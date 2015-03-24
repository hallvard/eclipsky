package no.hal.eclipsky.services.workspace.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Dictionary;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import no.hal.eclipsky.services.common.AbstractResourceVisitor;
import no.hal.eclipsky.services.common.ProjectRef;
import no.hal.eclipsky.services.common.ResourceRef;
import no.hal.eclipsky.services.workspace.ResourcesService;
import no.hal.eclipsky.services.workspace.http.util.JsonResponseFormatter;
import no.hal.eclipsky.services.workspace.http.util.ResponseFormatter;
import no.hal.eclipsky.services.workspace.http.util.XmlResponseFormatter;

import org.osgi.service.component.ComponentContext;

@SuppressWarnings("serial")
public abstract class AbstractServiceServlet extends HttpServlet implements ServiceServlet {

	public final static String SERVLET_ALIAS_KEY = "servlet.alias";
	public final static String RESOURCE_ALIAS_KEY_PREFIX = "resource.alias.";

	private String alias = null;
	private String[] resourceAliases = null;
	
	protected void activate(ComponentContext context) {
		Dictionary<String, Object> properties = context.getProperties();
		Object aliasValue = (properties != null ? properties.get(SERVLET_ALIAS_KEY) : null);
		alias = (aliasValue != null ? String.valueOf(aliasValue) : getClass().getSimpleName());
		Collection<String> resourcesAliasList = new ArrayList<String>();
		Enumeration<String> keys = properties.keys();
		while (keys.hasMoreElements()) {
			String key = keys.nextElement();
			if (key.startsWith(RESOURCE_ALIAS_KEY_PREFIX)) {
				resourcesAliasList.add(key.substring(RESOURCE_ALIAS_KEY_PREFIX.length()));
				resourcesAliasList.add(String.valueOf(properties.get(key)));
			}
		}
		resourceAliases = resourcesAliasList.toArray(new String[resourcesAliasList.size()]);
	}

	@Override
	public String getAlias() {
		return alias;
	}
	
	@Override
	public String[] getResourceAliases() {
		return resourceAliases;
	}
	
	//
	
	public static String getResponseFormat(HttpServletRequest request, String def) {
		String responseFormat = request.getParameter("format");
		if (responseFormat == null) {
			responseFormat = def;
		}
		return responseFormat;
	}

	public static String getResponseFormat(HttpServletRequest request) {
		return getResponseFormat(request, "html");
	}
	
	public static ResponseFormatter getResponseFormatter(String responseFormat, PrintWriter writer) {
		switch (responseFormat) {
		case "xml": return new XmlResponseFormatter(writer);
		case "json": return new JsonResponseFormatter(writer);
		}
		return null;
	}

	protected String getRequestBodyContent(HttpServletRequest request) {
		StringBuilder body = new StringBuilder(request.getContentLength());
		try {
			BufferedReader reader = request.getReader();
			String line = null;
			while ((line = reader.readLine()) != null) {
				body.append(line);
				body.append("\n");
			}
		} catch (IOException e) {
		}
		return body.toString();
	}
	
	public static void writeExceptionResponse(String responseFormat, PrintWriter writer, Exception ex) {
		switch (responseFormat) {
		case "xml" : writer.println("<exception>"); break;
		case "json" : writer.println("["); break;
		case "html" : {
			writer.println("<html>\n"
					+ "\t<head><title>Exception</title></head>\n"
					+ "\t<body>");
			break;
		}
		}
		ex.printStackTrace(writer);
		switch (responseFormat) {
		case "xml" : writer.println("</exception>"); break;
		case "json" : writer.println("]"); break;
		case "html" : {
			writer.println("\t</body>\n"
					+ "</html>");
			break;
		}
		}
	}

	protected static class ResourceResponseWriter extends AbstractResourceVisitor {
		
		@SuppressWarnings("unused")
		private String responseFormat;
		private PrintWriter writer;
		
		public ResourceResponseWriter(String responseFormat, PrintWriter writer) {
			super();
			this.responseFormat = responseFormat;
			this.writer = writer;
		}

		protected void indent(int d) {
			int count = getLevel() + d;
			while (count-- > 0) {
				writer.print("\t");
			}
		}
		
		protected void enterPackage(String packageName) {
			indent(0);
			int pos = packageName.lastIndexOf('.');
			writer.println("<li>" + (pos >= 0 ? packageName.substring(pos + 1) : packageName));
			indent(1);
			writer.println("<ul>");
		}

		protected void exitPackage(String packageName) {
			indent(0);
			writer.println("</ul>");
			indent(-1);
			writer.println("</li>");
		}
		
		protected void visitResource(String packageName, String resourceName) {
			writer.println("<li>" + resourceName + "</li>");
		}
	}
	
	static String PROJECT_NAME_REQUEST_PARAMETER = "projectName";
	static String PACKAGE_NAME_REQUEST_PARAMETER = "packageName";
	static String RESOURCE_NAME_REQUEST_PARAMETER = "resourceName";

	public static ProjectRef getProjectRef(HttpServletRequest request) {
		return new ProjectRef(request.getParameter(PROJECT_NAME_REQUEST_PARAMETER));
	}

	public static ResourceRef getResourceRef(HttpServletRequest request) {
		return new ResourceRef(
				request.getParameter(PROJECT_NAME_REQUEST_PARAMETER),
				request.getParameter(PACKAGE_NAME_REQUEST_PARAMETER),
				request.getParameter(RESOURCE_NAME_REQUEST_PARAMETER)
				);
	}

	public static ResourceRef getResourceRef(ProjectRef projectRef, String resourcePath) {
		String[] segments = resourcePath.split("/");
		int count = segments.length;
		String resourceName = (count >= 1 ? segments[count - 1] : null);
		String packageName = (count >= 2 ? segments[count - 2] : null);
		return new ResourceRef(projectRef, packageName.replace('/', '.'), resourceName);
	}
	
	protected void writerResourcesResponse(String responseFormat, PrintWriter writer, ResourcesService resourcesService, ResourceRef resourceRef, int depth) throws ServletException, IOException {
		ResourceResponseWriter visitor = new ResourceResponseWriter(responseFormat, writer);
		resourcesService.visitResources(visitor, depth, resourceRef);
	}
}
