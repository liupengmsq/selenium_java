package pengliu.me;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Listeners;

@Listeners(ScreenshotListener.class)
@SpringBootTest(classes = {TestApplication.class, TestConfig.class})
public abstract class BaseTestNG extends AbstractTestNGSpringContextTests {
    @Autowired
    protected WebDriver driver;
    protected ScreenshotListener listener;

    public WebDriver getDriver() {
        return this.driver;
    }
}
