package no.hal.eclipsky.services.workspace.http;

import no.hal.eclipsky.services.common.ProjectRef;
import no.hal.eclipsky.services.editor.SourceProject;
import no.hal.emfs.EmfsResource;

public interface SourceProjectManager {

	public void ensureSourceProject(ProjectRef projectRef, EmfsResource emfsResource) throws Exception;
	public SourceProject getSourceProject(ProjectRef projectRef);
	public EmfsResource getEmfs(ProjectRef projectRef);
}
