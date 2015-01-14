package no.hal.eclipsky.services.workspace.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Dictionary;
import java.util.Enumeration;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.ComponentContext;

import no.hal.eclipsky.services.common.ResourceRef;
import no.hal.eclipsky.services.workspace.WorkspaceService;

@SuppressWarnings("serial")
public abstract class AbstractWorkspaceServiceServlet extends HttpServlet implements WorkspaceServiceServlet {

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

	private WorkspaceService workspaceService;

	protected WorkspaceService getWorkspaceService() {
		return workspaceService;
	}

	public synchronized void setWorkspaceService(WorkspaceService workspaceService) {
		this.workspaceService = workspaceService;
	}

	public static ResourceRef getResourceRef(HttpServletRequest request) {
		return new HttpResourceRef(request);
	}
	
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
	
	protected static ResponseFormatter getResponseFormatter(String responseFormat, PrintWriter writer) {
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
}
