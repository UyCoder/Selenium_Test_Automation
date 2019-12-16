package com.seleniummaster.configutility;

public class ConfigDemo {
    public static void main(String[] args) {
        ApplicationConfig.readConfigProperties("config-prod.properties", "url");
        ApplicationConfig.readConfigProperties("config.properties", "username");
        ApplicationConfig.readConfigProperties("config.properties", "clinicadmin");
    }
}
