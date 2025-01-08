package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ConfigReader;
import utils.WaitHelper;

public class ContactsDetails {

    private static final Logger logger = LoggerFactory.getLogger(ContactsDetails.class);
    private final WebDriver driver;
    private final WaitHelper waitHelper;
    private final By deleteContactBtn = By.cssSelector("#delete");

    public ContactsDetails(WebDriver driver) {
        this.driver = driver;
        this.waitHelper = new WaitHelper(driver, 5);
        logger.info("ContactsDetails page initialized successfully.");
    }

    public void clickDeleteContactButton() {
        try {
            logger.info("Waiting for the Contact Details page URL to load.");
            waitHelper.waitForUrlToBe(ConfigReader.getProperty("contactDetailsUrl"));

            logger.info("Attempting to click the 'Delete Contact' button.");
            driver.findElement(deleteContactBtn).click();

            logger.info("Confirming the delete action in the alert dialog.");
            driver.switchTo().alert().accept();

            logger.info("Waiting for the Contact List page URL to load after deletion.");
            waitHelper.waitForUrlToBe(ConfigReader.getProperty("contactListPageUrl"));
            logger.info("'Delete Contact' action completed successfully.");
        } catch (Exception e) {
            logger.error("Error while attempting to delete contact. Details: {}", e.getMessage(), e);
        }
    }
}
