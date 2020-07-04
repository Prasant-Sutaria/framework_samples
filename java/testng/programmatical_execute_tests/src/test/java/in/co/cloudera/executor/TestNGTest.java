package in.co.cloudera.executor;

import org.testng.xml.XmlPackage;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestNGTest {

    private CLIUtils cliUtils;
    private XmlSuite suite;
    private final static int DEFAULT_THREAD_COUNT = 5;

    TestNGTest(XmlSuite suite, CLIUtils cliUtils){
        this.cliUtils = cliUtils;
        this.suite = suite;
    }

    public List<XmlTest> createTestsInSuite(){

        List<XmlTest> tests= new ArrayList<>();

        XmlTest test = new XmlTest();
        test.setName("Sample Test");

        test.setSuite(suite);

        List<XmlPackage> includedPackages = getTestClassPackages();
        if(includedPackages.size()>0){
            test.setPackages(includedPackages);
        }

        test.setParallel(XmlSuite.ParallelMode.METHODS);
        test.setThreadCount(getThreadCount());

        List<String> includedGroups = getIncludeGroups();
        if(includedGroups.size()>0){
            test.setIncludedGroups(includedGroups);
        }

        List<String> excludedGroups = getExcludeGroups();
        if(excludedGroups.size()>0){
            test.setExcludedGroups(excludedGroups);
        }

        tests.add(test);

        return tests;
    }

    private List<String> getIncludeGroups(){

        List<String> includedGroups = new LinkedList<>();

        String[] includedGroupNameList = cliUtils.getCLIArguments(CLIParameters.INCLUDED_GROUPS);

        for(String includedGroupName:includedGroupNameList){
            includedGroups.add(includedGroupName);
        }

        return includedGroups;
    }

    private List<String> getExcludeGroups(){
        List<String> excludedGroups = new LinkedList<>();

        String[] excludedGroupNameList = cliUtils.getCLIArguments(CLIParameters.EXCLUDED_GROUPS);
        for(String includedGroupName:excludedGroupNameList){
            excludedGroups.add(includedGroupName);
        }

        return excludedGroups;
    }

    private List<XmlPackage> getTestClassPackages(){

        List<XmlPackage> includedPackages = new LinkedList<>();
        String[] packageNameList = cliUtils.getCLIArguments(CLIParameters.TEST_PACKAGES);

        for(String packageName:packageNameList){
            includedPackages.add(new XmlPackage(packageName));
        }
        return includedPackages;
    }

    private int getThreadCount(){

        try{
            return Integer.parseInt(cliUtils.getCLIArgument(CLIParameters.THREAD_COUNT));
        }catch (NumberFormatException e){
            return DEFAULT_THREAD_COUNT;
        }
    }

}
