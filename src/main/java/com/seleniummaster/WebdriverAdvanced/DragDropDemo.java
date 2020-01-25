package com.seleniummaster.WebdriverAdvanced;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * @author Ahmet Bughra
 * @create 2020-01-25-3:37 PM
 * @email bughra1991@gmail.com
 */
public class DragDropDemo {
    WebDriver webDriver;
    public static int timeout = 30;

    @Before
    public void setUp() {
        System.setProperty("webdriver.firefox.marionette", "c:\\geckodriver\\geckodriver.exe");
        webDriver = new FirefoxDriver();
        webDriver.manage().timeouts().pageLoadTimeout(timeout, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        webDriver.get("https://jqueryui.com/droppable/");
    }

    @Test
    public void DragDropTest() throws InterruptedException {
        //wait for iframe to load
        waitForElementVisible(By.tagName("iframe"), timeout);
        WebElement iframeElement = webDriver.findElement(By.tagName("iframe"));
        //switch to the iframe
        webDriver.switchTo().frame(iframeElement);
        WebElement draggableElement = webDriver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement droppableElement = webDriver.findElement(By.xpath("//div[@id='droppable']"));
        Point beforeLocation = draggableElement.getLocation();
        int beforeX = beforeLocation.getX();
        Thread.sleep(2000);
        //Create object of actions class
        Actions actions = new Actions(webDriver);
        actions.dragAndDrop(draggableElement, droppableElement).build().perform();
        Thread.sleep(2000);
        //get x location after drag and drop
        Point afterLocation = draggableElement.getLocation();
        int afterX = afterLocation.getX();
        System.out.println("Before X=" + beforeX + "  After X=" + afterX);
        Assert.assertTrue(afterX > beforeX);

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
