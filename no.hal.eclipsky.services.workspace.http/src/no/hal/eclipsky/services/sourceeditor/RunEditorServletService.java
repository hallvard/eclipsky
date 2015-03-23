package no.hal.eclipsky.services.sourceeditor;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;

import no.hal.eclipsky.services.editor.RunResult;
import no.hal.eclipsky.services.sourceeditor.SourceEditorServlet.EditorServiceRequest;
import no.hal.eclipsky.services.workspace.http.AbstractServiceServlet;
import no.hal.eclipsky.services.workspace.http.util.ResponseFormatter;

public class RunEditorServletService extends AbstractSourceEditorServletService {

	@Override
	public String doSourceEditorServletService(EditorServiceRequest request, String requestBody) {
		RunResult result = getSourceProject(request).run(true);
		return runResponse(result, request.responseFormat);
	}
	
	private String runResponse(RunResult result, String protocol) {
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		PrintWriter output = new PrintWriter(buffer);
		writeRunResponse(protocol, output, result);
		output.close();
		return buffer.toString();
	}

	private static void writeRunResponse(String responseFormat, PrintWriter output, RunResult result) {
		ResponseFormatter formatter = AbstractServiceServlet.getResponseFormatter(responseFormat, output);
		if (formatter != null) {
			formatter.startEntities("run", false);
		} else {
			output.println("<html>\n"
					+ "\t<head><title>Run</title></head>\n"
					+ "\t<body>");
			output.println("\t\t<h1>Run</h1>\n\t\t<ul>");
		}

		if (formatter != null) {
			formatter.entity("run", 
					"console", result.getConsoleOutput(),
					"error", result.getErrorOutput(),
					"exLocation", result.getExceptionLocation()).endEntity();
		} else {
			// TODO: Write a proper result display
			output.println("\t\t\t<li>" + result + "</li>");
		}
		
		if (formatter == null) {
			output.println("\t\t</ul>");
			output.println("\t</body>\n"
					+ "</html>");
		}
	}

}
