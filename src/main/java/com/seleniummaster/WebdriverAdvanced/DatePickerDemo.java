package com.seleniummaster.WebdriverAdvanced;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * @author Ahmet Bughra
 * @create 2020-01-25-3:37 PM
 * @email bughra1991@gmail.com
 */
public class DatePickerDemo {
    WebDriver webDriver;
    public static int timeout = 30;

    @Before
    public void setUp() {
        System.setProperty("webdriver.firefox.marionette", "c:\\geckodriver\\geckodriver.exe");
        webDriver = new FirefoxDriver();
        webDriver.manage().timeouts().pageLoadTimeout(timeout, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        webDriver.get("https://jqueryui.com/datepicker/#date-range");
    }

    @Test
    public void DatePickerTest() throws InterruptedException {
        //wait for iframe to load
        waitForElementVisible(By.tagName("iframe"), timeout);
        WebElement iframeElement = webDriver.findElement(By.tagName("iframe"));
        //switch to the iframe
        webDriver.switchTo().frame(iframeElement);
        //Choose From Month Day Date
        WebElement datePickerFrom = webDriver.findElement(By.xpath("//input[@id=\"from\"]"));
        datePickerFrom.click();
        Thread.sleep(2000);
        WebElement monthFrom = webDriver.findElement(By.xpath("//div/select[@class='ui-datepicker-month']"));
        Select monthSelect = new Select(monthFrom);
        monthSelect.selectByVisibleText("Nov");
        Thread.sleep(2000);
        WebElement dayFrom = webDriver.findElement(By.xpath("//table/tbody/tr/td/a[text()='10']"));
        dayFrom.click();
        Thread.sleep(2000);
        //choose to month day date
        WebElement datePickerTo = webDriver.findElement(By.xpath("//input[@id='to']"));
        datePickerTo.click();
        WebElement monthTo = webDriver.findElement(By.xpath("//div/select[@class='ui-datepicker-month']"));
        Select monthToSelect = new Select(monthTo);
        monthToSelect.selectByVisibleText("Dec");
        Thread.sleep(2000);
        WebElement dayTo = webDriver.findElement(By.xpath("//table/tbody/tr/td/a[text()='10']"));
        dayTo.click();
        //get the string to input
        String toMonthString = datePickerTo.getAttribute("value");
        System.out.println(toMonthString);
        //verify that sub menu is displayed
        Assert.assertEquals(toMonthString, "12/10/2017");

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
