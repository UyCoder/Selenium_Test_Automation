package com.seleniummaster.basic.homework;
/**
 *
 */

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class Week13_1_4_TestLoginMahara {
    public static void main(String[] args) {
        //add chromedriver to the system property
        System.setProperty("webdriver.chrome.driver", "c:\\webdriver\\chromedriver.exe");
        //define a driver to open browser
        WebDriver webDriver= new ChromeDriver();
        //maximize browser window
        webDriver.manage().window().maximize();
        //open the website
        webDriver.get("https://demo.mahara.org/");
        //if the website does not open within 60 seconds
        webDriver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        //define the username textfield and input username
        WebElement username=webDriver.findElement(By.id("login_login_username"));
        username.sendKeys("admin");
        //define the password texfield and input password
        WebElement password=webDriver.findElement(By.id("login_login_password"));
        password.sendKeys("MaharaDemo"+Keys.ENTER);
        //verify element for ensuring login successfully. "inbox" button from dashboard by id=nav-inbox
        WebElement inbox=webDriver.findElement(By.id("nav-inbox"));
        if (inbox.isDisplayed())
        {
            System.out.println("=========================");
            System.out.println("\u001B[34mMahara Login Test passed.\u001B[0m");
            System.out.println("=========================");
            System.out.println(inbox.getText());
        }
        else {
            System.out.println("====================");
            System.out.println("\u001B[31mMahara Login failed.\u001B[0m");
            System.out.println("====================");
        }
        //close the browser and quit
        webDriver.close();
        webDriver.quit();
    }
}
