/**
 */
package no.hal.eclipsky.services.workspace.model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource Info Service</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link no.hal.eclipsky.services.workspace.model.ResourceInfoService#getResponseOptions <em>Response Options</em>}</li>
 *   <li>{@link no.hal.eclipsky.services.workspace.model.ResourceInfoService#getResource <em>Resource</em>}</li>
 * </ul>
 *
 * @see no.hal.eclipsky.services.workspace.model.ModelPackage#getResourceInfoService()
 * @model
 * @generated
 */
public interface ResourceInfoService extends EObject {
	/**
	 * Returns the value of the '<em><b>Response Options</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Response Options</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Response Options</em>' containment reference.
	 * @see #setResponseOptions(ResourceResponseOptions)
	 * @see no.hal.eclipsky.services.workspace.model.ModelPackage#getResourceInfoService_ResponseOptions()
	 * @model containment="true"
	 * @generated
	 */
	ResourceResponseOptions getResponseOptions();

	/**
	 * Sets the value of the '{@link no.hal.eclipsky.services.workspace.model.ResourceInfoService#getResponseOptions <em>Response Options</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Response Options</em>' containment reference.
	 * @see #getResponseOptions()
	 * @generated
	 */
	void setResponseOptions(ResourceResponseOptions value);

	/**
	 * Returns the value of the '<em><b>Resource</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource</em>' containment reference.
	 * @see #setResource(ResourceInfo)
	 * @see no.hal.eclipsky.services.workspace.model.ModelPackage#getResourceInfoService_Resource()
	 * @model containment="true"
	 * @generated
	 */
	ResourceInfo getResource();

	/**
	 * Sets the value of the '{@link no.hal.eclipsky.services.workspace.model.ResourceInfoService#getResource <em>Resource</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource</em>' containment reference.
	 * @see #getResource()
	 * @generated
	 */
	void setResource(ResourceInfo value);

} // ResourceInfoService
