package no.hal.eclipsky.services.editor;

import org.eclipse.core.runtime.IProgressMonitor;

import no.hal.eclipsky.services.common.ResourceRef;
import no.hal.eclipsky.services.workspace.model.CompletionProposal;
import no.hal.eclipsky.services.workspace.model.SourceFileMarker;

public interface SourceEditor {
	public ResourceRef getResourceRef();
	public CharSequence getSourceFileContents();
	public byte[] getResourceFileContents();
	public SourceFileMarker[] update(String stringContent, boolean markers, IProgressMonitor monitor);
	public CompletionProposal[] complete(int pos);
	public void close(IProgressMonitor monitor);
	public CharSequence getWorkingCopyContents();
}
