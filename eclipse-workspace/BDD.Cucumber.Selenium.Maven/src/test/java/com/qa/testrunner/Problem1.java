package com.qa.testrunner;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Problem1 {
	@Test
	public void excelReader() {
        try {
            // Specify the path to your Excel file
            String excelFilePath = "C:\\Users\\disem\\eclipse-workspace\\BDD.Cucumber.Selenium.Maven\\src\\test\\resources\\ExcelData.xlsx";
              // Create a FileInputStream to read the Excel file
            FileInputStream fis = new FileInputStream(new File(excelFilePath));

            // Create a workbook instance for the Excel file (in XLSX format)
            Workbook workbook = new XSSFWorkbook(fis);

            // Specify the sheet name or index you want to read from
            Sheet sheet = workbook.getSheet("Sheet1"); // Change "Sheet1" to your sheet name

            // Iterate through the rows and columns to read data
            for (Row row : sheet) {
                for (Cell cell : row) {
                    // Depending on the cell type, you can handle different data types
                    switch (cell.getCellType()) {                   
                        case Cell.CELL_TYPE_STRING:
                            System.out.print(cell.getStringCellValue());
                            break;
                        case Cell.CELL_TYPE_NUMERIC:
                            System.out.print(cell.getNumericCellValue());
                            break;
                        case Cell.CELL_TYPE_BOOLEAN:
                            System.out.print(cell.getBooleanCellValue());
                            break;
                        case Cell.CELL_TYPE_BLANK:
                            System.out.print("BLANK");
                            break;
                        default:
                            System.out.print("DEFAULT");
                    }
                    System.out.print("|");
                }
                System.out.println("\n"); // Move to the next row
            }
            // Close the FileInputStream and workbook
            fis.close();
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
