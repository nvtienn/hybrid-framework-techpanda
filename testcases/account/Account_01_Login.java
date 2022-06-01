package account;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.user.HomePageObject;
import pageObjects.user.LoginPageObject;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class Account_01_Login extends BasePage {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    HomePageObject homePageObject;
    LoginPageObject loginPageObject;
    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        openPageURL(driver,"https://sellerwix.com/");
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
    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
