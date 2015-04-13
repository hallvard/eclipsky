package no.hal.eclipsky.services.workspace.http;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import no.hal.eclipsky.services.common.ProjectRef;
import no.hal.eclipsky.services.common.ResourceRef;
import no.hal.eclipsky.services.workspace.ProjectService;

@Component(
	property = AbstractServiceServlet.SERVLET_ALIAS_KEY + "=projectResources"
)
@SuppressWarnings("serial")
public class ProjectResourcesServlet extends AbstractProjectServiceServlet implements ServiceServlet {

	@Reference
	@Override
	public synchronized void setProjectService(ProjectService projectService) {
		super.setProjectService(projectService);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProjectRef projectRef = getProjectRef(request);
		String projectName = projectRef.getProjectName();
		String responseFormat = getResponseFormat(request);
		PrintWriter writer = response.getWriter();
		writer.println("<html>\n"
				+ "\t<head><title>Project " + projectName + "</title></head>\n"
				+ "\t<body>");
		writer.println("<h1>Project " + projectName + "'s packages and resources</h1>\n"
				+ "\t<ul>");
		writerResourcesResponse(responseFormat, writer, getProjectService(), new ResourceRef(projectName, null, null), -1);
		writer.println("\t</ul></body>\n"
				+ "</html>");
		writer.close();
	}
}
