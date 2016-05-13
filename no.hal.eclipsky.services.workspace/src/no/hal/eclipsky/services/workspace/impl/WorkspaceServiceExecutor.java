package no.hal.eclipsky.services.workspace.impl;

import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import no.hal.eclipsky.services.common.ProjectRef;
import no.hal.eclipsky.services.editor.SourceProject;
import no.hal.eclipsky.services.workspace.IServiceExecutor;
import no.hal.eclipsky.services.workspace.SourceProjectManager;
import no.hal.eclipsky.services.workspace.WorkspaceService;
import no.hal.eclipsky.services.workspace.model.EnsureProjectService;
import no.hal.eclipsky.services.workspace.model.ModelFactory;
import no.hal.eclipsky.services.workspace.model.ProjectInfo;
import no.hal.eclipsky.services.workspace.model.ProjectListService;
import no.hal.eclipsky.services.workspace.model.ResultKind;

@Component(
	immediate=true,
	property="services=ProjectListService EnsureProjectService"
)
public class WorkspaceServiceExecutor extends AbstractServiceExecutor implements IServiceExecutor {

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
	public ResultKind caseProjectListService(ProjectListService service) {
		String[] projectNames = getWorkspaceService().getProjectList(service.getNamePattern(), service.getType());
		for (int i = 0; i < projectNames.length; i++) {
			SourceProject sourceProject = getSourceProjectManager().getSourceProject(new ProjectRef(projectNames[i]));
			if (sourceProject != null) {
				ProjectInfo projectInfo = ModelFactory.eINSTANCE.createProjectInfo();
				projectInfo.setProjectRef(new ProjectRef(projectNames[i]));
				service.getProjects().add(projectInfo);
			}
		}
		return ResultKind.SUCCESS;
	}
	
	@Override
	public ResultKind caseEnsureProjectService(EnsureProjectService service) {
		try {
			getSourceProjectManager().ensureSourceProject(service.getProjectRef(), service.getEmfs());
		} catch (Exception e) {
			return ResultKind.ERROR;
		}
		return ResultKind.SUCCESS;
	}
}
