package no.hal.eclipsky.services.sourceeditor;

import java.io.PrintWriter;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import no.hal.eclipsky.services.sourceeditor.SourceEditorServlet.EditorServiceRequest;
import no.hal.eclipsky.services.workspace.IServiceExecutor;
import no.hal.eclipsky.services.workspace.http.AbstractServiceServlet;
import no.hal.eclipsky.services.workspace.http.util.ResponseFormatter;
import no.hal.eclipsky.services.workspace.http.util.ResponseOptions;
import no.hal.eclipsky.services.workspace.model.ModelFactory;
import no.hal.eclipsky.services.workspace.model.RefreshEditorService;

@Component(
	immediate = true,
	property = AbstractSourceEditorServletService.OPERATION_KEY + "=refresh"
)
public class RefreshEditorServletService extends AbstractSourceEditorServletService<RefreshEditorService> implements SourceEditorServletService {

	@Reference(target="(services=*RefreshEditorService*)")
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

	protected Boolean markersDefault = true;

	@Override
	protected RefreshEditorService createService(EditorServiceRequest request, String requestBody) {
		RefreshEditorService service = getServiceFactory().createRefreshEditorService();
		service.setResourceRef(request.resourceRef);
		return service;
	}

	@Override
	protected void servicePerformedWithSuccess(RefreshEditorService service, ResponseOptions responseOptions, PrintWriter writer) {
		String stringContent = service.getResource().getContents().getStringContent();
		ResponseFormatter formatter = AbstractServiceServlet.getResponseFormatter(responseOptions.responseFormat, writer);
		if (formatter != null) {
			formatter.startEntities("refresh", false);
		} else {
			writer.println("<html>\n"
				+ "\t<head><title>Refresh</title></head>\n"
				+ "\t<body>");
			writer.println("\t\t<h1>Refresh</h1>\n\t\t");
		}

		if (formatter != null) {
			formatter.entity("refresh", 
							"code", stringContent,
							"resource", service.getResourceRef().getQualifiedName()
							).endEntity();
		} else {
			// TODO: Write a proper result display
			writer.println("\t\t\t<textarea>" + stringContent + "</textarea>");
		}

		if (formatter == null) {
			writer.println("\t</body>\n</html>");
		}
	}
}
