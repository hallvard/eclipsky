package no.hal.eclipsky.services.sourceeditor;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;

import no.hal.eclipsky.services.common.SourceFileMarker;
import no.hal.eclipsky.services.editor.SourceEditor;
import no.hal.eclipsky.services.sourceeditor.SourceEditorServlet.EditorServiceRequest;
import no.hal.eclipsky.services.workspace.http.AbstractServiceServlet;
import no.hal.eclipsky.services.workspace.http.SourceProjectManager;
import no.hal.eclipsky.services.workspace.http.util.EmfsUtil;
import no.hal.eclipsky.services.workspace.http.util.ResponseFormatter;
import no.hal.emfs.AbstractStringContents;
import no.hal.emfs.EmfsFile;
import no.hal.emfs.EmfsResource;
import no.hal.emfs.StringContentProvider;

import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true,
	property = AbstractSourceEditorServletService.OPERATION_KEY + "=refresh,update"
)
public class RefreshUpdateEditorServletService extends AbstractSourceEditorServletService implements SourceEditorServletService {

	@Reference
	@Override
	public synchronized void setSourceProjectManager(SourceProjectManager sourceProjectManager) {
		super.setSourceProjectManager(sourceProjectManager);
	}

	@Activate
	protected void activate(ComponentContext context) {
		super.activate(context);
	}

	protected Boolean markersDefault = true;

	@Override
	public CharSequence doSourceEditorServletService(EditorServiceRequest request, String requestBody) {
		EmfsResource emfsResource = getSourceProjectManager().getEmfsResource(request.resourceRef);
		AbstractStringContents editableStringContents = null;
		if (emfsResource instanceof EmfsFile) {
			EmfsFile emfsFile = (EmfsFile) emfsResource;
			editableStringContents = EmfsUtil.findStringContents(emfsFile, AbstractStringContents::isWriteable);
		}
		SourceEditor sourceEditor = getSourceEditor(request);
		if ("update".equals(request.op)) {
			if (editableStringContents != null) {
				editableStringContents.setStringContent(requestBody);
				requestBody = ((StringContentProvider) ((EmfsFile) emfsResource).getContentProvider()).getStringContent();
			}
			SourceFileMarker[] sourceFileMarkers = getSourceEditor(request).update(requestBody, markersDefault, false);
			CharacterPosition offset = computeResourceOffset(getSourceProjectManager().getEmfsResource(request.resourceRef));
			return MarkersEditorServletService.markersResponse(sourceFileMarkers, request.responseFormat, offset);
		}
		CharSequence stringContents = null;
		if (editableStringContents != null) {
			stringContents = editableStringContents.getStringContent();
		} else {
			stringContents = sourceEditor.getSourceFileContents();
		}
		return refreshResponse(stringContents, request.responseFormat);
	}

	public static String refreshResponse(CharSequence fileContent, String protocol) {
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		PrintWriter output = new PrintWriter(buffer);
		writeRefreshResponse(protocol, output, fileContent);
		output.close();
		return buffer.toString();
	}

	private static void writeRefreshResponse(String responseFormat, PrintWriter writer, CharSequence fileContent) {
		ResponseFormatter formatter = AbstractServiceServlet.getResponseFormatter(responseFormat, writer);
		if (formatter != null) {
			formatter.startEntities("refresh", false);
		} else {
			writer.println("<html>\n"
				+ "\t<head><title>Refresh</title></head>\n"
				+ "\t<body>");
			writer.println("\t\t<h1>Refresh</h1>\n\t\t");
		}

		if (formatter != null) {
			formatter.entity("refresh", "code", fileContent).endEntity();
		} else {
			// TODO: Write a proper result display
			writer.println("\t\t\t<textarea>" + fileContent + "</textarea>");
		}

		if (formatter == null) {
			writer.println("\t</body>\n</html>");
		}
	}
}
