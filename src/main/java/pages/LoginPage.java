package pages;

import Utils.ConfigReader;
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

    public LoginPage  EnterUsername(String user){
        //driver.findElement(usernameField).sendKeys(user);
        driver.elementActions().sendKey(usernameField,user);
        return this;

    }
    public LoginPage enterPassword(String pass){
       // driver.findElement(passwordField).sendKeys(pass);
        driver.elementActions().sendKey(passwordField,pass);
        return  this;
    }
    public LoginPage clickLogin(){
      //  driver.findElement(loginButton).click();
        driver.elementActions().clickElement(loginButton);
         return this ;
    }
    public String getErrorMassage(){
        return driver.elementActions().findElement(errorMassage).getText();
    }
    // assertion
    public ProductsPage assertSuccessfulLogin(){
        // assertion

        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        String actualUrl = driver.get(ConfigReader.getProperty("url")).getCurrentUrl();
     Assert.assertEquals(actualUrl,expectedUrl," Login failed - URL mismatched");
        return new ProductsPage(driver);
    }
    public LoginPage assertErrorMessage(){
        String actualError = getErrorMassage();
        Assert.assertTrue(actualError.contains("Epic sadface"), "Error massage mismatches");
        return  this;

    }


}
