package no.hal.eclipsky.services.workspace;

public interface WorkspaceService {
	public void ensureProject(String name, String type);
	public String[] getProjectList(String namePattern, String type);
	public String getSourceFile(String projectName, String packageName, String resourceName);
	public byte[] getResource(String projectName, String packageName, String resourceName);
}
