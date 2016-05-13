/**
 */
package no.hal.eclipsky.services.workspace.model;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Execution Service</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link no.hal.eclipsky.services.workspace.model.ExecutionService#getResult <em>Result</em>}</li>
 * </ul>
 *
 * @see no.hal.eclipsky.services.workspace.model.ModelPackage#getExecutionService()
 * @model
 * @generated
 */
public interface ExecutionService extends ResourceService {
	/**
	 * Returns the value of the '<em><b>Result</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result</em>' containment reference.
	 * @see #setResult(ExecutionResult)
	 * @see no.hal.eclipsky.services.workspace.model.ModelPackage#getExecutionService_Result()
	 * @model containment="true"
	 * @generated
	 */
	ExecutionResult getResult();

	/**
	 * Sets the value of the '{@link no.hal.eclipsky.services.workspace.model.ExecutionService#getResult <em>Result</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result</em>' containment reference.
	 * @see #getResult()
	 * @generated
	 */
	void setResult(ExecutionResult value);

} // ExecutionService
