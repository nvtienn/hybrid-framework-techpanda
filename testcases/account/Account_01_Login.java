package account;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.user.DashboardPageObject;
import pageObjects.user.HomePageObject;
import pageObjects.user.LoginPageObject;
import pageObjects.user.ProfilePageObject;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Account_01_Login extends BasePage {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    HomePageObject homePageObject;
    LoginPageObject loginPageObject;
    DashboardPageObject dashboardPageObject;
    ProfilePageObject profilePageObject;
    String validEmail = System.getenv("PROD_LOGIN_EMAIL");
    String validPassword = System.getenv("PROD_LOGIN_PASSWORD");

    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @Test
    public void TC_01_Login_Invalid_Account(){
        openPageURL(driver,"https://sellerwix.com/");
        homePageObject = new HomePageObject(driver);
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
        openPageURL(driver,"https://sellerwix.com/");
        homePageObject = new HomePageObject(driver);
        homePageObject.clickToLoginLink();
        loginPageObject = new LoginPageObject(driver);
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
