package no.hal.eclipsky.services.common;

public class ResourceRef extends ProjectRef {

	private String packageName, resourceName;
	
	public ResourceRef(String projectName, String packageName, String resourceName) {
		super(projectName);
		this.packageName = packageName;
		this.resourceName = resourceName;
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
