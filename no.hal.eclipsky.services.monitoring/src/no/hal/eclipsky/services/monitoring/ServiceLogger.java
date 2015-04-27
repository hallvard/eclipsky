package no.hal.eclipsky.services.monitoring;

public interface ServiceLogger {

	/**
	 * Sets the service Uri, typically host and address, that this logger logs for.
	 * @param serviceUri The service URI
	 */
	public void setServiceUri(String serviceUri);

	/**
	 * Notify that a request has been received and processing initiated
	 * @param requestKey the key that identifies the request, so it can be matched with the response
	 * @param logKey the key for the log entry
	 * @param timestamp the request receive time, or -1 to indicate it is now
	 */
	public void serviceRequested(Object requestKey, String logKey, long timestamp);

	/**
	 * Notify that a response for request has been computed
	 * @param requestKey the key that identifies the original request
	 * @param payload data to store in the log entry, may be null
	 * @param timestamp the time the response was ready, or -1 to indicate it is now
	 */
	public void serviceResponded(Object requestKey, String payload, long timestamp);
}
