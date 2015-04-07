package no.hal.eclipsky.services.workspace.http;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import no.hal.eclipsky.services.common.ProjectRef;
import no.hal.eclipsky.services.common.ResourceRef;
import no.hal.eclipsky.services.editor.SourceProject;
import no.hal.eclipsky.services.editor.impl.JavaSourceProject;
import no.hal.eclipsky.services.emfs.EmfsService;
import no.hal.eclipsky.services.workspace.WorkspaceService;
import no.hal.eclipsky.services.workspace.http.util.EmfsUtil;
import no.hal.emfs.EmfsFile;
import no.hal.emfs.EmfsResource;
import no.hal.emfs.util.ImportHelperOptions;

@Component
public class SourceProjectManagerImpl implements SourceProjectManager {

	private ImportHelperOptions importHelperOptions;
	
	public SourceProjectManagerImpl() {
		importHelperOptions = new ImportHelperOptions();
		importHelperOptions.overwrite = true;
		importHelperOptions.createEmptyWriteable = true;
	}
	
	private WorkspaceService workspaceService;

	@Reference
	public synchronized void setWorkspaceService(WorkspaceService workspaceService) {
		this.workspaceService = workspaceService;
	}

	private EmfsService emfsService;
	
	@Reference
	public synchronized void setEmfsService(EmfsService emfsService) {
		this.emfsService = emfsService;
	}

	private Map<ProjectRef, SourceProject> sourceProjects = new HashMap<ProjectRef, SourceProject>();
	private Map<ProjectRef, EmfsResource> emfsResources = new HashMap<ProjectRef, EmfsResource>();
	
	@Override
	public void ensureSourceProject(ProjectRef projectRef, EmfsResource emfsResource) throws Exception {
		String projectName = projectRef.getProjectName();
		workspaceService.ensureProject(projectName);
		JavaSourceProject sourceProject = new JavaSourceProject(projectRef);
		sourceProjects.put(projectRef, sourceProject);
		if (emfsResource != null) {
			Collection<EmfsResource> importResources = emfsService.importResources(Arrays.asList(emfsResource), projectName, importHelperOptions, null);
			for (EmfsResource importedResource : importResources) {
				EmfsResource sourceFolder = EmfsUtil.getEmfsContainer(importedResource.getContainer(), EmfsUtil::isSourceFolder);
				if (sourceFolder != null) {
					String packageName = EmfsUtil.getFullName(importedResource.getContainer(), EmfsUtil::isSourceFolder, ".");
					ResourceRef resourceRef = new ResourceRef(projectRef, packageName, importedResource.getName());
					emfsResources.put(resourceRef, importedResource);
				}
			}
			emfsResources.put(projectRef, emfsResource);
			// create XMI resource
			Resource emfsModel = EmfsUtil.createEmfsResource(URI.createPlatformResourceURI("/" + projectRef.getProjectName() + "/" + projectRef.getProjectName(), true), "emfs");
			// move contents
			emfsModel.getContents().addAll(emfsResource.eResource().getContents());
			// and serialize
			try {
				emfsModel.save(null);
			} catch (Exception e) {
			}
		}
	}

	@Override
	public SourceProject getSourceProject(ProjectRef projectRef) {
		return sourceProjects.get(new ProjectRef(projectRef));
	}

	@Override
	public EmfsResource getEmfsResource(ProjectRef resourceRef) {
		return emfsResources.get(resourceRef);
	}
	
	private ResourceRef withProjectRef(ProjectRef projectRef, ResourceRef resourceRef) {
		return new ResourceRef(projectRef, resourceRef.getPackageName(), resourceRef.getResourceName());
	}

	public Collection<ResourceRef> getEditableResources(ProjectRef projectRef) {
		Collection<ResourceRef> collectedResources = EmfsUtil.collectResources(emfsResources.get(projectRef), EmfsResource::isWriteable);
		return collectedResources.stream().map(resourceRef -> withProjectRef(projectRef, resourceRef)).collect(Collectors.toList());
	}
}
