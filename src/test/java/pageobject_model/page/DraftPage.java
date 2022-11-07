package pageobject_model.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DraftPage extends AbstractPage {
    @FindBy(xpath = "//a[@class='nav__item js-shortcut nav__item_active nav__item_shortcut nav__item_expanded_true nav__item_child-level_0' and @href='/drafts/']")
    private WebElement draftPage;
    @FindBy(xpath = "(//span[@class='ll-crpt'])[1]")
    private WebElement correspondent;
    @FindBy(xpath = "(//span[@class='ll-sj__normal'])[1]")
    private WebElement subject;
    @FindBy(xpath = "(//span[@class='ll-sp__normal'])[1]")
    private WebElement bodyOfMail;
    @FindBy(css = "a[href='/sent/']")
    private WebElement sentPageBtn;
    @FindBy(css = "a[href='/sent/']")
    private WebElement inboxPageBtn;
    @FindBy(xpath = "//span[text()='Выделить все']")
    private WebElement selectAllBtn;
    @FindBy(xpath = "//span[@class='compose-button__txt']")
    private WebElement writeLetterBtn;

    public DraftPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkMail(String text) {
        new WebDriverWait(driver, Duration.ofMinutes(WAIT_TIMEOUT_MINUTES)).until(ExpectedConditions.visibilityOf(draftPage));
        return correspondent.getText().equals(text) & subject.getText().equals(text) & bodyOfMail.getText().startsWith(text);
    }

    public MailFrame openDraft() {
        new WebDriverWait(driver, Duration.ofMinutes(WAIT_TIMEOUT_MINUTES)).until(ExpectedConditions.visibilityOf(draftPage));
        new WebDriverWait(driver, Duration.ofMinutes(WAIT_TIMEOUT_MINUTES)).until(ExpectedConditions.visibilityOf(correspondent));
        correspondent.click();
        return new MailFrame(driver);
    }

    public SentBoxPage openSentBoxPage() {
        new WebDriverWait(driver, Duration.ofMinutes(WAIT_TIMEOUT_MINUTES)).until(ExpectedConditions.elementToBeClickable(sentPageBtn));
        sentPageBtn.click();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(WAIT_TIMEOUT_MINUTES));
        return new SentBoxPage(driver);
    }

    public MailBoxPage openMailBoxPage() {
        new WebDriverWait(driver, Duration.ofMinutes(WAIT_TIMEOUT_MINUTES)).until(ExpectedConditions.elementToBeClickable(sentPageBtn));
        inboxPageBtn.click();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(WAIT_TIMEOUT_MINUTES));
        return new MailBoxPage(driver);
    }

    public boolean checkMailIsSent() throws InterruptedException {
        new WebDriverWait(driver, Duration.ofMinutes(WAIT_TIMEOUT_MINUTES)).until(ExpectedConditions.visibilityOf(draftPage));
        return driver.findElements(By.xpath("(//div[@class='llc__item llc__item_date'])[1]")).isEmpty();
    }

    public DraftPage removeDrafts() {
        new WebDriverWait(driver, Duration.ofMinutes(WAIT_TIMEOUT_MINUTES)).until(ExpectedConditions.elementToBeClickable(draftPage));
        try {
            selectAllBtn.click();
            draftPage.sendKeys(Keys.DELETE);
        } catch (ElementClickInterceptedException e) {
            System.out.println("Папка Черновики пуста");
        }
        return new DraftPage(driver);
    }

    @Override
    protected AbstractPage openPage() {
        throw new RuntimeException("It doesn't work!");
    }
}