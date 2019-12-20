package com.seleniummaster.csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * @author Ahmet Bughra
 * @create 2019-12-20-2:52 AM
 * @email bughra1991@gmail.com
 */
public class CsvReadDemo {
    public static void main(String[] args) {
        //define a reader to read a csv file
        Reader inputFile = null;
        try {
            inputFile = new FileReader("logs\\test-result.csv");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
        Iterable<CSVRecord> records = null;
        try {
            records = CSVFormat.RFC4180.withHeader("TestID",
                    "TestModule",
                    "TestType",
                    "TestResult").parse(inputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (CSVRecord csvRecord : records) {
            String id = csvRecord.get("TestID");
            String testModule = csvRecord.get("TestModule");
            String testType = csvRecord.get("TestType");
            String testResult = csvRecord.get("TestResult");
            System.out.println(String.format("%s,%s,%s,%s", id, testModule, testType, testResult));
        }
    }
}
