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
import no.hal.eclipsky.services.workspace.model.RunEditorService;

@Component(
	immediate = true,
	property = AbstractSourceEditorServletService.OPERATION_KEY + "=run"
)
public class RunEditorServletService extends AbstractSourceEditorServletService<RunEditorService> implements SourceEditorServletService {

	@Reference(target="(services=*RunEditorService*)")
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
	protected RunEditorService createService(EditorServiceRequest request, String requestBody) {
		RunEditorService service = getServiceFactory().createRunEditorService();
		service.setResourceRef(request.resourceRef);
		return service;
	}

	@Override
	protected void servicePerformedWithSuccess(RunEditorService service, ResponseOptions responseOptions, PrintWriter writer) {
		writeRunResultResponse(service.getResult(), responseOptions, writer);
	}

	static void writeRunResultResponse(ExecutionResult result, ResponseOptions responseOptions, PrintWriter writer) {
			ResponseFormatter formatter = AbstractServiceServlet.getResponseFormatter(responseOptions.responseFormat, writer);
		if (formatter != null) {
			formatter.startEntities("run", false);
		} else {
			writer.println("<html>\n"
					+ "\t<head><title>Run</title></head>\n"
					+ "\t<body>");
			writer.println("\t\t<h1>Run</h1>\n\t\t<ul>");
		}

		if (formatter != null) {
			formatter.entity("run", 
					"console", result.getSysout().getStringContent(),
					"error", result.getSyserr().getStringContent(),
					"exLocation", result.getExceptionLocation()).endEntity();
		} else {
			// TODO: Write a proper result display
			writer.println("\t\t\t<li>" + result + "</li>");
		}
		
		if (formatter == null) {
			writer.println("\t\t</ul>");
			writer.println("\t</body>\n"
					+ "</html>");
		}
	}

}
