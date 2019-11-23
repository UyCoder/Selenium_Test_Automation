package com.seleniummaster.classtutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CarSearch {
    public static void main(String[] args) {
        //add chromedriver to the system property - for windows
        System.setProperty("webdriver.chrome.driver", "c:\\webdriver\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        //maximize browser window
        webDriver.manage().window().maximize();
        //open the website
        webDriver.get("https://www.cars.com"); //this is for opening a the site
        Car car1 = new Car("Toyota", "RAV4", "Red");
        WebElement carMake = webDriver.findElement(By.name("makeId"));
        Select carSelect = new Select(carMake); //define a dropdown select object
        carSelect.selectByVisibleText(car1.getMake()); //select car make
        WebElement searchButton = webDriver.findElement(By.cssSelector("input[value='Search']"));
        searchButton.click();
        //define search result
        WebDriverWait wait=new WebDriverWait(webDriver,60);
        WebElement searchResult=
                wait.until(ExpectedConditions.presenceOfElementLocated
                        (By.xpath("//div[@class='matchcount']/div/span[@class='filter-count']")));

        //wait(webDriver,searchResult);
        if (searchResult.isDisplayed())
            System.out.println("Search test case passed");
        else
            System.out.println("Search test case failed");

        webDriver.close();
        webDriver.quit();
    }
}
