package no.hal.eclipsky.services.sourceeditor;

import no.hal.eclipsky.services.common.ResourceRef;
import no.hal.eclipsky.services.workspace.http.util.ResponseOptions;

public interface SourceEditorServlet {

	public CharSequence invokeEditorServiceOperation(EditorServiceRequest request, String requestBody);

	public static class EditorServiceRequest {
		public String op;
		public ResourceRef resourceRef;
		public ResponseOptions responseOptions;

		private EditorServiceRequest(String op, ResourceRef resourceRef) {
			this.op = op;
			this.resourceRef = resourceRef;
		}
		
		public EditorServiceRequest(String op, ResourceRef resourceRef, ResponseOptions responseOptions) {
			this(op, resourceRef);
			this.responseOptions = responseOptions;
		}
		
		public EditorServiceRequest(String op, ResourceRef resourceRef, String responseFormat) {
			this(op, resourceRef);
			ResponseOptions responseOptions = new ResponseOptions();
			responseOptions.responseFormat = responseFormat;
			this.responseOptions = responseOptions;
		}
	}
}
