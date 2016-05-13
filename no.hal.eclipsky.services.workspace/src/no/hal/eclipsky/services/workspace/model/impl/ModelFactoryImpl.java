/**
 */
package no.hal.eclipsky.services.workspace.model.impl;

import no.hal.eclipsky.services.common.ProjectRef;
import no.hal.eclipsky.services.common.ResourceRef;

import no.hal.eclipsky.services.workspace.model.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModelFactoryImpl extends EFactoryImpl implements ModelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ModelFactory init() {
		try {
			ModelFactory theModelFactory = (ModelFactory)EPackage.Registry.INSTANCE.getEFactory(ModelPackage.eNS_URI);
			if (theModelFactory != null) {
				return theModelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ModelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ModelPackage.PROJECT_SERVICE: return createProjectService();
			case ModelPackage.RESOURCE_SERVICE: return createResourceService();
			case ModelPackage.ENSURE_PROJECT_SERVICE: return createEnsureProjectService();
			case ModelPackage.PROJECT_LIST_SERVICE: return createProjectListService();
			case ModelPackage.PROJECT_RESPONSE_OPTIONS: return createProjectResponseOptions();
			case ModelPackage.RESOURCE_RESPONSE_OPTIONS: return createResourceResponseOptions();
			case ModelPackage.PROJECT_INFO: return createProjectInfo();
			case ModelPackage.RESOURCE_INFO: return createResourceInfo();
			case ModelPackage.SOURCE_EDITOR_SERVICE: return createSourceEditorService();
			case ModelPackage.RESOURCE_INFO_SERVICE: return createResourceInfoService();
			case ModelPackage.REFRESH_EDITOR_SERVICE: return createRefreshEditorService();
			case ModelPackage.MARKERS_EDITOR_SERVICE: return createMarkersEditorService();
			case ModelPackage.UPDATE_EDITOR_SERVICE: return createUpdateEditorService();
			case ModelPackage.SOURCE_FILE_MARKER: return createSourceFileMarker();
			case ModelPackage.COMPLETION_EDITOR_SERVICE: return createCompletionEditorService();
			case ModelPackage.COMPLETION_PROPOSAL: return createCompletionProposal();
			case ModelPackage.CLOSE_EDITOR_SERVICE: return createCloseEditorService();
			case ModelPackage.EXECUTION_SERVICE: return createExecutionService();
			case ModelPackage.EXECUTION_RESULT: return createExecutionResult();
			case ModelPackage.RUN_EDITOR_SERVICE: return createRunEditorService();
			case ModelPackage.TEST_EDITOR_SERVICE: return createTestEditorService();
			case ModelPackage.TEST_RESULT: return createTestResult();
			case ModelPackage.TEST_CASE_RESULT: return createTestCaseResult();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case ModelPackage.RESULT_KIND:
				return createResultKindFromString(eDataType, initialValue);
			case ModelPackage.SEVERITY_KIND:
				return createSeverityKindFromString(eDataType, initialValue);
			case ModelPackage.ETIMESTAMP:
				return createETimestampFromString(eDataType, initialValue);
			case ModelPackage.EPROJECT_REF:
				return createEProjectRefFromString(eDataType, initialValue);
			case ModelPackage.ERESOURCE_REF:
				return createEResourceRefFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case ModelPackage.RESULT_KIND:
				return convertResultKindToString(eDataType, instanceValue);
			case ModelPackage.SEVERITY_KIND:
				return convertSeverityKindToString(eDataType, instanceValue);
			case ModelPackage.ETIMESTAMP:
				return convertETimestampToString(eDataType, instanceValue);
			case ModelPackage.EPROJECT_REF:
				return convertEProjectRefToString(eDataType, instanceValue);
			case ModelPackage.ERESOURCE_REF:
				return convertEResourceRefToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProjectService createProjectService() {
		ProjectServiceImpl projectService = new ProjectServiceImpl();
		return projectService;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceService createResourceService() {
		ResourceServiceImpl resourceService = new ResourceServiceImpl();
		return resourceService;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnsureProjectService createEnsureProjectService() {
		EnsureProjectServiceImpl ensureProjectService = new EnsureProjectServiceImpl();
		return ensureProjectService;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProjectListService createProjectListService() {
		ProjectListServiceImpl projectListService = new ProjectListServiceImpl();
		return projectListService;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProjectResponseOptions createProjectResponseOptions() {
		ProjectResponseOptionsImpl projectResponseOptions = new ProjectResponseOptionsImpl();
		return projectResponseOptions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceResponseOptions createResourceResponseOptions() {
		ResourceResponseOptionsImpl resourceResponseOptions = new ResourceResponseOptionsImpl();
		return resourceResponseOptions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProjectInfo createProjectInfo() {
		ProjectInfoImpl projectInfo = new ProjectInfoImpl();
		return projectInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceInfo createResourceInfo() {
		ResourceInfoImpl resourceInfo = new ResourceInfoImpl();
		return resourceInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceEditorService createSourceEditorService() {
		SourceEditorServiceImpl sourceEditorService = new SourceEditorServiceImpl();
		return sourceEditorService;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceInfoService createResourceInfoService() {
		ResourceInfoServiceImpl resourceInfoService = new ResourceInfoServiceImpl();
		return resourceInfoService;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RefreshEditorService createRefreshEditorService() {
		RefreshEditorServiceImpl refreshEditorService = new RefreshEditorServiceImpl();
		return refreshEditorService;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MarkersEditorService createMarkersEditorService() {
		MarkersEditorServiceImpl markersEditorService = new MarkersEditorServiceImpl();
		return markersEditorService;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UpdateEditorService createUpdateEditorService() {
		UpdateEditorServiceImpl updateEditorService = new UpdateEditorServiceImpl();
		return updateEditorService;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceFileMarker createSourceFileMarker() {
		SourceFileMarkerImpl sourceFileMarker = new SourceFileMarkerImpl();
		return sourceFileMarker;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompletionEditorService createCompletionEditorService() {
		CompletionEditorServiceImpl completionEditorService = new CompletionEditorServiceImpl();
		return completionEditorService;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompletionProposal createCompletionProposal() {
		CompletionProposalImpl completionProposal = new CompletionProposalImpl();
		return completionProposal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CloseEditorService createCloseEditorService() {
		CloseEditorServiceImpl closeEditorService = new CloseEditorServiceImpl();
		return closeEditorService;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionService createExecutionService() {
		ExecutionServiceImpl executionService = new ExecutionServiceImpl();
		return executionService;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionResult createExecutionResult() {
		ExecutionResultImpl executionResult = new ExecutionResultImpl();
		return executionResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RunEditorService createRunEditorService() {
		RunEditorServiceImpl runEditorService = new RunEditorServiceImpl();
		return runEditorService;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestEditorService createTestEditorService() {
		TestEditorServiceImpl testEditorService = new TestEditorServiceImpl();
		return testEditorService;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestResult createTestResult() {
		TestResultImpl testResult = new TestResultImpl();
		return testResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestCaseResult createTestCaseResult() {
		TestCaseResultImpl testCaseResult = new TestCaseResultImpl();
		return testCaseResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultKind createResultKindFromString(EDataType eDataType, String initialValue) {
		ResultKind result = ResultKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertResultKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SeverityKind createSeverityKindFromString(EDataType eDataType, String initialValue) {
		SeverityKind result = SeverityKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSeverityKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Long createETimestampFromString(EDataType eDataType, String initialValue) {
		return (Long)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertETimestampToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProjectRef createEProjectRefFromString(EDataType eDataType, String initialValue) {
		return (ProjectRef)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEProjectRefToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceRef createEResourceRefFromString(EDataType eDataType, String initialValue) {
		return (ResourceRef)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEResourceRefToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelPackage getModelPackage() {
		return (ModelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ModelPackage getPackage() {
		return ModelPackage.eINSTANCE;
	}

} //ModelFactoryImpl
