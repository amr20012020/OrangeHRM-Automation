package com.amr.tests;
import com.amr.pages.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class LoginTest extends BaseTest {
    @Test(groups = {"smoke", "regression"})
    public void validLogin() throws InterruptedException {
        LoginPage page = new LoginPage(driver);

        page.enterUsername("Admin");
        page.enterPassword("admin123");
        page.clickLogin();
        DashboardPage dashboardPage = new DashboardPage(driver);

        Assert.assertTrue(dashboardPage.isDashboardDisplayed(),"Dashboard should appear after successful login");
    }

    @Test(dataProvider = "invalidCredentials")
    public void invalidLoginTest(String username, String password) {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();

        String actualMessage =
                loginPage.getInvalidCredentialsMessage();

        Assert.assertEquals(
                actualMessage,
                "Invalid credentials",
                "Invalid login error message is incorrect"
        );
    }


    @DataProvider(name = "invalidCredentials")
    public Object[][] invalidCredentials() {
        return new Object[][]{
                {"Admin", "123"},
                {"Test", "456"},
                {"User", "789"},
                {"Guest", "000"}
        };
    }


    @Test
    public void emptyUsernameAndPassword() {
        LoginPage page = new LoginPage(driver);
        page.clickLogin();

        Assert.assertEquals(page.getRequiredMessagesCount(),2);
    }

    @Test
    public void emptyUsername() {
        LoginPage page = new LoginPage(driver);
        page.enterPassword("admin123");
        page.clickLogin();

    }



    @Test
    public void invalidLoginTest() {
        LoginPage page = new LoginPage(driver);
        page.enterUsername("megri");
        page.enterPassword("ruewid1235");
        page.clickLogin();

        String actualMessage =
                page.getInvalidCredentialsMessage();

        Assert.assertEquals(
                actualMessage,
                "Invalid credentials",
                "Invalid login error message is incorrect"
        );

    }


}