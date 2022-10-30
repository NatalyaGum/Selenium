package pageobject_model.page;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends AbstractPage {
    private static final String HOMEPAGE_URL = "https://mail.ru";
    @FindBy(xpath = "//button[@class='ph-login svelte-1hiqrvn']")
    private WebElement loginBtn;
    @FindBy(xpath = "//iframe[@class='ag-popup__frame__layout__iframe']")
    private WebElement iframe;
    @FindBy(xpath = "//*[@class='input-0-2-71']")
    private WebElement loginInput;
    @FindBy(xpath = "//button[@class='base-0-2-79 primary-0-2-93']")
    private WebElement enterPasswordBtn;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordInput;
    @FindBy(xpath = "//span[@class='inner-0-2-81 innerTextWrapper-0-2-82']")
    private WebElement signinBtn;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public HomePage openPage() {
        driver.get(HOMEPAGE_URL);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        return this;
    }

    public MailBoxPage mailruLogin(String login, String password) throws InterruptedException {
        loginBtn.click();
        driver.switchTo().frame(iframe);
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS)).until(ExpectedConditions.visibilityOf(loginInput));
        loginInput.sendKeys(login);
        enterPasswordBtn.click();
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS)).until(ExpectedConditions.visibilityOf(passwordInput));
        passwordInput.sendKeys(password);
        signinBtn.click();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(WAIT_TIMEOUT_SECONDS));
        return new MailBoxPage(driver);
    }
}
