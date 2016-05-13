/**
 */
package no.hal.eclipsky.services.workspace.model.impl;

import no.hal.eclipsky.services.workspace.model.MarkersEditorService;
import no.hal.eclipsky.services.workspace.model.ModelPackage;
import no.hal.eclipsky.services.workspace.model.ResourceInfo;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Markers Editor Service</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link no.hal.eclipsky.services.workspace.model.impl.MarkersEditorServiceImpl#getMarkers <em>Markers</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MarkersEditorServiceImpl extends SourceEditorServiceImpl implements MarkersEditorService {
	/**
	 * The cached value of the '{@link #getMarkers() <em>Markers</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMarkers()
	 * @generated
	 * @ordered
	 */
	protected ResourceInfo markers;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MarkersEditorServiceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.MARKERS_EDITOR_SERVICE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceInfo getMarkers() {
		return markers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMarkers(ResourceInfo newMarkers, NotificationChain msgs) {
		ResourceInfo oldMarkers = markers;
		markers = newMarkers;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.MARKERS_EDITOR_SERVICE__MARKERS, oldMarkers, newMarkers);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMarkers(ResourceInfo newMarkers) {
		if (newMarkers != markers) {
			NotificationChain msgs = null;
			if (markers != null)
				msgs = ((InternalEObject)markers).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.MARKERS_EDITOR_SERVICE__MARKERS, null, msgs);
			if (newMarkers != null)
				msgs = ((InternalEObject)newMarkers).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.MARKERS_EDITOR_SERVICE__MARKERS, null, msgs);
			msgs = basicSetMarkers(newMarkers, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.MARKERS_EDITOR_SERVICE__MARKERS, newMarkers, newMarkers));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.MARKERS_EDITOR_SERVICE__MARKERS:
				return basicSetMarkers(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.MARKERS_EDITOR_SERVICE__MARKERS:
				return getMarkers();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ModelPackage.MARKERS_EDITOR_SERVICE__MARKERS:
				setMarkers((ResourceInfo)newValue);
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
			case ModelPackage.MARKERS_EDITOR_SERVICE__MARKERS:
				setMarkers((ResourceInfo)null);
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
			case ModelPackage.MARKERS_EDITOR_SERVICE__MARKERS:
				return markers != null;
		}
		return super.eIsSet(featureID);
	}

} //MarkersEditorServiceImpl
