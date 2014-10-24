package no.hal.eclipsky.services.workspace;

import no.hal.eclipsky.services.Status;

public class SourceFileMarker extends Status {
	
	private static final long serialVersionUID = 1L;
	
	public final int lineNumber;
	public final int start, end;
	
	public SourceFileMarker(Severity severity, String message, int lineNumber, int start, int end) {
		super(severity, message);
		this.lineNumber = lineNumber;
		this.start = start;
		this.end = end;
	}
}
