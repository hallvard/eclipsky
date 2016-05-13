/**
 */
package no.hal.eclipsky.services.workspace.model;

import no.hal.emfs.AbstractStringContentProvider;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Update Editor Service</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link no.hal.eclipsky.services.workspace.model.UpdateEditorService#getContents <em>Contents</em>}</li>
 * </ul>
 *
 * @see no.hal.eclipsky.services.workspace.model.ModelPackage#getUpdateEditorService()
 * @model
 * @generated
 */
public interface UpdateEditorService extends MarkersEditorService {
	/**
	 * Returns the value of the '<em><b>Contents</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contents</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contents</em>' containment reference.
	 * @see #setContents(AbstractStringContentProvider)
	 * @see no.hal.eclipsky.services.workspace.model.ModelPackage#getUpdateEditorService_Contents()
	 * @model containment="true"
	 * @generated
	 */
	AbstractStringContentProvider getContents();

	/**
	 * Sets the value of the '{@link no.hal.eclipsky.services.workspace.model.UpdateEditorService#getContents <em>Contents</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Contents</em>' containment reference.
	 * @see #getContents()
	 * @generated
	 */
	void setContents(AbstractStringContentProvider value);

} // UpdateEditorService
