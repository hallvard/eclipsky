package no.hal.eclipsky.services.editor;

import java.util.ArrayList;
import java.util.List;

import no.hal.eclipsky.services.common.Test;

public class TestResult extends RunResult {
	private List<Test> allTests;
	
	
	public TestResult(String qualifiedName) {
		super(qualifiedName);
	}
	
	/**
	 * This method will parse the console output into a list of Test-Objects 
	 */
	@Override
	public void setConsoleOutput(String consoleOutput) {
		super.setConsoleOutput(consoleOutput);
		
		String[] lines = consoleOutput.split("\n");
		allTests = new ArrayList<Test>();
		
		Test t;
		String testName = null, exception = "";
		char status = 'O';
		for (int i = 0; i < lines.length - 1; i++) {
			String line = lines[i];
			if (line.charAt(0) == '*') {
				testName = lines[++i];
				status = lines[++i].charAt(0);
				
				exception = lines[++i];
				while(lines[i+1].charAt(0) != '*') {
					exception += "\n" + lines[++i];
				}
			}
			t = new Test(testName, status, exception);
			
			allTests.add(t);
		}		
	}

	public List<Test> getAllTests() {
		return allTests;
	}
}
