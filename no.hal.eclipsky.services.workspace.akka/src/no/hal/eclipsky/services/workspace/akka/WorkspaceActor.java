package no.hal.eclipsky.services.workspace.akka;

import no.hal.eclipsky.services.Status;
import no.hal.eclipsky.services.workspace.WorkspaceService;
import no.hal.eclipsky.services.workspace.impl.WorkspaceServiceImpl;
import akka.actor.UntypedActor;

public class WorkspaceActor extends UntypedActor {

	private WorkspaceService workspaceService = new WorkspaceServiceImpl();
	
	@Override
	public void onReceive(Object message) throws Exception {
		if (message instanceof ListProjects) {
			handleListProjects((ListProjects) message);
		}
		else if (message instanceof EnsureJavaProject) {
			handleEnsureProject((EnsureJavaProject) message);
		}
		else {
			unhandled(message);
		}
	}
	
	private void handleEnsureProject(EnsureJavaProject message) {
		Status status = Status.OK;
		try {
			workspaceService.ensureProject(message.name, message.type);
		} catch (RuntimeException e) {
			status = new Status(Status.Severity.Error, "Couldn't create project: " + e.getMessage());
		}
		getSender().tell(status, getSelf());
	}
	
	private void handleListProjects(ListProjects message) {
		String[] projectList = workspaceService.getProjectList(message.namePattern, message.type);
		getSender().tell(projectList, getSelf());
	}
}
