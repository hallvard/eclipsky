package no.hal.eclipsky.services.workspace.impl;

import java.util.concurrent.CompletableFuture;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import no.hal.eclipsky.services.common.CharacterPosition;
import no.hal.eclipsky.services.common.ResourceRef;
import no.hal.eclipsky.services.editor.SourceEditor;
import no.hal.eclipsky.services.editor.SourceProject;
import no.hal.eclipsky.services.workspace.IServiceExecutor;
import no.hal.eclipsky.services.workspace.SourceProjectManager;
import no.hal.eclipsky.services.workspace.WorkspaceService;
import no.hal.eclipsky.services.workspace.model.CloseEditorService;
import no.hal.eclipsky.services.workspace.model.CompletionEditorService;
import no.hal.eclipsky.services.workspace.model.CompletionProposal;
import no.hal.eclipsky.services.workspace.model.MarkersEditorService;
import no.hal.eclipsky.services.workspace.model.ModelFactory;
import no.hal.eclipsky.services.workspace.model.RefreshEditorService;
import no.hal.eclipsky.services.workspace.model.ResourceInfo;
import no.hal.eclipsky.services.workspace.model.ResourceResponseOptions;
import no.hal.eclipsky.services.workspace.model.ResultKind;
import no.hal.eclipsky.services.workspace.model.SourceFileMarker;
import no.hal.eclipsky.services.workspace.model.UpdateEditorService;
import no.hal.emfs.AbstractStringContentProvider;
import no.hal.emfs.AbstractStringContents;
import no.hal.emfs.EmfsFactory;
import no.hal.emfs.EmfsFile;
import no.hal.emfs.EmfsResource;
import no.hal.emfs.StringContentProvider;

@Component(
	immediate=true,
	property="services=RefreshEditorService UpdateEditorService CloseEditorService MarkersEditorService CompletionEditorService"
)
public class SourceEditorServiceExecutor extends AbstractServiceExecutor implements IServiceExecutor {

	@Reference
	public synchronized void setWorkspaceService(WorkspaceService workspaceService) {
		super.setWorkspaceService(workspaceService);
	}
	public synchronized void unsetWorkspaceService(WorkspaceService workspaceService) {
		super.setWorkspaceService(null);
	}
	
	@Reference
	public synchronized void setSourceProjectManager(SourceProjectManager sourceProjectManager) {
		super.setSourceProjectManager(sourceProjectManager);
	}
	public synchronized void unsetSourceProjectManager(SourceProjectManager sourceProjectManager) {
		super.setSourceProjectManager(null);
	}

	@Activate
	protected void activate(ComponentContext context) {
		registerServiceFactory(context);
	}

	//
	
	@Override
	public ResultKind caseRefreshEditorService(RefreshEditorService service) {
		EmfsResource emfsResource = getSourceProjectManager().getEmfsResource(service.getResourceRef());
		AbstractStringContents editableStringContents = null;
		if (emfsResource instanceof EmfsFile) {
			EmfsFile emfsFile = (EmfsFile) emfsResource;
			editableStringContents = EmfsUtil.findStringContents(emfsFile, AbstractStringContents::isWriteable);
		}
		SourceProject sourceProject = getSourceProjectManager().getSourceProject(service.getResourceRef());
		SourceEditor sourceEditor = sourceProject.getSourceEditor(service.getResourceRef());
		CharSequence stringContents = null;
		if (editableStringContents != null) {
			stringContents = editableStringContents.getStringContent();
		} else {
			stringContents = sourceEditor.getWorkingCopyContents();
		}
		StringContentProvider contentProvider = EmfsFactory.eINSTANCE.createStringContentProvider();
		contentProvider.setStringContent(stringContents.toString());
		ResourceInfo resourceInfo = ModelFactory.eINSTANCE.createResourceInfo();
		resourceInfo.setResourceRef(service.getResourceRef());
		resourceInfo.setContents(contentProvider);
		service.setResource(resourceInfo);
		return ResultKind.SUCCESS;
	}
	
	protected Boolean markersDefault = true;

	@Override
	public ResultKind caseUpdateEditorService(UpdateEditorService service) {
		EmfsResource emfsResource = getSourceProjectManager().getEmfsResource(service.getResourceRef());
		AbstractStringContents editableStringContents = null;
		if (emfsResource instanceof EmfsFile) {
			EmfsFile emfsFile = (EmfsFile) emfsResource;
			editableStringContents = EmfsUtil.findStringContents(emfsFile, AbstractStringContents::isWriteable);
		}
		SourceProject sourceProject = getSourceProjectManager().getSourceProject(service.getResourceRef());
		SourceEditor sourceEditor = sourceProject.getSourceEditor(service.getResourceRef());
		String stringContents = service.getContents().getStringContent();
		if (editableStringContents != null) {
			editableStringContents.setStringContent(stringContents);
			stringContents = ((StringContentProvider) ((EmfsFile) emfsResource).getContentProvider()).getStringContent();
		}
		updateEditor(service, sourceEditor, stringContents);
		return ResultKind.SUCCESS;
	}
	
