package no.hal.eclipsky.ui.console;

import no.hal.eclipsky.services.common.ResourceRef;
import no.hal.eclipsky.services.sourceeditor.SourceEditorServlet;

import org.eclipse.osgi.framework.console.CommandInterpreter;
import org.eclipse.osgi.framework.console.CommandProvider;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component
public class SourceEditorServletCommandProvider implements CommandProvider {
	
	private SourceEditorServlet sourceEditorServlet;
	
	@Reference
	public synchronized void setSourceEditorServlet(SourceEditorServlet sourceEditorServlet) {
		this.sourceEditorServlet = sourceEditorServlet;
	}

	public void _sec(CommandInterpreter ci) {
		String op = ci.nextArgument();
		if (op == null) {
			syntaxError(ci, "There must be an operation argument");
			return;
		}
		String resourceRefArg = ci.nextArgument();
		if (resourceRefArg == null) {
			syntaxError(ci, "There must be a resource argument");
			return;
		}
		ResourceRef resourceRef = ResourceRef.valueOf(resourceRefArg);
		SourceEditorServlet.EditorServiceRequest editorServiceRequest = new SourceEditorServlet.EditorServiceRequest(op, resourceRef, "json");
		try {
			CharSequence response = sourceEditorServlet.invokeEditorServiceOperation(editorServiceRequest, ci.nextArgument());
			ci.print(response);
		} catch (Exception e) {
			ci.printStackTrace(e);
		}
    }

	protected void syntaxError(CommandInterpreter ci, String message) {
		ci.println(message);
		ci.println(getHelp());
	}

	@Override
	public String getHelp() {
		return "Syntax: sec <operation> <resources> <body>";
	}
}
