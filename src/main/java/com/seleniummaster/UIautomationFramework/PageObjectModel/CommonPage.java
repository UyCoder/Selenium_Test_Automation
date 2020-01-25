package com.seleniummaster.UIautomationFramework.PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Ahmet Bughra
 * @create 2020-01-14-10:01 PM
 * @email bughra1991@gmail.com
 */
public class CommonPage {
    WebDriver driver;
    @FindBy(id = "sign_out_link")
    WebElement commonPageSignoutLink;
    PageFunctions pageFunctions;
    int timeout = 30;

    public CommonPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        pageFunctions = new PageFunctions(driver);
    }

    public void clickSignoutLink() {
        pageFunctions.waitForElementVisible(commonPageSignoutLink, timeout);
        commonPageSignoutLink.click();
    }
}
