package com.amr.tests;

import com.amr.config.ConfigReader;
import com.amr.factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {

        System.out.println(">>> SETUP STARTED");

        driver = DriverFactory.createDriver();

        System.out.println(">>> DRIVER CREATED: " + driver);

        driver.manage().window().maximize();
        driver.get(ConfigReader.get("url"));

        System.out.println(">>> SETUP COMPLETED");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {

        System.out.println(">>> TEARDOWN STARTED");

        if (driver != null) {
            driver.quit();
            System.out.println(">>> DRIVER QUIT");
        }
    }

    public WebDriver getDriver() {
        System.out.println(">>> GET DRIVER CALLED: " + driver);
        return driver;
    }
}