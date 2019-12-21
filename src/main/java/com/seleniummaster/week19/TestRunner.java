package com.seleniummaster.week19;

import com.seleniummaster.configutility.ApplicationConfig;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class TestRunner {
    final static String username= ApplicationConfig.readConfigProperties("config.properties","cubecartUser");
    final static String password=ApplicationConfig.readConfigProperties("config.properties","cubecartPassword");
    final static String siteUrl=ApplicationConfig.readConfigProperties("config.properties","cubecartUrl");

    public static void main(String[] args) {
        HtmlReportBuilder htmlReportBuilder=new HtmlReportBuilder();
        htmlReportBuilder.setHtmlHeader();
        htmlReportBuilder.setTableHeader();
        CsvReportBuilder csvReportBuilder=new CsvReportBuilder();
        csvReportBuilder.addHeaderColumn();
        String currentUser=System.getProperty("user.name");
        String currentTime=String.valueOf(new Date());
        TestUser testUser=new TestUser(username,password);
        PromotionalCode promotionalCode=new PromotionalCode(String.valueOf(System.currentTimeMillis()),
                "Test Promotional Code",
                DiscountType.Fixed_Price_Discount,"10",
                "2019-12-31",true);
        TestLibrary testLibrary=new TestLibrary();
        testLibrary.openBrowser(siteUrl);
       boolean loginResult= testLibrary.login(testUser);
       htmlReportBuilder.addTestReport("Login","Login",
               testUser.getUserName(),loginResult,currentTime,currentUser);
       //add csv report
        csvReportBuilder.addTestResult("Login","Login",loginResult,currentTime,currentUser);
       boolean promotionalCodeTestResult= testLibrary.addPromotionalCode(promotionalCode);
       htmlReportBuilder.addTestReport("Add Promotional Code","Inventory",
               promotionalCode.toString(),promotionalCodeTestResult,currentTime,currentUser);
        csvReportBuilder.addTestResult("Add Promotional Code","Inventory",
                promotionalCodeTestResult,currentTime,currentUser);
        boolean logoutTestResult=testLibrary.logout();
        htmlReportBuilder.addTestReport("Logout","Login","",
                logoutTestResult,currentTime,currentUser);
        csvReportBuilder.addTestResult("Logout","Login",
                logoutTestResult,currentTime,currentUser);

        htmlReportBuilder.endTestReport(); //end test report
        try {
            FileUtils.writeStringToFile(new File("logs\\promocode.html"),
                    htmlReportBuilder.getFinalReport().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //write csv report
        try {
            FileUtils.writeStringToFile(new File("logs\\promocode.csv"),
                   csvReportBuilder.getReport());
        } catch (IOException e) {
            e.printStackTrace();
        }
        testLibrary.closeBrowser();
    }
}
