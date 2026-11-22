package com.amr.factory;
import com.amr.config.ConfigReader; import org.openqa.selenium.WebDriver; import org.openqa.selenium.chrome.ChromeDriver; import org.openqa.selenium.firefox.FirefoxDriver;
public final class DriverFactory {private DriverFactory(){} public static WebDriver createDriver(){switch(ConfigReader.get("browser").toLowerCase()){case "chrome":return new ChromeDriver();case "firefox":return new FirefoxDriver();default:throw new IllegalArgumentException("Unsupported browser");}}}
