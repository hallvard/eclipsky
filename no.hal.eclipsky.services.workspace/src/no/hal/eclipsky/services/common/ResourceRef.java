package no.hal.eclipsky.services.common;

public class ResourceRef extends ProjectRef {

	private String packageName, resourceName;
	
	public ResourceRef(String projectName, String packageName, String resourceName) {
		super(projectName);
		this.packageName = packageName;
		this.resourceName = resourceName;
	}

	public ResourceRef(ProjectRef projectRef, String packageName, String resourceName) {
		this(projectRef.getProjectName(), packageName, resourceName);
	}
	
	public ResourceRef(ResourceRef resourceRef) {
		this(resourceRef.getProjectName(), resourceRef.getPackageName(), resourceRef.getResourceName());
	}

	@Override
	public String toString() {
		return "->/" + getProjectName() + "/" + packageName + "/" + resourceName;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((getProjectName() == null) ? 0 : getProjectName().hashCode());
		result = prime * result
				+ ((packageName == null) ? 0 : packageName.hashCode());
		result = prime * result
				+ ((resourceName == null) ? 0 : resourceName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResourceRef other = (ResourceRef) obj;
		if (getProjectName() == null) {
			if (other.getProjectName() != null)
				return false;
		} else if (!getProjectName().equals(other.getProjectName()))
			return false;
		if (packageName == null) {
			if (other.packageName != null)
				return false;
		} else if (!packageName.equals(other.packageName))
			return false;
		if (resourceName == null) {
			if (other.resourceName != null)
				return false;
		} else if (!resourceName.equals(other.resourceName))
			return false;
		return true;
	}
}
