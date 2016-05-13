package no.hal.eclipsky.services.workspace.http;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServlet;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.http.HttpService;

import no.hal.eclipsky.services.monitoring.CompositeServiceLogger;
import no.hal.eclipsky.services.monitoring.EclipskyInstance;
import no.hal.eclipsky.services.monitoring.ServiceLogger;

@Component
public class WorkspaceHttpServiceImpl {

	private HttpService httpService;
	
	@Reference
	public synchronized void setHttpService(HttpService httpService) {
		this.httpService = httpService;
	}
	public synchronized void unsetHttpService(HttpService httpService) {
		setHttpService(null);
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

	private EclipskyInstance eclipskyInstance;
	
	public EclipskyInstance getEclipskyInstance() {
		if (eclipskyInstance == null) {
			eclipskyInstance = new EclipskyInstance();
			try {
				eclipskyInstance.setInstanceName(InetAddress.getLocalHost().getHostName().replace(".", "_"));
				eclipskyInstance.setHostAddress(InetAddress.getLocalHost().getHostAddress());
			} catch (UnknownHostException e) {
			}
		}
		return eclipskyInstance;
	}

	@Activate
	protected void activate(ComponentContext context) {
		BundleContext bundleContext = context.getBundleContext();
		ServiceReference<HttpService> httpServiceRef = bundleContext.getServiceReference(HttpService.class);
		Object portProperty = httpServiceRef.getProperty("org.osgi.service.http.port");
		if (portProperty == null) {
			portProperty = httpServiceRef.getProperty("http.port");
		}
		EclipskyInstance eclipskyInstance = getEclipskyInstance();
		eclipskyInstance.setServiceUri("http://" + eclipskyInstance.getHostAddress() + ":" + portProperty);
		bundleContext.registerService(EclipskyInstance.class, eclipskyInstance, null);
	}
}
