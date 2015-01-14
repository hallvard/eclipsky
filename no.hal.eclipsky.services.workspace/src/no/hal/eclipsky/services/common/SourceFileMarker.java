package no.hal.eclipsky.services.common;


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
	
	@Override
	public String toString() {
		return severity + "! " + message + " @" + lineNumber + ":" + start + "-" + end;
	}
}
