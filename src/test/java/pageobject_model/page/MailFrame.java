package pageobject_model.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MailFrame extends MailBoxPage {
    public MailFrame(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@class='container--H9L5q size_s--3_M-_' and @value='']")
    private WebElement enterToInput;
    @FindBy(xpath = "//input[@name='Subject']")
    private WebElement enterSubjectInput;
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div/div/div[2]/div[3]/div[5]/div/div/div[2]/div[1]/div[1]")
    private WebElement enterBodyInput;
    @FindBy(xpath = "//button[@class='container--2lPGK type_base--rkphf color_base--hO-yz']")
    private WebElement closeMailBtn;

    public MailFrame mailCreate(String email) {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(WAIT_TIMEOUT_SECONDS));
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS)).until(ExpectedConditions.visibilityOf(enterToInput));
        enterToInput.sendKeys(email);
        enterSubjectInput.sendKeys(email);
        enterBodyInput.sendKeys(email);
        return new MailFrame(driver);
    }

    public MailBoxPage mailSave() {
        enterBodyInput.sendKeys(Keys.chord(Keys.CONTROL, "s"));
        closeMailBtn.click();
        return new MailBoxPage(driver);
    }
}