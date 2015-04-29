package no.hal.eclipsky.services.sourceeditor;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hal.eclipsky.services.common.ProjectRef;
import no.hal.eclipsky.services.common.ResourceRef;
import no.hal.eclipsky.services.monitoring.CompositeServiceLogger;
import no.hal.eclipsky.services.monitoring.ServiceLogger;
import no.hal.eclipsky.services.workspace.http.AbstractServiceServlet;
import no.hal.eclipsky.services.workspace.http.AceEditorHelper;
import no.hal.eclipsky.services.workspace.http.SourceProjectManager;
import no.hal.eclipsky.services.workspace.http.util.EmfsUtil;
import no.hal.eclipsky.services.workspace.http.util.ResponseFormatter;
import no.hal.emfs.EmfsResource;

import org.eclipse.jetty.websocket.WebSocket;
import org.eclipse.jetty.websocket.WebSocket.Connection;
import org.eclipse.jetty.websocket.WebSocketServlet;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.http.HttpService;

@Component(
	immediate = true,
	property = AbstractServiceServlet.SERVLET_ALIAS_KEY + "=sourceEditor"
)
@SuppressWarnings("serial")
public class SourceEditorServletImpl extends WebSocketServlet implements SourceEditorServlet {

	private HttpService httpService;
	
	@Reference
	public synchronized void setHttpService(HttpService httpService) {
		this.httpService = httpService;
	}

	private SourceProjectManager sourceProjectManager;
	
	@Reference
	public synchronized void setSourceProjectManager(SourceProjectManager sourceProjectManager) {
		this.sourceProjectManager = sourceProjectManager;
	}

	private Map<String, SourceEditorServletService> editorServices = new HashMap<>();
	private Map<ProjectRef, List<Connection>> projectConnections = new HashMap<>();
	
	@Reference(
		cardinality = ReferenceCardinality.MULTIPLE,
		policy = ReferencePolicy.DYNAMIC,
		unbind = "removeServiceServlet"
	)
	public synchronized void addSourceEditorServletService(SourceEditorServletService editorService) {
		String[] operations = editorService.getSupportedOperations();
		for (String op : operations) {
			editorServices.put(op, editorService);
		}
	}

	public synchronized void removeServiceServlet(SourceEditorServletService editorService) {
		String[] operations = editorService.getSupportedOperations();
		for (String op : operations) {
			editorServices.remove(op);
		}
	}



	private final CompositeServiceLogger compositeServiceLogger = new CompositeServiceLogger();
	
	@Reference(
		cardinality = ReferenceCardinality.MULTIPLE,
		unbind="removeServiceLogger"
	)
	public synchronized void addServiceLogger(ServiceLogger serviceLogger) {
		compositeServiceLogger.addServiceLogger(serviceLogger);
	}
	
	public synchronized void removeServiceLogger(ServiceLogger serviceLogger) {
		compositeServiceLogger.removeServiceLogger(serviceLogger);
	}

	@Activate
	protected void activate() {
		try {
			httpService.registerServlet("/sourceEditor", (HttpServlet) this, null, null);
			httpService.registerResources("/ace", "/web/ace-builds/src-noconflict", null);
			httpService.registerResources("/js", "/web/js", null);
			httpService.registerResources("/css", "/web/css", null);
			httpService.registerResources("/img", "/web/img", null);
			httpService.registerResources("/sourceEditorForm.html", "/web/html/sourceEditorForm.html", null);
		} catch (Exception e) {
		}
	}

	@Deactivate
	protected void deactivate() {
		try {
			httpService.unregister("/sourceEditor");
			httpService.unregister("/ace");
			httpService.unregister("/js");
			httpService.unregister("/img");
			httpService.unregister("/sourceEditorForm.html");
		} catch (Exception e) {
		}
	}
	
	private AceEditorHelper aceEditorHelper = new AceEditorHelper();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ResourceRef resourceRef = AbstractServiceServlet.getResourceRef(request);
		boolean embed = Boolean.valueOf(request.getParameter("embed"));
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		AceEditorHelper.Options options = new AceEditorHelper.Options();
		options.requestUrl = request.getRequestURI();
		options.projectId = resourceRef.getProjectName();
		Collection<ResourceRef> emfsResources = EmfsUtil.collectResources(sourceProjectManager.getEmfsResource(new ProjectRef(resourceRef)), EmfsResource::isWriteable);
		ResourceRef[] editables = emfsResources.toArray(new ResourceRef[emfsResources.size()]);
		options.editorName = (editables != null && editables.length > 0 ? editables[0].getResourceName() : options.projectId);
		options.resourceRefs = editables;
		options.embed = embed;
		
