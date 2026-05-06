package pages;

import driverManager.GUIDriver;
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

    // method
    public InformationPage enterUserInfo(String fName, String lName, String zip){
        driver.elementActions().sendKey(firstNameField,fName);
        driver.elementActions().sendKey(lastNameField,lName);
        driver.elementActions().sendKey(zipCodeField,zip);
        return this;
    }

    public OverviewPage clickContinue(){
        driver.elementActions().clickElement(continueButton);
        return new OverviewPage(driver);
    }

}
