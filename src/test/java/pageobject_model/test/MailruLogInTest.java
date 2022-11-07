package pageobject_model.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject_model.page.HomePage;

public class MailruLogInTest {

    WebDriver driver;
    private static final String LOGIN = "2004nbg";
    private static final String PASSWORD = "!";

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(groups = "main_test")
    public void logInMailruTest()  {
        boolean realResult = new HomePage(driver)
                .openPage()
                .mailruLogin(LOGIN, PASSWORD)
                .checkForLogin();
        Assert.assertTrue(realResult, "You didn't enter in the MailBox!");
    }

    @AfterMethod(alwaysRun = true)
    public void driverTearDown() {
        driver.quit();
        driver = null;
    }
}