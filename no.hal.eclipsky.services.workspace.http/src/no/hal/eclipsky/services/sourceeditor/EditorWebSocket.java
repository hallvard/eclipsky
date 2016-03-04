package no.hal.eclipsky.services.sourceeditor;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

import no.hal.eclipsky.services.common.ProjectRef;
import no.hal.eclipsky.services.common.ResourceRef;
import no.hal.eclipsky.services.sourceeditor.SourceEditorServlet.EditorServiceRequest;
import no.hal.eclipsky.services.workspace.http.AbstractServiceServlet;
import no.hal.eclipsky.services.workspace.http.util.ResponseFormatter;


@WebSocket(maxTextMessageSize = 64 * 1024)
public class EditorWebSocket {
	private Session session;
	private String protocol;
	private ProjectRef projectRef;
	private SourceEditorServletImpl service;
	private final static String EMPTY_EDITOR_SERVLET_SERVICE_RESPONSE = "[]";

	public EditorWebSocket(final ProjectRef projectRef, final String protocol, SourceEditorServletImpl service) {
		this.projectRef = projectRef;
		this.protocol = protocol;
		this.service = service;
	}
	@OnWebSocketClose
	public void onClose(int closeCode, String message) {
		// TODO: Notify GIT exporter
//		project.editor.close(null);
	}

	@OnWebSocketMessage
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
		CharSequence response = service.invokeEditorServiceOperation(editorServiceRequest, contents);
		String responseString = response != null ? response.toString() : EMPTY_EDITOR_SERVLET_SERVICE_RESPONSE;

		try { 
			session.getRemote().sendString(responseString); 
		} catch (IOException e) {}
						
	}
	@OnWebSocketConnect
	public void onOpen(Session session) {
		this.session = session;
		try {
			session.getRemote().sendString((getReadyResponse(protocol)));
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
	

