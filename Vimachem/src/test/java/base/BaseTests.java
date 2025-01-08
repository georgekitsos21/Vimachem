package base;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

public class BaseTests {
    protected static ChromeDriver driver;
    protected static LoginPage loginPage;
    protected static SignUpPage signUpPage;
    protected static ContactPage contactPage;
    protected static AddContactPage addContactPage;
    protected static ContactsDetails contactsDetails;

    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://thinking-tester-contact-list.herokuapp.com/");
        loginPage = new LoginPage(driver);
        signUpPage = new SignUpPage(driver);
        contactPage = new ContactPage(driver);
        addContactPage = new AddContactPage(driver);
        contactsDetails = new ContactsDetails(driver);


    }

    @AfterClass
    public static void tearDown(){
       driver.quit();
   }
}



