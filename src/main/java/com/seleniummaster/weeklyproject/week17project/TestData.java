package com.seleniummaster.weeklyproject.week17project;

import com.seleniummaster.configutility.ApplicationConfig;

/**
 * @author Ahmet Bughra
 * @create 2019-12-19-3:21 AM
 * @email bughra1991@gmail.com
 */
public class TestData {
    // get the values from config-week17project.properties file
    final static String url = ApplicationConfig.readConfigProperties("config-week17project.properties", "url");
    final static String username = ApplicationConfig.readConfigProperties("config-week17project.properties", "username");
    final static String password = ApplicationConfig.readConfigProperties("config-week17project.properties", "password");
    final static String newsletterSubject = ApplicationConfig.readConfigProperties("config-week17project.properties", "NewsletterSubject");
    final static String sendersName = ApplicationConfig.readConfigProperties("config-week17project.properties", "Sender'sName");
    final static String sendersEmail = ApplicationConfig.readConfigProperties("config-week17project.properties", "Sender'sEmailAddress");
    final static String template = ApplicationConfig.readConfigProperties("config-week17project.properties", "Template");
    final static String textContent = ApplicationConfig.readConfigProperties("config-week17project.properties", "TextContent");
    final static String sleep = ApplicationConfig.readConfigProperties("config-week17project.properties", "sleep");
    final static String timeout = ApplicationConfig.readConfigProperties("config-week17project.properties", "timeout");

    // get the values from week17ProjectTestCase.xlsx file
//    ExcelUtility excelUtility = new ExcelUtility();
//    final static String pathOfExcelFile = "src\\main\\java\\com\\seleniummaster\\weeklyproject\\week17project\\week17ProjectTestCase.xlsx";
//    final static String urlFromExcel= excelUtility.readExcelCell(pathOfExcelFile, "Sheet1", 1, 5);
//    final static String usernameFromExcel = excelUtility.readExcelCell(pathOfExcelFile, "Sheet1", 2, 5);
//    final static String passwordFromExcel =excelUtility.readExcelCell(pathOfExcelFile, "Sheet1", 3, 5);
//    final static String newsletterSubjectFromExcel = excelUtility.readExcelCell(pathOfExcelFile, "Sheet1", 7, 5);
//    final static String sendersNameFromExcel = excelUtility.readExcelCell(pathOfExcelFile, "Sheet1", 8, 5);
//    final static String sendersEmailFromExcel = excelUtility.readExcelCell(pathOfExcelFile, "Sheet1", 9, 5);
//    final static String templateFromExcel = excelUtility.readExcelCell(pathOfExcelFile, "Sheet1", 11, 5);
//    final static String textContentFromExcel = excelUtility.readExcelCell(pathOfExcelFile, "Sheet1", 13, 5);
//    final static String sleepFromExcel = excelUtility.readExcelCell(pathOfExcelFile, "Sheet1", 15, 5);
//    final static String timeoutFromExcel =excelUtility.readExcelCell(pathOfExcelFile, "Sheet1", 1, 5);
}
