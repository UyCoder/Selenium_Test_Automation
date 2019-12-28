package com.seleniummaster.excel;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ExcelUtility {
    //write to an excel file
    public void writeToExcelFile(
            String filename,
            String sheetName,
            int rowNumber,
            int cellNumber,
            String content) {
        //define a file to write
        File excelFile = new File(filename);
        //define a workbook
        XSSFWorkbook workbook = new XSSFWorkbook();
        //define a worksheet
        XSSFSheet sheet = workbook.createSheet(sheetName);
        //define a row in the worksheet
        XSSFRow row = sheet.createRow(rowNumber);
        //define a cell in the row
        XSSFCell cell = row.createCell(cellNumber);
        //add content to the cell
        cell.setCellValue(content);
        //define output stream to write a file
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(excelFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            workbook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeToExcelFileMultipleCells(
            String filename,
            String sheetName,
            Map<String,
            String[]> content) {
        //define a file to write
        File excelFile = new File(filename);
        //define a workbook
        XSSFWorkbook workbook = new XSSFWorkbook();
        //define a worksheet
        XSSFSheet sheet = workbook.createSheet(sheetName);
        //define a row in the worksheet
        Set<String> numberOfRows = content.keySet();
        int rowNum = sheet.getLastRowNum();
        for (String key : numberOfRows) {
            XSSFRow row = sheet.createRow(rowNum++);
            String[] contents = content.get(key);
            int cellNum = 0;
            for (String value : contents) {
                //define a cell in the row
                XSSFCell cell = row.createCell(cellNum++);
                //add content to the cell
                cell.setCellValue(value);
            }
        }
        //define output stream to write a file
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(excelFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            workbook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //use overload for the excel file multiple cells method
    public void writeToExcelFileMultipleCells(
            String filename,
            String sheetName,
            List<String> contents) {
        //define a file to write
        File excelFile = new File(filename);
        //define a workbook
        XSSFWorkbook workbook = new XSSFWorkbook();
        //define a worksheet
        XSSFSheet sheet = workbook.createSheet(sheetName);
        //define a row in the worksheet
        int numberOfRows = contents.size(); //number of rows in the excel file
        for (int rowNumber = 0; rowNumber < numberOfRows; rowNumber++) {
            XSSFRow row = sheet.createRow(rowNumber); //create row
            String[] rowContent = contents.get(rowNumber).split(",");
            int totalCells = rowContent.length; //get total columns in the row
            for (int cellNumber = 0; cellNumber < totalCells; cellNumber++) {
                //define a cell in the row
                XSSFCell cell = row.createCell(cellNumber);
                //add content to the cell
                cell.setCellValue(rowContent[cellNumber]);
            }
        }
        //define output stream to write a file
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(excelFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            workbook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readExcelCell(
            String filename,
            String sheetName,
            int rowNumber,
            int colNumber) {
        String cellValue = null;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(filename);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //open an excel file
        XSSFWorkbook workbook = null;
        try {
            workbook = new XSSFWorkbook(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //get worksheet from the workbook
        XSSFSheet sheet = workbook.getSheet(sheetName);
        //get rows from the work sheet
        XSSFRow row = sheet.getRow(rowNumber);
        //get cell from the row
        if (row == null) {
            System.out.println("Empty row, no data row");
        } else {
            XSSFCell cell = row.getCell(colNumber);
            CellType cellType = cell.getCellTypeEnum();
            switch (cellType) {
                case NUMERIC:
                    cellValue = String.valueOf(cell.getNumericCellValue());
                    break;
                case STRING:
                    cellValue = cell.getStringCellValue();
                    break;
                default:
                    cellValue = cell.getStringCellValue();
                    break;
            }
        }
        System.out.println(cellValue);
        return cellValue;
    }
}
