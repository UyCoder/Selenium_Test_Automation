package com.seleniummaster.classtutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CardemoMaxSearch {
    public static void main(String[] args) {
       CarDemo myCarDemo =new CarDemo();
       myCarDemo.setMake("Toyota");

        //add chromedriver to the system property
        //for windows :
        System.setProperty("webdriver.chrome.driver", "c:\\webdriver\\chromedriver.exe");
        //for mac :
        //System.setProperty("webdriver.chrome.driver","/user/so1/webdriver/chromedriver");
        //define a driver to open browser
        WebDriver webDriver = new ChromeDriver();
        //maximize browser window
        webDriver.manage().window().maximize();
        //open the website
        webDriver.get("https://www.carmax.com");
        WebElement searchBox = webDriver.findElement(By.id("header-inventory-search"));
        searchBox.sendKeys(myCarDemo.getMake() + Keys.ENTER);
        WebElement carResult=webDriver.findElement(By.cssSelector("span.header-value.kmx-typography--headline-1"));

        String totalCars = carResult.getText().replace(",", "");
        if (Integer.parseInt(totalCars) > 1) {
            System.out.println("CarDemo Search passed; total number" + Integer.parseInt(totalCars));
        } else
            System.out.println("No car available");
        webDriver.close();
        webDriver.quit();
    }
}
