package no.hal.eclipsky.services.workspace.impl;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.regex.Pattern;

import no.hal.eclipsky.services.workspace.WorkspaceService;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.junit.JUnitCore;
import org.eclipse.jdt.launching.JavaRuntime;

public class WorkspaceServiceImpl implements WorkspaceService {

	public WorkspaceServiceImpl() {
		System.out.println("WorkspaceServiceImpl: constructed");
	}
	
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
	
	protected IWorkspaceRoot getWorkspaceRoot() {
		return ResourcesPlugin.getWorkspace().getRoot();
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

	protected IProject getProject(String projectName) {
		return getWorkspaceRoot().getProject(projectName);
	}
	
	protected IFile getFile(String projectName, String packageName, String name, Boolean exists, String...  folders) {
		IProject project = getProject(projectName);
		for (int i = 0; i < folders.length; i++) {
			IPath path = new Path(IPath.SEPARATOR + folders[i] + IPath.SEPARATOR + packageName.replace('.', IPath.SEPARATOR) + IPath.SEPARATOR + name);
			IFile file = project.getFile(path);
			if (exists != null) {
				if (exists == file.exists()) {
					return file;
				}
			} else {
				return file;
			}			
		}
		return null;
	}
	
	@Override
	public String getSourceFile(String projectName, String packageName, String resourceName) {
		IFile file = getFile(projectName, packageName, resourceName, true, "src", "resources");
		return (file != null ? getFileContentString(file) : null);
	}

	protected String getFileContentString(IFile file) {
		StringBuilder buffer = new StringBuilder();
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(file.getContents()));
			String line = null;
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
				buffer.append("\n");
			}
		} catch (Exception e) {
			buffer.append(e.getMessage());
		}
		return buffer.toString();
	}

	private byte[] byteBuffer = new byte[2048];
	
	protected byte[] getFileContentBytes(IFile file) {
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		try {
			InputStream input = file.getContents();
			int len = 0;
			while ((len = input.read(byteBuffer)) >= 0) {
				buffer.write(byteBuffer, 0, len);
			}
		} catch (Exception e) {
		}
		return buffer.toByteArray();
	}
	
	@Override
	public byte[] getResource(String projectName, String packageName, String resourceName) {
		IFile file = getFile(projectName, packageName, resourceName, true, "src", "resources");
		return (file != null ? getFileContentBytes(file) : null);
	}
}
