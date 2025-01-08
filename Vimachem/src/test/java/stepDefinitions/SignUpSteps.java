package stepDefinitions;

import base.BaseTests;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.ConfigReader;

public class SignUpSteps extends BaseTests {

    @Given("I am on the sign-up page")
    public void test() {
        loginPage.clickTheSignUpBtn();
    }

    @When("I enter valid registration details")
    public void addName() {
        signUpPage.fillFirstName("george");
        signUpPage.fillLastName("softareEngineer");
        signUpPage.fillTheEmail("VimachemAssignment2k@test.com");
        signUpPage.fillThePassword("Marcfit21");
    }

    @When("I click the submit button")
    public void clickSubmitButton() {
       signUpPage.clickSubmitBtn();
    }

    @Then("I should be registered and redirected to the contact page")
    public void  contactPageShouldBeAvailable() {
        String expectedUrl = ConfigReader.getProperty("contactListPageUrl");
        String actualUrl = contactPage.checkContactUrl(expectedUrl);
        Assert.assertEquals("The expected URL is not the same with the actual", actualUrl, expectedUrl);
    }
}
