package no.hal.eclipsky.services.mqttlogging;

import java.util.Dictionary;

import no.hal.eclipsky.services.monitoring.AbstractServiceLogger;
import no.hal.eclipsky.services.monitoring.ServiceLogger;

import org.eclipse.paho.client.mqttv3.MqttAsyncClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

@Component(
	property = MqttLogger.MQTT_SERVER_URI_KEY + "=" + MqttLogger.DEFAULT_MQTT_SERVER_URI
)
public class MqttLogger extends AbstractServiceLogger implements ServiceLogger {

	public final static String MQTT_SERVER_URI_KEY = "mqttServerUri";
	public final static String DEFAULT_MQTT_SERVER_URI = "tcp://iot.eclipse.org:1883";
	
	private String serverUri = null;
	
	@Activate
	protected void activate(ComponentContext context) {
		Dictionary<String, Object> properties = context.getProperties();
		Object serverUriValue = (properties != null ? properties.get(MQTT_SERVER_URI_KEY) : null);
		if (serverUriValue != null) {
			serverUri = String.valueOf(serverUriValue);
		}
	}

	@Deactivate
	protected void deactivate(ComponentContext context) {
		publishServiceUri(null);
	}

	private MqttAsyncClient mqttClient;

	private String clientId;
	
	protected String getClientId() {
		if (clientId == null) {
			clientId = getServiceUri().replaceAll("[^\\w]", "_");
		}
		return clientId;
	}
	
	public MqttAsyncClient getMqttClient() {
		if (mqttClient == null) {
			try {
				mqttClient = new MqttAsyncClient(serverUri, getClientId());
			} catch (MqttException e) {
				e.printStackTrace();
			}
		}
		if (mqttClient != null && (! mqttClient.isConnected())) {
			try {
				mqttClient.connect().waitForCompletion();
			} catch (MqttException e) {
				e.printStackTrace();
			}
		}
		return mqttClient;
	}

	public final static String MQTT_TOPIC_KEY_PREFIX = "no.hal.eclipsky.services.monitoring"; 
	
	protected String getTopicKey(String... logKeys) {
		StringBuilder builder = new StringBuilder(MQTT_TOPIC_KEY_PREFIX);
		builder.append("/");
		builder.append(getClientId());
		for (int i = 0; i < logKeys.length; i++) {
			builder.append("/");
			builder.append(logKeys[i]);
		}
		return builder.toString();
	}

	@Override
	public void setServiceUri(String serviceUri) {
		super.setServiceUri(serviceUri);
		publishServiceUri(getServiceUri());
	}

	protected void publishServiceUri(String serviceUri) {
		try {
			byte[] payload = serviceUri != null ? serviceUri.getBytes() : new byte[0];
			getMqttClient().publish(getTopicKey("serviceUri"), payload, 0, true);
		} catch (MqttException e) {
			e.printStackTrace();
		}
	}

	protected void log(byte[] payload, String... logKeys) throws MqttException, MqttPersistenceException {
		getMqttClient().publish(getTopicKey(logKeys), payload, 0, true);
//		System.out.println("Logging to topic " + getTopicKey(logKeys));
	}

	private String DEFAULT_LOG_PAYLOAD = "...";

	@Override
	protected void serviceCompleted(String logKey, String payload, long start, long end) {
		try {
			log((start + "-" + end).getBytes(), "services", logKey, "time");
			log((payload != null ? payload : DEFAULT_LOG_PAYLOAD).getBytes(), "services", logKey, "details");
		} catch (MqttException e) {
			e.printStackTrace();
		}
	}
}
