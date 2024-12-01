package pengliu.me;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    private WebDriver driver;
    private WebDriverWait shortWaiter;
    private WebDriverWait waiter;
    private WebDriverWait longWaiter;

    protected WebDriverWait getShortWaiter() {
        return shortWaiter;
    }

    protected WebDriverWait getWaiter() {
        return waiter;
    }

    protected WebDriverWait getLongWaiter() {
        return longWaiter;
    }

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.shortWaiter = new WebDriverWait(driver, Duration.ofSeconds(1));
        this.waiter = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.longWaiter = new WebDriverWait(driver, Duration.ofSeconds(100));
    }

    public abstract BasePage waitForLoadCompleted();

    public BasePage navigate(String url) {
        this.driver.get(url);
        return this;
    }

    public String getTitle() {
        return driver.getTitle();
    }
}
