package commons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    public void openPageURL(WebDriver driver, String pageURL) {
        driver.get(pageURL);
    }
    public By getByXpath(String locator){
        return By.xpath(locator);
    }
    public WebElement getWebElement(WebDriver driver, String locator){
        return driver.findElement(getByXpath(locator));
    }
    public void clickToElement(WebDriver driver, String locator){
        getWebElement(driver, locator).click();
    }
    public void sendKeyToElement(WebDriver driver, String locator, String valueInput){
        WebElement element = getWebElement(driver,locator);
        element.clear();
        element.sendKeys(valueInput);
    }
    public String getTextFromElement(WebDriver driver, String locator){
        return getWebElement(driver,locator).getText();
    }
}
