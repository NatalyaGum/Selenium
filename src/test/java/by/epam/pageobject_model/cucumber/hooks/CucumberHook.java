package by.epam.pageobject_model.cucumber.hooks;

import by.epam.pageobject_model.driver.DriverSingleton;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class CucumberHook {
    protected WebDriver driver;
    protected final Logger LOGGER = LogManager.getRootLogger();

    @Before
    public void seleniumDriverSetup() {
        driver = DriverSingleton.getDriver();
        LOGGER.info("GetDriver");

    }

    @After
    public void driverTearDown() {
        DriverSingleton.closeDriver();
        LOGGER.info("CloseDriver");
    }
}
