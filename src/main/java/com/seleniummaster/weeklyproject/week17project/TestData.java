package com.seleniummaster.weeklyproject.week17project;

import com.seleniummaster.configutility.ApplicationConfig;

/**
 * @author Ahmet Bughra
 * @create 2019-12-19-3:21 AM
 * @email bughra1991@gmail.com
 */
public class TestData {
    // make static string for all data used in this project
    // get the value from config-week17project.properties file
    final static String url = ApplicationConfig.readConfigProperties
            ("config-week17project.properties", "url");
    final static String username = ApplicationConfig.readConfigProperties
            ("config-week17project.properties", "username");
    final static String password = ApplicationConfig.readConfigProperties
            ("config-week17project.properties", "password");
    final static String newsletterSubject = ApplicationConfig.readConfigProperties
            ("config-week17project.properties", "NewsletterSubject");
    final static String sendersName = ApplicationConfig.readConfigProperties
            ("config-week17project.properties", "Sender'sName");
    final static String sendersEmail = ApplicationConfig.readConfigProperties
            ("config-week17project.properties", "Sender'sEmailAddress");
    final static String template = ApplicationConfig.readConfigProperties
            ("config-week17project.properties", "Template");
    final static String textContent = ApplicationConfig.readConfigProperties
            ("config-week17project.properties", "TextContent");
    final static String sleep = ApplicationConfig.readConfigProperties
            ("config-week17project.properties", "sleep");
    final static String timeout = ApplicationConfig.readConfigProperties
            ("config-week17project.properties", "timeout");
}
