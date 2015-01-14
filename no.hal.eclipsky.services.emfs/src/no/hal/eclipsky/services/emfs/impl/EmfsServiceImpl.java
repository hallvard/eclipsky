package no.hal.eclipsky.services.emfs.impl;

import java.util.Collection;

import no.hal.eclipsky.services.emfs.EmfsService;
import no.hal.emfs.EmfsContainer;
import no.hal.emfs.EmfsContainerContentProvider;
import no.hal.emfs.EmfsFile;
import no.hal.emfs.EmfsResource;
import no.hal.emfs.util.CompositeImportSupport;
import no.hal.emfs.util.ImportSupport;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;

public class EmfsServiceImpl implements EmfsService {

	private CompositeImportSupport importSupports = new CompositeImportSupport();
	
	public void addImportSupport(ImportSupport importSupport) {
		importSupports.addImportSupport(importSupport);
	}

	public void removeImportSupport(ImportSupport importSupport) {
		importSupports.removeImportSupport(importSupport);
	}
	
	public void importResources(Collection<EmfsResource> emfsResources, String projectName, boolean overwrite, IProgressMonitor monitor) {
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
		importResources(emfsResources, project, false, overwrite, monitor);
	}

	private void importResources(Collection<EmfsResource> emfsResources, IContainer target, boolean ensureContainers, boolean overwrite, IProgressMonitor monitor) {
		for (EmfsResource emfsResource : emfsResources) {
			if (ensureContainers) {
			}
			importResources(emfsResource, target, ensureContainers, overwrite, monitor);
		}
	}

	private IContainer ensureContainers(EmfsContainer emfsContainer, IContainer target, boolean overwrite, IProgressMonitor monitor) {
		if (emfsContainer != null) {
			target = ensureContainers(emfsContainer.getContainer(), target, overwrite, monitor);
			target = ensureContainer(emfsContainer, target, overwrite, monitor);
		}
		return target;
	}

	private IContainer ensureContainer(EmfsContainer emfsContainer, IContainer target, boolean overwrite, IProgressMonitor monitor) {
		String name = emfsContainer.getName();
		if (name != null) {
			target = ensureFolder(name, target, monitor);
		}
		if (emfsContainer.getContentProvider() != null) {
			ensureContainer(emfsContainer.getContentProvider(), target, overwrite, monitor);
		}
		if (monitor != null) {
			monitor.worked(1);
		}
		return target;
	}

	private void ensureContainer(EmfsContainerContentProvider contentProvider, IContainer target, boolean overwrite, IProgressMonitor monitor) {
		EList<EmfsResource> resources = contentProvider.importContent(importSupports);
		importResources(resources, target, false, overwrite, monitor);
	}

	private IFolder ensureFolder(String name, IContainer target, IProgressMonitor monitor) {
		IFolder folder = target.getFolder(new Path(name));
		if (! folder.exists()) {
			try {
				folder.create(IResource.NONE, true, null);
			} catch (CoreException e) {
				throwException(folder, target, e, monitor);
			}
		}
		return folder;
	}

	private void importResources(EmfsResource emfsResource, IContainer target, boolean ensureContainers, boolean overwrite, IProgressMonitor monitor) {
		if (ensureContainers) {
			target = ensureContainers(emfsResource.getContainer(), target, overwrite, monitor);
		}
		String name = emfsResource.getName();
		if (emfsResource instanceof EmfsContainer) {
			if (name != null) {
				target = ensureContainer((EmfsContainer) emfsResource, target, overwrite, monitor);
			}
			importResources(((EmfsContainer) emfsResource).getResources(), target, false, overwrite, monitor);
		} else if (emfsResource instanceof EmfsFile) {
			if (name != null) {
				IFile file = target.getFile(new Path(name));
				try {
					if (! file.exists()) {
						file.create(((EmfsFile) emfsResource).getInputStream(IResource.NONE), true, null);
					} else if (overwrite) {
						file.setContents(((EmfsFile) emfsResource).getInputStream(IResource.NONE), true, false, null);
					}
				} catch (CoreException e) {
					throwException(file, target, e, monitor);
				}
			}
			if (monitor != null) {
				monitor.worked(1);
			}
		}
	}

	private static void throwException(IResource resource, IContainer target, Exception e, IProgressMonitor monitor) {
		String resourceType = "resource";
		if (resource instanceof IFolder) {
			resourceType = "folder";
		} else if (resource instanceof IFile) {
			resourceType = "file";
		}
		monitor.setCanceled(true);
		throw new RuntimeException("Exception when creating " + resource.getName() + " " + resourceType + " in " + target.getFullPath(), e);
	}
}
