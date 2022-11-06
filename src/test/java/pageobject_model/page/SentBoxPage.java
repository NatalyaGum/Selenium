package pageobject_model.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class SentBoxPage extends AbstractPage{

    protected SentBoxPage(WebDriver driver) {
        super(driver);
    }
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("kk:mm");
    @FindBy(xpath = "(//div[@class='llc__item llc__item_date'])[1]")
    private WebElement timeOfSent;

    public boolean checkMailIsInSentBox() {
        new WebDriverWait(driver, Duration.ofMinutes(WAIT_TIMEOUT_MINUTES)).until(ExpectedConditions.visibilityOf(timeOfSent));
        timeOfSent.getText().equals(LocalTime.now().format(FORMATTER));
        System.out.println(timeOfSent.getText());
        System.out.println(LocalTime.now());
        return true;
    }

    @Override
    protected AbstractPage openPage() {
        throw new RuntimeException("It doesn't work!");
    }
}
