package stepDefinitions;

import base.BaseTests;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class DeleteContactSteps extends BaseTests {

    @When("I go to Contact List Page")
    public void navigateToContactPage() {
        contactPage.goToContactListPage();
    }

    @When("I navigate to Contact Details and delete the particular contact")
    public void deleteTheContact() {
        contactsDetails.clickDeleteContactButton();
    }

    @Then("I navigate back to the Contact Page")
    public void verifyContactIsNotVisible() {
        contactPage.navigateToContactPage();
        boolean contactsPresent = contactPage.areContactsNotPresent();
        Assert.assertTrue("The particular contact has been deleted", contactsPresent);
    }
}

