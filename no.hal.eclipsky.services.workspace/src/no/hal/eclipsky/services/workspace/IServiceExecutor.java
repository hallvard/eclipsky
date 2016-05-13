package no.hal.eclipsky.services.workspace;

import no.hal.eclipsky.services.workspace.model.AbstractService;
import no.hal.eclipsky.services.workspace.model.ResultKind;

public interface IServiceExecutor {	
	public ResultKind performService(AbstractService service);
}
