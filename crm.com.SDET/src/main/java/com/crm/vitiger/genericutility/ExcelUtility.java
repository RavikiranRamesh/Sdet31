package com.crm.vitiger.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * its developed using Apache Poi libraries,which used to handle Microsoft Excel sheet
 * @author Ravikiran
 *
 */

public class ExcelUtility {
	/**
	 * its used read the data from exel base don below arguments
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return Data
	 * @throws Throwable 
	 * @throws Throwable
	 */
	public String getDataFromExcel(String sheetName,int rowNum,int cellNum) throws Throwable {
		FileInputStream fis =new FileInputStream("./src/main/resources/Testdata/organisation.xlsx.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		String data = row.getCell(cellNum).getStringCellValue();
		return data;
	}
	/**
	 * used to get the last used row number on specified sheet
	 * @param sheetName
	 * @return
	 * @throws Throwable 
	 * @throws Throwable
	 */
    public int getRowCount(String sheetName) throws Throwable {
    	FileInputStream fis=new FileInputStream("./src/main/resources/Testdata/organisation.xlsx.xlsx");
    	Workbook wb = WorkbookFactory.create(fis);
    	Sheet sh = wb.getSheet(sheetName);
    	wb.close();
    	return sh.getLastRowNum();
    }
    /**
     * used to input data into Excel sheet
     * @param sheetName
     * @param data
     * @param rowNum
     * @param celNum
     * @throws Throwable 
     * @throws Throwable
     */
    public void setDataExcel(String sheetName,int rowNum,int celNum,String data) throws Throwable {
    	FileInputStream fis = new FileInputStream("./src/main/resources/Testdata/organisation.xlsx.xlsx");
    	Workbook wb = WorkbookFactory.create(fis);
    	Sheet sh = wb.getSheet(sheetName);
    	Row row = sh.getRow(rowNum);
    	Cell cel = row.createCell(celNum);
    	cel.setCellValue(data);
    	FileOutputStream fos = new FileOutputStream("./src/main/resources/Testdata/organisation.xlsx.xlsx");
    	wb.write(fos);
    	wb.close();
    }
}
