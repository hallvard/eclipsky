package no.hal.eclipsky.services.workspace;

import java.io.Serializable;

public class EnsureJavaProject implements Serializable {

	private static final long serialVersionUID = 1L;

	public final String name;
	public final String[] natures;
	
	public EnsureJavaProject(String name) {
		this(name, null);
	}

	public EnsureJavaProject(String name, String[] additionalNatures) {
		this.name = name;
		this.natures = additionalNatures;
	}
}
