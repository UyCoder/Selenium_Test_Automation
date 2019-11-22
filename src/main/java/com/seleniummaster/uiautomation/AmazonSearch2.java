package com.seleniummaster.uiautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;

public class AmazonSearch2 {
    public static void main(String[] args) {
        //add chromedriver to the system property
        //for windows :
        System.setProperty("webdriver.chrome.driver", "c:\\webdriver\\chromedriver.exe");
        //define a driver to open browser
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        WebDriver webDriver = new ChromeDriver(chromeOptions);
        //define multiple product to search
        List<String> products = new ArrayList<String>();
        products.add("Dell laptop");
        products.add("iphone case");
        for (String product : products) {
            //maximize browser window
            webDriver.manage().window().maximize();
            webDriver.get("https://www.amazon.com");
            //define search Box
            WebElement searchBox = webDriver.findElement(By.id("twotabsearchtextbox"));
            searchBox.sendKeys(product);//type search text
            //define search button
            WebElement searchButton = webDriver.findElement(By.cssSelector("input[value='Go']"));
            searchButton.click();//click search button
            WebElement searchResult = webDriver.findElement(By.xpath("//div/span[contains(text(),'results')]"));
            if (searchResult.isDisplayed()) {
                System.out.println("Search Result: " + searchResult.getText());
                System.out.println("Search test Passed.");
            } else {
                System.out.println("Search test Failed.");
            }
            webDriver.navigate().back();// go back to previous page
        }

        //close the browser and quit
        webDriver.close();// just closing browser
        webDriver.quit(); // terminate all process of driver
    }
}
