package pageObjects.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUis.user.ProfilePageUIs;

public class ProfilePageObject extends BasePage {
    WebDriver driver;
    public ProfilePageObject (WebDriver driver){
        this.driver = driver;
    }
    public String getEmail(){
        return getAttributeValue(driver,ProfilePageUIs.EMAIL_FIELD,"value");
    }
}
