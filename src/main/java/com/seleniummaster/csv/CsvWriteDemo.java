package com.seleniummaster.csv;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @author Ahmet Bughra
 * @create 2019-12-20-3:13 AM
 * @email bughra1991@gmail.com
 */
public class CsvWriteDemo {
    public static void main(String[] args) {
        StringBuilder mycsv = new StringBuilder();
        mycsv.append("TestID,TestModule,TestType,TestResult").append("\n");
        mycsv.append("1,Login,Reression,Pass").append("\n");
        mycsv.append("2,Logout,Regression,Fail");
        File csvFile = new File("logs\\testinfo.csv");
        try {
            FileUtils.writeStringToFile(csvFile, mycsv.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
