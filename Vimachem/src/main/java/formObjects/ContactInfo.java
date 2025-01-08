package formObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitHelper;

public class ContactInfo {
    private final WaitHelper waitHelper;
    private final By emailField = By.cssSelector("#email");
    private final By phoneField = By.cssSelector("#phone");

    public ContactInfo(WebDriver driver) {
        this.waitHelper = new WaitHelper(driver,5);
    }

    public void enterEmail(String email) {
        waitHelper.waitForVisibilityOfElement(emailField).sendKeys(email);
    }

    public void enterPhone(String phone) {
        waitHelper.waitForVisibilityOfElement(phoneField).sendKeys(phone);
    }
}
