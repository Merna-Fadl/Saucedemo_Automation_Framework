package tests.postive;

import Utils.ConfigReader;
import org.testng.annotations.*;
import driverManager.GUIDriver;

public class BaseTest {
    protected GUIDriver driver;

    @BeforeClass
    public void setUp() {
        String browser = ConfigReader.getProperty("browser");
        driver = new GUIDriver(browser);
        driver.getDriver().manage().window().maximize();
        String url = ConfigReader.getProperty("url");
        driver.getDriver().get(url);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}