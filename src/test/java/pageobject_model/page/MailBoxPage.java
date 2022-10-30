package pageobject_model.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MailBoxPage {
    private WebDriver driver;
    @FindBy(css="div[aria-label$='@mail.ru']")
    private WebElement userNameOnPage;

    public MailBoxPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

        public boolean checkForLogin () {
            new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions.visibilityOf(userNameOnPage));
            boolean isInMailBox= (userNameOnPage!=null);
            return isInMailBox;
        }
    }
