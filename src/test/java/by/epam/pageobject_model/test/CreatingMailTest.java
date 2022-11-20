package by.epam.pageobject_model.test;

import by.epam.pageobject_model.model.User;
import by.epam.pageobject_model.service.UserCreator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import by.epam.pageobject_model.page.HomePage;
import by.epam.pageobject_model.page.MailBoxPage;

public class CreatingMailTest extends BaseTest{

    MailBoxPage page;

    @BeforeMethod(alwaysRun = true)
    public void pageSetup() {
        User testUser = UserCreator.withCredentialsFromProperty();
        page = new HomePage(driver)
                .openPage()
                .mailruLogin(testUser);
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