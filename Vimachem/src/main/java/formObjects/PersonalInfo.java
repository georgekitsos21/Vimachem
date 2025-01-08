package formObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitHelper;

public class PersonalInfo {
    private final WaitHelper waitHelper;
    private final By firstName = By.cssSelector("#firstName");
    private final By lastName = By.cssSelector("#lastName");
    private final By dateOfBirth = By.cssSelector("#birthdate");

    public PersonalInfo(WebDriver driver) {
        this.waitHelper = new WaitHelper(driver,5);
    }

    public void enterFirstName(String firstNameValue) {
       waitHelper.waitForVisibilityOfElement(firstName).sendKeys(firstNameValue);
    }

    public void enterLastName(String lastNameValue) {
         waitHelper.waitForVisibilityOfElement(lastName).sendKeys(lastNameValue);
    }

    public void enterDateOfBirth(String dob) {
        waitHelper.waitForVisibilityOfElement(dateOfBirth).sendKeys(dob);
    }
}
