package no.hal.eclipsky.services.sourceeditor;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hal.eclipsky.services.common.ProjectRef;
import no.hal.eclipsky.services.common.ResourceRef;
import no.hal.eclipsky.services.workspace.http.AbstractServiceServlet;
import no.hal.eclipsky.services.workspace.http.AceEditorHelper;
import no.hal.eclipsky.services.workspace.http.SourceProjectManager;
import no.hal.eclipsky.services.workspace.http.util.EmfsUtil;
import no.hal.eclipsky.services.workspace.http.util.ResponseFormatter;
import no.hal.emfs.EmfsResource;

import org.eclipse.jetty.websocket.WebSocket;
import org.eclipse.jetty.websocket.WebSocketServlet;
import org.osgi.service.http.HttpService;

@SuppressWarnings("serial")
public class SourceEditorServlet extends WebSocketServlet {

	private HttpService httpService;
	
	public synchronized void setHttpService(HttpService httpService) {
		this.httpService = httpService;
	}

	private SourceProjectManager sourceProjectManager;
	
	public synchronized void setSourceProjectManager(SourceProjectManager sourceProjectManager) {
		this.sourceProjectManager = sourceProjectManager;
	}

	private Map<String, SourceEditorServletService> editorServices = new HashMap<String, SourceEditorServletService>();
	
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

	protected void activate() {
		try {
			httpService.registerServlet("/sourceEditor", (HttpServlet) this, null, null);
			httpService.registerResources("/ace", "/web/ace-builds/src-noconflict", null);
			httpService.registerResources("/js", "/web/js", null);
			httpService.registerResources("/sourceEditorForm.html", "/web/html/sourceEditorForm.html", null);
		} catch (Exception e) {
		}
	}

	protected void deactivate() {
		try {
			httpService.unregister("/sourceEditor");
			httpService.unregister("/ace");
			httpService.unregister("/js");
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
		Collection<ResourceRef> emfsResources = EmfsUtil.collectResources(sourceProjectManager.getEmfs(resourceRef), EmfsResource::isWriteable);
		ResourceRef[] editables = emfsResources.toArray(new ResourceRef[emfsResources.size()]);
		options.editorName = (editables != null && editables.length > 0 ? editables[0].getResourceName() : options.projectId);
		options.resourceRefs = editables;
		options.embed = embed;
		aceEditorHelper.writeEditorHtml(writer, options);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");
		String op = request.getParameter("op");
		if (op == null) {
			op = "refresh";
		}
		PrintWriter writer = response.getWriter();
		doEditorServiceOperation(op, request, writer);
	}

	protected void doEditorServiceOperation(String op, HttpServletRequest request, PrintWriter writer) {
		ResourceRef resourceRef = AbstractServiceServlet.getResourceRef(request);
		EditorServiceRequest editorServiceRequest = new EditorServiceRequest(op, resourceRef, AbstractServiceServlet.getResponseFormat(request));
		try {
			CharSequence response = invokeEditorServiceOperation(editorServiceRequest, request.getParameter("body"));
			writer.print(response);
		} catch (Exception e) {
			AbstractServiceServlet.writeExceptionResponse("html", writer, e);
		}
	}
	
	private final static String EMPTY_EDITOR_SERVLET_SERVICE_RESPONSE = "[]";

	private CharSequence invokeEditorServiceOperation(EditorServiceRequest request, String requestBody) {
		SourceEditorServletService editorService = editorServices.get(request.op);
		CharSequence response = null;
		if (editorService != null) {
			response = editorService.doSourceEditorServletService(request, requestBody);
		} else {
			System.err.println("Editor for op '" + request.op + "' doesn't exist");
		}
		if (response == null || response.length() == 0) {
			response = EMPTY_EDITOR_SERVLET_SERVICE_RESPONSE;
		}
		return response;
	}
	
	@Override
	public WebSocket doWebSocketConnect(HttpServletRequest request, final String protocol) {

		final ProjectRef projectRef = AbstractServiceServlet.getProjectRef(request);

		return new WebSocket.OnTextMessage() {

			private Connection connection;

			@Override
			public void onClose(int closeCode, String message) {
				// TODO: Notify GIT exporter
//				project.editor.close(null);
			}

			@Override
			public void onMessage(String message) {
				System.out.println("Message to SourceEditorService: " + message);
				int pos = message.indexOf('\n');
				String op = message, contents = null;
				ResourceRef resourceRef = new ResourceRef(projectRef, null, null);
				if (pos >= 0) {
					op = op.substring(0, pos);
					contents = message.substring(pos + 1);
				}
				pos = op.indexOf(' ');
				if (pos >= 0) {
					resourceRef = AbstractServiceServlet.getResourceRef(op.substring(pos + 1), projectRef);
					op = op.substring(0, pos);
				}
				EditorServiceRequest editorServiceRequest = new EditorServiceRequest(op, resourceRef, "json");
				CharSequence response = invokeEditorServiceOperation(editorServiceRequest, contents);
				System.out.println("Response from SourceEditorService: " + response);
				try {
					connection.sendMessage(response != null ? response.toString() : EMPTY_EDITOR_SERVLET_SERVICE_RESPONSE);
				} catch (IOException e) {
				}
			}
			
			@Override
			public void onOpen(Connection connection) {
				this.connection = connection;
				try {
					connection.sendMessage(getReadyResponse(protocol));
					} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					connection.sendMessage(EMPTY_EDITOR_SERVLET_SERVICE_RESPONSE);
				} catch (IOException e) {
					e.printStackTrace();
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
	}
	
	public class EditorServiceRequest {
		public String op;
		public ResourceRef resourceRef;
		public String responseFormat;

		public EditorServiceRequest(String op, ResourceRef resourceRef, String responseFormat) {
			this.op = op;
			this.resourceRef = resourceRef;
			this.responseFormat = responseFormat;
		}
	}
}