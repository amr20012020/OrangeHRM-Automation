package com.amr.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class ScreenshotUtils {
    public static void capture(WebDriver driver, String testName) {
        try {
            File screenshots = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Path folder = Path.of("target","screenshots");
            Files.createDirectories(folder);
            Path destination = folder.resolve(testName + "_"+ System.currentTimeMillis() + ".png");
            Files.copy(screenshots.toPath(), destination);
            System.out.println("ScreenShots Saved: "+ destination.toAbsolutePath());
        }catch (Exception e){
            System.out.println("ScreenShots Failed: "+ e.getMessage());

        }

    }
}
