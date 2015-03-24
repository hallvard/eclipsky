package no.hal.eclipsky.services.workspace.http;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

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

public class SourceProjectManagerImpl implements SourceProjectManager {

	private ImportHelperOptions importHelperOptions;
	
	public SourceProjectManagerImpl() {
		importHelperOptions = new ImportHelperOptions();
		importHelperOptions.overwrite = true;
		importHelperOptions.createEmptyWriteable = true;
	}
	
	private WorkspaceService workspaceService;

	public synchronized void setWorkspaceService(WorkspaceService workspaceService) {
		this.workspaceService = workspaceService;
	}

	private EmfsService emfsService;
	
	public synchronized void setEmfsService(EmfsService emfsService) {
		this.emfsService = emfsService;
	}

	private Map<ProjectRef, SourceProject> sourceProjects = new HashMap<ProjectRef, SourceProject>();
	private Map<ProjectRef, EmfsResource> emfsModels = new HashMap<ProjectRef, EmfsResource>();
	
	
	@Override
	public void ensureSourceProject(ProjectRef projectRef, EmfsResource emfsResource) throws Exception {
		String projectName = projectRef.getProjectName();
		workspaceService.ensureProject(projectName);
		JavaSourceProject sourceProject = new JavaSourceProject(projectRef);
		sourceProjects.put(projectRef, sourceProject);
		if (emfsResource != null) {
			emfsService.importResources(Arrays.asList(emfsResource), projectName, importHelperOptions, null);
			emfsModels.put(projectRef, emfsResource);
			Collection<ResourceRef> editableResources = getEditableResources(projectRef);
			sourceProject.setEditable(editableResources.toArray(new ResourceRef[editableResources.size()]));
			Collection<ResourceRef> runnables = getRunnableResources(projectRef);
			sourceProject.setRunnable(runnables.size() > 0 ? runnables.iterator().next() : null);
			Collection<ResourceRef> testables = getTestableResources(projectRef);
			sourceProject.setTestable(testables.size() > 0 ? testables.iterator().next() : null);
		}
	}

	@Override
	public SourceProject getSourceProject(ProjectRef projectRef) {
		return sourceProjects.get(new ProjectRef(projectRef));
	}
	
	private ResourceRef withProjectRef(ProjectRef projectRef, ResourceRef resourceRef) {
		return new ResourceRef(projectRef, resourceRef.getPackageName(), resourceRef.getResourceName());
	}

	private Collection<ResourceRef> withProjectRef(ProjectRef projectRef, Collection<ResourceRef> resourceRefs) {
		return resourceRefs.stream().map(resourceRef -> withProjectRef(projectRef, resourceRef)).collect(Collectors.toList());
	}

	public Collection<ResourceRef> getEditableResources(ProjectRef projectRef) {
		return withProjectRef(projectRef, EmfsUtil.collectResources(emfsModels.get(projectRef), EmfsResource::isWriteable));
	}

	private Collection<ResourceRef> getRunnableResources(ProjectRef projectRef) {
		return withProjectRef(projectRef, EmfsUtil.collectResources(emfsModels.get(projectRef), emfsResource -> emfsResource instanceof EmfsFile && EmfsUtil.hasTags(emfsResource, "java", "application")));
	}
	
	private Collection<ResourceRef> getTestableResources(ProjectRef projectRef) {
		return withProjectRef(projectRef, EmfsUtil.collectResources(emfsModels.get(projectRef), EmfsUtil::isTestable));
	}
}
