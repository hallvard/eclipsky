package no.hal.eclipsky.services.sourceeditor;

import no.hal.eclipsky.services.common.SourceFileMarker;
import no.hal.eclipsky.services.sourceeditor.SourceEditorServlet.EditorServiceRequest;

public class UpdateEditorServletService extends AbstractSourceEditorServletService {

	protected Boolean markersDefault = true;

	@Override
	public String doSourceEditorServletService(EditorServiceRequest request, String requestBody) {
		SourceFileMarker[] sourceFileMarkers = getSourceEditor(request).update(requestBody, markersDefault, false);
		return MarkersEditorServletService.markersResponse(sourceFileMarkers, request.responseFormat);
	}
}
