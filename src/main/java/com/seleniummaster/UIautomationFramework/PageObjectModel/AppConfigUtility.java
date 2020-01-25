package com.seleniummaster.UIautomationFramework.PageObjectModel;

import java.io.*;
import java.util.Properties;

/**
 * @author Ahmet Bughra
 * @create 2020-01-14-10:27 PM
 * @email bughra1991@gmail.com
 */
public class AppConfigUtility {

    public static void main(String[] args) {
        //WriteToConfigProperty("ClassName","Selenium Test Automation");
        //LoadConfigProperties("config.properties","SiteUrl");
        //LoadConfigProperties("config.properties","TherapistUserName");
        System.out.println(LoadConfigPropertiesInResource("log4j.properties", "log4j.rootLogger"));
    }

    //write to config file
    public static void WriteToConfigProperty(String property, String value) {
        Properties prop = new Properties();
        try {
            //set the properties value
            prop.setProperty(property, value);
            //save properties to project root folder
            prop.store(new FileOutputStream("config.properties"), "this is another key");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    //define read method
    public static String LoadConfigProperties(String configFileName, String property) {
        Properties properties = new Properties();
        String propertyValue;
        String workingDir = System.getProperty("user.dir");
        try {
            properties.load(new FileInputStream(workingDir + File.separator + configFileName));
            //get the property value and print it out
            propertyValue = (properties.getProperty(property));
            System.out.println(property + "=" + propertyValue);
            return propertyValue;
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("You should have a config file in your project folder");
            System.out.println("The config file should have the Key=Value pair entries");
            System.out.println("For example:");
            System.out.println("Username=UserNameValue");
            System.out.println("Password=PasswordValue:");
            return null;
        }
    }

    //define a method to read config property from the class path resrouce folder
    public static String LoadConfigPropertiesInResource(String configFileName, String property) {
        Properties prop = new Properties();
        InputStream input = null;
        String propertyValue;
        try {
            input = AppConfigUtility.class.getClassLoader().getResourceAsStream(configFileName);
            if (input == null) {
                System.out.println("Sorry, unable to find    " + configFileName);
                return null;
            }
            //load a properties file from class path, inside static method
            prop.load(input);
            propertyValue = prop.getProperty(property);
            return propertyValue;
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            if (input != null) try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
