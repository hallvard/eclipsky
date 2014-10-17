package no.hal.eclipsky.services.workspace;

import java.io.Serializable;

public class ListProjects implements Serializable {

	private static final long serialVersionUID = 1L;

	public final String namePattern;
	public final String nature;
	
	public ListProjects() {
		this(null);
	}
	
	public ListProjects(String namePattern) {
		this(namePattern, null);
	}
	
	public ListProjects(String namePattern, String nature) {
		this.namePattern = namePattern;
		this.nature = nature;
	}
}
