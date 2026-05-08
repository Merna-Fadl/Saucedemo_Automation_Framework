package tests.postive;

import Utils.ConfigReader;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.LoginPage;
@Epic("SauceDemo UI Tests")
@Feature("Authentication")
public class LogoutTests extends BaseTest {
    @Severity(SeverityLevel.CRITICAL) // تحديد الأهمية كدرجة حرجة
    @Description("Verify that a user can successfully log out and is redirected to the login page") // وصف الاختبار
    @Test
    @Step("Execution of Logout Flow: Login -> Sidebar -> Logout")
    public void successfulLogoutTest(){

        new LoginPage(driver)
                .enterUsername(
                        ConfigReader.getProperty("username"))
                .enterPassword(
                        ConfigReader.getProperty("password"))
                .clickLoginExpectingLogout()
                .logout()
                .assertLoginPageOpened();
    }
}
