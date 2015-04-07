package no.hal.eclipsky.services.sourceeditor;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;

import no.hal.eclipsky.services.common.SourceFileMarker;
import no.hal.eclipsky.services.sourceeditor.SourceEditorServlet.EditorServiceRequest;
import no.hal.eclipsky.services.workspace.http.AbstractServiceServlet;
import no.hal.eclipsky.services.workspace.http.util.ResponseFormatter;

public class MarkersEditorServletService extends AbstractSourceEditorServletService {

	@Override
	public String doSourceEditorServletService(EditorServiceRequest request, String requestBody, String protocol) {
		SourceFileMarker[] sourceFileMarkers = getSourceEditor(request).update(null, true, false);
		return markersResponse(sourceFileMarkers, protocol);
	}

	public static String markersResponse(SourceFileMarker[] sourceFileMarkers, String protocol) {
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		PrintWriter output = new PrintWriter(buffer);
		writeMarkersResponse(protocol, output, sourceFileMarkers);
		output.close();
		return buffer.toString();
	}

	private static void writeMarkersResponse(String responseFormat, PrintWriter writer, SourceFileMarker[] sourceFileMarkers) {
		ResponseFormatter formatter = AbstractServiceServlet.getResponseFormatter(responseFormat, writer);
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
