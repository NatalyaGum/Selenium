package pageobject_model.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SpamBoxPage extends AbstractPage {
    @FindBy(xpath = "//a[@class='nav__item nav__item_active nav__item_shortcut nav__item_expanded_true nav__item_child-level_0' and @href='/spam/']")
    private WebElement spamPage;

    @FindBy(xpath = "//span[text()='Выделить все']")
    private WebElement selectAllBtn;

    protected SpamBoxPage(WebDriver driver) {
        super(driver);
    }

    public SpamBoxPage cleanSpam() {
        new WebDriverWait(driver, Duration.ofMinutes(WAIT_TIMEOUT_MINUTES)).until(ExpectedConditions.elementToBeClickable(spamPage));
        try {
            selectAllBtn.click();
            spamPage.sendKeys(Keys.DELETE);

        } catch (ElementClickInterceptedException e) {
            System.out.println("Папка Черновики пуста");
        }
        return new SpamBoxPage(driver);
    }

    public boolean checkSpamBoxIsEmpty() {

        new WebDriverWait(driver, Duration.ofMinutes(WAIT_TIMEOUT_MINUTES)).until(ExpectedConditions.visibilityOf(spamPage));
        System.out.println(driver.findElements(By.xpath("//div[@class='llc__item llc__item_date']")).isEmpty());
        return driver.findElements(By.xpath("//div[@class='llc__item llc__item_date']")).isEmpty();
    }

    @Override
    protected AbstractPage openPage() {
        throw new RuntimeException("It doesn't work!");
    }
}
