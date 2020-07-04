package test.java.in.co.cloudera.executor.executor;

public class TestsExecutor {
    public static void main(String[] commandLineArgs) {
        TestNGSuite.getTestNGSuite(commandLineArgs).execute();
    }
}
