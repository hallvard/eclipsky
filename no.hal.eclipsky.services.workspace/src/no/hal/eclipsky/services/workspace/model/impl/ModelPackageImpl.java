/**
 */
package no.hal.eclipsky.services.workspace.model.impl;

import no.hal.eclipsky.services.common.ProjectRef;
import no.hal.eclipsky.services.common.ResourceRef;

import no.hal.eclipsky.services.workspace.model.AbstractService;
import no.hal.eclipsky.services.workspace.model.CloseEditorService;
import no.hal.eclipsky.services.workspace.model.CompletionEditorService;
import no.hal.eclipsky.services.workspace.model.CompletionProposal;
import no.hal.eclipsky.services.workspace.model.EnsureProjectService;
import no.hal.eclipsky.services.workspace.model.ExecutionResult;
import no.hal.eclipsky.services.workspace.model.ExecutionService;
import no.hal.eclipsky.services.workspace.model.FileMarker;
import no.hal.eclipsky.services.workspace.model.MarkersEditorService;
import no.hal.eclipsky.services.workspace.model.ModelFactory;
import no.hal.eclipsky.services.workspace.model.ModelPackage;
import no.hal.eclipsky.services.workspace.model.ProjectInfo;
import no.hal.eclipsky.services.workspace.model.ProjectListService;
import no.hal.eclipsky.services.workspace.model.ProjectResponseOptions;
import no.hal.eclipsky.services.workspace.model.ProjectService;
import no.hal.eclipsky.services.workspace.model.RefreshEditorService;
import no.hal.eclipsky.services.workspace.model.ResourceInfo;
import no.hal.eclipsky.services.workspace.model.ResourceInfoService;
import no.hal.eclipsky.services.workspace.model.ResourceResponseOptions;
import no.hal.eclipsky.services.workspace.model.ResourceService;
import no.hal.eclipsky.services.workspace.model.ResultKind;
import no.hal.eclipsky.services.workspace.model.RunEditorService;
import no.hal.eclipsky.services.workspace.model.SeverityKind;
import no.hal.eclipsky.services.workspace.model.SourceEditorService;
import no.hal.eclipsky.services.workspace.model.SourceFileMarker;
import no.hal.eclipsky.services.workspace.model.TestCaseResult;
import no.hal.eclipsky.services.workspace.model.TestEditorService;
import no.hal.eclipsky.services.workspace.model.TestResult;
import no.hal.eclipsky.services.workspace.model.UpdateEditorService;

