package by.epam.pageobject_model.test;

import by.epam.pageobject_model.driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import by.epam.pageobject_model.utils.TestListener;


@Listeners({TestListener.class})
public class BaseTest {
    protected WebDriver driver;

    protected static final String EMAIL = "leoshpo@mail.ru";

    @BeforeMethod(alwaysRun = true)
    public void seleniumDriverSetup() {
        driver = DriverSingleton.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void driverTearDown() {
        DriverSingleton.closeDriver();
    }
}
