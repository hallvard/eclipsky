package no.hal.eclipsky.services.workspace.akka;

import org.osgi.framework.BundleContext;

import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.osgi.ActorSystemActivator;

public class Activator extends ActorSystemActivator {
	
	private ActorSystem actorSystem;
	
	private Activator plugin = null;

	public Activator getPlugin() {
		return plugin;
	}

	@Override
	public void start(BundleContext context) {
		super.start(context);
		plugin = this;
	}
	
	@Override
	public void stop(BundleContext context) {
		plugin = null;
		super.stop(context);
	}
	
	@Override
	public String getActorSystemName(BundleContext context) {
		return "EclipskySystem";
	}
	
	@Override
	public void configure(BundleContext context, ActorSystem system) {
		registerService(context, system);
		actorSystem = system;
		getActorSystem().actorOf(Props.create(WorkspaceActor.class), "workspaceActor");
	}
	
	public ActorSystem getActorSystem() {
		return actorSystem;
	}
}
