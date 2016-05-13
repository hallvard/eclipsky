package no.hal.eclipsky.services.monitoring;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractServiceLogger implements ServiceLogger {

	private EclipskyInstance eclipskyInstance;
	
	public EclipskyInstance getEclipskyInstance() {
		return eclipskyInstance;
	}

	protected synchronized void setEclipskyInstance(EclipskyInstance eclipskyInstance) {
		this.eclipskyInstance = eclipskyInstance;
	}
	
	protected synchronized void unsetEclipskyInstance(EclipskyInstance eclipskyInstance) {
		this.eclipskyInstance = null;
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

	public static String formatTimestamp(long timestamp) {
		return String.format("%d(%s)", timestamp, new Date(timestamp));
	}
	public static String formatTimestamp() {
		return formatTimestamp(System.currentTimeMillis());
	}
	
	private static Pattern timestampPattern = Pattern.compile("(\\d+)\\((.+)\\)");
	
	public static long decodeTimestamp(String formatted) {
		Matcher matcher = timestampPattern.matcher(formatted);
		if (matcher.matches()) {
			long start = Long.valueOf(matcher.group(1));
			return start;
		}
		return -1;
	}

	public static String formatTimestampInterval(long start, long end) {
		return String.format("%d+%d=%d(%s)", start, (end - start), end, new Date(start));
	}

	private static Pattern timestampIntervalPattern = Pattern.compile("(\\d+)\\+(\\d)\\=\\((.+)\\)");

	public static long[] decodeTimestampInterval(String formatted) {
		Matcher matcher = timestampIntervalPattern.matcher(formatted);
		if (matcher.matches()) {
			long start = Long.valueOf(matcher.group(1));
			long duration = Long.valueOf(matcher.group(2));
			long end = Long.valueOf(matcher.group(3));
			return new long[]{start, end, duration};
		}
		return null;
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
