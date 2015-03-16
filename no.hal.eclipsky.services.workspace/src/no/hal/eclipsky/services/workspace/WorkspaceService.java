package no.hal.eclipsky.services.workspace;

/**
 * Workspace level methods, i.e. mainly covering projects
 * @author hal
 */
public interface WorkspaceService extends ResourcesService {

	/**
	 * Gets the list of projects in the workspace
	 * @param namePattern
	 * @param type
	 * @return
	 */
	public String[] getProjectList(String namePattern, String type);
	
	/**
	 * Creates a project and populates it according to the provided emfs model
	 * @param name the project name
	 * @param types project type(s) 
	 */
	public void ensureProject(String name, String... types);
}
