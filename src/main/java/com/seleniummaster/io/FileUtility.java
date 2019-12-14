package com.seleniummaster.io;

import java.io.*;

public class FileUtility {
    public FileUtility() throws IOException {
    }

    // create a method to write a text file
    public void writeToFile(String fileFolder, String fileName, String fileExtentions, String fileContent) {
        //create a folder if the folder does not exist
        String workingDirectory = System.getProperty("user.dir");
        String finalDirectory = workingDirectory + File.separator + fileFolder;
        System.out.println(finalDirectory);
        //if the folder does not exist, we need to craate the folder
        File file = new File(finalDirectory);
        if(!file.exists())
        {
            file.mkdirs();
            System.out.println("Folder is created.");
        }
        //final file name
        String finalFileName = finalDirectory + File.separator + fileName + fileExtentions;
        // we need to create a file object to write a file
        File myFile = new File(finalFileName);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(myFile.getAbsoluteFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //create a buffer instance
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        try {
            bufferedWriter.write(fileContent);//writing a file on the disk
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}