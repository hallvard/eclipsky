package no.hal.eclipsky.console;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;

import scala.concurrent.duration.Duration;
import akka.actor.ActorIdentity;
import akka.actor.ActorRef;
import akka.actor.Identify;
import akka.actor.ReceiveTimeout;
import akka.actor.UntypedActor;

public class ActorTester extends UntypedActor {

	public ActorTester(String path) {
		getContext().actorSelection(path).tell(new Identify(path), getSelf());
		getContext().system().scheduler().scheduleOnce(Duration.create(3, TimeUnit.SECONDS), getSelf(),
				ReceiveTimeout.getInstance(), getContext().dispatcher(), getSelf());
	}

	private ActorRef remote = null;

	public ActorRef getRemote() {
		return remote;
	}
	
	static class RemoteRequest {
		private final Object message;
		public RemoteRequest(Object message) {
			this.message = message;
		}
	}
	
	@Override
	public void onReceive(Object message) throws Exception {
		if (message instanceof ActorIdentity) {
			remote = ((ActorIdentity) message).getRef();
			System.out.println("Remote system: " + remote);
		} else if (message instanceof RemoteRequest) {
			remote.tell(((RemoteRequest) message).message, getSelf());
		} else {
			System.out.println("< " + uparseMessage(message));
		}
	}
	
	public static String uparseMessage(Object message) throws Exception {
		StringBuilder buffer = new StringBuilder();
		try {
			Class<?> messageClass = message.getClass();
			buffer.append(messageClass.getSimpleName());
			for (Field field : messageClass.getFields()) {
				buffer.append(" ");
				buffer.append(field.getName());
				buffer.append("=");
				Object value = field.get(message);
				if (value == null) {
					buffer.append("null");
				} else if (field.getType().isArray()) {
					buffer.append("[");
					for (int i = 0; i < Array.getLength(value); i++) {
						if (i > 0) {
							buffer.append(",");
						}
						buffer.append(String.valueOf(Array.get(value, i)));
					}
					buffer.append("]");
				} else {
					buffer.append(String.valueOf(value));
				}
			}
		} catch (Exception e) {
		}
		return buffer.toString();
	}
}
