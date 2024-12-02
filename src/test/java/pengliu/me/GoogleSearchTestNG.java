package pengliu.me;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

public class GoogleSearchTestNG extends BaseTestNG {
    @Autowired
    private GoogleSearchPage googleSearchPage;

    @BeforeClass
    public void setup(ITestContext context) {
        System.out.println("Test Name: " + context.getName());
        context.setAttribute("key", "value");
    }

    @Test
    public void testMethod(ITestContext context) {
        String value = (String) context.getAttribute("key");
        System.out.println("Shared value: " + value);
    }

    @Test
    public void testGoogleSearch() {
        // 打开 Google 首页
        googleSearchPage.navigate("https://www.google.com");
        googleSearchPage.waitForLoadCompleted();
        // 找到搜索框并输入关键字
        googleSearchPage.inputSearchKeyword("Selenium WebDriver");
        // 提交搜索
        googleSearchPage.submitSearch();

        // 验证页面标题是否包含 "Selenium WebDriver"
        String title = googleSearchPage.getTitle();
        Assert.assertTrue(title.contains("Selenium WebDriver"), "Title does not contain expected text!");
    }

    @Test
    public void testAnother() {
        int[] a={1, 2, 3};
        int[] b={1, 2, 3};
        Assert.assertEquals(a, b);
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void testTwoAnother() {
        int[] a={1, 2, 3};
        int[] b={1, 2, 3};
        Assert.assertNotEquals(a, b);
    }

    @Test(dataProviderClass =DataProviderExample.class, dataProvider = "testData")
    public void testLogin(String username, String password) {
        System.out.println("Testing with user: " + username + ", password: " + password);
    }

    @AfterClass
    public void tearDown() {
        // 关闭浏览器
        if (driver != null) {
            driver.quit();
        }
    }
}
