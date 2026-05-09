package pages;

import driverManager.GUIDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class OverviewPage {
    private GUIDriver driver;
    public OverviewPage (GUIDriver driver){
        this.driver = driver;
    }
   private final By subTotalLabel = By.className("summary_subtotal_label");
   private final By taxLabel = By.className("summary_tax_label");
   private final By totalLabel = By.className("summary_total_label");
   private final By finishButton = By.id("finish");

    @Step("Verifying that the actual price matches the calculated expected total")
    public OverviewPage verifyTotalPrice(){
        String actualTotalText = driver.elementActions().getText(subTotalLabel);
        double actualPrice = Double.parseDouble(actualTotalText.replaceAll("[^0-9.]", ""));

        // بنادي على المجموع الخاص بالـ Thread ده بس
        Assert.assertEquals(actualPrice, Utils.ConfigReader.getTotal(), "Total Price Mismatch!");
        return this;
    }
    @Step("Clicking Finish button")
   public SuccessPage clickFinish(){
       driver.elementActions().clickElement(finishButton);
       return new SuccessPage(driver);
   }





}
