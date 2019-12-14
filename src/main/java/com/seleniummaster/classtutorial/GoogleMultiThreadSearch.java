package com.seleniummaster.classtutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
public class GoogleMultiThreadSearch implements Runnable {
    private String keyword;
    // generate constructor
    public GoogleMultiThreadSearch(String keyword) {
        this.keyword = keyword;
    }
    @Override
    public void run() {
        System.setProperty("webdriver.chrome.driver", "c:\\webdriver\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        WebElement searchBox = driver.findElement( By.name("q"));
        searchBox.sendKeys(keyword + Keys.ENTER);
        WebElement searchResult = driver.findElement(By.id("resultStats"));
        if (searchResult.isDisplayed()) {
            System.out.println("Google search passed");
            System.out.println(searchResult.getText());
        } else
        {System.out.println("Google search failed");}
        driver.close();
        driver.quit();
    }
}
