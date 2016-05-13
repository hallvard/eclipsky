package no.hal.eclipsky.services.workspace.impl;

import java.util.concurrent.CompletableFuture;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import no.hal.eclipsky.services.common.ProjectRef;
import no.hal.eclipsky.services.editor.SourceEditor;
import no.hal.eclipsky.services.editor.SourceProject;
import no.hal.eclipsky.services.workspace.IServiceExecutor;
import no.hal.eclipsky.services.workspace.SourceProjectManager;
import no.hal.eclipsky.services.workspace.WorkspaceService;
import no.hal.eclipsky.services.workspace.model.CloseEditorService;
import no.hal.eclipsky.services.workspace.model.ExecutionResult;
import no.hal.eclipsky.services.workspace.model.ResultKind;
import no.hal.eclipsky.services.workspace.model.RunEditorService;
import no.hal.eclipsky.services.workspace.model.TestEditorService;
import no.hal.emfs.EmfsResource;

@Component(
	immediate=true,
	property="services=RunEditorService CloseEditorService TestEditorService"
)
public class ExecutionServiceExecutor extends AbstractServiceExecutor implements IServiceExecutor {

	@Reference
	public synchronized void setWorkspaceService(WorkspaceService workspaceService) {
		super.setWorkspaceService(workspaceService);
	}
	public synchronized void unsetWorkspaceService(WorkspaceService workspaceService) {
		super.setWorkspaceService(null);
	}
	
	@Reference
	public synchronized void setSourceProjectManager(SourceProjectManager sourceProjectManager) {
		super.setSourceProjectManager(sourceProjectManager);
	}
	public synchronized void unsetSourceProjectManager(SourceProjectManager sourceProjectManager) {
		super.setSourceProjectManager(null);
	}

	@Activate
	protected void activate(ComponentContext context) {
		registerServiceFactory(context);
	}

	//
	
	@Override
	public ResultKind caseCloseEditorService(CloseEditorService service) {
		SourceProject sourceProject = getSourceProjectManager().getSourceProject(service.getResourceRef());
		SourceEditor sourceEditor = sourceProject.getSourceEditor(service.getResourceRef());
		CompletableFuture<Boolean> future = new CompletableFuture<Boolean>();
		sourceEditor.close(new NullProgressMonitor() {
			@Override
			public void done() {
				future.complete(! isCanceled());
			}
		});
		try {
			Boolean result = future.get();
			return (Boolean.TRUE.equals(result) ? ResultKind.SUCCESS : ResultKind.FAILURE);
		} catch (Exception e) {
			return ResultKind.ERROR;
		}
	}

	@Override
	public ResultKind caseRunEditorService(RunEditorService service) {
		ProjectRef projectRef = new ProjectRef(service.getResourceRef());
		SourceProject sourceProject = getSourceProjectManager().getSourceProject(projectRef);
		EmfsResource emfsResource = EmfsUtil.findEmfsResource(getSourceProjectManager().getEmfsResource(projectRef), EmfsUtil::isRunnable);
		if (emfsResource != null) {
			ExecutionResult result = sourceProject.run(service.getResourceRef());
			service.setResult(result);
		}
		return ResultKind.SUCCESS;
	}

	@Override
	public ResultKind caseTestEditorService(TestEditorService service) {
		ProjectRef projectRef = new ProjectRef(service.getResourceRef());
		SourceProject sourceProject = getSourceProjectManager().getSourceProject(projectRef);
		EmfsResource emfsResource = EmfsUtil.findEmfsResource(getSourceProjectManager().getEmfsResource(projectRef), EmfsUtil::isTestable);
		if (emfsResource != null) {
			ExecutionResult result = sourceProject.test(service.getResourceRef());
			service.setResult(result);
		}
		return ResultKind.SUCCESS;
	}
}
