package account;

import commons.BaseTest;
import environmentVariable.EnvironmentVariables;
import org.testng.annotations.Test;
import pageObjects.user.DashboardPageObject;
import pageObjects.user.HomePageObject;
import pageObjects.user.LoginPageObject;
import pageObjects.user.ProfilePageObject;
import sun.rmi.runtime.Log;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Account_01_Login extends BaseTest {
    HomePageObject homePageObject;
    LoginPageObject loginPageObject;
    DashboardPageObject dashboardPageObject;
    ProfilePageObject profilePageObject;
    String validEmail = EnvironmentVariables.prodEmail;
    String validPassword = EnvironmentVariables.prodPassword;

    @Test
    public void TC_01_Login_Invalid_Account() {
        homePageObject = new HomePageObject(driver);
        log.info("Login_01 - Step 01: Click on Login button");
        homePageObject.clickToLoginLink();

        loginPageObject = new LoginPageObject(driver);
        log.info("Login_01 - Step 02: Enter to Email Textbox with empty data");
        loginPageObject.inputEmailToTextBox("");

        log.info("Login_01 - Step 03: Enter to Password Textbox with empty data");
        loginPageObject.inputPasswordToTextBox("");

        log.info("Login_01 - Step 04: Click on Login button");
        loginPageObject.clickToLoginButton();

         log.info("Login_01 - Step 05: Verify the error messages are displayed");
        assertEquals(loginPageObject.getEmailErrorMessage(), "Email is required");
        assertEquals(loginPageObject.getPasswordErrorMessage(), "Password is required");
    }

    @Test
    public void TC_02_Login_Valid_Account() {
        log.info("Login_02 - Step 01: Input to Email textbox with valid data: "+ validEmail);
        loginPageObject.inputEmailToTextBox(validEmail);

        log.info("Login_02 - Step 02: Input to Password textbox with valid data: "+ validPassword);
        loginPageObject.inputPasswordToTextBox(validPassword);

        log.info("Login_02 - Step 03: Click on Login button");
        loginPageObject.clickToLoginButton();

        dashboardPageObject = new DashboardPageObject(driver);
        log.info("Login_02 - Step 04: Verify that the user avatar is displayed");
        assertTrue(dashboardPageObject.isAvatarDisplayed());

        log.info("Login_02 - Step 05: Click on user avatar");
        dashboardPageObject.clickOnAvatar();

        log.info("Login_02 - Step 06: Click on Profile button");
        dashboardPageObject.clickProfileButton();

        profilePageObject = new ProfilePageObject(driver);

        log.info("Login_02 - Step 07: Verify that user email is displayed");
        assertEquals(profilePageObject.getEmail(), validEmail);
    }
}
