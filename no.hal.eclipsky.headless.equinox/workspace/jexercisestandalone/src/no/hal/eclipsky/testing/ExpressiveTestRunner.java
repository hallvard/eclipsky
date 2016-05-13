package no.hal.eclipsky.testing;

import java.io.PrintStream;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestResult;
import junit.framework.TestSuite;
import junit.runner.BaseTestRunner;

public class ExpressiveTestRunner extends BaseTestRunner {
	private ResultPrinter printer;

    public static final int SUCCESS_EXIT = 0;
    public static final int FAILURE_EXIT = 1;
    public static final int EXCEPTION_EXIT = 2;

    /**
     * Constructs a ExpressiveTestRunner.
     */
    public ExpressiveTestRunner() {
        this(System.out);
    }

    /**
     * Constructs a ExpressiveTestRunner using the given stream for all the output
     */
    public ExpressiveTestRunner(PrintStream writer) {
        this(new ResultPrinter(writer));
    }

    /**
     * Constructs a ExpressiveTestRunner using the given ResultPrinter all the output
     */
    public ExpressiveTestRunner(ResultPrinter printer) {
        setPrinter(printer);
    }
    
    /**
     * Sets the printer
     * @param printer
     */
    public void setPrinter(ResultPrinter printer) {
        this.printer = printer;
    }

    /**
     * Runs a suite extracted from a TestCase subclass.
     */
    static public void run(Class<? extends TestCase> testClass) {
        run(new TestSuite(testClass));
    }

    /**
     * Runs a single test and collects its results.
     * This method can be used to start a test run
     * from your program.
     * <pre>
     * public static void main (String[] args) {
     *    test.textui.ExpressiveTestRunner.run(suite());
     * }
     * </pre>
     */
    static public TestResult run(Test test) {
        ExpressiveTestRunner runner = new ExpressiveTestRunner();
        return runner.doRun(test);
    }

    /**
     * Runs a single test and waits until the user
     * types RETURN.
     */
    static public void runAndWait(Test suite) {
        ExpressiveTestRunner aExpressiveTestRunner = new ExpressiveTestRunner();
        aExpressiveTestRunner.doRun(suite, true);
    }

    @Override
    public void testFailed(int status, Test test, Throwable e) {
    }

    @Override
    public void testStarted(String testName) {
    }

    @Override
    public void testEnded(String testName) {
    }

    /**
     * Creates the TestResult to be used for the test run.
     */
    protected TestResult createTestResult() {
        return new TestResult();
    }

    public TestResult doRun(Test test) {
        return doRun(test, false);
    }

    public TestResult doRun(Test suite, boolean wait) {
        TestResult result = createTestResult();
        result.addListener(printer);
        long startTime = System.currentTimeMillis();
        suite.run(result);
        long endTime = System.currentTimeMillis();
        long runTime = endTime - startTime;
        printer.print(result, runTime);
        pause(wait);
        return result;
    }

    private void pause(boolean wait) {
        if (wait) {
	        printer.printWaitPrompt();
	        try {
	            System.in.read();
	        } catch (Exception e) {
	        }
        }
    }

    public static void main(String[] args) {
        ExpressiveTestRunner testRunner = new ExpressiveTestRunner();
        try {
            TestResult result = testRunner.start(args);
            System.exit(result.wasSuccessful() ? SUCCESS_EXIT : FAILURE_EXIT);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(EXCEPTION_EXIT);
        }
    }

    /**
     * Starts a test run. Analyzes the command line arguments and runs the given
     * test suite.
     */
    public TestResult start(String[] args) throws Exception {
        String testCase = "";
        String method = "";
        boolean wait = false;

        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-wait")) {
                wait = true;
            } else if (args[i].equals("-c")) {
                testCase = extractClassName(args[++i]);
            } else if (args[i].equals("-m")) {
                String arg = args[++i];
                int lastIndex = arg.lastIndexOf('.');
                testCase = arg.substring(0, lastIndex);
                method = arg.substring(lastIndex + 1);
            } else {
                testCase = args[i];
            }
        }
        
        if (testCase == null || "".equals(testCase)) {
            throw new Exception("Usage: ExpressiveTestRunner [-wait] testCaseName, where name is the name of the TestCase class");
        }

        try {
            if (! "".equals(method)) {
                return runSingleMethod(testCase, method, wait);
            }
            Test suite = getTest(testCase);
            return doRun(suite, wait);
        } catch (Exception e) {
            throw new Exception("Could not create and run test suite: " + e);
        }
    }

    @SuppressWarnings("unchecked")
	protected TestResult runSingleMethod(String testCase, String method, boolean wait) throws Exception {
        Class<? extends TestCase> testClass = loadSuiteClass(testCase).asSubclass(TestCase.class);
        Test test = TestSuite.createTest(testClass, method);
        return doRun(test, wait);
    }

    @Override
    protected void runFailed(String message) {
        System.err.println(message);
        System.exit(FAILURE_EXIT);
    }
}