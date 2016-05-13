/**
 */
package no.hal.eclipsky.services.workspace.model;

import no.hal.eclipsky.services.common.ResourceRef;

import no.hal.emfs.AbstractStringContentProvider;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource Info</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link no.hal.eclipsky.services.workspace.model.ResourceInfo#getResourceRef <em>Resource Ref</em>}</li>
 *   <li>{@link no.hal.eclipsky.services.workspace.model.ResourceInfo#getContents <em>Contents</em>}</li>
 *   <li>{@link no.hal.eclipsky.services.workspace.model.ResourceInfo#getMarkers <em>Markers</em>}</li>
 * </ul>
 *
 * @see no.hal.eclipsky.services.workspace.model.ModelPackage#getResourceInfo()
 * @model
 * @generated
 */
public interface ResourceInfo extends EObject {
	/**
	 * Returns the value of the '<em><b>Resource Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Ref</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Ref</em>' attribute.
	 * @see #setResourceRef(ResourceRef)
	 * @see no.hal.eclipsky.services.workspace.model.ModelPackage#getResourceInfo_ResourceRef()
	 * @model dataType="no.hal.eclipsky.services.workspace.model.EResourceRef"
	 * @generated
	 */
	ResourceRef getResourceRef();

	/**
	 * Sets the value of the '{@link no.hal.eclipsky.services.workspace.model.ResourceInfo#getResourceRef <em>Resource Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource Ref</em>' attribute.
	 * @see #getResourceRef()
	 * @generated
	 */
	void setResourceRef(ResourceRef value);

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
	 * @see no.hal.eclipsky.services.workspace.model.ModelPackage#getResourceInfo_Contents()
	 * @model containment="true"
	 * @generated
	 */
	AbstractStringContentProvider getContents();

	/**
	 * Sets the value of the '{@link no.hal.eclipsky.services.workspace.model.ResourceInfo#getContents <em>Contents</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Contents</em>' containment reference.
	 * @see #getContents()
	 * @generated
	 */
	void setContents(AbstractStringContentProvider value);

	/**
	 * Returns the value of the '<em><b>Markers</b></em>' containment reference list.
	 * The list contents are of type {@link no.hal.eclipsky.services.workspace.model.SourceFileMarker}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Markers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Markers</em>' containment reference list.
	 * @see no.hal.eclipsky.services.workspace.model.ModelPackage#getResourceInfo_Markers()
	 * @model containment="true"
	 * @generated
	 */
	EList<SourceFileMarker> getMarkers();

} // ResourceInfo
