/**
 */
package no.hal.eclipsky.services.workspace.model.impl;

import java.util.Collection;

import no.hal.eclipsky.services.common.ProjectRef;

import no.hal.eclipsky.services.workspace.model.ModelPackage;
import no.hal.eclipsky.services.workspace.model.ProjectInfo;
import no.hal.eclipsky.services.workspace.model.ResourceInfo;

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
 * An implementation of the model object '<em><b>Project Info</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link no.hal.eclipsky.services.workspace.model.impl.ProjectInfoImpl#getProjectRef <em>Project Ref</em>}</li>
 *   <li>{@link no.hal.eclipsky.services.workspace.model.impl.ProjectInfoImpl#getResources <em>Resources</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ProjectInfoImpl extends MinimalEObjectImpl.Container implements ProjectInfo {
	/**
	 * The default value of the '{@link #getProjectRef() <em>Project Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProjectRef()
	 * @generated
	 * @ordered
	 */
	protected static final ProjectRef PROJECT_REF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProjectRef() <em>Project Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProjectRef()
	 * @generated
	 * @ordered
	 */
	protected ProjectRef projectRef = PROJECT_REF_EDEFAULT;

	/**
	 * The cached value of the '{@link #getResources() <em>Resources</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResources()
	 * @generated
	 * @ordered
	 */
	protected EList<ResourceInfo> resources;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProjectInfoImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.PROJECT_INFO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProjectRef getProjectRef() {
		return projectRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProjectRef(ProjectRef newProjectRef) {
		ProjectRef oldProjectRef = projectRef;
		projectRef = newProjectRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PROJECT_INFO__PROJECT_REF, oldProjectRef, projectRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ResourceInfo> getResources() {
		if (resources == null) {
			resources = new EObjectContainmentEList<ResourceInfo>(ResourceInfo.class, this, ModelPackage.PROJECT_INFO__RESOURCES);
		}
		return resources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.PROJECT_INFO__RESOURCES:
				return ((InternalEList<?>)getResources()).basicRemove(otherEnd, msgs);
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
			case ModelPackage.PROJECT_INFO__PROJECT_REF:
				return getProjectRef();
			case ModelPackage.PROJECT_INFO__RESOURCES:
				return getResources();
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
			case ModelPackage.PROJECT_INFO__PROJECT_REF:
				setProjectRef((ProjectRef)newValue);
				return;
			case ModelPackage.PROJECT_INFO__RESOURCES:
				getResources().clear();
				getResources().addAll((Collection<? extends ResourceInfo>)newValue);
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
			case ModelPackage.PROJECT_INFO__PROJECT_REF:
				setProjectRef(PROJECT_REF_EDEFAULT);
				return;
			case ModelPackage.PROJECT_INFO__RESOURCES:
				getResources().clear();
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
			case ModelPackage.PROJECT_INFO__PROJECT_REF:
				return PROJECT_REF_EDEFAULT == null ? projectRef != null : !PROJECT_REF_EDEFAULT.equals(projectRef);
			case ModelPackage.PROJECT_INFO__RESOURCES:
				return resources != null && !resources.isEmpty();
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
		result.append(" (projectRef: ");
		result.append(projectRef);
		result.append(')');
		return result.toString();
	}

} //ProjectInfoImpl
