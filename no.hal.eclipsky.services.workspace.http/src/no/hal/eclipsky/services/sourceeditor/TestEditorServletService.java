package no.hal.eclipsky.services.sourceeditor;

import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import no.hal.eclipsky.services.common.ProjectRef;
import no.hal.eclipsky.services.editor.RunResult;
import no.hal.eclipsky.services.sourceeditor.SourceEditorServlet.EditorServiceRequest;
import no.hal.eclipsky.services.workspace.http.SourceProjectManager;
import no.hal.eclipsky.services.workspace.http.util.EmfsUtil;
import no.hal.emfs.EmfsResource;

@Component(
	immediate = true,
	property = AbstractSourceEditorServletService.OPERATION_KEY + "=test"
)
public class TestEditorServletService extends RunEditorServletService implements SourceEditorServletService {

	@Reference
	@Override
	public synchronized void setSourceProjectManager(SourceProjectManager sourceProjectManager) {
		super.setSourceProjectManager(sourceProjectManager);
	}
	public synchronized void unsetSourceProjectManager(SourceProjectManager sourceProjectManager) {
		super.unsetSourceProjectManager(sourceProjectManager);
	}

	@Activate
	@Override
	protected void activate(ComponentContext context) {
		super.activate(context);
	}

	@Override
	public String doSourceEditorServletService(EditorServiceRequest request, String requestBody) {
		EmfsResource emfsResource = EmfsUtil.findEmfsResource(getSourceProjectManager().getEmfsResource(new ProjectRef(request.resourceRef)), EmfsUtil::isTestable);
		if (emfsResource != null) {
			RunResult result = getSourceProject(request).test(EmfsUtil.createResourceRef(emfsResource));
			return runResponse(result, request.responseFormat);
		}
		return null;
	}
}
