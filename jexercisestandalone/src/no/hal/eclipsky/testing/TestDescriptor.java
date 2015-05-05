package no.hal.eclipsky.testing;

public class TestDescriptor {
	private String testName;
	private char status;
	private String exception;
	
	public TestDescriptor(String testName) {
		this(testName, 'O');
	}
	
	public TestDescriptor(String testName, char status) {
		this(testName, status, "");
	}
	
	public TestDescriptor(String testName, char status, String exception) {
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
