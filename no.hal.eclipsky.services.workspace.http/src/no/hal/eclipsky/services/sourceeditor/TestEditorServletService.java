package no.hal.eclipsky.services.sourceeditor;

import java.io.PrintWriter;

import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import no.hal.eclipsky.services.sourceeditor.SourceEditorServlet.EditorServiceRequest;
import no.hal.eclipsky.services.workspace.IServiceExecutor;
import no.hal.eclipsky.services.workspace.http.AbstractServiceServlet;
import no.hal.eclipsky.services.workspace.http.util.ResponseFormatter;
import no.hal.eclipsky.services.workspace.http.util.ResponseOptions;
import no.hal.eclipsky.services.workspace.model.ExecutionResult;
import no.hal.eclipsky.services.workspace.model.ModelFactory;
import no.hal.eclipsky.services.workspace.model.TestCaseResult;
import no.hal.eclipsky.services.workspace.model.TestEditorService;
import no.hal.eclipsky.services.workspace.model.TestResult;

@Component(
	immediate = true,
	property = AbstractSourceEditorServletService.OPERATION_KEY + "=test"
)
public class TestEditorServletService extends AbstractSourceEditorServletService<TestEditorService> implements SourceEditorServletService {

	@Reference(target="(services=*TestEditorService*)")
	@Override
	public synchronized void setServiceExecutor(IServiceExecutor serviceExecutor) {
		super.setServiceExecutor(serviceExecutor);
	}
	public synchronized void unsetServiceExecutor(IServiceExecutor serviceExecutor) {
		super.setServiceExecutor(null);
	}

	@Reference
	public synchronized void setServiceFactory(ModelFactory serviceFactory) {
		super.setServiceFactory(serviceFactory);
	}
	public synchronized void unsetServiceFactory(ModelFactory serviceFactory) {
		super.setServiceFactory(null);
	}

	@Activate
	@Override
	protected void activate(ComponentContext context) {
		super.activate(context);
	}

	@Override
	protected TestEditorService createService(EditorServiceRequest request, String requestBody) {
		TestEditorService service = getServiceFactory().createTestEditorService();
		service.setResourceRef(request.resourceRef);
		return service;
	}

	@Override
	protected void servicePerformedWithSuccess(TestEditorService service, ResponseOptions responseOptions, PrintWriter writer) {
		ExecutionResult result = service.getResult();
		if (result instanceof TestResult) {
			TestResult testResult = (TestResult) result;
			ResponseFormatter formatter = AbstractServiceServlet.getResponseFormatter(responseOptions.responseFormat, writer);
			if (formatter != null) {
				formatter.startEntities("test", true);
			} else {
				writer.println("<html>\n"
						+ "\t<head><title>Test</title></head>\n"
						+ "\t<body>");
				writer.println("\t\t<h1>Test</h1>\n\t\t<ul>");
			}
			for (TestCaseResult testCaseResult : testResult.getResults()) {
				if (formatter != null) {
					formatter.entity("test", 
							"name", testCaseResult.getTestName(),
							"status", testCaseResult.getKind(),
							"exception", testCaseResult.getException()).endEntity();
				} else {
					writer.println("\t\t\t<li>" + testCaseResult.getTestName() + ":" + testCaseResult.getKind() + "=" + testCaseResult.getException() + "</li>");
				}
			}
			if (formatter != null) {
				formatter.endEntities();
			} else {
				writer.println("\t\t</ul>");
				writer.println("\t</body>\n"
						+ "</html>");
			}
		} else {
			RunEditorServletService.writeRunResultResponse(result, responseOptions, writer);
		}
	}
}
