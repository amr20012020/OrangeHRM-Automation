package com.amr.pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    private final By username=By.name("username"),
                     password=By.name("password"),
                     login=By.cssSelector("button[type='submit']"),
                     error=By.cssSelector(".oxd-alert-content-text");
    public LoginPage(WebDriver driver){
        super(driver);
    }public void enterUsername(String s){
        type(username,s);
    }public void enterPassword(String s){
        type(password,s);
    }public void clickLogin(){
        click(login);
    }public String getInvalidCredentialsMessage(){
        return getText(error);
    }
    private final By requiredMessages = By.cssSelector(".oxd-alert-content-text");
    public int getRequiredMessagesCount() {
        return wait.until(
                ExpectedConditions.numberOfElementsToBeMoreThan(
                        requiredMessages, 0
                )
        ).size();
    }
}
