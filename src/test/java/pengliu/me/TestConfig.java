package pengliu.me;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class TestConfig {
    @Bean
    public WebDriver webDriver() {
        // 使用 WebDriver Manager 自动管理 ChromeDriver
        WebDriverManager.chromedriver().setup();

        // 配置 Chrome 的无头模式
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // 启用无头模式
        options.addArguments("--disable-gpu"); // 禁用 GPU 加速
        options.addArguments("--window-size=1920,1080"); // 设置窗口大小

        // 初始化 WebDriver
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        // 设置隐士等待的时间
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        return driver;
    }

    @Bean
    public GoogleSearchPage googleSearchResultsPage(WebDriver driver) {
        return new GoogleSearchPage(driver);
    }
}