	@Override
	public ResultKind caseMarkersEditorService(MarkersEditorService service) {
		SourceProject sourceProject = getSourceProjectManager().getSourceProject(service.getResourceRef());
		SourceEditor sourceEditor = sourceProject.getSourceEditor(service.getResourceRef());
		updateEditor(service, sourceEditor, null);
		return ResultKind.SUCCESS;
	}

	private void updateEditor(MarkersEditorService service, SourceEditor sourceEditor, String stringContents) {
		SourceFileMarker[] markers = sourceEditor.update(stringContents, true, null);
		CharacterPosition offset = computeResourceOffset(getSourceProjectManager().getEmfsResource(service.getResourceRef()));
		ResourceInfo resourceInfo = ModelFactory.eINSTANCE.createResourceInfo();
		resourceInfo.setResourceRef(service.getResourceRef());
		for (int i = 0; i < markers.length; i++) {
			SourceFileMarker marker = markers[i];
			if (offset != null) {
				marker.setLineNumber(marker.getLineNumber() - offset.getLineNumber());
				marker.setStart(marker.getStart() - offset.getPosition());
				marker.setEnd(marker.getEnd() - offset.getPosition());
			}
			resourceInfo.getMarkers().add(marker);
		}
		service.setMarkers(resourceInfo);
	}

	@Override
	public ResultKind caseCloseEditorService(CloseEditorService service) {
		SourceProject sourceProject = getSourceProjectManager().getSourceProject(service.getResourceRef());
		SourceEditor sourceEditor = sourceProject.getSourceEditor(service.getResourceRef());
		CompletableFuture<Boolean> future = new CompletableFuture<Boolean>();
		sourceEditor.close(new NullProgressMonitor() {
			@Override
			public void done() {
				future.complete(! isCanceled());
			}
		});
		try {
			if (future.get()) {
				return ResultKind.SUCCESS;
			}
		} catch (Exception e) {
			return ResultKind.ERROR;
		}
		return ResultKind.FAILURE;
	}

	private void updateResourceInfo(ResourceRef resourceRef, ResourceResponseOptions options, ResourceInfo resourceInfo) {
		resourceInfo.setResourceRef(resourceRef);
		SourceProject sourceProject = getSourceProjectManager().getSourceProject(resourceRef);
		SourceEditor sourceEditor = sourceProject.getSourceEditor(resourceRef);
		if (options.isIncludeContents()) {
			EmfsResource emfsResource = getSourceProjectManager().getEmfsResource(resourceRef);
			AbstractStringContents editableStringContents = null;
			if (emfsResource instanceof EmfsFile) {
				EmfsFile emfsFile = (EmfsFile) emfsResource;
				editableStringContents = EmfsUtil.findStringContents(emfsFile, AbstractStringContents::isWriteable);
			}
			CharSequence stringContents = null;
			if (editableStringContents != null) {
				stringContents = editableStringContents.getStringContent();
			} else {
				stringContents = sourceEditor.getWorkingCopyContents();
			}
			StringContentProvider contentProvider = EmfsFactory.eINSTANCE.createStringContentProvider();
			contentProvider.setStringContent(stringContents.toString());
			resourceInfo.setContents(contentProvider);
		}
		if (options.isIncludeMarkers()) {
			SourceFileMarker[] markers = sourceEditor.update(null, true, null);
			CharacterPosition offset = computeResourceOffset(getSourceProjectManager().getEmfsResource(resourceRef));
			resourceInfo.setResourceRef(resourceRef);
			for (int i = 0; i < markers.length; i++) {
				SourceFileMarker marker = markers[i];
				if (offset != null) {
					marker.setLineNumber(marker.getLineNumber() - offset.getLineNumber());
					marker.setStart(marker.getStart() - offset.getPosition());
					marker.setEnd(marker.getEnd() - offset.getPosition());
				}
				resourceInfo.getMarkers().add(marker);
			}
		}
	}
	
	protected CharacterPosition computeResourceOffset(EmfsResource emfsResource) {
		CharacterPosition offset = null;
		if (emfsResource instanceof EmfsFile) {
			EmfsFile emfsFile = (EmfsFile) emfsResource;
			AbstractStringContents editableStringContents = EmfsUtil.findStringContents(emfsFile, AbstractStringContents::isWriteable);
			if (editableStringContents != null && emfsFile.getContentProvider() instanceof AbstractStringContentProvider) {
				offset = new CharacterPosition();
				((AbstractStringContentProvider) emfsFile.getContentProvider()).accumulate(new CharacterPosition.Accumulator(editableStringContents), offset);
			}
		}
		return offset;
	}

	@Override
	public ResultKind caseCompletionEditorService(CompletionEditorService service) {
		SourceProject sourceProject = getSourceProjectManager().getSourceProject(service.getResourceRef());
		SourceEditor sourceEditor = sourceProject.getSourceEditor(service.getResourceRef());
		int position = service.getPosition();
		CharacterPosition offset = computeResourceOffset(getSourceProjectManager().getEmfsResource(service.getResourceRef()));
		if (offset != null) {
			position += offset.getPosition();
		}
		CompletionProposal[] completions = sourceEditor.complete(position);
		for (int i = 0; i < completions.length; i++) {
			service.getProposals().add(completions[i]);
		}
		return ResultKind.SUCCESS;
	}
}
