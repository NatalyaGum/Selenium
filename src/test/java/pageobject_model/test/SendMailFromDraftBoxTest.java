package pageobject_model.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject_model.page.HomePage;
import pageobject_model.page.DraftPage;

public class SendMailFromDraftBoxTest {

    WebDriver driver;
    DraftPage page;

    private static final String LOGIN = "2004nbg";
    private static final String PASSWORD = "!";
    private static final String EMAIL = "2004nbg@mail.ru";

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        page = new HomePage(driver)
                .openPage()
                .mailruLogin(LOGIN, PASSWORD)
                .openDraftPage()
                .removeDrafts()
                .openMailBoxPage()
                .writeLetter()
                .mailCreate(EMAIL)
                .mailSave()
                .openDraftPage();
    }


    @Test(groups = "mail_sent_from_draft_test")
    public void sentMailTest() throws InterruptedException {
        boolean mailIsSent = page.openDraft()
                .sendMail()
                .checkMailIsSent();
        boolean mailIsInSentBox = page.openSentBoxPage()
                .checkMailIsInSentBox();
        Assert.assertTrue(mailIsSent, "You didn't send an email from draft box!");
        Assert.assertTrue(mailIsInSentBox, "You didn't send an email!");
    }

    @AfterMethod(alwaysRun = true)
    public void driverTearDown() {
        driver.quit();
        driver = null;
    }
}
