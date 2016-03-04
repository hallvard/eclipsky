package no.hal.eclipsky.services.emfs;

import java.util.Collection;

import org.eclipse.core.runtime.IProgressMonitor;

import no.hal.emfs.EmfsResource;

public interface EmfsService {

	public Collection<EmfsResource> exportResources(Collection<EmfsResource> emfsResources, String projectName, IProgressMonitor monitor) throws Exception;
}
