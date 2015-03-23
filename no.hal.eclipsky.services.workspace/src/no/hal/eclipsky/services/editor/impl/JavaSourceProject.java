package no.hal.eclipsky.services.editor.impl;

import no.hal.eclipsky.services.common.ProjectRef;
import no.hal.eclipsky.services.common.ResourceRef;
import no.hal.eclipsky.services.editor.SourceEditor;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.jdt.launching.IJavaLaunchConfigurationConstants;

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

	// launching

	private static String javaApplicationLaunchId = IJavaLaunchConfigurationConstants.ID_JAVA_APPLICATION;
	private static String junitTestLaunchId = "org.eclipse.jdt.junit.launchconfig";

	protected ILaunchConfiguration getLaunchConfiguration(ResourceRef resourceRef) throws Exception {
		if (getRunnable().equals(resourceRef)) {
			return createLaunchConfiguration(javaApplicationLaunchId, "Run Main", resourceRef);
		} else if (getTestable().equals(resourceRef)) {
			return createLaunchConfiguration(junitTestLaunchId, "Run Tests", resourceRef);
		}
		return null;
	}
	
	private ILaunchConfiguration createLaunchConfiguration(String launchConfigurationTypeId, String configName, ResourceRef resourceRef) throws CoreException {
		ILaunchManager launchManager = DebugPlugin.getDefault().getLaunchManager();
		ILaunchConfigurationType launchConfigurationType = launchManager.getLaunchConfigurationType(launchConfigurationTypeId);
		ILaunchConfigurationWorkingCopy workingCopy = launchConfigurationType.newInstance(null, configName);
		workingCopy.setAttribute(IJavaLaunchConfigurationConstants.ATTR_PROJECT_NAME, resourceRef.getProjectName());
		workingCopy.setAttribute(IJavaLaunchConfigurationConstants.ATTR_MAIN_TYPE_NAME, getQualifiedClassName(resourceRef));
		return workingCopy.doSave();
	}
}
