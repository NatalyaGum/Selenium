package by.epam.pageobject_model.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class SentBoxPage extends AbstractPage {

    protected SentBoxPage(WebDriver driver) {
        super(driver);
    }

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("H:mm");
    @FindBy(xpath = "(//div[@class='llc__item llc__item_date'])[1]")
    private WebElement timeOfSent;

    @FindBy(xpath = "//a[@class='nav__item js-shortcut nav__item_active nav__item_shortcut nav__item_expanded_true nav__item_child-level_0' and @href='/sent/?']")
    private WebElement SentBoxPage;

    public boolean checkMailIsInSentBox() {
        new WebDriverWait(driver, Duration.ofMinutes(WAIT_TIMEOUT_MINUTES)).until(ExpectedConditions.visibilityOf(SentBoxPage));
        new WebDriverWait(driver, Duration.ofMinutes(WAIT_TIMEOUT_MINUTES)).until(ExpectedConditions.visibilityOf(timeOfSent));
        return (timeOfSent.getText().equals(LocalTime.now().format(FORMATTER))
                | (timeOfSent.getText().equals(LocalTime.now().plusMinutes(1).format(FORMATTER))));
    }

    @Override
    protected AbstractPage openPage() {
        LOGGER.error("It doesn't work!");
        throw new RuntimeException("It doesn't work!");
    }
}
