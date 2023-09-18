package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;

import pageobject.BaseClass;
import pageobject.loginpagePO;




public class Readxlsx {
	
	
	
	public HashMap<String, String> datafromexcelsheet(int currentrow) throws IOException {
		HashMap<String,String>hm=new HashMap<String,String>();
		XSSFWorkbook workbook = null;
		XSSFSheet sheet;
		XSSFRow Row;
		XSSFCell Cell;
		
	  File excelfile = new File("C:\\Users\\lenovo\\eclipse-workspace\\newframework\\src\\test\\resources\\TestData\\TestDataFile.xlsx");
	  
		FileInputStream inputstream= new FileInputStream(excelfile);
		
		workbook = new XSSFWorkbook(inputstream);
		sheet=workbook.getSheetAt(0);
	int totalrow=	sheet.getLastRowNum()+1;
	int totalcells=sheet.getRow(0).getLastCellNum();
	//for(int currentrow=1; currentrow<totalrow; currentrow++) {
	//hm.put(sheet.getRow(currentrow).getCell(0).toString(), sheet.getRow(currentrow).getCell(1).toString());
	hm.put("username", sheet.getRow(currentrow).getCell(0).toString());
	hm.put("password", sheet.getRow(currentrow).getCell(1).toString());
	return hm;
	
	
	
		
		
	}
		
	
}
