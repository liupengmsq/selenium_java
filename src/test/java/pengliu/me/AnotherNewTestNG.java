package pengliu.me;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AnotherNewTestNG extends BaseTestNG {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before testsuite in AnotherNewTestNG class");
    }

    @Test(priority = 2)
    public void testFive() {
        System.out.println("In testFive");
    }

//    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Test(priority = 1)
    public void testThree() {
        System.out.println("In testThree");
    }

//    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Test(priority = 0)
    public void testFour() {
        System.out.println("In testFour");
    }


    @AfterSuite
    public void afterSuite() {
        System.out.println("after testsuite in AnotherNewTestNG class");
    }

}
