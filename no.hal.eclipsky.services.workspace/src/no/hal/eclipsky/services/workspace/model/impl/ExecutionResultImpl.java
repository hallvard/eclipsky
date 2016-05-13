/**
 */
package no.hal.eclipsky.services.workspace.model.impl;

import no.hal.eclipsky.services.workspace.model.ExecutionResult;
import no.hal.eclipsky.services.workspace.model.ModelPackage;
import no.hal.eclipsky.services.workspace.model.SourceFileMarker;

import no.hal.emfs.AbstractStringContents;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Execution Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link no.hal.eclipsky.services.workspace.model.impl.ExecutionResultImpl#getSysout <em>Sysout</em>}</li>
 *   <li>{@link no.hal.eclipsky.services.workspace.model.impl.ExecutionResultImpl#getSyserr <em>Syserr</em>}</li>
 *   <li>{@link no.hal.eclipsky.services.workspace.model.impl.ExecutionResultImpl#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link no.hal.eclipsky.services.workspace.model.impl.ExecutionResultImpl#getExceptionLocation <em>Exception Location</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ExecutionResultImpl extends MinimalEObjectImpl.Container implements ExecutionResult {
	/**
	 * The cached value of the '{@link #getSysout() <em>Sysout</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSysout()
	 * @generated
	 * @ordered
	 */
	protected AbstractStringContents sysout;

	/**
	 * The cached value of the '{@link #getSyserr() <em>Syserr</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSyserr()
	 * @generated
	 * @ordered
	 */
	protected AbstractStringContents syserr;

	/**
	 * The default value of the '{@link #getQualifiedName() <em>Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualifiedName()
	 * @generated
	 * @ordered
	 */
	protected static final String QUALIFIED_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getQualifiedName() <em>Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualifiedName()
	 * @generated
	 * @ordered
	 */
	protected String qualifiedName = QUALIFIED_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getExceptionLocation() <em>Exception Location</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExceptionLocation()
	 * @generated
	 * @ordered
	 */
	protected SourceFileMarker exceptionLocation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExecutionResultImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.EXECUTION_RESULT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractStringContents getSysout() {
		return sysout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSysout(AbstractStringContents newSysout, NotificationChain msgs) {
		AbstractStringContents oldSysout = sysout;
		sysout = newSysout;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.EXECUTION_RESULT__SYSOUT, oldSysout, newSysout);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSysout(AbstractStringContents newSysout) {
		if (newSysout != sysout) {
			NotificationChain msgs = null;
			if (sysout != null)
				msgs = ((InternalEObject)sysout).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.EXECUTION_RESULT__SYSOUT, null, msgs);
			if (newSysout != null)
				msgs = ((InternalEObject)newSysout).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.EXECUTION_RESULT__SYSOUT, null, msgs);
			msgs = basicSetSysout(newSysout, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.EXECUTION_RESULT__SYSOUT, newSysout, newSysout));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractStringContents getSyserr() {
		return syserr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSyserr(AbstractStringContents newSyserr, NotificationChain msgs) {
		AbstractStringContents oldSyserr = syserr;
		syserr = newSyserr;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.EXECUTION_RESULT__SYSERR, oldSyserr, newSyserr);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSyserr(AbstractStringContents newSyserr) {
		if (newSyserr != syserr) {
			NotificationChain msgs = null;
			if (syserr != null)
				msgs = ((InternalEObject)syserr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.EXECUTION_RESULT__SYSERR, null, msgs);
			if (newSyserr != null)
				msgs = ((InternalEObject)newSyserr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.EXECUTION_RESULT__SYSERR, null, msgs);
			msgs = basicSetSyserr(newSyserr, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.EXECUTION_RESULT__SYSERR, newSyserr, newSyserr));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getQualifiedName() {
		return qualifiedName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQualifiedName(String newQualifiedName) {
		String oldQualifiedName = qualifiedName;
		qualifiedName = newQualifiedName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.EXECUTION_RESULT__QUALIFIED_NAME, oldQualifiedName, qualifiedName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceFileMarker getExceptionLocation() {
		return exceptionLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExceptionLocation(SourceFileMarker newExceptionLocation, NotificationChain msgs) {
		SourceFileMarker oldExceptionLocation = exceptionLocation;
		exceptionLocation = newExceptionLocation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.EXECUTION_RESULT__EXCEPTION_LOCATION, oldExceptionLocation, newExceptionLocation);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExceptionLocation(SourceFileMarker newExceptionLocation) {
		if (newExceptionLocation != exceptionLocation) {
			NotificationChain msgs = null;
			if (exceptionLocation != null)
				msgs = ((InternalEObject)exceptionLocation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.EXECUTION_RESULT__EXCEPTION_LOCATION, null, msgs);
			if (newExceptionLocation != null)
				msgs = ((InternalEObject)newExceptionLocation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.EXECUTION_RESULT__EXCEPTION_LOCATION, null, msgs);
			msgs = basicSetExceptionLocation(newExceptionLocation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.EXECUTION_RESULT__EXCEPTION_LOCATION, newExceptionLocation, newExceptionLocation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.EXECUTION_RESULT__SYSOUT:
				return basicSetSysout(null, msgs);
			case ModelPackage.EXECUTION_RESULT__SYSERR:
				return basicSetSyserr(null, msgs);
			case ModelPackage.EXECUTION_RESULT__EXCEPTION_LOCATION:
				return basicSetExceptionLocation(null, msgs);
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
			case ModelPackage.EXECUTION_RESULT__SYSOUT:
				return getSysout();
			case ModelPackage.EXECUTION_RESULT__SYSERR:
				return getSyserr();
			case ModelPackage.EXECUTION_RESULT__QUALIFIED_NAME:
				return getQualifiedName();
			case ModelPackage.EXECUTION_RESULT__EXCEPTION_LOCATION:
				return getExceptionLocation();
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
			case ModelPackage.EXECUTION_RESULT__SYSOUT:
				setSysout((AbstractStringContents)newValue);
				return;
			case ModelPackage.EXECUTION_RESULT__SYSERR:
				setSyserr((AbstractStringContents)newValue);
				return;
			case ModelPackage.EXECUTION_RESULT__QUALIFIED_NAME:
				setQualifiedName((String)newValue);
				return;
			case ModelPackage.EXECUTION_RESULT__EXCEPTION_LOCATION:
				setExceptionLocation((SourceFileMarker)newValue);
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
			case ModelPackage.EXECUTION_RESULT__SYSOUT:
				setSysout((AbstractStringContents)null);
				return;
			case ModelPackage.EXECUTION_RESULT__SYSERR:
				setSyserr((AbstractStringContents)null);
				return;
			case ModelPackage.EXECUTION_RESULT__QUALIFIED_NAME:
				setQualifiedName(QUALIFIED_NAME_EDEFAULT);
				return;
			case ModelPackage.EXECUTION_RESULT__EXCEPTION_LOCATION:
				setExceptionLocation((SourceFileMarker)null);
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
			case ModelPackage.EXECUTION_RESULT__SYSOUT:
				return sysout != null;
			case ModelPackage.EXECUTION_RESULT__SYSERR:
				return syserr != null;
			case ModelPackage.EXECUTION_RESULT__QUALIFIED_NAME:
				return QUALIFIED_NAME_EDEFAULT == null ? qualifiedName != null : !QUALIFIED_NAME_EDEFAULT.equals(qualifiedName);
			case ModelPackage.EXECUTION_RESULT__EXCEPTION_LOCATION:
				return exceptionLocation != null;
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
		result.append(" (qualifiedName: ");
		result.append(qualifiedName);
		result.append(')');
		return result.toString();
	}

} //ExecutionResultImpl
