/**
 */
package no.hal.eclipsky.services.workspace.model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Test Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link no.hal.eclipsky.services.workspace.model.TestResult#getResults <em>Results</em>}</li>
 * </ul>
 *
 * @see no.hal.eclipsky.services.workspace.model.ModelPackage#getTestResult()
 * @model
 * @generated
 */
public interface TestResult extends ExecutionResult {
	/**
	 * Returns the value of the '<em><b>Results</b></em>' containment reference list.
	 * The list contents are of type {@link no.hal.eclipsky.services.workspace.model.TestCaseResult}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Results</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Results</em>' containment reference list.
	 * @see no.hal.eclipsky.services.workspace.model.ModelPackage#getTestResult_Results()
	 * @model containment="true"
	 * @generated
	 */
	EList<TestCaseResult> getResults();

} // TestResult
