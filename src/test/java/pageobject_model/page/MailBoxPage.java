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
    @FindBy(xpath = "//span[@class='compose-button__txt']")
    private WebElement writeLetterBtn;
    @FindBy(xpath = "//div[@class='ph-project-promo-close-icon__container svelte-m7oyyo']")
    private WebElement closeMailruPrimary;
    @FindBy(css = "a[href='/drafts/']")
    private WebElement draftPageBtn;
    public MailBoxPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkForLogin() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS)).until(ExpectedConditions.visibilityOf(userNameOnPage));
        boolean isInMailBox = (userNameOnPage != null);
        return isInMailBox;
    }

    public MailFrame writeLetter() throws InterruptedException {
        new WebDriverWait(driver, Duration.ofMinutes(WAIT_TIMEOUT_MINUTES)).until(ExpectedConditions.elementToBeClickable(writeLetterBtn));
        if (closeMailruPrimary!=null) {closeMailruPrimary.click();}
        writeLetterBtn.click();
        return new MailFrame(driver);}

    public DraftPage openDraftPage() throws InterruptedException {
        new WebDriverWait(driver, Duration.ofMinutes(WAIT_TIMEOUT_MINUTES)).until(ExpectedConditions.elementToBeClickable(draftPageBtn));
        draftPageBtn.click();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(WAIT_TIMEOUT_MINUTES));
        return new DraftPage(driver);}
    @Override
    protected AbstractPage openPage() {
        throw new RuntimeException("It doesn't work!");
    }
}