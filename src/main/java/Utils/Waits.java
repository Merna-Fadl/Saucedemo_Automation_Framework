package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import driverManager.GUIDriver;

public class Waits {
   private GUIDriver driver;
    public  Waits (GUIDriver driver){this.driver =driver;}
    // wait for element present
    public WebElement waitForElementPresent(By locator){
        return new WebDriverWait(driver.getDriver(),Duration.ofSeconds(30))
                .until(driver1 -> driver.getDriver().findElement(locator));
    }
    // wait for element visible
    public WebElement waitForElementVisible(By locator){
        return  new WebDriverWait(driver.getDriver(),Duration.ofSeconds(30)).until(driver1 -> {
            WebElement element = waitForElementPresent(locator);
            return  element.isDisplayed() ? element:null;
        });
    }
    // wait for element clickable
    public WebElement waitForElementClickable(By locator){
        return  new WebDriverWait(driver.getDriver(),Duration.ofSeconds(30)).until(driver1 -> {
            WebElement element = waitForElementVisible(locator);
            return element.isEnabled() ? element:null;
        });
    }
}
