package pageobject_model.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {

    protected WebDriver driver;
    protected abstract AbstractPage openPage();
    protected static final int WAIT_TIMEOUT_SECONDS = 10;
    protected  static final int WAIT_TIMEOUT_MINUTES = 1;

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
