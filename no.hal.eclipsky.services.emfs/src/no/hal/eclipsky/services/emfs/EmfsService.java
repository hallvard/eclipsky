package no.hal.eclipsky.services.emfs;

import java.util.Collection;

import no.hal.emfs.EmfsResource;

import org.eclipse.core.runtime.IProgressMonitor;

public interface EmfsService {

	public void importResources(Collection<EmfsResource> emfsResources, String projectName, boolean overwrite, IProgressMonitor monitor) throws Exception;
}
