package no.hal.eclipsky.services.workspace;

import no.hal.eclipsky.services.common.ResourceRef;
import no.hal.eclipsky.services.common.SourceFileMarker;

/**
 * Project level methods, i.e. mainly covering resources and related info
 * @author hal
 *
 */
public interface ProjectService extends ResourcesService {

	/**
	 * Gets the content of the provided source file as a String
	 * @param resourceRef reference to the source file
	 * @return the content of the source file
	 */
	public String getSourceFile(ResourceRef resourceRef);

	/**
	 * Gets the content of the provided resource as a byte array
	 * @param resourceRef reference to the source file
	 * @return the content of the resource
	 */
	public byte[] getResource(ResourceRef resourceRef);
	
	/**
	 * Gets the markers associated with the provided source file (resource)
	 * @param resourceRef reference to the source file
	 * @param build whether to trigger and wait for a build
	 * @return the array of markers
	 */
	public SourceFileMarker[] getSourceFileMarkers(ResourceRef resourceRef, boolean build);

	/**
	 * Updates the source file's content
	 * @param resourceRef reference to the source file
	 * @param stringContent the new file content
	 * @param exists whether to require (non-null) that it actually already exists (true) or not (false)
	 * @param markers whether to return markers (non-null means yes) and possibly wait for a build (true) or not (true)
	 * @return
	 */
	public SourceFileMarker[] updateSourceFile(ResourceRef resourceRef, String stringContent, Boolean exists, Boolean markers);
}
