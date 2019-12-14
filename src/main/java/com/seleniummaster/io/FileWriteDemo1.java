package com.seleniummaster.io;

import java.io.IOException;

public class FileWriteDemo1 {
    public static void main(String[] args) throws IOException {
        FileUtility fileUtility = new FileUtility();
        //define a content
        StringBuilder fileContet = new StringBuilder();
        fileContet.append("I love coding in java \n");
        fileContet.append("Java Coding is really fun \n");
        fileUtility.writeToFile("log",
                 "test-result"+System.currentTimeMillis(),
                ".txt", fileContet.toString());
    }
}
