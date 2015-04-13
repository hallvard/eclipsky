package no.hal.eclipsky.services.sourceeditor;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;

import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import no.hal.eclipsky.services.common.Proposal;
import no.hal.eclipsky.services.sourceeditor.SourceEditorServlet.EditorServiceRequest;
import no.hal.eclipsky.services.workspace.http.AbstractServiceServlet;
import no.hal.eclipsky.services.workspace.http.SourceProjectManager;
import no.hal.eclipsky.services.workspace.http.util.ResponseFormatter;

@Component(
	immediate = true,
	property = AbstractSourceEditorServletService.OPERATION_KEY + "=completion"
)
public class CompletionEditorServletService extends AbstractSourceEditorServletService implements SourceEditorServletService {

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
		int position = Integer.parseInt(requestBody);
		Proposal[] completions = getSourceEditor(request).complete(position);
		if (completions.length == 0) {
			return null;
		}
		return completionsResponse(completions, request.responseFormat);
	}
	
	private String completionsResponse(Proposal [] completions, String protocol) {
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		PrintWriter output = new PrintWriter(buffer);
		writeCompletionsResponse(protocol, output, completions);
		output.close();
		return buffer.toString();
	}

	private static void writeCompletionsResponse(String protocol, PrintWriter output, Proposal[] completions) {
		ResponseFormatter formatter = AbstractServiceServlet.getResponseFormatter(protocol, output);
		if (formatter != null) {
			formatter.startEntities("completions", true);
		} else {
			output.println("<html>\n"
					+ "\t<head><title>Completions</title></head>\n"
					+ "\t<body>");
			output.println("\t\t<h1>Completions</h1>\n\t\t<ul>");
		}
		int count = (completions != null ? completions.length : 0);
		for (int i = 0; i < count; i++) {
			Proposal completion = completions[i];
			if (formatter != null) {
				formatter.entity("completion", 
						"name", completion.getName(),
						"value", completion.getValue(),
						"score", completion.getScore()).endEntity();
			} else {
				output.println("\t\t\t<li>" + completion + "</li>");
			}
		}
		if (formatter != null) {
			formatter.endEntities();
		} else {
			output.println("\t\t</ul>");
			output.println("\t</body>\n"
					+ "</html>");
		}
	}
}
