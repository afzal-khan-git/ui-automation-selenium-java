package com.ak.selenium.tests;

import com.ak.selenium.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StorePageTests extends TestBase {

    @Test
    public void tc_1_verifyPageTitle(){
        String storePageTitle ="Products – AskOmDch";
        String title = driver.getTitle();
        Assert.assertEquals(storePageTitle,title);
    }

}
