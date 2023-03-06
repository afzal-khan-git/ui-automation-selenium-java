package com.ak.selenium.util;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SeleniumActionsMethods {

    /**
     * locate an element in Webpage using BY locator and return the WebElement
     * @param by
     * @param driver
     * @return
     */
    public static WebElement findWebElement(By by, WebDriver driver){
        return driver.findElement(by);
    }

    /**
     * clicks on the provided Element
     * @param by
     * @param driver
     */
    public static void clickOnElement(By by, WebDriver driver){
        findWebElement(by,driver).click();
    }

    /**
     * return text of an element
     */
    public static String getWebElementText(By by, WebDriver driver){
        return findWebElement(by,driver).getText();
    }

    /**
     * move to the element using Actions class
     * @param by
     * @param driver
     */
    public static void moveToTheElement(By by, WebDriver driver){
        new Actions(driver).moveToElement(findWebElement(by,driver)).perform();
    }
    /**
     * clears a text field and send provided text
     */
    public static void clearAndSendKeys(By by, WebDriver driver, String txt){
        clickOnElement(by,driver);
        findWebElement(by,driver).clear();
        findWebElement(by,driver).sendKeys(txt);

    }
    /**
     * click on Element by handling Stale element exception
     * @param by
     * @param driver
     */
    public static void clickOnElementByHandlingStaleElementException(By by, WebDriver driver){
        try {
            moveToTheElement(by,driver);
            clickOnElement(by,driver);
        }catch (StaleElementReferenceException e){
            moveToTheElement(by,driver);
            clickOnElement(by,driver);
        }
    }

}
