package no.hal.eclipsky.services.workspace;

import no.hal.eclipsky.services.common.ResourceRef;
import no.hal.eclipsky.services.common.ResourceVisitor;

/**
 * Common services for projects and workspaces
 * @author hal
 *
 */
public interface ResourcesService {

	/**
	 * Visit the resources at and underneath the provided resourceRefs
	 * @param visitor the ResourceVisitor to notify
	 * @param the depth the depth to recurse, 0 to only visit the roots (essentially verifying their existence)
	 * @param resourceRefs the root resources, where the packageName and resourceName elements may be null 
	 * @return the content of the source file
	 */
	public void visitResources(ResourceVisitor visitor, int depth, ResourceRef resourceRef);
}
