package no.hal.eclipsky.services.sourceeditor;

import java.io.PrintWriter;
import java.util.Collection;

import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import no.hal.eclipsky.services.sourceeditor.SourceEditorServlet.EditorServiceRequest;
import no.hal.eclipsky.services.workspace.IServiceExecutor;
import no.hal.eclipsky.services.workspace.http.AbstractServiceServlet;
import no.hal.eclipsky.services.workspace.http.util.ResponseFormatter;
import no.hal.eclipsky.services.workspace.http.util.ResponseOptions;
import no.hal.eclipsky.services.workspace.model.MarkersEditorService;
import no.hal.eclipsky.services.workspace.model.ModelFactory;
import no.hal.eclipsky.services.workspace.model.SourceFileMarker;

@Component(
	immediate = true,
	property = AbstractSourceEditorServletService.OPERATION_KEY + "=markers"
)
public class MarkersEditorServletService extends AbstractSourceEditorServletService<MarkersEditorService> implements SourceEditorServletService {

	@Reference(target="(services=*MarkersEditorService*)")
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
	
	protected MarkersEditorService createService(EditorServiceRequest request, String requestBody) {
		MarkersEditorService service = getServiceFactory().createMarkersEditorService();
		service.setResourceRef(request.resourceRef);
		return service;
	}

	@Override
	protected void servicePerformedWithSuccess(MarkersEditorService service, ResponseOptions responseOptions, PrintWriter writer) {
		writeMarkersResponse(service.getMarkers().getMarkers(), responseOptions, writer);
	}

	static void writeMarkersResponse(Collection<SourceFileMarker> markers, ResponseOptions responseOptions, PrintWriter writer) {
		ResponseFormatter formatter = AbstractServiceServlet.getResponseFormatter(responseOptions.responseFormat, writer);
		if (formatter != null) {
			formatter.startEntities("problems", true);
		} else {
			writer.println("<html>\n"
					+ "\t<head><title>Problems</title></head>\n"
					+ "\t<body>");
			writer.println("\t\t<h1>Problems</h1>\n\t\t<ul>");
		}
		for (SourceFileMarker problem : markers) {
			if (formatter != null) {
				int lineNumber = problem.getLineNumber(), start = problem.getStart(), end = problem.getEnd();
				formatter.entity("problem",
						"severity", problem.getSeverity(),
						"message", problem.getMessage(),
						"lineNumber", lineNumber,
						"start", start,
						"end", end)
				.endEntity();
			} else {
				writer.println("\t\t\t<li>" + problem.getMessage() + "</li>");
			}
		}
		if (formatter != null) {
			formatter.endEntities();
		} else {
			writer.println("\t\t</ul>");
			writer.println("\t</body>\n"
					+ "</html>");
		}
	}
}
