package no.hal.eclipsky.services.workspace.http;

import no.hal.eclipsky.services.workspace.WorkspaceService;

public interface WorkspaceServiceServlet {
	public void setWorkspaceService(WorkspaceService workspaceService);
	public String getAlias();
	public String[] getResourceAliases();
}
