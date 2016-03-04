package no.hal.eclipsky.services.sourceeditor;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.util.concurrent.CompletableFuture;

import no.hal.eclipsky.services.editor.SourceEditor;
import no.hal.eclipsky.services.sourceeditor.SourceEditorServlet.EditorServiceRequest;
import no.hal.eclipsky.services.workspace.http.AbstractServiceServlet;
import no.hal.eclipsky.services.workspace.http.SourceProjectManager;
import no.hal.eclipsky.services.workspace.http.util.ResponseFormatter;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true,
		property = AbstractSourceEditorServletService.OPERATION_KEY + "=close"
	)
public class CloseEditorServletService extends AbstractSourceEditorServletService implements SourceEditorServletService {

	@Reference
	@Override
	public synchronized void setSourceProjectManager(SourceProjectManager sourceProjectManager) {
		super.setSourceProjectManager(sourceProjectManager);
	}
	public synchronized void unsetSourceProjectManager(SourceProjectManager sourceProjectManager) {
		super.setSourceProjectManager(null);
	}

	@Activate
	@Override
	protected void activate(ComponentContext context) {
		super.activate(context);
	}

	@Override
	public String doSourceEditorServletService(EditorServiceRequest request, String requestBody) {
		SourceEditor editor = getSourceEditor(request);
		CompletableFuture<Boolean> future = new CompletableFuture<Boolean>();
		editor.close(new NullProgressMonitor() {
			@Override
			public void done() {
				future.complete(! isCanceled());
			}
		});
		String result = "canceled";
		try {
			if (future.get()) {
				result = "saved";
			}
		} catch (Exception e) {
		}
		return closeEditorResponse(result, request.responseFormat);
	}

	public static String closeEditorResponse(String response, String protocol) {
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		PrintWriter output = new PrintWriter(buffer);
		writeCloseEditorResponse(protocol, output, response);
		output.close();
		System.out.println("Buffer : " + buffer.toString());
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