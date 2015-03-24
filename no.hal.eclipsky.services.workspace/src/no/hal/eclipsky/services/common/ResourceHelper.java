package no.hal.eclipsky.services.common;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringBufferInputStream;

import no.hal.eclipsky.services.editor.impl.SourceFileMarkersProvider;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

public class ResourceHelper {

	public static String[] SOURCE_FOLDER_NAMES = {"src", "resources"};
	public static String[] SOURCE_AND_TEST_FOLDER_NAMES = {"src", "resources", "tests"};

	private static boolean isNamed(String name, String... names) {
		for (int i = 0; i < names.length; i++) {
			if (names[i].equals(name)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isSourceOrTestFolderName(String name) {
		return isNamed(name, SOURCE_AND_TEST_FOLDER_NAMES);
	}

	public static boolean isSourceFolderName(String name) {
		return isNamed(name, SOURCE_FOLDER_NAMES);
	}
	
	private IFile file;
	
	public ResourceHelper(IFile file) {
		this.file = file;
	}
	
	public ResourceHelper(String projectName, String packageName, String name, Boolean exists, String...  folders) {
		this(getFile(projectName, packageName, name, exists, folders));
	}

	public ResourceHelper(ResourceRef ref, Boolean exists, String...  folders) {
		this(ref.getProjectName(), ref.getPackageName(), ref.getResourceName(), exists, folders);
	}
	
	public static IWorkspaceRoot getWorkspaceRoot() {
		return ResourcesPlugin.getWorkspace().getRoot();
	}

	public static IProject getProject(String projectName) {
		return getWorkspaceRoot().getProject(projectName);
	}

	public IFile getFile(Boolean exists) {
		if (exists == null || exists == file.exists()) {
			return file;
		}
		return null;
	}

	public static IFile getFile(String projectName, String packageName, String name, Boolean exists, String...  folders) {
		IProject project = getProject(projectName);
		for (int i = 0; i < folders.length; i++) {
			IPath path = new Path(IPath.SEPARATOR + folders[i] + IPath.SEPARATOR + packageName.replace('.', IPath.SEPARATOR) + IPath.SEPARATOR + name);
			IFile file = project.getFile(path);
			if (exists != null) {
				if (exists == file.exists()) {
					return file;
				}
			} else {
				return file;
			}			
		}
		return null;
	}

	public CharSequence getFileStringContent() {
		return getFileStringContent(this.file);
	}

	public static CharSequence getFileStringContent(IFile file) {
		StringBuilder buffer = new StringBuilder();
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(file.getContents()));
			String line = null;
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
				buffer.append("\n");
			}
		} catch (Exception e) {
			buffer.append(e.getMessage());
		}
		return buffer.toString();
	}

	public void setFileStringContent(CharSequence content) {
		setFileStringContent(this.file, content);
	}
	
	@SuppressWarnings("deprecation")
	public static void setFileStringContent(IFile file, CharSequence content) {
		try {
			file.setContents(new StringBufferInputStream(content.toString()), true, true, null);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public SourceFileMarker[] createSourceFileMarkers() {
		return createSourceFileMarkers(this.file);
	}
	
	public static SourceFileMarker[] createSourceFileMarkers(IResource resource) {
		IMarker[] problems = null;
		try {
			problems = resource.findMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
		} catch (CoreException e) {
		}
		SourceFileMarker[] sourceFileMarkers = new SourceFileMarker[problems != null ? problems.length : 0];
		for (int i = 0; i < sourceFileMarkers.length; i++) {
			sourceFileMarkers[i] = SourceFileMarkersProvider.createSourceFileMarker(problems[i]);
		}
		return sourceFileMarkers;
	}

	private static byte[] byteBuffer = new byte[2048];

	public byte[] getFileBytesContent() {
		return getFileBytesContent(this.file);
	}

	public synchronized static byte[] getFileBytesContent(IFile file) {
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		try {
			InputStream input = file.getContents();
			int len = 0;
			while ((len = input.read(byteBuffer)) >= 0) {
				buffer.write(byteBuffer, 0, len);
			}
		} catch (Exception e) {
		}
		return buffer.toByteArray();
	}
}
