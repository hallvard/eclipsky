package no.hal.eclipsky.services.git.impl;

import java.util.Dictionary;

import no.hal.eclipsky.services.git.GitService;
import no.hal.emfs.git.GitImportSupport;
import no.hal.emfs.util.ImportSupport;

import org.osgi.service.component.ComponentContext;

public class GitServiceImpl extends GitImportSupport implements GitService, ImportSupport {

	public final static String GIT_DIRECTORY_KEY = "git.directory";
	
	protected void activate(ComponentContext context) {
		Dictionary<String, Object> properties = context.getProperties();
		Object gitDirectoryValue = (properties != null ? properties.get(GIT_DIRECTORY_KEY) : null);
		if (gitDirectoryValue != null) {
			setGitDirectory(String.valueOf(gitDirectoryValue));
		}
	}
}
