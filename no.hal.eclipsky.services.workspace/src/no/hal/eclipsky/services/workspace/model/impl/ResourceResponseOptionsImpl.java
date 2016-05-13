/**
 */
package no.hal.eclipsky.services.workspace.model.impl;

import no.hal.eclipsky.services.workspace.model.ModelPackage;
import no.hal.eclipsky.services.workspace.model.ResourceResponseOptions;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Response Options</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link no.hal.eclipsky.services.workspace.model.impl.ResourceResponseOptionsImpl#isIncludeContents <em>Include Contents</em>}</li>
 *   <li>{@link no.hal.eclipsky.services.workspace.model.impl.ResourceResponseOptionsImpl#isIncludeMarkers <em>Include Markers</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ResourceResponseOptionsImpl extends MinimalEObjectImpl.Container implements ResourceResponseOptions {
	/**
	 * The default value of the '{@link #isIncludeContents() <em>Include Contents</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIncludeContents()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INCLUDE_CONTENTS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIncludeContents() <em>Include Contents</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIncludeContents()
	 * @generated
	 * @ordered
	 */
	protected boolean includeContents = INCLUDE_CONTENTS_EDEFAULT;

	/**
	 * The default value of the '{@link #isIncludeMarkers() <em>Include Markers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIncludeMarkers()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INCLUDE_MARKERS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIncludeMarkers() <em>Include Markers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIncludeMarkers()
	 * @generated
	 * @ordered
	 */
	protected boolean includeMarkers = INCLUDE_MARKERS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceResponseOptionsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.RESOURCE_RESPONSE_OPTIONS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIncludeContents() {
		return includeContents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIncludeContents(boolean newIncludeContents) {
		boolean oldIncludeContents = includeContents;
		includeContents = newIncludeContents;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.RESOURCE_RESPONSE_OPTIONS__INCLUDE_CONTENTS, oldIncludeContents, includeContents));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIncludeMarkers() {
		return includeMarkers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIncludeMarkers(boolean newIncludeMarkers) {
		boolean oldIncludeMarkers = includeMarkers;
		includeMarkers = newIncludeMarkers;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.RESOURCE_RESPONSE_OPTIONS__INCLUDE_MARKERS, oldIncludeMarkers, includeMarkers));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.RESOURCE_RESPONSE_OPTIONS__INCLUDE_CONTENTS:
				return isIncludeContents();
			case ModelPackage.RESOURCE_RESPONSE_OPTIONS__INCLUDE_MARKERS:
				return isIncludeMarkers();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ModelPackage.RESOURCE_RESPONSE_OPTIONS__INCLUDE_CONTENTS:
				setIncludeContents((Boolean)newValue);
				return;
			case ModelPackage.RESOURCE_RESPONSE_OPTIONS__INCLUDE_MARKERS:
				setIncludeMarkers((Boolean)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ModelPackage.RESOURCE_RESPONSE_OPTIONS__INCLUDE_CONTENTS:
				setIncludeContents(INCLUDE_CONTENTS_EDEFAULT);
				return;
			case ModelPackage.RESOURCE_RESPONSE_OPTIONS__INCLUDE_MARKERS:
				setIncludeMarkers(INCLUDE_MARKERS_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ModelPackage.RESOURCE_RESPONSE_OPTIONS__INCLUDE_CONTENTS:
				return includeContents != INCLUDE_CONTENTS_EDEFAULT;
			case ModelPackage.RESOURCE_RESPONSE_OPTIONS__INCLUDE_MARKERS:
				return includeMarkers != INCLUDE_MARKERS_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (includeContents: ");
		result.append(includeContents);
		result.append(", includeMarkers: ");
		result.append(includeMarkers);
		result.append(')');
		return result.toString();
	}

} //ResourceResponseOptionsImpl
