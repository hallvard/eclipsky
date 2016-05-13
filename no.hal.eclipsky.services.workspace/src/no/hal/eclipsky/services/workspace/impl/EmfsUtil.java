package no.hal.eclipsky.services.workspace.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import no.hal.eclipsky.services.common.ResourceHelper;
import no.hal.eclipsky.services.common.ResourceRef;
import no.hal.emfs.AbstractStringContents;
import no.hal.emfs.EmfsContainer;
import no.hal.emfs.EmfsFile;
import no.hal.emfs.EmfsResource;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

public class EmfsUtil {

	private static String getProjectName(EmfsResource emfsFile) {
		return null;
	}

	public static EmfsResource getEmfsContainer(EmfsResource emfsResource, Predicate<EmfsResource> predicate) {
		while (emfsResource != null) {
			if (predicate.test(emfsResource)) {
				return emfsResource;
			}
			emfsResource = emfsResource.getContainer();
		}
		return null;
	}
	
	public static String getFullName(EmfsResource emfsResource, EmfsResource root, String separator) {
		StringBuilder buffer = new StringBuilder();
		while (emfsResource != null) {
			if (emfsResource == root) {
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
	
	public static String getFullName(EmfsResource emfsResource, Predicate<EmfsResource> rootPredicate, String separator) {
		return getFullName(emfsResource, getEmfsContainer(emfsResource, rootPredicate), separator);
	}
	
	public static boolean isSourceFolder(EmfsResource emfsResource) {
		return emfsResource instanceof EmfsContainer && ResourceHelper.isSourceOrTestFolderName(emfsResource.getName());
	}
	
	public static boolean isRunnable(EmfsResource emfsResource) {
		return emfsResource instanceof EmfsFile; // && hasTags(emfsResource, "java", "application");
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
	
	public static boolean isEmfsResource(EmfsResource emfsModel, ResourceRef resourceRef, Predicate<EmfsResource> predicate) {
		EmfsResource foundEmfsResource = findEmfsResource(emfsModel, emfsResource -> resourceRef.equals(createResourceRef(emfsResource)));
		return foundEmfsResource != null && predicate.test(foundEmfsResource);
	}
	
	private static <T extends EObject> T findEObject(EObject root, Class<?> continueClazz, Class<T> clazz, Predicate<T> predicate) {
		TreeIterator<EObject> it = root.eAllContents();
		while (it.hasNext()) {
			EObject next = it.next();
			if (continueClazz != null && continueClazz.isInstance(next));
			else if (clazz.isInstance(next)) {
				@SuppressWarnings("unchecked")
				T t = (T) next;
				if (predicate.test(t)) {
					return t;
				}
			} else if (continueClazz != null) {
				it.prune();
			}
		}
		return null;
	}

	public static EmfsResource findEmfsResource(EmfsResource emfsModel, Predicate<EmfsResource> predicate) {
		return findEObject(emfsModel, EmfsContainer.class, EmfsResource.class, predicate);
	}
	
	public static AbstractStringContents findStringContents(EmfsResource emfsResource, Predicate<AbstractStringContents> predicate) {
		return findEObject(emfsResource, EmfsResource.class, AbstractStringContents.class, predicate);
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
	
	//
	
	public static Resource createEmfsResource(URI uri, String ext) {
		ResourceSet resourceSet = new ResourceSetImpl();
		String defaultExt = "emfs";
		Resource.Factory.Registry registry = Resource.Factory.Registry.INSTANCE;
		if (resourceSet.getResourceFactoryRegistry() == null) {
			resourceSet.setResourceFactoryRegistry(registry);
		}
		Object resourceFactory = null;
		if (ext != null) {
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().get(ext);
		}
		if (resourceFactory == null) {
			resourceFactory = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().get(ext);
		}
		if (resourceFactory == null) {
			ext = defaultExt;
		}
		if (resourceFactory instanceof Resource.Factory.Descriptor) {
			resourceFactory = ((Resource.Factory.Descriptor) resourceFactory).createFactory();
		}
		if (resourceFactory instanceof Resource.Factory) {
			return ((Resource.Factory) resourceFactory).createResource(ext.equals(uri.fileExtension()) ? uri : uri.appendFileExtension(ext));
		}
		return null;
	}
}
