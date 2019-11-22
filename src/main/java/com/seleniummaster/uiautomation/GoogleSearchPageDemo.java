package com.seleniummaster.uiautomation;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class GoogleSearchPageDemo {
    public static void main(String[] args) {
        System.setProperty("webdriver.crhome.driver", "c:\\webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.get("https://www.google.com");
        //wait til the search field display
        WebElement searchElement = driver.findElement(By.name("q"));
        waitForElelement(driver, searchElement);
        searchElement.sendKeys("Selenium"+ Keys.ENTER);
        //start the stopwatch
        StopWatch stopWatch=new StopWatch();//define a stopwatch variable
        stopWatch.start(); //start counting the time
        WebElement searchResult = driver.findElement(By.id("resultStats"));
        waitForElelement(driver,searchResult);
        if(searchResult.isDisplayed())
        {
            stopWatch.stop(); // stop counting the time
            long totalTime=stopWatch.getTime();
            System.out.println("Total search time "+totalTime);
            System.out.println("Search test passed.");
        }else {
            System.out.println("Test failed.");
        }
        driver.close();
        driver.quit();




    }

    public static void waitForElelement(WebDriver driver, WebElement webElement) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 60);
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
    }
}
