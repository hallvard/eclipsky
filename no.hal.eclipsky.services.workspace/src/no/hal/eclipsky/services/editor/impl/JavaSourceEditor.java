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

	private final IFile file;
	private ICompilationUnit workingCopy = null;

	public JavaSourceEditor(ResourceRef resourceRef) {
		super(resourceRef);
		file = getFile(true);
	}

	private void ensureWorkingCopy() {
		if (workingCopy == null) {
			workingCopy = JavaCore.createCompilationUnitFrom(file);
			if (workingCopy.exists()) {
				try {
					workingCopy.becomeWorkingCopy(null);
				} catch (JavaModelException e) {
					workingCopy = null;
				}
			}
		}
	}
	
	@Override
	public SourceFileMarker[] update(String stringContent, boolean markers, IProgressMonitor monitor) {
		ensureWorkingCopy();
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
				}, monitor);
				try {
					SourceFileMarker[] sourceFileMarkers = sourceFileMarkersProvider.getSourceFileMarkersFuture().get();
					return sourceFileMarkers;
				} catch (Exception e) {
				}
			} catch (JavaModelException e) {
			}
			return null;
		}
		return super.update(stringContent, markers, monitor);
	}
	
	@Override
	public CharSequence getWorkingCopyContents() {
		ensureWorkingCopy();
		if (workingCopy != null) {
			try {
				return workingCopy.getBuffer().getContents();
			} catch (JavaModelException e) {
			}
			return "";
		}
		return super.getWorkingCopyContents();
	}

	@Override
	protected void addCompletionProposals(int pos, Collection<Proposal> completions) throws NullPointerException {
		ensureWorkingCopy();
		if (workingCopy != null) {
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
	}
	
	@Override
	public void close(IProgressMonitor monitor) {
		if (workingCopy != null) {
			try {
				if (workingCopy.hasUnsavedChanges()) {
					workingCopy.commitWorkingCopy(true, monitor);
					workingCopy.discardWorkingCopy();
					workingCopy = null;
				} else {
					monitor.done();
				}
			} catch (JavaModelException e) {
				e.printStackTrace();
			}
		} else {
			monitor.done();
		}
		super.close(monitor);
	}
}
