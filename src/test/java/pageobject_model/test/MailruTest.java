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

    @BeforeMethod(alwaysRun = true)
    public void brovserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void logInMailru() throws InterruptedException {

        boolean realResult = new HomePage(driver)
                .mailruOpen()
                .mailruLogin("2004nbg", " ")
                .checkForLogin();
        Assert.assertTrue(realResult, "is not login!");
    }

    @AfterMethod(alwaysRun = true)
    public void druverTearDown() {
        driver.quit();
        driver = null;
    }
}