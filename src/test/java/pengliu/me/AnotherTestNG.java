package pengliu.me;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AnotherTestNG extends BaseTestNG {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before testsuite in anothertestng class");
    }

//    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Test
    public void testOne() {
        System.out.println("In testOne");
    }

//    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Test
    public void testTwo() {
        System.out.println("In testTwo");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("after testsuite in anothertestng class");
    }

}
