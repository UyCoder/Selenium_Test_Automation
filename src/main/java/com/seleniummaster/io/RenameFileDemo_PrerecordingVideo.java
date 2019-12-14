package com.seleniummaster.io;

import java.io.File;
import java.io.IOException;

public class RenameFileDemo_PrerecordingVideo {
    public static void main(String[] args) {
        createFileRenameExisting("docs\\smtestfile.txt");
    }

    //Rename an existing file and create a new file
    public static void createFileRenameExisting(String filename) {
        //get current project path
        String projectPath = System.getProperty("user.dir");
        //get file separator
        String fileSeparator = File.separator;
        //create a new file
        File file = new File(projectPath + fileSeparator + filename);
        try {
            if (!file.exists()) {
                file.createNewFile();
                System.out.println("File is created");
            } else {
                String absolutePath = file.getAbsolutePath(); //return file path (folder + filename)
                String filePath = absolutePath.substring(0, absolutePath.lastIndexOf(File.separator));
                System.out.println(filePath);
                File backupFile = new File(filePath + fileSeparator + "backup_" + file.getName());
                System.out.println("File already exist and backup file is created");
                file.renameTo(backupFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
