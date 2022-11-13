package pageobject_model.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
    @FindBy(xpath = "//div[@class='container--2Rl8H']/div/div[2]/div/div[1]")
    private WebElement enterBodyInput;
    @FindBy(xpath = "//button[@class='container--2lPGK type_base--rkphf color_base--hO-yz']")
    private WebElement closeMailBtn;
    @FindBy(xpath = "//*[text()='Письмо отправлено']")
    private WebElement mailSentMsg;
    @FindBy(xpath = "//span[text()='Сохранить']")
    private WebElement saveBtn;
    @FindBy(xpath = "//button[@data-test-id='send']")
    private WebElement sendBtn;
    @FindBy(xpath = "//span[@class='button2 button2_has-ico button2_has-ico-s button2_actions_close button2_base button2_secondary button2_short button2_hover-support']")
    private WebElement closeEditDraftBtn;
    @FindBy(xpath = "//span[@class='button2 button2_has-ico button2_has-ico-s button2_close button2_pure button2_short button2_hover-support']")
    private WebElement closeSentWindowBtn;

    public MailFrame mailCreate(String email) {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(WAIT_TIMEOUT_SECONDS));
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS)).until(ExpectedConditions.visibilityOf(enterToInput));
        enterToInput.sendKeys(email);
        enterSubjectInput.sendKeys(email);
        enterBodyInput.sendKeys(email);
        return new MailFrame(driver);
    }

    public MailBoxPage mailSave() {
        saveBtn.click();
        closeMailBtn.click();
        return new MailBoxPage(driver);
    }

    public DraftPage sendMail() {
        if (closeEditDraftBtn != null) {
            closeEditDraftBtn.click();
        }
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS)).until(ExpectedConditions.elementToBeClickable(sendBtn));
        sendBtn.click();
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS)).until(ExpectedConditions.visibilityOf(mailSentMsg));
        if (closeSentWindowBtn != null) {
            closeSentWindowBtn.click();
        }
        return new DraftPage(driver);
    }

    public MailFrame mailCreateWithActions(String email) {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(WAIT_TIMEOUT_SECONDS));
        new WebDriverWait(driver, Duration.ofMinutes(WAIT_TIMEOUT_MINUTES)).until(ExpectedConditions.visibilityOf(enterToInput));
        Actions builder = new Actions(driver);
        builder.sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(email)
                .sendKeys(enterBodyInput, email)
                .build().perform();
        return new MailFrame(driver);
    }
}