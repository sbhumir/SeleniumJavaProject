package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelUtils {


	XSSFWorkbook workbook;
	XSSFSheet sheet;
	
	
	public ExcelUtils(String excelPath, String sheetName) {		
		try {
			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	@Test
	public int getRowCount() {
		int rowCount = 0;
		try {
			rowCount = sheet.getPhysicalNumberOfRows();
			System.out.println(" no. of rows "+rowCount);
		}catch(Exception exp) {
			exp.getMessage();
			exp.printStackTrace();
		}
		return rowCount;
	}
	
	public int getColCount() {
		int colCount = 0;
		try {
			colCount = sheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println(" no. of columns "+colCount);
		}catch(Exception exp) {
			exp.getMessage();
			exp.printStackTrace();
		}
		return colCount;
	}
	
	
	@Test
	public String getCellDataString(int rowNum, int colNum) {
		String cellData = null;
		try {			
			cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			
			//System.out.println("cell data in Util"+cellData );
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} return cellData;		
	}
	@Test
	public int getCellDataNumber(int rowNum, int colNum) {
		int cellData=0;
		try {			
			cellData = (int) sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
			//System.out.println("cell data "+cellData );			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} return cellData;	
	}
}
