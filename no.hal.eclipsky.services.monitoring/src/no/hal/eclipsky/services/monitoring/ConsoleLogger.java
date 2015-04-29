package no.hal.eclipsky.services.monitoring;

import org.osgi.service.component.annotations.Component;

@Component
public class ConsoleLogger extends AbstractServiceLogger implements ServiceLogger {

	private int maxPayloadLength = -1;

	@Override
	protected void serviceCompleted(String logKey, String payload, long start, long end) {
		System.out.print(logKey + " service completed in " + (end - start) + "ms");
		if (payload != null) {
			if (maxPayloadLength >= 0 && payload.length() > maxPayloadLength) {
				payload = payload.substring(0, maxPayloadLength) + "...";
			}
			System.out.print(": " + payload);
		}
		System.out.println();
	}

	@Override
	protected void serviceException(String logKey, Throwable e, long start, long end) {
		System.out.print(logKey + " service exception after " + (end - start) + "ms");
		if (e != null) {
			System.out.print(": " + e);
		}
		System.out.println();
	}
}
