package com.seleniummaster.UIautomationFramework.PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Ahmet Bughra
 * @create 2020-01-14-9:56 PM
 * @email bughra1991@gmail.com
 */
public class PageFunctions {
    WebDriver driver;

    public PageFunctions(WebDriver driver) {
        this.driver = driver;
    }

    public boolean waitForElementVisible(WebElement element, int timeoutSeconds) {
        boolean isElementDisplayed = false;
        try {
            WebDriverWait webDriverWait = new WebDriverWait(driver, timeoutSeconds);
            webDriverWait.until(ExpectedConditions.visibilityOf(element));
            isElementDisplayed = true;
        } catch (Exception e) {
            System.out.println("Element " + element.toString() + "  is not found within " + timeoutSeconds + " seconds");
        }
        return isElementDisplayed;
    }
}
