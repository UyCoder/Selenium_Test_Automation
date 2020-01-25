package com.seleniummaster.WebdriverAdvanced;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * @author Ahmet Bughra
 * @create 2020-01-25-3:38 PM
 * @email bughra1991@gmail.com
 */
public class DragDropResizeDemo {
    WebDriver webDriver;
    public static int timeout = 30;

    @Before
    public void setUp() {
        System.setProperty("webdriver.firefox.marionette", "c:\\geckodriver\\geckodriver.exe");
        webDriver = new FirefoxDriver();
        webDriver.manage().timeouts().pageLoadTimeout(timeout, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        webDriver.get("https://jqueryui.com/resizable/");
    }

    @Test
    public void DragDropByOffsetTest() throws InterruptedException {
        //wait for iframe to load
        waitForElementVisible(By.tagName("iframe"), timeout);
        WebElement iframeElement = webDriver.findElement(By.tagName("iframe"));
        //switch to the iframe
        webDriver.switchTo().frame(iframeElement);
        //define resizable element
        WebElement resizableElement = webDriver.findElement(By.xpath("//div[@id='resizable']/h3"));
        WebElement draggingPoint = webDriver.findElement(By.xpath("//div[@id=\"resizable\"]/div[contains(@class,\"ui-icon-gripsmall-diagonal-se\")]"));
        //get width of resizable element
        int beforeWidth = resizableElement.getSize().getWidth();
        //Create object of actions class
        Actions actions = new Actions(webDriver);
        actions.clickAndHold(draggingPoint).moveByOffset(200, 0).release().build().perform();
        //get width after resize
        int afterWidth = resizableElement.getSize().getWidth();
        System.out.println("Before width=" + beforeWidth + "  After X=" + afterWidth);
        Assert.assertTrue((afterWidth - beforeWidth) == 200);

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
