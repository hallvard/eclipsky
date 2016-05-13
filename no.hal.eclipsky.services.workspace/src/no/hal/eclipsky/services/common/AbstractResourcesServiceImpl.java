package no.hal.eclipsky.services.common;

import no.hal.eclipsky.services.workspace.ResourcesService;
import no.hal.eclipsky.services.workspace.model.SourceFileMarker;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

public class AbstractResourcesServiceImpl implements ResourcesService {

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
		ResourceHelper.setFileStringContent(file, content);
	}

	protected SourceFileMarker[] createSourceFileMarkers(IResource resource) {
		return ResourceHelper.createSourceFileMarkers(resource);
	}

	protected byte[] getFileBytesContent(IFile file) {
		return ResourceHelper.getFileBytesContent(file);
	}
	
	@Override
	public void visitResources(ResourceVisitor visitor, int depth, ResourceRef resourceRef) {
		String projectName = resourceRef.getProjectName();
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
		if (project != null && project.exists()) {
			for (String sourceFolderName : ResourceHelper.SOURCE_AND_TEST_FOLDER_NAMES) {
				String packageRoot = IPath.SEPARATOR + sourceFolderName;
				visitResource(visitor, depth, project, packageRoot, resourceRef.getPackageName(), resourceRef.getResourceName());
				visitor.visit(new ResourceRef(projectName, null, null));
			}
		}
	}

	private void visitResource(ResourceVisitor visitor, int depth, IProject project, String packageRoot, String packageName, String resourceName) {
		String projectName = project.getName();
		String pathString = packageRoot;
		if (packageName != null) {
			pathString += IPath.SEPARATOR + packageName.replace('.', IPath.SEPARATOR);
		}
		if (resourceName != null) {
			IFile file = project.getFile(new Path(pathString + IPath.SEPARATOR + resourceName));
			if (file != null && file.exists()) {
				visitor.visit(new ResourceRef(projectName, packageName, resourceName));
			}
		} else {
			IFolder folder = project.getFolder(new Path(pathString));
			if (folder != null && folder.exists()) {
				visitor.visit(new ResourceRef(projectName, packageName, resourceName));
				if (depth != 0) {
					try {
						IResource[] children = folder.members();
						for (int k = 0; k < children.length; k++) {
							if (children[k] instanceof IFolder) {
								String subPackageName = children[k].getName();
								if (packageName != null) {
									subPackageName = packageName + "." + subPackageName;
								}
								visitResource(visitor, depth - 1, project, packageRoot, subPackageName, null);
							} else {
								visitResource(visitor, depth - 1, project, packageRoot, packageName, children[k].getName());
							}
						}
					} catch (CoreException e) {
					}
				}
			}
		}
	}
}
