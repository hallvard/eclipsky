package no.hal.eclipsky.services.workspace;

public interface WorkspaceService {
	public String[] getProjectList(String namePattern, String type);
	public void ensureProject(String name, String type);

	public String getSourceFile(String projectName, String packageName, String resourceName);
	public byte[] getResource(String projectName, String packageName, String resourceName);
	
	public void updateSourceFile(String projectName, String packageName, String resourceName, String stringContent);
}
