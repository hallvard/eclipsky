package no.hal.eclipsky.services.workspace.http;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hal.eclipsky.services.common.ResourceRef;
import no.hal.eclipsky.services.common.SourceFileMarker;

@SuppressWarnings("serial")
public class SourceFileEditorServlet extends SourceFileMarkersServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ResourceRef resourceRef = getResourceRef(request);
		String stringContent = getProjectService().getSourceFile(resourceRef);
		if (stringContent == null) {
			super.doGet(request, response);
		} else {
			response.setContentType("text/html");
			PrintWriter writer = response.getWriter();
			aceEditorHelper.writeEditorHtml(writer, resourceRef.getResourceName(), stringContent, aceEditorHelper.getEditorMode(resourceRef.getResourceName()), false);
		}
	}

	private AceEditorHelper aceEditorHelper = new AceEditorHelper();

	private PrintWriter debugWriter = null; // new PrintWriter(System.out);
	
	protected void updateSourceFile(HttpServletRequest request, HttpServletResponse response, Boolean exists, Boolean markers) throws ServletException, IOException {
		ResourceRef resourceRef = getResourceRef(request);
		String bodyContent = getRequestBodyContent(request);
		if (bodyContent == null) {
			super.doPost(request, response);
		} else {
			String responseFormat = getResponseFormat(request);
			response.setContentType("text/" + ("html".equals(responseFormat) ? "html" : "plain"));
			SourceFileMarker[] sourceFileMarkers = getProjectService().updateSourceFile(resourceRef, bodyContent, exists, markers);
			if (debugWriter != null) {
				writeMarkersResponse(responseFormat, debugWriter, sourceFileMarkers);
				debugWriter.flush();
			}
			writeMarkersResponse(responseFormat, response.getWriter(), sourceFileMarkers);
		}
	}

	protected Boolean markersDefault = true;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		updateSourceFile(request, response, true, markersDefault);
	}
	
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		updateSourceFile(request, response, false, markersDefault);
	}
}
