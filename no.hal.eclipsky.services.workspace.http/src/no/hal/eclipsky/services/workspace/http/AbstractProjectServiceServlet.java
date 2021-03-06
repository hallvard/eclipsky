package no.hal.eclipsky.services.workspace.http;

import no.hal.eclipsky.services.workspace.ProjectService;

@SuppressWarnings("serial")
public abstract class AbstractProjectServiceServlet extends AbstractServiceServlet {

	private ProjectService projectService;

	protected ProjectService getProjectService() {
		return projectService;
	}

	public synchronized void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}
}
