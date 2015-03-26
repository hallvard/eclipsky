package no.hal.eclipsky.services.sourceeditor;

import no.hal.eclipsky.services.editor.RunResult;
import no.hal.eclipsky.services.sourceeditor.SourceEditorServlet.EditorServiceRequest;
import no.hal.eclipsky.services.workspace.http.util.EmfsUtil;
import no.hal.emfs.EmfsResource;

public class TestEditorServletService extends RunEditorServletService {

	@Override
	public String doSourceEditorServletService(EditorServiceRequest request, String requestBody) {
		EmfsResource emfsResource = EmfsUtil.findEmfsResource(getSourceProjectManager().getEmfs(request.resourceRef), EmfsUtil::isTestable);
		if (emfsResource != null) {
			RunResult result = getSourceProject(request).test(EmfsUtil.createResourceRef(emfsResource));
			return runResponse(result, request.responseFormat);
		}
		return null;
	}
}
