package com.seleniummaster.weeklyproject.week15project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MaharaFunctionLibrary {

    WebDriver browser ;
    public void OpenBrowser(String url) { // url =   "http://mahara.unitedcoderschool.com/mahara/"
        System.setProperty("webdriver.chrome.driver", "c:\\webdriver\\chromedriver.exe");
        browser = new ChromeDriver();
        // maximize browser window
        browser.manage().window().maximize();
        // set maximun page time out
        browser.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        // navigate to the testing site
        browser.get(url);
    }

    public boolean Login(String userName, String password) {

        WebElement userNameElement = browser.findElement(By.id("login_login_username"));
        waitUntilElementVisiable(browser, userNameElement);
        userNameElement.sendKeys(userName);
        /* Step 3 */
        // Enter Password in the password field
        WebElement passwordElement = browser.findElement(By.id("login_login_password"));
        waitUntilElementVisiable(browser, passwordElement);
        passwordElement.sendKeys(password);
        /* Step 4 */
        // Click on the sign-in button
        WebElement submitButton = browser.findElement(By.id("login_submit"));
        waitUntilElementVisiable(browser, submitButton);
        submitButton.click();
        /* Step 5 */
        // Verify login
        WebElement userMenu = browser.findElement(By.xpath("//button/span[@class='icon icon-chevron-down collapsed']"));
        waitUntilElementVisiable(browser, userMenu);
        boolean isLoginSuccess = userMenu.isDisplayed();
        if (isLoginSuccess) {
            System.out.println("User logged in successfully. ");
        }
        System.out.println("=================================");
        return isLoginSuccess;
    }

    public boolean createANewPlan(String titleOfPlan, String descriptionOfPlan, String tag) {
        // Click on main menu
        WebElement mainMenu = browser.findElement(By.xpath("//button[@class='main-nav-toggle navbar-toggle collapsed']"));
        waitUntilElementVisiable(browser, mainMenu);
        mainMenu.click();
        /* Step 7 */
        //Click on "Create"
        WebElement create = browser.findElement(By.xpath("//a[@class='create menu-dropdown-toggle']"));
        waitUntilElementVisiable(browser, create);
        create.click();
        /* Step 8 */
        //Click on "Plans"
        WebElement plans = browser.findElement(By.xpath("//a[contains(text(),'Plans')]"));
        waitUntilElementVisiable(browser, plans);
        plans.click();
        /* Step 9 */
        //Click the "New plan" button on the Plans overview page.
        WebElement newPlan = browser.findElement(By.xpath("//a[@class='btn btn-secondary']"));
        waitUntilElementVisiable(browser, newPlan);
        newPlan.click();
        /* Step 10 */
        //Enter the title of the new plan on Title field     //input[@id='addplan_title']
        WebElement titleOfNewPlan = browser.findElement(By.id("addplan_title"));
        waitUntilElementVisiable(browser, titleOfNewPlan);
        titleOfNewPlan.sendKeys(titleOfPlan);
        /* Step 11 */
        //Enter the description of the new plan on the Description text field.    //textarea[@id='addplan_description']
        WebElement descriptionOfNewPlan = browser.findElement(By.id("addplan_description"));
        waitUntilElementVisiable(browser, descriptionOfNewPlan);
        descriptionOfNewPlan.sendKeys(descriptionOfPlan);
        /* Step 12 */
        //Select "Yes" on the drop-down list from "Template"
        WebElement templateDropDown = browser.findElement(By.xpath("//div[@id='addplan_template_container']//span[@class='state-label off'][contains(text(),'No')]"));
        waitUntilElementVisiable(browser, templateDropDown);
        templateDropDown.click();
        /* Step 13 */
        //Select "Yes" on the drop-down list from "Assignment tasks"
        // auto selected "Yes"

        /* Step 14 */
        //Enter tags on tags textfield
        WebElement tags = browser.findElement(By.xpath("//input[@placeholder='Type in a search term']"));
        waitUntilElementVisiable(browser, tags);
        tags.sendKeys(tag);
        /* Step 15 */
        //Click on the "Save Plan" button    //button[@id='addplan_submit']
        WebElement savePlan = browser.findElement(By.id("addplan_submit"));
        waitUntilElementVisiable(browser, savePlan);
        savePlan.click();
        /* Step 16 */
        //Verify The Plan saved successfully
        WebElement planSaved = browser.findElement(By.xpath("//div[contains(text(),'Plan saved successfully.')]"));
        waitUntilElementVisiable(browser, planSaved);
        boolean isPlanSaved = planSaved.isDisplayed();
        if (isPlanSaved) {
            System.out.println("1. Test case 1 passed.\t✓ ");
        }
        return isPlanSaved;
    }

    public boolean addTaskToAPlan(String titleOfTask, String taskDescription, String tag) {
        //Click on "Main menu"
        WebElement mainMenu2 = browser.findElement(By.xpath("//button[@class='main-nav-toggle navbar-toggle collapsed']"));
        waitUntilElementVisiable(browser, mainMenu2);
        mainMenu2.click();

        //Click on  "Create"
        WebElement plans2_ = browser.findElement(By.xpath("//a[contains(text(),'Plans')]"));
        waitUntilElementVisiable(browser, plans2_);
        if (!plans2_.isDisplayed()) {
            WebElement create2 = browser.findElement(By.xpath("//a[@class='create menu-dropdown-toggle']"));
            waitUntilElementVisiable(browser, create2);
            create2.click();
        }

        //Click on  "Plans"
        WebElement plans2 = browser.findElement(By.xpath("//a[contains(text(),'Plans')]"));
        waitUntilElementVisiable(browser, plans2);
        plans2.click();
        /* Step 20 */
        //Click on the "Manage Task" button
        WebElement manageTask = browser.findElement(By.xpath("//div[@class='container main-content']//div[2]//div[1]//div[1]//a[2]"));
        waitUntilElementVisiable(browser, manageTask);
        manageTask.click();
        /* Step 21 */
        //Click on the "New task"
        WebElement newTask = browser.findElement(By.xpath("//a[@class='btn btn-secondary settings']"));
        waitUntilElementVisiable(browser, newTask);
        newTask.click();
        /* Step 22 */
        //Enter the title for the task on the title text field    //input[@id='edittask_title']
        WebElement taskTitle = browser.findElement(By.id("edittask_title"));
        waitUntilElementVisiable(browser, taskTitle);
        taskTitle.sendKeys(titleOfTask);
        /* Step 23 */
        //Enter the description of the new task on the Description text field.   //textarea[@id='edittask_description']
        WebElement descriptionsOfTask = browser.findElement(By.id("edittask_description"));
        waitUntilElementVisiable(browser, descriptionsOfTask);
        descriptionsOfTask.sendKeys(taskDescription);
        /* Step 24 */
        //Enter tags on tags textfield
        WebElement tagsoftask = browser.findElement(By.xpath("//input[@placeholder='Type in a search term']"));
        waitUntilElementVisiable(browser, tagsoftask);
        tagsoftask.sendKeys(tag);
        /* Step 25 */
        //Click on the "Save task" button     //button[@id='edittask_submit']
        WebElement saveTask = browser.findElement(By.id("edittask_submit"));
        waitUntilElementVisiable(browser, saveTask);
        saveTask.click();
        /* Step 26 */
        //Verify the task saved successfully
        WebElement taskSaved = browser.findElement(By.xpath("//div[contains(text(),'Task saved successfully.')]"));
        waitUntilElementVisiable(browser, taskSaved);
        boolean isTaskSaved = taskSaved.isDisplayed();
        if (isTaskSaved) {
            System.out.println("2. Test Case 2 passed.\t✓ ");
        }
        return isTaskSaved;
    }

    public boolean editingTask(String editingDescription) {
        /* Step 27 */
        //Click on  "Main menu"
        WebElement mainmenu3 = browser.findElement(By.xpath("//button[@class='main-nav-toggle navbar-toggle collapsed']"));
        waitUntilElementVisiable(browser, mainmenu3);
        mainmenu3.click();
        /* Step 28 */
        //Click on "Create"
        WebElement plans3_ = browser.findElement(By.xpath("//a[contains(text(),'Plans')]"));
        waitUntilElementVisiable(browser, plans3_);
        if (!plans3_.isDisplayed()) {
            WebElement create3 = browser.findElement(By.xpath("//a[@class='create menu-dropdown-toggle']"));
            waitUntilElementVisiable(browser, create3);
            create3.click();
        }
        /* Step 29 */
        //Click on "Plans"
        WebElement plans3 = browser.findElement(By.xpath("//a[contains(text(),'Plans')]"));
        waitUntilElementVisiable(browser, plans3);
        plans3.click();
        /* Step 30 */
        //Click on the "Manage Task" button
        WebElement manageTask3 = browser.findElement(By.xpath("//div[@class='container main-content']//div[2]//div[1]//div[1]//a[2]"));
        waitUntilElementVisiable(browser, manageTask3);
        manageTask3.click();
        /* Step 31 */
        //Click on the "Edit"
        WebElement edit3 = browser.findElement(By.xpath("//td[@class='planscontrols text-right']//a[1]"));
        waitUntilElementVisiable(browser, edit3);
        edit3.click();
        /* Step 32 */
        //Enter the description of the new task on the Description text field.
        WebElement descriptionOfNewTask = browser.findElement(By.id("edittask_description"));
        waitUntilElementVisiable(browser, descriptionOfNewTask);
        descriptionOfNewTask.sendKeys(editingDescription);
        /* Step 33 */
        //Click on the "Sava task" button
        WebElement saveTask3 = browser.findElement(By.id("edittask_submit"));
        waitUntilElementVisiable(browser, saveTask3);
        saveTask3.click();
        /* Step 34 */
        //Verify the task saved successfully.
        WebElement taskSaved3 = browser.findElement(By.xpath("//div[contains(text(),'Task saved successfully.')]"));
        waitUntilElementVisiable(browser, taskSaved3);
        boolean isTaskSaved3 = taskSaved3.isDisplayed();
        if (isTaskSaved3) {
            System.out.println("3. Test Case 3 passed.\t✓ ");
        }
        return isTaskSaved3;
    }

    public boolean viewAllPlans() {
        WebElement mainMenu4 = browser.findElement(By.xpath("//button[@class='main-nav-toggle navbar-toggle collapsed']"));
        waitUntilElementVisiable(browser, mainMenu4);
        mainMenu4.click();
        /* Step 36 */
        //Click on "Create"
        WebElement plans4_ = browser.findElement(By.xpath("//a[contains(text(),'Plans')]"));
        waitUntilElementVisiable(browser, plans4_);
        if (!plans4_.isDisplayed()) {
            WebElement create4 = browser.findElement(By.xpath("//a[@class='create menu-dropdown-toggle']"));
            waitUntilElementVisiable(browser, create4);
            create4.click();
        }
        /* Step 37 */
        //Click on "Plans"
        WebElement plans4 = browser.findElement(By.xpath("//a[contains(text(),'Plans')]"));
        waitUntilElementVisiable(browser, plans4);
        plans4.click();
        /* Step 38 */
        //Click on a plan.
        WebElement plan4 = browser.findElement(By.xpath("//div[@class='list-group list-group-lite']//div[1]//div[1]//h3[1]//a[1]"));
        waitUntilElementVisiable(browser, plan4);
        plan4.click();
        /* Step 39 */
        //Verify the name of task.
        WebElement namesOfTasks = browser.findElement(By.xpath("//span[@class='section-heading']"));
        waitUntilElementVisiable(browser, namesOfTasks);
        boolean istasksDisplay = namesOfTasks.isDisplayed();
        if (istasksDisplay) {
            System.out.println("4. Test Case 4 passed.\t✓ ");
        }
        return istasksDisplay;
    }

    public boolean logout() {
        //Click on "Main menu"
        WebElement mainMenuLogout = browser.findElement(By.xpath("//span[@class='icon icon-chevron-down collapsed']"));
        waitUntilElementVisiable(browser, mainMenuLogout);
        mainMenuLogout.click();
        /* Step 41 */
        //Click on "Logout"     //a[@id='logoutbutton']
        WebElement logout = browser.findElement(By.id("logoutbutton"));
        waitUntilElementVisiable(browser, logout);
        logout.click();
        /* Step 42 */
        //Verify user logged out successfully
        WebElement loggedOut = browser.findElement(By.xpath("//div[contains(text(),'You have been logged out successfully')]"));
        waitUntilElementVisiable(browser, loggedOut);
        boolean isLoggedOut = loggedOut.isDisplayed();
        if (isLoggedOut) {
            System.out.println("================================");
            System.out.println("User logged out successfully.");
        }
        return isLoggedOut;
    }
    public void exitChromeDriver(){
        // close the browser and terminate the process
        browser.close();
        browser.quit();
    }


    public static void waitUntilElementVisiable(WebDriver driver, WebElement webElement) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
    }
}
