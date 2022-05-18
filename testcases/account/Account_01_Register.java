package account;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Account_01_Register extends BaseTest {
    WebDriver driver;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browser){
        driver = getBrowserDriver(browser);
    }


    @Test
    public void Register_01_Empty_Data(){
    }

    @Test
    public void Register_02_Invalid_Email(){
    }

    @Test
    public void Register_01_Invalid_Password(){
    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
