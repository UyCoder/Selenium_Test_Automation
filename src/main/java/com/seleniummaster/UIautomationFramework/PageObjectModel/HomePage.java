package com.seleniummaster.UIautomationFramework.PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Ahmet Bughra
 * @create 2020-01-14-10:02 PM
 * @email bughra1991@gmail.com
 */
public class HomePage {
    WebDriver driver;
    @FindBy(xpath = "//div[@id=\"front_flash\"]/div/div[@id=\"flash_notice\"]")
    WebElement databaseResetTextNotice;
    PageFunctions pageFunctions;
    int timeOut = 30;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
        pageFunctions = new PageFunctions(driver);
    }

    //site  reset
    public void resetSite(String resetUrl) {
        driver.navigate().to(resetUrl);
    }

    public String getSiteResetConfirmation() {
        pageFunctions.waitForElementVisible(databaseResetTextNotice, timeOut);
        String confirmationString = databaseResetTextNotice.getText();
        return confirmationString;
    }
}
