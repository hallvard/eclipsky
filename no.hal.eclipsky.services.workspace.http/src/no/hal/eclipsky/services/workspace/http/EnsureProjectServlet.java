package no.hal.eclipsky.services.workspace.http;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hal.eclipsky.services.common.ProjectRef;
import no.hal.eclipsky.services.common.ResourceRef;
import no.hal.eclipsky.services.monitoring.ServiceLogger;
import no.hal.eclipsky.services.workspace.WorkspaceService;
import no.hal.eclipsky.services.workspace.http.util.EmfsUtil;
import no.hal.emfs.EmfsPackage;
import no.hal.emfs.EmfsResource;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	property = {
		AbstractServiceServlet.SERVLET_ALIAS_KEY + "=ensureProject",
		AbstractServiceServlet.RESOURCE_ALIAS_KEY_PREFIX + "ensureProjectForm.html=/html/ensureProjectForm.html"
	}
)
@SuppressWarnings("serial")
public class EnsureProjectServlet extends ProjectListServlet implements ServiceServlet {

	@Reference
	@Override
	public synchronized void setWorkspaceService(WorkspaceService workspaceService) {
		super.setWorkspaceService(workspaceService);
	}
	public synchronized void unsetWorkspaceService(WorkspaceService workspaceService) {
		super.unsetWorkspaceService(workspaceService);
	}

	@Activate
	@Override
	protected void activate(ComponentContext context) {
		super.activate(context);
	}

	private SourceProjectManager sourceProjectManager;
	
	@Reference
	public synchronized void setSourceProjectManager(SourceProjectManager sourceProjectManager) {
		this.sourceProjectManager = sourceProjectManager;
	}
	public synchronized void unsetSourceProjectManager(SourceProjectManager sourceProjectManager) {
		setSourceProjectManager(null);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("ensureProjectForm.html");
	}

	protected EmfsResource getEmfsResource(String name, String body) throws Exception {
		String defaultExt = "emfs";
		String ext = (body.startsWith("<?xml") ? defaultExt : "xemfs");
		Resource resource = EmfsUtil.createEmfsResource(URI.createURI(name), ext);
		byte[] bytes = body.getBytes(StandardCharsets.UTF_8);
		try (InputStream stream = new ByteArrayInputStream(bytes);) {
			resource.load(stream, null);
			Object emfsResource = EcoreUtil.getObjectByType(resource.getContents(), EmfsPackage.eINSTANCE.getEmfsContainer());
			return (EmfsResource) emfsResource;
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		handleRequest(request, response);
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		handleRequest(request, response);
	}
	
	private void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServiceLogger serviceLogger = getServiceLogger();
		serviceLogger.serviceRequested(request, getClass().getSimpleName(), -1);
		ProjectRef projectRef = getProjectRef(request);
		String emfsContent = request.getParameter("emfs"); // getRequestBodyContent(request);
		Exception ex = null;
		try {
			EmfsResource emfsResource = getEmfsResource("temp", emfsContent);
			sourceProjectManager.ensureSourceProject(projectRef, emfsResource);
		} catch (Exception resourceException) {
			ex = resourceException;
		}
		String responseFormat = getResponseFormat(request);
		String forward = request.getParameter("forward");
		if (ex != null) {
			PrintWriter writer = response.getWriter();
			writeExceptionResponse(responseFormat, writer, ex);
		} else if (forward != null) {
			if (! forward.contains("?")) {
				forward += "?";
			} else {
				forward += "&";
			}  
			forward += "projectName=" + projectRef.getProjectName();
//			request.getRequestDispatcher(forward).forward(request, response);
			response.sendRedirect(forward);
		} else {
			PrintWriter writer = response.getWriter();
			String projectName = projectRef.getProjectName();
			if (! "html".equals(responseFormat)) {
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
		}
		serviceLogger.serviceResponded(request, projectRef.getProjectName(), -1);
	}
}
