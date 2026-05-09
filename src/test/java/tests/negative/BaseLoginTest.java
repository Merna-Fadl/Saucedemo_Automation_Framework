package tests.negative;

import Utils.ConfigReader;
import driverManager.GUIDriver;
import org.openqa.selenium.Dimension;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseLoginTest {
    protected GUIDriver driver;

    @Parameters("browser") // دي بتسمح لـ TestNG يبعت المتصفح من الـ XML
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) {
        // الأولوية للي جاي من الـ Command Line (GitHub Matrix) وبعدين الـ XML
        String finalBrowser = System.getProperty("browser", browser);
        // @Optional بتضمن إن التست يشتغل حتى لو شغلتي الكلاس لوحده من غير XML
        driver = new GUIDriver(finalBrowser);
        driver.getDriver().manage().window().setSize(new Dimension(1920, 1080));
        driver.getDriver().manage().window().maximize();
        driver.getDriver().get(ConfigReader.getProperty("url"));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
