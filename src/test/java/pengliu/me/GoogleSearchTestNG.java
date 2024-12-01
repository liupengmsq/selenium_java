package pengliu.me;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.*;

public class GoogleSearchTestNG extends BaseTestNG {
    @Autowired
    private GoogleSearchPage googleSearchPage;

    @BeforeClass
    public void setUp() {
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

    @AfterClass
    public void tearDown() {
        // 关闭浏览器
        if (driver != null) {
            driver.quit();
        }
    }
}
