package no.hal.eclipsky.services.editor;

import java.util.ArrayList;
import java.util.Collection;

import no.hal.eclipsky.services.common.Test;

public class TestResult extends RunResult {
	
	private Collection<Test> allTests;
	
	public TestResult(String qualifiedName) {
		super(qualifiedName);
	}
	
	/**
	 * This method will parse the console output into a list of Test-Objects 
	 */
	@Override
	public void setConsoleOutput(String consoleOutput) {
		super.setConsoleOutput(consoleOutput);
		allTests = new ArrayList<Test>();
		
		String[] lines = consoleOutput.split("\n");
		
		char status = 'O';
		for (int i = 0; i < lines.length - 1; i++) {
			String line = lines[i].trim();
			if (line.isEmpty()) {
				continue;
			}
			String testName = null, exception = "";
			if (line.charAt(0) == '*') {
				testName = lines[++i];
				status = lines[++i].charAt(0);
				exception = lines[++i];
				while (i + 1 < lines.length && (! lines[i + 1].isEmpty()) && lines[i + 1].charAt(0) != '*') {
					exception += "\n" + lines[++i];
				}
			}
			Test t = new Test(testName, status, exception);			
			allTests.add(t);
		}		
	}

	public Collection<Test> getAllTests() {
		return allTests;
	}
}
