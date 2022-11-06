package pageobject_model.page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

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
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("kk:mm");
    @FindBy(xpath = "(//div[@class='llc__item llc__item_date'])[1]")
    private WebElement timeOfDraft;

    public DraftPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkMail(String text) {
        new WebDriverWait(driver, Duration.ofMinutes(WAIT_TIMEOUT_MINUTES)).until(ExpectedConditions.visibilityOf(draftPage));
        return correspondent.getText().equals(text) & subject.getText().equals(text) & bodyOfMail.getText().startsWith(text);
    }

    public MailFrame openDraft() {
        new WebDriverWait(driver, Duration.ofMinutes(WAIT_TIMEOUT_MINUTES)).until(ExpectedConditions.visibilityOf(draftPage));
        correspondent.click();
        driver.switchTo().parentFrame();
        System.out.println(driver.findElements(By.tagName("iframe")).size());
        return new MailFrame(driver);
    }

    public SentBoxPage openSentBoxPage() throws InterruptedException {
        new WebDriverWait(driver, Duration.ofMinutes(WAIT_TIMEOUT_MINUTES)).until(ExpectedConditions.elementToBeClickable(sentPageBtn));
        sentPageBtn.click();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(WAIT_TIMEOUT_MINUTES));
        return new SentBoxPage(driver);
    }


    public boolean checkMailIsSent() throws InterruptedException {
        boolean mailIsSent = false;
        new WebDriverWait(driver, Duration.ofMinutes(WAIT_TIMEOUT_MINUTES)).until(ExpectedConditions.visibilityOf(draftPage));
        Thread.sleep(8000);
        System.out.println(driver.findElements(By.xpath("(//div[@class='llc__item llc__item_date'])[1]")).isEmpty());
        if (driver.findElements(By.xpath("(//div[@class='llc__item llc__item_date'])[1]")).isEmpty()) {
            mailIsSent = true;
        } else {
            mailIsSent = !((timeOfDraft.getText().equals(LocalTime.now().format(FORMATTER))
                    | (timeOfDraft.getText().equals(LocalTime.now().minusMinutes(1).format(FORMATTER)))
                    | (timeOfDraft.getText().equals(LocalTime.now().plusMinutes(1).format(FORMATTER)))));
        }

        System.out.println(timeOfDraft.getText());
        System.out.println(LocalTime.now().minusMinutes(1));
        System.out.println(mailIsSent);
        return mailIsSent;
    }

    public SentBoxPage openSentBoxPage() throws InterruptedException {
        new WebDriverWait(driver, Duration.ofMinutes(WAIT_TIMEOUT_MINUTES)).until(ExpectedConditions.elementToBeClickable(sentPageBtn));
        sentPageBtn.click();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(WAIT_TIMEOUT_MINUTES));
        return new SentBoxPage(driver);
    }

    @Override
    protected AbstractPage openPage() {
        throw new RuntimeException("It doesn't work!");
    }
}