		String index = request.getParameter("startIndex");
		if (index == null) {
			options.startIndex = 0;
		} else {
			options.startIndex = Integer.parseInt(index);
		}
		aceEditorHelper.writeEditorHtml(writer, options);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String  op = request.getParameter("op"), 
				packageName = null,
				resourceName = null;
		int pos = op.indexOf(' ');
		if (pos >= 0) {
			packageName = op.substring(pos + 1);
			op = op.substring(0, pos);
			
			pos = packageName.indexOf('/');
			resourceName = packageName.substring(pos + 1);
			packageName = packageName.substring(0, pos);
		}
		PrintWriter writer = response.getWriter();
		doEditorServiceOperation(op, packageName, resourceName, request, writer);
	}

	protected void doEditorServiceOperation(String op, String packageName, String resourceName, HttpServletRequest request, PrintWriter writer) {
		ResourceRef resourceRef;
		if (packageName == null && resourceName == null) {
			resourceRef = AbstractServiceServlet.getResourceRef(request);
		} else {
			resourceRef = AbstractServiceServlet.getResourceRef(request, packageName, resourceName);
		}
		EditorServiceRequest editorServiceRequest = new EditorServiceRequest(op, resourceRef, AbstractServiceServlet.getResponseFormat(request));
		try {
			CharSequence response = invokeEditorServiceOperation(editorServiceRequest, request.getParameter("body"));
			writer.print(response);
		} catch (Exception e) {
			AbstractServiceServlet.writeExceptionResponse("html", writer, e);
		}
	}
	
	private final static String EMPTY_EDITOR_SERVLET_SERVICE_RESPONSE = "[]";

	public CharSequence invokeEditorServiceOperation(EditorServiceRequest request, String requestBody) {
		SourceEditorServletService editorService = editorServices.get(request.op);
		CharSequence response = null;
		if (editorService != null) {
			compositeServiceLogger.serviceRequested(request, request.op, -1);
			try {
				response = editorService.doSourceEditorServletService(request, requestBody);
				compositeServiceLogger.serviceResponded(request, request.resourceRef.toPath(), -1);
			} catch (Exception e) {
				compositeServiceLogger.serviceException(request, e, -1);
				throw e;
			}
		}
		if (response == null || response.length() == 0) {
			response = EMPTY_EDITOR_SERVLET_SERVICE_RESPONSE;
		}
		return response;
	}
	
	@Override
	public WebSocket doWebSocketConnect(HttpServletRequest request, final String protocol) {
		final ProjectRef projectRef = AbstractServiceServlet.getProjectRef(request);
		
		WebSocket ws = new WebSocket.OnTextMessage() {

			private Connection connection;

			@Override
			public void onClose(int closeCode, String message) {
				removeFromList();
				// TODO: Notify GIT exporter
//				project.editor.close(null);
			}

			@Override
			public void onMessage(String message) {
				int pos = message.indexOf('\n');
				String op = message, contents = null;
				ResourceRef resourceRef = new ResourceRef(projectRef, null, null);
				if (pos >= 0) {
					op = op.substring(0, pos);
					contents = message.substring(pos + 1);
				}
				pos = op.indexOf(' ');
				if (pos >= 0) {
					resourceRef = ResourceRef.valueOf(op.substring(pos + 1), projectRef);
					op = op.substring(0, pos);
				}
				
				EditorServiceRequest editorServiceRequest = new EditorServiceRequest(op, resourceRef, "json");
				CharSequence response = invokeEditorServiceOperation(editorServiceRequest, contents);
				String responseString = response != null ? response.toString() : EMPTY_EDITOR_SERVLET_SERVICE_RESPONSE;
				
				// Notify all connections on an update 
				if ("update".equals(editorServiceRequest.op)) {
					editorServiceRequest.op = "refresh";
					CharSequence refreshResponse = invokeEditorServiceOperation(editorServiceRequest, contents);
					notifyAllConnections(refreshResponse.toString());
				}
				try { 
					connection.sendMessage(responseString); 
				} catch (IOException e) {}
								
			}
			
			@Override
			public void onOpen(Connection connection) {
				this.connection = connection;
				try {
					connection.sendMessage(getReadyResponse(protocol));
					} catch (IOException e) {
					e.printStackTrace();
				}
				
				addToList();
				
				/*
				try {
					connection.sendMessage(EMPTY_EDITOR_SERVLET_SERVICE_RESPONSE);
				} catch (IOException e) {
					e.printStackTrace();
				}*/
			}
			
			private void addToList() {
				List<Connection> connections;
				if (projectConnections.containsKey(projectRef)) {
					connections = projectConnections.get(projectRef);
					connections.add(connection);
				} else {
					connections = new ArrayList<>();
					connections.add(connection);
					projectConnections.put(projectRef, connections);
				}
			}
			
			private void removeFromList() {
				List<Connection> connections;
				if (projectConnections.containsKey(projectRef)) {
					connections = projectConnections.get(projectRef);
					connections.remove(connection);
				}
			}
			
			private void notifyAllConnections(String response) {
				if (projectConnections.containsKey(projectRef)) {
					List<Connection> connections = projectConnections.get(projectRef);
					connections.parallelStream()
								.filter(con -> con != connection)
								.forEach(con -> {
						try { 
							con.sendMessage(response); 
						} catch (IOException e) {}
					});
				}
			}
			
			private String getReadyResponse(String protocol) {
				ByteArrayOutputStream buffer = new ByteArrayOutputStream();
				PrintWriter writer = new PrintWriter(buffer);
				ResponseFormatter formatter = AbstractServiceServlet.getResponseFormatter(protocol, writer);
				if (formatter != null) {
					formatter.startEntities("ready", false);
				} else {
					writer.println("<html>\n"
							+ "\t<head><title>Refresh</title></head>\n"
							+ "\t<body>");
					writer.println("\t\t<h1>Refresh</h1>\n\t\t");
				}
				if (formatter != null) {
					formatter.entity("ready").endEntity();
				} else {
					// TODO: Write a proper result display
					writer.println("\t\t\t<p>Ready</p>");
				}
				if (formatter == null) {
					writer.println("\t</body>\n</html>");
				}
				writer.close();
				return buffer.toString();
			}
		};
		
		return ws;
	}
}
