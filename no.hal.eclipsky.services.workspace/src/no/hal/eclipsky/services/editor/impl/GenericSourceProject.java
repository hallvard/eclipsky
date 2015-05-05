package no.hal.eclipsky.services.editor.impl;

import java.util.HashMap;
import java.util.Map;

import no.hal.eclipsky.services.common.ProjectRef;
import no.hal.eclipsky.services.common.ResourceRef;
import no.hal.eclipsky.services.editor.RunResult;
import no.hal.eclipsky.services.editor.SourceEditor;
import no.hal.eclipsky.services.editor.SourceProject;
import no.hal.eclipsky.services.editor.TestResult;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.core.IStreamListener;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IStreamMonitor;
import org.eclipse.jdt.launching.IJavaLaunchConfigurationConstants;

public abstract class GenericSourceProject implements SourceProject {

	protected final ProjectRef projectRef;
	
	public GenericSourceProject(ProjectRef projectRef) {
		this.projectRef = projectRef;
	}
	
	@Override
	public ProjectRef getProjectRef() {
		return projectRef;
	}

	private Map<ResourceRef, SourceEditor> sourceEditors = null;
	
	protected SourceEditor createSourceEditor(ResourceRef editable) {
		return new GenericSourceEditor(editable);
	}

	@Override
	public SourceEditor getSourceEditor(ResourceRef resourceRef) {
		if (sourceEditors == null) {
			sourceEditors = new HashMap<ResourceRef, SourceEditor>();
		}
		SourceEditor sourceEditor = sourceEditors.get(resourceRef);
		if (sourceEditor == null) {
			sourceEditor = createSourceEditor(resourceRef);
			sourceEditors.put(resourceRef, sourceEditor);
		}
		return sourceEditor;
	}

	//
	
	protected Map<ResourceRef, ILaunchConfiguration> mainLaunchConfigs = new HashMap<>();
	protected Map<ResourceRef, ILaunchConfiguration> testLaunchConfigs = new HashMap<>();

	protected RunResult launch(ResourceRef resourceRef, String launchName, boolean isTest) {
		RunResult runResult = null;
		ILaunchConfiguration launchConfig;
		if (isTest) {
			launchConfig = testLaunchConfigs.get(resourceRef);
		} else {
			launchConfig = mainLaunchConfigs.get(resourceRef);
		}
		try {
			if (launchConfig == null) {
				launchConfig = createLaunchConfiguration(resourceRef, launchName, isTest);

				if (isTest) {
					testLaunchConfigs.put(resourceRef, launchConfig);
				} else {
					mainLaunchConfigs.put(resourceRef, launchConfig);
				}
			}
			if (launchConfig != null) {
				runResult = launch(resourceRef, launchConfig);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return runResult;
	}
	
	protected ILaunchConfiguration createLaunchConfiguration(ResourceRef resourceRef, String launchKey, boolean isTest) throws Exception {
		return null;
	}

	@Override
	public RunResult run(ResourceRef resourceRef) {
		return launch(resourceRef, "Run Main (" + resourceRef.getResourceName() + ")", false);
	}

	@Override
	public RunResult test(ResourceRef resourceRef) {
		return launch(resourceRef, "Run Tests (" + resourceRef.getResourceName() + ")", true);
	}

	// launching
	
	private ILaunch launch = null;
	
	private RunResult launch(ResourceRef resourceRef, ILaunchConfiguration launchConfiguration) throws CoreException {
		/*
		if (launch != null) {
			return null;
		}*/
		launch = launchConfiguration.launch(ILaunchManager.RUN_MODE, null);		
		StringBuilder outputBuffer = new StringBuilder(), errorBuffer = new StringBuilder();
		IProcess[] processes = launch.getProcesses();
		
		for (IProcess process : processes) {
			process.getStreamsProxy().getOutputStreamMonitor().addListener(new IStreamListener() {
				
				@Override
				public void streamAppended(String text, IStreamMonitor monitor) {
					outputBuffer.append(text);
					
				}
			});
			process.getStreamsProxy().getErrorStreamMonitor().addListener(new IStreamListener() {
				
				@Override
				public void streamAppended(String text, IStreamMonitor monitor) {
					errorBuffer.append(text);
					
				}
			});
		}
		
		// Wait for process to finish
		while (! launch.isTerminated()) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException ie) {
			}
		}
		
		// If any arguments have been passed in, assume test class
		String arguments = launchConfiguration.getAttribute(IJavaLaunchConfigurationConstants.ATTR_PROGRAM_ARGUMENTS, "");
		String qualifiedName = launchConfiguration.getAttribute(IJavaLaunchConfigurationConstants.ATTR_MAIN_TYPE_NAME, getQualifiedClassName(resourceRef));
		
		RunResult runResult;
		String error = errorBuffer.toString();
		if (!arguments.isEmpty() && error.isEmpty()) {
			runResult = new TestResult(qualifiedName);
		} else {
			runResult = new RunResult(qualifiedName);
		}		 
		runResult.setConsoleOutput(outputBuffer.toString());
		runResult.setErrorOutput(error);
		return runResult;
	}
	
	protected String getQualifiedClassName(ResourceRef resourceRef) {
		String simpleName = resourceRef.getResourceName();
		int pos = resourceRef.getResourceName().lastIndexOf('.');
		if (pos > 0) {
			simpleName = simpleName.substring(0, pos);
		}
		return resourceRef.getPackageName() + "." + simpleName;
	}
}
