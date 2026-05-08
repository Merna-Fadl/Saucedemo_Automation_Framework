package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import driverManager.GUIDriver;

public class Scrolling {
   private GUIDriver driver;
    public Scrolling( GUIDriver driver){this.driver=driver;}
    public  void ScrollToElement( By locator){
        WebElement element = driver.getDriver().findElement(locator);
        Actions actions = new Actions(driver.getDriver());
        actions.moveToElement(element).perform();
    }

}
