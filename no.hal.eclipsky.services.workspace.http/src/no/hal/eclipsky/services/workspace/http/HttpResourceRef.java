package no.hal.eclipsky.services.workspace.http;

import javax.servlet.http.HttpServletRequest;

import no.hal.eclipsky.services.common.ResourceRef;

public class HttpResourceRef extends ResourceRef {

	private static String get(HttpServletRequest request, String parameterName, int pathElementNum) {
		String param = request.getParameter(parameterName);
		if (param == null) {
			String[] elements = request.getPathTranslated().split("/");
			if (pathElementNum < elements.length) {
				param = elements[pathElementNum];
			}
		}
		return param;
	}
	
	public HttpResourceRef(HttpServletRequest request) {
		super(get(request, "projectName", 0), get(request, "packageName", 1), get(request, "resourceName", 2));
	}
}
