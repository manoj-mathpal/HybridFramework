package com.myApp.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {

    /****CLASS***
     This is the Base Test class, it will contain the logic of creating the driver and other util methods that
     can be used in automating the application.
     */
    protected static ChromeDriver driver;

    static {
       setupDriver();
    }

    public ChromeDriver getDriver(){
        return driver;
    }
    public static void setupDriver(){
        System.setProperty("webdriver.chrome.driver","/Users/manoj.mathpal/Documents/chromedriver-mac-x64/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins");
        driver  = new ChromeDriver(options);
    }

    public static void quitDriver(){
        driver.quit();
    }

}
