/**
 */
package no.hal.eclipsky.services.workspace.model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Test Case Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link no.hal.eclipsky.services.workspace.model.TestCaseResult#getTestName <em>Test Name</em>}</li>
 *   <li>{@link no.hal.eclipsky.services.workspace.model.TestCaseResult#getKind <em>Kind</em>}</li>
 *   <li>{@link no.hal.eclipsky.services.workspace.model.TestCaseResult#getMessage <em>Message</em>}</li>
 *   <li>{@link no.hal.eclipsky.services.workspace.model.TestCaseResult#getException <em>Exception</em>}</li>
 * </ul>
 *
 * @see no.hal.eclipsky.services.workspace.model.ModelPackage#getTestCaseResult()
 * @model
 * @generated
 */
public interface TestCaseResult extends EObject {
	/**
	 * Returns the value of the '<em><b>Test Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Test Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Test Name</em>' attribute.
	 * @see #setTestName(String)
	 * @see no.hal.eclipsky.services.workspace.model.ModelPackage#getTestCaseResult_TestName()
	 * @model
	 * @generated
	 */
	String getTestName();

	/**
	 * Sets the value of the '{@link no.hal.eclipsky.services.workspace.model.TestCaseResult#getTestName <em>Test Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Test Name</em>' attribute.
	 * @see #getTestName()
	 * @generated
	 */
	void setTestName(String value);

	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link no.hal.eclipsky.services.workspace.model.ResultKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see no.hal.eclipsky.services.workspace.model.ResultKind
	 * @see #setKind(ResultKind)
	 * @see no.hal.eclipsky.services.workspace.model.ModelPackage#getTestCaseResult_Kind()
	 * @model
	 * @generated
	 */
	ResultKind getKind();

	/**
	 * Sets the value of the '{@link no.hal.eclipsky.services.workspace.model.TestCaseResult#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see no.hal.eclipsky.services.workspace.model.ResultKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(ResultKind value);

	/**
	 * Returns the value of the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Message</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Message</em>' attribute.
	 * @see #setMessage(String)
	 * @see no.hal.eclipsky.services.workspace.model.ModelPackage#getTestCaseResult_Message()
	 * @model
	 * @generated
	 */
	String getMessage();

	/**
	 * Sets the value of the '{@link no.hal.eclipsky.services.workspace.model.TestCaseResult#getMessage <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message</em>' attribute.
	 * @see #getMessage()
	 * @generated
	 */
	void setMessage(String value);

	/**
	 * Returns the value of the '<em><b>Exception</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exception</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exception</em>' attribute.
	 * @see #setException(String)
	 * @see no.hal.eclipsky.services.workspace.model.ModelPackage#getTestCaseResult_Exception()
	 * @model
	 * @generated
	 */
	String getException();

	/**
	 * Sets the value of the '{@link no.hal.eclipsky.services.workspace.model.TestCaseResult#getException <em>Exception</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exception</em>' attribute.
	 * @see #getException()
	 * @generated
	 */
	void setException(String value);

} // TestCaseResult
