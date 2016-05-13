/**
 */
package no.hal.eclipsky.services.workspace.model.impl;

import java.util.Collection;

import no.hal.eclipsky.services.common.ResourceRef;

import no.hal.eclipsky.services.workspace.model.ModelPackage;
import no.hal.eclipsky.services.workspace.model.ResourceInfo;
import no.hal.eclipsky.services.workspace.model.SourceFileMarker;

import no.hal.emfs.AbstractStringContentProvider;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Info</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link no.hal.eclipsky.services.workspace.model.impl.ResourceInfoImpl#getResourceRef <em>Resource Ref</em>}</li>
 *   <li>{@link no.hal.eclipsky.services.workspace.model.impl.ResourceInfoImpl#getContents <em>Contents</em>}</li>
 *   <li>{@link no.hal.eclipsky.services.workspace.model.impl.ResourceInfoImpl#getMarkers <em>Markers</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ResourceInfoImpl extends MinimalEObjectImpl.Container implements ResourceInfo {
	/**
	 * The default value of the '{@link #getResourceRef() <em>Resource Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceRef()
	 * @generated
	 * @ordered
	 */
	protected static final ResourceRef RESOURCE_REF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getResourceRef() <em>Resource Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceRef()
	 * @generated
	 * @ordered
	 */
	protected ResourceRef resourceRef = RESOURCE_REF_EDEFAULT;

	/**
	 * The cached value of the '{@link #getContents() <em>Contents</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContents()
	 * @generated
	 * @ordered
	 */
	protected AbstractStringContentProvider contents;

	/**
	 * The cached value of the '{@link #getMarkers() <em>Markers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMarkers()
	 * @generated
	 * @ordered
	 */
	protected EList<SourceFileMarker> markers;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceInfoImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.RESOURCE_INFO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceRef getResourceRef() {
		return resourceRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceRef(ResourceRef newResourceRef) {
		ResourceRef oldResourceRef = resourceRef;
		resourceRef = newResourceRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.RESOURCE_INFO__RESOURCE_REF, oldResourceRef, resourceRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractStringContentProvider getContents() {
		return contents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContents(AbstractStringContentProvider newContents, NotificationChain msgs) {
		AbstractStringContentProvider oldContents = contents;
		contents = newContents;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.RESOURCE_INFO__CONTENTS, oldContents, newContents);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContents(AbstractStringContentProvider newContents) {
		if (newContents != contents) {
			NotificationChain msgs = null;
			if (contents != null)
				msgs = ((InternalEObject)contents).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.RESOURCE_INFO__CONTENTS, null, msgs);
			if (newContents != null)
				msgs = ((InternalEObject)newContents).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.RESOURCE_INFO__CONTENTS, null, msgs);
			msgs = basicSetContents(newContents, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.RESOURCE_INFO__CONTENTS, newContents, newContents));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SourceFileMarker> getMarkers() {
		if (markers == null) {
			markers = new EObjectContainmentEList<SourceFileMarker>(SourceFileMarker.class, this, ModelPackage.RESOURCE_INFO__MARKERS);
		}
		return markers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.RESOURCE_INFO__CONTENTS:
				return basicSetContents(null, msgs);
			case ModelPackage.RESOURCE_INFO__MARKERS:
				return ((InternalEList<?>)getMarkers()).basicRemove(otherEnd, msgs);
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
			case ModelPackage.RESOURCE_INFO__RESOURCE_REF:
				return getResourceRef();
			case ModelPackage.RESOURCE_INFO__CONTENTS:
				return getContents();
			case ModelPackage.RESOURCE_INFO__MARKERS:
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
			case ModelPackage.RESOURCE_INFO__RESOURCE_REF:
				setResourceRef((ResourceRef)newValue);
				return;
			case ModelPackage.RESOURCE_INFO__CONTENTS:
				setContents((AbstractStringContentProvider)newValue);
				return;
			case ModelPackage.RESOURCE_INFO__MARKERS:
				getMarkers().clear();
				getMarkers().addAll((Collection<? extends SourceFileMarker>)newValue);
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
			case ModelPackage.RESOURCE_INFO__RESOURCE_REF:
				setResourceRef(RESOURCE_REF_EDEFAULT);
				return;
			case ModelPackage.RESOURCE_INFO__CONTENTS:
				setContents((AbstractStringContentProvider)null);
				return;
			case ModelPackage.RESOURCE_INFO__MARKERS:
				getMarkers().clear();
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
			case ModelPackage.RESOURCE_INFO__RESOURCE_REF:
				return RESOURCE_REF_EDEFAULT == null ? resourceRef != null : !RESOURCE_REF_EDEFAULT.equals(resourceRef);
			case ModelPackage.RESOURCE_INFO__CONTENTS:
				return contents != null;
			case ModelPackage.RESOURCE_INFO__MARKERS:
				return markers != null && !markers.isEmpty();
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
		result.append(" (resourceRef: ");
		result.append(resourceRef);
		result.append(')');
		return result.toString();
	}

} //ResourceInfoImpl
