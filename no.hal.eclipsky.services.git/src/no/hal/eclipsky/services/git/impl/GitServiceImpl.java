package no.hal.eclipsky.services.git.impl;

import java.util.Dictionary;

import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Component;

import no.hal.eclipsky.services.git.GitService;
import no.hal.emfs.exporter.ExportSupport;
import no.hal.emfs.git.GitExportSupport;

@Component(
	property=GitServiceImpl.GIT_DIRECTORY_KEY + "=git"
)
public class GitServiceImpl extends GitExportSupport implements GitService, ExportSupport {

	public final static String GIT_DIRECTORY_KEY = "git.directory";
	
	protected void activate(ComponentContext context) {
		Dictionary<String, Object> properties = context.getProperties();
		Object gitDirectoryValue = (properties != null ? properties.get(GIT_DIRECTORY_KEY) : null);
		if (gitDirectoryValue != null) {
			setGitDirectory(String.valueOf(gitDirectoryValue));
		}
	}
}
