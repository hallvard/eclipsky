package no.hal.eclipsky.services.workspace.impl;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentContext;

import no.hal.eclipsky.services.workspace.IServiceExecutor;
import no.hal.eclipsky.services.workspace.SourceProjectManager;
import no.hal.eclipsky.services.workspace.WorkspaceService;
import no.hal.eclipsky.services.workspace.model.AbstractService;
import no.hal.eclipsky.services.workspace.model.ModelFactory;
import no.hal.eclipsky.services.workspace.model.ResultKind;
import no.hal.eclipsky.services.workspace.model.util.ModelSwitch;

abstract class AbstractServiceExecutor extends ModelSwitch<ResultKind> implements IServiceExecutor {

	private WorkspaceService workspaceService;

	public WorkspaceService getWorkspaceService() {
		return workspaceService;
	}
	
	protected synchronized void setWorkspaceService(WorkspaceService workspaceService) {
		this.workspaceService = workspaceService;
	}
	
	private SourceProjectManager sourceProjectManager;
	
	public SourceProjectManager getSourceProjectManager() {
		return sourceProjectManager;
	}

	protected synchronized void setSourceProjectManager(SourceProjectManager sourceProjectManager) {
		this.sourceProjectManager = sourceProjectManager;
	}

	protected void registerServiceFactory(ComponentContext context) {
		BundleContext bundleContext = context.getBundleContext();
		bundleContext.registerService(ModelFactory.class, ModelFactory.eINSTANCE, null);
	}

	@Override
	public ResultKind performService(AbstractService service) {
		try {
			return doSwitch(service);
		} catch (Exception e) {
			return ResultKind.ERROR;
		}
	}
}
