package no.hal.eclipsky.services.workspace.http;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hal.eclipsky.services.common.ProjectRef;
import no.hal.eclipsky.services.common.ResourceRef;
import no.hal.eclipsky.services.emfs.EmfsService;
import no.hal.emfs.EmfsPackage;
import no.hal.emfs.EmfsResource;
import no.hal.emfs.util.PropertyResolver;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

@SuppressWarnings("serial")
public class EnsureProjectServlet extends ProjectListServlet {
	
	private EmfsService emfsService;
	
	public synchronized void setEmfsService(EmfsService emfsService) {
		this.emfsService = emfsService;
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("ensureProjectForm.html");
	}

	protected EmfsResource getEmfsResource(String body) throws Exception {
		ResourceSet resourceSet = new ResourceSetImpl();
		String defaultExt = "emfs";
		String ext = (body.startsWith("<?xml") ? defaultExt : "xemfs");
		Resource.Factory.Registry registry = Resource.Factory.Registry.INSTANCE;
		if (resourceSet.getResourceFactoryRegistry() == null) {
			resourceSet.setResourceFactoryRegistry(registry);
		}
		Resource.Factory resourceFactory = (Resource.Factory) resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().get(ext);
		if (resourceFactory == null) {
			resourceFactory = (Resource.Factory) Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().get(ext);
		}
		if (resourceFactory == null) {
			ext = defaultExt;
		}
		Resource resource = resourceFactory.createResource(URI.createURI("temp." + ext));
		byte[] bytes = body.getBytes(StandardCharsets.UTF_8);
		try (InputStream stream = new ByteArrayInputStream(bytes);) {
			resource.load(stream, null);
			Object emfsResource = EcoreUtil.getObjectByType(resource.getContents(), EmfsPackage.eINSTANCE.getEmfsContainer());
			return (EmfsResource) emfsResource;
		}
	}

	private PropertyResolver propertyResolver = new PropertyResolver(false, true);

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPut(request, response);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProjectRef projectRef = getProjectRef(request);
		String emfsContent = request.getParameter("emfs"); // getRequestBodyContent(request);
		EmfsResource emfsResource = null;
		Exception ex = null;
		try {
			emfsResource = getEmfsResource(emfsContent);
		} catch (Exception resourceException) {
			ex = resourceException;
		}
		Collection<String> natures = new ArrayList<String>();
		Object naturePropertyValue = (emfsResource != null ? propertyResolver.getProperty(emfsResource, "natures") : null);
		if (naturePropertyValue != null) {
//			natures.addAll(Arrays.asList(String.valueOf(naturePropertyValue).split("[,;]")));
		}
		String projectName = projectRef.getProjectName();
		getWorkspaceService().ensureProject(projectName, natures.toArray(new String[natures.size()]));
		if (emfsResource != null) {
//			boolean overwrite = Boolean.valueOf(request.getParameter("overwrite"));
			try {
				emfsService.importResources(Arrays.asList(emfsResource), projectName, true, null);
			} catch (Exception importException) {
				ex = importException;
			}
		}
		String responseFormat = getResponseFormat(request);
		PrintWriter writer = response.getWriter();
		if (ex != null) {
			writeExceptionResponse(responseFormat, writer, ex);
		} else if (! "html".equals(responseFormat)) {
			writeProjectListResponse(responseFormat, writer, projectName);
		} else {
			writer.println("<html>\n"
					+ "\t<head><title>Project " + projectName + "</title></head>\n"
					+ "\t<body>");
			writer.println("<h1>Project " + projectName + "'s packages and resources</h1>\n"
					+ "\t<ul>");
			writerResourcesResponse(responseFormat, writer, getWorkspaceService(), new ResourceRef(projectName, null, null), -1);
			writer.println("\t</ul></body>\n"
					+ "</html>");
		}
		writer.close();
	}
}
