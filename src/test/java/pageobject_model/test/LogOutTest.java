package pageobject_model.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject_model.page.HomePage;
import pageobject_model.page.MailBoxPage;

public class LogOutTest {

    WebDriver driver;
    MailBoxPage page;

    private static final String LOGIN = "2004nbg";
    private static final String PASSWORD = "!";


    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        page = new HomePage(driver)
                .openPage()
                .mailruLogin(LOGIN, PASSWORD);
    }

    @Test(groups = "mail_log_out_test")
    public void createMailTest() {
        boolean realResult = page
                .mailruLogout()
                .checkForLogOut();
        Assert.assertTrue(realResult, "You didn't log out!");
    }

    @AfterMethod(alwaysRun = true)
    public void driverTearDown() {
        driver.quit();
        driver = null;
    }
}