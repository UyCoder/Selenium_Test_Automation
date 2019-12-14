package com.seleniummaster.io;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class FileCompareDemo {
    public static void main(String[] args)  {
        File file1= new File("logs\\test.txt");
        File file2 = new File("logs\\test1.txt");
        try {
            // compare the files
            boolean isFilesTheSame=FileUtils.contentEquals(file1, file2);
            if (isFilesTheSame) {
                System.out.println("Files are the same");
            } else {
                System.out.println("Two files are different");
                // find the difference
                String file1Content = FileUtils.readFileToString(file1);
                String file2Content = FileUtils.readFileToString(file2);
                String difference = file1Content.replace(file2Content, "");
                System.out.println("The difference is: \n"+difference);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
