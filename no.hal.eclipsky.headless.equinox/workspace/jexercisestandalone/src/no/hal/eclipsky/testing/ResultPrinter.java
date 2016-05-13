package no.hal.eclipsky.testing;

import java.io.PrintStream;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import junit.framework.AssertionFailedError;
import junit.framework.Test;
import junit.framework.TestListener;
import junit.framework.TestResult;

public class ResultPrinter implements TestListener {
	private List<TestDescriptor> tests = new ArrayList<>();

    private PrintStream writer;

    public ResultPrinter(PrintStream writer) {
        this.writer = writer;
    }

    /* API for use by textui.TestRunner */

    synchronized void print(TestResult result, long runTime) {
    	for (TestDescriptor testDescriptor : tests) {
    		getWriter().println('*');
    		getWriter().println(testDescriptor.testName);
    		getWriter().println(testDescriptor.status);
    		if (testDescriptor.exception != null) {
    			getWriter().println(testDescriptor.exception);
    		}
    	}
    	getWriter().println('*');
    }

    void printWaitPrompt() {
        getWriter().println();
        getWriter().println("<RETURN> to continue");
    }

    /**
     * Returns the formatted string of the elapsed time.
     * Duplicated from BaseTestRunner. Fix it.
     */
    protected String elapsedTimeAsString(long runTime) {
        return NumberFormat.getInstance().format((double) runTime / 1000);
    }

    public PrintStream getWriter() {
        return writer;
    }

    private TestDescriptor currentTest;
    
    /**
     * @see junit.framework.TestListener#addError(Test, Throwable)
     */
    public void addError(Test test, Throwable e) {
    	currentTest.status = 'E';
    	String exception = e.getLocalizedMessage();
    	currentTest.exception = exception;
    }

    /**
     * @see junit.framework.TestListener#addFailure(Test, AssertionFailedError)
     */
    public void addFailure(Test test, AssertionFailedError t) {
    	currentTest.status = 'E';
    	String exception = t.getLocalizedMessage();
    	currentTest.exception = exception;
    }

    /**
     * @see junit.framework.TestListener#endTest(Test)
     */
    public void endTest(Test test) {
    }

    /**
     * @see junit.framework.TestListener#startTest(Test)
     */
    public void startTest(Test test) {
    	currentTest = new TestDescriptor(test.toString());
    	tests.add(currentTest);
    }

    private static class TestDescriptor {

    	String testName;
    	char status;
    	String exception;
    	
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
    }
}
