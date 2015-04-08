package no.hal.eclipsky.services.workspace.http;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServlet;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.http.HttpService;

@Component
public class WorkspaceHttpServiceImpl {

	private HttpService httpService;
	
	@Reference
	public synchronized void setHttpService(HttpService httpService) {
		this.httpService = httpService;
	}
	
	private Collection<ServiceServlet> serviceServlets = new ArrayList<ServiceServlet>();
	
	@Reference(
		cardinality = ReferenceCardinality.MULTIPLE,
		policy = ReferencePolicy.DYNAMIC,
		unbind = "removeServiceServlet"
	)
	public synchronized void addServiceServlet(ServiceServlet serviceServlet) {
		try {
			String alias = serviceServlet.getAlias();
			if (alias != null) {
				if (! alias.startsWith("/")) {
					alias = "/" + alias;
				}
				httpService.registerServlet(alias, (HttpServlet) serviceServlet, null, null);
				serviceServlets.add(serviceServlet);
			}
			String[] resourceAliases = serviceServlet.getResourceAliases();
			if (resourceAliases != null) {
				for (int i = 0; i < resourceAliases.length; i += 2) {
					String resourceAlias = resourceAliases[i], resourceAliasValue = resourceAliases[i + 1];
					if (! resourceAlias.startsWith("/")) {
						resourceAlias = "/" + resourceAlias;
					}
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
			if (! alias.startsWith("/")) {
				alias = "/" + alias;
			}
			httpService.unregister(alias);
		}
		String[] resourceAliases = serviceServlet.getResourceAliases();
		if (resourceAliases != null) {
			for (int i = 0; i < resourceAliases.length; i += 2) {
				String resourceAlias = resourceAliases[i];
				if (! resourceAlias.startsWith("/")) {
					resourceAlias = "/" + resourceAlias;
				}
				httpService.unregister(resourceAlias);
			}
		}
	}
}
