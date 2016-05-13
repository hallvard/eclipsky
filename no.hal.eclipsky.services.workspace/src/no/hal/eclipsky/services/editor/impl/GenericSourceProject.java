package no.hal.eclipsky.services.editor.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.core.IStreamListener;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IStreamMonitor;
import org.eclipse.jdt.launching.IJavaLaunchConfigurationConstants;

import no.hal.eclipsky.services.common.ProjectRef;
import no.hal.eclipsky.services.common.ResourceRef;
import no.hal.eclipsky.services.editor.SourceEditor;
import no.hal.eclipsky.services.editor.SourceProject;
import no.hal.eclipsky.services.workspace.model.ExecutionResult;
import no.hal.eclipsky.services.workspace.model.ModelFactory;
import no.hal.eclipsky.services.workspace.model.ResultKind;
import no.hal.eclipsky.services.workspace.model.TestCaseResult;
import no.hal.eclipsky.services.workspace.model.TestResult;
import no.hal.emfs.AbstractStringContents;
import no.hal.emfs.EmfsFactory;

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

	protected void foreachSourceEditor(Consumer<SourceEditor> fun) {
		if (sourceEditors != null) {
			sourceEditors.values().forEach(fun);
		}
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

	protected ExecutionResult launch(ResourceRef resourceRef, String launchName, boolean isTest) {
		ExecutionResult runResult = null;
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
	public ExecutionResult run(ResourceRef resourceRef) {
		return launch(resourceRef, "Run Main (" + resourceRef.getResourceName() + ")", false);
	}

	@Override
	public ExecutionResult test(ResourceRef resourceRef) {
		return launch(resourceRef, "Run Tests (" + resourceRef.getResourceName() + ")", true);
	}

	// launching
	
	private ILaunch launch = null;
	
	private ExecutionResult launch(ResourceRef resourceRef, ILaunchConfiguration launchConfiguration) throws CoreException {
		/*
		if (launch != null) {
			return null;
		}*/
		launch = launchConfiguration.launch(ILaunchManager.RUN_MODE, null);		
		StringBuilder outputBuffer = new StringBuilder(), errorBuffer = new StringBuilder();
		IProcess[] processes = launch.getProcesses();
		
		for (IProcess process : processes) {
			process.getStreamsProxy().getOutputStreamMonitor().addListener(new StreamBufferAppender(outputBuffer));
			process.getStreamsProxy().getErrorStreamMonitor().addListener(new StreamBufferAppender(errorBuffer));
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
		
		ExecutionResult runResult;
		String error = errorBuffer.toString(), out = outputBuffer.toString();
		if ((! arguments.isEmpty()) && error.isEmpty()) {
			TestResult testResult = ModelFactory.eINSTANCE.createTestResult();
			updateTestCaseResults(out, testResult);
			runResult = testResult;
		} else {
			runResult = ModelFactory.eINSTANCE.createExecutionResult();
		}		 
		runResult.setQualifiedName(qualifiedName);
		AbstractStringContents outputContents = EmfsFactory.eINSTANCE.createVerbatimStringContents();
		outputContents.setStringContent(outputBuffer.toString());
		runResult.setSysout(outputContents);
		AbstractStringContents errorContents = EmfsFactory.eINSTANCE.createVerbatimStringContents();
		errorContents.setStringContent(error);
		runResult.setSyserr(errorContents);
		return runResult;
	}
	
	private void updateTestCaseResults(String consoleOutput, TestResult testResult) {
		String[] lines = consoleOutput.split("\n");
		ResultKind status = ResultKind.SUCCESS;
		for (int i = 0; i < lines.length - 1; i++) {
			String line = lines[i].trim();
			if (line.isEmpty()) {
				continue;
			}
			String testName = null, exception = "";
			if (line.charAt(0) == '*') {
				testName = lines[++i];
				switch (lines[++i].charAt(0)) {
				case 'F':
					status = ResultKind.FAILURE;
					break;
				case 'E':
					status = ResultKind.ERROR;
					break;
				default:
					status = ResultKind.SUCCESS;
					break;
				}
				exception = lines[++i];
				while (i + 1 < lines.length && (! lines[i + 1].isEmpty()) && lines[i + 1].charAt(0) != '*') {
					exception += "\n" + lines[++i];
				}
			}
			TestCaseResult testCaseResult = ModelFactory.eINSTANCE.createTestCaseResult();
			testCaseResult.setTestName(testName);
			testCaseResult.setKind(status);
			testCaseResult.setException(exception);
			testResult.getResults().add(testCaseResult);
		}
	}
	
	private static class StreamBufferAppender implements IStreamListener {
		final StringBuilder buffer;
		public StreamBufferAppender(StringBuilder buffer) {
			super();
			this.buffer = buffer;
		}
		@Override
		public void streamAppended(String text, IStreamMonitor monitor) {
			buffer.append(text);
		}
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
