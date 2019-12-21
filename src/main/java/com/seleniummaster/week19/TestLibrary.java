package com.seleniummaster.week19;
import com.seleniummaster.configutility.ApplicationConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TestLibrary {
    private WebDriver driver;
    //open browser function and navigate to the testing site
    public void openBrowser(String siteName) {
        System.setProperty("webdriver.chrome.driver", "c:\\webdriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        int timeout= Integer.parseInt(ApplicationConfig.readConfigProperties("config.properties","timeout"));
        driver.manage().timeouts().pageLoadTimeout(timeout, TimeUnit.SECONDS);
        driver.get(siteName);
    }
    public boolean login(TestUser testUser) {
        WebElement usernameTextBox = driver.findElement(By.name("username"));
        usernameTextBox.sendKeys(testUser.getUserName());
        WebElement passwordTextBox = driver.findElement(By.id("password"));
        passwordTextBox.sendKeys(testUser.getUserPassword());
        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();
        sleep(5);
        WebElement logoutIcon = wait(driver.findElement(By.cssSelector("i.fa.fa-sign-out")));
        if(logoutIcon.isDisplayed())
            return true;
        else
            return false;
    }

    public boolean addPromotionalCode(PromotionalCode promotionalCode)
    {
        //promotional code link
        sleep(5);
        WebElement promotionalCodeLink=wait(driver.findElement(By.linkText("Promotional Codes")));
        promotionalCodeLink.click();
        //create promotional code tab
        sleep(5);
        WebElement createPromotionalCodeTab=wait(driver.findElement(By.linkText("Create Promotional Code")));
        createPromotionalCodeTab.click();
        //promotional code
        WebElement codeTextField=wait(driver.findElement(By.id("form-code")));
        codeTextField.sendKeys(promotionalCode.getCode());
        //promotional description
        WebElement descriptionTextField=wait(driver.findElement(By.id("form-description")));
        descriptionTextField.sendKeys(promotionalCode.getDescription());
        //promotional discount type
        WebElement discountTypeDropdown=wait(driver.findElement(By.name("discount_type")));
        Select discountTypeSelect=new Select(discountTypeDropdown);
        discountTypeSelect.selectByVisibleText(promotionalCode.getDiscountType().getOption());
        //discount value
        WebElement discountValueTextField=wait(driver.findElement(By.id("form-value")));
        discountValueTextField.sendKeys(promotionalCode.getDiscountValue());
        //expire
        WebElement expireTextField=wait(driver.findElement(By.id("form-expires")));
        expireTextField.sendKeys(promotionalCode.getExpires()+ Keys.TAB);
        sleep(2);
        //applies discount to shipping cost checkbox
        WebElement discountAppliesToShippingCostCheckbox=wait
                (driver.findElement(By.cssSelector("div>span>img[class='checkbox']")));
        discountAppliesToShippingCostCheckbox.click();
        //save button
        WebElement saveButton=wait(driver.findElement(By.cssSelector("input[value='Save']")));
        saveButton.click();
        //verify confirmation
        WebElement confirmationMessage=wait(driver.findElement(By.xpath("//*[@id=\"gui_message\"]")));
        String confirmationText=confirmationMessage.getText();
        if(confirmationText.equalsIgnoreCase("Promotional code added."))
            return true;
        else
            return false;
    }

    public boolean logout() {
        sleep(2);
        WebElement logoutIcon = wait(driver.findElement(By.cssSelector("i.fa.fa-sign-out")));
        logoutIcon.click();
        sleep(5);
        WebElement login = wait(driver.findElement(By.id("login")));
        if (login.isDisplayed())
            return true;
        else return false;
    }
    public void closeBrowser()
    {
        driver.close();
        driver.quit();
    }
    public WebElement wait(WebElement webElement) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        return webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void sleep(int seconds)
    {
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
