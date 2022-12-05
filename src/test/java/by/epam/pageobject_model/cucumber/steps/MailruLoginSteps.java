package by.epam.pageobject_model.cucumber.steps;

import by.epam.pageobject_model.driver.DriverSingleton;
import by.epam.pageobject_model.model.User;
import by.epam.pageobject_model.page.HomePage;
import by.epam.pageobject_model.page.MailBoxPage;
import by.epam.pageobject_model.service.UserCreator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class MailruLoginSteps  {
    WebDriver driver = DriverSingleton.getDriver();
    User testUser = UserCreator.withCredentialsFromProperty();
    HomePage homePage= new HomePage(driver);
    MailBoxPage mailPage=new MailBoxPage(driver);

    @Given("the user navigates to mailru home page")
    public void theUserNavigatesToMailruHomePage() {
        homePage.openPage();
    }
    @When("the user logs in")
    public void theUserClicksSignInButton() {
        homePage.mailruLogin(testUser);
    }
    @Then("user's mailbox page is displayed")
    public void userSMailboxPageIsDisplayed() {
        Assert.assertTrue(mailPage.checkForLogin(), "You didn't enter in the MailBox!");
    }
}
