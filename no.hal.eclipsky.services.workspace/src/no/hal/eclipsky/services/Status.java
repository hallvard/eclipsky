package no.hal.eclipsky.services;

import java.io.Serializable;

public class Status implements Serializable {

	private static final long serialVersionUID = 1L;

	public enum Severity {
		OK,
		Info,
		Warning,
		Error
	}

	public final Severity severity;
	public final String message;

	public Status(Severity severity, String message) {
		this.severity = severity;
		this.message = message;
	}
	
	public final static Status OK = new Status(Severity.OK, null);
}
