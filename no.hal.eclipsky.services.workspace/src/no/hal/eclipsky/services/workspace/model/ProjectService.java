/**
 */
package no.hal.eclipsky.services.workspace.model;

import no.hal.eclipsky.services.common.ProjectRef;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Project Service</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link no.hal.eclipsky.services.workspace.model.ProjectService#getProjectRef <em>Project Ref</em>}</li>
 * </ul>
 *
 * @see no.hal.eclipsky.services.workspace.model.ModelPackage#getProjectService()
 * @model
 * @generated
 */
public interface ProjectService extends AbstractService {
	/**
	 * Returns the value of the '<em><b>Project Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project Ref</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project Ref</em>' attribute.
	 * @see #setProjectRef(ProjectRef)
	 * @see no.hal.eclipsky.services.workspace.model.ModelPackage#getProjectService_ProjectRef()
	 * @model dataType="no.hal.eclipsky.services.workspace.model.EProjectRef"
	 * @generated
	 */
	ProjectRef getProjectRef();

	/**
	 * Sets the value of the '{@link no.hal.eclipsky.services.workspace.model.ProjectService#getProjectRef <em>Project Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project Ref</em>' attribute.
	 * @see #getProjectRef()
	 * @generated
	 */
	void setProjectRef(ProjectRef value);

} // ProjectService
