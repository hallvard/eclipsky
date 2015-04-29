package no.hal.eclipsky.services.sourceeditor;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;

import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import no.hal.eclipsky.services.common.ProjectRef;
import no.hal.eclipsky.services.common.ResourceRef;
import no.hal.eclipsky.services.editor.RunResult;
import no.hal.eclipsky.services.editor.SourceEditor;
import no.hal.eclipsky.services.sourceeditor.SourceEditorServlet.EditorServiceRequest;
import no.hal.eclipsky.services.workspace.http.AbstractServiceServlet;
import no.hal.eclipsky.services.workspace.http.SourceProjectManager;
import no.hal.eclipsky.services.workspace.http.util.EmfsUtil;
import no.hal.eclipsky.services.workspace.http.util.ResponseFormatter;
import no.hal.emfs.EmfsResource;

@Component(
	immediate = true,
	property = AbstractSourceEditorServletService.OPERATION_KEY + "=run"
)
public class RunEditorServletService extends AbstractSourceEditorServletService implements SourceEditorServletService {

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
		EmfsResource emfsResource = EmfsUtil.findEmfsResource(getSourceProjectManager().getEmfsResource(new ProjectRef(request.resourceRef)), EmfsUtil::isRunnable);
		if (emfsResource != null) {	
			SourceEditor editor = getSourceEditor(request);
			CloseEditorServletService.closeEditorResponse(editor);			
			ResourceRef resourceRef = request.resourceRef;
			ResourceRef combinedRef = new ResourceRef(
					EmfsUtil.createResourceRef(emfsResource),
					resourceRef.getPackageName(),
					resourceRef.getResourceName()
			);
			RunResult result = getSourceProject(request).run(combinedRef);
			return runResponse(result, request.responseFormat);
		}
		return null;
	}
	
	protected String runResponse(RunResult result, String protocol) {
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
