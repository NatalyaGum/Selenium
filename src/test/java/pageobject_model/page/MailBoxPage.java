package pageobject_model.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MailBoxPage extends AbstractPage {
    @FindBy(css = "div[aria-label$='@mail.ru']")
    private WebElement userNameOnPage;

    public MailBoxPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkForLogin() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS)).until(ExpectedConditions.visibilityOf(userNameOnPage));
        boolean isInMailBox = (userNameOnPage != null);
        return isInMailBox;
    }

    @Override
    protected AbstractPage openPage() {
        throw new RuntimeException("It doesn't work!");
    }
}