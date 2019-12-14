package com.seleniummaster.io;

import java.io.*;
import java.net.URL;

public class FileReadFrimUrlDemo_PrerecordingVideo {
    public static void main(String[] args) {

        String projectPath = System.getProperty("user.dir"); //return current project folder
        String fileSeparatorSymbol = File.separator;  //return file separator symbol like "\\"

        String filePath = projectPath + fileSeparatorSymbol;
        InputStream in = null;
        try {
            URL testUrl = new URL("http://commons.apache.org");
            in = testUrl.openStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuilder result = new StringBuilder();
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(result);

        //Use Output Stream to create a file
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(filePath + "docs\\temp4" + ".html");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //Write output stream to a file
        Writer writer = new OutputStreamWriter(outputStream);
        try {
            //write out to a file
            writer.write(result.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
