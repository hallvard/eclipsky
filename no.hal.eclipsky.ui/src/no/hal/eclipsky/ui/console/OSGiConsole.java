package no.hal.eclipsky.ui.console;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import no.hal.eclipsky.ui.Activator;

import org.eclipse.osgi.framework.console.ConsoleSession;
import org.eclipse.ui.console.IOConsole;
import org.eclipse.ui.console.IOConsoleOutputStream;
import org.osgi.framework.BundleContext;

/**
 * OSGi console connected to the Host/Running Eclipse.
 * 
 * @since 3.6
 */

public class OSGiConsole extends IOConsole {

	public final static String TYPE = "osgiConsole"; //$NON-NLS-1$
	private final ConsoleSession session;

	public OSGiConsole(final OSGiConsoleFactory factory) {
		super("OSGI Console", TYPE, null, true);
		session = new ConsoleSession() {

			public OutputStream getOutput() {
				return newOutputStream();
			}

			public InputStream getInput() {
				return getInputStream();
			}

			protected void doClose() {
				factory.closeConsole(OSGiConsole.this);
			}
		};
	}

	protected void init() {
		super.init();
		IOConsoleOutputStream info = newOutputStream(); // create a stream to write info message to
		try {
			info.write("OSGi Console");
			info.write('\n');
		} catch (IOException e) {
		} finally {
			try {
				info.close();
			} catch (IOException e) {
			}
		}
		BundleContext context = Activator.getBundleContext();
		context.registerService(ConsoleSession.class.getName(), session, null);
	}

	protected void dispose() {
		super.dispose();
	}
}
