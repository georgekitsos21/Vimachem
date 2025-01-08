package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ConfigReader;
import utils.MapHelper;
import utils.WaitHelper;
import utils.WindowManager;

import java.util.List;
import java.util.Map;

public class ContactPage {

    private static final Logger logger = LoggerFactory.getLogger(ContactPage.class);
    private final WebDriver driver;
    private final WaitHelper waitHelper;
    private final WindowManager windowManager;
    private final By addNewContactBtn = By.cssSelector("#add-contact");
    private final By contactsTableRow = By.cssSelector(".contactTable .contactTableBodyRow");

    public ContactPage(WebDriver driver) {
        this.driver = driver;
        this.waitHelper = new WaitHelper(driver, 5);
        this.windowManager = new WindowManager(driver);
        logger.info("ContactPage initialized successfully.");
    }

    public String checkContactUrl(String expectedUrl) {
        try {
            logger.info("Waiting for the URL to match: {}", expectedUrl);
            waitHelper.waitForUrlToBe(expectedUrl);
            String currentUrl = driver.getCurrentUrl();
            logger.info("Current URL is: {}", currentUrl);
            return currentUrl;
        } catch (Exception e) {
            logger.error("Error while checking the contact URL. Details: {}", e.getMessage(), e);
            return "";
        }
    }

    public void clickNewContactButton() {
        try {
            logger.info("Attempting to click 'Add New Contact' button.");
            waitHelper.waitForVisibilityOfElement(addNewContactBtn).click();
            logger.info("'Add New Contact' button clicked successfully.");
        } catch (Exception e) {
            logger.error("Error while clicking 'Add New Contact' button. Details: {}", e.getMessage(), e);
        }
    }

    public boolean isContactPresentInTable(String contactName, String birthDate, String email, String phone, String address, String cityStatePostal, String country) {
        try {
            logger.info("Checking if contact is present in the table with details: Name: {}, DOB: {}, Email: {}, Phone: {}, Address: {}, City/State/Postal: {}, Country: {}",
                    contactName, birthDate, email, phone, address, cityStatePostal, country);

            waitHelper.waitForVisibilityOfElement(contactsTableRow);
            List<WebElement> contactRows = driver.findElements(contactsTableRow);
            logger.info("Number of contact rows found: {}", contactRows.size());

            for (WebElement row : contactRows) {
                List<WebElement> columns = row.findElements(By.tagName("td"));
                Map<String, String> contactDetails = MapHelper.extractContactDetails(columns);  // Extract details using MapHelper

                if (compareContactDetails(contactDetails, contactName, birthDate, email, phone, address, cityStatePostal, country)) {
                    logger.info("Contact found in the table.");
                    return true;
                }
            }

            logger.info("Contact not found in the table.");
            return false;
        } catch (Exception e) {
            logger.error("Error while checking for contact in the table. Details: {}", e.getMessage(), e);
            return false;
        }
    }

    private boolean compareContactDetails(Map<String, String> contactDetails, String contactName, String birthDate, String email, String phone, String address, String cityStatePostal, String country) {
        return contactDetails.get("Name").equals(contactName) &&
                contactDetails.get("DOB").equals(birthDate) &&
                contactDetails.get("Email").equals(email) &&
                contactDetails.get("Phone").equals(phone) &&
                contactDetails.get("Address").equals(address) &&
                contactDetails.get("City/State/Postal").equals(cityStatePostal) &&
                contactDetails.get("Country").equals(country);
    }

    public void goToAddANewContactPage() {
        try {
            String url = ConfigReader.getProperty("addNewContactPageUrl");
            logger.info("Navigating to 'Add New Contact' page: {}", url);
            windowManager.goTo(url);
            logger.info("Navigation to 'Add New Contact' page successful.");
        } catch (Exception e) {
            logger.error("Error while navigating to 'Add New Contact' page. Details: {}", e.getMessage(), e);
        }
    }

    public void goToContactListPage() {
        try {
            String url = ConfigReader.getProperty("contactListPageUrl");
            logger.info("Navigating to 'Contact List' page: {}", url);
            windowManager.goBack(url);
            logger.info("Navigation to 'Contact List' page successful.");
            logger.info("Clicking on first contact row in the table.");
            driver.findElement(contactsTableRow).click();
            logger.info("Clicked on the first contact row.");
        } catch (Exception e) {
            logger.error("Error while navigating to 'Contact List' page. Details: {}", e.getMessage(), e);
        }
    }

    public void navigateToContactPage() {
        waitHelper.waitForUrlToBe(ConfigReader.getProperty("contactListPageUrl"));
    }

    public boolean areContactsNotPresent() {
        List<WebElement> contactRows = driver.findElements(contactsTableRow);
        return contactRows.isEmpty();
    }
}

