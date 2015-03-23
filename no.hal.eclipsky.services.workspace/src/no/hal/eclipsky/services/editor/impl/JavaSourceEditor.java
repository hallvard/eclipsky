package no.hal.eclipsky.services.editor.impl;

import java.util.Collection;

import no.hal.eclipsky.services.common.Proposal;
import no.hal.eclipsky.services.common.ResourceRef;
import no.hal.eclipsky.services.common.SourceFileMarker;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.core.CompletionProposal;
import org.eclipse.jdt.core.CompletionRequestor;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IProblemRequestor;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.WorkingCopyOwner;

public class JavaSourceEditor extends GenericSourceEditor {

	private ICompilationUnit workingCopy = null;

	public JavaSourceEditor(ResourceRef resourceRef) {
		super(resourceRef);
		System.out.println("JavaSourceEditor: Getting file for " + resourceRef);
		IFile file = getFile(true);
		System.out.println("JavaSourceEditor: Creating working copy for " + file);
		workingCopy = JavaCore.createCompilationUnitFrom(file);
		if (workingCopy.exists()) {
			try {
				workingCopy.becomeWorkingCopy(null);
			} catch (JavaModelException e) {
				workingCopy = null;
			}
		}
	}

	private static String[] JAVA_SOURCE_FOLDERS = {"src", "resources"}; 
	
	protected String[] getSourceFolderNames() {
		return JAVA_SOURCE_FOLDERS;
	}

	@Override
	public SourceFileMarker[] update(String stringContent, boolean markers, boolean commit) {
		if (workingCopy != null) {
			try {
				if (stringContent != null) {
					workingCopy.getBuffer().setContents(stringContent);
				}
				final SourceFileMarkersProvider sourceFileMarkersProvider = new SourceFileMarkersProvider();
				workingCopy.reconcile(ICompilationUnit.NO_AST, true, new WorkingCopyOwner() {
					@Override
					public IProblemRequestor getProblemRequestor(ICompilationUnit workingCopy) {
						return sourceFileMarkersProvider;
					}
				}, null);
				try {
					SourceFileMarker[] sourceFileMarkers = sourceFileMarkersProvider.getSourceFileMarkersFuture().get();
					return sourceFileMarkers;
				} catch (Exception e) {
				}
			} catch (JavaModelException e) {
			}
			return null;
		}
		return super.update(stringContent, markers, commit);
	}

	@Override
	protected void addCompletionProposals(int pos, Collection<Proposal> completions) throws NullPointerException {
		if (workingCopy == null) {
			throw new NullPointerException("Working Copy is null");
		}
		try {
			workingCopy.codeComplete(pos, new CompletionRequestor() {
				@Override
				public void accept(CompletionProposal proposal) {
					Proposal p = Proposal.getProposal(proposal);
					completions.add(p);					
				}
			});		
		} catch (JavaModelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	@Override
	public void close(IProgressMonitor monitor) {
		if (workingCopy != null) {
			try {
				workingCopy.commitWorkingCopy(true, monitor);
				workingCopy.discardWorkingCopy();
			} catch (JavaModelException e) {
			}
		}
		super.close(monitor);
	}
}
