package com.ak.selenium.util;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class ExcelReadWriteUtil {
    File file;
    FileInputStream fileIn;
    FileOutputStream fileOut;
    private XSSFWorkbook wb;
    private XSSFSheet sheet;
    private XSSFRow row;
    private XSSFCell cell;
    private String filePath;

// taking file path from project directory and setting it to instance var filePath
    public ExcelReadWriteUtil(String filePathFromProjDir){
        this.filePath = System.getProperty("user.dir") + filePathFromProjDir;

    }

    /**
     * get row count of the file based on sheet name
     * @param sheetName
     * @return
     * @throws IOException
     */
    public int getRowCount(String sheetName) throws IOException {
        file = new File(filePath);
        fileIn = new FileInputStream(file);
        wb = new XSSFWorkbook(fileIn);
        sheet = wb.getSheet(sheetName);
        int rowCount = sheet.getLastRowNum();
        wb.close();
        fileIn.close();

        return rowCount;

    }

    /**
     * get column count of the file based on sheet name
     * @param sheetName
     * @param rowNum
     * @return
     * @throws IOException
     */

    public int getColumnCount(String sheetName, int rowNum) throws IOException {
        file = new File(filePath);
        fileIn = new FileInputStream(file);
        wb = new XSSFWorkbook(fileIn);
        sheet = wb.getSheet(sheetName);
        row = sheet.getRow(rowNum);
        int colCount = row.getLastCellNum();
        wb.close();
        fileIn.close();

        return colCount;

    }

    /**
     * get cell data and return as string it could easily capture into a 2D array using nested for loops for DataProvider in TestNG
     * @param sheetName
     * @param rowNum
     * @param colNum
     * @return
     * @throws IOException
     */
    public String getCellData(String sheetName, int rowNum, int colNum) throws IOException {
        file = new File(filePath);
        fileIn = new FileInputStream(file);
        wb = new XSSFWorkbook(fileIn);
        sheet = wb.getSheet(sheetName);
        row = sheet.getRow(rowNum);
        cell = row.getCell(colNum);
        DataFormatter dataFormatter = new DataFormatter();
        String data = dataFormatter.formatCellValue(cell);
        wb.close();
        fileIn.close();

        return data;

    }

    /**
     * update/write data into an existing cell
     * @param sheetName
     * @param rowNum
     * @param colNum
     * @param data
     * @throws IOException
     */
    public void writeDataIntoCell(String sheetName, int rowNum, int colNum, String data) throws IOException {
        file = new File(filePath);
        fileIn = new FileInputStream(file);
        wb = new XSSFWorkbook(fileIn);
        sheet = wb.getSheet(sheetName);
        row = sheet.getRow(rowNum);
        cell = row.getCell(colNum);
        cell.setCellValue(data);
        fileOut = new FileOutputStream(filePath);
        wb.write(fileOut);

        fileIn.close();
        wb.close();
    }






}
