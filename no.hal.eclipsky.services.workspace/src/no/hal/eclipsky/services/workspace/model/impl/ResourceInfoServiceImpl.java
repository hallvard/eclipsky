/**
 */
package no.hal.eclipsky.services.workspace.model.impl;

import no.hal.eclipsky.services.workspace.model.ModelPackage;
import no.hal.eclipsky.services.workspace.model.ResourceInfo;
import no.hal.eclipsky.services.workspace.model.ResourceInfoService;
import no.hal.eclipsky.services.workspace.model.ResourceResponseOptions;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Info Service</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link no.hal.eclipsky.services.workspace.model.impl.ResourceInfoServiceImpl#getResponseOptions <em>Response Options</em>}</li>
 *   <li>{@link no.hal.eclipsky.services.workspace.model.impl.ResourceInfoServiceImpl#getResource <em>Resource</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ResourceInfoServiceImpl extends MinimalEObjectImpl.Container implements ResourceInfoService {
	/**
	 * The cached value of the '{@link #getResponseOptions() <em>Response Options</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResponseOptions()
	 * @generated
	 * @ordered
	 */
	protected ResourceResponseOptions responseOptions;

	/**
	 * The cached value of the '{@link #getResource() <em>Resource</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResource()
	 * @generated
	 * @ordered
	 */
	protected ResourceInfo resource;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceInfoServiceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.RESOURCE_INFO_SERVICE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceResponseOptions getResponseOptions() {
		return responseOptions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResponseOptions(ResourceResponseOptions newResponseOptions, NotificationChain msgs) {
		ResourceResponseOptions oldResponseOptions = responseOptions;
		responseOptions = newResponseOptions;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.RESOURCE_INFO_SERVICE__RESPONSE_OPTIONS, oldResponseOptions, newResponseOptions);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResponseOptions(ResourceResponseOptions newResponseOptions) {
		if (newResponseOptions != responseOptions) {
			NotificationChain msgs = null;
			if (responseOptions != null)
				msgs = ((InternalEObject)responseOptions).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.RESOURCE_INFO_SERVICE__RESPONSE_OPTIONS, null, msgs);
			if (newResponseOptions != null)
				msgs = ((InternalEObject)newResponseOptions).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.RESOURCE_INFO_SERVICE__RESPONSE_OPTIONS, null, msgs);
			msgs = basicSetResponseOptions(newResponseOptions, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.RESOURCE_INFO_SERVICE__RESPONSE_OPTIONS, newResponseOptions, newResponseOptions));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceInfo getResource() {
		return resource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResource(ResourceInfo newResource, NotificationChain msgs) {
		ResourceInfo oldResource = resource;
		resource = newResource;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.RESOURCE_INFO_SERVICE__RESOURCE, oldResource, newResource);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResource(ResourceInfo newResource) {
		if (newResource != resource) {
			NotificationChain msgs = null;
			if (resource != null)
				msgs = ((InternalEObject)resource).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.RESOURCE_INFO_SERVICE__RESOURCE, null, msgs);
			if (newResource != null)
				msgs = ((InternalEObject)newResource).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.RESOURCE_INFO_SERVICE__RESOURCE, null, msgs);
			msgs = basicSetResource(newResource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.RESOURCE_INFO_SERVICE__RESOURCE, newResource, newResource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.RESOURCE_INFO_SERVICE__RESPONSE_OPTIONS:
				return basicSetResponseOptions(null, msgs);
			case ModelPackage.RESOURCE_INFO_SERVICE__RESOURCE:
				return basicSetResource(null, msgs);
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
			case ModelPackage.RESOURCE_INFO_SERVICE__RESPONSE_OPTIONS:
				return getResponseOptions();
			case ModelPackage.RESOURCE_INFO_SERVICE__RESOURCE:
				return getResource();
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
			case ModelPackage.RESOURCE_INFO_SERVICE__RESPONSE_OPTIONS:
				setResponseOptions((ResourceResponseOptions)newValue);
				return;
			case ModelPackage.RESOURCE_INFO_SERVICE__RESOURCE:
				setResource((ResourceInfo)newValue);
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
			case ModelPackage.RESOURCE_INFO_SERVICE__RESPONSE_OPTIONS:
				setResponseOptions((ResourceResponseOptions)null);
				return;
			case ModelPackage.RESOURCE_INFO_SERVICE__RESOURCE:
				setResource((ResourceInfo)null);
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
			case ModelPackage.RESOURCE_INFO_SERVICE__RESPONSE_OPTIONS:
				return responseOptions != null;
			case ModelPackage.RESOURCE_INFO_SERVICE__RESOURCE:
				return resource != null;
		}
		return super.eIsSet(featureID);
	}

} //ResourceInfoServiceImpl
