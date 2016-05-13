package no.hal.eclipsky.services.editor.impl;

import java.util.concurrent.CompletableFuture;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.jdt.launching.IJavaLaunchConfigurationConstants;

import no.hal.eclipsky.services.common.ProjectRef;
import no.hal.eclipsky.services.common.ResourceRef;
import no.hal.eclipsky.services.editor.SourceEditor;
import no.hal.eclipsky.services.workspace.model.ExecutionResult;

public class JavaSourceProject extends GenericSourceProject {

	public JavaSourceProject(ProjectRef projectRef) {
		super(projectRef);
	}

	@Override
	protected SourceEditor createSourceEditor(ResourceRef editable) {
		if (editable.getResourceName().endsWith(".java")) {
			return new JavaSourceEditor(editable);
		}
		return super.createSourceEditor(editable);
	}
	
	protected boolean ensureBuildComplete(ResourceRef resourceRef) {
		CompletableFuture<Boolean> future = new CompletableFuture<Boolean>();
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(resourceRef.getProjectName());
		try {
			project.build(IncrementalProjectBuilder.INCREMENTAL_BUILD, new NullProgressMonitor(){		
				@Override
				public void done() {
					future.complete(! isCanceled());
				}
			});
		} catch (CoreException e1) {
			future.complete(false);
			e1.printStackTrace();
		}
		// Wait for feature to build
		boolean buildSuccessfull = false;
		try {
			buildSuccessfull = future.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return buildSuccessfull;
	}
	
	private void saveAllSourceEditors() {
		foreachSourceEditor(sourceEditor -> { sourceEditor.close(new NullProgressMonitor());});
	}

	@Override
	public ExecutionResult run(ResourceRef resourceRef) {
		saveAllSourceEditors();
		if (ensureBuildComplete(resourceRef)) {
			return super.run(resourceRef);
		}
		return null;
	}

	@Override
	public ExecutionResult test(ResourceRef resourceRef) {
		saveAllSourceEditors();
		if (ensureBuildComplete(resourceRef)) {
			return super.test(resourceRef);
		}
		return null;
	}
	
	

	// launching

	private static String javaApplicationLaunchId = IJavaLaunchConfigurationConstants.ID_JAVA_APPLICATION;	
	private static String testRunner = "no.hal.eclipsky.testing.ExpressiveTestRunner";
	
	@Override
	protected ILaunchConfiguration createLaunchConfiguration(ResourceRef resourceRef, String configName, boolean isTest) throws CoreException {		
		ILaunchManager launchManager = DebugPlugin.getDefault().getLaunchManager();
		ILaunchConfigurationType launchConfigurationType = launchManager.getLaunchConfigurationType(javaApplicationLaunchId);
		ILaunchConfigurationWorkingCopy workingCopy = launchConfigurationType.newInstance(null, configName);
		workingCopy.setAttribute(IJavaLaunchConfigurationConstants.ATTR_PROJECT_NAME, projectRef.getProjectName());
		if (isTest) {
			workingCopy.setAttribute(
					IJavaLaunchConfigurationConstants.ATTR_PROGRAM_ARGUMENTS, 
					getQualifiedClassName(resourceRef) + "Test"
			);
			workingCopy.setAttribute(
					IJavaLaunchConfigurationConstants.ATTR_MAIN_TYPE_NAME, 
					testRunner
			);
		} else {
			workingCopy.setAttribute(
					IJavaLaunchConfigurationConstants.ATTR_MAIN_TYPE_NAME, 
					getQualifiedClassName(resourceRef)
			);
		}
		
		workingCopy.setAttribute("IS_TEST", isTest);		
		return workingCopy.doSave();
	}
	
	
}
