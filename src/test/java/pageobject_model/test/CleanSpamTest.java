package pageobject_model.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject_model.page.HomePage;
import pageobject_model.page.MailBoxPage;

public class CleanSpamTest extends BaseTest {
    MailBoxPage page;

    @BeforeMethod(alwaysRun = true)
    public void pageSetup() {
        page = new HomePage(driver)
                .openPage()
                .mailruLogin(LOGIN, PASSWORD);
    }

    @Test(groups = "spam_test")
    public void spamMailruTest() throws InterruptedException {
        boolean realResult = page
                .openSpamPage()
                .cleanSpam()
                .checkSpamBoxIsEmpty();
        Assert.assertTrue(realResult, "You didn't clean spam box!");
    }

}