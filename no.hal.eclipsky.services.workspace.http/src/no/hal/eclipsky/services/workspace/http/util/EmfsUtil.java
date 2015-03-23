package no.hal.eclipsky.services.workspace.http.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import no.hal.eclipsky.services.common.ResourceHelper;
import no.hal.eclipsky.services.common.ResourceRef;
import no.hal.emfs.EmfsContainer;
import no.hal.emfs.EmfsFile;
import no.hal.emfs.EmfsResource;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;

public class EmfsUtil {

	private static String getProjectName(EmfsResource emfsFile) {
		return null;
	}

	public static String getFullName(EmfsResource emfsResource, Predicate<EmfsResource> rootPredicate, String separator) {
		StringBuilder buffer = new StringBuilder();
		while (emfsResource != null) {
			if (rootPredicate.test(emfsResource)) {
				return buffer.toString();
			}
			if (buffer.length() > 0) {
				buffer.insert(0, separator);
			}
			buffer.insert(0, emfsResource.getName());
			emfsResource = emfsResource.getContainer();
		}
		return buffer.toString();
	}
	
	public static boolean isSourceFolder(EmfsResource emfsResource) {
		return emfsResource instanceof EmfsContainer && ResourceHelper.isSourceOrTestFolderName(emfsResource.getName());
	}
	
	public static boolean isRunnable(EmfsResource emfsResource) {
		return emfsResource instanceof EmfsFile && hasTags(emfsResource, "java", "application");
	}

	public static boolean isTestable(EmfsResource emfsResource) {
		return emfsResource instanceof EmfsFile && (emfsResource.getName().endsWith("Test.java") || hasTags(emfsResource, "java", "test"));
	}
	
	public static ResourceRef createResourceRef(EmfsResource emfsFile) {
		String fullName = getFullName(emfsFile.getContainer(), EmfsUtil::isSourceFolder, ".");
		return new ResourceRef(getProjectName(emfsFile), fullName, emfsFile.getName());
	}

	public static boolean hasTags(EmfsResource emfsResource, String... tags) {
		for (int i = 0; i < tags.length; i++) {
			if (! emfsResource.getTags().contains(tags[i])) {
				return false;
			}
		}
		return true;
	}
	
	public static EmfsResource findEmfsResource(EmfsResource emfsModel, Predicate<EmfsResource> predicate) {
		TreeIterator<EObject> it = emfsModel.eAllContents();
		while (it.hasNext()) {
			EObject next = it.next();
			if (next instanceof EmfsContainer);
			else if (next instanceof EmfsResource) {
				if (predicate.test((EmfsResource) next)) {
					return (EmfsResource) next;
				}
			} else {
				it.prune();
			}
		}
		return null;
	}
	
	public static Collection<EmfsResource> collectEmfsResources(EmfsResource emfsModel, Predicate<EmfsResource> predicate) {
		Collection<EmfsResource> emfsResources = new ArrayList<EmfsResource>();
		TreeIterator<EObject> it = emfsModel.eAllContents();
		while (it.hasNext()) {
			EObject next = it.next();
			if (next instanceof EmfsContainer);
			else if (next instanceof EmfsResource) {
				if (predicate.test((EmfsResource) next)) {
					emfsResources.add((EmfsResource) next);
				}
			} else {
				it.prune();
			}
		}
		return emfsResources;
	}

	public static ResourceRef findResource(EmfsResource emfsModel, Predicate<EmfsResource> predicate) {
		EmfsResource emfsResource = EmfsUtil.findEmfsResource(emfsModel, predicate);
		if (emfsResource != null) {
			return createResourceRef(emfsResource);
		}
		return null;
	}

	public static Collection<ResourceRef> collectResources(EmfsResource emfsModel, Predicate<EmfsResource> predicate) {
		Collection<EmfsResource> emfsResources = EmfsUtil.collectEmfsResources(emfsModel, predicate);
		return emfsResources.stream().map(EmfsUtil::createResourceRef).collect(Collectors.toList());
	}
}
