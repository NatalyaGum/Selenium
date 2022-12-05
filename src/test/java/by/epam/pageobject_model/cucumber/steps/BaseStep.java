package by.epam.pageobject_model.cucumber.steps;

import by.epam.pageobject_model.driver.DriverSingleton;
import org.openqa.selenium.WebDriver;

public class BaseStep {
    protected WebDriver driver= DriverSingleton.getDriver();
}
