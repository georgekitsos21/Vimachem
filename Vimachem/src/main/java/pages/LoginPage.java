package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.NoSuchElementException;

public class LoginPage {

    private static final Logger log = LoggerFactory.getLogger(LoginPage.class);
    private final WebDriver driver;
    private final By emailField = By.id("email");
    private final By passwordField = By.id("password");
    private final By submitBtn = By.id("submit");
    private final By signUpBtn = By.id("signup");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        log.info("LoginPage initialized successfully.");
    }

    public void fillTheEmail(String email) {
        try {
            log.info("Filling in the email field with value: {}", email);
            driver.findElement(emailField).sendKeys(email);
            log.info("Email field filled successfully.");
        } catch (NoSuchElementException e) {
            log.error("Email field was not found: {}", e.getMessage(), e);
        } catch (WebDriverException e) {
            log.error("An error occurred while interacting with the email field: {}", e.getMessage(), e);
        }
    }

    public void fillThePassword(String password) {
        try {
            log.info("Filling in the password field.");
            driver.findElement(passwordField).sendKeys(password);
            log.info("Password field filled successfully.");
        } catch (NoSuchElementException e) {
            log.error("Password field was not found: {}", e.getMessage(), e);
        } catch (WebDriverException e) {
            log.error("An error occurred while interacting with the password field: {}", e.getMessage(), e);
        }
    }

    public ContactPage clickTheSubmitBtn() {
        try {
            log.info("Attempting to click the submit button.");
            driver.findElement(submitBtn).click();
            log.info("Submit button clicked successfully. Navigating to ContactPage.");
            return new ContactPage(driver);
        } catch (NoSuchElementException e) {
            log.error("Submit button was not found: {}", e.getMessage(), e);
        } catch (WebDriverException e) {
            log.error("An error occurred while interacting with the submit button: {}", e.getMessage(), e);
        }
        return null;
    }

    public void clickTheSignUpBtn() {
        try {
            log.info("Attempting to click the sign-up button.");
            driver.findElement(signUpBtn).click();
            log.info("Sign-up button clicked successfully.");
        } catch (NoSuchElementException e) {
            log.error("Sign-up button was not found: {}", e.getMessage(), e);
        } catch (WebDriverException e) {
            log.error("An error occurred while interacting with the sign-up button: {}", e.getMessage(), e);
        }
    }
}
