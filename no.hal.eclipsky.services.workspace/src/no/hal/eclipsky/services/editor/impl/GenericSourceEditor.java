package no.hal.eclipsky.services.editor.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;

import no.hal.eclipsky.services.common.ResourceHelper;
import no.hal.eclipsky.services.common.ResourceRef;
import no.hal.eclipsky.services.editor.SourceEditor;
import no.hal.eclipsky.services.workspace.model.CompletionProposal;
import no.hal.eclipsky.services.workspace.model.SourceFileMarker;

public class GenericSourceEditor implements SourceEditor {

	protected final ResourceRef resourceRef;

	protected ResourceHelper resourceHelper;
	
	public GenericSourceEditor(ResourceRef resourceRef) {
		this.resourceRef = resourceRef;
		resourceHelper = new ResourceHelper(resourceRef.getProjectName(), resourceRef.getPackageName(), resourceRef.getResourceName(), null, getSourceFolderNames());
	}
	
	@Override
	public ResourceRef getResourceRef() {
		return resourceRef;
	}

	private static String[] SOURCE_FOLDER_NAMES = {"src"};
	
	protected String[] getSourceFolderNames() {
		return SOURCE_FOLDER_NAMES;
	}
	
	protected IFile getFile(boolean exists) {
		return resourceHelper.getFile(exists);
	}
	
	@Override
	public CharSequence getSourceFileContents() {
		return resourceHelper.getFileStringContent();
	}

	@Override
	public byte[] getResourceFileContents() {
		return resourceHelper.getFileBytesContent();
	}

	@Override
	public SourceFileMarker[] update(String stringContent, boolean markers, IProgressMonitor monitor) {
		if (stringContent != null && getFile(true) != null) {
			resourceHelper.setFileStringContent(stringContent);
		}
		return resourceHelper.createSourceFileMarkers();
	}

	@Override
	public CompletionProposal[] complete(int pos) {
		final Collection<CompletionProposal> completions = new ArrayList<>();
		addCompletionProposals(pos, completions);
		return completions.toArray(new CompletionProposal[completions.size()]);
	}

	protected void addCompletionProposals(int pos, Collection<CompletionProposal> completions) throws NullPointerException{
	}
	@Override
	public void close(IProgressMonitor monitor) {
	}

	@Override
	public CharSequence getWorkingCopyContents() {
		return getSourceFileContents();
	}
}
