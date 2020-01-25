package com.seleniummaster.WebdriverAdvanced;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * @author Ahmet Bughra
 * @create 2020-01-25-3:40 PM
 * @email bughra1991@gmail.com
 */
public class TinymceDemo {
    WebDriver webDriver;
    public static int timeout = 30;

    @Before
    public void setUp() {
        System.setProperty("webdriver.firefox.marionette", "c:\\geckodriver\\geckodriver.exe");
        webDriver = new FirefoxDriver();
        webDriver.manage().timeouts().pageLoadTimeout(timeout, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        webDriver.get("https://www.tinymce.com/docs/demo/full-featured/");
    }

    @Test
    public void tinymceTest() throws InterruptedException {
        //wait for top iframe to load
        waitForElementVisible(By.id("cp_embed_NGegZK"), timeout);
        WebElement topIframeElement = webDriver.findElement(By.id("cp_embed_NGegZK"));
        //switch to the top iframe
        webDriver.switchTo().frame(topIframeElement);
        //define result frame
        WebElement resultFrame = webDriver.findElement(By.id("result-iframe"));
        //switch to the result frame
        webDriver.switchTo().frame(resultFrame);
        //define mce frame
        WebElement mceFrame = webDriver.findElement(By.id("mce_0_ifr"));
        //switch to the frame
        webDriver.switchTo().frame(mceFrame);
        //define mce body
        WebElement mceBody = webDriver.findElement(By.xpath("//body[@id='tinymce']"));
        Thread.sleep(2000);
        mceBody.clear();
        Thread.sleep(2000);
        mceBody.sendKeys("Selenium Master");
        mceBody.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        mceBody.sendKeys("Java WebDriver Crash Course");
        Thread.sleep(2000);
        String bodyText = mceBody.getText();
        Assert.assertTrue(bodyText.contains("Java WebDriver"));
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
