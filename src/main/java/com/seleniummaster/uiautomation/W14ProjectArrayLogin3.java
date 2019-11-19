package com.seleniummaster.uiautomation;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class W14ProjectArrayLogin3 {

    //PROJECT DESCRIPTION: This a homework from United Coder SDET Class
    //In this java class, I am testing MaharaDemo Site

    public static void main(String[] args) throws InterruptedException {

        //STEP 1 - Adding Chromedriver to system property
        System.setProperty("webdriver.chrome.driver", "c:\\webdriver\\chromedriver.exe");

        //STEP 2 - Adding ChromeOptions to Chromedriver
        //       - Allowing page to load fully
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        //STEP 3 - Defining a webdriver.
        //       - Choosing a Chromedriver as the webdriver
        //       - Adding chromeOptions to the webDriver
        WebDriver webDriver = new ChromeDriver(chromeOptions);

        //STEP 4 - Maximizing the browser window
        webDriver.manage().window().maximize();

        //STEP 5 - Opening the Mahara site
        webDriver.get("https://demo.mahara.org/");

        //STEP 6 - Setting a time limit on page load
        webDriver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

        List<String> roles= new ArrayList<String>();
        roles.add("Student");
        roles.add("Learner");
        roles.add("Admin");
        roles.add("Staff");
        roles.add("Sitestaff");


        for (int i=0; i<roles.size();i++) {
            //STEP 7 - Locating the username field
            //        - Typing "admin" into the username field
            WebElement userNameBox = webDriver.findElement(By.id("login_login_username"));
            String roleName = getUsername(roles.get(i));
            userNameBox.sendKeys(roleName);

            //STEP 8 - Locating the password field
            //       - Typing "MaharaDemo" into the password field
            WebElement passWordBox = webDriver.findElement(By.id("login_login_password"));
            String rolePass;
            rolePass= getPassword(roles.get(i));
            passWordBox.sendKeys(rolePass);

            //STEP 9 - Locating the Login Button
            //       - Hitting Enter
            WebElement loginButton = webDriver.findElement(By.id("login_submit"));
            loginButton.sendKeys(Keys.ENTER);

            //STEP 10 - Locating the Engage field
            //       - clicking
            WebElement engage = webDriver.findElement(By.xpath("//*[@id='home-info-engage']/div[1]"));
            engage.click();

            //STEP 11 - Locating the Create group link
            //       - clicking
            WebElement createGroup = webDriver.findElement(By.xpath("//*[@id='main-column-container']/div[2]/a"));
            createGroup.click();

            //STEP 12 - Locating the Group name text field
            //       - clicking
            WebElement groupName = webDriver.findElement(By.id("editgroup_name"));
            groupName.sendKeys("Hello Mahara");

            //STEP 13 - Switching to iframe
            //        - Locating the Group description text field
            //        - clicking it
            //        - Switching back to orginal html file
            webDriver.switchTo().frame(0);
            WebElement groupDescription = webDriver.findElement(By.xpath("//*[@id='tinymce']"));
            groupDescription.sendKeys("I am testing Mahara web application");
            webDriver.switchTo().defaultContent();

            //STEP 14 - Locating Friend invitations switch
            //        - clicking it to switch it to "yes"
            Thread.sleep(3000);
            webDriver.findElement(By.xpath("//*[@id='editgroup_invitefriends_container']/div[1]/div/label")).click();

            //STEP 15 - Locating the Create and edit dropdown list & Clicking it
            //        - Selecting the second option
            webDriver.findElement(By.xpath("//*[@id='editgroup_editroles']")).click();
            webDriver.findElement(By.xpath("//*[@id='editgroup_editroles']/option[2]")).click();


            //STEP 16 - Locating Participation report switch
            //        - clicking it to switch it to "yes"
            webDriver.findElement(By.xpath("//*[@id='editgroup_groupparticipationreports_container']/div[1]/div/label")).click();

            //STEP 17 - Locating the Start date calendar
            //        - Sending keys for the desired date
            webDriver.findElement(By.xpath("//*[@id='editgroup_editwindowstart']")).sendKeys("2019/11/17");

            //STEP 18 - Locating the End date calendar
            //        - Sending keys for the desired date
            webDriver.findElement(By.xpath("//*[@id='editgroup_editwindowend']")).sendKeys("2019/11/18");

            //STEP 19 - Locating the Group category dropdown list & clicking it
            //        - Selecting the second option
            webDriver.findElement(By.xpath("//*[@id='editgroup_category']")).click();
            webDriver.findElement(By.xpath("//*[@id='editgroup_category']/option[2]")).click();

            //STEP 20 - Locating the Shared page notifications dropdown list & clicking it
            //        - Selecting the second option
            webDriver.findElement(By.xpath("//*[@id='editgroup_viewnotify']")).click();
            webDriver.findElement(By.xpath("//*[@id='editgroup_viewnotify']/option[3]")).click();

            //STEP 21 - Locating the Comment notifications dropdown list & clicking it
            //        - Selecting the second option
            webDriver.findElement(By.xpath("//*[@id='editgroup_feedbacknotify']")).click();
            webDriver.findElement(By.xpath("//*[@id='editgroup_feedbacknotify']/option[4]")).click();

            //STEP 22 - Locating Save Group & Clicking it
            webDriver.findElement(By.xpath("//*[@id='editgroup_submit']")).click();

            //STEP 23 - Validating group is created
            WebElement createValidationMessage = webDriver.findElement(By.xpath("//*[@id='messages']/div/div"));
            if (createValidationMessage.isDisplayed()) {
                System.out.println(roles.get(i) + " successfully created the group!");
            }

            //STEP 23 - Deleting the created group
            webDriver.findElement(By.xpath("//*[@id='main-column-container']/div[3]/div/a[4]")).click();
            webDriver.findElement(By.xpath("//*[@id='deletegroup_submit']")).click();

            //STEP 24 - Validating group is deleted
            WebElement deleteValidationMessage = webDriver.findElement(By.xpath("//*[@id='messages']/div/div"));
            if (deleteValidationMessage.isDisplayed()) {
                System.out.println(roles.get(i) + " successfully deleted the group!");
            }

            //STEP 25 - Locating the Profile button
            //        - Clicking it
            WebElement profileButton = webDriver.findElement(By.cssSelector("body > header > div > div > div.nav-toggle-area > button.user-toggle.navbar-toggle")); //This is using Xpath
            profileButton.sendKeys(Keys.ENTER);

            //STEP 26 - Locating the Logout Button from the Profile dropdown menu
            //        - Waiting for animation to finish. For this we imported org.openqa.selenium.support.ui.ExpectedConditions;
            WebDriverWait wait = new WebDriverWait(webDriver, 4); //4 is arbitrary number here
            wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(By.xpath("//*[@id='logoutbutton']")))).click();

            //STEP 27 - Validating the test is passed
            WebElement logoutValidationMessage = webDriver.findElement(By.xpath("//*[@id='messages']/div/div"));
            if (logoutValidationMessage.isDisplayed()) {
                System.out.println(roles.get(i) + " successfully logged out, the Test has passed!");
            }

        }

        //STEP 28 - Closing the browser and quitting
        webDriver.close();
        webDriver.quit();



        
}
    //Creating HashMap to store all the various user type credentials
    public static HashMap<String, String> getCredentialsMap (){
        HashMap <String,String>userMap =new HashMap<String,String>();
        userMap.put("Student", "student:MaharaDemo");
        userMap.put("Learner", "learner:MaharaDemo");
        userMap.put("Admin", "admin:MaharaDemo");
        userMap.put("Staff", "staff:MaharaDemo");
        userMap.put("Sitestaff", "sitestaff:MaharaDemo");

        return userMap;
    }

    //Creating a method to get the username out of HashMap bases on the role argument
    public static String getUsername(String role){
        String credentials=  getCredentialsMap().get(role);
        return credentials.split(":")[0];
    }

    //Creating a method to get the password out of HashMap bases on the role argument
    public static String getPassword(String role){
        String credentials=  getCredentialsMap().get(role);
        return credentials.split(":")[1];
    }

}
