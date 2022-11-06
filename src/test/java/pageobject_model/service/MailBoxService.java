package pageobject_model.service;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject_model.page.MailBoxPage;

import java.time.Duration;

public class MailBoxService extends MailBoxPage {

    public MailBoxService(WebDriver driver) {
        super(driver);
    }


    }

