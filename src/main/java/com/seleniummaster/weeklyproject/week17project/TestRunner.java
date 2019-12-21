package com.seleniummaster.weeklyproject.week17project;

/**
 * @author Ahmet Bughra
 * @create 2019-12-19-3:29 AM
 * @email bughra1991@gmail.com
 */
public class TestRunner {
    public static void main(String[] args) {
        // Create the testData object and week17Project object
        TestData testData = new TestData();
        FunctionLibrary week17project= new FunctionLibrary();
        // call the project methods
        week17project.openBrowser(testData.url);
        week17project.Login(testData.username, testData.password);
        boolean isNewsletterAdded=week17project.addNewsletter(
                testData.newsletterSubject,
                testData.sendersName,
                testData.sendersEmail,
                testData.template,
                testData.textContent);
        week17project.Logout();
        week17project.closeTheBrowser();

        //*************** Generate Report *************
        //generate report as a html file
        Report report = new Report();
        report.reportHTML(isNewsletterAdded);
        // generate report as an excel file
        report.reportExcel(isNewsletterAdded);
        // generate report as CSV file
        report.reportCSV(isNewsletterAdded);
    }
}
