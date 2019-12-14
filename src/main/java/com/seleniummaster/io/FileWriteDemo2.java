package com.seleniummaster.io;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileWriteDemo2 {
    public static void main(String[] args) {
        try {
            String content = "Login test passed";
            content = content + "\n" + "New client test passed";
            FileUtils.writeStringToFile(new File("logs\\test.txt"), content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
