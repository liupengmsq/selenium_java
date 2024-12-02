package pengliu.me;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

public class DataProviderExample {
    @DataProvider(name = "testData")
    public Object[][] provideData(ITestContext context) {
        String testEnv = context.getCurrentXmlTest().getParameter("env");
        if ("dev".equals(testEnv)) {
            return new Object[][]{{"dev_user", "dev_password"}};
        } else if ("prod".equals(testEnv)) {
            return new Object[][]{{"prod_user", "prod_password"}};
        }
        return new Object[][]{{"default_user", "default_password"}};
    }
}
