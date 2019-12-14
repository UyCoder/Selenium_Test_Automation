package com.seleniummaster.io;

import java.io.*;

public class InputStreamFileReaderDemo_Prerecording {
    public static void main(String[] args) throws IOException {
        System.out.println(readToString("docs\\test.txt"));
    }
        // method for read the file
    public static String readToString(String fileToText) throws IOException {
        //you can read all different types of data from all different types of sources.
        //define a string builder to accumulate file content
        StringBuilder contents = new StringBuilder();
        //current project folder
        String workingDir = System.getProperty("user.dir");
        //define a file object variable
        File filePath = new File(workingDir + File.separator);
        System.out.println(filePath);
        Reader reader = null;

        try {
            InputStream inputStream = new FileInputStream(filePath + File.separator + fileToText);
            reader = new InputStreamReader(inputStream);

            int data = reader.read();
            while (data != -1) {
                char theChar = (char) data;
                data = reader.read();
                contents.append(theChar);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }
        return contents.toString();

    }
}
