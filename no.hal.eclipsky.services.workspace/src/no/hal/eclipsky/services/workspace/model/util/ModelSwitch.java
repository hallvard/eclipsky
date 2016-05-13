/**
 */
package no.hal.eclipsky.services.workspace.model.util;

import no.hal.eclipsky.services.workspace.model.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see no.hal.eclipsky.services.workspace.model.ModelPackage
 * @generated
 */
public class ModelSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ModelPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelSwitch() {
		if (modelPackage == null) {
			modelPackage = ModelPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ModelPackage.ABSTRACT_SERVICE: {
				AbstractService abstractService = (AbstractService)theEObject;
				T result = caseAbstractService(abstractService);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.PROJECT_SERVICE: {
				ProjectService projectService = (ProjectService)theEObject;
				T result = caseProjectService(projectService);
				if (result == null) result = caseAbstractService(projectService);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.RESOURCE_SERVICE: {
				ResourceService resourceService = (ResourceService)theEObject;
				T result = caseResourceService(resourceService);
				if (result == null) result = caseAbstractService(resourceService);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.ENSURE_PROJECT_SERVICE: {
				EnsureProjectService ensureProjectService = (EnsureProjectService)theEObject;
				T result = caseEnsureProjectService(ensureProjectService);
				if (result == null) result = caseProjectService(ensureProjectService);
				if (result == null) result = caseAbstractService(ensureProjectService);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.PROJECT_LIST_SERVICE: {
				ProjectListService projectListService = (ProjectListService)theEObject;
				T result = caseProjectListService(projectListService);
				if (result == null) result = caseAbstractService(projectListService);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.PROJECT_RESPONSE_OPTIONS: {
				ProjectResponseOptions projectResponseOptions = (ProjectResponseOptions)theEObject;
				T result = caseProjectResponseOptions(projectResponseOptions);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.RESOURCE_RESPONSE_OPTIONS: {
				ResourceResponseOptions resourceResponseOptions = (ResourceResponseOptions)theEObject;
				T result = caseResourceResponseOptions(resourceResponseOptions);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.PROJECT_INFO: {
				ProjectInfo projectInfo = (ProjectInfo)theEObject;
				T result = caseProjectInfo(projectInfo);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.RESOURCE_INFO: {
				ResourceInfo resourceInfo = (ResourceInfo)theEObject;
				T result = caseResourceInfo(resourceInfo);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.SOURCE_EDITOR_SERVICE: {
				SourceEditorService sourceEditorService = (SourceEditorService)theEObject;
				T result = caseSourceEditorService(sourceEditorService);
				if (result == null) result = caseResourceService(sourceEditorService);
				if (result == null) result = caseAbstractService(sourceEditorService);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.RESOURCE_INFO_SERVICE: {
				ResourceInfoService resourceInfoService = (ResourceInfoService)theEObject;
				T result = caseResourceInfoService(resourceInfoService);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.REFRESH_EDITOR_SERVICE: {
				RefreshEditorService refreshEditorService = (RefreshEditorService)theEObject;
				T result = caseRefreshEditorService(refreshEditorService);
				if (result == null) result = caseSourceEditorService(refreshEditorService);
				if (result == null) result = caseResourceService(refreshEditorService);
				if (result == null) result = caseAbstractService(refreshEditorService);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.MARKERS_EDITOR_SERVICE: {
				MarkersEditorService markersEditorService = (MarkersEditorService)theEObject;
				T result = caseMarkersEditorService(markersEditorService);
				if (result == null) result = caseSourceEditorService(markersEditorService);
				if (result == null) result = caseResourceService(markersEditorService);
				if (result == null) result = caseAbstractService(markersEditorService);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.UPDATE_EDITOR_SERVICE: {
				UpdateEditorService updateEditorService = (UpdateEditorService)theEObject;
				T result = caseUpdateEditorService(updateEditorService);
				if (result == null) result = caseMarkersEditorService(updateEditorService);
				if (result == null) result = caseSourceEditorService(updateEditorService);
				if (result == null) result = caseResourceService(updateEditorService);
				if (result == null) result = caseAbstractService(updateEditorService);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.FILE_MARKER: {
				FileMarker fileMarker = (FileMarker)theEObject;
				T result = caseFileMarker(fileMarker);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.SOURCE_FILE_MARKER: {
				SourceFileMarker sourceFileMarker = (SourceFileMarker)theEObject;
				T result = caseSourceFileMarker(sourceFileMarker);
				if (result == null) result = caseFileMarker(sourceFileMarker);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.COMPLETION_EDITOR_SERVICE: {
				CompletionEditorService completionEditorService = (CompletionEditorService)theEObject;
				T result = caseCompletionEditorService(completionEditorService);
				if (result == null) result = caseSourceEditorService(completionEditorService);
				if (result == null) result = caseResourceService(completionEditorService);
				if (result == null) result = caseAbstractService(completionEditorService);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.COMPLETION_PROPOSAL: {
				CompletionProposal completionProposal = (CompletionProposal)theEObject;
				T result = caseCompletionProposal(completionProposal);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.CLOSE_EDITOR_SERVICE: {
				CloseEditorService closeEditorService = (CloseEditorService)theEObject;
				T result = caseCloseEditorService(closeEditorService);
				if (result == null) result = caseResourceService(closeEditorService);
				if (result == null) result = caseAbstractService(closeEditorService);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.EXECUTION_SERVICE: {
				ExecutionService executionService = (ExecutionService)theEObject;
				T result = caseExecutionService(executionService);
				if (result == null) result = caseResourceService(executionService);
				if (result == null) result = caseAbstractService(executionService);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.EXECUTION_RESULT: {
				ExecutionResult executionResult = (ExecutionResult)theEObject;
				T result = caseExecutionResult(executionResult);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.RUN_EDITOR_SERVICE: {
				RunEditorService runEditorService = (RunEditorService)theEObject;
				T result = caseRunEditorService(runEditorService);
				if (result == null) result = caseExecutionService(runEditorService);
				if (result == null) result = caseResourceService(runEditorService);
				if (result == null) result = caseAbstractService(runEditorService);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.TEST_EDITOR_SERVICE: {
				TestEditorService testEditorService = (TestEditorService)theEObject;
				T result = caseTestEditorService(testEditorService);
				if (result == null) result = caseExecutionService(testEditorService);
				if (result == null) result = caseResourceService(testEditorService);
				if (result == null) result = caseAbstractService(testEditorService);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.TEST_RESULT: {
				TestResult testResult = (TestResult)theEObject;
				T result = caseTestResult(testResult);
				if (result == null) result = caseExecutionResult(testResult);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.TEST_CASE_RESULT: {
				TestCaseResult testCaseResult = (TestCaseResult)theEObject;
				T result = caseTestCaseResult(testCaseResult);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Service</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Service</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractService(AbstractService object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Project Service</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Project Service</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProjectService(ProjectService object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource Service</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource Service</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResourceService(ResourceService object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ensure Project Service</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ensure Project Service</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnsureProjectService(EnsureProjectService object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Project List Service</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Project List Service</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProjectListService(ProjectListService object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Project Response Options</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Project Response Options</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProjectResponseOptions(ProjectResponseOptions object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource Response Options</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource Response Options</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResourceResponseOptions(ResourceResponseOptions object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Project Info</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Project Info</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProjectInfo(ProjectInfo object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource Info</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource Info</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResourceInfo(ResourceInfo object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Source Editor Service</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Source Editor Service</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSourceEditorService(SourceEditorService object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource Info Service</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource Info Service</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResourceInfoService(ResourceInfoService object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Refresh Editor Service</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Refresh Editor Service</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRefreshEditorService(RefreshEditorService object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Markers Editor Service</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Markers Editor Service</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMarkersEditorService(MarkersEditorService object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Update Editor Service</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Update Editor Service</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUpdateEditorService(UpdateEditorService object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>File Marker</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>File Marker</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFileMarker(FileMarker object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Source File Marker</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Source File Marker</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSourceFileMarker(SourceFileMarker object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Completion Editor Service</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Completion Editor Service</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompletionEditorService(CompletionEditorService object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Completion Proposal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Completion Proposal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompletionProposal(CompletionProposal object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Close Editor Service</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Close Editor Service</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCloseEditorService(CloseEditorService object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Execution Service</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Execution Service</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExecutionService(ExecutionService object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Execution Result</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Execution Result</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExecutionResult(ExecutionResult object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Run Editor Service</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Run Editor Service</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRunEditorService(RunEditorService object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Test Editor Service</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Test Editor Service</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTestEditorService(TestEditorService object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Test Result</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Test Result</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTestResult(TestResult object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Test Case Result</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Test Case Result</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTestCaseResult(TestCaseResult object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //ModelSwitch
