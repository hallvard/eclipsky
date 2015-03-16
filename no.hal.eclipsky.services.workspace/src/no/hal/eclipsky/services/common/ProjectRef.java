package no.hal.eclipsky.services.common;

public class ProjectRef {

	private String projectName;
	
	public ProjectRef(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectName() {
		return projectName;
	}

	protected void setProjectName(String projectName) {
		this.projectName = projectName;
	}
}
