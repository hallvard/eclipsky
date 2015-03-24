package no.hal.eclipsky.services.editor.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

public class GenericSourceProject implements SourceProject {

	protected final ProjectRef projectRef;
	
	public GenericSourceProject(ProjectRef projectRef) {
		this.projectRef = projectRef;
	}
	
	@Override
	public ProjectRef getProjectRef() {
		return projectRef;
	}
	
	private ResourceRef runnable;
	
	public ResourceRef getRunnable() {
		return runnable;
	}
	
	public void setRunnable(ResourceRef runnable) {
		this.runnable = runnable;
	}
	
	private ResourceRef testable;

	public ResourceRef getTestable() {
		return testable;
	}
	
	public void setTestable(ResourceRef testable) {
		this.testable = testable;
	}

	private Collection<SourceEditor> sourceEditors = null;
	
	public void setEditable(ResourceRef... editables) {
		sourceEditors = new ArrayList<SourceEditor>();
		for (int i = 0; i < editables.length; i++) {
			SourceEditor sourceEditor = createSourceEditor(editables[i]);
			sourceEditors.add(sourceEditor);
		}
	}

	@Override
	public ResourceRef[] getEditables() {
		Collection<ResourceRef> resourceRefs = sourceEditors.stream().map(SourceEditor::getResourceRef).collect(Collectors.toList());
		return resourceRefs.toArray(new ResourceRef[resourceRefs.size()]);
	}
	
	protected SourceEditor createSourceEditor(ResourceRef editable) {
		return new GenericSourceEditor(editable);
	}

	@Override
	public SourceEditor getSourceEditor(ResourceRef resourceRef) {
		if (sourceEditors != null) {
			for (SourceEditor sourceEditor : sourceEditors) {
				if (sourceEditor.getResourceRef().equals(resourceRef)) {
					return sourceEditor;
				}
			}
		}
		return null;
	}

	//
	
	protected Map<ResourceRef, ILaunchConfiguration> launchConfigs = new HashMap<ResourceRef, ILaunchConfiguration>();

	protected RunResult launch(ResourceRef resourceRef, boolean result) {
		RunResult runResult = null;
		try {
			ILaunchConfiguration launchConfig = launchConfigs.get(resourceRef);
			if (launchConfig == null) {
				launchConfig = getLaunchConfiguration(resourceRef);
				launchConfigs.put(resourceRef, launchConfig);
			}
			if (launchConfig != null) {
				runResult = launch(resourceRef, launchConfig);
			}
		} catch (Exception e) {
		}
		return runResult;
	}
	
	protected ILaunchConfiguration getLaunchConfiguration(ResourceRef resourceRef) throws Exception {
		return null;
	}

	@Override
	public RunResult run(boolean result) {
		return launch(runnable, result);
	}

	@Override
	public RunResult test(boolean result) {
		return launch(testable, result);
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
