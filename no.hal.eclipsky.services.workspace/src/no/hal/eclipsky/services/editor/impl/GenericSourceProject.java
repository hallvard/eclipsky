package no.hal.eclipsky.services.editor.impl;

import java.util.HashMap;
import java.util.Map;

import no.hal.eclipsky.services.common.ProjectRef;
import no.hal.eclipsky.services.common.ResourceRef;
import no.hal.eclipsky.services.editor.RunResult;
import no.hal.eclipsky.services.editor.SourceEditor;
import no.hal.eclipsky.services.editor.SourceProject;

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
	
	protected Map<ResourceRef, ILaunchConfiguration> launchConfigs = new HashMap<ResourceRef, ILaunchConfiguration>();

	protected RunResult launch(ResourceRef resourceRef, String launchKey, String launchName) {
		RunResult runResult = null;
		try {
			ILaunchConfiguration launchConfig = launchConfigs.get(resourceRef);
			if (launchConfig == null) {
				launchConfig = createLaunchConfiguration(resourceRef, launchKey, launchName);
				launchConfigs.put(resourceRef, launchConfig);
			}
			if (launchConfig != null) {
				runResult = launch(resourceRef, launchConfig);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return runResult;
	}
	
	protected ILaunchConfiguration createLaunchConfiguration(ResourceRef resourceRef, String launchKey, String launchName) throws Exception {
		return null;
	}

	protected abstract String getRunLaunchKey();
	protected abstract String getTestLaunchKey();

	@Override
	public RunResult run(ResourceRef resourceRef) {
		return launch(resourceRef, getRunLaunchKey(), "Run Main (" + resourceRef.getResourceName() + ")");
	}

	@Override
	public RunResult test(ResourceRef resourceRef) {
		return launch(resourceRef, getTestLaunchKey(), "Run Tests");
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
		
		while (! launch.isTerminated()) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException ie) {
			}
		}
		
		RunResult runResult = new RunResult(launchConfiguration.getAttribute(IJavaLaunchConfigurationConstants.ATTR_MAIN_TYPE_NAME, getQualifiedClassName(resourceRef)));
		runResult.setConsoleOutput(outputBuffer.toString());
		runResult.setErrorOutput(errorBuffer.toString());
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
