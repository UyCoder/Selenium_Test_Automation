package com.seleniummaster.weeklyproject.week17project;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

/**
 * @author Ahmet Bughra
 * @create 2019-12-19-5:08 AM
 * @email bughra1991@gmail.com
 */
public class Report {
    public void reportHTML(boolean testResult){
        TestData testData = new TestData();
        StringBuilder report= new StringBuilder();
        report.append("<html><head><title>Test Result</title></head><body>");
        report.append("<table border=1>");
        report.append("<tr><td>Test Name</td><td>Test Result</td></tr>");

        if (testResult) {
            report.append("<tr bgcolor=#5cd65c ><td>Add Newsletter</td> <td>Passed</td><tr>");
        }else {
            report.append("<tr><td>Add Newsletter</td> <td>Failed</td><tr>");
        }
        report.append("</table></body></html>");
        System.out.println("Html report file is saved.");
        try {
            FileUtils.writeStringToFile(new File("logs\\week17ProjectResult.html"),report.toString());
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
