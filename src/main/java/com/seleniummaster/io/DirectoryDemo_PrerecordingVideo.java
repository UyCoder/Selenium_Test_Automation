package com.seleniummaster.io;

import java.io.File;

public class DirectoryDemo_PrerecordingVideo {
    public static void main(String[] args) {
        //enter the directory path and name to create new one
        CreateDirectory("docs", "testDir1");
    }

    //method that will create a new directory
    public static void CreateDirectory(String parentFolder, String directoryName) {
        //project directory
        String workingDirectory = System.getProperty("user.dir");
        // define a folder path
        // workingDirectory+"\\"+parentFolder+"\\"+directoryName
        String dir = workingDirectory + File.separator + parentFolder + File.separator + directoryName;
        System.out.println("Final dile directory: " + dir);

        //create a directory in the path
        File file = new File(dir);
        if (!file.exists()) {
            boolean isFolderCreated = file.mkdir();
            System.out.println("Directory is created? " + isFolderCreated);
        } else {
            System.out.println("Directoet is already existed.");
        }
    }

}
