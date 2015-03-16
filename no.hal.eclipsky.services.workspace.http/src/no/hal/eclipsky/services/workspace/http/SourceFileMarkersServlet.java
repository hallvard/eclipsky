package no.hal.eclipsky.services.workspace.http;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hal.eclipsky.services.common.ResourceRef;
import no.hal.eclipsky.services.common.SourceFileMarker;

@SuppressWarnings("serial")
public class SourceFileMarkersServlet extends AbstractProjectServiceServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ResourceRef resourceRef = getResourceRef(request);
		SourceFileMarker[] sourceFileMarkers = getProjectService().getSourceFileMarkers(resourceRef, false);
		if (sourceFileMarkers == null) {
			super.doPost(request, response);
		} else {
			String responseFormat = getResponseFormat(request);
			response.setContentType("text/" + ("html".equals(responseFormat) ? "html" : "plain"));
			writeMarkersResponse(responseFormat, response.getWriter(), sourceFileMarkers);
		}
	}

	public static void writeMarkersResponse(String responseFormat, PrintWriter writer, SourceFileMarker[] sourceFileMarkers) {
		ResponseFormatter formatter = getResponseFormatter(responseFormat, writer);
		if (formatter != null) {
			formatter.startEntities("problems", true);
		} else {
			writer.println("<html>\n"
					+ "\t<head><title>Problems</title></head>\n"
					+ "\t<body>");
			writer.println("\t\t<h1>Problems</h1>\n\t\t<ul>");
		}
		int count = (sourceFileMarkers != null ? sourceFileMarkers.length : 0);
		for (int i = 0; i < count; i++) {
			SourceFileMarker problem = sourceFileMarkers[i];
			if (formatter != null) {
				formatter.entity("problem",
						"severity", problem.severity,
						"message", problem.message,
						"lineNumber", problem.lineNumber,
						"start", problem.start,
						"end", problem.end)
				.endEntity();
			} else {
				writer.println("\t\t\t<li>" + problem.message + "</li>");
			}
		}
		if (formatter != null) {
			formatter.endEntities();
		} else {
			writer.println("\t\t</ul>");
			writer.println("\t</body>\n"
					+ "</html>");
		}
	}
}
