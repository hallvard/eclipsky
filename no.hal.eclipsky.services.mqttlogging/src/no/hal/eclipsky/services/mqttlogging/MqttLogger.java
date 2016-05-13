package no.hal.eclipsky.services.mqttlogging;

import java.util.Dictionary;

import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttAsyncClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;

import no.hal.eclipsky.services.monitoring.AbstractServiceLogger;
import no.hal.eclipsky.services.monitoring.EclipskyInstance;
import no.hal.eclipsky.services.monitoring.ServiceLogger;

@Component(
	property = MqttLogger.MQTT_SERVER_URI_KEY + "=" + MqttLogger.DEFAULT_MQTT_SERVER_URI
)
public class MqttLogger extends AbstractServiceLogger implements ServiceLogger {

	public final static String MQTT_SERVER_URI_KEY = "mqttServerUri";
	public final static String DEFAULT_MQTT_SERVER_URI = "tcp://iot.eclipse.org:1883";

	@Reference(
		cardinality = ReferenceCardinality.MANDATORY,
		unbind="unsetEclipskyInstance"
	)
	public synchronized void setEclipskyInstance(EclipskyInstance eclipskyInstance) {
		super.setEclipskyInstance(eclipskyInstance);
	}
	
	public synchronized void unsetEclipskyInstance(EclipskyInstance eclipskyInstance) {
		super.unsetEclipskyInstance(eclipskyInstance);
	}

	private String serverUri = null;
	
	@Activate
	protected void activate(ComponentContext context) {
		Dictionary<String, Object> properties = context.getProperties();
		Object serverUriValue = (properties != null ? properties.get(MQTT_SERVER_URI_KEY) : null);
		if (serverUriValue != null) {
			serverUri = String.valueOf(serverUriValue);
		}
		publishServiceUri(getEclipskyInstance().getServiceUri());
	}

	@Deactivate
	protected void deactivate(ComponentContext context) {
		publishServiceUri(null);
	}

	private String clientId;
	
	protected String getClientId() {
		String serviceUri = getEclipskyInstance().getServiceUri();
		if (clientId == null) {
			clientId = (serviceUri != null ? serviceUri : this.getClass().getName())
						.replaceAll("[^\\w]", "_");
		}
		return clientId;
	}

	private MqttAsyncClient mqttClient;
	
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
				IMqttToken connectToken = mqttClient.connect();
//				connectToken.setActionCallback(new IMqttActionListener() {
//					@Override
//					public void onSuccess(IMqttToken arg0) {
//						System.out.println("Connection success!");
//						System.out.flush();
//					}
//					@Override
//					public void onFailure(IMqttToken arg0, Throwable arg1) {
//						System.out.println("Connection failed!");
//						System.out.flush();
//					}
//				});
				connectToken.waitForCompletion();
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

	protected void publishServiceUri(String serviceUri) {
		try {
			byte[] payload = null;
			if (serviceUri != null) {
				String message = serviceUri + "@" + formatTimestamp();
				payload = message.getBytes();
			}
//			IMqttDeliveryToken publishToken =
			String topicKey = getTopicKey("serviceUri");
			getMqttClient().publish(topicKey, (payload != null ? payload : new byte[0]), 0, true);
//			publishToken.setActionCallback(new IMqttActionListener() {
//				@Override
//				public void onSuccess(IMqttToken arg0) {
//					System.out.println("publish (ServiceUri) success!");
//					System.out.flush();
//				}
//				@Override
//				public void onFailure(IMqttToken arg0, Throwable arg1) {
//					System.out.println("publish (ServiceUri) failed!");
//					System.out.flush();
//				}
//			});
		} catch (MqttException e) {
			e.printStackTrace();
		}
	}

	protected void log(byte[] payload, String... logKeys) throws MqttException, MqttPersistenceException {
		String topicKey = getTopicKey(logKeys);
		getMqttClient().publish(topicKey, payload, 0, true);
//		System.out.println("Logging to topic " + getTopicKey(logKeys));
	}

	private String DEFAULT_LOG_PAYLOAD = "...";

	public final static String LOG_ITEM_TIME_KEY = "time";

	@Override
	protected void serviceCompleted(String logKey, String payload, long start, long end) {
		try {
			log(formatTimestampInterval(start, end).getBytes(), "services", logKey, LOG_ITEM_TIME_KEY);
			log((payload != null ? payload : DEFAULT_LOG_PAYLOAD).getBytes(), "services", logKey, "details");
		} catch (MqttException e) {
			e.printStackTrace();
		}
	}
}
