/**
 */
package no.hal.eclipsky.services.workspace.model;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Refresh Editor Service</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link no.hal.eclipsky.services.workspace.model.RefreshEditorService#getResource <em>Resource</em>}</li>
 * </ul>
 *
 * @see no.hal.eclipsky.services.workspace.model.ModelPackage#getRefreshEditorService()
 * @model
 * @generated
 */
public interface RefreshEditorService extends SourceEditorService {
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
	 * @see no.hal.eclipsky.services.workspace.model.ModelPackage#getRefreshEditorService_Resource()
	 * @model containment="true"
	 * @generated
	 */
	ResourceInfo getResource();

	/**
	 * Sets the value of the '{@link no.hal.eclipsky.services.workspace.model.RefreshEditorService#getResource <em>Resource</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource</em>' containment reference.
	 * @see #getResource()
	 * @generated
	 */
	void setResource(ResourceInfo value);

} // RefreshEditorService
