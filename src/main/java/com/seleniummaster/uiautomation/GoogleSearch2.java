package com.seleniummaster.uiautomation;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

public class GoogleSearch2 {
    public static void main(String[] args) {
        //add chromedriver to the system property
        //for windows :
        System.setProperty("webdriver.chrome.driver", "c:\\webdriver\\chromedriver.exe");
        //for mac :
        //System.setProperty("webdriver.chrome.driver","/user/so1/webdriver/chromedriver");
        //define a driver to open browser
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);//wait untill the page is fully loaded
        WebDriver webDriver= new ChromeDriver();
        //maximize browser window
        webDriver.manage().window().maximize();
        //open the website
        webDriver.get("https://www.google.com");
        //if the website does not open within 60 seconds
        webDriver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        //define the web element
        WebElement searchBox=webDriver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium"+Keys.ENTER);
        WebElement searchresult=webDriver.findElement(By.id("resultStats"));
        if (searchresult.isDisplayed())
        {
            String result=searchresult.getText();
            //only get the number form the result string
            result=result.trim().substring(result.indexOf("t")+1,result.indexOf("r"));
            //remove ,
            result=result.replace(",","").trim();
            long theCountInResult=Long.parseLong(result); //convert the numeric string to number
            System.out.println("Search result count: "+result);
            if(theCountInResult>10000)
                System.out.println("Search result is more than 10,000, test passed.");
            else
                System.out.println("Search result is less tahn 10,000, test faild.");
        }
        else
            System.out.println("Google serach failed.");
        //close the browser and quit
        webDriver.close();
        webDriver.quit();
    }
}
