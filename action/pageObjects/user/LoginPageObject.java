package pageObjects.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUis.user.LoginPageUIs;

public class LoginPageObject extends BasePage {
    WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public void inputEmailToTextBox(String email){
        waitForElementVisible(driver, LoginPageUIs.EMAIL_ADDRESS_TEXTBOX);
        sendKeyToElement(driver, LoginPageUIs.EMAIL_ADDRESS_TEXTBOX, email);
    }
    public void inputPasswordToTextBox(String password){
        waitForElementVisible(driver, LoginPageUIs.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, LoginPageUIs.PASSWORD_TEXTBOX, password);
    }
    public void clickToLoginButton(){
        waitForElementClickable(driver, LoginPageUIs.LOGIN_BUTTON);
        clickToElement(driver,LoginPageUIs.LOGIN_BUTTON);
    }
    public String getEmailErrorMessage(){
        waitForElementVisible(driver, LoginPageUIs.EMAIL_ERROR_MESSAGE);
        return getTextFromElement(driver,LoginPageUIs.EMAIL_ERROR_MESSAGE);
    }
    public String getPasswordErrorMessage(){
        waitForElementVisible(driver, LoginPageUIs.PASSWORD_ERROR_MESSAGE);
        return getTextFromElement(driver,LoginPageUIs.PASSWORD_ERROR_MESSAGE);
    }
}
