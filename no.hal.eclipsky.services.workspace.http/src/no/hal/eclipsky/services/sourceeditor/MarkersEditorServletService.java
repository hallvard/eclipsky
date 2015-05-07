package no.hal.eclipsky.services.sourceeditor;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;

import no.hal.eclipsky.services.common.SourceFileMarker;
import no.hal.eclipsky.services.sourceeditor.SourceEditorServlet.EditorServiceRequest;
import no.hal.eclipsky.services.workspace.http.AbstractServiceServlet;
import no.hal.eclipsky.services.workspace.http.SourceProjectManager;
import no.hal.eclipsky.services.workspace.http.util.ResponseFormatter;

import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true,
	property = AbstractSourceEditorServletService.OPERATION_KEY + "=markers"
)
public class MarkersEditorServletService extends AbstractSourceEditorServletService implements SourceEditorServletService {

	@Reference
	@Override
	public synchronized void setSourceProjectManager(SourceProjectManager sourceProjectManager) {
		super.setSourceProjectManager(sourceProjectManager);
	}

	@Activate
	@Override
	protected void activate(ComponentContext context) {
		super.activate(context);
	}
	
	@Override
	public String doSourceEditorServletService(EditorServiceRequest request, String requestBody) {
		SourceFileMarker[] sourceFileMarkers = getSourceEditor(request).update(null, true, null);
		CharacterPosition offset = computeResourceOffset(getSourceProjectManager().getEmfsResource(request.resourceRef));
		return markersResponse(sourceFileMarkers, request.responseFormat, offset);
	}

	public static String markersResponse(SourceFileMarker[] sourceFileMarkers, String protocol, CharacterPosition offset) {
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		PrintWriter output = new PrintWriter(buffer);
		writeMarkersResponse(protocol, output, sourceFileMarkers, offset);
		output.close();
		return buffer.toString();
	}

	private static void writeMarkersResponse(String responseFormat, PrintWriter writer, SourceFileMarker[] sourceFileMarkers, CharacterPosition offset) {
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
		System.out.println("Offset: " + offset);
		for (int i = 0; i < count; i++) {
			SourceFileMarker problem = sourceFileMarkers[i];
			if (formatter != null) {
				int lineNumber = problem.lineNumber, start = problem.start, end = problem.end;
				if (offset != null) {
					lineNumber -= offset.getLine();
					start -= offset.getPosition();
					end -= offset.getPosition();
				}
				formatter.entity("problem",
						"severity", problem.severity,
						"message", problem.message,
						"lineNumber", lineNumber,
						"start", start,
						"end", end)
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
