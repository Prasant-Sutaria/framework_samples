package test.java.in.co.cloudera.executor;

public enum CLIParameters {

    INCLUDED_GROUPS("--includeGroups"),
    EXCLUDED_GROUPS("--excludeGroups"),
    TEST_PACKAGES("--testPackages"),
    THREAD_COUNT("--threadCount");

    private String parameter;

    CLIParameters(String parameter){
        this.parameter = parameter;
    }

    public String getParameter(){
        return parameter;
    }

}
