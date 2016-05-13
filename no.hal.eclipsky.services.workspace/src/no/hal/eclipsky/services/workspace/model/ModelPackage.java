/**
 */
package no.hal.eclipsky.services.workspace.model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see no.hal.eclipsky.services.workspace.model.ModelFactory
 * @model kind="package"
 * @generated
 */
public interface ModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "model";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "plugin:/platform/no.hal.eclipsky.services.workspace/model/workspace-services.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ws";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelPackage eINSTANCE = no.hal.eclipsky.services.workspace.model.impl.ModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link no.hal.eclipsky.services.workspace.model.impl.AbstractServiceImpl <em>Abstract Service</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hal.eclipsky.services.workspace.model.impl.AbstractServiceImpl
	 * @see no.hal.eclipsky.services.workspace.model.impl.ModelPackageImpl#getAbstractService()
	 * @generated
	 */
	int ABSTRACT_SERVICE = 0;

	/**
	 * The feature id for the '<em><b>Request Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SERVICE__REQUEST_TIME = 0;

	/**
	 * The feature id for the '<em><b>Response Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SERVICE__RESPONSE_TIME = 1;

	/**
	 * The number of structural features of the '<em>Abstract Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SERVICE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Abstract Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SERVICE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link no.hal.eclipsky.services.workspace.model.impl.ProjectServiceImpl <em>Project Service</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hal.eclipsky.services.workspace.model.impl.ProjectServiceImpl
	 * @see no.hal.eclipsky.services.workspace.model.impl.ModelPackageImpl#getProjectService()
	 * @generated
	 */
	int PROJECT_SERVICE = 1;

	/**
	 * The feature id for the '<em><b>Request Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_SERVICE__REQUEST_TIME = ABSTRACT_SERVICE__REQUEST_TIME;

	/**
	 * The feature id for the '<em><b>Response Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_SERVICE__RESPONSE_TIME = ABSTRACT_SERVICE__RESPONSE_TIME;

	/**
	 * The feature id for the '<em><b>Project Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_SERVICE__PROJECT_REF = ABSTRACT_SERVICE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Project Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_SERVICE_FEATURE_COUNT = ABSTRACT_SERVICE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Project Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_SERVICE_OPERATION_COUNT = ABSTRACT_SERVICE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link no.hal.eclipsky.services.workspace.model.impl.ResourceServiceImpl <em>Resource Service</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hal.eclipsky.services.workspace.model.impl.ResourceServiceImpl
	 * @see no.hal.eclipsky.services.workspace.model.impl.ModelPackageImpl#getResourceService()
	 * @generated
	 */
	int RESOURCE_SERVICE = 2;

	/**
	 * The feature id for the '<em><b>Request Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_SERVICE__REQUEST_TIME = ABSTRACT_SERVICE__REQUEST_TIME;

	/**
	 * The feature id for the '<em><b>Response Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_SERVICE__RESPONSE_TIME = ABSTRACT_SERVICE__RESPONSE_TIME;

	/**
	 * The feature id for the '<em><b>Resource Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_SERVICE__RESOURCE_REF = ABSTRACT_SERVICE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Resource Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_SERVICE_FEATURE_COUNT = ABSTRACT_SERVICE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Resource Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_SERVICE_OPERATION_COUNT = ABSTRACT_SERVICE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link no.hal.eclipsky.services.workspace.model.impl.EnsureProjectServiceImpl <em>Ensure Project Service</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hal.eclipsky.services.workspace.model.impl.EnsureProjectServiceImpl
	 * @see no.hal.eclipsky.services.workspace.model.impl.ModelPackageImpl#getEnsureProjectService()
	 * @generated
	 */
	int ENSURE_PROJECT_SERVICE = 3;

	/**
	 * The feature id for the '<em><b>Request Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENSURE_PROJECT_SERVICE__REQUEST_TIME = PROJECT_SERVICE__REQUEST_TIME;

	/**
	 * The feature id for the '<em><b>Response Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENSURE_PROJECT_SERVICE__RESPONSE_TIME = PROJECT_SERVICE__RESPONSE_TIME;

	/**
	 * The feature id for the '<em><b>Project Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENSURE_PROJECT_SERVICE__PROJECT_REF = PROJECT_SERVICE__PROJECT_REF;

	/**
	 * The feature id for the '<em><b>Emfs</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENSURE_PROJECT_SERVICE__EMFS = PROJECT_SERVICE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Ensure Project Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENSURE_PROJECT_SERVICE_FEATURE_COUNT = PROJECT_SERVICE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Ensure Project Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENSURE_PROJECT_SERVICE_OPERATION_COUNT = PROJECT_SERVICE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link no.hal.eclipsky.services.workspace.model.impl.ProjectListServiceImpl <em>Project List Service</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hal.eclipsky.services.workspace.model.impl.ProjectListServiceImpl
	 * @see no.hal.eclipsky.services.workspace.model.impl.ModelPackageImpl#getProjectListService()
	 * @generated
	 */
	int PROJECT_LIST_SERVICE = 4;

	/**
	 * The feature id for the '<em><b>Request Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_LIST_SERVICE__REQUEST_TIME = ABSTRACT_SERVICE__REQUEST_TIME;

	/**
	 * The feature id for the '<em><b>Response Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_LIST_SERVICE__RESPONSE_TIME = ABSTRACT_SERVICE__RESPONSE_TIME;

	/**
	 * The feature id for the '<em><b>Name Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_LIST_SERVICE__NAME_PATTERN = ABSTRACT_SERVICE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_LIST_SERVICE__TYPE = ABSTRACT_SERVICE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Response Options</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_LIST_SERVICE__RESPONSE_OPTIONS = ABSTRACT_SERVICE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Projects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_LIST_SERVICE__PROJECTS = ABSTRACT_SERVICE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Project List Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_LIST_SERVICE_FEATURE_COUNT = ABSTRACT_SERVICE_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Project List Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_LIST_SERVICE_OPERATION_COUNT = ABSTRACT_SERVICE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link no.hal.eclipsky.services.workspace.model.impl.ProjectResponseOptionsImpl <em>Project Response Options</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hal.eclipsky.services.workspace.model.impl.ProjectResponseOptionsImpl
	 * @see no.hal.eclipsky.services.workspace.model.impl.ModelPackageImpl#getProjectResponseOptions()
	 * @generated
	 */
	int PROJECT_RESPONSE_OPTIONS = 5;

	/**
	 * The feature id for the '<em><b>Include Resources</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_RESPONSE_OPTIONS__INCLUDE_RESOURCES = 0;

	/**
	 * The feature id for the '<em><b>Resource Response Options</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_RESPONSE_OPTIONS__RESOURCE_RESPONSE_OPTIONS = 1;

	/**
	 * The number of structural features of the '<em>Project Response Options</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_RESPONSE_OPTIONS_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Project Response Options</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_RESPONSE_OPTIONS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link no.hal.eclipsky.services.workspace.model.impl.ResourceResponseOptionsImpl <em>Resource Response Options</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hal.eclipsky.services.workspace.model.impl.ResourceResponseOptionsImpl
	 * @see no.hal.eclipsky.services.workspace.model.impl.ModelPackageImpl#getResourceResponseOptions()
	 * @generated
	 */
	int RESOURCE_RESPONSE_OPTIONS = 6;

	/**
	 * The feature id for the '<em><b>Include Contents</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_RESPONSE_OPTIONS__INCLUDE_CONTENTS = 0;

	/**
	 * The feature id for the '<em><b>Include Markers</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_RESPONSE_OPTIONS__INCLUDE_MARKERS = 1;

	/**
	 * The number of structural features of the '<em>Resource Response Options</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_RESPONSE_OPTIONS_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Resource Response Options</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_RESPONSE_OPTIONS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link no.hal.eclipsky.services.workspace.model.impl.ProjectInfoImpl <em>Project Info</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hal.eclipsky.services.workspace.model.impl.ProjectInfoImpl
	 * @see no.hal.eclipsky.services.workspace.model.impl.ModelPackageImpl#getProjectInfo()
	 * @generated
	 */
	int PROJECT_INFO = 7;

	/**
	 * The feature id for the '<em><b>Project Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_INFO__PROJECT_REF = 0;

	/**
	 * The feature id for the '<em><b>Resources</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_INFO__RESOURCES = 1;

	/**
	 * The number of structural features of the '<em>Project Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_INFO_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Project Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_INFO_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link no.hal.eclipsky.services.workspace.model.impl.ResourceInfoImpl <em>Resource Info</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hal.eclipsky.services.workspace.model.impl.ResourceInfoImpl
	 * @see no.hal.eclipsky.services.workspace.model.impl.ModelPackageImpl#getResourceInfo()
	 * @generated
	 */
	int RESOURCE_INFO = 8;

	/**
	 * The feature id for the '<em><b>Resource Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_INFO__RESOURCE_REF = 0;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_INFO__CONTENTS = 1;

	/**
	 * The feature id for the '<em><b>Markers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_INFO__MARKERS = 2;

	/**
	 * The number of structural features of the '<em>Resource Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_INFO_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Resource Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_INFO_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link no.hal.eclipsky.services.workspace.model.impl.SourceEditorServiceImpl <em>Source Editor Service</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hal.eclipsky.services.workspace.model.impl.SourceEditorServiceImpl
	 * @see no.hal.eclipsky.services.workspace.model.impl.ModelPackageImpl#getSourceEditorService()
	 * @generated
	 */
	int SOURCE_EDITOR_SERVICE = 9;

	/**
	 * The feature id for the '<em><b>Request Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_EDITOR_SERVICE__REQUEST_TIME = RESOURCE_SERVICE__REQUEST_TIME;

	/**
	 * The feature id for the '<em><b>Response Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_EDITOR_SERVICE__RESPONSE_TIME = RESOURCE_SERVICE__RESPONSE_TIME;

	/**
	 * The feature id for the '<em><b>Resource Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_EDITOR_SERVICE__RESOURCE_REF = RESOURCE_SERVICE__RESOURCE_REF;

	/**
	 * The number of structural features of the '<em>Source Editor Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_EDITOR_SERVICE_FEATURE_COUNT = RESOURCE_SERVICE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Source Editor Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_EDITOR_SERVICE_OPERATION_COUNT = RESOURCE_SERVICE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link no.hal.eclipsky.services.workspace.model.impl.ResourceInfoServiceImpl <em>Resource Info Service</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hal.eclipsky.services.workspace.model.impl.ResourceInfoServiceImpl
	 * @see no.hal.eclipsky.services.workspace.model.impl.ModelPackageImpl#getResourceInfoService()
	 * @generated
	 */
	int RESOURCE_INFO_SERVICE = 10;

	/**
	 * The feature id for the '<em><b>Response Options</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_INFO_SERVICE__RESPONSE_OPTIONS = 0;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_INFO_SERVICE__RESOURCE = 1;

	/**
	 * The number of structural features of the '<em>Resource Info Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_INFO_SERVICE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Resource Info Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_INFO_SERVICE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link no.hal.eclipsky.services.workspace.model.impl.RefreshEditorServiceImpl <em>Refresh Editor Service</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hal.eclipsky.services.workspace.model.impl.RefreshEditorServiceImpl
	 * @see no.hal.eclipsky.services.workspace.model.impl.ModelPackageImpl#getRefreshEditorService()
	 * @generated
	 */
	int REFRESH_EDITOR_SERVICE = 11;

	/**
	 * The feature id for the '<em><b>Request Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFRESH_EDITOR_SERVICE__REQUEST_TIME = SOURCE_EDITOR_SERVICE__REQUEST_TIME;

	/**
	 * The feature id for the '<em><b>Response Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFRESH_EDITOR_SERVICE__RESPONSE_TIME = SOURCE_EDITOR_SERVICE__RESPONSE_TIME;

	/**
	 * The feature id for the '<em><b>Resource Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFRESH_EDITOR_SERVICE__RESOURCE_REF = SOURCE_EDITOR_SERVICE__RESOURCE_REF;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFRESH_EDITOR_SERVICE__RESOURCE = SOURCE_EDITOR_SERVICE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Refresh Editor Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFRESH_EDITOR_SERVICE_FEATURE_COUNT = SOURCE_EDITOR_SERVICE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Refresh Editor Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFRESH_EDITOR_SERVICE_OPERATION_COUNT = SOURCE_EDITOR_SERVICE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link no.hal.eclipsky.services.workspace.model.impl.MarkersEditorServiceImpl <em>Markers Editor Service</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hal.eclipsky.services.workspace.model.impl.MarkersEditorServiceImpl
	 * @see no.hal.eclipsky.services.workspace.model.impl.ModelPackageImpl#getMarkersEditorService()
	 * @generated
	 */
	int MARKERS_EDITOR_SERVICE = 12;

	/**
	 * The feature id for the '<em><b>Request Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKERS_EDITOR_SERVICE__REQUEST_TIME = SOURCE_EDITOR_SERVICE__REQUEST_TIME;

	/**
	 * The feature id for the '<em><b>Response Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKERS_EDITOR_SERVICE__RESPONSE_TIME = SOURCE_EDITOR_SERVICE__RESPONSE_TIME;

	/**
	 * The feature id for the '<em><b>Resource Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKERS_EDITOR_SERVICE__RESOURCE_REF = SOURCE_EDITOR_SERVICE__RESOURCE_REF;

	/**
	 * The feature id for the '<em><b>Markers</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKERS_EDITOR_SERVICE__MARKERS = SOURCE_EDITOR_SERVICE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Markers Editor Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKERS_EDITOR_SERVICE_FEATURE_COUNT = SOURCE_EDITOR_SERVICE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Markers Editor Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKERS_EDITOR_SERVICE_OPERATION_COUNT = SOURCE_EDITOR_SERVICE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link no.hal.eclipsky.services.workspace.model.impl.UpdateEditorServiceImpl <em>Update Editor Service</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hal.eclipsky.services.workspace.model.impl.UpdateEditorServiceImpl
	 * @see no.hal.eclipsky.services.workspace.model.impl.ModelPackageImpl#getUpdateEditorService()
	 * @generated
	 */
	int UPDATE_EDITOR_SERVICE = 13;

	/**
	 * The feature id for the '<em><b>Request Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_EDITOR_SERVICE__REQUEST_TIME = MARKERS_EDITOR_SERVICE__REQUEST_TIME;

	/**
	 * The feature id for the '<em><b>Response Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_EDITOR_SERVICE__RESPONSE_TIME = MARKERS_EDITOR_SERVICE__RESPONSE_TIME;

	/**
	 * The feature id for the '<em><b>Resource Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_EDITOR_SERVICE__RESOURCE_REF = MARKERS_EDITOR_SERVICE__RESOURCE_REF;

	/**
	 * The feature id for the '<em><b>Markers</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_EDITOR_SERVICE__MARKERS = MARKERS_EDITOR_SERVICE__MARKERS;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_EDITOR_SERVICE__CONTENTS = MARKERS_EDITOR_SERVICE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Update Editor Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_EDITOR_SERVICE_FEATURE_COUNT = MARKERS_EDITOR_SERVICE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Update Editor Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_EDITOR_SERVICE_OPERATION_COUNT = MARKERS_EDITOR_SERVICE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link no.hal.eclipsky.services.workspace.model.impl.FileMarkerImpl <em>File Marker</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hal.eclipsky.services.workspace.model.impl.FileMarkerImpl
	 * @see no.hal.eclipsky.services.workspace.model.impl.ModelPackageImpl#getFileMarker()
	 * @generated
	 */
	int FILE_MARKER = 14;

	/**
	 * The feature id for the '<em><b>Severity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_MARKER__SEVERITY = 0;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_MARKER__MESSAGE = 1;

	/**
	 * The number of structural features of the '<em>File Marker</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_MARKER_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>File Marker</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_MARKER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link no.hal.eclipsky.services.workspace.model.impl.SourceFileMarkerImpl <em>Source File Marker</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hal.eclipsky.services.workspace.model.impl.SourceFileMarkerImpl
	 * @see no.hal.eclipsky.services.workspace.model.impl.ModelPackageImpl#getSourceFileMarker()
	 * @generated
	 */
	int SOURCE_FILE_MARKER = 15;

	/**
	 * The feature id for the '<em><b>Severity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_FILE_MARKER__SEVERITY = FILE_MARKER__SEVERITY;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_FILE_MARKER__MESSAGE = FILE_MARKER__MESSAGE;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_FILE_MARKER__LINE_NUMBER = FILE_MARKER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_FILE_MARKER__START = FILE_MARKER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_FILE_MARKER__END = FILE_MARKER_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Source File Marker</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_FILE_MARKER_FEATURE_COUNT = FILE_MARKER_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Source File Marker</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_FILE_MARKER_OPERATION_COUNT = FILE_MARKER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link no.hal.eclipsky.services.workspace.model.impl.CompletionEditorServiceImpl <em>Completion Editor Service</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hal.eclipsky.services.workspace.model.impl.CompletionEditorServiceImpl
	 * @see no.hal.eclipsky.services.workspace.model.impl.ModelPackageImpl#getCompletionEditorService()
	 * @generated
	 */
	int COMPLETION_EDITOR_SERVICE = 16;

	/**
	 * The feature id for the '<em><b>Request Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETION_EDITOR_SERVICE__REQUEST_TIME = SOURCE_EDITOR_SERVICE__REQUEST_TIME;

	/**
	 * The feature id for the '<em><b>Response Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETION_EDITOR_SERVICE__RESPONSE_TIME = SOURCE_EDITOR_SERVICE__RESPONSE_TIME;

	/**
	 * The feature id for the '<em><b>Resource Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETION_EDITOR_SERVICE__RESOURCE_REF = SOURCE_EDITOR_SERVICE__RESOURCE_REF;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETION_EDITOR_SERVICE__POSITION = SOURCE_EDITOR_SERVICE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Proposals</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETION_EDITOR_SERVICE__PROPOSALS = SOURCE_EDITOR_SERVICE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Completion Editor Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETION_EDITOR_SERVICE_FEATURE_COUNT = SOURCE_EDITOR_SERVICE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Completion Editor Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETION_EDITOR_SERVICE_OPERATION_COUNT = SOURCE_EDITOR_SERVICE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link no.hal.eclipsky.services.workspace.model.impl.CompletionProposalImpl <em>Completion Proposal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hal.eclipsky.services.workspace.model.impl.CompletionProposalImpl
	 * @see no.hal.eclipsky.services.workspace.model.impl.ModelPackageImpl#getCompletionProposal()
	 * @generated
	 */
	int COMPLETION_PROPOSAL = 17;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETION_PROPOSAL__NAME = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETION_PROPOSAL__VALUE = 1;

	/**
	 * The feature id for the '<em><b>Score</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETION_PROPOSAL__SCORE = 2;

	/**
	 * The number of structural features of the '<em>Completion Proposal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETION_PROPOSAL_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Completion Proposal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETION_PROPOSAL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link no.hal.eclipsky.services.workspace.model.impl.CloseEditorServiceImpl <em>Close Editor Service</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hal.eclipsky.services.workspace.model.impl.CloseEditorServiceImpl
	 * @see no.hal.eclipsky.services.workspace.model.impl.ModelPackageImpl#getCloseEditorService()
	 * @generated
	 */
	int CLOSE_EDITOR_SERVICE = 18;

	/**
	 * The feature id for the '<em><b>Request Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOSE_EDITOR_SERVICE__REQUEST_TIME = RESOURCE_SERVICE__REQUEST_TIME;

	/**
	 * The feature id for the '<em><b>Response Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOSE_EDITOR_SERVICE__RESPONSE_TIME = RESOURCE_SERVICE__RESPONSE_TIME;

	/**
	 * The feature id for the '<em><b>Resource Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOSE_EDITOR_SERVICE__RESOURCE_REF = RESOURCE_SERVICE__RESOURCE_REF;

	/**
	 * The number of structural features of the '<em>Close Editor Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOSE_EDITOR_SERVICE_FEATURE_COUNT = RESOURCE_SERVICE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Close Editor Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOSE_EDITOR_SERVICE_OPERATION_COUNT = RESOURCE_SERVICE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link no.hal.eclipsky.services.workspace.model.impl.ExecutionServiceImpl <em>Execution Service</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hal.eclipsky.services.workspace.model.impl.ExecutionServiceImpl
	 * @see no.hal.eclipsky.services.workspace.model.impl.ModelPackageImpl#getExecutionService()
	 * @generated
	 */
	int EXECUTION_SERVICE = 19;

	/**
	 * The feature id for the '<em><b>Request Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_SERVICE__REQUEST_TIME = RESOURCE_SERVICE__REQUEST_TIME;

	/**
	 * The feature id for the '<em><b>Response Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_SERVICE__RESPONSE_TIME = RESOURCE_SERVICE__RESPONSE_TIME;

	/**
	 * The feature id for the '<em><b>Resource Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_SERVICE__RESOURCE_REF = RESOURCE_SERVICE__RESOURCE_REF;

	/**
	 * The feature id for the '<em><b>Result</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_SERVICE__RESULT = RESOURCE_SERVICE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Execution Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_SERVICE_FEATURE_COUNT = RESOURCE_SERVICE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Execution Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_SERVICE_OPERATION_COUNT = RESOURCE_SERVICE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link no.hal.eclipsky.services.workspace.model.impl.ExecutionResultImpl <em>Execution Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hal.eclipsky.services.workspace.model.impl.ExecutionResultImpl
	 * @see no.hal.eclipsky.services.workspace.model.impl.ModelPackageImpl#getExecutionResult()
	 * @generated
	 */
	int EXECUTION_RESULT = 20;

	/**
	 * The feature id for the '<em><b>Sysout</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_RESULT__SYSOUT = 0;

	/**
	 * The feature id for the '<em><b>Syserr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_RESULT__SYSERR = 1;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_RESULT__QUALIFIED_NAME = 2;

	/**
	 * The feature id for the '<em><b>Exception Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_RESULT__EXCEPTION_LOCATION = 3;

	/**
	 * The number of structural features of the '<em>Execution Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_RESULT_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Execution Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_RESULT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link no.hal.eclipsky.services.workspace.model.impl.RunEditorServiceImpl <em>Run Editor Service</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hal.eclipsky.services.workspace.model.impl.RunEditorServiceImpl
	 * @see no.hal.eclipsky.services.workspace.model.impl.ModelPackageImpl#getRunEditorService()
	 * @generated
	 */
	int RUN_EDITOR_SERVICE = 21;

	/**
	 * The feature id for the '<em><b>Request Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUN_EDITOR_SERVICE__REQUEST_TIME = EXECUTION_SERVICE__REQUEST_TIME;

	/**
	 * The feature id for the '<em><b>Response Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUN_EDITOR_SERVICE__RESPONSE_TIME = EXECUTION_SERVICE__RESPONSE_TIME;

	/**
	 * The feature id for the '<em><b>Resource Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUN_EDITOR_SERVICE__RESOURCE_REF = EXECUTION_SERVICE__RESOURCE_REF;

	/**
	 * The feature id for the '<em><b>Result</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUN_EDITOR_SERVICE__RESULT = EXECUTION_SERVICE__RESULT;

	/**
	 * The number of structural features of the '<em>Run Editor Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUN_EDITOR_SERVICE_FEATURE_COUNT = EXECUTION_SERVICE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Run Editor Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUN_EDITOR_SERVICE_OPERATION_COUNT = EXECUTION_SERVICE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link no.hal.eclipsky.services.workspace.model.impl.TestEditorServiceImpl <em>Test Editor Service</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hal.eclipsky.services.workspace.model.impl.TestEditorServiceImpl
	 * @see no.hal.eclipsky.services.workspace.model.impl.ModelPackageImpl#getTestEditorService()
	 * @generated
	 */
	int TEST_EDITOR_SERVICE = 22;

	/**
	 * The feature id for the '<em><b>Request Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_EDITOR_SERVICE__REQUEST_TIME = EXECUTION_SERVICE__REQUEST_TIME;

	/**
	 * The feature id for the '<em><b>Response Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_EDITOR_SERVICE__RESPONSE_TIME = EXECUTION_SERVICE__RESPONSE_TIME;

	/**
	 * The feature id for the '<em><b>Resource Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_EDITOR_SERVICE__RESOURCE_REF = EXECUTION_SERVICE__RESOURCE_REF;

	/**
	 * The feature id for the '<em><b>Result</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_EDITOR_SERVICE__RESULT = EXECUTION_SERVICE__RESULT;

	/**
	 * The number of structural features of the '<em>Test Editor Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_EDITOR_SERVICE_FEATURE_COUNT = EXECUTION_SERVICE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Test Editor Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_EDITOR_SERVICE_OPERATION_COUNT = EXECUTION_SERVICE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link no.hal.eclipsky.services.workspace.model.impl.TestResultImpl <em>Test Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hal.eclipsky.services.workspace.model.impl.TestResultImpl
	 * @see no.hal.eclipsky.services.workspace.model.impl.ModelPackageImpl#getTestResult()
	 * @generated
	 */
	int TEST_RESULT = 23;

	/**
	 * The feature id for the '<em><b>Sysout</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_RESULT__SYSOUT = EXECUTION_RESULT__SYSOUT;

	/**
	 * The feature id for the '<em><b>Syserr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_RESULT__SYSERR = EXECUTION_RESULT__SYSERR;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_RESULT__QUALIFIED_NAME = EXECUTION_RESULT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Exception Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_RESULT__EXCEPTION_LOCATION = EXECUTION_RESULT__EXCEPTION_LOCATION;

	/**
	 * The feature id for the '<em><b>Results</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_RESULT__RESULTS = EXECUTION_RESULT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Test Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_RESULT_FEATURE_COUNT = EXECUTION_RESULT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Test Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_RESULT_OPERATION_COUNT = EXECUTION_RESULT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link no.hal.eclipsky.services.workspace.model.impl.TestCaseResultImpl <em>Test Case Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hal.eclipsky.services.workspace.model.impl.TestCaseResultImpl
	 * @see no.hal.eclipsky.services.workspace.model.impl.ModelPackageImpl#getTestCaseResult()
	 * @generated
	 */
	int TEST_CASE_RESULT = 24;

	/**
	 * The feature id for the '<em><b>Test Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CASE_RESULT__TEST_NAME = 0;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CASE_RESULT__KIND = 1;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CASE_RESULT__MESSAGE = 2;

	/**
	 * The feature id for the '<em><b>Exception</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CASE_RESULT__EXCEPTION = 3;

	/**
	 * The number of structural features of the '<em>Test Case Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CASE_RESULT_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Test Case Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CASE_RESULT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link no.hal.eclipsky.services.workspace.model.ResultKind <em>Result Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hal.eclipsky.services.workspace.model.ResultKind
	 * @see no.hal.eclipsky.services.workspace.model.impl.ModelPackageImpl#getResultKind()
	 * @generated
	 */
	int RESULT_KIND = 25;

	/**
	 * The meta object id for the '{@link no.hal.eclipsky.services.workspace.model.SeverityKind <em>Severity Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hal.eclipsky.services.workspace.model.SeverityKind
	 * @see no.hal.eclipsky.services.workspace.model.impl.ModelPackageImpl#getSeverityKind()
	 * @generated
	 */
	int SEVERITY_KIND = 26;

	/**
	 * The meta object id for the '<em>ETimestamp</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hal.eclipsky.services.workspace.model.impl.ModelPackageImpl#getETimestamp()
	 * @generated
	 */
	int ETIMESTAMP = 27;

	/**
	 * The meta object id for the '<em>EProject Ref</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hal.eclipsky.services.common.ProjectRef
	 * @see no.hal.eclipsky.services.workspace.model.impl.ModelPackageImpl#getEProjectRef()
	 * @generated
	 */
	int EPROJECT_REF = 28;

	/**
	 * The meta object id for the '<em>EResource Ref</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hal.eclipsky.services.common.ResourceRef
	 * @see no.hal.eclipsky.services.workspace.model.impl.ModelPackageImpl#getEResourceRef()
	 * @generated
	 */
	int ERESOURCE_REF = 29;


	/**
	 * Returns the meta object for class '{@link no.hal.eclipsky.services.workspace.model.AbstractService <em>Abstract Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Service</em>'.
	 * @see no.hal.eclipsky.services.workspace.model.AbstractService
	 * @generated
	 */
	EClass getAbstractService();

	/**
	 * Returns the meta object for the attribute '{@link no.hal.eclipsky.services.workspace.model.AbstractService#getRequestTime <em>Request Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Request Time</em>'.
	 * @see no.hal.eclipsky.services.workspace.model.AbstractService#getRequestTime()
	 * @see #getAbstractService()
	 * @generated
	 */
	EAttribute getAbstractService_RequestTime();

	/**
	 * Returns the meta object for the attribute '{@link no.hal.eclipsky.services.workspace.model.AbstractService#getResponseTime <em>Response Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Response Time</em>'.
	 * @see no.hal.eclipsky.services.workspace.model.AbstractService#getResponseTime()
	 * @see #getAbstractService()
	 * @generated
	 */
	EAttribute getAbstractService_ResponseTime();

	/**
	 * Returns the meta object for class '{@link no.hal.eclipsky.services.workspace.model.ProjectService <em>Project Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Project Service</em>'.
	 * @see no.hal.eclipsky.services.workspace.model.ProjectService
	 * @generated
	 */
	EClass getProjectService();

	/**
	 * Returns the meta object for the attribute '{@link no.hal.eclipsky.services.workspace.model.ProjectService#getProjectRef <em>Project Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Project Ref</em>'.
	 * @see no.hal.eclipsky.services.workspace.model.ProjectService#getProjectRef()
	 * @see #getProjectService()
	 * @generated
	 */
	EAttribute getProjectService_ProjectRef();

	/**
	 * Returns the meta object for class '{@link no.hal.eclipsky.services.workspace.model.ResourceService <em>Resource Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Service</em>'.
	 * @see no.hal.eclipsky.services.workspace.model.ResourceService
	 * @generated
	 */
	EClass getResourceService();

	/**
	 * Returns the meta object for the attribute '{@link no.hal.eclipsky.services.workspace.model.ResourceService#getResourceRef <em>Resource Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Resource Ref</em>'.
	 * @see no.hal.eclipsky.services.workspace.model.ResourceService#getResourceRef()
	 * @see #getResourceService()
	 * @generated
	 */
	EAttribute getResourceService_ResourceRef();

	/**
	 * Returns the meta object for class '{@link no.hal.eclipsky.services.workspace.model.EnsureProjectService <em>Ensure Project Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ensure Project Service</em>'.
	 * @see no.hal.eclipsky.services.workspace.model.EnsureProjectService
	 * @generated
	 */
	EClass getEnsureProjectService();

	/**
	 * Returns the meta object for the reference '{@link no.hal.eclipsky.services.workspace.model.EnsureProjectService#getEmfs <em>Emfs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Emfs</em>'.
	 * @see no.hal.eclipsky.services.workspace.model.EnsureProjectService#getEmfs()
	 * @see #getEnsureProjectService()
	 * @generated
	 */
	EReference getEnsureProjectService_Emfs();

	/**
	 * Returns the meta object for class '{@link no.hal.eclipsky.services.workspace.model.ProjectListService <em>Project List Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Project List Service</em>'.
	 * @see no.hal.eclipsky.services.workspace.model.ProjectListService
	 * @generated
	 */
	EClass getProjectListService();

	/**
	 * Returns the meta object for the attribute '{@link no.hal.eclipsky.services.workspace.model.ProjectListService#getNamePattern <em>Name Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name Pattern</em>'.
	 * @see no.hal.eclipsky.services.workspace.model.ProjectListService#getNamePattern()
	 * @see #getProjectListService()
	 * @generated
	 */
	EAttribute getProjectListService_NamePattern();

	/**
	 * Returns the meta object for the attribute '{@link no.hal.eclipsky.services.workspace.model.ProjectListService#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see no.hal.eclipsky.services.workspace.model.ProjectListService#getType()
	 * @see #getProjectListService()
	 * @generated
	 */
	EAttribute getProjectListService_Type();

	/**
	 * Returns the meta object for the containment reference '{@link no.hal.eclipsky.services.workspace.model.ProjectListService#getResponseOptions <em>Response Options</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Response Options</em>'.
	 * @see no.hal.eclipsky.services.workspace.model.ProjectListService#getResponseOptions()
	 * @see #getProjectListService()
	 * @generated
	 */
	EReference getProjectListService_ResponseOptions();

	/**
	 * Returns the meta object for the containment reference list '{@link no.hal.eclipsky.services.workspace.model.ProjectListService#getProjects <em>Projects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Projects</em>'.
	 * @see no.hal.eclipsky.services.workspace.model.ProjectListService#getProjects()
	 * @see #getProjectListService()
	 * @generated
	 */
	EReference getProjectListService_Projects();

	/**
	 * Returns the meta object for class '{@link no.hal.eclipsky.services.workspace.model.ProjectResponseOptions <em>Project Response Options</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Project Response Options</em>'.
	 * @see no.hal.eclipsky.services.workspace.model.ProjectResponseOptions
	 * @generated
	 */
	EClass getProjectResponseOptions();

	/**
	 * Returns the meta object for the attribute '{@link no.hal.eclipsky.services.workspace.model.ProjectResponseOptions#isIncludeResources <em>Include Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Include Resources</em>'.
	 * @see no.hal.eclipsky.services.workspace.model.ProjectResponseOptions#isIncludeResources()
	 * @see #getProjectResponseOptions()
	 * @generated
	 */
	EAttribute getProjectResponseOptions_IncludeResources();

	/**
	 * Returns the meta object for the containment reference '{@link no.hal.eclipsky.services.workspace.model.ProjectResponseOptions#getResourceResponseOptions <em>Resource Response Options</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Resource Response Options</em>'.
	 * @see no.hal.eclipsky.services.workspace.model.ProjectResponseOptions#getResourceResponseOptions()
	 * @see #getProjectResponseOptions()
	 * @generated
	 */
	EReference getProjectResponseOptions_ResourceResponseOptions();

	/**
	 * Returns the meta object for class '{@link no.hal.eclipsky.services.workspace.model.ResourceResponseOptions <em>Resource Response Options</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Response Options</em>'.
	 * @see no.hal.eclipsky.services.workspace.model.ResourceResponseOptions
	 * @generated
	 */
	EClass getResourceResponseOptions();

	/**
	 * Returns the meta object for the attribute '{@link no.hal.eclipsky.services.workspace.model.ResourceResponseOptions#isIncludeContents <em>Include Contents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Include Contents</em>'.
	 * @see no.hal.eclipsky.services.workspace.model.ResourceResponseOptions#isIncludeContents()
	 * @see #getResourceResponseOptions()
	 * @generated
	 */
	EAttribute getResourceResponseOptions_IncludeContents();

	/**
	 * Returns the meta object for the attribute '{@link no.hal.eclipsky.services.workspace.model.ResourceResponseOptions#isIncludeMarkers <em>Include Markers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Include Markers</em>'.
	 * @see no.hal.eclipsky.services.workspace.model.ResourceResponseOptions#isIncludeMarkers()
	 * @see #getResourceResponseOptions()
	 * @generated
	 */
	EAttribute getResourceResponseOptions_IncludeMarkers();

	/**
	 * Returns the meta object for class '{@link no.hal.eclipsky.services.workspace.model.ProjectInfo <em>Project Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Project Info</em>'.
	 * @see no.hal.eclipsky.services.workspace.model.ProjectInfo
	 * @generated
	 */
	EClass getProjectInfo();

	/**
	 * Returns the meta object for the attribute '{@link no.hal.eclipsky.services.workspace.model.ProjectInfo#getProjectRef <em>Project Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Project Ref</em>'.
	 * @see no.hal.eclipsky.services.workspace.model.ProjectInfo#getProjectRef()
	 * @see #getProjectInfo()
	 * @generated
	 */
	EAttribute getProjectInfo_ProjectRef();

	/**
	 * Returns the meta object for the containment reference list '{@link no.hal.eclipsky.services.workspace.model.ProjectInfo#getResources <em>Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resources</em>'.
	 * @see no.hal.eclipsky.services.workspace.model.ProjectInfo#getResources()
	 * @see #getProjectInfo()
	 * @generated
	 */
	EReference getProjectInfo_Resources();

	/**
	 * Returns the meta object for class '{@link no.hal.eclipsky.services.workspace.model.ResourceInfo <em>Resource Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Info</em>'.
	 * @see no.hal.eclipsky.services.workspace.model.ResourceInfo
	 * @generated
	 */
	EClass getResourceInfo();

	/**
	 * Returns the meta object for the attribute '{@link no.hal.eclipsky.services.workspace.model.ResourceInfo#getResourceRef <em>Resource Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Resource Ref</em>'.
	 * @see no.hal.eclipsky.services.workspace.model.ResourceInfo#getResourceRef()
	 * @see #getResourceInfo()
	 * @generated
	 */
	EAttribute getResourceInfo_ResourceRef();

	/**
	 * Returns the meta object for the containment reference '{@link no.hal.eclipsky.services.workspace.model.ResourceInfo#getContents <em>Contents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Contents</em>'.
	 * @see no.hal.eclipsky.services.workspace.model.ResourceInfo#getContents()
	 * @see #getResourceInfo()
	 * @generated
	 */
	EReference getResourceInfo_Contents();

	/**
	 * Returns the meta object for the containment reference list '{@link no.hal.eclipsky.services.workspace.model.ResourceInfo#getMarkers <em>Markers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Markers</em>'.
	 * @see no.hal.eclipsky.services.workspace.model.ResourceInfo#getMarkers()
	 * @see #getResourceInfo()
	 * @generated
	 */
	EReference getResourceInfo_Markers();

	/**
	 * Returns the meta object for class '{@link no.hal.eclipsky.services.workspace.model.SourceEditorService <em>Source Editor Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Source Editor Service</em>'.
	 * @see no.hal.eclipsky.services.workspace.model.SourceEditorService
	 * @generated
	 */
	EClass getSourceEditorService();

	/**
	 * Returns the meta object for class '{@link no.hal.eclipsky.services.workspace.model.ResourceInfoService <em>Resource Info Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Info Service</em>'.
	 * @see no.hal.eclipsky.services.workspace.model.ResourceInfoService
	 * @generated
	 */
	EClass getResourceInfoService();

	/**
	 * Returns the meta object for the containment reference '{@link no.hal.eclipsky.services.workspace.model.ResourceInfoService#getResponseOptions <em>Response Options</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Response Options</em>'.
	 * @see no.hal.eclipsky.services.workspace.model.ResourceInfoService#getResponseOptions()
	 * @see #getResourceInfoService()
	 * @generated
	 */
	EReference getResourceInfoService_ResponseOptions();

	/**
	 * Returns the meta object for the containment reference '{@link no.hal.eclipsky.services.workspace.model.ResourceInfoService#getResource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Resource</em>'.
	 * @see no.hal.eclipsky.services.workspace.model.ResourceInfoService#getResource()
	 * @see #getResourceInfoService()
	 * @generated
	 */
	EReference getResourceInfoService_Resource();

	/**
	 * Returns the meta object for class '{@link no.hal.eclipsky.services.workspace.model.RefreshEditorService <em>Refresh Editor Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Refresh Editor Service</em>'.
	 * @see no.hal.eclipsky.services.workspace.model.RefreshEditorService
	 * @generated
	 */
	EClass getRefreshEditorService();

	/**
	 * Returns the meta object for the containment reference '{@link no.hal.eclipsky.services.workspace.model.RefreshEditorService#getResource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Resource</em>'.
	 * @see no.hal.eclipsky.services.workspace.model.RefreshEditorService#getResource()
	 * @see #getRefreshEditorService()
	 * @generated
	 */
	EReference getRefreshEditorService_Resource();

	/**
	 * Returns the meta object for class '{@link no.hal.eclipsky.services.workspace.model.MarkersEditorService <em>Markers Editor Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Markers Editor Service</em>'.
	 * @see no.hal.eclipsky.services.workspace.model.MarkersEditorService
	 * @generated
	 */
	EClass getMarkersEditorService();

	/**
	 * Returns the meta object for the containment reference '{@link no.hal.eclipsky.services.workspace.model.MarkersEditorService#getMarkers <em>Markers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Markers</em>'.
	 * @see no.hal.eclipsky.services.workspace.model.MarkersEditorService#getMarkers()
	 * @see #getMarkersEditorService()
	 * @generated
	 */
	EReference getMarkersEditorService_Markers();

	/**
	 * Returns the meta object for class '{@link no.hal.eclipsky.services.workspace.model.UpdateEditorService <em>Update Editor Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Update Editor Service</em>'.
	 * @see no.hal.eclipsky.services.workspace.model.UpdateEditorService
	 * @generated
	 */
	EClass getUpdateEditorService();

	/**
	 * Returns the meta object for the containment reference '{@link no.hal.eclipsky.services.workspace.model.UpdateEditorService#getContents <em>Contents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Contents</em>'.
	 * @see no.hal.eclipsky.services.workspace.model.UpdateEditorService#getContents()
	 * @see #getUpdateEditorService()
	 * @generated
	 */
	EReference getUpdateEditorService_Contents();

	/**
	 * Returns the meta object for class '{@link no.hal.eclipsky.services.workspace.model.FileMarker <em>File Marker</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>File Marker</em>'.
	 * @see no.hal.eclipsky.services.workspace.model.FileMarker
	 * @generated
	 */
	EClass getFileMarker();

	/**
	 * Returns the meta object for the attribute '{@link no.hal.eclipsky.services.workspace.model.FileMarker#getSeverity <em>Severity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Severity</em>'.
	 * @see no.hal.eclipsky.services.workspace.model.FileMarker#getSeverity()
	 * @see #getFileMarker()
	 * @generated
	 */
	EAttribute getFileMarker_Severity();

	/**
	 * Returns the meta object for the attribute '{@link no.hal.eclipsky.services.workspace.model.FileMarker#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message</em>'.
	 * @see no.hal.eclipsky.services.workspace.model.FileMarker#getMessage()
	 * @see #getFileMarker()
	 * @generated
	 */
	EAttribute getFileMarker_Message();

	/**
	 * Returns the meta object for class '{@link no.hal.eclipsky.services.workspace.model.SourceFileMarker <em>Source File Marker</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Source File Marker</em>'.
	 * @see no.hal.eclipsky.services.workspace.model.SourceFileMarker
	 * @generated
	 */
	EClass getSourceFileMarker();

	/**
	 * Returns the meta object for the attribute '{@link no.hal.eclipsky.services.workspace.model.SourceFileMarker#getLineNumber <em>Line Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line Number</em>'.
	 * @see no.hal.eclipsky.services.workspace.model.SourceFileMarker#getLineNumber()
	 * @see #getSourceFileMarker()
	 * @generated
	 */
	EAttribute getSourceFileMarker_LineNumber();

	/**
	 * Returns the meta object for the attribute '{@link no.hal.eclipsky.services.workspace.model.SourceFileMarker#getStart <em>Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start</em>'.
	 * @see no.hal.eclipsky.services.workspace.model.SourceFileMarker#getStart()
	 * @see #getSourceFileMarker()
	 * @generated
	 */
	EAttribute getSourceFileMarker_Start();

	/**
	 * Returns the meta object for the attribute '{@link no.hal.eclipsky.services.workspace.model.SourceFileMarker#getEnd <em>End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End</em>'.
	 * @see no.hal.eclipsky.services.workspace.model.SourceFileMarker#getEnd()
	 * @see #getSourceFileMarker()
	 * @generated
	 */
	EAttribute getSourceFileMarker_End();

	/**
	 * Returns the meta object for class '{@link no.hal.eclipsky.services.workspace.model.CompletionEditorService <em>Completion Editor Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Completion Editor Service</em>'.
	 * @see no.hal.eclipsky.services.workspace.model.CompletionEditorService
	 * @generated
	 */
	EClass getCompletionEditorService();

	/**
	 * Returns the meta object for the attribute '{@link no.hal.eclipsky.services.workspace.model.CompletionEditorService#getPosition <em>Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Position</em>'.
	 * @see no.hal.eclipsky.services.workspace.model.CompletionEditorService#getPosition()
	 * @see #getCompletionEditorService()
	 * @generated
	 */
	EAttribute getCompletionEditorService_Position();

	/**
	 * Returns the meta object for the containment reference list '{@link no.hal.eclipsky.services.workspace.model.CompletionEditorService#getProposals <em>Proposals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Proposals</em>'.
	 * @see no.hal.eclipsky.services.workspace.model.CompletionEditorService#getProposals()
	 * @see #getCompletionEditorService()
	 * @generated
	 */
	EReference getCompletionEditorService_Proposals();

	/**
	 * Returns the meta object for class '{@link no.hal.eclipsky.services.workspace.model.CompletionProposal <em>Completion Proposal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Completion Proposal</em>'.
	 * @see no.hal.eclipsky.services.workspace.model.CompletionProposal
	 * @generated
	 */
	EClass getCompletionProposal();

	/**
	 * Returns the meta object for the attribute '{@link no.hal.eclipsky.services.workspace.model.CompletionProposal#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see no.hal.eclipsky.services.workspace.model.CompletionProposal#getName()
	 * @see #getCompletionProposal()
	 * @generated
	 */
	EAttribute getCompletionProposal_Name();

	/**
	 * Returns the meta object for the attribute '{@link no.hal.eclipsky.services.workspace.model.CompletionProposal#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see no.hal.eclipsky.services.workspace.model.CompletionProposal#getValue()
	 * @see #getCompletionProposal()
	 * @generated
	 */
	EAttribute getCompletionProposal_Value();

	/**
	 * Returns the meta object for the attribute '{@link no.hal.eclipsky.services.workspace.model.CompletionProposal#getScore <em>Score</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Score</em>'.
	 * @see no.hal.eclipsky.services.workspace.model.CompletionProposal#getScore()
	 * @see #getCompletionProposal()
	 * @generated
	 */
	EAttribute getCompletionProposal_Score();

	/**
	 * Returns the meta object for class '{@link no.hal.eclipsky.services.workspace.model.CloseEditorService <em>Close Editor Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Close Editor Service</em>'.
	 * @see no.hal.eclipsky.services.workspace.model.CloseEditorService
	 * @generated
	 */
	EClass getCloseEditorService();

	/**
	 * Returns the meta object for class '{@link no.hal.eclipsky.services.workspace.model.ExecutionService <em>Execution Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Execution Service</em>'.
	 * @see no.hal.eclipsky.services.workspace.model.ExecutionService
	 * @generated
	 */
	EClass getExecutionService();

	/**
	 * Returns the meta object for the containment reference '{@link no.hal.eclipsky.services.workspace.model.ExecutionService#getResult <em>Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Result</em>'.
	 * @see no.hal.eclipsky.services.workspace.model.ExecutionService#getResult()
	 * @see #getExecutionService()
	 * @generated
	 */
	EReference getExecutionService_Result();

	/**
	 * Returns the meta object for class '{@link no.hal.eclipsky.services.workspace.model.ExecutionResult <em>Execution Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Execution Result</em>'.
	 * @see no.hal.eclipsky.services.workspace.model.ExecutionResult
	 * @generated
	 */
	EClass getExecutionResult();

	/**
	 * Returns the meta object for the containment reference '{@link no.hal.eclipsky.services.workspace.model.ExecutionResult#getSysout <em>Sysout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Sysout</em>'.
	 * @see no.hal.eclipsky.services.workspace.model.ExecutionResult#getSysout()
	 * @see #getExecutionResult()
	 * @generated
	 */
	EReference getExecutionResult_Sysout();

	/**
	 * Returns the meta object for the containment reference '{@link no.hal.eclipsky.services.workspace.model.ExecutionResult#getSyserr <em>Syserr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Syserr</em>'.
	 * @see no.hal.eclipsky.services.workspace.model.ExecutionResult#getSyserr()
	 * @see #getExecutionResult()
	 * @generated
	 */
	EReference getExecutionResult_Syserr();

	/**
	 * Returns the meta object for the attribute '{@link no.hal.eclipsky.services.workspace.model.ExecutionResult#getQualifiedName <em>Qualified Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Qualified Name</em>'.
	 * @see no.hal.eclipsky.services.workspace.model.ExecutionResult#getQualifiedName()
	 * @see #getExecutionResult()
	 * @generated
	 */
	EAttribute getExecutionResult_QualifiedName();

	/**
	 * Returns the meta object for the containment reference '{@link no.hal.eclipsky.services.workspace.model.ExecutionResult#getExceptionLocation <em>Exception Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Exception Location</em>'.
	 * @see no.hal.eclipsky.services.workspace.model.ExecutionResult#getExceptionLocation()
	 * @see #getExecutionResult()
	 * @generated
	 */
	EReference getExecutionResult_ExceptionLocation();

	/**
	 * Returns the meta object for class '{@link no.hal.eclipsky.services.workspace.model.RunEditorService <em>Run Editor Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Run Editor Service</em>'.
	 * @see no.hal.eclipsky.services.workspace.model.RunEditorService
	 * @generated
	 */
	EClass getRunEditorService();

	/**
	 * Returns the meta object for class '{@link no.hal.eclipsky.services.workspace.model.TestEditorService <em>Test Editor Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test Editor Service</em>'.
	 * @see no.hal.eclipsky.services.workspace.model.TestEditorService
	 * @generated
	 */
	EClass getTestEditorService();

	/**
	 * Returns the meta object for class '{@link no.hal.eclipsky.services.workspace.model.TestResult <em>Test Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test Result</em>'.
	 * @see no.hal.eclipsky.services.workspace.model.TestResult
	 * @generated
	 */
	EClass getTestResult();

	/**
	 * Returns the meta object for the containment reference list '{@link no.hal.eclipsky.services.workspace.model.TestResult#getResults <em>Results</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Results</em>'.
	 * @see no.hal.eclipsky.services.workspace.model.TestResult#getResults()
	 * @see #getTestResult()
	 * @generated
	 */
	EReference getTestResult_Results();

	/**
	 * Returns the meta object for class '{@link no.hal.eclipsky.services.workspace.model.TestCaseResult <em>Test Case Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test Case Result</em>'.
	 * @see no.hal.eclipsky.services.workspace.model.TestCaseResult
	 * @generated
	 */
	EClass getTestCaseResult();

	/**
	 * Returns the meta object for the attribute '{@link no.hal.eclipsky.services.workspace.model.TestCaseResult#getTestName <em>Test Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Test Name</em>'.
	 * @see no.hal.eclipsky.services.workspace.model.TestCaseResult#getTestName()
	 * @see #getTestCaseResult()
	 * @generated
	 */
	EAttribute getTestCaseResult_TestName();

	/**
	 * Returns the meta object for the attribute '{@link no.hal.eclipsky.services.workspace.model.TestCaseResult#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see no.hal.eclipsky.services.workspace.model.TestCaseResult#getKind()
	 * @see #getTestCaseResult()
	 * @generated
	 */
	EAttribute getTestCaseResult_Kind();

	/**
	 * Returns the meta object for the attribute '{@link no.hal.eclipsky.services.workspace.model.TestCaseResult#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message</em>'.
	 * @see no.hal.eclipsky.services.workspace.model.TestCaseResult#getMessage()
	 * @see #getTestCaseResult()
	 * @generated
	 */
	EAttribute getTestCaseResult_Message();

	/**
	 * Returns the meta object for the attribute '{@link no.hal.eclipsky.services.workspace.model.TestCaseResult#getException <em>Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exception</em>'.
	 * @see no.hal.eclipsky.services.workspace.model.TestCaseResult#getException()
	 * @see #getTestCaseResult()
	 * @generated
	 */
	EAttribute getTestCaseResult_Exception();

	/**
	 * Returns the meta object for enum '{@link no.hal.eclipsky.services.workspace.model.ResultKind <em>Result Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Result Kind</em>'.
	 * @see no.hal.eclipsky.services.workspace.model.ResultKind
	 * @generated
	 */
	EEnum getResultKind();

	/**
	 * Returns the meta object for enum '{@link no.hal.eclipsky.services.workspace.model.SeverityKind <em>Severity Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Severity Kind</em>'.
	 * @see no.hal.eclipsky.services.workspace.model.SeverityKind
	 * @generated
	 */
	EEnum getSeverityKind();

	/**
	 * Returns the meta object for data type '<em>ETimestamp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>ETimestamp</em>'.
	 * @model instanceClass="long"
	 * @generated
	 */
	EDataType getETimestamp();

	/**
	 * Returns the meta object for data type '{@link no.hal.eclipsky.services.common.ProjectRef <em>EProject Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>EProject Ref</em>'.
	 * @see no.hal.eclipsky.services.common.ProjectRef
	 * @model instanceClass="no.hal.eclipsky.services.common.ProjectRef"
	 * @generated
	 */
	EDataType getEProjectRef();

	/**
	 * Returns the meta object for data type '{@link no.hal.eclipsky.services.common.ResourceRef <em>EResource Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>EResource Ref</em>'.
	 * @see no.hal.eclipsky.services.common.ResourceRef
	 * @model instanceClass="no.hal.eclipsky.services.common.ResourceRef"
	 * @generated
	 */
	EDataType getEResourceRef();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ModelFactory getModelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link no.hal.eclipsky.services.workspace.model.impl.AbstractServiceImpl <em>Abstract Service</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hal.eclipsky.services.workspace.model.impl.AbstractServiceImpl
		 * @see no.hal.eclipsky.services.workspace.model.impl.ModelPackageImpl#getAbstractService()
		 * @generated
		 */
		EClass ABSTRACT_SERVICE = eINSTANCE.getAbstractService();

		/**
		 * The meta object literal for the '<em><b>Request Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_SERVICE__REQUEST_TIME = eINSTANCE.getAbstractService_RequestTime();

		/**
		 * The meta object literal for the '<em><b>Response Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_SERVICE__RESPONSE_TIME = eINSTANCE.getAbstractService_ResponseTime();

		/**
		 * The meta object literal for the '{@link no.hal.eclipsky.services.workspace.model.impl.ProjectServiceImpl <em>Project Service</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hal.eclipsky.services.workspace.model.impl.ProjectServiceImpl
		 * @see no.hal.eclipsky.services.workspace.model.impl.ModelPackageImpl#getProjectService()
		 * @generated
		 */
		EClass PROJECT_SERVICE = eINSTANCE.getProjectService();

		/**
		 * The meta object literal for the '<em><b>Project Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT_SERVICE__PROJECT_REF = eINSTANCE.getProjectService_ProjectRef();

		/**
		 * The meta object literal for the '{@link no.hal.eclipsky.services.workspace.model.impl.ResourceServiceImpl <em>Resource Service</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hal.eclipsky.services.workspace.model.impl.ResourceServiceImpl
		 * @see no.hal.eclipsky.services.workspace.model.impl.ModelPackageImpl#getResourceService()
		 * @generated
		 */
		EClass RESOURCE_SERVICE = eINSTANCE.getResourceService();

		/**
		 * The meta object literal for the '<em><b>Resource Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_SERVICE__RESOURCE_REF = eINSTANCE.getResourceService_ResourceRef();

		/**
		 * The meta object literal for the '{@link no.hal.eclipsky.services.workspace.model.impl.EnsureProjectServiceImpl <em>Ensure Project Service</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hal.eclipsky.services.workspace.model.impl.EnsureProjectServiceImpl
		 * @see no.hal.eclipsky.services.workspace.model.impl.ModelPackageImpl#getEnsureProjectService()
		 * @generated
		 */
		EClass ENSURE_PROJECT_SERVICE = eINSTANCE.getEnsureProjectService();

		/**
		 * The meta object literal for the '<em><b>Emfs</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENSURE_PROJECT_SERVICE__EMFS = eINSTANCE.getEnsureProjectService_Emfs();

		/**
		 * The meta object literal for the '{@link no.hal.eclipsky.services.workspace.model.impl.ProjectListServiceImpl <em>Project List Service</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hal.eclipsky.services.workspace.model.impl.ProjectListServiceImpl
		 * @see no.hal.eclipsky.services.workspace.model.impl.ModelPackageImpl#getProjectListService()
		 * @generated
		 */
		EClass PROJECT_LIST_SERVICE = eINSTANCE.getProjectListService();

		/**
		 * The meta object literal for the '<em><b>Name Pattern</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT_LIST_SERVICE__NAME_PATTERN = eINSTANCE.getProjectListService_NamePattern();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT_LIST_SERVICE__TYPE = eINSTANCE.getProjectListService_Type();

		/**
		 * The meta object literal for the '<em><b>Response Options</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT_LIST_SERVICE__RESPONSE_OPTIONS = eINSTANCE.getProjectListService_ResponseOptions();

		/**
		 * The meta object literal for the '<em><b>Projects</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT_LIST_SERVICE__PROJECTS = eINSTANCE.getProjectListService_Projects();

		/**
		 * The meta object literal for the '{@link no.hal.eclipsky.services.workspace.model.impl.ProjectResponseOptionsImpl <em>Project Response Options</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hal.eclipsky.services.workspace.model.impl.ProjectResponseOptionsImpl
		 * @see no.hal.eclipsky.services.workspace.model.impl.ModelPackageImpl#getProjectResponseOptions()
		 * @generated
		 */
		EClass PROJECT_RESPONSE_OPTIONS = eINSTANCE.getProjectResponseOptions();

		/**
		 * The meta object literal for the '<em><b>Include Resources</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT_RESPONSE_OPTIONS__INCLUDE_RESOURCES = eINSTANCE.getProjectResponseOptions_IncludeResources();

		/**
		 * The meta object literal for the '<em><b>Resource Response Options</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT_RESPONSE_OPTIONS__RESOURCE_RESPONSE_OPTIONS = eINSTANCE.getProjectResponseOptions_ResourceResponseOptions();

		/**
		 * The meta object literal for the '{@link no.hal.eclipsky.services.workspace.model.impl.ResourceResponseOptionsImpl <em>Resource Response Options</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hal.eclipsky.services.workspace.model.impl.ResourceResponseOptionsImpl
		 * @see no.hal.eclipsky.services.workspace.model.impl.ModelPackageImpl#getResourceResponseOptions()
		 * @generated
		 */
		EClass RESOURCE_RESPONSE_OPTIONS = eINSTANCE.getResourceResponseOptions();

		/**
		 * The meta object literal for the '<em><b>Include Contents</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_RESPONSE_OPTIONS__INCLUDE_CONTENTS = eINSTANCE.getResourceResponseOptions_IncludeContents();

		/**
		 * The meta object literal for the '<em><b>Include Markers</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_RESPONSE_OPTIONS__INCLUDE_MARKERS = eINSTANCE.getResourceResponseOptions_IncludeMarkers();

		/**
		 * The meta object literal for the '{@link no.hal.eclipsky.services.workspace.model.impl.ProjectInfoImpl <em>Project Info</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hal.eclipsky.services.workspace.model.impl.ProjectInfoImpl
		 * @see no.hal.eclipsky.services.workspace.model.impl.ModelPackageImpl#getProjectInfo()
		 * @generated
		 */
		EClass PROJECT_INFO = eINSTANCE.getProjectInfo();

		/**
		 * The meta object literal for the '<em><b>Project Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT_INFO__PROJECT_REF = eINSTANCE.getProjectInfo_ProjectRef();

		/**
		 * The meta object literal for the '<em><b>Resources</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT_INFO__RESOURCES = eINSTANCE.getProjectInfo_Resources();

		/**
		 * The meta object literal for the '{@link no.hal.eclipsky.services.workspace.model.impl.ResourceInfoImpl <em>Resource Info</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hal.eclipsky.services.workspace.model.impl.ResourceInfoImpl
		 * @see no.hal.eclipsky.services.workspace.model.impl.ModelPackageImpl#getResourceInfo()
		 * @generated
		 */
		EClass RESOURCE_INFO = eINSTANCE.getResourceInfo();

		/**
		 * The meta object literal for the '<em><b>Resource Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_INFO__RESOURCE_REF = eINSTANCE.getResourceInfo_ResourceRef();

		/**
		 * The meta object literal for the '<em><b>Contents</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_INFO__CONTENTS = eINSTANCE.getResourceInfo_Contents();

		/**
		 * The meta object literal for the '<em><b>Markers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_INFO__MARKERS = eINSTANCE.getResourceInfo_Markers();

		/**
		 * The meta object literal for the '{@link no.hal.eclipsky.services.workspace.model.impl.SourceEditorServiceImpl <em>Source Editor Service</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hal.eclipsky.services.workspace.model.impl.SourceEditorServiceImpl
		 * @see no.hal.eclipsky.services.workspace.model.impl.ModelPackageImpl#getSourceEditorService()
		 * @generated
		 */
		EClass SOURCE_EDITOR_SERVICE = eINSTANCE.getSourceEditorService();

		/**
		 * The meta object literal for the '{@link no.hal.eclipsky.services.workspace.model.impl.ResourceInfoServiceImpl <em>Resource Info Service</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hal.eclipsky.services.workspace.model.impl.ResourceInfoServiceImpl
		 * @see no.hal.eclipsky.services.workspace.model.impl.ModelPackageImpl#getResourceInfoService()
		 * @generated
		 */
		EClass RESOURCE_INFO_SERVICE = eINSTANCE.getResourceInfoService();

		/**
		 * The meta object literal for the '<em><b>Response Options</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_INFO_SERVICE__RESPONSE_OPTIONS = eINSTANCE.getResourceInfoService_ResponseOptions();

		/**
		 * The meta object literal for the '<em><b>Resource</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_INFO_SERVICE__RESOURCE = eINSTANCE.getResourceInfoService_Resource();

		/**
		 * The meta object literal for the '{@link no.hal.eclipsky.services.workspace.model.impl.RefreshEditorServiceImpl <em>Refresh Editor Service</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hal.eclipsky.services.workspace.model.impl.RefreshEditorServiceImpl
		 * @see no.hal.eclipsky.services.workspace.model.impl.ModelPackageImpl#getRefreshEditorService()
		 * @generated
		 */
		EClass REFRESH_EDITOR_SERVICE = eINSTANCE.getRefreshEditorService();

		/**
		 * The meta object literal for the '<em><b>Resource</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFRESH_EDITOR_SERVICE__RESOURCE = eINSTANCE.getRefreshEditorService_Resource();

		/**
		 * The meta object literal for the '{@link no.hal.eclipsky.services.workspace.model.impl.MarkersEditorServiceImpl <em>Markers Editor Service</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hal.eclipsky.services.workspace.model.impl.MarkersEditorServiceImpl
		 * @see no.hal.eclipsky.services.workspace.model.impl.ModelPackageImpl#getMarkersEditorService()
		 * @generated
		 */
		EClass MARKERS_EDITOR_SERVICE = eINSTANCE.getMarkersEditorService();

		/**
		 * The meta object literal for the '<em><b>Markers</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MARKERS_EDITOR_SERVICE__MARKERS = eINSTANCE.getMarkersEditorService_Markers();

		/**
		 * The meta object literal for the '{@link no.hal.eclipsky.services.workspace.model.impl.UpdateEditorServiceImpl <em>Update Editor Service</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hal.eclipsky.services.workspace.model.impl.UpdateEditorServiceImpl
		 * @see no.hal.eclipsky.services.workspace.model.impl.ModelPackageImpl#getUpdateEditorService()
		 * @generated
		 */
		EClass UPDATE_EDITOR_SERVICE = eINSTANCE.getUpdateEditorService();

		/**
		 * The meta object literal for the '<em><b>Contents</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UPDATE_EDITOR_SERVICE__CONTENTS = eINSTANCE.getUpdateEditorService_Contents();

		/**
		 * The meta object literal for the '{@link no.hal.eclipsky.services.workspace.model.impl.FileMarkerImpl <em>File Marker</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hal.eclipsky.services.workspace.model.impl.FileMarkerImpl
		 * @see no.hal.eclipsky.services.workspace.model.impl.ModelPackageImpl#getFileMarker()
		 * @generated
		 */
		EClass FILE_MARKER = eINSTANCE.getFileMarker();

		/**
		 * The meta object literal for the '<em><b>Severity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_MARKER__SEVERITY = eINSTANCE.getFileMarker_Severity();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_MARKER__MESSAGE = eINSTANCE.getFileMarker_Message();

		/**
		 * The meta object literal for the '{@link no.hal.eclipsky.services.workspace.model.impl.SourceFileMarkerImpl <em>Source File Marker</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hal.eclipsky.services.workspace.model.impl.SourceFileMarkerImpl
		 * @see no.hal.eclipsky.services.workspace.model.impl.ModelPackageImpl#getSourceFileMarker()
		 * @generated
		 */
		EClass SOURCE_FILE_MARKER = eINSTANCE.getSourceFileMarker();

		/**
		 * The meta object literal for the '<em><b>Line Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOURCE_FILE_MARKER__LINE_NUMBER = eINSTANCE.getSourceFileMarker_LineNumber();

		/**
		 * The meta object literal for the '<em><b>Start</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOURCE_FILE_MARKER__START = eINSTANCE.getSourceFileMarker_Start();

		/**
		 * The meta object literal for the '<em><b>End</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOURCE_FILE_MARKER__END = eINSTANCE.getSourceFileMarker_End();

		/**
		 * The meta object literal for the '{@link no.hal.eclipsky.services.workspace.model.impl.CompletionEditorServiceImpl <em>Completion Editor Service</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hal.eclipsky.services.workspace.model.impl.CompletionEditorServiceImpl
		 * @see no.hal.eclipsky.services.workspace.model.impl.ModelPackageImpl#getCompletionEditorService()
		 * @generated
		 */
		EClass COMPLETION_EDITOR_SERVICE = eINSTANCE.getCompletionEditorService();

		/**
		 * The meta object literal for the '<em><b>Position</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPLETION_EDITOR_SERVICE__POSITION = eINSTANCE.getCompletionEditorService_Position();

		/**
		 * The meta object literal for the '<em><b>Proposals</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLETION_EDITOR_SERVICE__PROPOSALS = eINSTANCE.getCompletionEditorService_Proposals();

		/**
		 * The meta object literal for the '{@link no.hal.eclipsky.services.workspace.model.impl.CompletionProposalImpl <em>Completion Proposal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hal.eclipsky.services.workspace.model.impl.CompletionProposalImpl
		 * @see no.hal.eclipsky.services.workspace.model.impl.ModelPackageImpl#getCompletionProposal()
		 * @generated
		 */
		EClass COMPLETION_PROPOSAL = eINSTANCE.getCompletionProposal();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPLETION_PROPOSAL__NAME = eINSTANCE.getCompletionProposal_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPLETION_PROPOSAL__VALUE = eINSTANCE.getCompletionProposal_Value();

		/**
		 * The meta object literal for the '<em><b>Score</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPLETION_PROPOSAL__SCORE = eINSTANCE.getCompletionProposal_Score();

		/**
		 * The meta object literal for the '{@link no.hal.eclipsky.services.workspace.model.impl.CloseEditorServiceImpl <em>Close Editor Service</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hal.eclipsky.services.workspace.model.impl.CloseEditorServiceImpl
		 * @see no.hal.eclipsky.services.workspace.model.impl.ModelPackageImpl#getCloseEditorService()
		 * @generated
		 */
		EClass CLOSE_EDITOR_SERVICE = eINSTANCE.getCloseEditorService();

		/**
		 * The meta object literal for the '{@link no.hal.eclipsky.services.workspace.model.impl.ExecutionServiceImpl <em>Execution Service</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hal.eclipsky.services.workspace.model.impl.ExecutionServiceImpl
		 * @see no.hal.eclipsky.services.workspace.model.impl.ModelPackageImpl#getExecutionService()
		 * @generated
		 */
		EClass EXECUTION_SERVICE = eINSTANCE.getExecutionService();

		/**
		 * The meta object literal for the '<em><b>Result</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION_SERVICE__RESULT = eINSTANCE.getExecutionService_Result();

		/**
		 * The meta object literal for the '{@link no.hal.eclipsky.services.workspace.model.impl.ExecutionResultImpl <em>Execution Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hal.eclipsky.services.workspace.model.impl.ExecutionResultImpl
		 * @see no.hal.eclipsky.services.workspace.model.impl.ModelPackageImpl#getExecutionResult()
		 * @generated
		 */
		EClass EXECUTION_RESULT = eINSTANCE.getExecutionResult();

		/**
		 * The meta object literal for the '<em><b>Sysout</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION_RESULT__SYSOUT = eINSTANCE.getExecutionResult_Sysout();

		/**
		 * The meta object literal for the '<em><b>Syserr</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION_RESULT__SYSERR = eINSTANCE.getExecutionResult_Syserr();

		/**
		 * The meta object literal for the '<em><b>Qualified Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXECUTION_RESULT__QUALIFIED_NAME = eINSTANCE.getExecutionResult_QualifiedName();

		/**
		 * The meta object literal for the '<em><b>Exception Location</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION_RESULT__EXCEPTION_LOCATION = eINSTANCE.getExecutionResult_ExceptionLocation();

		/**
		 * The meta object literal for the '{@link no.hal.eclipsky.services.workspace.model.impl.RunEditorServiceImpl <em>Run Editor Service</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hal.eclipsky.services.workspace.model.impl.RunEditorServiceImpl
		 * @see no.hal.eclipsky.services.workspace.model.impl.ModelPackageImpl#getRunEditorService()
		 * @generated
		 */
		EClass RUN_EDITOR_SERVICE = eINSTANCE.getRunEditorService();

		/**
		 * The meta object literal for the '{@link no.hal.eclipsky.services.workspace.model.impl.TestEditorServiceImpl <em>Test Editor Service</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hal.eclipsky.services.workspace.model.impl.TestEditorServiceImpl
		 * @see no.hal.eclipsky.services.workspace.model.impl.ModelPackageImpl#getTestEditorService()
		 * @generated
		 */
		EClass TEST_EDITOR_SERVICE = eINSTANCE.getTestEditorService();

		/**
		 * The meta object literal for the '{@link no.hal.eclipsky.services.workspace.model.impl.TestResultImpl <em>Test Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hal.eclipsky.services.workspace.model.impl.TestResultImpl
		 * @see no.hal.eclipsky.services.workspace.model.impl.ModelPackageImpl#getTestResult()
		 * @generated
		 */
		EClass TEST_RESULT = eINSTANCE.getTestResult();

		/**
		 * The meta object literal for the '<em><b>Results</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_RESULT__RESULTS = eINSTANCE.getTestResult_Results();

		/**
		 * The meta object literal for the '{@link no.hal.eclipsky.services.workspace.model.impl.TestCaseResultImpl <em>Test Case Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hal.eclipsky.services.workspace.model.impl.TestCaseResultImpl
		 * @see no.hal.eclipsky.services.workspace.model.impl.ModelPackageImpl#getTestCaseResult()
		 * @generated
		 */
		EClass TEST_CASE_RESULT = eINSTANCE.getTestCaseResult();

		/**
		 * The meta object literal for the '<em><b>Test Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_CASE_RESULT__TEST_NAME = eINSTANCE.getTestCaseResult_TestName();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_CASE_RESULT__KIND = eINSTANCE.getTestCaseResult_Kind();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_CASE_RESULT__MESSAGE = eINSTANCE.getTestCaseResult_Message();

		/**
		 * The meta object literal for the '<em><b>Exception</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_CASE_RESULT__EXCEPTION = eINSTANCE.getTestCaseResult_Exception();

		/**
		 * The meta object literal for the '{@link no.hal.eclipsky.services.workspace.model.ResultKind <em>Result Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hal.eclipsky.services.workspace.model.ResultKind
		 * @see no.hal.eclipsky.services.workspace.model.impl.ModelPackageImpl#getResultKind()
		 * @generated
		 */
		EEnum RESULT_KIND = eINSTANCE.getResultKind();

		/**
		 * The meta object literal for the '{@link no.hal.eclipsky.services.workspace.model.SeverityKind <em>Severity Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hal.eclipsky.services.workspace.model.SeverityKind
		 * @see no.hal.eclipsky.services.workspace.model.impl.ModelPackageImpl#getSeverityKind()
		 * @generated
		 */
		EEnum SEVERITY_KIND = eINSTANCE.getSeverityKind();

		/**
		 * The meta object literal for the '<em>ETimestamp</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hal.eclipsky.services.workspace.model.impl.ModelPackageImpl#getETimestamp()
		 * @generated
		 */
		EDataType ETIMESTAMP = eINSTANCE.getETimestamp();

		/**
		 * The meta object literal for the '<em>EProject Ref</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hal.eclipsky.services.common.ProjectRef
		 * @see no.hal.eclipsky.services.workspace.model.impl.ModelPackageImpl#getEProjectRef()
		 * @generated
		 */
		EDataType EPROJECT_REF = eINSTANCE.getEProjectRef();

		/**
		 * The meta object literal for the '<em>EResource Ref</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hal.eclipsky.services.common.ResourceRef
		 * @see no.hal.eclipsky.services.workspace.model.impl.ModelPackageImpl#getEResourceRef()
		 * @generated
		 */
		EDataType ERESOURCE_REF = eINSTANCE.getEResourceRef();

	}

} //ModelPackage
