package com.seleniummaster.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo3_PrerecordingVideo {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Hello Test").append("\n");
        stringBuilder.append("Selenium Master").append("\n");
        stringBuilder.append("Selenium Master2").append("\n");
        stringBuilder.append("Selenium Master3").append("\n");
        try {
            writeToFile(stringBuilder.toString(), "docs\\test.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeToFile(String fileContent, String fileName) throws IOException {
        String projectPath = System.getProperty("user.dir"); //return current project folder
        String tempFile = projectPath + File.separator + fileName; //define a path for the file
        File file = new File(tempFile);
        // if file does exist, rename it and create a new file
        if (file.exists()) {
            try {
                File newFileName = new File(projectPath + File.separator + fileName + "_backup");
                file.renameTo(newFileName); //rename the current file to a new backup file
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        try {
            bw.write(fileContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(fileContent);
        bw.close();

    }
}
