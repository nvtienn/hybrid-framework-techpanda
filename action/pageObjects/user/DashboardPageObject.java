package pageObjects.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUis.user.DashboardPageUIs;

public class DashboardPageObject extends BasePage {
    WebDriver driver;

    public DashboardPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnAvatar() {
        waitForElementClickable(driver, DashboardPageUIs.AVATAR_IMAGE_LINK);
        clickToElement(driver, DashboardPageUIs.AVATAR_IMAGE_LINK);
    }

    public ProfilePageObject clickProfileButton() {
        waitForElementClickable(driver, DashboardPageUIs.PROFILE_BUTTON);
        clickToElement(driver, DashboardPageUIs.PROFILE_BUTTON);
        return PageGeneratorManager.getProfilePage(driver);
    }

    public boolean isAvatarDisplayed() {
        return isElementDisplayed(driver, DashboardPageUIs.AVATAR_IMAGE_LINK);
    }
}
