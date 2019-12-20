package com.seleniummaster.excel;

/**
 * @author Ahmet Bughra
 * @create 2019-12-20-4:10 AM
 * @email bughra1991@gmail.com
 */
public class ExcelReadDemo {
    public static void main(String[] args) {
        ExcelUtility excelUtility = new ExcelUtility();
//        excelUtility.readExcelCell(
//                "logs\\login-user.xlsx",
//                "Sheet1",
//                1,
//                0);
//        excelUtility.readExcelCell(
//                "logs\\login-user.xlsx",
//                "Sheet1",
//                1,
//                1);
//        excelUtility.readExcelCell(
//                "logs\\login-user.xlsx",
//                "Sheet1",
//                2,
//                0);
        String url= excelUtility.readExcelCell(
                "logs\\week17ProjectTestCase.xlsx",
                "Sheet1",
                1,
                5);

    }
}
