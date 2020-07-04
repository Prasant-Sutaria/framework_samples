package in.co.cloudera.executor;

public class TestsExecutor {
    public static void main(String[] commandLineArgs) {
        TestNGSuite.getTestNGSuite(commandLineArgs).execute();
    }
}
