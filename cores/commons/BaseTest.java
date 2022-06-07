package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    public WebDriver getBrowserDriver(String browser) {
        switch (browser){
            case "chrome":
                System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver", projectPath + "/browserDrivers/msedgedriver.exe");
                driver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException("Invalid browser");
        }
        driver.get("https://sellerwix.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }
}
