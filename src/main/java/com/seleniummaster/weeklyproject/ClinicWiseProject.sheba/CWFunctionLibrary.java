package com.seleniummaster.sandbox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;

public class CWFunctionLibrary {
    private WebDriver driver;

    public void openBrowser(String webSite) {
        System.setProperty("webdriver.chrome.driver", "c:\\webdriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(webSite);
    }

    public void Login(com.seleniummaster.sandbox.CWLogin cwLogin) {
        WebElement userName = wait(driver.findElement(By.id("username")));
        userName.sendKeys(cwLogin.getUserName());
        WebElement password = wait(driver.findElement(By.id("password")));
        password.sendKeys(cwLogin.getPassWord());
        WebElement signIn = wait(driver.findElement(By.name("commit")));
        signIn.click();
    }

    public boolean NewClient(com.seleniummaster.sandbox.CWAddNewClient cwAddNewClient) {
        WebElement client = wait(driver.findElement(By.xpath("//span[text()=' Clients ']")));
        client.click();
        WebElement newClient = wait(driver.findElement(By.id("menu_new_client_link")));
        newClient.click();
        WebElement firstName = wait(driver.findElement(By.name("client[first_name]")));
        firstName.sendKeys(cwAddNewClient.getFirstName());
        WebElement lastName = wait(driver.findElement(By.name("client[last_name]")));
        lastName.sendKeys(cwAddNewClient.getLastName());
        WebElement gender=wait(driver.findElement(By.id("client_gender_male")));
        gender.click();
        //Select gender=new Select(driver.findElement(By.xpath("//span[@class='lbl radio-label']")));
        //gender.selectByVisibleText("Male||Female");
        //WebElement maleRadioButton = wait(driver.findElement(By.id("client_gender_male")));
        //WebElement femaleRadioButton = wait(driver.findElement(By.id("client_gender_female")));
        //if (maleRadioButton.isSelected()) {
           // maleRadioButton.click();
        //} else {
         //   femaleRadioButton.click();
        //}
        WebElement VIP = wait(driver.findElement(By.id("client_is_vip")));
        VIP.click();
        WebElement DOB=wait(driver.findElement(By.xpath("//input[@id=\"client_birth_date\"]")));
        DOB.sendKeys(cwAddNewClient.getDOB());
        WebElement medicareNumber=wait(driver.findElement(By.id("client_medicare_number")));
        medicareNumber.sendKeys(String.valueOf(cwAddNewClient.getMedicareNumber()));
        Select privateHealthFund=new Select (driver.findElement(By.id("client_private_health_fund_id")));
        privateHealthFund.selectByIndex(1);
        WebElement phoneNumber=wait(driver.findElement(By.id("client_mobile")));
        phoneNumber.sendKeys(String.valueOf(cwAddNewClient.getPhoneNumber()));
        WebElement email=wait(driver.findElement(By.id("client_email")));
        email.sendKeys(cwAddNewClient.getEmail());
        WebElement address=wait(driver.findElement(By.id("client_address_line_1")));
        address.sendKeys(cwAddNewClient.getAddress());
        WebElement suburb=wait(driver.findElement(By.id("client_suburb")));
        suburb.sendKeys(cwAddNewClient.getSuburb());
        WebElement postCode=wait(driver.findElement(By.id("client_post_code")));
        postCode.sendKeys(String.valueOf(cwAddNewClient.getPostCode()));
        WebElement occupation=wait(driver.findElement(By.id("client_occupation")));
        occupation.sendKeys(cwAddNewClient.getOccupation());
        WebElement notes=wait(driver.findElement(By.id("client_notes")));
        notes.sendKeys(cwAddNewClient.getNotes());
        WebElement create=wait(driver.findElement(By.id("create_client_btn")));
        create.click();

        return true;
    }

    public WebElement wait(WebElement webElement) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        return webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
    }
}
