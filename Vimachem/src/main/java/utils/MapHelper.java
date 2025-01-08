package utils;

import org.openqa.selenium.WebElement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapHelper {

    private static final int NAME_INDEX = 1;
    private static final int DOB_INDEX = 2;
    private static final int EMAIL_INDEX = 3;
    private static final int PHONE_INDEX = 4;
    private static final int ADDRESS_INDEX = 5;
    private static final int CITY_STATE_POSTAL_INDEX = 6;
    private static final int COUNTRY_INDEX = 7;

    public static Map<String, String> extractContactDetails(List<WebElement> columns) {
        Map<String, String> contactDetails = new HashMap<>();

        if (columns.size() < 8) {
            throw new IllegalArgumentException("Row does not contain enough columns.");
        }

        contactDetails.put("Name", columns.get(NAME_INDEX).getText().trim());
        contactDetails.put("DOB", columns.get(DOB_INDEX).getText().trim());
        contactDetails.put("Email", columns.get(EMAIL_INDEX).getText().trim());
        contactDetails.put("Phone", columns.get(PHONE_INDEX).getText().trim());
        contactDetails.put("Address", columns.get(ADDRESS_INDEX).getText().trim());
        contactDetails.put("City/State/Postal", columns.get(CITY_STATE_POSTAL_INDEX).getText().trim());
        contactDetails.put("Country", columns.get(COUNTRY_INDEX).getText().trim());

        return contactDetails;
    }
}

