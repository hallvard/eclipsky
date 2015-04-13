package no.hal.eclipsky.services.emfs.impl;

import java.util.ArrayList;
import java.util.Collection;

import no.hal.eclipsky.services.emfs.EmfsService;
import no.hal.emfs.EmfsFile;
import no.hal.emfs.EmfsResource;
import no.hal.emfs.util.CompositeImportSupport;
import no.hal.emfs.util.ImportHelper;
import no.hal.emfs.util.ImportHelperOptions;
import no.hal.emfs.util.ImportSupport;
import no.hal.emfs.xtext.XemfsStandaloneSetup;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;

@Component
public class EmfsServiceImpl implements EmfsService {
	
	public EmfsServiceImpl() {
		XemfsStandaloneSetup.doSetup();
	}
	
	private CompositeImportSupport importSupports = new CompositeImportSupport();
	
	@Reference(
		cardinality=ReferenceCardinality.MULTIPLE,
		policy=ReferencePolicy.DYNAMIC,
		unbind="removeImportSupport"
	)
	public synchronized void addImportSupport(ImportSupport importSupport) {
		importSupports.addImportSupport(importSupport);
	}

	public synchronized void removeImportSupport(ImportSupport importSupport) {
		importSupports.removeImportSupport(importSupport);
	}

	@Override
	public Collection<EmfsResource> importResources(Collection<EmfsResource> emfsResources, String projectName, ImportHelperOptions options, IProgressMonitor monitor) throws Exception {
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
		final Collection<EmfsResource> importedResources = new ArrayList<EmfsResource>();
		ImportHelper importHelper = new ImportHelper() {
			@Override
			protected void ensureFile(EmfsFile emfsFile, IFile file, IContainer target, IProgressMonitor monitor) throws Exception {
				super.ensureFile(emfsFile, file, target, monitor);
				importedResources.add(emfsFile);
			}
		};
		importHelper.set(options);
		importHelper.importSupport = importSupports;
		importHelper.importResources(emfsResources, project, monitor);
		return importedResources;
	}
}
