package account;

import commons.BaseTest;
import environmentVariable.EnvironmentVariables;
import org.testng.annotations.Test;
import pageObjects.user.DashboardPageObject;
import pageObjects.user.HomePageObject;
import pageObjects.user.LoginPageObject;
import pageObjects.user.ProfilePageObject;

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
        homePageObject.clickToLoginLink();
        loginPageObject = new LoginPageObject(driver);
        loginPageObject.inputEmailToTextBox("");
        loginPageObject.inputPasswordToTextBox("");
        loginPageObject.clickToLoginButton();
        assertEquals(loginPageObject.getEmailErrorMessage(), "Email is required");
        assertEquals(loginPageObject.getPasswordErrorMessage(), "Password is required");
    }

    @Test
    public void TC_02_Login_Valid_Account() {
        loginPageObject.inputEmailToTextBox(validEmail);
        loginPageObject.inputPasswordToTextBox(validPassword);
        loginPageObject.clickToLoginButton();

        dashboardPageObject = new DashboardPageObject(driver);
        assertTrue(dashboardPageObject.isAvatarDisplayed());
        dashboardPageObject.clickOnAvatar();
        dashboardPageObject.clickProfileButton();

        profilePageObject = new ProfilePageObject(driver);
        assertEquals(profilePageObject.getEmail(), validEmail);
    }
}
