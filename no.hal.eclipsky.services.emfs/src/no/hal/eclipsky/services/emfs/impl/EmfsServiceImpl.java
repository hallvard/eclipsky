package no.hal.eclipsky.services.emfs.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;

import no.hal.eclipsky.services.emfs.EmfsService;
import no.hal.emfs.EmfsResource;
import no.hal.emfs.exporter.ExportSupport;
import no.hal.emfs.exporter.Exporter;
import no.hal.emfs.sync.ExportRule;
import no.hal.emfs.sync.ExportSpec;
import no.hal.emfs.sync.RelativePath;
import no.hal.emfs.sync.SyncFactory;
import no.hal.emfs.util.AbstractPorter.Listener;
import no.hal.emfs.util.CompositeExportSupport;
import no.hal.emfs.xtext.XemfsStandaloneSetup;

@Component
public class EmfsServiceImpl implements EmfsService {
	
	public EmfsServiceImpl() {
		XemfsStandaloneSetup.doSetup();
	}
	
	private CompositeExportSupport exportSupports = new CompositeExportSupport();
	
	@Reference(
		cardinality=ReferenceCardinality.MULTIPLE,
		policy=ReferencePolicy.DYNAMIC,
		unbind="removeImportSupport"
	)

	public synchronized void addExportSupport(ExportSupport importSupport) {
		exportSupports.addExportSupport(importSupport);
	}
	public synchronized void removeExportSupport(ExportSupport importSupport) {
		exportSupports.removeImportSupport(importSupport);
	}

	@Override
	public Collection<EmfsResource> exportResources(Collection<EmfsResource> emfsResources, String projectName, IProgressMonitor monitor) throws Exception {
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
		ExportSpec exportSpec = SyncFactory.eINSTANCE.createExportSpec();
		ExportRule rule = SyncFactory.eINSTANCE.createExportRule();
		rule.setPath(createRulePath(""));
//		rule.setTargetPath(createRulePath(projectName));
		exportSpec.getRules().add(rule);
		Exporter exporter = new Exporter(exportSpec);
		exporter.setRootContainer(project);
		final Collection<EmfsResource> exportedResources = new ArrayList<EmfsResource>();
		exporter.addListener(new Listener() {
			@Override
			public void resourceHandled(EmfsResource emfsResource, IResource resource, int what) {
				if ((what & Listener.EXPORTED) > 0) {
					exportedResources.add(emfsResource);
				}
			}
		});
		exporter.exportResources(emfsResources, monitor);
		return exportedResources;
	}

	private RelativePath createRulePath(String pathString) {
		RelativePath path = SyncFactory.eINSTANCE.createRelativePath();
		path.getSegments().add(pathString);
		return path;
	}
}
