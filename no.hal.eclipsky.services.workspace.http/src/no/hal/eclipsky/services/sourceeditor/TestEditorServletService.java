package no.hal.eclipsky.services.sourceeditor;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;

import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import no.hal.eclipsky.services.common.ProjectRef;
import no.hal.eclipsky.services.common.Proposal;
import no.hal.eclipsky.services.common.ResourceRef;
import no.hal.eclipsky.services.common.Test;
import no.hal.eclipsky.services.editor.RunResult;
import no.hal.eclipsky.services.editor.SourceEditor;
import no.hal.eclipsky.services.editor.TestResult;
import no.hal.eclipsky.services.sourceeditor.SourceEditorServlet.EditorServiceRequest;
import no.hal.eclipsky.services.workspace.http.AbstractServiceServlet;
import no.hal.eclipsky.services.workspace.http.SourceProjectManager;
import no.hal.eclipsky.services.workspace.http.util.EmfsUtil;
import no.hal.eclipsky.services.workspace.http.util.ResponseFormatter;
import no.hal.emfs.EmfsResource;

@Component(
	immediate = true,
	property = AbstractSourceEditorServletService.OPERATION_KEY + "=test"
)
public class TestEditorServletService extends RunEditorServletService implements SourceEditorServletService {

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
		EmfsResource emfsResource = EmfsUtil.findEmfsResource(getSourceProjectManager().getEmfsResource(new ProjectRef(request.resourceRef)), EmfsUtil::isTestable);
		if (emfsResource != null) {	
			SourceEditor editor = getSourceEditor(request);
			CloseEditorServletService.closeEditorResponse(editor);			
			ResourceRef resourceRef = request.resourceRef;
			ResourceRef combinedRef = new ResourceRef(
					request.resourceRef.getProjectName(),
					resourceRef.getPackageName(),
					resourceRef.getResourceName()
			);
			RunResult result = getSourceProject(request).test(combinedRef);
			// Return a test result of the project was compiled, otherwise return a run response with the error message
			if (result instanceof TestResult) {
				TestResult testResult = (TestResult)result;
				return testResponse(testResult, request.responseFormat);
			} else {
				return RunEditorServletService.runResponse(result, request.responseFormat);
			}
		}
		return null;
	}
	
	protected String testResponse(TestResult result, String protocol) {
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		PrintWriter output = new PrintWriter(buffer);
		writeTestResponse(protocol, output, result);
		output.close();
		return buffer.toString();
	}

	private static void writeTestResponse(String responseFormat, PrintWriter output, TestResult result) {
		ResponseFormatter formatter = AbstractServiceServlet.getResponseFormatter(responseFormat, output);
		if (formatter != null) {
			formatter.startEntities("test", true);
		} else {
			output.println("<html>\n"
					+ "\t<head><title>Test</title></head>\n"
					+ "\t<body>");
			output.println("\t\t<h1>Test</h1>\n\t\t<ul>");
		}
		
		
		for (Test t : result.getAllTests()) {
			if (formatter != null) {
				formatter.entity("test", 
						"name", t.getTestName(),
						"status", t.getStatus(),
						"exception", t.getException()).endEntity();
			} else {
				output.println("\t\t\t<li>" + t.getTestName() + ":" + t.getStatus() + "=" + t.getException() + "</li>");
			}
		}
		
		/*
		if (formatter != null) {
			formatter.entity("test", 
					"console", result.getConsoleOutput(),
					"error", result.getErrorOutput(),
					"exLocation", result.getExceptionLocation()).endEntity();
		} else {
			// TODO: Write a proper result display
			output.println("\t\t\t<li>" + result + "</li>");
		}
		*/
		if (formatter != null) {
			formatter.endEntities();
		} else {
			output.println("\t\t</ul>");
			output.println("\t</body>\n"
					+ "</html>");
		}
	}
}
