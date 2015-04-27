package no.hal.eclipsky.services.monitoring;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractServiceLogger implements ServiceLogger {

	private String serviceUri = null;
	
	public String getServiceUri() {
		return serviceUri;
	}
	
	@Override
	public void setServiceUri(String serviceUri) {
		this.serviceUri = serviceUri;
	}
	
	private Map<Object, RequestData> requestData;
	
	private static class RequestData {
		public final String logKey;
		public final long timestamp;
		public RequestData(String logKey, long timestamp) {
			this.logKey = logKey;
			this.timestamp = timestamp;
		}
	}
	
	@Override
	public void serviceRequested(Object requestKey, String logKey, long timestamp) {
		if (timestamp < 0) {
			timestamp = System.currentTimeMillis();
		}
		if (requestData == null) {
			requestData = new HashMap<Object, RequestData>();
		}
		requestData.put(requestKey, new RequestData(logKey, timestamp));
	}

	@Override
	public void serviceResponded(Object requestKey, String payload, long timestamp) {
		if (timestamp < 0) {
			timestamp = System.currentTimeMillis();
		}
		if (requestData != null) {
			RequestData data = requestData.get(requestKey);
			requestData.remove(requestKey);
			serviceCompleted(data.logKey, payload, data.timestamp, timestamp);
		}
	}

	protected abstract void serviceCompleted(String logKey, String payload, long start, long end);
}
