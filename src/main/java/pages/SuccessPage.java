package pages;

import driverManager.GUIDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class SuccessPage {
    private GUIDriver driver;
    public SuccessPage (GUIDriver driver){
        this.driver = driver;
    }
    private final By headerMessage = By.className("complete-header");

    @Step("Verifying final success message: 'Thank you for your order!'")
    public void verifySuccessMessage(){
        String message = driver.elementActions().getText(headerMessage);
        Assert.assertEquals(message,"Thank you for your order!");
    }
}
