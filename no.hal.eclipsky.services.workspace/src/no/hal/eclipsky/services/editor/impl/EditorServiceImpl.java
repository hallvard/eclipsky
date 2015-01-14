package no.hal.eclipsky.services.editor.impl;

import org.eclipse.core.resources.IFile;

import no.hal.eclipsky.services.common.AbstractResourceServiceImpl;
import no.hal.eclipsky.services.editor.EditorService;
import no.hal.eclipsky.services.editor.SourceEditor;

public class EditorServiceImpl extends AbstractResourceServiceImpl implements EditorService {

	@Override
	public String getSourceFile(String projectName, String packageName, String resourceName) {
		IFile file = getFile(projectName, packageName, resourceName, true, "src");
		return (file != null ? super.getFileStringContent(file).toString() : null);
	}
	
	@Override
	public SourceEditor openEditor(String projectName, String packageName, String resourceName) {
		if (resourceName.endsWith(".java")) {
			return new JavaSourceEditor(projectName, packageName, resourceName);
		}
		return new GenericSourceEditor(projectName, packageName, resourceName);
	}
}
