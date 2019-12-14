package com.seleniummaster.io;

import java.io.*;

public class LineNumberReaderDemo_PrerecordingVideo {
    public static void main(String[] args) throws IOException {
        readToString("docs\\test.txt");
    }

    public static void readToString(String fileToRead) throws IOException {
        String workingDir = System.getProperty("user.dir"); //current project folder
        File file = new File(workingDir + File.separator + fileToRead); //define a file object variable with file path
        System.out.println(file); //print out file path
        LineNumberReader reader = new LineNumberReader(new FileReader(file)); //define LineNumberReader instance
        BufferedReader br=new BufferedReader(new FileReader(file));
        System.out.println("Line Number        Content");
        try {
            while (reader.readLine() != null) {
                int lineNumber = reader.getLineNumber();
                String s = br.readLine();
                System.out.println(lineNumber + ":" + " " + s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
