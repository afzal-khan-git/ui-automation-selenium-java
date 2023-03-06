package com.ak.selenium.tests;

import com.ak.selenium.pages.HomePage;
import com.ak.selenium.testbase.TestBase;
import com.ak.selenium.util.ConfigPropertyReaderUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {

    @Test
    public void tc_1_verifyHomePageTitle(){
        String homePageTitle = "AskOmDch – Become a Selenium automation expert!";
        String title = driver.getTitle();
        Assert.assertEquals(homePageTitle,title);
        HomePage homePage = new HomePage(driver);
        homePage.clickOnShopNowLink();

    }




}
