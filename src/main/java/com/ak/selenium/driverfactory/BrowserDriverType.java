package com.ak.selenium.driverfactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public enum BrowserDriverType {

    CHROME{
        @Override
        public WebDriver setUpDriver() {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--incognito");
            WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
            return new ChromeDriver(chromeOptions);
        }
    },
    FIREFOX{
        @Override
        public WebDriver setUpDriver() {
            WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
            return new FirefoxDriver();
        }
    },
    SAFARI{
        @Override
        public WebDriver setUpDriver() {
            WebDriverManager.getInstance(DriverManagerType.SAFARI).setup();
            return new SafariDriver();
        }
    },
    EDGE{
        @Override
        public WebDriver setUpDriver() {
            WebDriverManager.getInstance(DriverManagerType.EDGE).setup();
            return new EdgeDriver();
        }
    };

    public abstract WebDriver setUpDriver();



}
