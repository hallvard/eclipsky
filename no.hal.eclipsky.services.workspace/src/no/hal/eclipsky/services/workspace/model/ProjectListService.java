/**
 */
package no.hal.eclipsky.services.workspace.model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Project List Service</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link no.hal.eclipsky.services.workspace.model.ProjectListService#getNamePattern <em>Name Pattern</em>}</li>
 *   <li>{@link no.hal.eclipsky.services.workspace.model.ProjectListService#getType <em>Type</em>}</li>
 *   <li>{@link no.hal.eclipsky.services.workspace.model.ProjectListService#getResponseOptions <em>Response Options</em>}</li>
 *   <li>{@link no.hal.eclipsky.services.workspace.model.ProjectListService#getProjects <em>Projects</em>}</li>
 * </ul>
 *
 * @see no.hal.eclipsky.services.workspace.model.ModelPackage#getProjectListService()
 * @model
 * @generated
 */
public interface ProjectListService extends AbstractService {
	/**
	 * Returns the value of the '<em><b>Name Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name Pattern</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name Pattern</em>' attribute.
	 * @see #setNamePattern(String)
	 * @see no.hal.eclipsky.services.workspace.model.ModelPackage#getProjectListService_NamePattern()
	 * @model
	 * @generated
	 */
	String getNamePattern();

	/**
	 * Sets the value of the '{@link no.hal.eclipsky.services.workspace.model.ProjectListService#getNamePattern <em>Name Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name Pattern</em>' attribute.
	 * @see #getNamePattern()
	 * @generated
	 */
	void setNamePattern(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see no.hal.eclipsky.services.workspace.model.ModelPackage#getProjectListService_Type()
	 * @model
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link no.hal.eclipsky.services.workspace.model.ProjectListService#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * Returns the value of the '<em><b>Response Options</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Response Options</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Response Options</em>' containment reference.
	 * @see #setResponseOptions(ProjectResponseOptions)
	 * @see no.hal.eclipsky.services.workspace.model.ModelPackage#getProjectListService_ResponseOptions()
	 * @model containment="true"
	 * @generated
	 */
	ProjectResponseOptions getResponseOptions();

	/**
	 * Sets the value of the '{@link no.hal.eclipsky.services.workspace.model.ProjectListService#getResponseOptions <em>Response Options</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Response Options</em>' containment reference.
	 * @see #getResponseOptions()
	 * @generated
	 */
	void setResponseOptions(ProjectResponseOptions value);

	/**
	 * Returns the value of the '<em><b>Projects</b></em>' containment reference list.
	 * The list contents are of type {@link no.hal.eclipsky.services.workspace.model.ProjectInfo}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Projects</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Projects</em>' containment reference list.
	 * @see no.hal.eclipsky.services.workspace.model.ModelPackage#getProjectListService_Projects()
	 * @model containment="true"
	 * @generated
	 */
	EList<ProjectInfo> getProjects();

} // ProjectListService
