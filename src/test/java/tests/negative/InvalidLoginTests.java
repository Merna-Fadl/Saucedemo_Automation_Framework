package tests.negative;

import Utils.ConfigReader;
import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.JsonReader;

@Epic("SauceDemo UI Tests")
@Feature("Login Negative Scenarios")

public class InvalidLoginTests extends BaseLoginTest {

    @DataProvider(name = "invalidLoginData")
    public Object[][] invalidLoginData() {

        return new Object[][]{

                {
                        JsonReader.getTestData("invalidUsername"),
                        ConfigReader.getProperty("password"),
                        JsonReader.getTestData("invalidCredentialsError")
                },

                {
                        ConfigReader.getProperty("username"),
                        JsonReader.getTestData("invalidPassword"),
                        JsonReader.getTestData("invalidCredentialsError")
                },

                {
                        "",
                        ConfigReader.getProperty("password"),
                        JsonReader.getTestData("usernameRequiredError")
                },

                {
                        ConfigReader.getProperty("username"),
                        "",
                        JsonReader.getTestData("passwordRequiredError")
                },

                {
                        JsonReader.getTestData("lockedUser"),
                        ConfigReader.getProperty("password"),
                        JsonReader.getTestData("lockedUserError")
                }

        };

    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify user cannot login with invalid credentials")

    @Test(dataProvider = "invalidLoginData")
    @Step("Attempting login with username: [{username}] to verify error: [{expectedError}]")
    public void invalidLoginTest(String username, String password, String expectedError) {

        new LoginPage(driver)
                .enterUsername(username)
                .enterPassword(password)
                .clickLogin()
                .assertErrorMessage(expectedError);
    }
}