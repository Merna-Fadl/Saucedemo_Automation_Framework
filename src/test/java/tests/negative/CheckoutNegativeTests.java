package tests.negative;

import Utils.ConfigReader;
import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;
import utils.JsonReader;

@Epic("SauceDemo UI Tests")
@Feature("Checkout Negative Scenarios")

public class CheckoutNegativeTests extends BaseLoginTest {

    @DataProvider(name = "invalidCheckoutData")
    public Object[][] invalidCheckoutData() {

        return new Object[][]{

                {
                        "",
                        JsonReader.getTestData("lastName"),
                        JsonReader.getTestData("zipCode"),
                        JsonReader.getTestData("firstNameRequired")
                },

                {
                        JsonReader.getTestData("firstName"),
                        "",
                        JsonReader.getTestData("zipCode"),
                        JsonReader.getTestData("lastNameRequired")
                },

                {
                        JsonReader.getTestData("firstName"),
                        JsonReader.getTestData("lastName"),
                        "",
                        JsonReader.getTestData("postalCodeRequired")
                }
        };
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify user cannot continue checkout with missing required fields")
    @Test(dataProvider = "invalidCheckoutData")
    @Step("Testing checkout validation with FirstName:[{0}], LastName:[{1}], Zip:[{2}]")

    public void invalidCheckoutTest(
            String firstName,
            String lastName,
            String postalCode,
            String expectedError) {

        new LoginPage(driver)
                .enterUsername(ConfigReader.getProperty("username"))
                .enterPassword(ConfigReader.getProperty("password"))
                .clickLogin();

        new ProductsPage(driver)
                .addItem1()
                .clickOnCartIcon();

        new CartPage(driver)
                .clickCheckout()
                .enterUserInfo(firstName, lastName, postalCode)
                .clickContinueExpectingError()
                .assertCheckoutError(expectedError);
    }
}