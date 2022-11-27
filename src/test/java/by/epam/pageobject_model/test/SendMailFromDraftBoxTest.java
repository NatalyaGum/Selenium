package by.epam.pageobject_model.test;

import by.epam.pageobject_model.model.User;
import by.epam.pageobject_model.service.UserCreator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import by.epam.pageobject_model.page.HomePage;
import by.epam.pageobject_model.page.DraftPage;

public class SendMailFromDraftBoxTest extends BaseTest {

    DraftPage page;

    @BeforeMethod(alwaysRun = true)
    public void pageSetup() {
        User testUser = UserCreator.withCredentialsFromProperty();
        page = new HomePage(driver)
                .openPage()
                .mailruLogin(testUser)
                .openDraftPage()
                .scrollDown()
                .removeDrafts()
                .openMailBoxPage()
                .writeLetter()
                .mailCreate(EMAIL)
                .mailSave()
                .openDraftPage();
    }

    @Test(groups = "mail_sent_from_draft_test")
    public void sentMailTest() {
        boolean mailIsSent = page.openDraft()
                .sendMail()
                .checkMailIsSent();
        boolean mailIsInSentBox = page.openSentBoxPage()
                .checkMailIsInSentBox();
        Assert.assertTrue(mailIsSent, "You didn't send an email from draft box!");
        Assert.assertTrue(mailIsInSentBox, "You didn't send an email!");
    }
}
