package com.amr.listeners;

import com.amr.tests.BaseTest;
import com.amr.utils.ScreenshotUtils;

import io.qameta.allure.Allure;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;

import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;

public class TestListener implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println(
                "PASSED: " + result.getName()
        );
    }

    @Override
    public void onTestFailure(ITestResult result) {

        System.out.println(
                "FAILED: " + result.getName()
        );

        Object instance = result.getInstance();

        if (instance instanceof BaseTest) {

            BaseTest test = (BaseTest) instance;
            WebDriver driver = test.getDriver();

            if (driver != null) {

                // Save screenshot to target/screenshots
                ScreenshotUtils.capture(
                        driver,
                        result.getMethod().getMethodName()
                );


                try {
                    byte[] screenshot =
                            ((TakesScreenshot) driver)
                                    .getScreenshotAs(OutputType.BYTES);

                    Allure.addAttachment(
                            "Failure Screenshot",
                            "image/png",
                            new ByteArrayInputStream(screenshot),
                            ".png"
                    );

                    System.out.println("Screenshot attached to Allure!");

                } catch (org.openqa.selenium.WebDriverException e) {
                    System.out.println(
                            "Could not capture screenshot: " + e.getMessage()
                    );
                }

            }
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println(
                "SKIPPED: " + result.getName()
        );
    }
}