import no.hal.emfs.EmfsPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModelPackageImpl extends EPackageImpl implements ModelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractServiceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass projectServiceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceServiceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ensureProjectServiceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass projectListServiceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass projectResponseOptionsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceResponseOptionsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass projectInfoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceInfoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sourceEditorServiceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceInfoServiceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass refreshEditorServiceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass markersEditorServiceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass updateEditorServiceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fileMarkerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sourceFileMarkerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass completionEditorServiceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass completionProposalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass closeEditorServiceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass executionServiceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass executionResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass runEditorServiceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass testEditorServiceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass testResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass testCaseResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum resultKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum severityKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType eTimestampEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType eProjectRefEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType eResourceRefEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see no.hal.eclipsky.services.workspace.model.ModelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ModelPackageImpl() {
		super(eNS_URI, ModelFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link ModelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ModelPackage init() {
		if (isInited) return (ModelPackage)EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI);

		// Obtain or create and register package
		ModelPackageImpl theModelPackage = (ModelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ModelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ModelPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EmfsPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theModelPackage.createPackageContents();

		// Initialize created meta-data
		theModelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theModelPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ModelPackage.eNS_URI, theModelPackage);
		return theModelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractService() {
		return abstractServiceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractService_RequestTime() {
		return (EAttribute)abstractServiceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractService_ResponseTime() {
		return (EAttribute)abstractServiceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProjectService() {
		return projectServiceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProjectService_ProjectRef() {
		return (EAttribute)projectServiceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResourceService() {
		return resourceServiceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResourceService_ResourceRef() {
		return (EAttribute)resourceServiceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnsureProjectService() {
		return ensureProjectServiceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnsureProjectService_Emfs() {
		return (EReference)ensureProjectServiceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProjectListService() {
		return projectListServiceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProjectListService_NamePattern() {
		return (EAttribute)projectListServiceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProjectListService_Type() {
		return (EAttribute)projectListServiceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectListService_ResponseOptions() {
		return (EReference)projectListServiceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectListService_Projects() {
		return (EReference)projectListServiceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProjectResponseOptions() {
		return projectResponseOptionsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProjectResponseOptions_IncludeResources() {
		return (EAttribute)projectResponseOptionsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectResponseOptions_ResourceResponseOptions() {
		return (EReference)projectResponseOptionsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResourceResponseOptions() {
		return resourceResponseOptionsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResourceResponseOptions_IncludeContents() {
		return (EAttribute)resourceResponseOptionsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResourceResponseOptions_IncludeMarkers() {
		return (EAttribute)resourceResponseOptionsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProjectInfo() {
		return projectInfoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProjectInfo_ProjectRef() {
		return (EAttribute)projectInfoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectInfo_Resources() {
		return (EReference)projectInfoEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResourceInfo() {
		return resourceInfoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResourceInfo_ResourceRef() {
		return (EAttribute)resourceInfoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceInfo_Contents() {
		return (EReference)resourceInfoEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceInfo_Markers() {
		return (EReference)resourceInfoEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSourceEditorService() {
		return sourceEditorServiceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResourceInfoService() {
		return resourceInfoServiceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceInfoService_ResponseOptions() {
		return (EReference)resourceInfoServiceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceInfoService_Resource() {
		return (EReference)resourceInfoServiceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRefreshEditorService() {
		return refreshEditorServiceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRefreshEditorService_Resource() {
		return (EReference)refreshEditorServiceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMarkersEditorService() {
		return markersEditorServiceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMarkersEditorService_Markers() {
		return (EReference)markersEditorServiceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUpdateEditorService() {
		return updateEditorServiceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUpdateEditorService_Contents() {
		return (EReference)updateEditorServiceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFileMarker() {
		return fileMarkerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFileMarker_Severity() {
		return (EAttribute)fileMarkerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFileMarker_Message() {
		return (EAttribute)fileMarkerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSourceFileMarker() {
		return sourceFileMarkerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSourceFileMarker_LineNumber() {
		return (EAttribute)sourceFileMarkerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSourceFileMarker_Start() {
		return (EAttribute)sourceFileMarkerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSourceFileMarker_End() {
		return (EAttribute)sourceFileMarkerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompletionEditorService() {
		return completionEditorServiceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompletionEditorService_Position() {
		return (EAttribute)completionEditorServiceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompletionEditorService_Proposals() {
		return (EReference)completionEditorServiceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompletionProposal() {
		return completionProposalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompletionProposal_Name() {
		return (EAttribute)completionProposalEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompletionProposal_Value() {
		return (EAttribute)completionProposalEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompletionProposal_Score() {
		return (EAttribute)completionProposalEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCloseEditorService() {
		return closeEditorServiceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExecutionService() {
		return executionServiceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecutionService_Result() {
		return (EReference)executionServiceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExecutionResult() {
		return executionResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecutionResult_Sysout() {
		return (EReference)executionResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecutionResult_Syserr() {
		return (EReference)executionResultEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExecutionResult_QualifiedName() {
		return (EAttribute)executionResultEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecutionResult_ExceptionLocation() {
		return (EReference)executionResultEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRunEditorService() {
		return runEditorServiceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTestEditorService() {
		return testEditorServiceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTestResult() {
		return testResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTestResult_Results() {
		return (EReference)testResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTestCaseResult() {
		return testCaseResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTestCaseResult_TestName() {
		return (EAttribute)testCaseResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTestCaseResult_Kind() {
		return (EAttribute)testCaseResultEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTestCaseResult_Message() {
		return (EAttribute)testCaseResultEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTestCaseResult_Exception() {
		return (EAttribute)testCaseResultEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getResultKind() {
		return resultKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSeverityKind() {
		return severityKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getETimestamp() {
		return eTimestampEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getEProjectRef() {
		return eProjectRefEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getEResourceRef() {
		return eResourceRefEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelFactory getModelFactory() {
		return (ModelFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		abstractServiceEClass = createEClass(ABSTRACT_SERVICE);
		createEAttribute(abstractServiceEClass, ABSTRACT_SERVICE__REQUEST_TIME);
		createEAttribute(abstractServiceEClass, ABSTRACT_SERVICE__RESPONSE_TIME);

		projectServiceEClass = createEClass(PROJECT_SERVICE);
		createEAttribute(projectServiceEClass, PROJECT_SERVICE__PROJECT_REF);

		resourceServiceEClass = createEClass(RESOURCE_SERVICE);
		createEAttribute(resourceServiceEClass, RESOURCE_SERVICE__RESOURCE_REF);

		ensureProjectServiceEClass = createEClass(ENSURE_PROJECT_SERVICE);
		createEReference(ensureProjectServiceEClass, ENSURE_PROJECT_SERVICE__EMFS);

		projectListServiceEClass = createEClass(PROJECT_LIST_SERVICE);
		createEAttribute(projectListServiceEClass, PROJECT_LIST_SERVICE__NAME_PATTERN);
		createEAttribute(projectListServiceEClass, PROJECT_LIST_SERVICE__TYPE);
		createEReference(projectListServiceEClass, PROJECT_LIST_SERVICE__RESPONSE_OPTIONS);
		createEReference(projectListServiceEClass, PROJECT_LIST_SERVICE__PROJECTS);

		projectResponseOptionsEClass = createEClass(PROJECT_RESPONSE_OPTIONS);
		createEAttribute(projectResponseOptionsEClass, PROJECT_RESPONSE_OPTIONS__INCLUDE_RESOURCES);
		createEReference(projectResponseOptionsEClass, PROJECT_RESPONSE_OPTIONS__RESOURCE_RESPONSE_OPTIONS);

		resourceResponseOptionsEClass = createEClass(RESOURCE_RESPONSE_OPTIONS);
		createEAttribute(resourceResponseOptionsEClass, RESOURCE_RESPONSE_OPTIONS__INCLUDE_CONTENTS);
		createEAttribute(resourceResponseOptionsEClass, RESOURCE_RESPONSE_OPTIONS__INCLUDE_MARKERS);

		projectInfoEClass = createEClass(PROJECT_INFO);
		createEAttribute(projectInfoEClass, PROJECT_INFO__PROJECT_REF);
		createEReference(projectInfoEClass, PROJECT_INFO__RESOURCES);

		resourceInfoEClass = createEClass(RESOURCE_INFO);
		createEAttribute(resourceInfoEClass, RESOURCE_INFO__RESOURCE_REF);
		createEReference(resourceInfoEClass, RESOURCE_INFO__CONTENTS);
		createEReference(resourceInfoEClass, RESOURCE_INFO__MARKERS);

		sourceEditorServiceEClass = createEClass(SOURCE_EDITOR_SERVICE);

		resourceInfoServiceEClass = createEClass(RESOURCE_INFO_SERVICE);
		createEReference(resourceInfoServiceEClass, RESOURCE_INFO_SERVICE__RESPONSE_OPTIONS);
		createEReference(resourceInfoServiceEClass, RESOURCE_INFO_SERVICE__RESOURCE);

		refreshEditorServiceEClass = createEClass(REFRESH_EDITOR_SERVICE);
		createEReference(refreshEditorServiceEClass, REFRESH_EDITOR_SERVICE__RESOURCE);

		markersEditorServiceEClass = createEClass(MARKERS_EDITOR_SERVICE);
		createEReference(markersEditorServiceEClass, MARKERS_EDITOR_SERVICE__MARKERS);

		updateEditorServiceEClass = createEClass(UPDATE_EDITOR_SERVICE);
		createEReference(updateEditorServiceEClass, UPDATE_EDITOR_SERVICE__CONTENTS);

		fileMarkerEClass = createEClass(FILE_MARKER);
		createEAttribute(fileMarkerEClass, FILE_MARKER__SEVERITY);
		createEAttribute(fileMarkerEClass, FILE_MARKER__MESSAGE);

		sourceFileMarkerEClass = createEClass(SOURCE_FILE_MARKER);
		createEAttribute(sourceFileMarkerEClass, SOURCE_FILE_MARKER__LINE_NUMBER);
		createEAttribute(sourceFileMarkerEClass, SOURCE_FILE_MARKER__START);
		createEAttribute(sourceFileMarkerEClass, SOURCE_FILE_MARKER__END);

		completionEditorServiceEClass = createEClass(COMPLETION_EDITOR_SERVICE);
		createEAttribute(completionEditorServiceEClass, COMPLETION_EDITOR_SERVICE__POSITION);
		createEReference(completionEditorServiceEClass, COMPLETION_EDITOR_SERVICE__PROPOSALS);

		completionProposalEClass = createEClass(COMPLETION_PROPOSAL);
		createEAttribute(completionProposalEClass, COMPLETION_PROPOSAL__NAME);
		createEAttribute(completionProposalEClass, COMPLETION_PROPOSAL__VALUE);
		createEAttribute(completionProposalEClass, COMPLETION_PROPOSAL__SCORE);

		closeEditorServiceEClass = createEClass(CLOSE_EDITOR_SERVICE);

		executionServiceEClass = createEClass(EXECUTION_SERVICE);
		createEReference(executionServiceEClass, EXECUTION_SERVICE__RESULT);

		executionResultEClass = createEClass(EXECUTION_RESULT);
		createEReference(executionResultEClass, EXECUTION_RESULT__SYSOUT);
		createEReference(executionResultEClass, EXECUTION_RESULT__SYSERR);
		createEAttribute(executionResultEClass, EXECUTION_RESULT__QUALIFIED_NAME);
		createEReference(executionResultEClass, EXECUTION_RESULT__EXCEPTION_LOCATION);

		runEditorServiceEClass = createEClass(RUN_EDITOR_SERVICE);

		testEditorServiceEClass = createEClass(TEST_EDITOR_SERVICE);

		testResultEClass = createEClass(TEST_RESULT);
		createEReference(testResultEClass, TEST_RESULT__RESULTS);

		testCaseResultEClass = createEClass(TEST_CASE_RESULT);
		createEAttribute(testCaseResultEClass, TEST_CASE_RESULT__TEST_NAME);
		createEAttribute(testCaseResultEClass, TEST_CASE_RESULT__KIND);
		createEAttribute(testCaseResultEClass, TEST_CASE_RESULT__MESSAGE);
		createEAttribute(testCaseResultEClass, TEST_CASE_RESULT__EXCEPTION);

		// Create enums
		resultKindEEnum = createEEnum(RESULT_KIND);
		severityKindEEnum = createEEnum(SEVERITY_KIND);

		// Create data types
		eTimestampEDataType = createEDataType(ETIMESTAMP);
		eProjectRefEDataType = createEDataType(EPROJECT_REF);
		eResourceRefEDataType = createEDataType(ERESOURCE_REF);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		EmfsPackage theEmfsPackage = (EmfsPackage)EPackage.Registry.INSTANCE.getEPackage(EmfsPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		projectServiceEClass.getESuperTypes().add(this.getAbstractService());
		resourceServiceEClass.getESuperTypes().add(this.getAbstractService());
		ensureProjectServiceEClass.getESuperTypes().add(this.getProjectService());
		projectListServiceEClass.getESuperTypes().add(this.getAbstractService());
		sourceEditorServiceEClass.getESuperTypes().add(this.getResourceService());
		refreshEditorServiceEClass.getESuperTypes().add(this.getSourceEditorService());
		markersEditorServiceEClass.getESuperTypes().add(this.getSourceEditorService());
		updateEditorServiceEClass.getESuperTypes().add(this.getMarkersEditorService());
		sourceFileMarkerEClass.getESuperTypes().add(this.getFileMarker());
		completionEditorServiceEClass.getESuperTypes().add(this.getSourceEditorService());
		closeEditorServiceEClass.getESuperTypes().add(this.getResourceService());
		executionServiceEClass.getESuperTypes().add(this.getResourceService());
		runEditorServiceEClass.getESuperTypes().add(this.getExecutionService());
		testEditorServiceEClass.getESuperTypes().add(this.getExecutionService());
		testResultEClass.getESuperTypes().add(this.getExecutionResult());

		// Initialize classes, features, and operations; add parameters
		initEClass(abstractServiceEClass, AbstractService.class, "AbstractService", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAbstractService_RequestTime(), this.getETimestamp(), "requestTime", null, 0, 1, AbstractService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractService_ResponseTime(), this.getETimestamp(), "responseTime", null, 0, 1, AbstractService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(projectServiceEClass, ProjectService.class, "ProjectService", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProjectService_ProjectRef(), this.getEProjectRef(), "projectRef", null, 0, 1, ProjectService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(resourceServiceEClass, ResourceService.class, "ResourceService", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getResourceService_ResourceRef(), this.getEResourceRef(), "resourceRef", null, 0, 1, ResourceService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ensureProjectServiceEClass, EnsureProjectService.class, "EnsureProjectService", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEnsureProjectService_Emfs(), theEmfsPackage.getEmfsResource(), null, "emfs", null, 0, 1, EnsureProjectService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(projectListServiceEClass, ProjectListService.class, "ProjectListService", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProjectListService_NamePattern(), ecorePackage.getEString(), "namePattern", null, 0, 1, ProjectListService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProjectListService_Type(), ecorePackage.getEString(), "type", null, 0, 1, ProjectListService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProjectListService_ResponseOptions(), this.getProjectResponseOptions(), null, "responseOptions", null, 0, 1, ProjectListService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProjectListService_Projects(), this.getProjectInfo(), null, "projects", null, 0, -1, ProjectListService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(projectResponseOptionsEClass, ProjectResponseOptions.class, "ProjectResponseOptions", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProjectResponseOptions_IncludeResources(), ecorePackage.getEBoolean(), "includeResources", null, 0, 1, ProjectResponseOptions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProjectResponseOptions_ResourceResponseOptions(), this.getResourceResponseOptions(), null, "resourceResponseOptions", null, 0, 1, ProjectResponseOptions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(resourceResponseOptionsEClass, ResourceResponseOptions.class, "ResourceResponseOptions", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getResourceResponseOptions_IncludeContents(), ecorePackage.getEBoolean(), "includeContents", null, 0, 1, ResourceResponseOptions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResourceResponseOptions_IncludeMarkers(), ecorePackage.getEBoolean(), "includeMarkers", null, 0, 1, ResourceResponseOptions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(projectInfoEClass, ProjectInfo.class, "ProjectInfo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProjectInfo_ProjectRef(), this.getEProjectRef(), "projectRef", null, 0, 1, ProjectInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProjectInfo_Resources(), this.getResourceInfo(), null, "resources", null, 0, -1, ProjectInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(resourceInfoEClass, ResourceInfo.class, "ResourceInfo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getResourceInfo_ResourceRef(), this.getEResourceRef(), "resourceRef", null, 0, 1, ResourceInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResourceInfo_Contents(), theEmfsPackage.getAbstractStringContentProvider(), null, "contents", null, 0, 1, ResourceInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResourceInfo_Markers(), this.getSourceFileMarker(), null, "markers", null, 0, -1, ResourceInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sourceEditorServiceEClass, SourceEditorService.class, "SourceEditorService", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(resourceInfoServiceEClass, ResourceInfoService.class, "ResourceInfoService", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getResourceInfoService_ResponseOptions(), this.getResourceResponseOptions(), null, "responseOptions", null, 0, 1, ResourceInfoService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResourceInfoService_Resource(), this.getResourceInfo(), null, "resource", null, 0, 1, ResourceInfoService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(refreshEditorServiceEClass, RefreshEditorService.class, "RefreshEditorService", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRefreshEditorService_Resource(), this.getResourceInfo(), null, "resource", null, 0, 1, RefreshEditorService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(markersEditorServiceEClass, MarkersEditorService.class, "MarkersEditorService", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMarkersEditorService_Markers(), this.getResourceInfo(), null, "markers", null, 0, 1, MarkersEditorService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(updateEditorServiceEClass, UpdateEditorService.class, "UpdateEditorService", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUpdateEditorService_Contents(), theEmfsPackage.getAbstractStringContentProvider(), null, "contents", null, 0, 1, UpdateEditorService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fileMarkerEClass, FileMarker.class, "FileMarker", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFileMarker_Severity(), this.getSeverityKind(), "severity", null, 0, 1, FileMarker.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFileMarker_Message(), ecorePackage.getEString(), "message", null, 0, 1, FileMarker.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sourceFileMarkerEClass, SourceFileMarker.class, "SourceFileMarker", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSourceFileMarker_LineNumber(), ecorePackage.getEInt(), "lineNumber", null, 0, 1, SourceFileMarker.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSourceFileMarker_Start(), ecorePackage.getEInt(), "start", null, 0, 1, SourceFileMarker.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSourceFileMarker_End(), ecorePackage.getEInt(), "end", null, 0, 1, SourceFileMarker.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(completionEditorServiceEClass, CompletionEditorService.class, "CompletionEditorService", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCompletionEditorService_Position(), ecorePackage.getEInt(), "position", null, 0, 1, CompletionEditorService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompletionEditorService_Proposals(), this.getCompletionProposal(), null, "proposals", null, 0, -1, CompletionEditorService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(completionProposalEClass, CompletionProposal.class, "CompletionProposal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCompletionProposal_Name(), ecorePackage.getEString(), "name", null, 0, 1, CompletionProposal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompletionProposal_Value(), ecorePackage.getEString(), "value", null, 0, 1, CompletionProposal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompletionProposal_Score(), ecorePackage.getEInt(), "score", null, 0, 1, CompletionProposal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(closeEditorServiceEClass, CloseEditorService.class, "CloseEditorService", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(executionServiceEClass, ExecutionService.class, "ExecutionService", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExecutionService_Result(), this.getExecutionResult(), null, "result", null, 0, 1, ExecutionService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(executionResultEClass, ExecutionResult.class, "ExecutionResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExecutionResult_Sysout(), theEmfsPackage.getAbstractStringContents(), null, "sysout", null, 0, 1, ExecutionResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExecutionResult_Syserr(), theEmfsPackage.getAbstractStringContents(), null, "syserr", null, 0, 1, ExecutionResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExecutionResult_QualifiedName(), ecorePackage.getEString(), "qualifiedName", null, 0, 1, ExecutionResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExecutionResult_ExceptionLocation(), this.getSourceFileMarker(), null, "exceptionLocation", null, 0, 1, ExecutionResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(runEditorServiceEClass, RunEditorService.class, "RunEditorService", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(testEditorServiceEClass, TestEditorService.class, "TestEditorService", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(testResultEClass, TestResult.class, "TestResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTestResult_Results(), this.getTestCaseResult(), null, "results", null, 0, -1, TestResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(testCaseResultEClass, TestCaseResult.class, "TestCaseResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTestCaseResult_TestName(), ecorePackage.getEString(), "testName", null, 0, 1, TestCaseResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestCaseResult_Kind(), this.getResultKind(), "kind", null, 0, 1, TestCaseResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestCaseResult_Message(), ecorePackage.getEString(), "message", null, 0, 1, TestCaseResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestCaseResult_Exception(), ecorePackage.getEString(), "exception", null, 0, 1, TestCaseResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(resultKindEEnum, ResultKind.class, "ResultKind");
		addEEnumLiteral(resultKindEEnum, ResultKind.UNKNOWN);
		addEEnumLiteral(resultKindEEnum, ResultKind.SUCCESS);
		addEEnumLiteral(resultKindEEnum, ResultKind.FAILURE);
		addEEnumLiteral(resultKindEEnum, ResultKind.ERROR);

		initEEnum(severityKindEEnum, SeverityKind.class, "SeverityKind");
		addEEnumLiteral(severityKindEEnum, SeverityKind.UNKNOWN);
		addEEnumLiteral(severityKindEEnum, SeverityKind.OK);
		addEEnumLiteral(severityKindEEnum, SeverityKind.INFO);
		addEEnumLiteral(severityKindEEnum, SeverityKind.WARNING);
		addEEnumLiteral(severityKindEEnum, SeverityKind.ERROR);

		// Initialize data types
		initEDataType(eTimestampEDataType, long.class, "ETimestamp", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(eProjectRefEDataType, ProjectRef.class, "EProjectRef", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(eResourceRefEDataType, ResourceRef.class, "EResourceRef", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //ModelPackageImpl
