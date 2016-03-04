package no.hal.eclipsky.services.sourceeditor;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hal.eclipsky.services.common.ProjectRef;
import no.hal.eclipsky.services.common.ResourceRef;
import no.hal.eclipsky.services.monitoring.CompositeServiceLogger;
import no.hal.eclipsky.services.monitoring.ServiceLogger;
import no.hal.eclipsky.services.workspace.http.AbstractServiceServlet;
import no.hal.eclipsky.services.workspace.http.AceEditorHelper;
import no.hal.eclipsky.services.workspace.http.SourceProjectManager;
import no.hal.eclipsky.services.workspace.http.util.EmfsUtil;
import no.hal.eclipsky.services.workspace.http.util.ResponseFormatter;
import no.hal.emfs.EmfsResource;

import org.eclipse.jetty.websocket.servlet.WebSocketServlet;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.http.HttpService;

@Component(
	immediate = true,
	property = AbstractServiceServlet.SERVLET_ALIAS_KEY + "=sourceEditor"
)
@SuppressWarnings("serial")
public class SourceEditorServletImpl extends WebSocketServlet implements SourceEditorServlet {

	private HttpService httpService;
	
	@Reference
	public synchronized void setHttpService(HttpService httpService) {
		this.httpService = httpService;
	}

	private SourceProjectManager sourceProjectManager;
	
	@Reference
	public synchronized void setSourceProjectManager(SourceProjectManager sourceProjectManager) {
		this.sourceProjectManager = sourceProjectManager;
	}

	private Map<String, SourceEditorServletService> editorServices = new HashMap<>();
	
	@Reference(
		cardinality = ReferenceCardinality.MULTIPLE,
		policy = ReferencePolicy.DYNAMIC,
		unbind = "removeServiceServlet"
	)
	public synchronized void addSourceEditorServletService(SourceEditorServletService editorService) {
		String[] operations = editorService.getSupportedOperations();
		for (String op : operations) {
			editorServices.put(op, editorService);
		}
	}

	public synchronized void removeServiceServlet(SourceEditorServletService editorService) {
		String[] operations = editorService.getSupportedOperations();
		for (String op : operations) {
			editorServices.remove(op);
		}
	}



	private final CompositeServiceLogger compositeServiceLogger = new CompositeServiceLogger();
	
	@Reference(
		cardinality = ReferenceCardinality.MULTIPLE,
		unbind="removeServiceLogger"
	)
	public synchronized void addServiceLogger(ServiceLogger serviceLogger) {
		compositeServiceLogger.addServiceLogger(serviceLogger);
	}
	
	public synchronized void removeServiceLogger(ServiceLogger serviceLogger) {
		compositeServiceLogger.removeServiceLogger(serviceLogger);
	}

	@Activate
	protected void activate() {
		try {
			httpService.registerServlet("/sourceEditor", (HttpServlet) this, null, null);
			httpService.registerResources("/ace", "/web/ace-builds/src-noconflict", null);
			httpService.registerResources("/js", "/web/js", null);
			httpService.registerResources("/css", "/web/css", null);
			httpService.registerResources("/img", "/web/img", null);
			httpService.registerResources("/sourceEditorForm.html", "/web/html/sourceEditorForm.html", null);
		} catch (Exception e) {
		}
	}

	@Deactivate
	protected void deactivate() {
		try {
			httpService.unregister("/sourceEditor");
			httpService.unregister("/ace");
			httpService.unregister("/js");
			httpService.unregister("/img");
			httpService.unregister("/sourceEditorForm.html");
		} catch (Exception e) {
		}
	}
	
	private AceEditorHelper aceEditorHelper = new AceEditorHelper();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ResourceRef resourceRef = AbstractServiceServlet.getResourceRef(request);
		boolean embed = Boolean.valueOf(request.getParameter("embed"));
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		AceEditorHelper.Options options = new AceEditorHelper.Options();
		options.requestUrl = request.getRequestURI();
		options.projectId = resourceRef.getProjectName();
		Collection<ResourceRef> emfsResources = EmfsUtil.collectResources(sourceProjectManager.getEmfsResource(new ProjectRef(resourceRef)), EmfsResource::isWriteable);
		ResourceRef[] editables = emfsResources.toArray(new ResourceRef[emfsResources.size()]);
		options.editorName = (editables != null && editables.length > 0 ? editables[0].getResourceName() : options.projectId);
		options.resourceRefs = editables;
		options.embed = embed;
		
		String index = request.getParameter("startIndex");
		if (index == null) {
			options.startIndex = 0;
		} else {
			options.startIndex = Integer.parseInt(index);
		}
		aceEditorHelper.writeEditorHtml(writer, options);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		if (op == null) {
			op = "refresh";
		}
		PrintWriter writer = response.getWriter();
		doEditorServiceOperation(op, request, writer);
	}

	protected void doEditorServiceOperation(String op, HttpServletRequest request, PrintWriter writer) {
		ResourceRef resourceRef = AbstractServiceServlet.getResourceRef(request);
		EditorServiceRequest editorServiceRequest = new EditorServiceRequest(op, resourceRef, AbstractServiceServlet.getResponseFormat(request));
		try {
			CharSequence response = invokeEditorServiceOperation(editorServiceRequest, request.getParameter("body"));
			writer.print(response);
		} catch (Exception e) {
			AbstractServiceServlet.writeExceptionResponse("html", writer, e);
		}
	}
	
	private final static String EMPTY_EDITOR_SERVLET_SERVICE_RESPONSE = "[]";

	public CharSequence invokeEditorServiceOperation(EditorServiceRequest request, String requestBody) {
		SourceEditorServletService editorService = editorServices.get(request.op);
		CharSequence response = null;
		if (editorService != null) {
			compositeServiceLogger.serviceRequested(request, request.op, -1);
			try {
				response = editorService.doSourceEditorServletService(request, requestBody);
				compositeServiceLogger.serviceResponded(request, request.resourceRef.toPath(), -1);
			} catch (Exception e) {
				compositeServiceLogger.serviceException(request, e, -1);
				throw e;
			}
		}
		if (response == null || response.length() == 0) {
			response = EMPTY_EDITOR_SERVLET_SERVICE_RESPONSE;
		}
		return response;
	}
	


	@Override
	public void configure(WebSocketServletFactory factory) {
		factory.setCreator(new EditorWebSocketCreator(this));
	}


}
