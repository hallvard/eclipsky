/**
 */
package no.hal.eclipsky.services.workspace.model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Service</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link no.hal.eclipsky.services.workspace.model.AbstractService#getRequestTime <em>Request Time</em>}</li>
 *   <li>{@link no.hal.eclipsky.services.workspace.model.AbstractService#getResponseTime <em>Response Time</em>}</li>
 * </ul>
 *
 * @see no.hal.eclipsky.services.workspace.model.ModelPackage#getAbstractService()
 * @model abstract="true"
 * @generated
 */
public interface AbstractService extends EObject {
	/**
	 * Returns the value of the '<em><b>Request Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Request Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Request Time</em>' attribute.
	 * @see #setRequestTime(long)
	 * @see no.hal.eclipsky.services.workspace.model.ModelPackage#getAbstractService_RequestTime()
	 * @model dataType="no.hal.eclipsky.services.workspace.model.ETimestamp"
	 * @generated
	 */
	long getRequestTime();

	/**
	 * Sets the value of the '{@link no.hal.eclipsky.services.workspace.model.AbstractService#getRequestTime <em>Request Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Request Time</em>' attribute.
	 * @see #getRequestTime()
	 * @generated
	 */
	void setRequestTime(long value);

	/**
	 * Returns the value of the '<em><b>Response Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Response Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Response Time</em>' attribute.
	 * @see #setResponseTime(long)
	 * @see no.hal.eclipsky.services.workspace.model.ModelPackage#getAbstractService_ResponseTime()
	 * @model dataType="no.hal.eclipsky.services.workspace.model.ETimestamp"
	 * @generated
	 */
	long getResponseTime();

	/**
	 * Sets the value of the '{@link no.hal.eclipsky.services.workspace.model.AbstractService#getResponseTime <em>Response Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Response Time</em>' attribute.
	 * @see #getResponseTime()
	 * @generated
	 */
	void setResponseTime(long value);

} // AbstractService
