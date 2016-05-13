/**
 */
package no.hal.eclipsky.services.workspace.model;

import no.hal.emfs.EmfsResource;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ensure Project Service</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link no.hal.eclipsky.services.workspace.model.EnsureProjectService#getEmfs <em>Emfs</em>}</li>
 * </ul>
 *
 * @see no.hal.eclipsky.services.workspace.model.ModelPackage#getEnsureProjectService()
 * @model
 * @generated
 */
public interface EnsureProjectService extends ProjectService {
	/**
	 * Returns the value of the '<em><b>Emfs</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Emfs</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Emfs</em>' reference.
	 * @see #setEmfs(EmfsResource)
	 * @see no.hal.eclipsky.services.workspace.model.ModelPackage#getEnsureProjectService_Emfs()
	 * @model
	 * @generated
	 */
	EmfsResource getEmfs();

	/**
	 * Sets the value of the '{@link no.hal.eclipsky.services.workspace.model.EnsureProjectService#getEmfs <em>Emfs</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Emfs</em>' reference.
	 * @see #getEmfs()
	 * @generated
	 */
	void setEmfs(EmfsResource value);

} // EnsureProjectService
