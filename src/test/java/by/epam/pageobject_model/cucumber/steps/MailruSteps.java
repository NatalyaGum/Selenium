package by.epam.pageobject_model.cucumber.steps;

import by.epam.pageobject_model.page.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class MailruSteps extends BaseStep{

    HomePage homePage= new HomePage(driver);
    MailFrame mailFrame= new MailFrame(driver);
    DraftPage draftPage= new DraftPage(driver);

    SpamBoxPage spamPage= new SpamBoxPage(driver);
    MailBoxPage mailPage=new MailBoxPage(driver);
    @Given("the user navigates to frame of mail body")
    public void theUserNavigatesToFrameOfMailBody() {
             mailFrame.writeLetter();
    }

    @When("^the user creates mail addressed to \"([^\"]*)\"$")
    public void theUserCreatesMailAddressedTo(String mail) {
        mailFrame.mailCreateWithActions(mail);
    }

    @And("the user saves a draft")
    public void theUserSavesADraft() {
        mailFrame.mailSave();
    }

    @Then("draft to {string} is displayed on draftPage")
    public void draftIsDisplayedOnDraftPage(String mail) {
        mailPage.openDraftPage();
        Assert.assertTrue(draftPage.checkMail(mail), "You didn't create an email!");
    }

    @Given("the user navigates in draftBox with mail")
    public void theUserNavigatesInDraftBoxWithMail() {
        mailPage.openDraftPage();
    }

    @When("the user opens mail and sends it")
    public void theUserOpensMailAndSendsIt() {
        draftPage.openDraft()
                 .sendMail();
    }

    @Then("the mail is in sentBox with the current time")
    public void theMailIsInSentBoxWithTheCurrentTime() {
        Assert.assertTrue(draftPage.openSentBoxPage().checkMailIsInSentBox(),
                "You didn't send an email!");
    }

    @Given("the user navigates in spamBox")
    public void theUserNavigatesInSpamBox() {
        mailPage.openSpamPage();
    }

    @When("the user cleans spamBox")
    public void theUserCleansSpamBox() {
        spamPage.cleanSpam();

    }

    @Then("the spamBox is empty")
    public void theSpamBoxIsEmpty() {
        Assert.assertTrue(spamPage.checkSpamBoxIsEmpty(), "You didn't clean spam box!");
    }

    @When("the user logs out from mailbox")
    public void theUserLogsOutFromMailbox() {
        mailPage.mailruLogout();
    }

    @Then("the user is on Home page and logged out")
    public void theUserIsOnHomePageAndLoggedOut() {
        Assert.assertTrue( homePage.checkForLogOut(), "You didn't log out!");
    }
}
