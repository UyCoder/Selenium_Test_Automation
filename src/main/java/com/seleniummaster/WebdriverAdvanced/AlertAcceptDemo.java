package com.seleniummaster.WebdriverAdvanced;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * @author Ahmet Bughra
 * @create 2020-01-25-3:36 PM
 * @email bughra1991@gmail.com
 */
public class AlertAcceptDemo {
    WebDriver webDriver;
    public static int timeout = 30;

    @Before
    public void setUp() {
        System.setProperty("webdriver.firefox.marionette", "c:\\webdriver\\geckodriver.exe");
        webDriver = new FirefoxDriver();
        webDriver.manage().timeouts().pageLoadTimeout(timeout, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        webDriver.get("http://www.seleniummaster.com/sitecontent/testfiles/alert.html");
    }

    @Test
    public void AlertTest() throws InterruptedException {
        waitForElementVisible(By.xpath("//input[@value=\"testcase1\"]"), timeout);
        //define remove button element
        WebElement removeButton = webDriver.findElement(By.name("removebutton"));
        //click on remove button
        removeButton.click();
        Thread.sleep(2000);
        try {
            Alert alert = webDriver.switchTo().alert();
            String alertText = alert.getText();
            System.out.println(alertText);
            alert.accept();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Thread.sleep(2000);
        //get page source
        boolean isTestCase1Exist = false;
        WebElement testcase1Element;
        try {
            testcase1Element = webDriver.findElement(By.xpath("//input[@value=\"testcase1\"]"));
            if (testcase1Element.isDisplayed())
                isTestCase1Exist = true;
        } catch (NotFoundException e) {
            e.printStackTrace();
            isTestCase1Exist = false;
        }


        System.out.println(isTestCase1Exist);
        Assert.assertFalse(isTestCase1Exist);

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
