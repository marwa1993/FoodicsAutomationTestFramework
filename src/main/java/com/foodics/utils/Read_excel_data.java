package com.foodics.utils;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Utility class to store test data for the Login and Sign-Up screen.
 */
public class Read_excel_data {

    // Test data for login and sign-up functionality
    public String[][] read_sheet() throws InvalidFormatException, IOException {
        File myfile = new File("src/test/resources/testdata/signup_data.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(myfile);
        XSSFSheet mysheet = wb.getSheet("signup_data");
        int number_of_rows = mysheet.getPhysicalNumberOfRows();
        int number_of_columns = mysheet.getRow(0).getLastCellNum();
        String[][] myarray = new String[number_of_rows - 1][number_of_columns];

        for (int i = 1; i < number_of_rows; i++) {
            for (int a = 0; a < number_of_columns; a++) {
                XSSFRow row = mysheet.getRow(i);
                if (row.getCell(a).getCellType() == CellType.STRING) {
                    myarray[i - 1][a] = row.getCell(a).getStringCellValue();
                } else if (row.getCell(a).getCellType() == CellType.NUMERIC) {
                    myarray[i - 1][a] = String.valueOf(row.getCell(a).getNumericCellValue());
                }
            }
        }

        wb.close();  // Don't forget to close the workbook to prevent memory leaks
        return myarray;
    }
}




