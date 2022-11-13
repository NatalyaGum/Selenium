package pageobject_model.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject_model.page.HomePage;
import pageobject_model.page.MailBoxPage;

public class CreatingMailTest extends BaseTest{

    MailBoxPage page;

    @BeforeMethod(alwaysRun = true)
    public void pageSetup() {
        page = new HomePage(driver)
                .openPage()
                .mailruLoginWithActions(LOGIN, PASSWORD);
    }

    @Test(groups = "mail_create_test")
    public void createMailTest() {
        boolean realResult = page.writeLetter()
                .mailCreateWithActions(EMAIL)
                .mailSave()
                .openDraftPage()
                .checkMail(EMAIL);
        Assert.assertTrue(realResult, "You didn't create an email!");
    }
}