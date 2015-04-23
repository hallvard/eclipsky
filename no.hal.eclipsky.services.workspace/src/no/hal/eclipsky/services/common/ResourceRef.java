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
	public String toPath() {
		return super.toPath() +  "/" + packageName.replace('.', '/') + "/" + resourceName;
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
	
	//
	
	public static ResourceRef valueOf(String resourcePath) {
		return valueOf(resourcePath, null);
	}

	public static ResourceRef valueOf(String resourcePath, ProjectRef defaultProject) {
		int startPos = 0, pos = resourcePath.indexOf('/'), lastPos = resourcePath.lastIndexOf('/');
		String projectName = null, packageName = null, resourceName = null;
		if (pos == 0) {
			// skip first char
			startPos = 1;
			pos = resourcePath.indexOf('/');
		}
		if (pos < 0) {
			// one segment
			resourceName = resourcePath;
		} else {
			// at least two segment: resourceName
			resourceName = resourcePath.substring(lastPos + 1);
			if (pos == lastPos) {
				// only two segments: packageName/resourceName
				packageName = resourcePath.substring(startPos, lastPos);
			} else {
				// three or more segments: projectName/packageName/resourceName
				projectName = resourcePath.substring(startPos, pos);
				packageName = resourcePath.substring(pos + 1, lastPos).replace('/', '.');
			}
		}
		if (projectName == null && defaultProject != null) {
			projectName = defaultProject.getProjectName();
		}
		return new ResourceRef(projectName, packageName, resourceName);
	}
}
