/**
 */
package no.hal.eclipsky.services.workspace.model;

import no.hal.eclipsky.services.common.ProjectRef;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Project Info</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link no.hal.eclipsky.services.workspace.model.ProjectInfo#getProjectRef <em>Project Ref</em>}</li>
 *   <li>{@link no.hal.eclipsky.services.workspace.model.ProjectInfo#getResources <em>Resources</em>}</li>
 * </ul>
 *
 * @see no.hal.eclipsky.services.workspace.model.ModelPackage#getProjectInfo()
 * @model
 * @generated
 */
public interface ProjectInfo extends EObject {
	/**
	 * Returns the value of the '<em><b>Project Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project Ref</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project Ref</em>' attribute.
	 * @see #setProjectRef(ProjectRef)
	 * @see no.hal.eclipsky.services.workspace.model.ModelPackage#getProjectInfo_ProjectRef()
	 * @model dataType="no.hal.eclipsky.services.workspace.model.EProjectRef"
	 * @generated
	 */
	ProjectRef getProjectRef();

	/**
	 * Sets the value of the '{@link no.hal.eclipsky.services.workspace.model.ProjectInfo#getProjectRef <em>Project Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project Ref</em>' attribute.
	 * @see #getProjectRef()
	 * @generated
	 */
	void setProjectRef(ProjectRef value);

	/**
	 * Returns the value of the '<em><b>Resources</b></em>' containment reference list.
	 * The list contents are of type {@link no.hal.eclipsky.services.workspace.model.ResourceInfo}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resources</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resources</em>' containment reference list.
	 * @see no.hal.eclipsky.services.workspace.model.ModelPackage#getProjectInfo_Resources()
	 * @model containment="true"
	 * @generated
	 */
	EList<ResourceInfo> getResources();

} // ProjectInfo
