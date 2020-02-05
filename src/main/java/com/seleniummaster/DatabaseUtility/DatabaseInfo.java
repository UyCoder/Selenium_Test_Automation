package com.seleniummaster.DatabaseUtility;

import com.seleniummaster.UIautomationFramework.PageObjectModel.AppConfigUtility;

/**
 * @author Ahmet Bughra
 * @create 2020-02-04-8:12 PM
 * @email bughra1991@gmail.com
 */
public class DatabaseInfo {
    // MSSQL Database credentials
    static final String MSSQLDBURL = AppConfigUtility.LoadConfigProperties("config.properties", "MSSQLDatabaseUrl");
    static final String MSSQLDBDEFAULT = AppConfigUtility.LoadConfigProperties("config.properties", "MSSQLDefaultDatabase");
    static final String MSSQLDBPORT = AppConfigUtility.LoadConfigProperties("config.properties", "MSSQLPort");
    static final String MSSQLUSERNAME = AppConfigUtility.LoadConfigProperties("config.properties", "MSSQLUsername");
    static final String MSSQLPASSWORD = AppConfigUtility.LoadConfigProperties("config.properties", "MSSQLPassword");
    //Aurora MySQL DB Information
    static final String MYSQLUsername = AppConfigUtility.LoadConfigProperties("config.properties", "MYSQLUsername");
    static final String MYSQLPassword = AppConfigUtility.LoadConfigProperties("config.properties", "MYSQLPassword");
    static final String MYSQLDATABASE = AppConfigUtility.LoadConfigProperties("config.properties", "MYSQLDatabaseUrl");
    static final String MYSQLPORT = AppConfigUtility.LoadConfigProperties("config.properties", "MYSQLPort");
    static final String AuroraDBDefaultDatabase = AppConfigUtility.LoadConfigProperties("config.properties", "MYSQLDefaultDatabase");

    public static void main(String[] args) {
        System.out.println("...... Database Information ....");
        System.out.println(getDatabaseUrl(ConnectionType.MYSQLSERVER));
    }

    public static String getDatabaseUrl(ConnectionType connectionType) {
        String DatabaseUrl;
        if (connectionType.name() == "MSSQLSERVER")
            DatabaseUrl = MSSQLDBURL;
        else {
            DatabaseUrl = MYSQLDATABASE;
        }
        System.out.println("Database: " + DatabaseUrl);
        return DatabaseUrl;

    }

    public static String getDatabasePort(ConnectionType connectionType) {
        String DatabasePort;
        if (connectionType.name() == "MSSQLSERVER")
            DatabasePort = MSSQLDBPORT;
        else {
            DatabasePort = MYSQLPORT;
        }
        System.out.println("Database Port: " + DatabasePort);
        return DatabasePort;

    }

    public static String getDatabaseDefault(ConnectionType connectionType) {
        String DefaultDatabase;
        if (connectionType.name() == "MSSQLSERVER")
            DefaultDatabase = MSSQLDBDEFAULT;
        else {
            DefaultDatabase = AuroraDBDefaultDatabase;
        }
        System.out.println("Default Database: " + DefaultDatabase);
        return DefaultDatabase;

    }

    public static String getDatabaseUsername(ConnectionType connectionType) {
        String DatabaseUsername;
        if (connectionType.name() == "MSSQLSERVER")
            DatabaseUsername = MSSQLUSERNAME;
        else {
            DatabaseUsername = MYSQLUsername;
        }
        System.out.println("Database User: " + DatabaseUsername);
        return DatabaseUsername;

    }

    public static String getDatabasePassword(ConnectionType connectionType) {
        String DatabasePassword;
        if (connectionType.name() == "MSSQLSERVER")
            DatabasePassword = MSSQLPASSWORD;
        else {
            DatabasePassword = MYSQLPassword;
        }
        System.out.println("Database Password: " + DatabasePassword);
        return DatabasePassword;

    }
}
