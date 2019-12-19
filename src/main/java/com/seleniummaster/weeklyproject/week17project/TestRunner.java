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

        // if test passed then call reportHTML method from report class
        if (isNewsletterAdded){
            System.out.println("Test case passed.");
            Report report = new Report();
            report.reportHTML(isNewsletterAdded);
        }else{
            System.out.println("Test case failed.");
        }
    }
}
