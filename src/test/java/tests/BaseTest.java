package tests;

import Utils.ConfigReader;
import org.testng.annotations.*;
import driverManager.GUIDriver;

public class BaseTest {
    protected GUIDriver driver;

    @BeforeClass
    public void setUp() {
        String browser = ConfigReader.getProperty("browser");
        driver = new GUIDriver(browser);
        driver.get(ConfigReader.getProperty("url")).manage().window().maximize();
        String url = ConfigReader.getProperty("url");
        driver.get(ConfigReader.getProperty("url")).get(url);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}