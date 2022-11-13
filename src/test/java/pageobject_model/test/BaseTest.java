package pageobject_model.test;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;


public class BaseTest {
    WebDriver driver;
    protected static final String LOGIN = "2004nbg";
    protected static final String PASSWORD = "";
    protected static final String EMAIL = "2004nbg@mail.ru";

    @BeforeMethod(alwaysRun = true)
    public void seleniumGridSetup() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setPlatform(Platform.WIN10);
        capabilities.setBrowserName("chrome");
        try {
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void driverTearDown() {
        driver.quit();
        driver = null;
    }
}
