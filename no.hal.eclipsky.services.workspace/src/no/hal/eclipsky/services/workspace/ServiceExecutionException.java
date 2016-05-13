package no.hal.eclipsky.services.workspace;

import no.hal.eclipsky.services.workspace.model.AbstractService;
import no.hal.eclipsky.services.workspace.model.ResultKind;

@SuppressWarnings("serial")
public class ServiceExecutionException extends RuntimeException {

	private final AbstractService service;
	private final ResultKind resultKind;
	
	public ServiceExecutionException(String message, AbstractService service, ResultKind resultKind, Throwable ex) {
		super(message, ex);
		this.service = service;
		this.resultKind = resultKind;
	}
	
	public AbstractService getService() {
		return service;
	}
	
	public ResultKind getResultKind() {
		return resultKind;
	}
}
