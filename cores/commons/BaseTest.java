package commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
    protected static WebDriver driver;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

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
