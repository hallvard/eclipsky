package no.hal.eclipsky.services.workspace.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.regex.Pattern;

import no.hal.eclipsky.services.common.AbstractResourcesServiceImpl;
import no.hal.eclipsky.services.workspace.WorkspaceService;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.launching.JavaRuntime;

public class WorkspaceServiceImpl extends AbstractResourcesServiceImpl implements WorkspaceService {

	private final static String[] TYPE_NATURES = {
		"java", JavaCore.NATURE_ID
	};
	
	private String findNature(String type) {
		for (int i = 0; i < TYPE_NATURES.length; i += 2) {
			if (TYPE_NATURES[i].equals(type)) {
				return TYPE_NATURES[i + 1];
			}
		}
		return null;
	}

	@Override
	public void ensureProject(String name, String... types) {
		Collection<String> natures = new ArrayList<String>();
		for (int i = 0; i < types.length; i++) {
			String nature = findNature(types[i]);
			if (nature != null) {
				natures.add(nature);
			}
		}
		try {
			ensureProjectInternal(name, natures.toArray(new String[natures.size()]));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private IProject ensureProjectInternal(String name, String... natures) throws CoreException {
		IWorkspaceRoot root = getWorkspaceRoot();
		IProject project = root.getProject(name);

		if (! project.exists()) {
			// inspired by https://sdqweb.ipd.kit.edu/wiki/JDT_Tutorial:_Creating_Eclipse_Java_Projects_Programmatically
			project.create(null);
			project.open(null);

			// Because we need a java project, we have to set the Java nature to the created project:
			IProjectDescription description = project.getDescription();
			description.setNatureIds(natures);
			project.setDescription(description, null);

			// should be handled by the emfs model, i.e. as .project and .classpath resources
			if (natures != null && Arrays.asList(natures).contains(JavaCore.NATURE_ID)) {
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
//						JavaCore.newContainerEntry(JUnitCore.JUNIT3_CONTAINER_PATH),
						JavaCore.newSourceEntry(sourceFolder.getFullPath())
				};
				javaProject.setRawClasspath(buildPath, binFolder.getFullPath(), null);
			}
		}
		return project;
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
}
