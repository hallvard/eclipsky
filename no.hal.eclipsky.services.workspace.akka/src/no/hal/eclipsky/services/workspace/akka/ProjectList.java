package no.hal.eclipsky.services.workspace.akka;

import java.io.Serializable;

public class ProjectList implements Serializable {

	private static final long serialVersionUID = 1L;

	public final String[] projectNames;
	
	public ProjectList(String... projectNames) {
		this.projectNames = projectNames;
	}
}
