package in.co.cloudera.test.a;

import org.testng.annotations.Test;

public class TestClass {

    @Test(testName = "Test A1", groups = {"A1","A"})
    public void testA1(){
        System.out.println("Executing Test A1");
    }

    @Test(testName = "Test A2", groups = {"A2","A"})
    public void testA2(){
        System.out.println("Executing Test A2");
    }
}
