package tests.postive;

import Utils.ConfigReader;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;

//@Listeners(TestListener.class)
@Feature("End to End Purchase Flow")
@Severity(SeverityLevel.CRITICAL)
@Story("Purchase Multiple Items")

public class E2e extends BaseTest {

    @Description("Full flow from login to adding items to cart and finishing checkout.")
    @Test
    @Step("Step 1: Login with valid credentials")
    public void successLogintest(){
         new LoginPage(driver)
        .enterUsername(ConfigReader.getProperty("username"))
       .enterPassword(ConfigReader.getProperty("password"))
       .clickLogin()
        .assertSuccessfulLogin();



    }
    @Test(dependsOnMethods = "successLogintest")
    @Step("Step 2: Add multiple products and verify cart badge")
    public void addMultipleProductsFlow(){
        new ProductsPage(driver)
                .addItem1()
                .addItem2()
                .addItem3()
                .assertCartBadgeCount("3")
                .clickOnCartIcon();

    }

    @Test(dependsOnMethods = "addMultipleProductsFlow")
    @Step("Step 3: Complete checkout and verify total price calculation")
    public void completeCheckOutFlow(){
        new CartPage(driver)
                .clickCheckout()
                .enterUserInfo(utils.JsonReader.getTestData("firstName"), utils.JsonReader.getTestData("lastName"), utils.JsonReader.getTestData("zipCode"))
                .clickContinue()
                .verifyTotalPrice()
                .clickFinish()
                .verifySuccessMessage();

    }


}
