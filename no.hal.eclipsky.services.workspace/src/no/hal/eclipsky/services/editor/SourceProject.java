package no.hal.eclipsky.services.editor;

import no.hal.eclipsky.services.common.ProjectRef;
import no.hal.eclipsky.services.common.ResourceRef;
import no.hal.eclipsky.services.workspace.model.ExecutionResult;

public interface SourceProject {
	/**
	 * Get the project reference for this SourceProject
	 * @return the project reference for this SourceProject
	 */
	public ProjectRef getProjectRef();

	/**
	 * Get the SourceEditor for the provided ResourceRef
	 * @param resource the ResourceRef
	 * @return the SourceEditor for the provided ResourceRef
	 */
	public SourceEditor getSourceEditor(ResourceRef resource);
	
	/**
	 * Execute the provided ResourceRef as an application
	 * @param resourceRef the ResourceRef to run
	 * @return
	 */
	public ExecutionResult run(ResourceRef resourceRef);

	/**
	 * Execute the provided ResourceRef as a test
	 * @param resourceRef the ResourceRef to run
	 * @return
	 */
	public ExecutionResult test(ResourceRef resourceRef);
}
