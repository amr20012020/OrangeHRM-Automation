package com.amr.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdminPage extends BasePage{
    private final By adminMenu = By.xpath( "//a[contains(@href, '/web/index.php/admin/viewAdminModule')]");
    private final By userNameInput = By.xpath("//label[normalize-space()='Username']/ancestor::div[contains(@class,'oxd-input-group')]//input");
    private final By searchButton = By.xpath("//button[@type='submit']");
    private final By adminUserResult = By.xpath("//div[@role='row']//div[@role='cell'][2]//div[normalize-space()='Admin']");
    private final By noRecordsFoundMessage = By.xpath("//*[normalize-space()='No Records Found']");




    public AdminPage(WebDriver driver) {
        super(driver);
    }

    public void clickAdminMenu() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(adminMenu)).click();
        System.out.println("Admin menu clicked successfully!");
    }

    public void enterUserName(String userName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(userNameInput)).sendKeys(userName);
        System.out.println("Searching for user name: " + userName);
    }


    public void clickSearch() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
        System.out.println("Search button clicked successfully!");
    }


    public boolean isUserDisplayed(String username) {

        String lowerUsername = username.toLowerCase();

        By userResult = By.xpath(
                "//div[@role='row']//div[@role='cell'][2]//*" +
                        "[translate(normalize-space(.), " +
                        "'ABCDEFGHIJKLMNOPQRSTUVWXYZ', " +
                        "'abcdefghijklmnopqrstuvwxyz')='" +
                        lowerUsername + "']"
        );

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(userResult)
        ).isDisplayed();
    }




    public boolean isNoRecordsFoundDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(noRecordsFoundMessage)).isDisplayed();
    }




}
