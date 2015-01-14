package no.hal.eclipsky.services.editor.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.CompletableFuture;

import no.hal.eclipsky.services.common.SourceFileMarker;
import no.hal.eclipsky.services.common.Status;

import org.eclipse.core.resources.IMarker;
import org.eclipse.jdt.core.IProblemRequestor;
import org.eclipse.jdt.core.compiler.IProblem;

public class SourceFileMarkersProvider implements IProblemRequestor {

	private Collection<SourceFileMarker> sourceFileMarkers = new ArrayList<SourceFileMarker>();

	private CompletableFuture<SourceFileMarker[]> sourceFileMarkersFuture;
	
	@Override
	public void beginReporting() {
	}
	@Override
	public void acceptProblem(IProblem problem) {
		sourceFileMarkers.add(createSourceFileMarker(problem));
	}

	@Override
	public void endReporting() {
		sourceFileMarkersFuture = new CompletableFuture<SourceFileMarker[]>();
		sourceFileMarkersFuture.complete(getSourceFileMarkers());
		sourceFileMarkers.clear();
	}

	@Override
	public boolean isActive() {
		return sourceFileMarkers != null;
	}
	
	public SourceFileMarker[] getSourceFileMarkers() {
		return sourceFileMarkers.toArray(new SourceFileMarker[sourceFileMarkers.size()]);
	}
	
	public CompletableFuture<SourceFileMarker[]> getSourceFileMarkersFuture() {
		return sourceFileMarkersFuture;
	}

	//
	
	public static SourceFileMarker createSourceFileMarker(IMarker marker) {
		String message = marker.getAttribute(IMarker.MESSAGE, null);
		int lineNumber = marker.getAttribute(IMarker.LINE_NUMBER, -1);
		int start = marker.getAttribute(IMarker.CHAR_START, -1), end = marker.getAttribute(IMarker.CHAR_END, -1);
		int markerSeverity = marker.getAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
		return new SourceFileMarker(getSeverity(markerSeverity), message, lineNumber, start, end);
	}

	public static SourceFileMarker createSourceFileMarker(IProblem problem) {
		String message = problem.getMessage();
		int lineNumber = problem.getSourceLineNumber();
		int start = problem.getSourceStart(), end = problem.getSourceEnd();
		return new SourceFileMarker(getSeverity(problem), message, lineNumber, start, end);
	}
	
	public static Status.Severity getSeverity(int severity) {
		switch (severity) {
		case IMarker.SEVERITY_WARNING:
			return Status.Severity.Warning;
		case IMarker.SEVERITY_INFO:
			return Status.Severity.Info;
		default:
			return Status.Severity.Error;
		}
	}

	public static Status.Severity getSeverity(IProblem problem) {
		if (problem.isError()) {
			return Status.Severity.Error;
		} else if (problem.isWarning()) {
			return Status.Severity.Warning;
		} else {
			return Status.Severity.Info;
		}
	}
}
