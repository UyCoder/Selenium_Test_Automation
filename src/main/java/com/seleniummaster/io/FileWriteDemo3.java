package com.seleniummaster.io;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class FileWriteDemo3 {
    public static void main(String[] args) {

        // we used existing filewrite library
        try {
            String newTestReasult = "\n Logout test passed";
            File existingFile = new File("logs\\test1.txt");
            FileUtils.writeStringToFile(existingFile, newTestReasult,Charset.defaultCharset(),true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
