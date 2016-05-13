/**
 */
package no.hal.eclipsky.services.workspace.model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Completion Editor Service</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link no.hal.eclipsky.services.workspace.model.CompletionEditorService#getPosition <em>Position</em>}</li>
 *   <li>{@link no.hal.eclipsky.services.workspace.model.CompletionEditorService#getProposals <em>Proposals</em>}</li>
 * </ul>
 *
 * @see no.hal.eclipsky.services.workspace.model.ModelPackage#getCompletionEditorService()
 * @model
 * @generated
 */
public interface CompletionEditorService extends SourceEditorService {
	/**
	 * Returns the value of the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Position</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Position</em>' attribute.
	 * @see #setPosition(int)
	 * @see no.hal.eclipsky.services.workspace.model.ModelPackage#getCompletionEditorService_Position()
	 * @model
	 * @generated
	 */
	int getPosition();

	/**
	 * Sets the value of the '{@link no.hal.eclipsky.services.workspace.model.CompletionEditorService#getPosition <em>Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Position</em>' attribute.
	 * @see #getPosition()
	 * @generated
	 */
	void setPosition(int value);

	/**
	 * Returns the value of the '<em><b>Proposals</b></em>' containment reference list.
	 * The list contents are of type {@link no.hal.eclipsky.services.workspace.model.CompletionProposal}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Proposals</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Proposals</em>' containment reference list.
	 * @see no.hal.eclipsky.services.workspace.model.ModelPackage#getCompletionEditorService_Proposals()
	 * @model containment="true"
	 * @generated
	 */
	EList<CompletionProposal> getProposals();

} // CompletionEditorService
