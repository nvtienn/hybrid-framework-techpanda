package commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import pageObjects.user.HomePageObject;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected static WebDriver driver;
    protected final Log log;

    public BaseTest() {
        log = LogFactory.getLog(getClass());
    }

    @Parameters("browser")
    @BeforeClass
    protected void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        driver.get("https://sellerwix.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterClass
    protected void afterClass() {
        driver.quit();
    }

    private WebDriver getBrowserDriver(String browser) {
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
        return driver;
    }
}
