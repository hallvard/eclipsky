package no.hal.eclipsky.services.workspace.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.regex.Pattern;

import no.hal.eclipsky.services.common.AbstractResourceServiceImpl;
import no.hal.eclipsky.services.common.ResourceRef;
import no.hal.eclipsky.services.common.SourceFileMarker;
import no.hal.eclipsky.services.workspace.WorkspaceService;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.junit.JUnitCore;
import org.eclipse.jdt.launching.JavaRuntime;

public class WorkspaceServiceImpl extends AbstractResourceServiceImpl implements WorkspaceService, IResourceChangeListener, IResourceDeltaVisitor {

	public void ensureProject(String name, String type) {
		try {
			ensureProjectInteral(name, type);
		} catch (CoreException e) {
			throw new RuntimeException(e);
		}
	}

	private void ensureProjectInteral(String name, String... natures) throws CoreException {
		IWorkspaceRoot root = getWorkspaceRoot();
		IProject project = root.getProject(name);

		if (! project.exists()) {
			// inspired by https://sdqweb.ipd.kit.edu/wiki/JDT_Tutorial:_Creating_Eclipse_Java_Projects_Programmatically
			project.create(null);
			project.open(null);

			// Because we need a java project, we have to set the Java nature to the created project:
			IProjectDescription description = project.getDescription();
			Collection<String> natureList = new ArrayList<String>(natures != null ? Arrays.asList(natures) : Collections.emptyList());
			if (! natureList.contains(JavaCore.NATURE_ID)) {
				natureList.add(JavaCore.NATURE_ID);
			}
			description.setNatureIds(natureList.toArray(new String[natureList.size()]));
			project.setDescription(description, null);

			// Now we can create our Java project
			IJavaProject javaProject = JavaCore.create(project); 

			// However, it's not enough if we want to add Java source code to the project. We have to set the Java build path:
			// (1) We first specify the output location of the compiler (the bin folder):
			IFolder binFolder = project.getFolder("bin");
			binFolder.create(false, true, null);
			javaProject.setOutputLocation(binFolder.getFullPath(), null);

			// (2) We have not yet the source folder created:
			IFolder sourceFolder = project.getFolder("src");
			sourceFolder.create(false, true, null);

			// (3) Define the class path entries. Class path entries define the roots of package fragments. Note that you might have to include the necessary plugin "org.eclipse.jdt.launching".
			IClasspathEntry[] buildPath = {
					JavaRuntime.getDefaultJREContainerEntry(),
					JavaCore.newContainerEntry(JUnitCore.JUNIT3_CONTAINER_PATH),
					JavaCore.newSourceEntry(sourceFolder.getFullPath())
			};
			javaProject.setRawClasspath(buildPath, binFolder.getFullPath(), null);
		}
	}

	public String[] getProjectList(String namePattern, String type) {
		IProject[] projects = getWorkspaceRoot().getProjects(IProject.NONE);
		Collection<String> projectNames = new ArrayList<String>();
		Pattern pattern = null;
		try {
			pattern = Pattern.compile(namePattern);
		} catch (Exception e) {
		}
		for (IProject project : projects) {
			String name = project.getName();
			boolean acceptName = pattern == null || pattern.matcher(name).matches();
			boolean acceptNature = true;
			try {
				acceptNature = (type == null || project.hasNature(type));
			} catch (CoreException e) {
			}
			if (acceptName && acceptNature) {
				projectNames.add(name);
			}
		}
		return projectNames.toArray(new String[projectNames.size()]);
	}

	private static String[] SOURCE_FOLDER_NAMES = {"src", "resources"};
	
	protected String[] getSourceFolderNames() {
		return SOURCE_FOLDER_NAMES;
	}
	
	protected String getSourceFile(String projectName, String packageName, String resourceName) {
		IFile file = getFile(projectName, packageName, resourceName, true, getSourceFolderNames());
		return (file != null ? getFileStringContent(file).toString() : null);
	}

