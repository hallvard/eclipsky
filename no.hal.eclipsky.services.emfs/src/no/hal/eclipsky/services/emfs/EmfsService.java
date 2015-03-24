package no.hal.eclipsky.services.emfs;

import java.util.Collection;

import no.hal.emfs.EmfsResource;
import no.hal.emfs.util.ImportHelperOptions;

import org.eclipse.core.runtime.IProgressMonitor;

public interface EmfsService {

	public void importResources(Collection<EmfsResource> emfsResources, String projectName, ImportHelperOptions options, IProgressMonitor monitor) throws Exception;
}
