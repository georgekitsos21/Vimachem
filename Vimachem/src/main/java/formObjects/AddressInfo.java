package formObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitHelper;

public class AddressInfo {
    private final WaitHelper waitHelper;
    private final By street1Field = By.cssSelector("#street1");
    private final By street2Field = By.cssSelector("#street2");
    private final By cityField = By.cssSelector("#city");
    private final By stateField = By.cssSelector("#stateProvince");
    private final By postalCodeField = By.cssSelector("#postalCode");
    private final By countryField = By.cssSelector("#country");

    public AddressInfo(WebDriver driver) {
        this.waitHelper = new WaitHelper(driver,5);
    }

    public void enterStreet1(String street1) {
        waitHelper.waitForVisibilityOfElement(street1Field).sendKeys(street1);
    }

    public void enterStreet2(String street2) {
        waitHelper.waitForVisibilityOfElement(street2Field).sendKeys(street2);
    }

    public void enterCity(String city) {
        waitHelper.waitForVisibilityOfElement(cityField).sendKeys(city);
    }

    public void enterState(String state) {
        waitHelper.waitForVisibilityOfElement(stateField).sendKeys(state);
    }

    public void enterPostalCode(String postalCode) {
        waitHelper.waitForVisibilityOfElement(postalCodeField).sendKeys(postalCode);
    }

    public void enterCountry(String country) {
        waitHelper.waitForVisibilityOfElement(countryField).sendKeys(country);
    }
}
