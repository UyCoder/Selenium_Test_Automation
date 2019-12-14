package com.seleniummaster.io;

import java.io.File;

public class DeleteFileDemo_PrerecordingVideo {
    public static void main(String[] args) {
        // enter the file we want to delete
        DeleteFile("docs\\2019_12_14_02_53_007.txt");
    }

    // method of delete a file
    public static void DeleteFile(String fileName) {
        // get cuttent project path
        String filePath = System.getProperty("user.dir");
        // create a new objecte instance
        File file = new File(filePath + "\\" + fileName);
        if (!file.exists()) {
            System.out.println("file is not found");
        }else{
            //delete file
            System.out.println("file  exist and deleted successfully");
            file.delete();
        }
    }
}
