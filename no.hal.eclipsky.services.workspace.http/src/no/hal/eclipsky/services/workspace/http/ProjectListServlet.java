package no.hal.eclipsky.services.workspace.http;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.http.HttpGenerator.Result;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import no.hal.eclipsky.services.workspace.IServiceExecutor;
import no.hal.eclipsky.services.workspace.model.ModelFactory;
import no.hal.eclipsky.services.workspace.model.ProjectListService;
import no.hal.eclipsky.services.workspace.model.ResultKind;

@Component(
	property = AbstractServiceServlet.SERVLET_ALIAS_KEY + "=projects"
)
@SuppressWarnings("serial")
public class ProjectListServlet extends AbstractServiceServlet implements ServiceServlet {
	
	@Reference(target="(services=*ProjectListService*)")
	@Override
	public synchronized void setServiceExecutor(IServiceExecutor serviceExecutor) {
		super.setServiceExecutor(serviceExecutor);
	}
	public synchronized void unsetServiceExecutor(IServiceExecutor serviceExecutor) {
		super.setServiceExecutor(null);
	}

	@Reference
	public synchronized void setServiceFactory(ModelFactory serviceFactory) {
		super.setServiceFactory(serviceFactory);
	}
	public synchronized void unsetServiceFactory(ModelFactory serviceFactory) {
		super.setServiceFactory(null);
	}

	@Activate
	@Override
	protected void activate(ComponentContext context) {
		super.activate(context);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProjectListService service = getServiceFactory().createProjectListService();
		service.setNamePattern(request.getParameter("namePattern"));
		String responseFormat = getResponseFormat(request);
		ResultKind result = getServiceExecutor().performService(service);
		if (result == ResultKind.SUCCESS) {
			response.setContentType("text/" + ("html".equals(responseFormat) ? "html" : "plain")); 
			String[] projectNames = new String[service.getProjects().size()];
			for (int i = 0; i < service.getProjects().size(); i++) {
				projectNames[i] = service.getProjects().get(i).getProjectRef().getProjectName();
			}
			writeProjectListResponse(responseFormat, response.getWriter(), projectNames);
		}
	}

	protected void writeProjectListResponse(String responseFormat, PrintWriter writer, String... projectNames) throws ServletException, IOException {
		if ("xml".equals(responseFormat)) {
			writer.println("<projects>");
		} else if ("json".equals(responseFormat)) {
			writer.println("[");
		} else if ("html".equals(responseFormat)) {
			writer.println("<html>\n"
					+ "\t<head><title>Project list</title></head>\n"
					+ "\t<body>");
			writer.println("\t\t<h1>Projects</h1>\n\t\t<ul>");
		}
		int count = projectNames.length;
		for (int i = 0; i < count; i++) {
			String projectName = projectNames[i];
			if ("xml".equals(responseFormat)) {
				writer.println("\t<project name=\"" + projectName + "\"/>");
			} else if ("json".equals(responseFormat)) {
				writer.print("	{ \"name\": \"" + projectName + "\"}");
				if (i + 1 < count) writer.print(",");
				writer.println();
			} else if ("html".equals(responseFormat)) {
				writer.println("\t\t\t<li>");
				writer.print("<a href='projectResources?projectName=" + projectName + "'>" + projectName + "</a>");
				writer.print(" (<a href='sourceEditor?projectName=" + projectName + "'>" + "edit" + "</a>)");
				writer.println("</li>");
			}
		}
		if ("xml".equals(responseFormat)) {
			writer.println("</project>");
		} else if ("json".equals(responseFormat)) {
			writer.println("]");
		} else if ("html".equals(responseFormat)) {
			writer.println("\t\t</ul>");
			writer.println("\t</body>\n"
					+ "</html>");
		}
	}
}
