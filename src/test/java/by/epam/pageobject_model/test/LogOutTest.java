package by.epam.pageobject_model.test;

import by.epam.pageobject_model.model.User;
import by.epam.pageobject_model.page.HomePage;
import by.epam.pageobject_model.page.MailBoxPage;
import by.epam.pageobject_model.service.UserCreator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogOutTest extends BaseTest {
    MailBoxPage page;

    @BeforeMethod(alwaysRun = true)
    public void pageSetup() {
        User testUser = UserCreator.withCredentialsFromProperty();
        page = new HomePage(driver)
                .openPage()
                .mailruLogin(testUser);
    }

    @Test(groups = "mail_log_out_test")
    public void logOutTest() {
        boolean realResult = page
                .mailruLogout()
                .checkForLogOut();
        Assert.assertTrue(realResult, "You didn't log out!");
    }
}