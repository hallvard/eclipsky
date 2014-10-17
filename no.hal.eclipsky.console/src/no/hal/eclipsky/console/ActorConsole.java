package no.hal.eclipsky.console;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Scanner;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class ActorConsole {

	public final static String defaultMessageClassNamePrefix = "no.hal.eclipsky.services.workspace.";

	public static void main(String[] args) {
		
		final ActorSystem system = ActorSystem.create("ConsoleSystem");
		String path = "akka.tcp://EclipskySystem@localhost:2552/user/workspaceActor";
		if (args.length >= 1) {
			path = args[0];
		}
		final ActorRef actor = system.actorOf(Props.create(ActorTester.class, path), "actorTester");
		
		Scanner scanner = new Scanner(System.in);
		System.out.println(">");
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			if (line.trim().length() == 0) {
				break;
			}
			try {
				Object message = parseMessage(line);
				actor.tell(new ActorTester.RemoteRequest(message), null);
			} catch (Exception e) {
				System.err.println(e);
			}
			System.out.println(">");
		}
		scanner.close();
	}

	private static Object parseMessage(String command) throws Exception {
		String[] commandAndArgs = command.split("\\s+");
		String className = commandAndArgs[0];
		Class<?> messageClass = null;
		try {
			messageClass = Class.forName(className);
		} catch (Exception e) {
			messageClass = Class.forName(defaultMessageClassNamePrefix + className);
		}
		Constructor<?> constructor = null;
		for (Constructor<?> cons : messageClass.getConstructors()) {
			if (cons.getParameterTypes().length == commandAndArgs.length - 1) {
				constructor = cons;
				break;
			}
		}
		Object[] messageArgs = new Object[commandAndArgs.length - 1];
		int argNum = 0;
		for (Class<?> argClass : constructor.getParameterTypes()) {
			Object messageArg = parseMessageArgument(argClass, commandAndArgs[argNum + 1]);
			messageArgs[argNum] = messageArg;
			argNum++;
		}
		Object message = constructor.newInstance(messageArgs);
		return message;
	}

	private static String[] EMPTY_STRING_ARRAY = new String[0];
	private static Class<?>[] SINGLE_STRING_CLASS_ARRAY = new Class[]{String.class};

	public static Object parseMessageArgument(Class<?> argClass, String s) {
		if ("null".equals(s)) {
			return null;
		} else if (argClass.isArray()) {
			if (s.startsWith("[") && s.endsWith("]")) {
				s = s.substring(1, s.length() - 1);
			}
			String[] elements = (s.length() == 0 ? EMPTY_STRING_ARRAY : s.split(","));
			Object array = Array.newInstance(argClass.getComponentType(), elements.length);
			for (int i = 0; i < elements.length; i++) {
				Array.set(array, i, parseMessageArgument(argClass.getComponentType(), elements[i]));
			}
			return array;
		}
		try {
			Method method = argClass.getMethod("valueOf", SINGLE_STRING_CLASS_ARRAY);
			Object value = method.invoke(null, s);
			return value;
		} catch (Exception e) {
			try {
				Constructor<?> cons = argClass.getConstructor(SINGLE_STRING_CLASS_ARRAY);
				Object value = cons.newInstance(s);
				return value;
			} catch (Exception e1) {
			}
		}
		return s;
	}
}
