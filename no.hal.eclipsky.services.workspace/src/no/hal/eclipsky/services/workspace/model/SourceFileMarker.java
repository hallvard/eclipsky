/**
 */
package no.hal.eclipsky.services.workspace.model;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Source File Marker</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link no.hal.eclipsky.services.workspace.model.SourceFileMarker#getLineNumber <em>Line Number</em>}</li>
 *   <li>{@link no.hal.eclipsky.services.workspace.model.SourceFileMarker#getStart <em>Start</em>}</li>
 *   <li>{@link no.hal.eclipsky.services.workspace.model.SourceFileMarker#getEnd <em>End</em>}</li>
 * </ul>
 *
 * @see no.hal.eclipsky.services.workspace.model.ModelPackage#getSourceFileMarker()
 * @model
 * @generated
 */
public interface SourceFileMarker extends FileMarker {
	/**
	 * Returns the value of the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Line Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Line Number</em>' attribute.
	 * @see #setLineNumber(int)
	 * @see no.hal.eclipsky.services.workspace.model.ModelPackage#getSourceFileMarker_LineNumber()
	 * @model
	 * @generated
	 */
	int getLineNumber();

	/**
	 * Sets the value of the '{@link no.hal.eclipsky.services.workspace.model.SourceFileMarker#getLineNumber <em>Line Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Line Number</em>' attribute.
	 * @see #getLineNumber()
	 * @generated
	 */
	void setLineNumber(int value);

	/**
	 * Returns the value of the '<em><b>Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start</em>' attribute.
	 * @see #setStart(int)
	 * @see no.hal.eclipsky.services.workspace.model.ModelPackage#getSourceFileMarker_Start()
	 * @model
	 * @generated
	 */
	int getStart();

	/**
	 * Sets the value of the '{@link no.hal.eclipsky.services.workspace.model.SourceFileMarker#getStart <em>Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start</em>' attribute.
	 * @see #getStart()
	 * @generated
	 */
	void setStart(int value);

	/**
	 * Returns the value of the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End</em>' attribute.
	 * @see #setEnd(int)
	 * @see no.hal.eclipsky.services.workspace.model.ModelPackage#getSourceFileMarker_End()
	 * @model
	 * @generated
	 */
	int getEnd();

	/**
	 * Sets the value of the '{@link no.hal.eclipsky.services.workspace.model.SourceFileMarker#getEnd <em>End</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End</em>' attribute.
	 * @see #getEnd()
	 * @generated
	 */
	void setEnd(int value);

} // SourceFileMarker
