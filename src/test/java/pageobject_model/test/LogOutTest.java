package pageobject_model.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject_model.page.HomePage;
import pageobject_model.page.MailBoxPage;

public class LogOutTest extends BaseTest {
    MailBoxPage page;

    @BeforeMethod(alwaysRun = true)
    public void pageSetup() {
        page = new HomePage(driver)
                .openPage()
                .mailruLogin(LOGIN, PASSWORD);
    }

    @Test(groups = "mail_log_out_test")
    public void logOutTest() {
        boolean realResult = page
                .mailruLogout()
                .checkForLogOut();
        Assert.assertTrue(realResult, "You didn't log out!");
    }
}