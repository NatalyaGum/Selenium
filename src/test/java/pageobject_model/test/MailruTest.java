package pageobject_model.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject_model.page.HomePage;

public class MailruTest {

    WebDriver driver;
    private static final String LOGIN = "2004nbg";
    private static final String PASSWORD = "M10082019!";

    @BeforeMethod(alwaysRun = true)
    public void brovserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void logInMailru() throws InterruptedException {

        boolean realResult = new HomePage(driver)
                .openPage()
                .mailruLogin(LOGIN, PASSWORD)
                .checkForLogin();
        Assert.assertTrue(realResult, "You didn't enter in the MailBox!");
    }

    @AfterMethod(alwaysRun = true)
    public void druverTearDown() {
        driver.quit();
        driver = null;
    }
}