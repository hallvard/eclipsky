package no.hal.eclipsky.services.sourceeditor;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;

import no.hal.eclipsky.services.editor.SourceEditor;
import no.hal.eclipsky.services.sourceeditor.SourceEditorServlet.EditorServiceRequest;
import no.hal.eclipsky.services.workspace.http.AbstractServiceServlet;
import no.hal.eclipsky.services.workspace.http.util.ResponseFormatter;

public class RefreshEditorServletService extends AbstractSourceEditorServletService {

	@Override
	public CharSequence doSourceEditorServletService(EditorServiceRequest request, String requestBody) {
		SourceEditor sourceEditor = getSourceEditor(request);
		System.out.println(sourceEditor.getResourceRef().getResourceName());
		return refreshResponse(sourceEditor.getSourceFileContents(), request.responseFormat);
	}

	public static String refreshResponse(CharSequence fileContent, String protocol) {
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		PrintWriter output = new PrintWriter(buffer);
		writeRefreshResponse(protocol, output, fileContent);
		output.close();
		return buffer.toString();
	}

	private static void writeRefreshResponse(String responseFormat, PrintWriter writer, CharSequence fileContent) {
		ResponseFormatter formatter = AbstractServiceServlet.getResponseFormatter(responseFormat, writer);
		if (formatter != null) {
			formatter.startEntities("refresh", false);
		} else {
			writer.println("<html>\n"
				+ "\t<head><title>Refresh</title></head>\n"
				+ "\t<body>");
			writer.println("\t\t<h1>Refresh</h1>\n\t\t");
		}

		if (formatter != null) {
			formatter.entity("refresh", "code", fileContent).endEntity();
		} else {
			// TODO: Write a proper result display
			writer.println("\t\t\t<textarea>" + fileContent + "</textarea>");
		}

		if (formatter == null) {
			writer.println("\t</body>\n</html>");
		}
	}
}