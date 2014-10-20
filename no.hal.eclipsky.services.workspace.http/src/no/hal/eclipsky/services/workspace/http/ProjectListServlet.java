package no.hal.eclipsky.services.workspace.http;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ProjectListServlet extends WorkspaceServiceServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String responseFormat = getResponseFormat(request);
		String namePattern = request.getParameter("namePattern");
		String[] projectNames = getWorkspaceService().getProjectList(namePattern, null);
		response.setContentType("text/" + ("html".equals(responseFormat) ? "html" : "plain")); 
		PrintWriter writer = response.getWriter();
		switch (responseFormat) {
		case "xml" : writer.println("<projects>"); break;
		case "json" : writer.println("["); break;
		case "html" : {
			writer.println("<html>\n"
					+ "\t<head><title>Project list</title></head>\n"
					+ "\t<body>");
			writer.println("\t\t<h1>Projects</h1>\n\t\t<ul>");
			break;
		}
		}
		int count = projectNames.length;
		for (int i = 0; i < count; i++) {
			String projectName = projectNames[i];
			switch (responseFormat) {
			case "xml" : writer.println("\t<project name=\"" + projectName + "\"/>"); break;
			case "json" : {
				writer.print("	{ \"name\": \"" + projectName + "\"}");
				if (i + 1 < count) writer.print(",");
				writer.println();
				break;
			}
			case "html" : writer.println("\t\t\t<li>" + projectName + "</li>");
				break;
			}
		}
		switch (responseFormat) {
		case "xml" : writer.println("</project>"); break;
		case "json" : writer.println("]"); break;
		case "html" : {
			writer.println("\t\t</ul>");
			writer.println("\t</body>\n"
					+ "</html>");
			break;
		}
		}
	}
}
