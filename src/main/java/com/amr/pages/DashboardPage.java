package com.amr.pages;
import org.openqa.selenium.*;
public class DashboardPage extends BasePage {private final By title=By.xpath("//h6[normalize-space()='Dashboard']");public DashboardPage(WebDriver driver){super(driver);}public boolean isDashboardDisplayed(){return isDisplayed(title);}}
