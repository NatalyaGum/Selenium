package by.epam.pageobject_model.test;

import by.epam.pageobject_model.model.User;
import by.epam.pageobject_model.service.UserCreator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import by.epam.pageobject_model.page.HomePage;
import by.epam.pageobject_model.page.MailBoxPage;

public class CleanSpamTest extends BaseTest {
    MailBoxPage page;

    @BeforeMethod(alwaysRun = true)
    public void pageSetup() {
        User testUser = UserCreator.withCredentialsFromProperty();
        page = new HomePage(driver)
                .openPage()
                .mailruLogin(testUser);
    }

    @Test(groups = "spam_test")
    public void spamMailruTest()  {
        boolean realResult = page
                .openSpamPage()
                .cleanSpam()
                .checkSpamBoxIsEmpty();
        Assert.assertTrue(realResult, "You didn't clean spam box!");
    }

}