package no.hal.eclipsky.services.workspace.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hal.eclipsky.services.workspace.SourceFileMarker;

@SuppressWarnings("serial")
public class SourceFileEditorServlet extends SourceFileMarkersServlet {
		/*
		<html lang="en">
		<head>
		<title>ACE in Action</title>
		<style type="text/css" media="screen">
		    #editor { 
		        position: absolute;
		        top: 0;
		        right: 0;
		        bottom: 0;
		        left: 0;
		    }
		</style>
		</head>
		<body>

		<div id="editor">function foo(items) {
		    var x = "All this is syntax highlighted";
		    return x;
		}</div>
		    
		<script src="/ace-builds/src-noconflict/ace.js" type="text/javascript" charset="utf-8"></script>
		<script>
		    var editor = ace.edit("editor");
		    editor.setTheme("ace/theme/monokai");
		    editor.getSession().setMode("ace/mode/javascript");
		</script>
		</body>
		</html>
		*/
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String projectName = request.getParameter("projectName");
		String packageName = request.getParameter("packageName");
		String resourceName = request.getParameter("resourceName");
		String stringContent = getWorkspaceService().getSourceFile(projectName, packageName, resourceName);
		if (stringContent == null) {
			super.doGet(request, response);
		} else {
			response.setContentType("text/html");
			PrintWriter writer = response.getWriter();
			writer.print("<html lang=\"en\">\n" +
		"\t<head><title>" + resourceName + "</title>\n" +
		"\t\t<style type=\"text/css\" media=\"screen\">#editor { position: absolute; top: 0; right: 0; bottom: 0; left: 0;}</style>\n" +
		"\t</head>\n" +
		"\t<body>\n" +
		"\t\t<div id=\"editor\">");
			writer.print(XmlResponseFormatter.escapeHtml(stringContent));
			writer.println("</div>\n" +
		"\t\t\t<script src=\"/ace/ace.js\" type=\"text/javascript\" charset=\"utf-8\"></script>\n" +
		"\t\t<script>\n" +
		    "\t\tvar editor = ace.edit(\"editor\");\n" +
		    "\t\teditor.setTheme(\"ace/theme/monokai\");\n" +
		    
			"\t\teditor.commands.addCommand({ name: 'save', bindKey: {win: 'Ctrl-S', mac: 'Command-S'}, readOnly: false, \n" +
			"\t\texec: function(editor) {\n" +
				"\t\t\tvar xmlHttp = new XMLHttpRequest();\n" +
				"\t\t\tvar url = window.location;\n" +
				"\t\t\t// var parameters = url.search.substring(1) + \"&content=\" + editor.getValue();\n" +
				"\t\t\tvar urlString = url.href;\n" +
				"\t\t\tvar requestUrl = urlString; // .substring(0, urlString.indexOf('?'));\n" +
				"\t\t\tvar ok = true; // window.confirm(requestUrl);\n" +
				"\t\t\tif (ok == true) {\n" +
				"\t\t\txmlHttp.open(\"POST\", requestUrl, true);\n" +
				"\t\t\t}\n" +
				"\t\t\txmlHttp.send(editor.getValue());\n" +
				"\t\t\t}\n" +
			"\t\t});\n"); 
			writer.println("\t\teditor.getSession().setMode(\"ace/mode/" + getEditorMode(resourceName) + "\");\n");
			writer.println("\t\t</script>\n" +
		"\t</body>\n" +
		"</html>\n");
		}
	}

	protected String getEditorMode(String resourceName) {
		int pos = resourceName.lastIndexOf('.');
		String ext = pos < 0 ? resourceName : resourceName.substring(pos + 1);
		switch (ext) {
		case "py": return "python";
		case "js": return "javascript";
		default: return ext;
		}
	}

	protected void updateSourceFile(HttpServletRequest request, HttpServletResponse response, Boolean exists, Boolean markers) throws ServletException, IOException {
		String projectName = request.getParameter("projectName");
		String packageName = request.getParameter("packageName");
		String resourceName = request.getParameter("resourceName");
		StringBuilder body = new StringBuilder(request.getContentLength());
		BufferedReader reader = request.getReader();
		String line = null;
		while ((line = reader.readLine()) != null) {
			body.append(line);
			body.append("\n");
		}
		String stringContent = body.toString();
		if (stringContent == null) {
			super.doPost(request, response);
		} else {
			String responseFormat = getResponseFormat(request);
			response.setContentType("text/" + ("html".equals(responseFormat) ? "html" : "plain"));
			SourceFileMarker[] sourceFileMarkers = getWorkspaceService().updateSourceFile(projectName, packageName, resourceName, stringContent, exists, markers);
			writeResponse(responseFormat, new PrintWriter(System.out), sourceFileMarkers);
			writeResponse(responseFormat, response.getWriter(), sourceFileMarkers);
		}
	}

	protected Boolean markersDefault = true;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		updateSourceFile(request, response, true, markersDefault);
	}
	
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		updateSourceFile(request, response, false, markersDefault);
	}
}
