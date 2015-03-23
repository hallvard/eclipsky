package no.hal.eclipsky.services.sourceeditor;

import java.io.IOException;
import java.io.PrintWriter;
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
		System.out.println("Adding SourceEditorServletService: " + editorService);
		String[] operations = editorService.getSupportedOperations();
		for (String op : operations) {
			editorServices.put(op, editorService);
		}
	}

	public synchronized void removeServiceServlet(SourceEditorServletService editorService) {
		System.out.println("Removing SourceEditorServletService: " + editorService);
		String[] operations = editorService.getSupportedOperations();
		for (String op : operations) {
			editorServices.remove(op);
		}
	}

	protected void activate() {
		try {
			System.out.println("Registering servlet alias and resources for " + this);
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

//	private SourceProject getSourceProject(EditorServiceRequest request) {
//		return sourceProjectManager.getSourceProject(request.resourceRef);
//	}
//
//	private SourceEditor getSourceEditor(HttpServletRequest request) {
//		ResourceRef resourceRef = AbstractServiceServlet.getResourceRef(request);
//		SourceEditor editor = sourceProjectManager.getSourceProject(resourceRef).getSourceEditor(resourceRef);
//		return editor;
//	}
	
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
		ResourceRef[] editables = sourceProjectManager.getSourceProject(resourceRef).getEditables();
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
		System.out.println("Resource argument: " + resourceRef);
		EditorServiceRequest editorServiceRequest = new EditorServiceRequest(op, resourceRef, AbstractServiceServlet.getResponseFormat(request));
		try {
			CharSequence response = invokeEditorServiceOperation(editorServiceRequest, request.getParameter("body"));
			writer.print(response);
		} catch (Exception e) {
			AbstractServiceServlet.writeExceptionResponse("html", writer, e);
		}
	}

	private CharSequence invokeEditorServiceOperation(EditorServiceRequest request, String requestBody) {
		SourceEditorServletService editorService = editorServices.get(request.op);
		CharSequence response = null;
		if (editorService != null) {
			response = editorService.doSourceEditorServletService(request, requestBody);
		}
		if (response == null || response.length() == 0) {
			response = "{}";
		}
		return response;
	}

//	private PrintWriter debugWriter = null; // new PrintWriter(System.out);
	
//	protected void updateSourceFile(HttpServletRequest request, HttpServletResponse response, Boolean exists, Boolean markers) throws ServletException, IOException {
//		StringBuilder body = new StringBuilder(request.getContentLength());
//		BufferedReader reader = request.getReader();
//		String line = null;
//		while ((line = reader.readLine()) != null) {
//			body.append(line);
//			body.append("\n");
//		}
//		String stringContent = body.toString();
//		if (stringContent == null) {
//			super.doPost(request, response);
//		} else {
//			SourceEditor editor = getSourceEditor(request);
//			if (editor == null) {
//				super.doPost(request, response);
//			} else {
//				String responseFormat = AbstractWorkspaceServiceServlet.getResponseFormat(request);
//				response.setContentType("text/" + ("html".equals(responseFormat) ? "html" : "plain"));
//				SourceFileMarker[] sourceFileMarkers = editor.update(stringContent, markers, false);
//				if (debugWriter != null) {
//					writeMarkersResponse(responseFormat, debugWriter, sourceFileMarkers);
//					debugWriter.flush();
//				}
//				writeMarkersResponse(responseFormat, response.getWriter(), sourceFileMarkers);
//			}
//		}
//	}

	private final static String EMPTY_EDITOR_SERVLET_SERVICE_RESPONSE = "{}";

	
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
				System.out.println("WebSocket message: " + message);
				int pos = message.indexOf('\n');
				String op = message, contents = null;
				ResourceRef resourceRef = new ResourceRef(projectRef, null, null);
				if (pos >= 0) {
					op = op.substring(0, pos);
					contents = message.substring(pos + 1);
				}
				pos = op.indexOf(' ');
				if (pos >= 0) {
					resourceRef = AbstractServiceServlet.getResourceRef(projectRef, op.substring(pos + 1));
					op = op.substring(0, pos);
				}
				EditorServiceRequest editorServiceRequest = new EditorServiceRequest(op, resourceRef, "json");
				CharSequence response = invokeEditorServiceOperation(editorServiceRequest, contents);
				try {
					connection.sendMessage(response != null ? response.toString() : EMPTY_EDITOR_SERVLET_SERVICE_RESPONSE);
				} catch (IOException e) {
				}
			}
			
			@Override
			public void onOpen(Connection connection) {
				this.connection = connection;
				try {
					connection.sendMessage(EMPTY_EDITOR_SERVLET_SERVICE_RESPONSE);
				} catch (IOException e) {
					e.printStackTrace();
				}
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
