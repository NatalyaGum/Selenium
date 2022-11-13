package pageobject_model.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
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
    private WebElement signInBtn;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public HomePage openPage() {
        driver.get(HOMEPAGE_URL);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(WAIT_TIMEOUT_SECONDS));
        return this;
    }

    public MailBoxPage mailruLoginWithActions(String login, String password) {
        loginBtn.click();
        driver.switchTo().frame(iframe);
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS)).until(ExpectedConditions.visibilityOf(loginInput));
        Actions builder = new Actions(driver);
        builder.moveToElement(loginInput)
                .sendKeys(login)
                .moveByOffset(0, 50)
                .click()
                .build().perform();
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS)).until(ExpectedConditions.visibilityOf(passwordInput));
        builder.moveToElement(passwordInput)
                .sendKeys(password)
                .moveByOffset(0, 50)
                .moveByOffset(-100, 0)
                .click()
                .build().perform();
        return new MailBoxPage(driver);
    }

    public MailBoxPage mailruLogin(String login, String password) {
        loginBtn.click();
        driver.switchTo().frame(iframe);
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS)).until(ExpectedConditions.visibilityOf(loginInput));
        loginInput.sendKeys(login);
        enterPasswordBtn.click();
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS)).until(ExpectedConditions.visibilityOf(passwordInput));
        passwordInput.sendKeys(password);
        signInBtn.click();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(WAIT_TIMEOUT_SECONDS));
        return new MailBoxPage(driver);
    }

    public HomePage scrollDown() {
        JavascriptExecutor jsExec = (JavascriptExecutor) driver;
        jsExec.executeScript("window.scrollBy(0,500)");
        jsExec.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        return new HomePage(driver);
    }

    public MailBoxPage mailruLoginWithJsExec(String login, String password) {
        JavascriptExecutor jsExec = (JavascriptExecutor) driver;
        jsExec.executeScript("arguments[0].click();", loginBtn);
        driver.switchTo().frame(iframe);
        jsExec.executeScript("arguments[0].style.backgroundColor = '" + "yellow" + "'", loginInput);
        jsExec.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 1000);");
        loginInput.sendKeys(login);
        jsExec.executeScript("arguments[0].click();", enterPasswordBtn);
        jsExec.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 1000);");
        jsExec.executeScript("arguments[0].style.backgroundColor = '" + "yellow" + "'", passwordInput);
        passwordInput.sendKeys(password);
        jsExec.executeScript("arguments[0].click();", signInBtn);
        return new MailBoxPage(driver);
    }

    public boolean checkForLogOut() {
        return new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS)).until(ExpectedConditions.visibilityOf(loginBtn)).isDisplayed();

    }

}