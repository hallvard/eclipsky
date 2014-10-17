package no.hal.eclipsky.services.workspace.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.regex.Pattern;

import no.hal.eclipsky.services.workspace.EnsureJavaProject;
import no.hal.eclipsky.services.workspace.ListProjects;
import no.hal.eclipsky.services.workspace.ProjectList;
import no.hal.eclipsky.services.workspace.WorkspaceService;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.junit.JUnitCore;
import org.eclipse.jdt.launching.JavaRuntime;

public class WorkspaceServiceImpl implements WorkspaceService {

	public void ensureProject(EnsureJavaProject message) throws CoreException {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IProject project = root.getProject(message.name);
		
		if (! project.exists()) {
			// inspired by https://sdqweb.ipd.kit.edu/wiki/JDT_Tutorial:_Creating_Eclipse_Java_Projects_Programmatically
			project.create(null);
			project.open(null);
			
			// Because we need a java project, we have to set the Java nature to the created project:
			IProjectDescription description = project.getDescription();
			Collection<String> natures = new ArrayList<String>(message.natures != null ? Arrays.asList(message.natures) : Collections.emptyList());
			if (! natures.contains(JavaCore.NATURE_ID)) {
				natures.add(JavaCore.NATURE_ID);
			}
			description.setNatureIds(natures.toArray(new String[natures.size()]));
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
	
	public ProjectList getProjectList(ListProjects message) {
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects(IProject.NONE);
		Collection<String> projectNames = new ArrayList<String>();
		Pattern pattern = null;
		try {
			pattern = Pattern.compile(message.namePattern);
		} catch (Exception e) {
		}
		for (IProject project : projects) {
			String name = project.getName();
			boolean acceptName = pattern == null || pattern.matcher(name).matches();
			boolean acceptNature = true;
			try {
				acceptNature = (message.nature == null || project.hasNature(message.nature));
			} catch (CoreException e) {
			}
			if (acceptName && acceptNature) {
				projectNames.add(name);
			}
		}
		return new ProjectList(projectNames.toArray(new String[projectNames.size()]));
	}
}
