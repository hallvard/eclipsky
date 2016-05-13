/**
 */
package no.hal.eclipsky.services.workspace.model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource Response Options</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link no.hal.eclipsky.services.workspace.model.ResourceResponseOptions#isIncludeContents <em>Include Contents</em>}</li>
 *   <li>{@link no.hal.eclipsky.services.workspace.model.ResourceResponseOptions#isIncludeMarkers <em>Include Markers</em>}</li>
 * </ul>
 *
 * @see no.hal.eclipsky.services.workspace.model.ModelPackage#getResourceResponseOptions()
 * @model
 * @generated
 */
public interface ResourceResponseOptions extends EObject {
	/**
	 * Returns the value of the '<em><b>Include Contents</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Include Contents</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Include Contents</em>' attribute.
	 * @see #setIncludeContents(boolean)
	 * @see no.hal.eclipsky.services.workspace.model.ModelPackage#getResourceResponseOptions_IncludeContents()
	 * @model
	 * @generated
	 */
	boolean isIncludeContents();

	/**
	 * Sets the value of the '{@link no.hal.eclipsky.services.workspace.model.ResourceResponseOptions#isIncludeContents <em>Include Contents</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Include Contents</em>' attribute.
	 * @see #isIncludeContents()
	 * @generated
	 */
	void setIncludeContents(boolean value);

	/**
	 * Returns the value of the '<em><b>Include Markers</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Include Markers</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Include Markers</em>' attribute.
	 * @see #setIncludeMarkers(boolean)
	 * @see no.hal.eclipsky.services.workspace.model.ModelPackage#getResourceResponseOptions_IncludeMarkers()
	 * @model
	 * @generated
	 */
	boolean isIncludeMarkers();

	/**
	 * Sets the value of the '{@link no.hal.eclipsky.services.workspace.model.ResourceResponseOptions#isIncludeMarkers <em>Include Markers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Include Markers</em>' attribute.
	 * @see #isIncludeMarkers()
	 * @generated
	 */
	void setIncludeMarkers(boolean value);

} // ResourceResponseOptions
