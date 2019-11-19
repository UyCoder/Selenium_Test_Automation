package com.seleniummaster.uiautomation;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class VerifyMultpleWebsite {
    public static void main(String[] args) {
        //add chromedriver to the system property - for windows
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        System.setProperty("webdriver.chrome.driver", "c:\\webdriver\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver(chromeOptions);
        //maximize browser window
        webDriver.manage().window().maximize();
        //open the website
        Map<String,String> websites=new HashMap<String,String>();
        websites.put("Google","https://www.google.com");
        websites.put("Yahoo","https://www.yahoo.com");
        websites.put("YouTube","https://www.youtube.com");
        Set<String> sites=websites.keySet(); //return all site names as keys
        for(String site: sites)
        {
            System.out.println("The site under test: "+websites.get(site));
            webDriver.get(websites.get(site)); //open the site
            String siteTitle=webDriver.getTitle();
            if(siteTitle.contains(site))
                System.out.println("Test passed");
            else
                System.out.println("Test failed");
        }
        webDriver.close();
        webDriver.quit();
    }
}
