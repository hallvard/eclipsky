/**
 */
package no.hal.eclipsky.services.workspace.model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Project Response Options</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link no.hal.eclipsky.services.workspace.model.ProjectResponseOptions#isIncludeResources <em>Include Resources</em>}</li>
 *   <li>{@link no.hal.eclipsky.services.workspace.model.ProjectResponseOptions#getResourceResponseOptions <em>Resource Response Options</em>}</li>
 * </ul>
 *
 * @see no.hal.eclipsky.services.workspace.model.ModelPackage#getProjectResponseOptions()
 * @model
 * @generated
 */
public interface ProjectResponseOptions extends EObject {
	/**
	 * Returns the value of the '<em><b>Include Resources</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Include Resources</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Include Resources</em>' attribute.
	 * @see #setIncludeResources(boolean)
	 * @see no.hal.eclipsky.services.workspace.model.ModelPackage#getProjectResponseOptions_IncludeResources()
	 * @model
	 * @generated
	 */
	boolean isIncludeResources();

	/**
	 * Sets the value of the '{@link no.hal.eclipsky.services.workspace.model.ProjectResponseOptions#isIncludeResources <em>Include Resources</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Include Resources</em>' attribute.
	 * @see #isIncludeResources()
	 * @generated
	 */
	void setIncludeResources(boolean value);

	/**
	 * Returns the value of the '<em><b>Resource Response Options</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Response Options</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Response Options</em>' containment reference.
	 * @see #setResourceResponseOptions(ResourceResponseOptions)
	 * @see no.hal.eclipsky.services.workspace.model.ModelPackage#getProjectResponseOptions_ResourceResponseOptions()
	 * @model containment="true"
	 * @generated
	 */
	ResourceResponseOptions getResourceResponseOptions();

	/**
	 * Sets the value of the '{@link no.hal.eclipsky.services.workspace.model.ProjectResponseOptions#getResourceResponseOptions <em>Resource Response Options</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource Response Options</em>' containment reference.
	 * @see #getResourceResponseOptions()
	 * @generated
	 */
	void setResourceResponseOptions(ResourceResponseOptions value);

} // ProjectResponseOptions
