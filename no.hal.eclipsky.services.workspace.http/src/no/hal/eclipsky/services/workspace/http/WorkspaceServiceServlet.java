package no.hal.eclipsky.services.workspace.http;

import no.hal.eclipsky.services.workspace.WorkspaceService;

public interface WorkspaceServiceServlet extends ServiceServlet {
	public void setWorkspaceService(WorkspaceService workspaceService);
}
