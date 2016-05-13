/**
 */
package no.hal.eclipsky.services.workspace.model.impl;

import no.hal.eclipsky.services.workspace.model.ModelPackage;
import no.hal.eclipsky.services.workspace.model.ProjectResponseOptions;
import no.hal.eclipsky.services.workspace.model.ResourceResponseOptions;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Project Response Options</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link no.hal.eclipsky.services.workspace.model.impl.ProjectResponseOptionsImpl#isIncludeResources <em>Include Resources</em>}</li>
 *   <li>{@link no.hal.eclipsky.services.workspace.model.impl.ProjectResponseOptionsImpl#getResourceResponseOptions <em>Resource Response Options</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ProjectResponseOptionsImpl extends MinimalEObjectImpl.Container implements ProjectResponseOptions {
	/**
	 * The default value of the '{@link #isIncludeResources() <em>Include Resources</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIncludeResources()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INCLUDE_RESOURCES_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIncludeResources() <em>Include Resources</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIncludeResources()
	 * @generated
	 * @ordered
	 */
	protected boolean includeResources = INCLUDE_RESOURCES_EDEFAULT;

	/**
	 * The cached value of the '{@link #getResourceResponseOptions() <em>Resource Response Options</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceResponseOptions()
	 * @generated
	 * @ordered
	 */
	protected ResourceResponseOptions resourceResponseOptions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProjectResponseOptionsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.PROJECT_RESPONSE_OPTIONS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIncludeResources() {
		return includeResources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIncludeResources(boolean newIncludeResources) {
		boolean oldIncludeResources = includeResources;
		includeResources = newIncludeResources;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PROJECT_RESPONSE_OPTIONS__INCLUDE_RESOURCES, oldIncludeResources, includeResources));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceResponseOptions getResourceResponseOptions() {
		return resourceResponseOptions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResourceResponseOptions(ResourceResponseOptions newResourceResponseOptions, NotificationChain msgs) {
		ResourceResponseOptions oldResourceResponseOptions = resourceResponseOptions;
		resourceResponseOptions = newResourceResponseOptions;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.PROJECT_RESPONSE_OPTIONS__RESOURCE_RESPONSE_OPTIONS, oldResourceResponseOptions, newResourceResponseOptions);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceResponseOptions(ResourceResponseOptions newResourceResponseOptions) {
		if (newResourceResponseOptions != resourceResponseOptions) {
			NotificationChain msgs = null;
			if (resourceResponseOptions != null)
				msgs = ((InternalEObject)resourceResponseOptions).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.PROJECT_RESPONSE_OPTIONS__RESOURCE_RESPONSE_OPTIONS, null, msgs);
			if (newResourceResponseOptions != null)
				msgs = ((InternalEObject)newResourceResponseOptions).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.PROJECT_RESPONSE_OPTIONS__RESOURCE_RESPONSE_OPTIONS, null, msgs);
			msgs = basicSetResourceResponseOptions(newResourceResponseOptions, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PROJECT_RESPONSE_OPTIONS__RESOURCE_RESPONSE_OPTIONS, newResourceResponseOptions, newResourceResponseOptions));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.PROJECT_RESPONSE_OPTIONS__RESOURCE_RESPONSE_OPTIONS:
				return basicSetResourceResponseOptions(null, msgs);
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
			case ModelPackage.PROJECT_RESPONSE_OPTIONS__INCLUDE_RESOURCES:
				return isIncludeResources();
			case ModelPackage.PROJECT_RESPONSE_OPTIONS__RESOURCE_RESPONSE_OPTIONS:
				return getResourceResponseOptions();
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
			case ModelPackage.PROJECT_RESPONSE_OPTIONS__INCLUDE_RESOURCES:
				setIncludeResources((Boolean)newValue);
				return;
			case ModelPackage.PROJECT_RESPONSE_OPTIONS__RESOURCE_RESPONSE_OPTIONS:
				setResourceResponseOptions((ResourceResponseOptions)newValue);
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
			case ModelPackage.PROJECT_RESPONSE_OPTIONS__INCLUDE_RESOURCES:
				setIncludeResources(INCLUDE_RESOURCES_EDEFAULT);
				return;
			case ModelPackage.PROJECT_RESPONSE_OPTIONS__RESOURCE_RESPONSE_OPTIONS:
				setResourceResponseOptions((ResourceResponseOptions)null);
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
			case ModelPackage.PROJECT_RESPONSE_OPTIONS__INCLUDE_RESOURCES:
				return includeResources != INCLUDE_RESOURCES_EDEFAULT;
			case ModelPackage.PROJECT_RESPONSE_OPTIONS__RESOURCE_RESPONSE_OPTIONS:
				return resourceResponseOptions != null;
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
		result.append(" (includeResources: ");
		result.append(includeResources);
		result.append(')');
		return result.toString();
	}

} //ProjectResponseOptionsImpl
