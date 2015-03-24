package no.hal.eclipsky.services.sourceeditor;

import java.util.Dictionary;

import no.hal.eclipsky.services.editor.SourceEditor;
import no.hal.eclipsky.services.editor.SourceProject;
import no.hal.eclipsky.services.workspace.http.SourceProjectManager;

import org.osgi.service.component.ComponentContext;

public abstract class AbstractSourceEditorServletService implements SourceEditorServletService {

	private SourceProjectManager sourceProjectManager;

	public SourceProjectManager getSourceProjectManager() {
		return sourceProjectManager;
	}
	
	public synchronized void setSourceProjectManager(SourceProjectManager sourceProjectManager) {
		this.sourceProjectManager = sourceProjectManager;
	}

	public final static String OPERATION_KEY = "operations";

	private String[] supportedOperations = {};
	
	protected void activate(ComponentContext context) {
		Dictionary<String, Object> properties = context.getProperties();
		Object operationsValue = (properties != null ? properties.get(OPERATION_KEY) : null);
		if (operationsValue != null) {
			supportedOperations = String.valueOf(operationsValue).split(",");
		}
	}

	@Override
	public String[] getSupportedOperations() {
		return supportedOperations;
	}
	
	protected SourceProject getSourceProject(SourceEditorServlet.EditorServiceRequest request) {
		return getSourceProjectManager().getSourceProject(request.resourceRef);
	}

	protected SourceEditor getSourceEditor(SourceEditorServlet.EditorServiceRequest request) {
		return getSourceProject(request).getSourceEditor(request.resourceRef);
	}
}
