package pages;

import Utils.ConfigReader;
import driverManager.GUIDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class CartPage {
    private GUIDriver driver;

    public CartPage(GUIDriver driver) {
        this.driver = driver;
    }

    private final By checkoutButton = By.id("checkout");
    private final By cartItemsName = By.className("inventory_item_name");
    private final By cartItemsPrice = By.className("inventory_item_price");

    // method
    // ميثود عشان نتأكد إن المنتج موجود
    private CartPage verifyProductExists(String productName) {
        // بنجيب كل الأسماء اللي في الصفحة ونحطها في لستة
        List<WebElement> products = driver.get(ConfigReader.getProperty("url")).findElements(cartItemsName);

        // بنلف على الأسماء دي ونشوف هل اسم المنتج اللي إحنا عايزينه موجود؟
        boolean isFound = false;
        for (WebElement product : products) {
            if (product.getText().equals(productName)) {
                isFound = true;
                break;

            }
        }
        // لو ملقيناش المنتج، التست يقع ويقولنا المنتج مش موجود
        Assert.assertTrue(isFound,"the product not found in cart "+ productName);
        return this;
    }
    public InformationPage clickCheckout(){
        driver.elementActions().clickElement(checkoutButton);
        return new InformationPage(driver);
    }


}

