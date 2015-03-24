package no.hal.eclipsky.services.emfs.impl;

import java.util.Collection;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;

import no.hal.eclipsky.services.emfs.EmfsService;
import no.hal.emfs.EmfsResource;
import no.hal.emfs.util.CompositeImportSupport;
import no.hal.emfs.util.ImportHelper;
import no.hal.emfs.util.ImportHelperOptions;
import no.hal.emfs.util.ImportSupport;
import no.hal.emfs.xtext.XemfsStandaloneSetup;

public class EmfsServiceImpl implements EmfsService {
	
	public EmfsServiceImpl() {
		XemfsStandaloneSetup.doSetup();
	}
	
	private CompositeImportSupport importSupports = new CompositeImportSupport();
	
	public synchronized void addImportSupport(ImportSupport importSupport) {
		importSupports.addImportSupport(importSupport);
	}

	public synchronized void removeImportSupport(ImportSupport importSupport) {
		importSupports.removeImportSupport(importSupport);
	}

	@Override
	public void importResources(Collection<EmfsResource> emfsResources, String projectName, ImportHelperOptions options, IProgressMonitor monitor) throws Exception {
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
		ImportHelper importHelper = new ImportHelper();
		importHelper.set(options);
		importHelper.importSupport = importSupports;
		importHelper.importResources(emfsResources, project, monitor);
	}
}
