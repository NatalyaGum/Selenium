package pageobject_model.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject_model.page.HomePage;
import pageobject_model.page.MailBoxPage;

public class CreatingMailTest {

    WebDriver driver;

    MailBoxPage page;
    private static final String LOGIN = "2004nbg";
    private static final String PASSWORD = "";

    private static final String EMAIL = "2004nbg@mail.ru";

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        page=new HomePage(driver)
                .openPage()
                .mailruLogin(LOGIN, PASSWORD);
    }

    @Test (groups= "mail_create_test")
    public void createMailTest() throws InterruptedException {

        boolean realResult=page.writeLetter()
                .mailCreate(EMAIL)
                .mailSave()
                .openDraftPage()
                .checkMail(EMAIL) ;
        Assert.assertTrue(realResult, "You didn't create an email!");
    }

    @AfterMethod(alwaysRun = true)
    public void druverTearDown() {
        driver.quit();
        driver = null;
    }
}