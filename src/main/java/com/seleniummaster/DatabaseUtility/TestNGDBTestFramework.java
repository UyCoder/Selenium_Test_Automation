package com.seleniummaster.DatabaseUtility;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.sql.Connection;
import java.util.List;

/**
 * @author Ahmet Bughra
 * @create 2020-02-04-8:26 PM
 * @email bughra1991@gmail.com
 */
public class TestNGDBTestFramework {
    private List<String> testUsers;
    private Connection connection;

    @BeforeClass(alwaysRun = true)
    public void setupDatabaseConnection(ITestContext context) {
        connection = ConnectionManager.connectDatabaseServer(ConnectionType.MSSQLSERVER);

    }

    @BeforeMethod
    public void printTestStartInfo() {
        System.out.println(" ---- New Test Started ---");
    }

    @Test
    public void testClinicWiseLoginInfoTableShouldContainAdmin() {
        testUsers = DataAccess.getClinicWiseTestUsernames(connection);
        System.out.println(testUsers.toString());
        Assert.assertTrue(testUsers.contains("admin"));
    }

    @Test
    public void testClinicWiseLoginInfoTableShouldContainReceptionist() {
        testUsers = DataAccess.getClinicWiseTestUsernames(connection);
        System.out.println(testUsers.toString());
        Assert.assertTrue(testUsers.contains("natalie"));
    }

    @AfterMethod
    public void printTestEndInfo() {

        System.out.println("--- Test Ended ------");
    }

    @AfterClass
    public void setupAfterSuite() {
        ConnectionManager.closeDatabaseServerConnection(connection);
    }

}
