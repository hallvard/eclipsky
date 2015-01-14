package no.hal.eclipsky.services.common;

public class ResourceRef {

	private String projectName, packageName, resourceName;
	
	public ResourceRef(String projectName, String packageName, String resourceName) {
		this.projectName = projectName;
		this.packageName = packageName;
		this.resourceName = resourceName;
	}

	public String getProjectName() {
		return projectName;
	}

	protected void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getPackageName() {
		return packageName;
	}

	protected void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getResourceName() {
		return resourceName;
	}

	protected void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
}
