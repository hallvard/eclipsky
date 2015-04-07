package no.hal.eclipsky.services.sourceeditor;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;

import org.eclipse.core.runtime.IProgressMonitor;

import no.hal.eclipsky.services.editor.SourceEditor;
import no.hal.eclipsky.services.sourceeditor.SourceEditorServlet.EditorServiceRequest;
import no.hal.eclipsky.services.workspace.http.AbstractServiceServlet;
import no.hal.eclipsky.services.workspace.http.util.ResponseFormatter;

public class CloseEditorServletService extends AbstractSourceEditorServletService {

	@Override
	public String doSourceEditorServletService(EditorServiceRequest request, String requestBody) {
		SourceEditor editor = getSourceEditor(request);
		final String[] output = new String[1];
		editor.close(new IProgressMonitor() {
			@Override
			public void worked(int work) {
			}
			
			@Override
			public void subTask(String name) {
			}
			
			@Override
			public void setTaskName(String name) {
			}
			
			@Override
			public void setCanceled(boolean value) {
			}
			
			@Override
			public boolean isCanceled() {
				output[0] = "canceled";
				return false;
			}
			
			@Override
			public void internalWorked(double work) {
			}
			
			@Override
			public void done() {
				output[0] = "saved";
			}
			
			@Override
			public void beginTask(String name, int totalWork) {
			}
		});

		// Wait for the execution to finish
		long startTime = System.currentTimeMillis(), currentTime = startTime;
		while (output[0] == null && 
				currentTime - startTime < 1000) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
			currentTime = System.currentTimeMillis();
		}
		
		return closeEditorResponse(output[0], request.responseFormat);
	}
	
	public static String closeEditorResponse(String response, String protocol) {
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		PrintWriter output = new PrintWriter(buffer);
		writeCloseEditorResponse(protocol, output, response);
		output.close();
		return buffer.toString();
	}

	private static void writeCloseEditorResponse(String responseFormat, PrintWriter output, String response) {
		ResponseFormatter formatter = AbstractServiceServlet.getResponseFormatter(responseFormat, output);
		if (formatter != null) {
			formatter.startEntities("close", false);
		} else {
			output.println("<html>\n"
					+ "\t<head><title>Close</title></head>\n"
					+ "\t<body>");
			output.println("\t\t<h1>Close</h1>\n\t\t<ul>");
		}

		if (formatter != null) {
			formatter.entity("close", "status", response).endEntity();
		} else {
			// TODO: Write a proper result display
			output.println("\t\t\t<li>" + response + "</li>");
		}
		
		if (formatter == null) {
			output.println("\t\t</ul>");
			output.println("\t</body>\n"
					+ "</html>");
		}
	}
}