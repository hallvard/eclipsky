package no.hal.eclipsky.services.common;

public class Test {
	private String testName;
	private char status;
	private String exception;
	
	public Test(String testName) {
		this(testName, 'O');
	}
	
	public Test(String testName, char status) {
		this(testName, status, "");
	}
	
	public Test(String testName, char status, String exception) {
		this.testName = testName;
		this.status = status;
		this.exception = exception;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}	
}
