package pages;


import driverManager.GUIDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ProductsPage {
    private GUIDriver driver;
    public ProductsPage(GUIDriver driver){
        this.driver = driver;
    }

    // locators
    private final By item1 = By.id("add-to-cart-sauce-labs-backpack");
    private final By item2 = By.id("add-to-cart-sauce-labs-bike-light");
    private final By item3 = By.id("add-to-cart-sauce-labs-fleece-jacket");
    private final By cartIcon = By.className("shopping_cart_link");
    private final By shoppingCartBadge = By.className("shopping_cart_badge");
    private final By priceItem1 = By.xpath("//div[text()='Sauce Labs Backpack']/ancestor::div[@class='inventory_item_description']//div[@class='inventory_item_price']");
    private final By priceItem2 = By.xpath("//div[text()='Sauce Labs Bike Light']/ancestor::div[@class='inventory_item_description']//div[@class='inventory_item_price']");
    private final By priceItem3 = By.xpath("//div[text()='Sauce Labs Fleece Jacket']/ancestor::div[@class='inventory_item_description']//div[@class='inventory_item_price']");
    private final By menuButton = By.id("react-burger-menu-btn");
    private final By logoutButton = By.id("logout_sidebar_link");


    //method

    // ميثود مساعدة لتحويل السعر من نص لرقم وجمعه
    @Step("Adding price to total expected sum")
    private void addPriceToTotal(By priceLocator) {
        String priceText = driver.elementActions().getText(priceLocator); // بيجيب مثلاً "$29.99"
        double price = Double.parseDouble(priceText.replace("$", "")); // بيحولها لـ 29.99
        // هننادي عليه من الـ ConfigReader
        Utils.ConfigReader.expectedTotal += price;
    }
    @Step("Adding Item 1 to cart and updating total price")
    public ProductsPage addItem1(){
        addPriceToTotal(priceItem1);
        driver.elementActions().clickElement(item1);
        return this;
    }
    @Step("Adding Item 2 to cart and updating total price")
    public ProductsPage addItem2(){
        addPriceToTotal(priceItem2);
        driver.elementActions().clickElement(item2);
        return this;
    }
    @Step("Adding Item 3 to cart and updating total price")
    public ProductsPage addItem3(){
        addPriceToTotal(priceItem3);
        driver.elementActions().clickElement(item3);
        return this;
    }
    @Step("Clicking on Cart icon")
    public CartPage clickOnCartIcon(){
        driver.elementActions().clickElement(cartIcon);
        return new CartPage(driver);
    }

    //asserting
    @Step("Verifying cart badge count is: {expectedCount}")
    public ProductsPage assertCartBadgeCount(String expectedCount){
        String actualCount= driver.elementActions().getText(shoppingCartBadge);
        Assert.assertEquals(actualCount,expectedCount,"cart count mismatch! Expected: "+ expectedCount +  " but found:" + actualCount);
        return this;

    }
    @Step("Logging out from the application")
    public LoginPage logout(){
        driver.elementActions().clickElement(menuButton);
        driver.elementActions().clickElement(logoutButton);

        return new LoginPage(driver);
    }

}
