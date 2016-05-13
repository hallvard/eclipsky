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
import no.hal.eclipsky.services.workspace.model.CompletionEditorService;
import no.hal.eclipsky.services.workspace.model.CompletionProposal;
import no.hal.eclipsky.services.workspace.model.ModelFactory;

@Component(
	immediate = true,
	property = AbstractSourceEditorServletService.OPERATION_KEY + "=completion"
)
public class CompletionEditorServletService extends AbstractSourceEditorServletService<CompletionEditorService> implements SourceEditorServletService {

	@Activate
	@Override
	protected void activate(ComponentContext context) {
		super.activate(context);
	}

	@Reference(target="(services=*CompletionEditorService*)")
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

	@Override
	protected CompletionEditorService createService(EditorServiceRequest request, String requestBody) {
		CompletionEditorService service = getServiceFactory().createCompletionEditorService();
		service.setResourceRef(request.resourceRef);
		service.setPosition(Integer.parseInt(requestBody));
		return service;
	}

	@Override
	protected void servicePerformedWithSuccess(CompletionEditorService service, ResponseOptions responseOptions, PrintWriter output) {
		ResponseFormatter formatter = AbstractServiceServlet.getResponseFormatter(responseOptions.responseFormat, output);
		if (formatter != null) {
			formatter.startEntities("completions", true);
		} else {
			output.println("<html>\n"
					+ "\t<head><title>Completions</title></head>\n"
					+ "\t<body>");
			output.println("\t\t<h1>Completions</h1>\n\t\t<ul>");
		}
		for (CompletionProposal completion : service.getProposals()) {
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
