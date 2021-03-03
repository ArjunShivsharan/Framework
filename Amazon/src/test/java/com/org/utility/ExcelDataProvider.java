package com.org.utility;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	
	XSSFSheet sheet;
	XSSFWorkbook wb;
	
	public ExcelDataProvider() 
  {
		try {
			File src = new File("./TestData/TestData.xlsx");
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) 
		{
			System.out.println("Unable To Read Excel File : "+e.getMessage());
			
		} 
	}
	
	
	//Concept of MethodOverloading
	public double getNumericData(int sheeIndex,int row, int coloumn) 
	{
		return wb.getSheetAt(sheeIndex).getRow(row).getCell(coloumn).getNumericCellValue();
	}
	
	public String getStringData(String sheetName,int row, int coloumn) 
	{
		return wb.getSheet(sheetName).getRow(row).getCell(coloumn).getStringCellValue();
	}
	
	public double getNumericData(String sheetName,int row, int coloumn) 
	{
		return wb.getSheet(sheetName).getRow(row).getCell(coloumn).getNumericCellValue();
	}
	
}