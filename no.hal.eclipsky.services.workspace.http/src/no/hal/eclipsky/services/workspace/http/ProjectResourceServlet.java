package no.hal.eclipsky.services.workspace.http;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ProjectResourceServlet extends WorkspaceServiceServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String responseFormat = getResponseFormat(request, null);
		String projectName = request.getParameter("projectName");
		String packageName = request.getParameter("packageName");
		String resourceName = request.getParameter("resourceName");
		boolean binary = "true".equals(request.getParameter("binary"));
		if (binary) {
			byte[] contentBytes = getWorkspaceService().getResource(projectName, packageName, resourceName);
			if (contentBytes == null) {
				super.doGet(request, response);
			} else {
				response.setContentType("application/octet-stream"); 
				ServletOutputStream output = response.getOutputStream();
				output.write(contentBytes);
			}
		} else {
			String contentString = getWorkspaceService().getSourceFile(projectName, packageName, resourceName);
			if (contentString == null) {
				super.doGet(request, response);
			} else {
				response.setContentType("text/plain");
				PrintWriter writer = response.getWriter();
				writer.println(contentString);
			}
		}
	}
}
