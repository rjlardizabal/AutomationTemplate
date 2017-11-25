package com.dice.utils;



import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;




public class ExcelReader {
	String[][] arrayExcelData;

	public ExcelReader() {

	}
	
	public Object[][] getExcelData(String FilePath, String SheetName) throws IOException{
		FileInputStream fis = new FileInputStream(FilePath);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheet(SheetName);
		

		int totalNoOfCols = sheet.getRow(0).getPhysicalNumberOfCells();
		int totalNoOfRows = sheet.getLastRowNum()+1;
		
		//System.out.println(totalNoOfRows+""+totalNoOfCols);
		
		arrayExcelData = new String[totalNoOfRows-1][totalNoOfCols];
		

		for(int i=1;i<totalNoOfRows;i++) {
			for(int j=0;j<totalNoOfCols;j++) {
				
			arrayExcelData[i-1][j]=	sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}	

			
			return arrayExcelData;

		}
		
		
		
		
	
	



}
