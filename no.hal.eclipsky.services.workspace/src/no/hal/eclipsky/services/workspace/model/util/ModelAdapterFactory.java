/**
 */
package no.hal.eclipsky.services.workspace.model.util;

import no.hal.eclipsky.services.workspace.model.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see no.hal.eclipsky.services.workspace.model.ModelPackage
 * @generated
 */
public class ModelAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ModelPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ModelPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelSwitch<Adapter> modelSwitch =
		new ModelSwitch<Adapter>() {
			@Override
			public Adapter caseAbstractService(AbstractService object) {
				return createAbstractServiceAdapter();
			}
			@Override
			public Adapter caseProjectService(ProjectService object) {
				return createProjectServiceAdapter();
			}
			@Override
			public Adapter caseResourceService(ResourceService object) {
				return createResourceServiceAdapter();
			}
			@Override
			public Adapter caseEnsureProjectService(EnsureProjectService object) {
				return createEnsureProjectServiceAdapter();
			}
			@Override
			public Adapter caseProjectListService(ProjectListService object) {
				return createProjectListServiceAdapter();
			}
			@Override
			public Adapter caseProjectResponseOptions(ProjectResponseOptions object) {
				return createProjectResponseOptionsAdapter();
			}
			@Override
			public Adapter caseResourceResponseOptions(ResourceResponseOptions object) {
				return createResourceResponseOptionsAdapter();
			}
			@Override
			public Adapter caseProjectInfo(ProjectInfo object) {
				return createProjectInfoAdapter();
			}
			@Override
			public Adapter caseResourceInfo(ResourceInfo object) {
				return createResourceInfoAdapter();
			}
			@Override
			public Adapter caseSourceEditorService(SourceEditorService object) {
				return createSourceEditorServiceAdapter();
			}
			@Override
			public Adapter caseResourceInfoService(ResourceInfoService object) {
				return createResourceInfoServiceAdapter();
			}
			@Override
			public Adapter caseRefreshEditorService(RefreshEditorService object) {
				return createRefreshEditorServiceAdapter();
			}
			@Override
			public Adapter caseMarkersEditorService(MarkersEditorService object) {
				return createMarkersEditorServiceAdapter();
			}
			@Override
			public Adapter caseUpdateEditorService(UpdateEditorService object) {
				return createUpdateEditorServiceAdapter();
			}
			@Override
			public Adapter caseFileMarker(FileMarker object) {
				return createFileMarkerAdapter();
			}
			@Override
			public Adapter caseSourceFileMarker(SourceFileMarker object) {
				return createSourceFileMarkerAdapter();
			}
			@Override
			public Adapter caseCompletionEditorService(CompletionEditorService object) {
				return createCompletionEditorServiceAdapter();
			}
			@Override
			public Adapter caseCompletionProposal(CompletionProposal object) {
				return createCompletionProposalAdapter();
			}
			@Override
			public Adapter caseCloseEditorService(CloseEditorService object) {
				return createCloseEditorServiceAdapter();
			}
			@Override
			public Adapter caseExecutionService(ExecutionService object) {
				return createExecutionServiceAdapter();
			}
			@Override
			public Adapter caseExecutionResult(ExecutionResult object) {
				return createExecutionResultAdapter();
			}
			@Override
			public Adapter caseRunEditorService(RunEditorService object) {
				return createRunEditorServiceAdapter();
			}
			@Override
			public Adapter caseTestEditorService(TestEditorService object) {
				return createTestEditorServiceAdapter();
			}
			@Override
			public Adapter caseTestResult(TestResult object) {
				return createTestResultAdapter();
			}
			@Override
			public Adapter caseTestCaseResult(TestCaseResult object) {
				return createTestCaseResultAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link no.hal.eclipsky.services.workspace.model.AbstractService <em>Abstract Service</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see no.hal.eclipsky.services.workspace.model.AbstractService
	 * @generated
	 */
	public Adapter createAbstractServiceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link no.hal.eclipsky.services.workspace.model.ProjectService <em>Project Service</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see no.hal.eclipsky.services.workspace.model.ProjectService
	 * @generated
	 */
	public Adapter createProjectServiceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link no.hal.eclipsky.services.workspace.model.ResourceService <em>Resource Service</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see no.hal.eclipsky.services.workspace.model.ResourceService
	 * @generated
	 */
	public Adapter createResourceServiceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link no.hal.eclipsky.services.workspace.model.EnsureProjectService <em>Ensure Project Service</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see no.hal.eclipsky.services.workspace.model.EnsureProjectService
	 * @generated
	 */
	public Adapter createEnsureProjectServiceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link no.hal.eclipsky.services.workspace.model.ProjectListService <em>Project List Service</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see no.hal.eclipsky.services.workspace.model.ProjectListService
	 * @generated
	 */
	public Adapter createProjectListServiceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link no.hal.eclipsky.services.workspace.model.ProjectResponseOptions <em>Project Response Options</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see no.hal.eclipsky.services.workspace.model.ProjectResponseOptions
	 * @generated
	 */
	public Adapter createProjectResponseOptionsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link no.hal.eclipsky.services.workspace.model.ResourceResponseOptions <em>Resource Response Options</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see no.hal.eclipsky.services.workspace.model.ResourceResponseOptions
	 * @generated
	 */
	public Adapter createResourceResponseOptionsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link no.hal.eclipsky.services.workspace.model.ProjectInfo <em>Project Info</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see no.hal.eclipsky.services.workspace.model.ProjectInfo
	 * @generated
	 */
	public Adapter createProjectInfoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link no.hal.eclipsky.services.workspace.model.ResourceInfo <em>Resource Info</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see no.hal.eclipsky.services.workspace.model.ResourceInfo
	 * @generated
	 */
	public Adapter createResourceInfoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link no.hal.eclipsky.services.workspace.model.SourceEditorService <em>Source Editor Service</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see no.hal.eclipsky.services.workspace.model.SourceEditorService
	 * @generated
	 */
	public Adapter createSourceEditorServiceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link no.hal.eclipsky.services.workspace.model.ResourceInfoService <em>Resource Info Service</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see no.hal.eclipsky.services.workspace.model.ResourceInfoService
	 * @generated
	 */
	public Adapter createResourceInfoServiceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link no.hal.eclipsky.services.workspace.model.RefreshEditorService <em>Refresh Editor Service</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see no.hal.eclipsky.services.workspace.model.RefreshEditorService
	 * @generated
	 */
	public Adapter createRefreshEditorServiceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link no.hal.eclipsky.services.workspace.model.MarkersEditorService <em>Markers Editor Service</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see no.hal.eclipsky.services.workspace.model.MarkersEditorService
	 * @generated
	 */
	public Adapter createMarkersEditorServiceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link no.hal.eclipsky.services.workspace.model.UpdateEditorService <em>Update Editor Service</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see no.hal.eclipsky.services.workspace.model.UpdateEditorService
	 * @generated
	 */
	public Adapter createUpdateEditorServiceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link no.hal.eclipsky.services.workspace.model.FileMarker <em>File Marker</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see no.hal.eclipsky.services.workspace.model.FileMarker
	 * @generated
	 */
	public Adapter createFileMarkerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link no.hal.eclipsky.services.workspace.model.SourceFileMarker <em>Source File Marker</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see no.hal.eclipsky.services.workspace.model.SourceFileMarker
	 * @generated
	 */
	public Adapter createSourceFileMarkerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link no.hal.eclipsky.services.workspace.model.CompletionEditorService <em>Completion Editor Service</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see no.hal.eclipsky.services.workspace.model.CompletionEditorService
	 * @generated
	 */
	public Adapter createCompletionEditorServiceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link no.hal.eclipsky.services.workspace.model.CompletionProposal <em>Completion Proposal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see no.hal.eclipsky.services.workspace.model.CompletionProposal
	 * @generated
	 */
	public Adapter createCompletionProposalAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link no.hal.eclipsky.services.workspace.model.CloseEditorService <em>Close Editor Service</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see no.hal.eclipsky.services.workspace.model.CloseEditorService
	 * @generated
	 */
	public Adapter createCloseEditorServiceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link no.hal.eclipsky.services.workspace.model.ExecutionService <em>Execution Service</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see no.hal.eclipsky.services.workspace.model.ExecutionService
	 * @generated
	 */
	public Adapter createExecutionServiceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link no.hal.eclipsky.services.workspace.model.ExecutionResult <em>Execution Result</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see no.hal.eclipsky.services.workspace.model.ExecutionResult
	 * @generated
	 */
	public Adapter createExecutionResultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link no.hal.eclipsky.services.workspace.model.RunEditorService <em>Run Editor Service</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see no.hal.eclipsky.services.workspace.model.RunEditorService
	 * @generated
	 */
	public Adapter createRunEditorServiceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link no.hal.eclipsky.services.workspace.model.TestEditorService <em>Test Editor Service</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see no.hal.eclipsky.services.workspace.model.TestEditorService
	 * @generated
	 */
	public Adapter createTestEditorServiceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link no.hal.eclipsky.services.workspace.model.TestResult <em>Test Result</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see no.hal.eclipsky.services.workspace.model.TestResult
	 * @generated
	 */
	public Adapter createTestResultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link no.hal.eclipsky.services.workspace.model.TestCaseResult <em>Test Case Result</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see no.hal.eclipsky.services.workspace.model.TestCaseResult
	 * @generated
	 */
	public Adapter createTestCaseResultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //ModelAdapterFactory
