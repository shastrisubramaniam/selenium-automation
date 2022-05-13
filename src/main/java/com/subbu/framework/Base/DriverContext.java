package com.subbu.framework.Base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverContext {
    public static WebDriver Driver;
    public static String Browser;
    public static String BrowserURL;
    public static WebDriver getDriver(String browser) {
        Browser = browser;
        switch (DriverContext.Browser) {
            case "firefox" :
                DriverContext.Driver = new FirefoxDriver();
                break;
            case "edge" :
                DriverContext.Driver = new EdgeDriver();
                break;
            case "safari" :
                DriverContext.Driver = new SafariDriver();
                break;
            case "chrome" :
            default:
                System.setProperty("webdriver.chrome.driver","C:\\Users\\Subramaniam\\Downloads\\chromedriver_win32\\chromedriver.exe");
                DriverContext.Driver = new ChromeDriver();
                DriverContext.Driver.navigate().to("https://automatenow.io/sandbox-automation-testing-practice-website/");
                DriverContext.Driver.manage().window().maximize();
                JavascriptExecutor js = (JavascriptExecutor)DriverContext.Driver;
                break;
        }
        return DriverContext.Driver;
    }
}
