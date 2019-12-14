package com.seleniummaster.io;

import java.io.*;

public class FileReaderDemo1_PrerecordingVideo {
    public static void main(String[] args) {
        // enter the fileName we want to read
        System.out.println(readToString("docs\\test.txt"));
    }

    //method of read the file
    public static String readToString(String fileToText) {
        String workingDir = System.getProperty("user.dir");
        StringBuilder fileContent = new StringBuilder();
        File file = new File(workingDir + File.separator);
        System.out.println(file);
        try {
            FileReader fr = new FileReader(file + File.separator + fileToText);
            BufferedReader br=new BufferedReader(fr);
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                fileContent.append(sCurrentLine).append("\n");
            }
        } catch (IOException e) {
            System.out.println("can not read the text file");
        }
        return fileContent.toString();
    }
}
