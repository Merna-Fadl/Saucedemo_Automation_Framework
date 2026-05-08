package pages;

import driverManager.GUIDriver;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.openqa.selenium.By;

public class InformationPage {
    private GUIDriver driver;
    public InformationPage(GUIDriver driver){
        this.driver = driver;
    }
    private final By firstNameField = By.id("first-name");
    private final By lastNameField = By.id("last-name");
    private final By zipCodeField = By.id("postal-code");
    private final By continueButton = By.id("continue");
    private final By errorMessage = By.cssSelector("[data-test='error']");

    // method
    @Step("Entering user info: First Name [{fName}], Last Name [{lName}], Zip [{zip}]")
    public InformationPage enterUserInfo(String fName, String lName, String zip){
        driver.elementActions().sendKey(firstNameField,fName);
        driver.elementActions().sendKey(lastNameField,lName);
        driver.elementActions().sendKey(zipCodeField,zip);
        return this;
    }

    @Step("Clicking Continue")
    public OverviewPage clickContinue(){
        driver.elementActions().clickElement(continueButton);
        return new OverviewPage(driver);
    }

    @Step("Verifying checkout error message: {expectedMessage}")
    public InformationPage assertCheckoutError(String expectedMessage) {
        String actualMessage = driver.elementActions().getText(errorMessage);

        // نستخدم assertTrue للتأكد من صحة الشرط المنطقي
        Assert.assertTrue(actualMessage.contains(expectedMessage),
                "Error message mismatch! Expected to find [" + expectedMessage + "] inside [" + actualMessage + "]");

        return this;
    }
    public InformationPage clickContinueExpectingError(){
        driver.elementActions().clickElement(continueButton);
        return this;
    }


}
