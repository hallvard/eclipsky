/**
 */
package no.hal.eclipsky.services.workspace.model.impl;

import java.util.Collection;
import no.hal.eclipsky.services.workspace.model.ModelPackage;
import no.hal.eclipsky.services.workspace.model.ProjectInfo;
import no.hal.eclipsky.services.workspace.model.ProjectListService;

import no.hal.eclipsky.services.workspace.model.ProjectResponseOptions;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Project List Service</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link no.hal.eclipsky.services.workspace.model.impl.ProjectListServiceImpl#getNamePattern <em>Name Pattern</em>}</li>
 *   <li>{@link no.hal.eclipsky.services.workspace.model.impl.ProjectListServiceImpl#getType <em>Type</em>}</li>
 *   <li>{@link no.hal.eclipsky.services.workspace.model.impl.ProjectListServiceImpl#getResponseOptions <em>Response Options</em>}</li>
 *   <li>{@link no.hal.eclipsky.services.workspace.model.impl.ProjectListServiceImpl#getProjects <em>Projects</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ProjectListServiceImpl extends AbstractServiceImpl implements ProjectListService {
	/**
	 * The default value of the '{@link #getNamePattern() <em>Name Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNamePattern()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_PATTERN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNamePattern() <em>Name Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNamePattern()
	 * @generated
	 * @ordered
	 */
	protected String namePattern = NAME_PATTERN_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getResponseOptions() <em>Response Options</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResponseOptions()
	 * @generated
	 * @ordered
	 */
	protected ProjectResponseOptions responseOptions;

	/**
	 * The cached value of the '{@link #getProjects() <em>Projects</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProjects()
	 * @generated
	 * @ordered
	 */
	protected EList<ProjectInfo> projects;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProjectListServiceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.PROJECT_LIST_SERVICE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNamePattern() {
		return namePattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNamePattern(String newNamePattern) {
		String oldNamePattern = namePattern;
		namePattern = newNamePattern;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PROJECT_LIST_SERVICE__NAME_PATTERN, oldNamePattern, namePattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(String newType) {
		String oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PROJECT_LIST_SERVICE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProjectResponseOptions getResponseOptions() {
		return responseOptions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResponseOptions(ProjectResponseOptions newResponseOptions, NotificationChain msgs) {
		ProjectResponseOptions oldResponseOptions = responseOptions;
		responseOptions = newResponseOptions;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.PROJECT_LIST_SERVICE__RESPONSE_OPTIONS, oldResponseOptions, newResponseOptions);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResponseOptions(ProjectResponseOptions newResponseOptions) {
		if (newResponseOptions != responseOptions) {
			NotificationChain msgs = null;
			if (responseOptions != null)
				msgs = ((InternalEObject)responseOptions).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.PROJECT_LIST_SERVICE__RESPONSE_OPTIONS, null, msgs);
			if (newResponseOptions != null)
				msgs = ((InternalEObject)newResponseOptions).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.PROJECT_LIST_SERVICE__RESPONSE_OPTIONS, null, msgs);
			msgs = basicSetResponseOptions(newResponseOptions, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PROJECT_LIST_SERVICE__RESPONSE_OPTIONS, newResponseOptions, newResponseOptions));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ProjectInfo> getProjects() {
		if (projects == null) {
			projects = new EObjectContainmentEList<ProjectInfo>(ProjectInfo.class, this, ModelPackage.PROJECT_LIST_SERVICE__PROJECTS);
		}
		return projects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.PROJECT_LIST_SERVICE__RESPONSE_OPTIONS:
				return basicSetResponseOptions(null, msgs);
			case ModelPackage.PROJECT_LIST_SERVICE__PROJECTS:
				return ((InternalEList<?>)getProjects()).basicRemove(otherEnd, msgs);
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
			case ModelPackage.PROJECT_LIST_SERVICE__NAME_PATTERN:
				return getNamePattern();
			case ModelPackage.PROJECT_LIST_SERVICE__TYPE:
				return getType();
			case ModelPackage.PROJECT_LIST_SERVICE__RESPONSE_OPTIONS:
				return getResponseOptions();
			case ModelPackage.PROJECT_LIST_SERVICE__PROJECTS:
				return getProjects();
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
			case ModelPackage.PROJECT_LIST_SERVICE__NAME_PATTERN:
				setNamePattern((String)newValue);
				return;
			case ModelPackage.PROJECT_LIST_SERVICE__TYPE:
				setType((String)newValue);
				return;
			case ModelPackage.PROJECT_LIST_SERVICE__RESPONSE_OPTIONS:
				setResponseOptions((ProjectResponseOptions)newValue);
				return;
			case ModelPackage.PROJECT_LIST_SERVICE__PROJECTS:
				getProjects().clear();
				getProjects().addAll((Collection<? extends ProjectInfo>)newValue);
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
			case ModelPackage.PROJECT_LIST_SERVICE__NAME_PATTERN:
				setNamePattern(NAME_PATTERN_EDEFAULT);
				return;
			case ModelPackage.PROJECT_LIST_SERVICE__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case ModelPackage.PROJECT_LIST_SERVICE__RESPONSE_OPTIONS:
				setResponseOptions((ProjectResponseOptions)null);
				return;
			case ModelPackage.PROJECT_LIST_SERVICE__PROJECTS:
				getProjects().clear();
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
			case ModelPackage.PROJECT_LIST_SERVICE__NAME_PATTERN:
				return NAME_PATTERN_EDEFAULT == null ? namePattern != null : !NAME_PATTERN_EDEFAULT.equals(namePattern);
			case ModelPackage.PROJECT_LIST_SERVICE__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case ModelPackage.PROJECT_LIST_SERVICE__RESPONSE_OPTIONS:
				return responseOptions != null;
			case ModelPackage.PROJECT_LIST_SERVICE__PROJECTS:
				return projects != null && !projects.isEmpty();
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
		result.append(" (namePattern: ");
		result.append(namePattern);
		result.append(", type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

} //ProjectListServiceImpl
