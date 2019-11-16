package com.seleniummaster.uiautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class maharaAutomation_TestCase2 {
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
        browser.get("https://demo.mahara.org/");
        //login implementation
        WebElement userNameElement=browser.findElement(By.id("login_login_username"));
        waitUntilElementVisiable(browser,userNameElement);
        userNameElement.sendKeys("learner");
        WebElement passwordElement=browser.findElement(By.id("login_login_password"));
        waitUntilElementVisiable(browser,passwordElement);
        passwordElement.sendKeys("MaharaDemo");
        WebElement submitButton=browser.findElement(By.id("login_submit"));
        waitUntilElementVisiable(browser,submitButton);
        submitButton.click();
        //verify login
        WebElement userMenu=browser.findElement(By.xpath("//button/span[@class='icon icon-chevron-down collapsed']"));
        waitUntilElementVisiable(browser,userMenu);
        boolean isLoginSuccess=userMenu.isDisplayed();
        // Click on "Engage" button ... xpath=//h2[contains(text(),'Engage')]
        WebElement engageButton = browser.findElement(By.xpath("//h2[contains(text(),'Engage')]"));
        waitUntilElementVisiable(browser,engageButton);
        engageButton.click();
        // Click on "Create Group" button ...xpath=//a[@class='btn btn-secondary creategroup']
        WebElement createGroupButton = browser.findElement(By.xpath("//a[@class='btn btn-secondary creategroup']"));
        waitUntilElementVisiable(browser,createGroupButton);
        createGroupButton.click();
        //Enter Groupname in the textfield ...id=editgroup_name
        WebElement groupNameElement=browser.findElement(By.id("editgroup_name"));
        waitUntilElementVisiable(browser,groupNameElement);
        groupNameElement.sendKeys("User Group");
        //Click on "Save Group" button id=editgroup_submit
        WebElement saveGroupeButton= browser.findElement(By.id("editgroup_submit"));
        waitUntilElementVisiable(browser,saveGroupeButton);
        saveGroupeButton.click();
        //Verify the group is created ...xpath=//div[contains(text(),'Group saved successfully')]
        WebElement groupCreatedText= browser.findElement(By.xpath("//div[contains(text(),'Group saved successfully')]"));
        waitUntilElementVisiable(browser,groupCreatedText);
        boolean isGroupCreated=groupCreatedText.isDisplayed();

        //verify the two boolean varible is true or not...
        if(isLoginSuccess&&isGroupCreated) {
            System.out.println("=========================");
            System.out.println("\u001B[34mMahara Automation Test passed.\u001B[0m");
            System.out.println("=========================");
        }
        else {
            System.out.println("=========================");
            System.out.println("\u001B[31mMahara Automation Test failed.\u001B[0m");
            System.out.println("=========================");
        }
        // close the browser and terminate the process
        browser.close();
        browser.quit();

    }

    // create the waitUtilElementVisible method
     public static void waitUntilElementVisiable(WebDriver driver, WebElement webElement)
     {
         WebDriverWait webDriverWait=new WebDriverWait(driver,30);
         webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
     }
}
