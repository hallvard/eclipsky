package no.hal.eclipsky.services.workspace.http;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
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
import no.hal.emfs.EmfsPackage;
import no.hal.emfs.EmfsResource;
import no.hal.emfs.exporter.Exporter;
import no.hal.emfs.importer.Importer;

@Component
public class SourceProjectManagerImpl implements SourceProjectManager {

	private Exporter exporter;
	
	public SourceProjectManagerImpl() {
		exporter = new Exporter(null);
	}
	
	private WorkspaceService workspaceService;

	@Reference
	public synchronized void setWorkspaceService(WorkspaceService workspaceService) {
		this.workspaceService = workspaceService;
	}
	public synchronized void unsetWorkspaceService(WorkspaceService workspaceService) {
		setWorkspaceService(null);
	}

	private EmfsService emfsService;
	
	@Reference
	public synchronized void setEmfsService(EmfsService emfsService) {
		this.emfsService = emfsService;
	}
	public synchronized void unsetEmfsService(EmfsService emfsService) {
		setEmfsService(null);
	}

	private Map<ProjectRef, SourceProject> sourceProjects = new HashMap<ProjectRef, SourceProject>();
	private Map<ProjectRef, EmfsResource> emfsResources = new HashMap<ProjectRef, EmfsResource>();
	
	@Override
	public void ensureSourceProject(ProjectRef projectRef, EmfsResource emfsResource) throws Exception {
		String projectName = projectRef.getProjectName();
		workspaceService.ensureProject(projectName);
		SourceProject sourceProject = new JavaSourceProject(projectRef);
		sourceProjects.put(projectRef, sourceProject);
		if (emfsResource != null) {
			emfsResources.put(projectRef, emfsResource);
			Collection<EmfsResource> importResources = emfsService.exportResources(Arrays.asList(emfsResource), projectName, null);
			registerEmfsSourceResources(importResources.iterator(), projectRef);
			// create XMI resource
			Resource emfsModel = EmfsUtil.createEmfsResource(createProjectEmfsUri(projectName), "emfs");
			// move contents
			emfsModel.getContents().addAll(emfsResource.eResource().getContents());
			// and serialize
			try {
				emfsModel.save(null);
			} catch (Exception e) {
			}
		}
	}

	private void registerEmfsSourceResources(Iterator<? extends EObject> iterator, ProjectRef projectRef) {
		while (iterator.hasNext()) {
			EObject next = iterator.next();
			if (next instanceof EmfsFile) {
				EmfsFile emfsFile = (EmfsFile) next;
				EmfsResource sourceFolder = EmfsUtil.getEmfsContainer(emfsFile.getContainer(), EmfsUtil::isSourceFolder);
				if (sourceFolder != null) {
					String packageName = EmfsUtil.getFullName(emfsFile.getContainer(), EmfsUtil::isSourceFolder, ".");
					ResourceRef resourceRef = new ResourceRef(projectRef, packageName, emfsFile.getName());
					emfsResources.put(resourceRef, emfsFile);
				}
			} else if (next instanceof EmfsResource);
			else if (iterator instanceof TreeIterator<?>) {
				((TreeIterator<?>) iterator).prune();
			}
		}
	}
	
	private URI createProjectEmfsUri(String projectName) {
		return URI.createPlatformResourceURI("/" + projectName + "/" + projectName, true);
	}

	private boolean autoEnsureProject = true;
	
	@Override
	public SourceProject getSourceProject(ProjectRef projectRef) {
		projectRef = new ProjectRef(projectRef.getProjectName());
		SourceProject sourceProject = sourceProjects.get(projectRef);
		if (sourceProject == null && autoEnsureProject) {
			sourceProject = ensureProject(projectRef);
		}
		return sourceProject;
	}

	protected SourceProject ensureProject(ProjectRef projectRef) {
		Resource emfsModel = EmfsUtil.createEmfsResource(createProjectEmfsUri(projectRef.getProjectName()), "emfs");
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResources().add(emfsModel);
		try {
			emfsModel.load(null);
			EmfsResource emfsResource = (EmfsResource) EcoreUtil.getObjectByType(emfsModel.getContents(), EmfsPackage.eINSTANCE.getEmfsResource());
			if (emfsResource != null) {
				SourceProject sourceProject = new JavaSourceProject(projectRef);
				sourceProjects.put(projectRef, sourceProject);
				emfsResources.put(projectRef, emfsResource);
				registerEmfsSourceResources(emfsResource.eAllContents(), projectRef);
				return sourceProject;
			}
		} catch (IOException e1) {
		}
		return null;
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
