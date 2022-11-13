package pageobject_model.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject_model.page.HomePage;

public class MailruLogInTest extends BaseTest {

    @Test(groups = "main_test")
    public void logInMailruTest() {
        boolean realResult = new HomePage(driver)
                .openPage()
                .scrollDown()
                .mailruLoginWithJsExec(LOGIN, PASSWORD)
                .checkForLogin();
        Assert.assertTrue(realResult, "You didn't enter in the MailBox!");
    }
}