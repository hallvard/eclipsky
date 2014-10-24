package no.hal.eclipsky.services.workspace;

public interface WorkspaceService {
	public String[] getProjectList(String namePattern, String type);
	public void ensureProject(String name, String type);

	public String getSourceFile(String projectName, String packageName, String resourceName);
	public byte[] getResource(String projectName, String packageName, String resourceName);
	
	public SourceFileMarker[] getSourceFileMarkers(String projectName, String packageName, String resourceName, boolean build);
	public SourceFileMarker[] updateSourceFile(String projectName, String packageName, String resourceName, String stringContent, Boolean markers);
}
