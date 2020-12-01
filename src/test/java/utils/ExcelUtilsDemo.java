package utils;

public class ExcelUtilsDemo {
	
	public static void main(String[] args) {
		
		String projectPath = System.getProperty("user.dir");
		String excelPath = "/src/test/resources/testdata/FBRegistration.xlsx";
		String sheetName = "userdata";
		ExcelUtils excel = new ExcelUtils(projectPath+excelPath, sheetName);
		
		excel.getRowCount();
		excel.getCellDataString(1,0);
		excel.getCellDataNumber(1,6);
	}
}
