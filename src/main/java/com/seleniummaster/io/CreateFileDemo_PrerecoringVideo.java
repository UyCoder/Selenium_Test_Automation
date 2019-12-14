package com.seleniummaster.io;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateFileDemo_PrerecoringVideo {
    public static void main(String[] args) {
        createFile("docs","Java",".txt");
    }


    // method that will make new file
    public static void createFile(String folder, String fileName, String fileExtension) {
        // get current project path
        String filePath = System.getProperty("user.dir");
        // get current date time stamp
        Date currentTime = new Date();
        SimpleDateFormat sdf;
        String pattern = "yyyy-MM-dd-hh-mm-sss";
        SimpleDateFormat format= new SimpleDateFormat(pattern);
        String timeStamp = format.format(currentTime).replace("-", "_");

        // create a new file object instance
        File file = new File(filePath + "\\" + folder +"\\"+ timeStamp + fileExtension);
        try {
            if (!file.exists()) {

                file.createNewFile();
                System.out.println("File is created");
                System.out.println("file: " + file);
            } else {
                System.out.println("file already exist");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
