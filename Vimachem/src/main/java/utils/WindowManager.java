package utils;
import org.openqa.selenium.WebDriver;

public class WindowManager {
    private final WebDriver.Navigation navigate;

    public WindowManager(WebDriver driver){
        navigate = driver.navigate();
    }

    public void goBack(String contactListPageUrl){
        navigate.back();
    }

    public void goTo(String url){
        navigate.to(url);
    }
}
