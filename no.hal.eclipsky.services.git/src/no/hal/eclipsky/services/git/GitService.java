package no.hal.eclipsky.services.git;

import java.io.File;

import no.hal.emfs.git.GitRepoRef;

public interface GitService {
	
	public File getFile(GitRepoRef repoRef, String path, boolean update);
}
