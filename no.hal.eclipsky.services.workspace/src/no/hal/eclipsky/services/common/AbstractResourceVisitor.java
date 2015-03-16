package no.hal.eclipsky.services.common;

import java.util.Stack;

import no.hal.eclipsky.services.common.ResourceRef;

public abstract class AbstractResourceVisitor implements ResourceVisitor {
	
	private Stack<String> packages = new Stack<String>();
	
	protected int getLevel() {
		return packages.size();
	}
	
	public void visit(ResourceRef resourceRef) {
		String packageName = resourceRef.getPackageName(), resourceName = resourceRef.getResourceName();
		String lastPackage = null;
		while (! packages.isEmpty()) {
			lastPackage = packages.peek();
			if (packageName != null && packageName.startsWith(lastPackage)) {
				break;
			}
			exitPackage(lastPackage);
			packages.pop();
			lastPackage = null;
		}
		if (packageName != null && (! packageName.equals(lastPackage))) {
			enterPackage(packageName);
			packages.push(packageName);
		}
		if (resourceName != null) {
			visitResource(packageName, resourceName);
		}
	}

	protected void enterPackage(String packageName) {}
	protected void exitPackage(String packageName) {}
	protected void visitResource(String packageName, String resourceName) {}
}
