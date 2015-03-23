package no.hal.eclipsky.services.common;

public class ProjectRef {

	private String projectName;
	
	public ProjectRef(String projectName) {
		this.projectName = projectName;
	}

	public ProjectRef(ProjectRef projectRef) {
		this(projectRef.getProjectName());
	}

	@Override
	public String toString() {
		return "->/" + projectName;
	}

	public String getProjectName() {
		return projectName;
	}

	protected void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((projectName == null) ? 0 : projectName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProjectRef other = (ProjectRef) obj;
		if (projectName == null) {
			if (other.projectName != null)
				return false;
		} else if (!projectName.equals(other.projectName))
			return false;
		return true;
	}
}
