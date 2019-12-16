package com.seleniummaster.configutility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ApplicationConfig {
    //write a method to read a specific key value pair from config file
    public static String readConfigProperties(String fileName,String key)
    {
        Properties properties=new Properties();
        String value;
        String workingDir=System.getProperty("user.dir");
        try {
            properties.load(new FileInputStream(workingDir+ File.separator+fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        value=properties.getProperty(key);
        System.out.println(String.format("%s=%s",key,value));
        return value;
    }

}
