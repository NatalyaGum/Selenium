package by.epam.pageobject_model.cucumber.steps;

import by.epam.pageobject_model.page.DraftPage;
import by.epam.pageobject_model.page.MailBoxPage;
import by.epam.pageobject_model.page.MailFrame;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class MailCreateSteps extends BaseStep{

    MailFrame mailFrame= new MailFrame(driver);
    DraftPage draftPage= new DraftPage(driver);
    MailBoxPage mailPage=new MailBoxPage(driver);
    @Given("the user navigates to frame of mail body")
    public void theUserNavigatesToFrameOfMailBody() {
             mailFrame.writeLetter();
    }

    @When("the user creates mail addressed to {string}")
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
}
