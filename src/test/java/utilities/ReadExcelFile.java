package utilities;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {
	
	public static FileInputStream inputStream;
	public static XSSFWorkbook wrkbk;
	public static XSSFSheet  excelSheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static String getCellValue(String filename, String sheetName,int rowNo, int celllNo) {
		try {
			inputStream = new FileInputStream(filename);
			wrkbk = new XSSFWorkbook(inputStream);
			excelSheet = wrkbk.getSheet(sheetName);
			cell = wrkbk.getSheet(sheetName).getRow(rowNo).getCell(celllNo);
			 return cell.getStringCellValue();
		}
		catch(Exception e) {
			return "";
		}
	}
	
	public static int getRowCount(String fileName, String sheetName) {
		try {
		inputStream = new FileInputStream(fileName);
		wrkbk = new XSSFWorkbook(inputStream);
		excelSheet = wrkbk.getSheet(sheetName);
		int ttlRow = excelSheet.getLastRowNum()+1;
		wrkbk.close();
		return ttlRow;
		} catch(Exception e) {
			return 0;
		}
	}
		
		public static int getColumCount(String fName, String sName) {
			try {
			inputStream = new FileInputStream(fName);
			wrkbk = new XSSFWorkbook(inputStream);
			excelSheet = wrkbk.getSheet(sName);
			int ttlCol = excelSheet.getRow(0).getLastCellNum();
			wrkbk.close();
			return ttlCol;
			} catch(Exception e) {
				return 0;
			}	
	}
		
	}
	
	
	
	
	


