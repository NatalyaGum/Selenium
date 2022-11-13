package pageobject_model.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
    @FindBy(xpath = "//a[@href='/drafts/']")
    private WebElement draftPageBtn;
    @FindBy(xpath = "//a[@href='/spam/']")
    private WebElement spamPageBtn;
    @FindBy(xpath = "//div[@data-testid='whiteline-account-exit']")
    private WebElement logOutBtn;

    public MailBoxPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkForLogin() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS)).until(ExpectedConditions.visibilityOf(draftPageBtn));
        boolean isInMailBox = (userNameOnPage != null);
        return isInMailBox;
    }

    public MailFrame writeLetter() {
        new WebDriverWait(driver, Duration.ofMinutes(WAIT_TIMEOUT_MINUTES)).until(ExpectedConditions.elementToBeClickable(writeLetterBtn));
        if (!driver.findElements(By.xpath("//div[@class='ph-project-promo-close-icon__container svelte-m7oyyo']")).isEmpty()) {
            closeMailruPrimary.click();
        }
        writeLetterBtn.click();
        return new MailFrame(driver);
    }

    public DraftPage openDraftPage() {
        new WebDriverWait(driver, Duration.ofMinutes(WAIT_TIMEOUT_MINUTES)).until(ExpectedConditions.elementToBeClickable(draftPageBtn));
        if (!driver.findElements(By.xpath("//div[@class='ph-project-promo-close-icon__container svelte-m7oyyo']")).isEmpty()) {
            closeMailruPrimary.click();
        }
        draftPageBtn.click();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(WAIT_TIMEOUT_MINUTES));
        return new DraftPage(driver);
    }

    public SpamBoxPage openSpamPage() {
        new WebDriverWait(driver, Duration.ofMinutes(WAIT_TIMEOUT_MINUTES)).until(ExpectedConditions.elementToBeClickable(spamPageBtn));
        if (!driver.findElements(By.xpath("//div[@class='ph-project-promo-close-icon__container svelte-m7oyyo']")).isEmpty()) {
            closeMailruPrimary.click();
        }
        spamPageBtn.click();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(WAIT_TIMEOUT_MINUTES));
        return new SpamBoxPage(driver);
    }

    public HomePage mailruLogout() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS)).until(ExpectedConditions.visibilityOf(spamPageBtn));
        if (!driver.findElements(By.xpath("//div[@class='ph-project-promo-close-icon__container svelte-m7oyyo']")).isEmpty()) {
            closeMailruPrimary.click();
        }
        userNameOnPage.click();
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS)).until(ExpectedConditions.visibilityOf(logOutBtn));
        logOutBtn.click();
        return new HomePage(driver);
    }

    public MailBoxPage scrollDown() {
        JavascriptExecutor jsExec = (JavascriptExecutor) driver;
        jsExec.executeScript("window.scrollBy(0,300)");
        return new MailBoxPage(driver);
    }

    @Override
    protected AbstractPage openPage() {
        throw new RuntimeException("It doesn't work!");
    }
}