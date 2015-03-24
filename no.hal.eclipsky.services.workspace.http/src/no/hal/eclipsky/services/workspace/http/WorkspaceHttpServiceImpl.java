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
	
	private Collection<ServiceServlet> serviceServlets = new ArrayList<ServiceServlet>();
	
	public synchronized void addServiceServlet(ServiceServlet serviceServlet) {
		try {
			String alias = serviceServlet.getAlias();
			if (alias != null) {
				alias = "/" + alias;
				System.out.println("Registering servlet alias: " + serviceServlet + " @ " + alias);
				httpService.registerServlet(alias, (HttpServlet) serviceServlet, null, null);
				serviceServlets.add(serviceServlet);
			}
			String[] resourceAliases = serviceServlet.getResourceAliases();
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

	public synchronized void removeServiceServlet(ServiceServlet serviceServlet) {
		serviceServlets.remove(serviceServlet);
		String alias = serviceServlet.getAlias();
		if (alias != null) {
			alias = "/" + alias;
			System.out.println("Unregistering alias: " + alias);
			httpService.unregister(alias);
		}
		String[] resourceAliases = serviceServlet.getResourceAliases();
		if (resourceAliases != null) {
			for (int i = 0; i < resourceAliases.length; i += 2) {
				String resourceAlias = "/" + resourceAliases[i];
				System.out.println("Unregistering alias: " + resourceAlias);
				httpService.unregister(resourceAlias);
			}
		}
	}
}
