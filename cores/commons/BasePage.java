package commons;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {
    public static BasePage getBasePageInstance(){
        return new BasePage();
    }
    public void openPageURL(WebDriver driver, String pageURL) {
        driver.get(pageURL);
    }
    public By getByXpath(String locator){
        return By.xpath(locator);
    }
    public WebElement getWebElement(WebDriver driver, String locator){
        return driver.findElement(getByXpath(locator));
    }

    public List<WebElement> getWebListElement (WebDriver driver, String locator){
        return driver.findElements(getByXpath(locator));
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

    public void selectOptionInCustomDropdown(WebDriver driver, String parentLocator, String childLocator, String expectedItemText){
        getWebElement(driver,parentLocator).click();
        sleepInSecond(2);
        List <WebElement> childItems = new WebDriverWait(driver,longTimeout).until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childLocator)));
        for (WebElement tempElement : childItems){
            if (tempElement.getText().trim().equals(expectedItemText)){
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", tempElement);
                sleepInSecond(1);
                tempElement.click();
                sleepInSecond(1);
                break;
            }
        }

    }
    public void waitForElementClickable(WebDriver driver, String locator){
        WebDriverWait webDriverWait = new WebDriverWait(driver,longTimeout);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
    }
    public void waitForElementVisible(WebDriver driver, String locator){
        WebDriverWait webDriverWait = new WebDriverWait(driver,longTimeout);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
    }

    public void sleepInSecond(int timeInSecond) {
        try {
            Thread.sleep(timeInSecond*1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    private long longTimeout = 30;
    private long shorTimeout = 5;
}
