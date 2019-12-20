package com.seleniummaster.excel;

/**
 * @author Ahmet Bughra
 * @create 2019-12-20-4:50 AM
 * @email bughra1991@gmail.com
 */
public class ExcelWriteDemo1 {
    public static void main(String[] args) {
    ExcelUtility excelUtility = new ExcelUtility();
    String username = "testautomation";
        String password = "automation123!";
        String filename = "logs\\cubecart.xlsx";
        excelUtility.writeToExcelFile(
                filename,
                "Login",
                0,
                0,
                username);
        excelUtility.writeToExcelFile(
                filename,
                "Login",
                0,
                1,
                password);
    }
}
