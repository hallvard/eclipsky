/**
 */
package no.hal.eclipsky.services.workspace.model;

import no.hal.emfs.AbstractStringContents;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Execution Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link no.hal.eclipsky.services.workspace.model.ExecutionResult#getSysout <em>Sysout</em>}</li>
 *   <li>{@link no.hal.eclipsky.services.workspace.model.ExecutionResult#getSyserr <em>Syserr</em>}</li>
 *   <li>{@link no.hal.eclipsky.services.workspace.model.ExecutionResult#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link no.hal.eclipsky.services.workspace.model.ExecutionResult#getExceptionLocation <em>Exception Location</em>}</li>
 * </ul>
 *
 * @see no.hal.eclipsky.services.workspace.model.ModelPackage#getExecutionResult()
 * @model
 * @generated
 */
public interface ExecutionResult extends EObject {
	/**
	 * Returns the value of the '<em><b>Sysout</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sysout</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sysout</em>' containment reference.
	 * @see #setSysout(AbstractStringContents)
	 * @see no.hal.eclipsky.services.workspace.model.ModelPackage#getExecutionResult_Sysout()
	 * @model containment="true"
	 * @generated
	 */
	AbstractStringContents getSysout();

	/**
	 * Sets the value of the '{@link no.hal.eclipsky.services.workspace.model.ExecutionResult#getSysout <em>Sysout</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sysout</em>' containment reference.
	 * @see #getSysout()
	 * @generated
	 */
	void setSysout(AbstractStringContents value);

	/**
	 * Returns the value of the '<em><b>Syserr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Syserr</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Syserr</em>' containment reference.
	 * @see #setSyserr(AbstractStringContents)
	 * @see no.hal.eclipsky.services.workspace.model.ModelPackage#getExecutionResult_Syserr()
	 * @model containment="true"
	 * @generated
	 */
	AbstractStringContents getSyserr();

	/**
	 * Sets the value of the '{@link no.hal.eclipsky.services.workspace.model.ExecutionResult#getSyserr <em>Syserr</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Syserr</em>' containment reference.
	 * @see #getSyserr()
	 * @generated
	 */
	void setSyserr(AbstractStringContents value);

	/**
	 * Returns the value of the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Qualified Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Qualified Name</em>' attribute.
	 * @see #setQualifiedName(String)
	 * @see no.hal.eclipsky.services.workspace.model.ModelPackage#getExecutionResult_QualifiedName()
	 * @model
	 * @generated
	 */
	String getQualifiedName();

	/**
	 * Sets the value of the '{@link no.hal.eclipsky.services.workspace.model.ExecutionResult#getQualifiedName <em>Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Qualified Name</em>' attribute.
	 * @see #getQualifiedName()
	 * @generated
	 */
	void setQualifiedName(String value);

	/**
	 * Returns the value of the '<em><b>Exception Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exception Location</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exception Location</em>' containment reference.
	 * @see #setExceptionLocation(SourceFileMarker)
	 * @see no.hal.eclipsky.services.workspace.model.ModelPackage#getExecutionResult_ExceptionLocation()
	 * @model containment="true"
	 * @generated
	 */
	SourceFileMarker getExceptionLocation();

	/**
	 * Sets the value of the '{@link no.hal.eclipsky.services.workspace.model.ExecutionResult#getExceptionLocation <em>Exception Location</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exception Location</em>' containment reference.
	 * @see #getExceptionLocation()
	 * @generated
	 */
	void setExceptionLocation(SourceFileMarker value);

} // ExecutionResult
