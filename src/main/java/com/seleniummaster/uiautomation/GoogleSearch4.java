package com.seleniummaster.uiautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class GoogleSearch4 {
    public static void main(String[] args) throws InterruptedException {
        //add chromedriver to the system property
        //for windows :
        System.setProperty("webdriver.chrome.driver", "c:\\webdriver\\chromedriver.exe");
        //for mac :
        //System.setProperty("webdriver.chrome.driver","/user/so1/webdriver/chromedriver");
        //define a driver to open browser
        WebDriver webDriver= new ChromeDriver();
        //maximize browser window
        webDriver.manage().window().maximize();
        //open the website
        webDriver.get("https://www.google.com");
        //if the website does not open within 60 seconds
        webDriver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        //define the web element

        //loop the search 5 times
        for(int i=1; i<5;i++) {
            WebElement searchBox = webDriver.findElement(By.name("q"));
            String searchWord=args[i-1];
            System.out.println("Keywords: "+searchWord);
            searchBox.sendKeys(searchWord + Keys.ENTER);
            WebElement searchresult = webDriver.findElement(By.id("resultStats"));
            if (searchresult.isDisplayed()) {
                System.out.println("Google search passed.");
                System.out.println(searchresult.getText());
            } else
                {
                System.out.println("Google serach failed.");
            }
            Thread.sleep(2000);
            webDriver.navigate().back(); //go back to the main page
        }
        //close the browser and quit
        webDriver.close();
        webDriver.quit();
    }
}
