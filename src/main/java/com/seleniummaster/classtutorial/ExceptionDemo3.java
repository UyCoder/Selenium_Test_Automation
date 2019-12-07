package com.seleniummaster.classtutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ExceptionDemo3 {
    //verify that the website demo.mahara.org contains a link 'legal'
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "c:\\webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(); // using ChromeDriver
        driver.manage().window().maximize(); // maximize browser window
        try {
            driver.navigate().to(new URL("http://demo.mahara.org"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } finally {
            System.out.println("This is for verifying the link");
        }

        //find all links on the website
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        int totalLinks = allLinks.size();// total links count
        System.out.println("Total links: " + totalLinks);
        List<String> urls = new ArrayList<>();
        for (WebElement link : allLinks) {
            System.out.println(link.getText() + " " + link.getAttribute("href"));
            urls.add(link.getAttribute("href")); // add link to the list
        }

        // open each link and verify
        for (String url : urls) {
            System.out.println("Current URL: " + url);
            if (url!=null) {
                driver.navigate().to(url);
            }
            Thread.sleep(2000);
        }

        //close the driver and quit
        driver.close();
        driver.quit();
    }

}
