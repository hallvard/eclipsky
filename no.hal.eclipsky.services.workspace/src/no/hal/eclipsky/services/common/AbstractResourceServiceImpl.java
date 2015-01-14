package no.hal.eclipsky.services.common;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;

public class AbstractResourceServiceImpl {

	protected IWorkspaceRoot getWorkspaceRoot() {
		return ResourceHelper.getWorkspaceRoot();
	}

	protected IProject getProject(String projectName) {
		return ResourceHelper.getProject(projectName);
	}

	protected IFile getFile(String projectName, String packageName, String name, Boolean exists, String...  folders) {
		return ResourceHelper.getFile(projectName, packageName, name, exists, folders);
	}

	protected CharSequence getFileStringContent(IFile file) {
		return ResourceHelper.getFileStringContent(file);
	}

	protected void setFileStringContent(IFile file, CharSequence content) {
		ResourceHelper.getFileStringContent(file);
	}

	protected SourceFileMarker[] createSourceFileMarkers(IResource resource) {
		return ResourceHelper.createSourceFileMarkers(resource);
	}

	protected byte[] getFileBytesContent(IFile file) {
		return ResourceHelper.getFileBytesContent(file);
	}
}
