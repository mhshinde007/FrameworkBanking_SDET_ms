package com.SdetBanking.Utilities;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/*
 * DataFormatter contains methods for formatting the value stored in a Cell. This can be useful for reports and GUI presentations 
 * when you need to display data exactly as it appears in Excel. Supported formats include currency, SSN, percentages, decimals, dates,
 *  phone numbers, zip codes, etc.
 */

public class XLUtils {

	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	
	public static int getRowCount (String xlFile, String sheetName) throws IOException
	{
		fi = new FileInputStream(xlFile);
		wbook = new XSSFWorkbook(fi);
		sheet = wbook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		wbook.close();
		fi.close();
		return rowCount;
	}
	
	public static int getCellCount (String xlFile, String sheetName, int rowNum) throws IOException
	{
		fi = new FileInputStream(xlFile);
		wbook = new XSSFWorkbook(fi);
		sheet = wbook.getSheet(sheetName);
		int cellCount = sheet.getRow(rowNum).getLastCellNum();
		wbook.close();
		fi.close();
		return cellCount;
	}
	
	public static String getCellData (String xlFile, String sheetName, int rowNum, int cellNum) throws IOException
	{
		fi = new FileInputStream(xlFile);
		wbook = new XSSFWorkbook(fi);
		sheet = wbook.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		cell = row.getCell(cellNum);
		String data;
		try 
		{
			DataFormatter formatter = new DataFormatter();
			String cellData = formatter.formatCellValue(cell);	
			return cellData;
		} 
		catch (Exception e)
		{
			data="";
		}
		wbook.close();
		fi.close();
		return data;
	}
	
	public static void setCellData (String xlFile, String sheetName, int rowNum, int cellNum, String data) throws IOException
	{
		fi = new FileInputStream(xlFile);
		wbook = new XSSFWorkbook(fi);
		sheet = wbook.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		cell = row.createCell(cellNum);
		cell.setCellValue(data);
		
		fo = new FileOutputStream(xlFile);
		wbook.write(fo);
		wbook.close();
		fi.close();
		fo.close();
	}
		
}
