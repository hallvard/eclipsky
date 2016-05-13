package no.hal.eclipsky.services.sourceeditor;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.util.Dictionary;

import org.osgi.service.component.ComponentContext;

import no.hal.eclipsky.services.sourceeditor.SourceEditorServlet.EditorServiceRequest;
import no.hal.eclipsky.services.workspace.IServiceExecutor;
import no.hal.eclipsky.services.workspace.http.util.ResponseOptions;
import no.hal.eclipsky.services.workspace.model.AbstractService;
import no.hal.eclipsky.services.workspace.model.ModelFactory;
import no.hal.eclipsky.services.workspace.model.ResultKind;

public abstract class AbstractSourceEditorServletService<S extends AbstractService> implements SourceEditorServletService {

	private IServiceExecutor serviceExecutor;
	
	public IServiceExecutor getServiceExecutor() {
		return serviceExecutor;
	}
	
	protected synchronized void setServiceExecutor(IServiceExecutor serviceExecutor) {
		this.serviceExecutor = serviceExecutor;
	}

	private ModelFactory serviceFactory;

	public ModelFactory getServiceFactory() {
		return serviceFactory;
	}
	
	protected synchronized void setServiceFactory(ModelFactory serviceFactory) {
		this.serviceFactory = serviceFactory;
	}

	public final static String OPERATION_KEY = "operations";

	private String[] supportedOperations = {};
	
	protected void activate(ComponentContext context) {
		Dictionary<String, Object> properties = context.getProperties();
		Object operationsValue = (properties != null ? properties.get(OPERATION_KEY) : null);
		if (operationsValue != null) {
			supportedOperations = String.valueOf(operationsValue).split(",");
		}
	}

	@Override
	public String[] getSupportedOperations() {
		return supportedOperations;
	}
	
	//
	
	@Override
	public String doSourceEditorServletService(EditorServiceRequest request, String requestBody) {
		S service = createService(request, requestBody);
		ResultKind result = getServiceExecutor().performService(service);
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		PrintWriter output = new PrintWriter(buffer);
		servicePerformed(service, result, request.responseOptions, output);
		output.close();
		String responseString = buffer.toString();
		return responseString != null && responseString.length() > 0 ? responseString : null;
	}

	protected abstract S createService(EditorServiceRequest request, String requestBody);

	protected void servicePerformed(S service, ResultKind result, ResponseOptions responseOptions, PrintWriter output) {
		switch (result) {
		case SUCCESS:
			servicePerformedWithSuccess(service, responseOptions, output);
			break;
		case FAILURE:
			servicePerformedWithFailure(service, responseOptions, output);
			break;
		case ERROR:
			servicePerformedWithError(service, responseOptions, output);
			break;
		default:
			break;
		}
	}

	protected void servicePerformedWithSuccess(S service, ResponseOptions responseOptions, PrintWriter writer) {
	}

	protected void servicePerformedWithFailure(S service, ResponseOptions responseOptions, PrintWriter writer) {
	}

	protected void servicePerformedWithError(S service, ResponseOptions responseOptions, PrintWriter writer) {
	}
}
