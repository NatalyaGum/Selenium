package pageobject_model.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DraftPage extends AbstractPage {

    @FindBy(xpath = "//a[@class='nav__item js-shortcut nav__item_active nav__item_shortcut nav__item_expanded_true nav__item_child-level_0' and @href='/drafts/']")
    private WebElement draftPage;
    @FindBy(xpath = "//*[@id='app-canvas']/div/div[1]/div[1]/div/div[2]/span/div[2]/div/div/div/div/div[1]/div/div/div/div[1]/div/div/a[1]/div[4]/div/div[1]/span")
    private WebElement correspondent;
    @FindBy(xpath = "//*[@id='app-canvas']/div/div[1]/div[1]/div/div[2]/span/div[2]/div/div/div/div/div[1]/div/div/div/div[1]/div/div/a[1]/div[4]/div/div[3]/span[1]/div/span")
    private WebElement subject;
    @FindBy(xpath = "//*[@id=\"app-canvas\"]/div/div[1]/div[1]/div/div[2]/span/div[2]/div/div/div/div/div[1]/div/div/div/div[1]/div/div/a[1]/div[4]/div/div[3]/span[2]/div/span")
    private WebElement bodyOfMail;

    public DraftPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkMail(String text) {
        new WebDriverWait(driver, Duration.ofMinutes(WAIT_TIMEOUT_MINUTES)).until(ExpectedConditions.visibilityOf(draftPage));
        return correspondent.getText().equals(text)&subject.getText().equals(text)&bodyOfMail.getText().startsWith(text) ;
    }

    @Override
    protected AbstractPage openPage() {
        throw new RuntimeException("It doesn't work!");
    }
}