package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SignUpPage {

    private static final Logger logger = LoggerFactory.getLogger(SignUpPage.class);

    private final WebDriver driver;
    private final By firstNameField = By.cssSelector("#firstName");
    private final By lastNameField = By.cssSelector("#lastName");
    private final By emailField = By.cssSelector("#email");
    private final By passwordField = By.cssSelector("#password");
    private final By submitBtn = By.cssSelector("#submit");

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        logger.info("SignUpPage initialized successfully.");
    }

    public void fillFirstName(String name) {
        try {
            logger.info("Filling in the first name: {}", name);
            driver.findElement(firstNameField).sendKeys(name);
            logger.info("First name filled successfully.");
        } catch (Exception e) {
            logger.error("Error while filling in the first name. Details: {}", e.getMessage(), e);
        }
    }

    public void fillLastName(String lastName) {
        try {
            logger.info("Filling in the last name: {}", lastName);
            driver.findElement(lastNameField).sendKeys(lastName);
            logger.info("Last name filled successfully.");
        } catch (Exception e) {
            logger.error("Error while filling in the last name. Details: {}", e.getMessage(), e);
        }
    }

    public void fillTheEmail(String email) {
        try {
            logger.info("Filling in the email: {}", email);
            driver.findElement(emailField).sendKeys(email);
            logger.info("Email filled successfully.");
        } catch (Exception e) {
            logger.error("Error while filling in the email. Details: {}", e.getMessage(), e);
        }
    }

    public void fillThePassword(String password) {
        try {
            logger.info("Filling in the password.");
            driver.findElement(passwordField).sendKeys(password);
            logger.info("Password filled successfully.");
        } catch (Exception e) {
            logger.error("Error while filling in the password. Details: {}", e.getMessage(), e);
        }
    }

    public void clickSubmitBtn() {
        try {
            logger.info("Attempting to click the submit button.");
            driver.findElement(submitBtn).click();
            logger.info("Submit button clicked successfully. Navigating to ContactPage.");
            new ContactPage(driver);
        } catch (Exception e) {
            logger.error("Error while clicking the submit button. Details: {}", e.getMessage(), e);
        }
    }
}