	@Override
	public String getSourceFile(ResourceRef resourceRef) {
		return getSourceFile(resourceRef.getProjectName(), resourceRef.getPackageName(), resourceRef.getResourceName());
	}

	protected SourceFileMarker[] getSourceFileMarkers(String projectName, String packageName, String resourceName, boolean build) {
		IFile file = getFile(projectName, packageName, resourceName, true, getSourceFolderNames());
		if (build) {
		}
		return createSourceFileMarkers(file);
	}

	@Override
	public SourceFileMarker[] getSourceFileMarkers(ResourceRef resourceRef, boolean build) {
		return getSourceFileMarkers(resourceRef.getProjectName(), resourceRef.getPackageName(), resourceRef.getResourceName(),
				build);
	}

	protected SourceFileMarker[] updateSourceFile(String projectName, String packageName, String resourceName, String stringContent, Boolean exists, Boolean markers) {
		IFile file = getFile(projectName, packageName, resourceName, exists, getSourceFolderNames());
		Future<SourceFileMarker[]> future = null;
		if (Boolean.TRUE.equals(markers)) {
			future = ensureResourceFuture(file);
		}
		setFileStringContent(file, stringContent);
		if (markers == null) {
			return null;
		} else {
			if (future != null) {
				try {
					SourceFileMarker[] sourceFileMarkers = future.get();
					return sourceFileMarkers;
				} catch (Exception e) {
				}
			}
			return createSourceFileMarkers(file);
		}
	}

	public SourceFileMarker[] updateSourceFile(ResourceRef resourceRef, String stringContent, Boolean exists, Boolean markers) {
		return updateSourceFile(resourceRef.getProjectName(), resourceRef.getPackageName(), resourceRef.getResourceName(),
				stringContent, exists, markers);
	}
	
	protected byte[] getResource(String projectName, String packageName, String resourceName) {
		IFile file = getFile(projectName, packageName, resourceName, true, getSourceFolderNames());
		return (file != null ? getFileBytesContent(file) : null);
	}

	@Override
	public byte[] getResource(ResourceRef resourceRef) {
		return getResource(resourceRef.getProjectName(), resourceRef.getPackageName(), resourceRef.getResourceName());
	}

	//

	private Map<IResource, CompletableFuture<SourceFileMarker[]>> resourceMarkers;
	
	private Future<SourceFileMarker[]> ensureResourceFuture(IFile file) {
		if (resourceMarkers == null) {
			resourceMarkers = new HashMap<IResource, CompletableFuture<SourceFileMarker[]>>();
			ResourcesPlugin.getWorkspace().addResourceChangeListener(this, IResourceChangeEvent.POST_BUILD);
		}
		CompletableFuture<SourceFileMarker[]> future = resourceMarkers.get(file);
		if (future == null) {
			future = new CompletableFuture<SourceFileMarker[]>();
			resourceMarkers.put(file, future);
		}
		return future;
	}

	@Override
	public void resourceChanged(IResourceChangeEvent event) {
		IResource resource = event.getResource();
		if (! handleChangedResource(resource)) {
			IResourceDelta delta = event.getDelta();
			if (delta != null) {
				try {
					delta.accept(this);
				} catch (CoreException e) {
				}
			}
		}
	}

	@Override
	public boolean visit(IResourceDelta delta) throws CoreException {
		IResource resource = delta.getResource();
		if (handleChangedResource(resource)) {
		}
		return true;
	}

	protected boolean handleChangedResource(IResource resource) {
		if (resourceMarkers != null && resourceMarkers.containsKey(resource)) {
			CompletableFuture<SourceFileMarker[]> future = resourceMarkers.get(resource);
			resourceMarkers.remove(resource);
			if (resourceMarkers.isEmpty()) {
				resourceMarkers = null;
				ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);
			}
			if (future.complete(createSourceFileMarkers(resource))) {
			}
			return true;
		}
		return false;
	}
}
