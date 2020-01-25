package com.seleniummaster.WebdriverAdvanced;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * @author Ahmet Bughra
 * @create 2020-01-25-3:36 PM
 * @email bughra1991@gmail.com
 */
public class AlertDismissDemo {
    WebDriver webDriver;
    public static int timeout = 30;

    @Before
    public void setUp() {
        System.setProperty("webdriver.firefox.marionette", "c:\\geckodriver\\geckodriver.exe");
        webDriver = new FirefoxDriver();
        webDriver.manage().timeouts().pageLoadTimeout(timeout, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        webDriver.get("http://www.seleniummaster.com/sitecontent/testfiles/alert.html");
    }

    @Test
    public void AlertTest() throws InterruptedException {
        waitForElementVisible(By.xpath("//input[@value=\"testcase1\"]"), timeout);
        //define test case 1 element
        WebElement testcase1Element = webDriver.findElement(By.xpath("//input[@value=\"testcase1\"]"));
        //define remove button element
        WebElement removeButton = webDriver.findElement(By.name("removebutton"));
        //click on remove button
        removeButton.click();
        Thread.sleep(2000);
        try {
            Alert alert = webDriver.switchTo().alert();
            String alertText = alert.getText();
            System.out.println(alertText);
            alert.dismiss();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //verify that test case 1 element still exist
        Assert.assertTrue(testcase1Element.isDisplayed());

    }

    @After
    public void tearDown() {
        //close the browser
        webDriver.close();
        //quit the browser
        webDriver.quit();

    }

    public void waitForElementVisible(By by, int timeoutSeconds) {
        try {
            WebDriverWait webDriverWait = new WebDriverWait(webDriver, timeoutSeconds);
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated((by)));
        } catch (Exception e) {
            System.out.println("Element " + by.toString() + "  is not found within " + timeoutSeconds + " seconds");
        }

    }
}
