package no.hal.eclipsky.services.editor;

import no.hal.eclipsky.services.common.ProjectRef;
import no.hal.eclipsky.services.common.ResourceRef;

public interface SourceProject {
	public ProjectRef getProjectRef();
	public ResourceRef[] getEditables();
	public SourceEditor getSourceEditor(ResourceRef resource);
	public RunResult run(boolean result);
	public RunResult test(boolean result);
}
