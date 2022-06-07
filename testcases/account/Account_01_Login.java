package account;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.user.DashboardPageObject;
import pageObjects.user.HomePageObject;
import pageObjects.user.LoginPageObject;
import pageObjects.user.ProfilePageObject;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Account_01_Login extends BaseTest {
    WebDriver driver;
    HomePageObject homePageObject;
    LoginPageObject loginPageObject;
    DashboardPageObject dashboardPageObject;
    ProfilePageObject profilePageObject;
    String validEmail = System.getenv("PROD_LOGIN_EMAIL");
    String validPassword = System.getenv("PROD_LOGIN_PASSWORD");

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName){
        driver = getBrowserDriver(browserName);
        homePageObject = new HomePageObject(driver);
    }
    @Test
    public void TC_01_Login_Invalid_Account(){
        homePageObject.clickToLoginLink();
        loginPageObject = new LoginPageObject(driver);
        loginPageObject.inputEmailToTextBox("");
        loginPageObject.inputPasswordToTextBox("");
        loginPageObject.clickToLoginButton();
        assertEquals(loginPageObject.getEmailErrorMessage(),"Email is required");
        assertEquals(loginPageObject.getPasswordErrorMessage(),"Password is required");
    }
    @Test
    public void TC_02_Login_Valid_Account(){
//        homePageObject.clickToLoginLink();
//        loginPageObject = new LoginPageObject(driver);
        loginPageObject.inputEmailToTextBox(validEmail);
        loginPageObject.inputPasswordToTextBox(validPassword);
        loginPageObject.clickToLoginButton();

        dashboardPageObject = new DashboardPageObject(driver);
        assertTrue(dashboardPageObject.isAvatarDisplayed());
        dashboardPageObject.clickOnAvatar();
        dashboardPageObject.clickProfileButton();

        profilePageObject = new ProfilePageObject(driver);
        assertEquals(profilePageObject.getEmail(),validEmail);
    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
