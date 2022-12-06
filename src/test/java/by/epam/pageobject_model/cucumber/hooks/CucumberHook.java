package by.epam.pageobject_model.cucumber.hooks;

import by.epam.pageobject_model.driver.DriverSingleton;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;

public class CucumberHook {
    protected WebDriver driver;

    @After
    public void driverTearDown() {
        DriverSingleton.closeDriver();
    }
}
