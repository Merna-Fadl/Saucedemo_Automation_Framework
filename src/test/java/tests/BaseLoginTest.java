package tests;

import Utils.ConfigReader;
import driverManager.GUIDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseLoginTest {
    protected GUIDriver driver;

    @BeforeMethod
    public void setUp() {
        String browser = ConfigReader.getProperty("browser");
        driver = new GUIDriver(browser);
        driver.get(ConfigReader.getProperty("url")).manage().window().maximize();
        String url = ConfigReader.getProperty("url");
        driver.get(ConfigReader.getProperty("url")).get(url);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
