package com.seleniummaster.uiautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MaharaAutomation {
    public static void main(String[] args) {
        //setup system variable for chromedriver
        System.setProperty("webdriver.chrome.driver","c:\\webdriver\\chromedriver.exe");
        //define a webdriver variable
        WebDriver browser=new ChromeDriver();
        //maximize browser window
        browser.manage().window().maximize();
        //set maximun page time out
        browser.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        //navigate to the testing site
        browser.get("http://mahara.unitedcoderschool.com/mahara/");
        //login implementation
        WebElement userNameElement=browser.findElement(By.id("login_login_username"));
        waitUntilElementVisiable(browser,userNameElement);
        userNameElement.sendKeys("student1");
        WebElement passwordElement=browser.findElement(By.id("login_login_password"));
        waitUntilElementVisiable(browser,passwordElement);
        passwordElement.sendKeys("MaharaDemo123!");
        WebElement submitButton=browser.findElement(By.id("login_submit"));
        waitUntilElementVisiable(browser,submitButton);
        submitButton.click();
        //vrify login
        //logout
        WebElement userMenu=browser.findElement(By.xpath("//button/span[@class='icon icon-chevron-down collapsed']"));
        waitUntilElementVisiable(browser,userMenu);
        boolean isLoginSuccess=userMenu.isDisplayed();
        userMenu.click();
        WebElement logoutButton=browser.findElement(By.id("logoutbutton"));
        waitUntilElementVisiable(browser,logoutButton);
        logoutButton.click();
        //vrify logout
        WebElement messegeElement=browser.findElement(By.id("messages"));
        waitUntilElementVisiable(browser,messegeElement);
        boolean isLogoutSuccess=messegeElement.getText().contains("logged out");
        if(isLoginSuccess&&isLogoutSuccess) {
            System.out.println("=========================");
            System.out.println("\u001B[34mLogin Logout test passed.\u001B[0m");
            System.out.println("=========================");
        }
        else {
            System.out.println("=========================");
            System.out.println("\u001B[31mLogin Logout test failed.\u001B[0m");
            System.out.println("=========================");
        }

        browser.close();
        browser.quit();

    }
     public static void waitUntilElementVisiable(WebDriver driver, WebElement webElement)
     {
         WebDriverWait webDriverWait=new WebDriverWait(driver,30);
         webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
     }
}
