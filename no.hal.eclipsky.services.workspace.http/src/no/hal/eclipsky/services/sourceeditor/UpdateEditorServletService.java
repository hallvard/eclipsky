package no.hal.eclipsky.services.sourceeditor;

import no.hal.eclipsky.services.common.SourceFileMarker;
import no.hal.eclipsky.services.sourceeditor.SourceEditorServlet.EditorServiceRequest;
import no.hal.eclipsky.services.workspace.http.util.EmfsUtil;
import no.hal.emfs.EmfsFile;
import no.hal.emfs.EmfsResource;
import no.hal.emfs.StringContentProvider;
import no.hal.emfs.util.PropertyResolver;

public class UpdateEditorServletService extends AbstractSourceEditorServletService {

	protected Boolean markersDefault = true;

	private PropertyResolver propertyResolver;
	
	@Override
	public String doSourceEditorServletService(EditorServiceRequest request, String requestBody) {
		EmfsResource emfsResource = EmfsUtil.getEmfsResource(getSourceProjectManager().getEmfs(request.resourceRef), request.resourceRef);
		if (emfsResource instanceof EmfsFile) {
			EmfsFile emfsFile = (EmfsFile) emfsResource;
			if (emfsFile.getContentProvider() instanceof StringContentProvider) {
				Object editableFragmenProperty = propertyResolver.getProperty(emfsFile, "editableFragment");
				if (editableFragmenProperty != null) {
					// update fragment instead
				}
			}
		}
		SourceFileMarker[] sourceFileMarkers = getSourceEditor(request).update(requestBody, markersDefault, false);
		return MarkersEditorServletService.markersResponse(sourceFileMarkers, request.responseFormat);
	}
}
