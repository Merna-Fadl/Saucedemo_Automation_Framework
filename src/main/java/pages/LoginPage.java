package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import driverManager.GUIDriver;
import org.testng.Assert;

public class LoginPage {
    private GUIDriver driver;
    public  LoginPage (GUIDriver driver){
        this.driver = driver;
    }
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMassage = By.xpath("//h3[@data-test='error']");

    @Step("Entering username: {user}")
    public LoginPage enterUsername(String user){
        //driver.findElement(usernameField).sendKeys(user);
        driver.elementActions().sendKey(usernameField,user);
        return this;

    }
    @Step("Entering password")
    public LoginPage enterPassword(String pass){
       // driver.findElement(passwordField).sendKeys(pass);
        driver.elementActions().sendKey(passwordField,pass);
        return  this;
    }
    @Step("Clicking Login button for Logout test only")
    public ProductsPage clickLoginExpectingLogout(){
      //  driver.findElement(loginButton).click();
        driver.elementActions().clickElement(loginButton);
         return new ProductsPage(driver) ;
    }
    public String getErrorMassage(){
        return driver.elementActions().findElement(errorMassage).getText();
    }
    // assertion
    @Step("Verifying successful login by URL")
    public ProductsPage assertSuccessfulLogin(){
        // assertion

        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        String actualUrl = driver.getDriver().getCurrentUrl();
     Assert.assertEquals(actualUrl,expectedUrl," Login failed - URL mismatched");
        return new ProductsPage(driver);
    }

    @Step("Verifying error message: {expectedMessage}")
    public LoginPage assertErrorMessage(String expectedMessage){
        // التأكد من أن الرسالة المتوقعة ليست فارغة قبل المقارنة
        if (expectedMessage == null) {
            Assert.fail("القيمة المتوقعة من ملف الـ JSON عادت بـ NULL! تأكد من المفتاح (Key) والمسار.");
        }

        String actualError = getErrorMassage();
        Assert.assertTrue(actualError.contains(expectedMessage),
                "Error message mismatch. Actual: " + actualError);
        return this;
    }

    public LoginPage assertLoginPageOpened() {
        String expectedUrl = "https://www.saucedemo.com/";
        String actualUrl = driver.getDriver().getCurrentUrl();

        // نتحقق من الـ URL أو وجود زر الـ Login
        Assert.assertEquals(actualUrl, expectedUrl, "Logout failed! User is not redirected to Login page.");
        Assert.assertTrue(driver.elementActions().findElement(loginButton).isDisplayed(), "Login button is not visible after logout.");

        return this;
    }
    @Step("Clicking Login button")
    public LoginPage clickLogin() {
        driver.elementActions().clickElement(loginButton);
        return this; // بتفضل في نفس الصفحة عشان تعملي Assertion على الرسالة
    }
}



