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
       // 1. قراءة النص من الصفحة (بيكون: "Item total: $89.97")
       String actualTotalText = driver.elementActions().getText(subTotalLabel);
       // 2. تنظيف النص عشان ناخد الرقم بس
       double actualPrice = Double.parseDouble(actualTotalText.replaceAll("[^0-9.]", ""));
       Assert.assertEquals(actualPrice, Utils.ConfigReader.expectedTotal, "Total Price Mismatch!");
       return this;
   }

    @Step("Clicking Finish button")
   public SuccessPage clickFinish(){
       driver.elementActions().clickElement(finishButton);
       return new SuccessPage(driver);
   }





}
