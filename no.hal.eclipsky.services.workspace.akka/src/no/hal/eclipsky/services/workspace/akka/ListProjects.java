package no.hal.eclipsky.services.workspace.akka;

import java.io.Serializable;

public class ListProjects implements Serializable {

	private static final long serialVersionUID = 1L;

	public final String namePattern;
	public final String type;
	
	public ListProjects() {
		this(null);
	}
	
	public ListProjects(String namePattern) {
		this(namePattern, null);
	}
	
	public ListProjects(String namePattern, String type) {
		this.namePattern = namePattern;
		this.type = type;
	}
}
