package tests.postive;

import Utils.ConfigReader;
import org.testng.annotations.*;
import driverManager.GUIDriver;
import org.openqa.selenium.Dimension;
public class BaseTest {
    protected GUIDriver driver;

    @Parameters("browser") // دي بتسمح لـ TestNG يبعت المتصفح من الـ XML
    @BeforeClass
    public void setUp(@Optional("chrome") String browser) {
        // @Optional بتضمن إن التست يشتغل حتى لو شغلتي الكلاس لوحده من غير XML
        driver = new GUIDriver(browser);
        driver.getDriver().manage().window().setSize(new Dimension(1920, 1080));
        driver.getDriver().manage().window().maximize();
        driver.getDriver().get(ConfigReader.getProperty("url"));
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        // صَفري العداد الخاص بالـ Thread ده بعد ما يخلص
        Utils.ConfigReader.clearTotal();
    }
}