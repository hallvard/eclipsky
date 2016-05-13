package no.hal.eclipsky.services.sourceeditor;

import java.io.PrintWriter;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import no.hal.eclipsky.services.sourceeditor.SourceEditorServlet.EditorServiceRequest;
import no.hal.eclipsky.services.workspace.IServiceExecutor;
import no.hal.eclipsky.services.workspace.http.util.ResponseOptions;
import no.hal.eclipsky.services.workspace.model.ModelFactory;
import no.hal.eclipsky.services.workspace.model.UpdateEditorService;
import no.hal.emfs.EmfsFactory;
import no.hal.emfs.StringContentProvider;

@Component(
	immediate = true,
	property = AbstractSourceEditorServletService.OPERATION_KEY + "=update"
)
public class UpdateEditorServletService extends AbstractSourceEditorServletService<UpdateEditorService> implements SourceEditorServletService {

	@Reference(target="(services=*UpdateEditorService*)")
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
	protected UpdateEditorService createService(EditorServiceRequest request, String requestBody) {
		UpdateEditorService service = getServiceFactory().createUpdateEditorService();
		service.setResourceRef(request.resourceRef);
		StringContentProvider contentProvider = EmfsFactory.eINSTANCE.createStringContentProvider();
		contentProvider.setStringContent(requestBody);
		service.setContents(contentProvider);
		return service;
	}
	
	@Override
	protected void servicePerformedWithSuccess(UpdateEditorService service, ResponseOptions responseOptions, PrintWriter writer) {
		MarkersEditorServletService.writeMarkersResponse(service.getMarkers().getMarkers(), responseOptions, writer);
	}
}
