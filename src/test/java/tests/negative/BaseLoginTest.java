package tests.negative;

import Utils.ConfigReader;
import driverManager.GUIDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseLoginTest {
    protected GUIDriver driver;

    @BeforeMethod
    public void setUp() {
        String browser = ConfigReader.getProperty("browser");
        driver = new GUIDriver(browser);
        driver.getDriver().manage().window().maximize();
        String url = ConfigReader.getProperty("url");
        driver.getDriver().get(url);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
