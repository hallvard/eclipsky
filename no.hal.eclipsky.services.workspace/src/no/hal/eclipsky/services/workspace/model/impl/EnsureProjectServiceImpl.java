/**
 */
package no.hal.eclipsky.services.workspace.model.impl;

import no.hal.eclipsky.services.workspace.model.EnsureProjectService;
import no.hal.eclipsky.services.workspace.model.ModelPackage;

import no.hal.emfs.EmfsResource;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ensure Project Service</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link no.hal.eclipsky.services.workspace.model.impl.EnsureProjectServiceImpl#getEmfs <em>Emfs</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EnsureProjectServiceImpl extends ProjectServiceImpl implements EnsureProjectService {
	/**
	 * The cached value of the '{@link #getEmfs() <em>Emfs</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmfs()
	 * @generated
	 * @ordered
	 */
	protected EmfsResource emfs;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EnsureProjectServiceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.ENSURE_PROJECT_SERVICE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EmfsResource getEmfs() {
		if (emfs != null && emfs.eIsProxy()) {
			InternalEObject oldEmfs = (InternalEObject)emfs;
			emfs = (EmfsResource)eResolveProxy(oldEmfs);
			if (emfs != oldEmfs) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.ENSURE_PROJECT_SERVICE__EMFS, oldEmfs, emfs));
			}
		}
		return emfs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EmfsResource basicGetEmfs() {
		return emfs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEmfs(EmfsResource newEmfs) {
		EmfsResource oldEmfs = emfs;
		emfs = newEmfs;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ENSURE_PROJECT_SERVICE__EMFS, oldEmfs, emfs));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.ENSURE_PROJECT_SERVICE__EMFS:
				if (resolve) return getEmfs();
				return basicGetEmfs();
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
			case ModelPackage.ENSURE_PROJECT_SERVICE__EMFS:
				setEmfs((EmfsResource)newValue);
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
			case ModelPackage.ENSURE_PROJECT_SERVICE__EMFS:
				setEmfs((EmfsResource)null);
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
			case ModelPackage.ENSURE_PROJECT_SERVICE__EMFS:
				return emfs != null;
		}
		return super.eIsSet(featureID);
	}

} //EnsureProjectServiceImpl
