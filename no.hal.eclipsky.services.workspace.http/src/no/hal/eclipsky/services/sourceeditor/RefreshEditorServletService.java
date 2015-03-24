package no.hal.eclipsky.services.sourceeditor;

import no.hal.eclipsky.services.sourceeditor.SourceEditorServlet.EditorServiceRequest;

public class RefreshEditorServletService extends AbstractSourceEditorServletService {

	@Override
	public CharSequence doSourceEditorServletService(EditorServiceRequest request, String requestBody) {
		return getSourceEditor(request).getSourceFileContents();
	}
}
