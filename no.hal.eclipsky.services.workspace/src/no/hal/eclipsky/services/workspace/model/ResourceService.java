/**
 */
package no.hal.eclipsky.services.workspace.model;

import no.hal.eclipsky.services.common.ResourceRef;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource Service</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link no.hal.eclipsky.services.workspace.model.ResourceService#getResourceRef <em>Resource Ref</em>}</li>
 * </ul>
 *
 * @see no.hal.eclipsky.services.workspace.model.ModelPackage#getResourceService()
 * @model
 * @generated
 */
public interface ResourceService extends AbstractService {
	/**
	 * Returns the value of the '<em><b>Resource Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Ref</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Ref</em>' attribute.
	 * @see #setResourceRef(ResourceRef)
	 * @see no.hal.eclipsky.services.workspace.model.ModelPackage#getResourceService_ResourceRef()
	 * @model dataType="no.hal.eclipsky.services.workspace.model.EResourceRef"
	 * @generated
	 */
	ResourceRef getResourceRef();

	/**
	 * Sets the value of the '{@link no.hal.eclipsky.services.workspace.model.ResourceService#getResourceRef <em>Resource Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource Ref</em>' attribute.
	 * @see #getResourceRef()
	 * @generated
	 */
	void setResourceRef(ResourceRef value);

} // ResourceService
