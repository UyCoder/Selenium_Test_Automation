package com.seleniummaster.DatabaseUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Ahmet Bughra
 * @create 2020-02-04-8:16 PM
 * @email bughra1991@gmail.com
 */
public class ConnectionManager {
    public static void main(String[] args) {
    }

    public static Connection connectDatabaseServer(ConnectionType connectionType) {
        //define connection object variable
        Connection conn = null;
        //get connection type name
        String databaseConnectionName = connectionType.name();
        System.out.println("Connecting to a database server: " + databaseConnectionName);
        //defined drivers
        String JTDS_DRIVER = "net.sourceforge.jtds.jdbc.Driver"; //jtds Driver object
        String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";         //jdbc Driver object
        String dbUrl;
        String dbPort;
        String defaultDatabase;
        String dbUsername;
        String dbPassword;
        switch (connectionType) {
            case MSSQLSERVER:
                try {
                    //Register JDBC driver with JTDS
                    Class.forName(JTDS_DRIVER);
                    //Open a connection
                    //get MSSQL DB URL
                    dbUrl = DatabaseInfo.getDatabaseUrl(ConnectionType.MSSQLSERVER);
                    //get MSSQL DB PORT
                    dbPort = DatabaseInfo.getDatabasePort(ConnectionType.MSSQLSERVER);
                    //get MSSQL Default Database
                    defaultDatabase = DatabaseInfo.getDatabaseDefault(ConnectionType.MSSQLSERVER);
                    //get MSSQL DB Username
                    dbUsername = DatabaseInfo.getDatabaseUsername(ConnectionType.MSSQLSERVER);
                    //get MSSQL User Password
                    dbPassword = DatabaseInfo.getDatabasePassword(ConnectionType.MSSQLSERVER);
                    //create MSSQL Connection String
                    String connection_url = "jdbc:jtds:sqlserver://" + dbUrl + ":" + dbPort + ";DatabaseName=" + defaultDatabase;
                    //create connection
                    conn = DriverManager.getConnection(connection_url, dbUsername, dbPassword);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    if (!conn.isClosed())

                        System.out.println("Database Connection is live");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case MYSQLSERVER:
                //Register JDBC driver
                try {
                    Class.forName(JDBC_DRIVER).newInstance();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                try {
                    System.out.println("Connecting to a selected database...");
                    //get MYSQL Database URL
                    dbUrl = DatabaseInfo.getDatabaseUrl(ConnectionType.MYSQLSERVER);
                    //get MYSQL Database Port
                    dbPort = DatabaseInfo.getDatabasePort(ConnectionType.MYSQLSERVER);
                    //get MYSQL Default database Name
                    defaultDatabase = DatabaseInfo.getDatabaseDefault(ConnectionType.MYSQLSERVER);
                    //get MYSQL username
                    dbUsername = DatabaseInfo.getDatabaseUsername(ConnectionType.MYSQLSERVER);
                    //get MYSQL password
                    dbPassword = DatabaseInfo.getDatabasePassword(ConnectionType.MYSQLSERVER);
                    //create MYSQL Connection String
                    String mysql_connection_url = "jdbc:mysql://" + dbUrl + ":" + dbPort + "/" + defaultDatabase;
                    //Connect to MYSQL Database
                    conn = DriverManager.getConnection(mysql_connection_url, dbUsername, dbPassword);
                    // Do something with the Connection
                } catch (SQLException ex) {
                    // handle any errors
                    System.out.println("SQLException: " + ex.getMessage());
                    System.out.println("SQLState: " + ex.getSQLState());
                    System.out.println("VendorError: " + ex.getErrorCode());
                }
                if (conn != null) {
                    System.out.println("Mysql connection has been established");
                } else {
                    System.out.println("Failed to make connection to Mysql DB");
                }
                break;
            default:
                System.out.println("You need to specify a database connection type: MsSql or Mysql");
                break;
        }
        return conn;
    }

    public static void closeDatabaseServerConnection(Connection conn) {
        try {
            if (!conn.isClosed()) {
                System.out.println("Disconnecting database server connection");
                //close the connection
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn.isClosed()) {
                System.out.println("Database connection is closed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
