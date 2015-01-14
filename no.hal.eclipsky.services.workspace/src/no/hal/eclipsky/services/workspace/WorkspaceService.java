package no.hal.eclipsky.services.workspace;

import no.hal.eclipsky.services.common.ResourceRef;
import no.hal.eclipsky.services.common.SourceFileMarker;

public interface WorkspaceService {
	public String[] getProjectList(String namePattern, String type);
	public void ensureProject(String name, String type);

	public String getSourceFile(ResourceRef resourceRef);
	public byte[] getResource(ResourceRef resourceRef);
	
	public SourceFileMarker[] getSourceFileMarkers(ResourceRef resourceRef, boolean build);
	public SourceFileMarker[] updateSourceFile(ResourceRef resourceRef, String stringContent, Boolean exists, Boolean markers);
}
