package tests;

import Utils.ConfigReader;
import Utils.TestListener;
import driverManager.GUIDriver;
import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
//@Listeners(TestListener.class)
@Epic("SauceDemo UI Tests")
@Feature("Login Management") // تصنيف التست تحت ميزة معينة
public class LoginTests extends BaseLoginTest {
    /**
     * DataProvider بيسحب اليوزرات من ملف الـ Properties
     * تقدري تزودي أي عدد من اليوزرات في ملف الـ properties وتضيفيهم هنا
     */
    @DataProvider(name = "loginUsers")
    public Object[][] getUsersFromConfig() {
        return new Object[][]{
                {ConfigReader.getProperty("user1")}, // standard_user
                {ConfigReader.getProperty("user2")}, // problem_user
                {ConfigReader.getProperty("user3")}  // performance_glitch_user
        };
    }

    @Severity(SeverityLevel.BLOCKER) // تحديد أهمية التست (Blocker, Critical, Normal)
    @Description("Verify that multiple valid users can log in successfully using data from properties file.")
    @Story("PositiveLogin Scenarios") // سيناريو محدد داخل الميزة
    @Test(dataProvider = "loginUsers")
    public void successLogintest(String username){
        GUIDriver.get(ConfigReader.getProperty("url")); // ارجعي لصفحة اللوجن قبل كل محاولة
        new LoginPage(driver)
                .EnterUsername(username)
                .enterPassword(ConfigReader.getProperty("password"))
                .clickLogin()
                .assertSuccessfulLogin();


    }
    @Severity(SeverityLevel.NORMAL)
    @Story("Negative Login Scenarios")
    @Description("Verify that error message is displayed when logging in with a locked out user.")
    @Test
    public void failedLoginTest(){
        new LoginPage(driver)
                .EnterUsername(ConfigReader.getProperty("FailedUser"))
                .enterPassword(ConfigReader.getProperty("password"))
                .clickLogin()
                .assertErrorMessage();



    }

}
