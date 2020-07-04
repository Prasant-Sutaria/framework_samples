package in.co.cloudera.test.b;

import org.testng.annotations.Test;

public class TestClass {

    @Test(testName = "Test B", groups = {"BGroup"})
    public void testA(){
        System.out.println("Executing Test B");
    }
}
