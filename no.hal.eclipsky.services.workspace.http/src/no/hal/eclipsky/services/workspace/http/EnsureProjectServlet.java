package no.hal.eclipsky.services.workspace.http;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import no.hal.eclipsky.services.common.ResourceRef;
import no.hal.eclipsky.services.monitoring.ServiceLogger;
import no.hal.eclipsky.services.workspace.IServiceExecutor;
import no.hal.eclipsky.services.workspace.WorkspaceService;
import no.hal.eclipsky.services.workspace.impl.EmfsUtil;
import no.hal.eclipsky.services.workspace.model.EnsureProjectService;
import no.hal.eclipsky.services.workspace.model.ModelFactory;
import no.hal.emfs.EmfsPackage;
import no.hal.emfs.EmfsResource;

@Component(
	property = {
		AbstractServiceServlet.SERVLET_ALIAS_KEY + "=ensureProject",
		AbstractServiceServlet.RESOURCE_ALIAS_KEY_PREFIX + "ensureProjectForm.html=/web/html/ensureProjectForm.html"
	}
)
@SuppressWarnings("serial")
public class EnsureProjectServlet extends ProjectListServlet implements ServiceServlet {

	@Reference(target="(services=*EnsureProjectService*)")
	@Override
	public synchronized void setServiceExecutor(IServiceExecutor serviceExecutor) {
		super.setServiceExecutor(serviceExecutor);
	}
	@Override
	public synchronized void unsetServiceExecutor(IServiceExecutor serviceExecutor) {
		super.unsetServiceExecutor(serviceExecutor);
	}

	@Reference
	public synchronized void setServiceFactory(ModelFactory serviceFactory) {
		super.setServiceFactory(serviceFactory);
	}
	public synchronized void unsetServiceFactory(ModelFactory serviceFactory) {
		super.unsetServiceFactory(serviceFactory);
	}

	@Activate
	@Override
	protected void activate(ComponentContext context) {
		super.activate(context);
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
		InputStream stream = new ByteArrayInputStream(bytes);
		try {
			resource.load(stream, null);
		} catch (IOException ioe) {
		}
		Object emfsResource = EcoreUtil.getObjectByType(resource.getContents(), EmfsPackage.eINSTANCE.getEmfsContainer());
		return (EmfsResource) emfsResource;
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		handleRequest(request, response);
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		handleRequest(request, response);
	}
	
	private WorkspaceService workspaceService;
	
	@Reference
	public synchronized void setWorkspaceService(WorkspaceService workspaceService) {
		this.workspaceService = workspaceService;
	}
	public synchronized void unsetWorkspaceService(WorkspaceService workspaceService) {
		this.workspaceService = null;
	}

	private void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServiceLogger serviceLogger = getServiceLogger();
		serviceLogger.serviceRequested(request, getClass().getSimpleName(), -1);
		EnsureProjectService service = getServiceFactory().createEnsureProjectService();
		service.setProjectRef(getProjectRef(request));
		String emfsContent = request.getParameter("emfs"); // getRequestBodyContent(request);
		Exception ex = null;
		try {
			EmfsResource emfsResource = getEmfsResource("temp", emfsContent);
			service.setEmfs(emfsResource);
			switch (getServiceExecutor().performService(service)) {
				case SUCCESS:
					break;
				default:
					break;
			}
		} catch (Exception resourceException) {
			ex = resourceException;
		}
		String responseFormat = getResponseFormat(request);
		String forward = request.getParameter("forward");
		String projectName = service.getProjectRef().getProjectName();
		if (ex != null) {
			PrintWriter writer = response.getWriter();
			writeExceptionResponse(responseFormat, writer, ex);
		} else if (forward != null) {
			if (! forward.contains("?")) {
				forward += "?";
			} else {
				forward += "&";
			}
			forward += "projectName=" + projectName;
//			request.getRequestDispatcher(forward).forward(request, response);
			response.sendRedirect(forward);
		} else {
			PrintWriter writer = response.getWriter();
			if (! "html".equals(responseFormat)) {
				writeProjectListResponse(responseFormat, writer, projectName);
			} else {
				writer.println("<html>\n"
						+ "\t<head><title>Project " + projectName + "</title></head>\n"
						+ "\t<body>");
				writer.println("<h1>Project " + projectName + "'s packages and resources</h1>\n"
						+ "\t<ul>");
				writerResourcesResponse(responseFormat, writer, workspaceService, new ResourceRef(projectName, null, null), -1);
				writer.println("\t</ul></body>\n"
						+ "</html>");
			}
		}
		serviceLogger.serviceResponded(request, projectName, -1);
	}
}
