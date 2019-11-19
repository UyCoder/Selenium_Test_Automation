package com.seleniummaster.uiautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class StudentCreateGroupDemo {
    public static void main(String[] args) {
        // setup sysyem variablefor chromedriver
        System.setProperty("webdriver.chrome.driver", "c:\\webdriver\\chromedriver.exe");
        //define a web driver variable
        WebDriver browser = new ChromeDriver();
        //MAXIMIXE THE WINDOW
        browser.manage().window().maximize();
        //set maximize page timeout
        browser.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        // NAVIGATE TO testing site
        browser.get("http://mahara.unitedcoderschool.com/mahara/");
        //login implementation
        WebElement usernameElement = browser.findElement(By.id("login_login_username"));
        waitUntilIsVisible(browser, usernameElement);
        usernameElement.sendKeys("atiyakulsum");
        WebElement passwordElement = browser.findElement(By.id("login_login_password"));
        passwordElement.sendKeys("MaharaDemo123!");
        WebElement submitButton = browser.findElement(By.id("login_submit"));
        submitButton.click();
        //create group implementation
        WebElement mainMenu = browser.findElement(By.xpath("//button/span[@class='icon icon-bars icon-lg']"));
        waitUntilIsVisible(browser, mainMenu);
        mainMenu.click();
        WebElement dropdownMenu=browser.findElement(By.xpath(" //a[@class='engage menu-dropdown-toggle']"));
        waitUntilIsVisible(browser,dropdownMenu);
        dropdownMenu.click();
        WebElement groupItems=browser.findElement(By.xpath("//a[text()='Groups']"));
        waitUntilIsVisible(browser,groupItems);
        groupItems.click();
        //creating group
        WebElement creatGroup=browser.findElement(By.xpath("//a[@class='btn btn-secondary creategroup']"));
        waitUntilIsVisible(browser,creatGroup);
        creatGroup.click();
        WebElement groupName=browser.findElement(By.id("editgroup_name"));
        groupName.sendKeys("Automation Group");
        //switching to frame
        browser.switchTo().frame("editgroup_description_ifr");
        WebElement groupDisccription=browser.findElement(By.xpath("//p"));
        groupDisccription.sendKeys("This group is for Java coders");
        //switch back to parent frame
        browser.switchTo().parentFrame();
        //for scrolling down the page
        JavascriptExecutor js = (JavascriptExecutor) browser;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        WebElement saveButton=browser.findElement(By.xpath("//button[@class='btn-primary submitcancel submit btn']"));
        saveButton.click();
        // verify group is created
        WebElement searchresult2=browser.findElement(By.xpath("//div[@class='alert alert-success'][div[text()='Group saved successfully']]"));

        // logout implementation
        WebElement userMenu = browser.findElement(By.xpath("//button/span[@class='icon icon-chevron-down collapsed']"));
        waitUntilIsVisible(browser, userMenu);
        userMenu.click();
        WebElement logoutButton = browser.findElement(By.id("logoutbutton"));
        waitUntilIsVisible(browser, logoutButton);
        logoutButton.click();
        //verify logout
        WebElement messageElement = browser.findElement(By.id("messages"));
        waitUntilIsVisible(browser, messageElement);
        if (messageElement.isDisplayed()) {
            System.out.println("passed");
            System.out.println(messageElement.getText());
        } else
            System.out.println(" failed");
        browser.close();
        browser.quit();




    }
    public static void  waitUntilIsVisible( WebDriver driver,WebElement webElement) {
        WebDriverWait WebDriverWait = new WebDriverWait(driver, 30);
        WebDriverWait.until(ExpectedConditions.visibilityOf(webElement));
    }
    }
