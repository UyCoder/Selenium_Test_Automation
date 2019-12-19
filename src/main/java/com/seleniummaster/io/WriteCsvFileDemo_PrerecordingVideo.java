package com.seleniummaster.io;

import com.csvreader.CsvWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * @author Ahmet Bughra
 * @create 2019-12-18-4:48 PM
 * @email bughra1991@gmail.com
 */
public class WriteCsvFileDemo_PrerecordingVideo {
    public static void main(String[] args) {
                   //define output file name
                   String csvOutputFile = "docs\\writetest.csv";
                   //check if file exist
                   boolean isFileExist = new File(csvOutputFile).exists();
                   try {
                           //create a FileWriter constructor to open a file in appending mode
                           CsvWriter testcases = new CsvWriter(new FileWriter(csvOutputFile, true), ',');
                           //write header column if the file did not already exist
                           if(!isFileExist)
                               {
                                   testcases.write("TestId");
                                   testcases.write("TestName");
                                   testcases.write("TestModule");
                                   testcases.write("TestType");
                                   testcases.write("TestSteps");
                                   testcases.write("Action");
                                   testcases.write("TestResult");
                                   testcases.write("Note");
                                   //end the record
                                   testcases.endRecord();
                               }
                           Random r=new Random();
                           int testCaseID=r.nextInt(10000); //generate random numbers from 1 to 10000
                           //add record to the file
                           testcases.write(String.valueOf(testCaseID));
                           testcases.write("Login");
                           testcases.write("Dashboard");
                           testcases.write("Smoke");
                           testcases.write("1");
                           testcases.write("Open Browser");
                           testcases.write("Pass");
                           testcases.write("Browser opened");
                           //end the record
                           testcases.endRecord();
                           //close the file
                           testcases.close();

                       } catch (IOException e) {
                           e.printStackTrace();
                      }

               }
}
