package com.seleniummaster.weeklyproject.week17project;

import com.seleniummaster.excel.ExcelUtility;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ahmet Bughra
 * @create 2019-12-19-5:08 AM
 * @email bughra1991@gmail.com
 */
public class Report {
    String pathOfProject = "src\\main\\java\\com\\seleniummaster\\weeklyproject\\week17project\\";

    public void reportHTML(boolean testResult){
        String filename = pathOfProject+"ResultOfWeek17Project.html";
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
        System.out.println("Report saved ad HTML file.\nHTML file path:"+filename);
        try {
            FileUtils.writeStringToFile(new File(filename),report.toString());
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public void reportExcel(boolean testReasult) {
            Map<String, String[]> excelData = new HashMap<String, String[]>();
            excelData.put("1", new String[]{"Test Name", "Test Result"});
            String isPassed = "Failed";
            if (testReasult){
                isPassed="Passed";
            }
            excelData.put("2", new String[]{"Add Newsletter",isPassed});
            String filename = pathOfProject+"ResultOfWeek17Project.xlsx";
            ExcelUtility excelUtility = new ExcelUtility();
            excelUtility.writeToExcelFileMultipleCells(filename, "sheet1", excelData);
            System.out.println("Report saved as an Excel file. \nExcel File path:  "+filename);
    }
    public void reportCSV(boolean tesResult) {
        StringBuilder mycsv = new StringBuilder();
        mycsv.append("TestName,TestResult").append("\n");
        if (tesResult){
            mycsv.append("AddNewsletter,Passed");
        } else
        {
            mycsv.append("AddNewsletter,Failed");
        }
        String fileName = pathOfProject + "ResultOfWeek17Project.csv";
        File csvFile = new File(fileName);
        try {
            FileUtils.writeStringToFile(csvFile, mycsv.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Report saved as CSV file. \nCSV File path:  "+fileName);
    }
}
