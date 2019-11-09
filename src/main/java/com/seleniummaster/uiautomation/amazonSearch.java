package com.seleniummaster.uiautomation;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class amazonSearch {
    public static void main(String[] args) {
        //add chromedriver to the system property
        //for windows :
        System.setProperty("webdriver.chrome.driver", "c:\\webdriver\\chromedriver.exe");
        //define a driver to open browser
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        WebDriver webDriver= new ChromeDriver(chromeOptions);
        //maximize browser window
        webDriver.manage().window().maximize();
        webDriver.get("https://www.amazon.com");
        //define search Box
        WebElement searchBox=webDriver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys(args[0]);//type search text
        //define search button
        WebElement searchButton=webDriver.findElement(By.cssSelector("input[value='Go']"));
        searchButton.click();//click search button
        WebElement searchResult = webDriver.findElement(By.xpath("//div/span[contains(text(),'results')]"));
        if(searchResult.isDisplayed())
        {
            System.out.println("Search Result: " +searchResult.getText());
            System.out.println("Search test Passed.");
        }else{
            System.out.println("Search test Failed.");
        }

        //close the browser and quit
        webDriver.close();
        webDriver.quit();
    }
}
