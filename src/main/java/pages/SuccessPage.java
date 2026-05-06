package pages;

import driverManager.GUIDriver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class SuccessPage {
    private GUIDriver driver;
    public SuccessPage (GUIDriver driver){
        this.driver = driver;
    }
    private final By headerMessage = By.className("complete-header");

    public void verifySuccessMessage(){
        String message = driver.elementActions().getText(headerMessage);
        Assert.assertEquals(message,"Thank you for your order!");
    }
}
