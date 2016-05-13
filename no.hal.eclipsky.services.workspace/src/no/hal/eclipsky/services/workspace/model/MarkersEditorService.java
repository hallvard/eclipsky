/**
 */
package no.hal.eclipsky.services.workspace.model;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Markers Editor Service</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link no.hal.eclipsky.services.workspace.model.MarkersEditorService#getMarkers <em>Markers</em>}</li>
 * </ul>
 *
 * @see no.hal.eclipsky.services.workspace.model.ModelPackage#getMarkersEditorService()
 * @model
 * @generated
 */
public interface MarkersEditorService extends SourceEditorService {
	/**
	 * Returns the value of the '<em><b>Markers</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Markers</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Markers</em>' containment reference.
	 * @see #setMarkers(ResourceInfo)
	 * @see no.hal.eclipsky.services.workspace.model.ModelPackage#getMarkersEditorService_Markers()
	 * @model containment="true"
	 * @generated
	 */
	ResourceInfo getMarkers();

	/**
	 * Sets the value of the '{@link no.hal.eclipsky.services.workspace.model.MarkersEditorService#getMarkers <em>Markers</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Markers</em>' containment reference.
	 * @see #getMarkers()
	 * @generated
	 */
	void setMarkers(ResourceInfo value);

} // MarkersEditorService
