/**
 */
package no.hal.eclipsky.services.workspace.model.impl;

import no.hal.eclipsky.services.workspace.model.AbstractService;
import no.hal.eclipsky.services.workspace.model.ModelPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Service</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link no.hal.eclipsky.services.workspace.model.impl.AbstractServiceImpl#getRequestTime <em>Request Time</em>}</li>
 *   <li>{@link no.hal.eclipsky.services.workspace.model.impl.AbstractServiceImpl#getResponseTime <em>Response Time</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AbstractServiceImpl extends MinimalEObjectImpl.Container implements AbstractService {
	/**
	 * The default value of the '{@link #getRequestTime() <em>Request Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequestTime()
	 * @generated
	 * @ordered
	 */
	protected static final long REQUEST_TIME_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getRequestTime() <em>Request Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequestTime()
	 * @generated
	 * @ordered
	 */
	protected long requestTime = REQUEST_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getResponseTime() <em>Response Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResponseTime()
	 * @generated
	 * @ordered
	 */
	protected static final long RESPONSE_TIME_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getResponseTime() <em>Response Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResponseTime()
	 * @generated
	 * @ordered
	 */
	protected long responseTime = RESPONSE_TIME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractServiceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.ABSTRACT_SERVICE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getRequestTime() {
		return requestTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequestTime(long newRequestTime) {
		long oldRequestTime = requestTime;
		requestTime = newRequestTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ABSTRACT_SERVICE__REQUEST_TIME, oldRequestTime, requestTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getResponseTime() {
		return responseTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResponseTime(long newResponseTime) {
		long oldResponseTime = responseTime;
		responseTime = newResponseTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ABSTRACT_SERVICE__RESPONSE_TIME, oldResponseTime, responseTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.ABSTRACT_SERVICE__REQUEST_TIME:
				return getRequestTime();
			case ModelPackage.ABSTRACT_SERVICE__RESPONSE_TIME:
				return getResponseTime();
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
			case ModelPackage.ABSTRACT_SERVICE__REQUEST_TIME:
				setRequestTime((Long)newValue);
				return;
			case ModelPackage.ABSTRACT_SERVICE__RESPONSE_TIME:
				setResponseTime((Long)newValue);
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
			case ModelPackage.ABSTRACT_SERVICE__REQUEST_TIME:
				setRequestTime(REQUEST_TIME_EDEFAULT);
				return;
			case ModelPackage.ABSTRACT_SERVICE__RESPONSE_TIME:
				setResponseTime(RESPONSE_TIME_EDEFAULT);
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
			case ModelPackage.ABSTRACT_SERVICE__REQUEST_TIME:
				return requestTime != REQUEST_TIME_EDEFAULT;
			case ModelPackage.ABSTRACT_SERVICE__RESPONSE_TIME:
				return responseTime != RESPONSE_TIME_EDEFAULT;
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
		result.append(" (requestTime: ");
		result.append(requestTime);
		result.append(", responseTime: ");
		result.append(responseTime);
		result.append(')');
		return result.toString();
	}

} //AbstractServiceImpl
