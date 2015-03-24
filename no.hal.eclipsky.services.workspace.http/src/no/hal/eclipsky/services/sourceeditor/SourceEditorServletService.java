package no.hal.eclipsky.services.sourceeditor;

public interface SourceEditorServletService {
	public String[] getSupportedOperations();
	public CharSequence doSourceEditorServletService(SourceEditorServlet.EditorServiceRequest request, String requestBody);
}
