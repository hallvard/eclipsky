package no.hal.eclipsky.services.workspace;

import org.eclipse.core.runtime.CoreException;

public interface WorkspaceService {
	public void ensureProject(EnsureJavaProject message) throws CoreException;
	public ProjectList getProjectList(ListProjects message);
}
