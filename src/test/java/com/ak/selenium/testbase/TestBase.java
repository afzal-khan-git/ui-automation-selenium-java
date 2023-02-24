package com.ak.selenium.testbase;

import com.ak.selenium.driverfactory.BrowserDriverFactory;
import com.ak.selenium.driverfactory.BrowserDriverType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestBase {

    public static WebDriver driver;

    @BeforeTest
    @Parameters("browserName")
    void launchBrowserAndNavigateToURL(@Optional("CHROME") String browserName){
        driver = BrowserDriverFactory.getBrowserDriverInstance("FIREFOX");
        driver.navigate().to("https://askomdch.com/");

    }



}
