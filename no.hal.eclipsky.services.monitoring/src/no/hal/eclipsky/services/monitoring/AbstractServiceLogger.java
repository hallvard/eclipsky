package no.hal.eclipsky.services.monitoring;

import java.util.Date;
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
		public final long start;
		public long end;
		public RequestData(String logKey, long timestamp) {
			this.logKey = logKey;
			this.start = timestamp;
		}
	}
	
	protected String formatTimestamp(long timestamp) {
		return timestamp + "(" + new Date(timestamp) + ")";
	}
	protected String formatTimestamp() {
		return formatTimestamp(System.currentTimeMillis());
	}

	protected String formatTimestampInterval(long start, long end) {
		return start + "+" + (end - start) + "=" + end + "(" + new Date(start) + ")";
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

	private RequestData popRequestData(Object requestKey, long timestamp) {
		if (requestData != null) {
			RequestData data = requestData.get(requestKey);
			requestData.remove(requestKey);
			data.end = (timestamp >= 0 ? timestamp : System.currentTimeMillis());
			return data;
		}
		return null;
	}
	
	@Override
	public void serviceResponded(Object requestKey, String payload, long timestamp) {
		RequestData data = popRequestData(requestKey, timestamp);
		if (data != null) {
			serviceCompleted(data.logKey, payload, data.start, data.end);
		}
	}

	@Override
	public void serviceException(Object requestKey, Throwable e, long timestamp) {
		RequestData data = popRequestData(requestKey, timestamp);
		if (data != null) {
			serviceException(data.logKey, e, data.start, data.end);
		}
	}

	protected abstract void serviceCompleted(String logKey, String payload, long start, long end);

	protected void serviceException(String logKey, Throwable e, long start, long end) {
		serviceCompleted(logKey, e.getMessage(), start, end);
	}
}
