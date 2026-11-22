package com.amr.tests;

import com.amr.pages.AdminPage;
import com.amr.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AdminTest extends BaseTest{
    @Test(groups = {"regression"})
    public void OpenAdminPage()
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLogin();


        AdminPage adminPage = new AdminPage(driver);
        adminPage.clickAdminMenu();

        String currentUrl = driver.getCurrentUrl();
        org.testng.Assert.assertTrue(currentUrl.contains("/admin/"), "Admin page should open successfully");

        System.out.println("Admin Menu clicked Successfully");

    }


    @Test(
            dataProvider = "userSearchData",
            groups = {"regression"}
    )
    public void searchUserTest(String username) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLogin();


        AdminPage adminPage = new AdminPage(driver);
        adminPage.clickAdminMenu();


        adminPage.enterUserName(username);
        adminPage.clickSearch();

        Assert.assertTrue(
                adminPage.isUserDisplayed(username),
                "User " + username + " should appear in search results"
        );



        System.out.println("User search completed!");

    }


    @DataProvider(name = "userSearchData")
    public Object[][] userSearchData() {
        return new Object[][] {
                {"Admin"},
                {"admin"}
        };
    }

    @Test(groups = {"regression"})
    public void searchInvalidUserTest(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLogin();

        AdminPage adminPage = new AdminPage(driver);
        adminPage.clickAdminMenu();

        adminPage.enterUserName("InvalidUser99999");
        adminPage.clickSearch();
        Assert.assertTrue(
                adminPage.isNoRecordsFoundDisplayed(),
                "No Records Found message should appear for invalid username"
        );

        System.out.println("Negative user search test completed!");
    }




    @Test(groups = {"regression"})
    public void verifyAdminPageTitle(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLogin();

        AdminPage adminPage = new AdminPage(driver);
        adminPage.clickAdminMenu();

        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle,"OrangeHRM");

    }

}
