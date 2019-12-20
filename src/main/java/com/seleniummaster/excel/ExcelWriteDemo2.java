package com.seleniummaster.excel;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ahmet Bughra
 * @create 2019-12-20-5:07 AM
 * @email bughra1991@gmail.com
 */
public class ExcelWriteDemo2 {
    public static void main(String[] args) {
        Map<String, String[]> excelData = new HashMap<String, String[]>();
        excelData.put("1", new String[]{"username", "password","role"});
        excelData.put("2", new String[]{"test automation", "automation123!","test user"});
        String filename = "logs\\cubecart-login.xlsx";
        ExcelUtility excelUtility = new ExcelUtility();
        excelUtility.writeToExcelFileMultipleCells(filename, "sheet1", excelData);
    }
}
