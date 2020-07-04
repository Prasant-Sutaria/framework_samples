package in.co.cloudera.executor;

import org.testng.TestNG;
import org.testng.xml.XmlPackage;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestNGSuite {

    private CLIUtils cliUtils;
    private TestNG testNG;
    private static TestNGSuite testNGUtil;

    private void createTestNGSuite(){

        this.testNG = new TestNG();

        List<XmlSuite> suites = new ArrayList<>();
        XmlSuite suite = new XmlSuite();
        suite.setName("Sample TestNG Suite");

        TestNGTest testNGTest = new TestNGTest(suite,cliUtils);
        List<XmlTest> tests = testNGTest.createTestsInSuite();

        suite.setTests(tests);
        suites.add(suite);

//        System.out.println( suite.toXml());
        this.testNG.setXmlSuites(suites);
    }

    private TestNGSuite(String[] commandLineArgs){

        this.cliUtils = new CLIUtils(commandLineArgs);
        this.createTestNGSuite();
    }

    public static TestNGSuite getTestNGSuite(String[] commandLineArgs){

        if(testNGUtil==null){
            testNGUtil = new TestNGSuite(commandLineArgs);
        }
        return testNGUtil;
    }

    public void execute(){
        testNG.run();
    }

}
