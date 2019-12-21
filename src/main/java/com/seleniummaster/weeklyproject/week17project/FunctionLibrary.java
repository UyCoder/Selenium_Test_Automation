package com.seleniummaster.weeklyproject.week17project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * @author Ahmet Bughra
 * @create 2019-12-19-3:32 AM
 * @email bughra1991@gmail.com
 */
public class FunctionLibrary {
    private WebDriver driver;
    TestData testData= new TestData();
    //open browser function and navigate to the testing site
    public void openBrowser(String url) {
        System.setProperty("webdriver.chrome.driver", "c:\\webdriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
//        int timeout = Integer.parseInt(ApplicationConfig.readConfigProperties("config-week17project.properties", "timeout"));
        int timeout = Integer.parseInt(testData.timeout);
        driver.manage().timeouts().pageLoadTimeout(timeout, TimeUnit.SECONDS);
        driver.get(url);
    }
    // login method contains parameters of username and password
    public void Login(String username, String password) {
        WebElement usernameTextBox = driver.findElement(By.name("username"));
        usernameTextBox.sendKeys(username);
        WebElement passwordTextBox = driver.findElement(By.id("password"));
        passwordTextBox.sendKeys(password);
        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();
        WebElement userInfoTab = driver.findElement(By.xpath("//span[@class='user_info']"));
        if (userInfoTab.isDisplayed()) {
            System.out.println("User logged in seccessfully.");
        } else {
            System.out.println("Login failed");
        }
    }
    // method for adding newsletter. it has 5 parameters that will used during test
    public boolean addNewsletter(String newsletterSubject,
                                 String sendersName,
                                 String emailAddress,
                                 String template,
                                 String textContent) {
        sleep(Integer.parseInt(testData.sleep));
        boolean testResult = false;
        WebElement newsletterbutton = wait(driver.findElement(By.xpath("//a[contains(text(),'Newsletters')]")));
        newsletterbutton.click();
        sleep(5);
        WebElement createNewsletterButton = wait(driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[3]/div[1]/div[2]")));
        // xpath = //a[contains(text(),'Create Newsletter')]
        // css = div:nth-child(2) div:nth-child(3) div:nth-child(1) div.tab:nth-child(2) > a:nth-child(1)
        // linkText = Create Newsletter
        // PlinkText = Create Newslett
        createNewsletterButton.click();
        WebElement newslettersubject = wait(driver.findElement(By.id("email_subject")));
        newslettersubject.sendKeys(newsletterSubject);
        WebElement senderName = wait(driver.findElement(By.id("sender_name")));
        senderName.sendKeys(sendersName);
        WebElement senderemail = wait(driver.findElement(By.id("sender_email")));
        senderemail.sendKeys(emailAddress);
        WebElement sedToDouble = wait(driver.findElement(By.xpath("//img[@class='checkbox']")));
        sedToDouble.click();
        WebElement templatedrplst = wait(driver.findElement(By.id("template_id")));
        Select conditionSelect= new Select(templatedrplst);
        conditionSelect.selectByVisibleText(template);
//        WebElement templatedropdown = wait(driver.findElement(By.xpath("//select[@id='template_id']")));
//        templatedropdown.getAttribute(template);
        WebElement plainText = wait(driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[3]/div[1]/div[3]/a[1]")));
        plainText.click();
        WebElement textArea = wait(driver.findElement(By.id("content_text")));
        textArea.sendKeys(textContent);
        WebElement saveButton = wait(driver.findElement(By.xpath("//div[@id='content']//input[3]")));
        saveButton.click();
        WebElement saved = wait(driver.findElement(By.xpath("//div[@class='success']")));
        if (saved.isDisplayed()) {
            testResult=true;
        }
        if (testResult)
        {
            System.out.println("\u001B[34m==================\nTest passed.\t✓\n==================");
        } else
        {
            System.out.println("\u001B[31m==================\nTest failed.\t✖\n==================");
        }
        return testResult;
    }
    // logout method
    public boolean Logout() {
        WebElement logoutIcon = wait(driver.findElement(By.cssSelector("i.fa.fa-sign-out")));
        logoutIcon.click();
//        WebElement login = wait(driver.findElement(By.xpath("//input[@id='login']")));
        WebElement login = wait(driver.findElement(By.id("username")));
        if (login.isDisplayed()){
            System.out.println("Logout successfully.");
            return true;
        }
        else {
            System.out.println("Logout Failed.");
            return false;
        }
    }

    // close the browser
    public void closeTheBrowser() {
        driver.close();
        driver.quit();
    }
    // create the waitUtilElementVisible method
    public WebElement wait(WebElement webElement) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Integer.parseInt(testData.timeout));
        return webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
    }
    // create the sleep method
    public void sleep(int slp)
    {
        try {
            Thread.sleep(slp);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
