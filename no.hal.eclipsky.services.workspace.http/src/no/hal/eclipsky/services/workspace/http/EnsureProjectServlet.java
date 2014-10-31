package no.hal.eclipsky.services.workspace.http;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
 
public class EnsureProjectServlet extends WorkspaceServiceServlet {

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String responseFormat = getResponseFormat(request);
		String projectName = request.getParameter("projectName");
		getWorkspaceService().ensureProject(projectName, null);
		response.setContentType("text/" + ("html".equals(responseFormat) ? "html" : "plain")); 
		PrintWriter writer = response.getWriter();
		switch (responseFormat) {
		case "xml" : writer.println("<project>"); break;
		case "json" : writer.println("["); break;
		case "html" : {
			writer.println("<html>\n"
					+ "\t<head><title>Ensure project</title></head>\n"
					+ "\t<body>");
			IPath workspaceLocation = ResourcesPlugin.getWorkspace().getRoot().getLocation();
			writer.println("\t\t<p>Ensure project " + projectName + " in workspace at: " + workspaceLocation + "</p>");
			writer.println("\t</body>\n"
					+ "</html>");
			break;
		}
	}
}
}
