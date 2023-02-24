package com.ak.selenium.driverfactory;

import org.openqa.selenium.WebDriver;

public class BrowserDriverFactory {

    public static WebDriver getBrowserDriverInstance(String browserName){
        WebDriver driver;

        switch (browserName){
            case "CHROME":
                driver = BrowserDriverType.CHROME.setUpDriver();
                break;
            case "FIREFOX":
                driver = BrowserDriverType.FIREFOX.setUpDriver();
                break;
            case "SAFARI":
                driver = BrowserDriverType.SAFARI.setUpDriver();
                break;
            case "EDGE":
                driver = BrowserDriverType.EDGE.setUpDriver();
                break;

            default: throw new IllegalArgumentException("Please provide valid browser name");
        }
        return driver;
    }
}
