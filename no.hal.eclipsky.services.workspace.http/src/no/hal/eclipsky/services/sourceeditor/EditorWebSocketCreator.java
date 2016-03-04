package no.hal.eclipsky.services.sourceeditor;

import org.eclipse.jetty.websocket.servlet.ServletUpgradeRequest;
import org.eclipse.jetty.websocket.servlet.ServletUpgradeResponse;
import org.eclipse.jetty.websocket.servlet.WebSocketCreator;

import no.hal.eclipsky.services.common.ProjectRef;
import no.hal.eclipsky.services.workspace.http.AbstractServiceServlet;

public class EditorWebSocketCreator implements WebSocketCreator {
	public SourceEditorServletImpl service;
	public EditorWebSocketCreator(SourceEditorServletImpl service){
		this.service = service;
	}
	@Override
	public Object createWebSocket(ServletUpgradeRequest request, ServletUpgradeResponse response) {
		final ProjectRef projectRef = AbstractServiceServlet.getProjectRef(request.getHttpServletRequest());
		
		EditorWebSocket ws = new EditorWebSocket(projectRef, "text", service);

		return ws;
	}

}
