package no.hal.eclipsky.services.workspace.http;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServlet;

import no.hal.eclipsky.services.monitoring.CompositeServiceLogger;
import no.hal.eclipsky.services.monitoring.ServiceLogger;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
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

	private final CompositeServiceLogger compositeServiceLogger = new CompositeServiceLogger();
	
	@Reference(
		cardinality = ReferenceCardinality.MULTIPLE,
		policy = ReferencePolicy.DYNAMIC,
		unbind="removeServiceLogger"
	)
	public synchronized void addServiceLogger(ServiceLogger serviceLogger) {
		compositeServiceLogger.addServiceLogger(serviceLogger);
	}
	
	public synchronized void removeServiceLogger(ServiceLogger serviceLogger) {
		compositeServiceLogger.removeServiceLogger(serviceLogger);
	}
	
	@Activate
	protected void activate(ComponentContext context) {
		BundleContext bundleContext = context.getBundleContext();
		ServiceReference<HttpService> httpServiceRef = bundleContext.getServiceReference(HttpService.class);
		Object property = httpServiceRef.getProperty("org.osgi.service.http.port");
		if (property == null) {
			property = httpServiceRef.getProperty("http.port");
		}
		try {
			InetAddress localHost = InetAddress.getLocalHost();
			compositeServiceLogger.setServiceUri("http://" + localHost.getHostAddress() + ":" + property);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
