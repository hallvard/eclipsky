package no.hal.eclipsky.services.workspace.akka;

import java.io.Serializable;

public class EnsureJavaProject implements Serializable {

	private static final long serialVersionUID = 1L;

	public final String name;
	public final String type;
	
	public EnsureJavaProject(String name) {
		this(name, null);
	}

	public EnsureJavaProject(String name, String type) {
		this.name = name;
		this.type = type;
	}
}
