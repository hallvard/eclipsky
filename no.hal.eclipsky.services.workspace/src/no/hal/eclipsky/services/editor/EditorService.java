package no.hal.eclipsky.services.editor;

public interface EditorService {
	public String getSourceFile(String projectName, String packageName, String resourceName);
	public SourceEditor openEditor(String projectName, String packageName, String resourceName);
}
