package com.seleniummaster.io;

import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileWriterDemo2_PrerecordingVideo {
    public static void main(String[] args) {
        try {
            String textContent = "Content created on PC: " + getCurrentTestHostName();
            textContent = textContent + "\n" + "Content created by: " + getCurrentTestUserName();
            textContent = textContent + "\n" + "Hello Test";
            textContent = textContent + "\n" + "This is file creation example";
            writeToFile(textContent, "docs\\testfile", ".txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeToFile(String fileContent, String fileName, String fileExtention) throws IOException {
        //return current project folder
        String projectPath = System.getProperty("user.dir");
        //define a file name for the output file
        String tempFile = projectPath + File.separator + fileName + getCurrentTimeStamp() + fileExtention;
        //define a file object
        File file = new File(tempFile);
        // if file does exist, then backup and create a new file
        if (file.exists()) {
            try {
                File newFileName = new File(projectPath + File.separator + "backup_" + fileName);
                file.renameTo(newFileName);
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //write to file with OutputStreamWriter
        OutputStream outputStream = new FileOutputStream(file.getAbsoluteFile());
        Writer writer = new OutputStreamWriter(outputStream);
        try {
            writer.write(fileContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
        writer.close();

    }

    // Get current system time
    public static String getCurrentTimeStamp() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");// dd/MM/yyyy
        Date now = new Date();
        String strDate = sdfDate.format(now);
        strDate = strDate.replace(":", "_").replace(".", "_");
        return strDate;
    }

    // Get Current Host Name
    public static String getCurrentTestHostName() {
        InetAddress localMachine = null;
        try {
            localMachine = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        String hostName = localMachine.getHostName();
        return hostName;
    }

    // Get Current User Name
    public static String getCurrentTestUserName() {
        return System.getProperty("user.name");
    }
}
