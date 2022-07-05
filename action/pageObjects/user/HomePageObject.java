package pageObjects.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUis.user.HomePageUIs;

public class HomePageObject extends BasePage {
    WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToLoginLink() {
        clickToElement(driver, HomePageUIs.LOGIN_LINK);
    }
}
