package no.hal.eclipsky.services.sourceeditor;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketError;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketFrame;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;
import org.eclipse.jetty.websocket.api.extensions.Frame;

import no.hal.eclipsky.services.common.ProjectRef;
import no.hal.eclipsky.services.common.ResourceRef;
import no.hal.eclipsky.services.sourceeditor.SourceEditorServlet.EditorServiceRequest;
import no.hal.eclipsky.services.workspace.http.AbstractServiceServlet;
import no.hal.eclipsky.services.workspace.http.util.ResponseFormatter;

@WebSocket // (maxTextMessageSize = 64 * 1024)
public class EditorWebSocket {

	private ProjectRef projectRef;
	private String responseFormat;
	private SourceEditorServlet sourceEditorServlet;

	public EditorWebSocket(final ProjectRef projectRef, final String responseFormat, SourceEditorServlet sourceEditorServlet) {
		this.projectRef = projectRef;
		this.responseFormat = responseFormat;
		this.sourceEditorServlet = sourceEditorServlet;
	}

	@OnWebSocketConnect
	public void onConnect(Session session) {
		try {
			String readyResponse = getReadyResponse(responseFormat);
			System.out.println("EditorWebSocket.onConnect: " + readyResponse);
			session.getRemote().sendString(readyResponse);
		} catch (IOException e) {
			System.err.println("EditorWebSocket.onConnect: " + e);
		}
	}

	@OnWebSocketFrame
	public void onFrameEvent(Session session, Frame frame) {
		System.out.println("EditorWebSocket.onFrameEvent: " + frame);
	}

	@OnWebSocketError
	public void onException(Session session, Throwable exception) {
		System.out.println("EditorWebSocket.onException: " + exception);
	}

	@OnWebSocketMessage
	public void onMessage(Session session, String message) {
		System.out.println("EditorWebSocket.onMessage: " + message);
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
		System.out.println("EditorWebSocket.onMessage: " + resourceRef + "#" + op);
		
		EditorServiceRequest editorServiceRequest = new EditorServiceRequest(op, resourceRef, "json");
		CharSequence response = sourceEditorServlet.invokeEditorServiceOperation(editorServiceRequest, contents);
		String responseString = response != null ? response.toString() : SourceEditorServletImpl.EMPTY_EDITOR_SERVLET_SERVICE_RESPONSE;

		try { 
			session.getRemote().sendString(responseString); 
		} catch (IOException e) {
			System.err.println("EditorWebSocket.onMessage: " + e);
		}
	}
	
	@OnWebSocketClose
	public void onClose(int closeCode, String message) {
		System.out.println("EditorWebSocket.onClose: ");
		// TODO: Notify GIT exporter
//		project.editor.close(null);
	}
	
	private String getReadyResponse(String responseFormat) {
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		PrintWriter writer = new PrintWriter(buffer);
		ResponseFormatter formatter = AbstractServiceServlet.getResponseFormatter(responseFormat, writer);
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
}
