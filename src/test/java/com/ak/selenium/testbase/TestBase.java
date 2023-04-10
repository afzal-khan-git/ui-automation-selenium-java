package com.ak.selenium.testbase;

import com.ak.selenium.driverfactory.BrowserDriverFactory;
import com.ak.selenium.driverfactory.BrowserDriverType;
import com.ak.selenium.util.ConfigPropertyReaderUtil;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class TestBase {

    public static WebDriver driver;

    @BeforeTest
    @Parameters("browserName")
    public void launchBrowserAndNavigateToURL(@Optional("CHROME") String browserName){
        driver = BrowserDriverFactory.getBrowserDriverInstance(browserName.toUpperCase());
        driver.navigate().to(ConfigPropertyReaderUtil.getPropertyValueByKey("app_url","app_test.properties"));

    }

    @AfterTest
    public void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }



}
