package no.hal.eclipsky.services.workspace.http;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hal.eclipsky.services.common.ResourceRef;

@SuppressWarnings("serial")
public class ProjectResourceServlet extends AbstractWorkspaceServiceServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ResourceRef resourceRef = getResourceRef(request);
		boolean binary = Boolean.valueOf(request.getParameter("binary"));
		if (binary) {
			byte[] contentBytes = getWorkspaceService().getResource(resourceRef);
			if (contentBytes == null) {
				super.doGet(request, response);
			} else {
				response.setContentType("application/octet-stream"); 
				ServletOutputStream output = response.getOutputStream();
				output.write(contentBytes);
			}
		} else {
			String contentString = getWorkspaceService().getSourceFile(resourceRef);
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
