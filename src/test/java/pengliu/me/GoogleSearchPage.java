package pengliu.me;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GoogleSearchPage extends BasePage {
    @FindBy(name="q")
    private WebElement searchBox;

    public GoogleSearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public GoogleSearchPage waitForLoadCompleted() {
        getWaiter().until(ExpectedConditions.visibilityOf(this.searchBox));
        return this;
    }

    public GoogleSearchPage inputSearchKeyword(String search) {
        this.searchBox.sendKeys(search);
        return this;
    }

    public GoogleSearchPage submitSearch() {
        this.searchBox.submit();
        return this;
    }
}
