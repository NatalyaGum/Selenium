package by.epam.pageobject_model.test;

import by.epam.pageobject_model.model.User;
import by.epam.pageobject_model.page.HomePage;
import by.epam.pageobject_model.service.UserCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MailruLogInTest extends BaseTest {

    @Test(groups = "main_test")
    public void logInMailruTest() {
        User testUser = UserCreator.withCredentialsFromProperty();
        boolean realResult = new HomePage(driver)
                .openPage()
                .scrollDown()
                .mailruLogin(testUser)
                .checkForLogin();
        Assert.assertTrue(realResult, "You didn't enter in the MailBox!");
    }
}