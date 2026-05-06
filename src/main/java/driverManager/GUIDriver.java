package driverManager;

import Utils.ConfigReader;
import Utils.ElementActions;
import Utils.LogsUtil;
import org.openqa.selenium.WebDriver;
import static org.testng.Assert.fail; // تصحيح الـ Import الخاص بـ fail

public class GUIDriver {
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public GUIDriver(String browserName) {
        setDriver(browserName);
    }

    // لإنشاء الدريفير
    private void setDriver(String browserName) {
        driverThreadLocal.set(BrowserFactory.getBrowser(browserName));
    }

    // الميثود الأساسية لجلب الـ WebDriver
    public static WebDriver get(String url) {
        if (driverThreadLocal.get() == null) {
            LogsUtil.error("Driver is null! Make sure it's initialized.");
            fail("Driver is null");
        }
        return driverThreadLocal.get();
    }

    // ميثود لربط الأكشنز بالدرايفر الحالي
    public ElementActions elementActions() {
        return new ElementActions(this); // نمرر 'this' لأن الـ Constructor يتوقع GUIDriver
    }

    // لغلق المتصفح وتنظيف الـ ThreadLocal
    public void quit() {
        if (driverThreadLocal.get() != null) {
            get(ConfigReader.getProperty("url")).quit();
            driverThreadLocal.remove();
            LogsUtil.info("Driver closed and ThreadLocal removed.");
        }
    }
}
