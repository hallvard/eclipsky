/**
 */
package no.hal.eclipsky.services.workspace.model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>File Marker</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link no.hal.eclipsky.services.workspace.model.FileMarker#getSeverity <em>Severity</em>}</li>
 *   <li>{@link no.hal.eclipsky.services.workspace.model.FileMarker#getMessage <em>Message</em>}</li>
 * </ul>
 *
 * @see no.hal.eclipsky.services.workspace.model.ModelPackage#getFileMarker()
 * @model abstract="true"
 * @generated
 */
public interface FileMarker extends EObject {
	/**
	 * Returns the value of the '<em><b>Severity</b></em>' attribute.
	 * The literals are from the enumeration {@link no.hal.eclipsky.services.workspace.model.SeverityKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Severity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Severity</em>' attribute.
	 * @see no.hal.eclipsky.services.workspace.model.SeverityKind
	 * @see #setSeverity(SeverityKind)
	 * @see no.hal.eclipsky.services.workspace.model.ModelPackage#getFileMarker_Severity()
	 * @model
	 * @generated
	 */
	SeverityKind getSeverity();

	/**
	 * Sets the value of the '{@link no.hal.eclipsky.services.workspace.model.FileMarker#getSeverity <em>Severity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Severity</em>' attribute.
	 * @see no.hal.eclipsky.services.workspace.model.SeverityKind
	 * @see #getSeverity()
	 * @generated
	 */
	void setSeverity(SeverityKind value);

	/**
	 * Returns the value of the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Message</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Message</em>' attribute.
	 * @see #setMessage(String)
	 * @see no.hal.eclipsky.services.workspace.model.ModelPackage#getFileMarker_Message()
	 * @model
	 * @generated
	 */
	String getMessage();

	/**
	 * Sets the value of the '{@link no.hal.eclipsky.services.workspace.model.FileMarker#getMessage <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message</em>' attribute.
	 * @see #getMessage()
	 * @generated
	 */
	void setMessage(String value);

} // FileMarker
