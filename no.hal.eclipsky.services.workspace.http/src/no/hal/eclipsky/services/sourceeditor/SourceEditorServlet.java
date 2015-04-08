package no.hal.eclipsky.services.sourceeditor;

import no.hal.eclipsky.services.common.ResourceRef;

public interface SourceEditorServlet {

	public CharSequence invokeEditorServiceOperation(EditorServiceRequest request, String requestBody);

	public static class EditorServiceRequest {
		public String op;
		public ResourceRef resourceRef;
		public String responseFormat;

		public EditorServiceRequest(String op, ResourceRef resourceRef, String responseFormat) {
			this.op = op;
			this.resourceRef = resourceRef;
			this.responseFormat = responseFormat;
		}
	}
}
