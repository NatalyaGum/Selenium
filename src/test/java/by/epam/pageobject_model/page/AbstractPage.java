package by.epam.pageobject_model.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {

    protected WebDriver driver;

    protected abstract AbstractPage openPage();

    protected final Logger LOGGER = LogManager.getRootLogger();
    protected static final int WAIT_TIMEOUT_SECONDS = 120;
    protected static final int WAIT_TIMEOUT_MINUTES = 3;

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
