package com.seleniummaster.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FileWriteDemo1_PrerecordingVideo {
    public static void main(String[] args) {
        writeToFile("docs\\test.txt");
    }

    public static void writeToFile(String FileToText) {
        String workingDir = System.getProperty("user.dir");//return current project folder
        String fileSeparatorSymbol = File.separator;  //return file separator symbol
        String filePath = workingDir + fileSeparatorSymbol;
        System.out.println(filePath);

        try {
            RandomAccessFile file = new RandomAccessFile(filePath + fileSeparatorSymbol + FileToText, "rw");
            System.out.println(file.readLine());
            long point = file.getFilePointer();
            System.out.println(point);
            //move cursor to the last of the file
            file.seek(file.length());
            file.write("This is another example of random access file \n".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
