/**
 */
package no.hal.eclipsky.services.workspace.model;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see no.hal.eclipsky.services.workspace.model.ModelPackage
 * @generated
 */
public interface ModelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelFactory eINSTANCE = no.hal.eclipsky.services.workspace.model.impl.ModelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Project Service</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Project Service</em>'.
	 * @generated
	 */
	ProjectService createProjectService();

	/**
	 * Returns a new object of class '<em>Resource Service</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resource Service</em>'.
	 * @generated
	 */
	ResourceService createResourceService();

	/**
	 * Returns a new object of class '<em>Ensure Project Service</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ensure Project Service</em>'.
	 * @generated
	 */
	EnsureProjectService createEnsureProjectService();

	/**
	 * Returns a new object of class '<em>Project List Service</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Project List Service</em>'.
	 * @generated
	 */
	ProjectListService createProjectListService();

	/**
	 * Returns a new object of class '<em>Project Response Options</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Project Response Options</em>'.
	 * @generated
	 */
	ProjectResponseOptions createProjectResponseOptions();

	/**
	 * Returns a new object of class '<em>Resource Response Options</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resource Response Options</em>'.
	 * @generated
	 */
	ResourceResponseOptions createResourceResponseOptions();

	/**
	 * Returns a new object of class '<em>Project Info</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Project Info</em>'.
	 * @generated
	 */
	ProjectInfo createProjectInfo();

	/**
	 * Returns a new object of class '<em>Resource Info</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resource Info</em>'.
	 * @generated
	 */
	ResourceInfo createResourceInfo();

	/**
	 * Returns a new object of class '<em>Source Editor Service</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Source Editor Service</em>'.
	 * @generated
	 */
	SourceEditorService createSourceEditorService();

	/**
	 * Returns a new object of class '<em>Resource Info Service</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resource Info Service</em>'.
	 * @generated
	 */
	ResourceInfoService createResourceInfoService();

	/**
	 * Returns a new object of class '<em>Refresh Editor Service</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Refresh Editor Service</em>'.
	 * @generated
	 */
	RefreshEditorService createRefreshEditorService();

	/**
	 * Returns a new object of class '<em>Markers Editor Service</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Markers Editor Service</em>'.
	 * @generated
	 */
	MarkersEditorService createMarkersEditorService();

	/**
	 * Returns a new object of class '<em>Update Editor Service</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Update Editor Service</em>'.
	 * @generated
	 */
	UpdateEditorService createUpdateEditorService();

	/**
	 * Returns a new object of class '<em>Source File Marker</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Source File Marker</em>'.
	 * @generated
	 */
	SourceFileMarker createSourceFileMarker();

	/**
	 * Returns a new object of class '<em>Completion Editor Service</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Completion Editor Service</em>'.
	 * @generated
	 */
	CompletionEditorService createCompletionEditorService();

	/**
	 * Returns a new object of class '<em>Completion Proposal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Completion Proposal</em>'.
	 * @generated
	 */
	CompletionProposal createCompletionProposal();

	/**
	 * Returns a new object of class '<em>Close Editor Service</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Close Editor Service</em>'.
	 * @generated
	 */
	CloseEditorService createCloseEditorService();

	/**
	 * Returns a new object of class '<em>Execution Service</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Execution Service</em>'.
	 * @generated
	 */
	ExecutionService createExecutionService();

	/**
	 * Returns a new object of class '<em>Execution Result</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Execution Result</em>'.
	 * @generated
	 */
	ExecutionResult createExecutionResult();

	/**
	 * Returns a new object of class '<em>Run Editor Service</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Run Editor Service</em>'.
	 * @generated
	 */
	RunEditorService createRunEditorService();

	/**
	 * Returns a new object of class '<em>Test Editor Service</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Test Editor Service</em>'.
	 * @generated
	 */
	TestEditorService createTestEditorService();

	/**
	 * Returns a new object of class '<em>Test Result</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Test Result</em>'.
	 * @generated
	 */
	TestResult createTestResult();

	/**
	 * Returns a new object of class '<em>Test Case Result</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Test Case Result</em>'.
	 * @generated
	 */
	TestCaseResult createTestCaseResult();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ModelPackage getModelPackage();

} //ModelFactory
