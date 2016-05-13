package no.hal.eclipsky.services.editor.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.CompletableFuture;

import no.hal.eclipsky.services.workspace.model.ModelFactory;
import no.hal.eclipsky.services.workspace.model.SeverityKind;
import no.hal.eclipsky.services.workspace.model.SourceFileMarker;

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
		SourceFileMarker sourceFileMarker = ModelFactory.eINSTANCE.createSourceFileMarker();
		sourceFileMarker.setSeverity(getSeverity(markerSeverity));
		sourceFileMarker.setMessage(message);
		sourceFileMarker.setStart(start);
		sourceFileMarker.setEnd(end);
		sourceFileMarker.setLineNumber(lineNumber);
		return sourceFileMarker;
	}

	public static SourceFileMarker createSourceFileMarker(IProblem problem) {
		String message = problem.getMessage();
		int lineNumber = problem.getSourceLineNumber();
		int start = problem.getSourceStart(), end = problem.getSourceEnd();
		SourceFileMarker sourceFileMarker = ModelFactory.eINSTANCE.createSourceFileMarker();
		sourceFileMarker.setSeverity(getSeverity(problem));
		sourceFileMarker.setMessage(message);
		sourceFileMarker.setStart(start);
		sourceFileMarker.setEnd(end);
		sourceFileMarker.setLineNumber(lineNumber);
		return sourceFileMarker;
	}
	
	public static SeverityKind getSeverity(int severity) {
		switch (severity) {
		case IMarker.SEVERITY_WARNING:
			return SeverityKind.WARNING;
		case IMarker.SEVERITY_INFO:
			return SeverityKind.INFO;
		default:
			return SeverityKind.ERROR;
		}
	}

	public static SeverityKind getSeverity(IProblem problem) {
		if (problem.isError()) {
			return SeverityKind.ERROR;
		} else if (problem.isWarning()) {
			return SeverityKind.WARNING;
		} else {
			return SeverityKind.INFO;
		}
	}
}
