package com.seleniummaster.DatabaseUtility;

import com.sun.rowset.CachedRowSetImpl;

import javax.sql.rowset.CachedRowSet;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ahmet Bughra
 * @create 2020-02-04-8:22 PM
 * @email bughra1991@gmail.com
 */
public class DataAccess {
    public static void main(String[] args) {

        Connection conn = ConnectionManager.connectDatabaseServer(ConnectionType.MSSQLSERVER);
        for (int i = 0; i < 1; i++) {
            List<String> users = getClinicWiseTestUsernames(conn);
            for (String user : users) {
                System.out.println(user);
            }
        }
        ConnectionManager.closeDatabaseServerConnection(conn);
        //This is for MYSQL
        Connection mysqlconn = ConnectionManager.connectDatabaseServer(ConnectionType.MYSQLSERVER);
        List<String> customers = getSakilaCustomerInformationByStore(mysqlconn, 1);
        System.out.println(customers.toString());
        try {
            insertDataIntoSakilaLanguageTable(mysqlconn, 9, "USA English3");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ConnectionManager.closeDatabaseServerConnection(mysqlconn);

    }

    //get sample sakila customer information by store Id
    public static List<String> getSakilaCustomerInformationByStore(Connection conn, int storeId) {
        List<String> customerNames = new ArrayList<String>();
        CachedRowSet crs = null;
        String sql = String.format("select * from sakila.customer where store_id=%d", storeId);
        System.out.println(sql);
        try {
            crs = ExecuteSqlForDataRetrieve(conn, sql);
            while (crs.next()) {
                String firstName = crs.getString("first_name");
                String lastName = crs.getString("last_name");
                customerNames.add(firstName + " " + lastName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                crs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return customerNames;
    }

    public static List<String> getClinicWiseTestUsers(Connection conn) {
        List<String> testUsers = new ArrayList<String>();
        //defined a cached rowset object instance to store sql script result
        CachedRowSet crs = null;
        String sqlScript = String.format("select * from dbo.login_info");
        System.out.println(sqlScript);
        try {
            crs = ExecuteSqlForDataRetrieve(conn, sqlScript);
            while (crs.next()) {
                String uName = crs.getString("username").trim();
                String uPassword = crs.getString("password").trim();
                String uRole = crs.getString("userrole").trim();
                testUsers.add(uName + "," + uPassword + "," + uRole);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                crs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return testUsers;
    }

    public static List<String> getClinicWiseTestUsernames(Connection conn) {
        List<String> testUserNames = new ArrayList<String>();
        CachedRowSet crs = null;
        String sql = String.format("select username from dbo.login_info");
        System.out.println(sql);
        try {
            crs = ExecuteSqlForDataRetrieve(conn, sql);
            while (crs.next()) {
                String uName = crs.getString("username").trim();
                testUserNames.add(uName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                crs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return testUserNames;
    }

    //insert data into sakila language table
    public static void insertDataIntoSakilaLanguageTable(Connection conn, int languageId, String languageName) throws SQLException {
        String sql = String.format("INSERT INTO LANGUAGE(language_id,name,last_update) values(%d,%s,CURRENT_TIMESTAMP)", languageId, encapsulateSingleQuote(languageName));
        System.out.println(sql);
        int numberOfRows = ExecuteSqlForDataUpdate(conn, sql);
        System.out.println(numberOfRows + "  record get inserted into the sakila language table");
    }

    public static CachedRowSet ExecuteSqlForDataRetrieve(Connection conn, String SqlStatement) throws SQLException {
        Statement stmt = null; //SQL Statement
        ResultSet rs; //SQL Script Result Set
        CachedRowSet crs = new CachedRowSetImpl();
        try {
            //Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SqlStatement); //Execute SQl Statement
            if (rs == null) {
                System.out.println("Sql Statement DID NOT return data ");
            } else {
                System.out.println("Sql Statement returned data ");
                crs.populate(rs); //transfer result set to cached result set object
            }
            rs.close();
        } catch (SQLException se) {
            System.out.println("Check JDBC Database");
            se.printStackTrace();
        } catch (Exception e) {
            System.out.println("Check JDBC Database Driver");
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }// do nothing
        }//end try
        return crs;
    }

    public static int ExecuteSqlForDataUpdate(Connection conn, String SqlStatement) throws SQLException {
        Statement stmt = null; //SQL Statement
        int affectedRows = 0;
        try {
            //Execute a query for data update
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            affectedRows = stmt.executeUpdate(SqlStatement);
            if (affectedRows != 0) {
                System.out.println("Sql Statement Data Update success ");
            } else {
                System.out.println("Sql Statement DID NOT update data ");
            }
        } catch (SQLException se) {
            System.out.println("Check JDBC Database");
            se.printStackTrace();
        } catch (Exception e) {
            System.out.println("Check JDBC Database Driver");
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }// do nothing
        }//end try
        return affectedRows;
    }

    public static String encapsulateSingleQuote(String variable) {
        String temp = "'" + variable + "'";
        return temp;
    }
}
