package no.hal.eclipsky.services.workspace.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import no.hal.eclipsky.services.common.AbstractResourcesServiceImpl;
import no.hal.eclipsky.services.common.ResourceHelper;
import no.hal.eclipsky.services.common.ResourceRef;
import no.hal.eclipsky.services.workspace.model.SourceFileMarker;
import no.hal.eclipsky.services.workspace.ProjectService;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.osgi.service.component.annotations.Component;

@Component(
	service=ProjectService.class
)
public class ProjectServiceImpl extends AbstractResourcesServiceImpl implements ProjectService, IResourceChangeListener, IResourceDeltaVisitor {

	protected String[] getSourceFolderNames() {
		return ResourceHelper.SOURCE_FOLDER_NAMES;
	}
	
	protected String getSourceFile(String projectName, String packageName, String resourceName) {
		IFile file = getFile(projectName, packageName, resourceName, true, getSourceFolderNames());
		return (file != null ? getFileStringContent(file).toString() : null);
	}

	@Override
	public String getSourceFile(ResourceRef resourceRef) {
		return getSourceFile(resourceRef.getProjectName(), resourceRef.getPackageName(), resourceRef.getResourceName());
	}

	protected SourceFileMarker[] getSourceFileMarkers(String projectName, String packageName, String resourceName, boolean build) {
		IFile file = getFile(projectName, packageName, resourceName, true, getSourceFolderNames());
		if (build) {
		}
		return createSourceFileMarkers(file);
	}

	@Override
	public SourceFileMarker[] getSourceFileMarkers(ResourceRef resourceRef, boolean build) {
		return getSourceFileMarkers(resourceRef.getProjectName(), resourceRef.getPackageName(), resourceRef.getResourceName(),
				build);
	}

	protected SourceFileMarker[] updateSourceFile(String projectName, String packageName, String resourceName, String stringContent, Boolean exists, Boolean markers) {
		IFile file = getFile(projectName, packageName, resourceName, exists, getSourceFolderNames());
		Future<SourceFileMarker[]> future = null;
		if (Boolean.TRUE.equals(markers)) {
			future = ensureResourceFuture(file);
		}
		setFileStringContent(file, stringContent);
		if (markers == null) {
			return null;
		} else {
			if (future != null) {
				try {
					SourceFileMarker[] sourceFileMarkers = future.get();
					return sourceFileMarkers;
				} catch (Exception e) {
				}
			}
			return createSourceFileMarkers(file);
		}
	}

	public SourceFileMarker[] updateSourceFile(ResourceRef resourceRef, String stringContent, Boolean exists, Boolean markers) {
		return updateSourceFile(resourceRef.getProjectName(), resourceRef.getPackageName(), resourceRef.getResourceName(),
				stringContent, exists, markers);
	}
	
	protected byte[] getResource(String projectName, String packageName, String resourceName) {
		IFile file = getFile(projectName, packageName, resourceName, true, getSourceFolderNames());
		return (file != null ? getFileBytesContent(file) : null);
	}

	@Override
	public byte[] getResource(ResourceRef resourceRef) {
		return getResource(resourceRef.getProjectName(), resourceRef.getPackageName(), resourceRef.getResourceName());
	}

	//

	private Map<IResource, CompletableFuture<SourceFileMarker[]>> resourceMarkers;
	
	private Future<SourceFileMarker[]> ensureResourceFuture(IFile file) {
		if (resourceMarkers == null) {
			resourceMarkers = new HashMap<IResource, CompletableFuture<SourceFileMarker[]>>();
			ResourcesPlugin.getWorkspace().addResourceChangeListener(this, IResourceChangeEvent.POST_BUILD);
		}
		CompletableFuture<SourceFileMarker[]> future = resourceMarkers.get(file);
		if (future == null) {
			future = new CompletableFuture<SourceFileMarker[]>();
			resourceMarkers.put(file, future);
		}
		return future;
	}

	@Override
	public void resourceChanged(IResourceChangeEvent event) {
		IResource resource = event.getResource();
		if (! handleChangedResource(resource)) {
			IResourceDelta delta = event.getDelta();
			if (delta != null) {
				try {
					delta.accept(this);
				} catch (CoreException e) {
				}
			}
		}
	}

	@Override
	public boolean visit(IResourceDelta delta) throws CoreException {
		IResource resource = delta.getResource();
		if (handleChangedResource(resource)) {
		}
		return true;
	}

	protected boolean handleChangedResource(IResource resource) {
		if (resourceMarkers != null && resourceMarkers.containsKey(resource)) {
			CompletableFuture<SourceFileMarker[]> future = resourceMarkers.get(resource);
			resourceMarkers.remove(resource);
			if (resourceMarkers.isEmpty()) {
				resourceMarkers = null;
				ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);
			}
			if (future.complete(createSourceFileMarkers(resource))) {
			}
			return true;
		}
		return false;
	}
}
