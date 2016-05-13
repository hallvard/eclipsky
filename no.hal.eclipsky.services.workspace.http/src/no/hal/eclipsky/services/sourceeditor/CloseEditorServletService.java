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
import no.hal.eclipsky.services.workspace.model.CloseEditorService;
import no.hal.eclipsky.services.workspace.model.ModelFactory;
import no.hal.eclipsky.services.workspace.model.ResultKind;

@Component(
		immediate = true,
		property = AbstractSourceEditorServletService.OPERATION_KEY + "=close"
	)
public class CloseEditorServletService extends AbstractSourceEditorServletService<CloseEditorService> implements SourceEditorServletService {

	@Reference(target="(services=*CloseEditorService*)")
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
	protected CloseEditorService createService(EditorServiceRequest request, String requestBody) {
		CloseEditorService service = getServiceFactory().createCloseEditorService();
		service.setResourceRef(request.resourceRef);
		return service;
	}
	
	@Override
	protected void servicePerformed(CloseEditorService service, ResultKind result, ResponseOptions responseOptions, PrintWriter output) {
		String response = result == ResultKind.SUCCESS ? "saved" : "close";
		ResponseFormatter formatter = AbstractServiceServlet.getResponseFormatter(responseOptions.responseFormat, output);
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