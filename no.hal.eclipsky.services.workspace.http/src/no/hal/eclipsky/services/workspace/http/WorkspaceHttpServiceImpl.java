package no.hal.eclipsky.services.workspace.http;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServlet;

import org.osgi.service.http.HttpService;

public class WorkspaceHttpServiceImpl {

	private HttpService httpService;
	
	public synchronized void setHttpService(HttpService httpService) {
		this.httpService = httpService;
	}
	
	private Collection<WorkspaceServiceServlet> workspaceServiceServlets = new ArrayList<WorkspaceServiceServlet>();
	
	public synchronized void addWorkspaceServiceServlet(WorkspaceServiceServlet workspaceServiceServlet) {
		try {
			String alias = workspaceServiceServlet.getAlias();
			if (alias != null) {
				alias = "/" + alias;
				System.out.println("Registering servlet alias: " + workspaceServiceServlet + " @ " + alias);
				httpService.registerServlet(alias, (HttpServlet) workspaceServiceServlet, null, null);
				workspaceServiceServlets.add(workspaceServiceServlet);
			}
			String[] resourceAliases = workspaceServiceServlet.getResourceAliases();
			if (resourceAliases != null) {
				for (int i = 0; i < resourceAliases.length; i += 2) {
					String resourceAlias = "/" + resourceAliases[i], resourceAliasValue = resourceAliases[i + 1];
					System.out.println("Registering resource alias: " + resourceAlias + " @ " + resourceAliasValue);
					httpService.registerResources(resourceAlias, resourceAliasValue, null);
				}
			}
		} catch (Exception e) {
		}
	}

	public synchronized void removeWorkspaceServiceServlet(WorkspaceServiceServlet workspaceServiceServlet) {
		workspaceServiceServlets.remove(workspaceServiceServlet);
		String alias = workspaceServiceServlet.getAlias();
		if (alias != null) {
			alias = "/" + alias;
			System.out.println("Unregistering alias: " + alias);
			httpService.unregister(alias);
		}
		String[] resourceAliases = workspaceServiceServlet.getResourceAliases();
		if (resourceAliases != null) {
			for (int i = 0; i < resourceAliases.length; i += 2) {
				String resourceAlias = "/" + resourceAliases[i];
				System.out.println("Unregistering alias: " + resourceAlias);
				httpService.unregister(resourceAlias);
			}
		}
	}
}
