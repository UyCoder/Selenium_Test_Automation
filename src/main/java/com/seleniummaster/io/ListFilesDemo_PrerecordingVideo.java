package com.seleniummaster.io;

import java.io.File;

public class ListFilesDemo_PrerecordingVideo {
    public static void main(String[] args) {
        // list files in a directory
        ListFiles("docs");
    }

    // method
    public static void ListFiles(String directoryName) {
        // project directory
        String workingDirectory = System.getProperty("user.dir");
        System.out.println("current project directory : " + workingDirectory);
        // define a folder
        String dir = workingDirectory + File.separator + directoryName;
        System.out.println("final file directory : " + dir);

        // list files in the directory
        File file = new File(dir);
        // define array of files
        File[] files = file.listFiles();

        if (file.exists()) {
            System.out.println("Directory is found!");
            for (File eachFile : files) {
                System.out.println(eachFile.getName() +
                        " ; is file : " + eachFile.isFile());
            }
        } else {
            System.out.println("Directory in not exist");
        }
    }
}
