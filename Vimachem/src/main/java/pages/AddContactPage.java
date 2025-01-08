package pages;

import formObjects.AddressInfo;
import formObjects.ContactInfo;
import formObjects.PersonalInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.WaitHelper;

public class AddContactPage {

    private static final Logger logger = LoggerFactory.getLogger(AddContactPage.class);
    private final WebDriver driver;
    private final WaitHelper waitHelper;
    private final PersonalInfo personalInfo;
    private final AddressInfo addressInfo;
    private final ContactInfo contactInfo;
    private final By submitBtn = By.cssSelector("#submit");
    private final By errorMessage = By.cssSelector("#error");

    public AddContactPage(WebDriver driver) {
        this.driver = driver;
        this.waitHelper = new WaitHelper(driver, 5);
        this.personalInfo = new PersonalInfo(driver);
        this.addressInfo = new AddressInfo(driver);
        this.contactInfo = new ContactInfo(driver);
    }

    public void fillContactForm(String firstName, String lastName, String dob, String email, String phone,
                                String street1, String street2, String city, String state, String postalCode, String country) {
        try {
            logger.info("Starting to fill contact form");

            logger.info("Entering personal information: FirstName: {}, LastName: {}, DOB: {}", firstName, lastName, dob);
            personalInfo.enterFirstName(firstName);
            personalInfo.enterLastName(lastName);
            personalInfo.enterDateOfBirth(dob);

            logger.info("Entering address information: Street1: {}, Street2: {}, City: {}, State: {}, PostalCode: {}, Country: {}",
                    street1, street2, city, state, postalCode, country);
            addressInfo.enterStreet1(street1);
            addressInfo.enterStreet2(street2);
            addressInfo.enterCity(city);
            addressInfo.enterState(state);
            addressInfo.enterPostalCode(postalCode);
            addressInfo.enterCountry(country);

            logger.info("Entering contact information: Email: {}, Phone: {}", email, phone);
            contactInfo.enterEmail(email);
            contactInfo.enterPhone(phone);

            logger.info("Finished filling the contact form");

        } catch (Exception e) {
            logger.error("Error while filling the contact form fields: {}", e.getMessage(), e);
        }
    }

    public void clickSubmit() {
        try {
            logger.info("Attempting to click submit button");
            waitHelper.waitForVisibilityOfElement(submitBtn).click();
            logger.info("Submit button clicked successfully");
        } catch (Exception e) {
            logger.error("Error while clicking submit button: {}", e.getMessage(), e);
        }
    }

    public String getDateOfBirthday() {
        try {
            logger.info("Attempting to fetch the error message.");
            waitHelper.waitForVisibilityOfElement(errorMessage);
            String errorText = driver.findElement(errorMessage).getText();
            logger.info("Error message fetched successfully: {}", errorText);
            return errorText;
        } catch (Exception e) {
            logger.error("Error while fetching the error message. Details: {}", e.getMessage(), e);
        }
        return "";
    }
}