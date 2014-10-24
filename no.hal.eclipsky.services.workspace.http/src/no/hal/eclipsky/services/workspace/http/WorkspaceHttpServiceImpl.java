package no.hal.eclipsky.services.workspace.http;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import no.hal.eclipsky.services.workspace.WorkspaceService;

import org.osgi.service.http.HttpService;
import org.osgi.service.http.NamespaceException;

public class WorkspaceHttpServiceImpl {

	private WorkspaceService workspaceService;
	private HttpService httpService;
	
	private Collection<String> httpServiceAliases = null;
	
	public synchronized void setWorkspaceService(WorkspaceService workspaceService) {
		this.workspaceService = workspaceService;
		handleWorkspaceHttpService();
	}
	public synchronized void unsetWorkspaceService() {
		setWorkspaceService(null);
	}

	public synchronized void setHttpService(HttpService httpService) {
		this.httpService = httpService;
		handleWorkspaceHttpService();
	}
	public synchronized void unsetHttpService() {
		setHttpService(null);
	}

	protected void handleWorkspaceHttpService() {
		if (httpServiceAliases == null && workspaceService != null && httpService != null) {
			httpServiceAliases = new ArrayList<String>();
			try {
				registerServlet(new ProjectListServlet(), "/projects");
				registerServlet(new ProjectResourceServlet(), "/resource");
				registerServlet(new SourceFileEditorServlet(), "/editor");
				registerServlet(new SourceFileMarkersServlet(), "/markers");
				httpService.registerResources("/ace", "/web/ace-builds/src-noconflict", null);
				httpService.registerResources("/editor", "/web/editor", null);
			} catch (Exception e) {
			}
		} else if (httpServiceAliases != null && workspaceService == null) {
			try {
				for (String alias : httpServiceAliases) {
					httpService.unregister(alias);
					httpService.unregister("/ace");
				}
			} catch (Exception e) {
			}
		}
	}

	protected void registerServlet(WorkspaceServiceServlet workspaceServiceServlet, String alias) throws ServletException, NamespaceException {
		workspaceServiceServlet.setWorkspaceService(workspaceService);
		registerServlet((HttpServlet) workspaceServiceServlet, alias);
	}

	protected void registerServlet(HttpServlet servlet, String alias) throws ServletException, NamespaceException {
		httpServiceAliases.add(alias);
		httpService.registerServlet(alias, servlet, null, null);
	}
}
