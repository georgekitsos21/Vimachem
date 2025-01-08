package stepDefinitions;

import base.BaseTests;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.ConfigReader;

public class AddNewContactSteps extends BaseTests {


    @When("I press the add new contact button")
    public void clickNewContactButton() {
        contactPage.clickNewContactButton();
    }

    @Then("I navigate to Add Contact page")
    public void addContactPageShouldBeVisible() {
        contactPage.checkContactUrl(ConfigReader.getProperty("addNewContactPageUrl"));
    }

    @When("I fill all the required fields")
    public void fillAllTheContactsPage() {
        addContactPage.fillContactForm("George", "Kitsos", "1991-08-28",
                "georgekitsos20g@mail.com", "6978533372", "AthensStreet", "AthensStreet2",
                "Attica", "Galatsi", "12345", "Greece");
    }

    @When("I press the submit button")
    public void clickSubmitButton() {
        addContactPage.clickSubmit();
    }


    @Then("I navigate to Contact List Page and I should see the particular contact")
    public void checkIfTheContactAdded() {
            String expectedName = "George Kitsos";
            String expectedBirthDate = "1991-08-28";
            String expectedEmail = "georgekitsos20g@mail.com";
            String expectedPhone = "6978533372";
            String expectedAddress = "AthensStreet AthensStreet2";
            String expectedCityStatePostal = "Attica Galatsi 12345";
            String expectedCountry = "Greece";

            boolean isContactPresent = contactPage.isContactPresentInTable(expectedName, expectedBirthDate, expectedEmail,
                    expectedPhone, expectedAddress, expectedCityStatePostal, expectedCountry);
            Assert.assertTrue("The contact with all provided details is not present in the contact list", isContactPresent);
        }

        @When("I go to Add Contact page")
            public void navigateToAddNewContactPage(){
            contactPage.goToAddANewContactPage();
        }

        @When("I fill all the required fields with invalid date of birth")
        public void addInvalidDateOfBirth(){
            addContactPage.fillContactForm("George", "Kitsos", "testDOB",
                    "georgekitsos20g@mail.com", "6978533372", "AthensStreet", "AthensStreet2",
                    "Attica", "Galatsi", "12345", "Greece");
        }

        @Then("I should see the error message for invalid type of birthday date")
            public void errorMessageShouldBeDisplayed() {
            String actual = addContactPage.getDateOfBirthday();
            String expected = "Contact validation failed: birthdate: Birthdate is invalid";
            Assert.assertEquals("The error message is not the expected", actual, expected);
        }
    }

