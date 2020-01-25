package com.seleniummaster.UIautomationFramework.PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * @author Ahmet Bughra
 * @create 2020-01-14-10:13 PM
 * @email bughra1991@gmail.com
 */
public class TestRunner {
    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    CommonPage commonPage;
    DashboardPage dashboardPage;

    @BeforeClass
    public void setup() {
        int timeout = Integer.parseInt(AppConfigUtility.LoadConfigProperties("config.properties", "DocumentReadyTimeout"));
        String siteResetUrl = AppConfigUtility.LoadConfigProperties("config.properties", "SiteResetUrl");
        System.setProperty("webdriver.chrome.driver", "c:\\webdriver\\chromedriver.exe");
        //assign Chrome driver to the driver object
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(timeout, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        homePage.resetSite(siteResetUrl);
        loginPage = new LoginPage(driver);
        String username = AppConfigUtility.LoadConfigProperties("config.properties", "AdminUserName");
        String password = AppConfigUtility.LoadConfigProperties("config.properties", "AdminPassword");
        loginPage.loginToSite(username, password);
        dashboardPage = new DashboardPage(driver);
        boolean status = dashboardPage.isCommonUserInfoElementDisplayed();
        System.out.println("User Login Status: " + status);
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Test started ...");
    }

    @Test
    public void testAddClient() {
        boolean isClientAdded = false;
        dashboardPage = new DashboardPage(driver);
        try {
            isClientAdded = dashboardPage.addNewClient("Selenium" + System.currentTimeMillis(), "Master" + System.currentTimeMillis(), true, true, "01/01/1980", "12345678",
                    "MBF",
                    "0432121202", "testxxx@gmail.com", "1234 test lane", "test city,test country", 12345, "Dr." +
                            " Bill Soft", "Professor", "It is easy");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(isClientAdded);
    }

    @AfterTest
    public void afterTest() {
        System.out.println("Test completed ...");
    }

    @AfterClass
    public void tearDown() {
        dashboardPage = new DashboardPage(driver);
        dashboardPage.clickDashboardUserNavigationLink();
        commonPage = new CommonPage(driver);
        commonPage.clickSignoutLink();
        driver.close();
        driver.quit();
    }
}
