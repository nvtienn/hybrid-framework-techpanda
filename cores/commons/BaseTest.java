package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver getBrowserDriver(String browser) {
        WebDriver driver;
        String projectPath = System.getProperty("user.dir");
        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            default:
                throw new RuntimeException("Invalid browser");
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }
}
