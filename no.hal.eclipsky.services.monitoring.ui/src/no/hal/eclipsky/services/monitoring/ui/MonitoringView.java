package no.hal.eclipsky.services.monitoring.ui;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttAsyncClient;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;

import no.hal.eclipsky.services.monitoring.AbstractServiceLogger;
import no.hal.eclipsky.services.monitoring.EclipskyInstance;
import no.hal.eclipsky.services.mqttlogging.MqttLogger;
import no.hal.emf.ui.utils.TextPromptHelper;

public class MonitoringView extends ViewPart implements MqttCallback {

	private List<EclipskyInstance> instances = new ArrayList<EclipskyInstance>();
	
	private TabFolder tabs;
	private TabItem summaryTab;
	
	@Override
	public void createPartControl(Composite composite) {
		composite.setLayout(new GridLayout(1, false));
		Composite hostComposite = new Composite(composite, SWT.NONE);
		hostComposite.setLayoutData(new GridData(SWT.LEFT,  SWT.CENTER, true, false));
		hostComposite.setLayout(new FillLayout());
		final Text loggingHostText = new Text(hostComposite, SWT.NONE);
		loggingHostText.setText(MqttLogger.DEFAULT_MQTT_SERVER_URI);
		new TextPromptHelper(loggingHostText, "<logging uri: protocol://host:port>");
		Button loggingConnectButton = new Button(hostComposite, SWT.NONE);
		loggingConnectButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				connect(loggingHostText.getText());
			}
		});
		tabs = new TabFolder(composite, SWT.HORIZONTAL);
		summaryTab = new TabItem(tabs, SWT.NONE);
		summaryTab.setControl(createSummaryControl(tabs));
	}

	protected Control createSummaryControl(Composite composite) {
		Composite summary = new Composite(composite, SWT.NONE);
		return summary;
	}

	protected EclipskyInstance findEclipskyInstance(String instanceKey) {
		for (EclipskyInstance instance : instances) {
			if (instanceKey.equals(instance.getInstanceName())) {
				return instance;
			}
		}
		return null;
	}

	protected void addEclipskyInstance(EclipskyInstance instance) {
		TabItem tab = new TabItem(tabs, SWT.NONE);
		tab.setControl(createInstanceControl(instance, tabs));
		tab.setText(instance.getInstanceName());
		tab.setToolTipText(instance.getHostAddress());
	}

	protected <T extends Control> T getChildControl(Composite parent, Class<T> clazz, int num, boolean create) {
		for (Control control : parent.getChildren()) {
			if (clazz.isInstance(control)) {
				if (num == 0) {
					return (T) control;
				}
				num--;
			}
		}
		if (create) {
			try {
				T t = clazz.getConstructor(new Class[]{Composite.class, Integer.TYPE}).newInstance(new Object[]{parent, SWT.NONE});
				return t;
			} catch (Exception e) {
			}
		}
		return null;
	}

	protected Control createInstanceControl(EclipskyInstance instance, Composite composite) {
		Composite instanceComposite = new Composite(composite, SWT.NONE);
		// TODO
		updateView(instance, instanceComposite);
		return instanceComposite;
	}

	protected void updateView(EclipskyInstance instance) {
		TabItem tab = tabs.getItem(instances.indexOf(instance));
		if (tab != null) {
			updateView(instance, tab.getControl());
		}
	}

	protected void updateView(EclipskyInstance instance, Control control) {
		// TODO
	}

	private MqttAsyncClient mqttClient;
	
	protected void connect(String loggingHost) {
		if (mqttClient == null) {
			try {
				if (loggingHost == null || loggingHost.trim().length() == 0) {
					loggingHost = MqttLogger.DEFAULT_MQTT_SERVER_URI;
				}
				mqttClient = new MqttAsyncClient(loggingHost, MqttAsyncClient.generateClientId());
				mqttClient.setCallback(this);
			} catch (MqttException e) {
				e.printStackTrace();
			}
		}
		if (mqttClient != null && (! mqttClient.isConnected())) {
			try {
				IMqttToken connectToken = mqttClient.connect();
				connectToken.waitForCompletion();
				mqttClient.subscribe(MqttLogger.MQTT_TOPIC_KEY_PREFIX, 0);
			} catch (MqttException e) {
				e.printStackTrace();
			}
		}
	}

	public MqttAsyncClient getMqttClient() {
		if (! mqttClient.isConnected()) {
			connect(null);
		}
		return mqttClient;
	}

	@Override
	public void setFocus() {
		summaryTab.getControl().setFocus();
	}

	//

	private class LogItem {
		String key;
		long start, end, duration;
		String details;
	}
	
	@Override
	public void connectionLost(Throwable arg0) {
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken arg0) {
	}

	private Map<EclipskyInstance, Collection<LogItem>> logItems = new HashMap<EclipskyInstance, Collection<LogItem>>();
	
	@Override
	public void messageArrived(String topic, MqttMessage message) throws Exception {
		String[] segments = topic.split("\\\\");
		String payload = new String(message.getPayload());
		LogItem logItem = new LogItem();
		logItem.key = segments[segments.length - 2];
		if (MqttLogger.LOG_ITEM_TIME_KEY.equals(segments[segments.length - 1])) {
			long[] timeItems = AbstractServiceLogger.decodeTimestampInterval(payload);
			logItem.start = timeItems[0];
			logItem.end = timeItems[1];
			logItem.duration = timeItems[2];
		}
		EclipskyInstance instance = findEclipskyInstance(segments[1]);
		if (instance != null) {
			Collection<LogItem> logItems = this.logItems.get(instance);
			if (logItems == null) {
				logItems = new ArrayList<MonitoringView.LogItem>();
				this.logItems.put(instance, logItems);
			}
			logItems.add(logItem);
			updateView(instance);
		}
		message.getPayload();
	}
}
