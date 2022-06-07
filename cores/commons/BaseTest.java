package commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver driver;

    public WebDriver getBrowserDriver(String browser) {
        BrowserList browserList = BrowserList.valueOf(browser.toUpperCase());
        switch (browserList) {
            case CHROME:
                driver = WebDriverManager.chromedriver().create();
                break;
            case EDGE:
                driver = WebDriverManager.edgedriver().create();
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
