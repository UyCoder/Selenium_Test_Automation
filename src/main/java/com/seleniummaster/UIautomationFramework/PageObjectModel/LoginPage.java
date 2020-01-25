package com.seleniummaster.UIautomationFramework.PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Ahmet Bughra
 * @create 2020-01-14-9:54 PM
 * @email bughra1991@gmail.com
 */
public class LoginPage {
    WebDriver driver;
    @FindBy(id = "username")
    WebElement loginPageUsername;
    @FindBy(id = "password")
    WebElement loginPagePassword;
    @FindBy(xpath = "//div/input[@id=\"signin_button\"]")
    WebElement loginButton;
    @FindBy(xpath = "//div[@id=\"front_flash\"]/div/div[@id=\"flash_notice\"]")
    WebElement databaseResetTextNotice;
    int timeout = 30;
    PageFunctions pageFunctions;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
        pageFunctions = new PageFunctions(driver);
    }

    //set username in textbox
    public void setUsername(String usernameString) {
        pageFunctions.waitForElementVisible(loginPageUsername, timeout);
        loginPageUsername.sendKeys(usernameString);
    }

    //set password in textbox
    public void setUserpassword(String passwordString) {
        pageFunctions.waitForElementVisible(loginPagePassword, timeout);
        loginPagePassword.sendKeys(passwordString);
    }

    //click on the login button
    public void clickLoginButton() {
        pageFunctions.waitForElementVisible(loginButton, timeout);
        loginButton.click();
    }

    //get the title of the login page
    public String getLoginPageTitle() {
        return driver.getTitle();
    }

    public void loginToSite(String usernameString, String userPassword) {
        //fill username
        this.setUsername(usernameString);
        //fill userpassword
        this.setUserpassword(userPassword);
        //click on the login in button
        this.clickLoginButton();
    }
}
