package com.ak.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.ak.selenium.util.SeleniumActionsMethods.*;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    By shopNowLink = By.cssSelector("a[href='/store']");

    public StorePage clickOnShopNowLink(){
        clickOnElement(shopNowLink,driver);

        return new StorePage(driver);
    }


}
