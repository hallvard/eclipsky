/**
 */
package no.hal.eclipsky.services.workspace.model.impl;

import no.hal.eclipsky.services.workspace.model.ModelPackage;
import no.hal.eclipsky.services.workspace.model.ResultKind;
import no.hal.eclipsky.services.workspace.model.TestCaseResult;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Test Case Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link no.hal.eclipsky.services.workspace.model.impl.TestCaseResultImpl#getTestName <em>Test Name</em>}</li>
 *   <li>{@link no.hal.eclipsky.services.workspace.model.impl.TestCaseResultImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link no.hal.eclipsky.services.workspace.model.impl.TestCaseResultImpl#getMessage <em>Message</em>}</li>
 *   <li>{@link no.hal.eclipsky.services.workspace.model.impl.TestCaseResultImpl#getException <em>Exception</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TestCaseResultImpl extends MinimalEObjectImpl.Container implements TestCaseResult {
	/**
	 * The default value of the '{@link #getTestName() <em>Test Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestName()
	 * @generated
	 * @ordered
	 */
	protected static final String TEST_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTestName() <em>Test Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestName()
	 * @generated
	 * @ordered
	 */
	protected String testName = TEST_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final ResultKind KIND_EDEFAULT = ResultKind.UNKNOWN;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected ResultKind kind = KIND_EDEFAULT;

	/**
	 * The default value of the '{@link #getMessage() <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessage()
	 * @generated
	 * @ordered
	 */
	protected static final String MESSAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMessage() <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessage()
	 * @generated
	 * @ordered
	 */
	protected String message = MESSAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getException() <em>Exception</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getException()
	 * @generated
	 * @ordered
	 */
	protected static final String EXCEPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getException() <em>Exception</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getException()
	 * @generated
	 * @ordered
	 */
	protected String exception = EXCEPTION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TestCaseResultImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.TEST_CASE_RESULT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTestName() {
		return testName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTestName(String newTestName) {
		String oldTestName = testName;
		testName = newTestName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.TEST_CASE_RESULT__TEST_NAME, oldTestName, testName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultKind getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKind(ResultKind newKind) {
		ResultKind oldKind = kind;
		kind = newKind == null ? KIND_EDEFAULT : newKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.TEST_CASE_RESULT__KIND, oldKind, kind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMessage(String newMessage) {
		String oldMessage = message;
		message = newMessage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.TEST_CASE_RESULT__MESSAGE, oldMessage, message));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getException() {
		return exception;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setException(String newException) {
		String oldException = exception;
		exception = newException;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.TEST_CASE_RESULT__EXCEPTION, oldException, exception));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.TEST_CASE_RESULT__TEST_NAME:
				return getTestName();
			case ModelPackage.TEST_CASE_RESULT__KIND:
				return getKind();
			case ModelPackage.TEST_CASE_RESULT__MESSAGE:
				return getMessage();
			case ModelPackage.TEST_CASE_RESULT__EXCEPTION:
				return getException();
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
			case ModelPackage.TEST_CASE_RESULT__TEST_NAME:
				setTestName((String)newValue);
				return;
			case ModelPackage.TEST_CASE_RESULT__KIND:
				setKind((ResultKind)newValue);
				return;
			case ModelPackage.TEST_CASE_RESULT__MESSAGE:
				setMessage((String)newValue);
				return;
			case ModelPackage.TEST_CASE_RESULT__EXCEPTION:
				setException((String)newValue);
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
			case ModelPackage.TEST_CASE_RESULT__TEST_NAME:
				setTestName(TEST_NAME_EDEFAULT);
				return;
			case ModelPackage.TEST_CASE_RESULT__KIND:
				setKind(KIND_EDEFAULT);
				return;
			case ModelPackage.TEST_CASE_RESULT__MESSAGE:
				setMessage(MESSAGE_EDEFAULT);
				return;
			case ModelPackage.TEST_CASE_RESULT__EXCEPTION:
				setException(EXCEPTION_EDEFAULT);
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
			case ModelPackage.TEST_CASE_RESULT__TEST_NAME:
				return TEST_NAME_EDEFAULT == null ? testName != null : !TEST_NAME_EDEFAULT.equals(testName);
			case ModelPackage.TEST_CASE_RESULT__KIND:
				return kind != KIND_EDEFAULT;
			case ModelPackage.TEST_CASE_RESULT__MESSAGE:
				return MESSAGE_EDEFAULT == null ? message != null : !MESSAGE_EDEFAULT.equals(message);
			case ModelPackage.TEST_CASE_RESULT__EXCEPTION:
				return EXCEPTION_EDEFAULT == null ? exception != null : !EXCEPTION_EDEFAULT.equals(exception);
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
		result.append(" (testName: ");
		result.append(testName);
		result.append(", kind: ");
		result.append(kind);
		result.append(", message: ");
		result.append(message);
		result.append(", exception: ");
		result.append(exception);
		result.append(')');
		return result.toString();
	}

} //TestCaseResultImpl
