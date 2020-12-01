package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.FaceBookRegistrationPage;

public class ExcelDataProvider {

	String projectPath = System.getProperty("user.dir");
	String excelPath = "/src/test/resources/testdata/FBRegistration.xlsx";
	String sheetName = "userdata";
	WebDriver driver = null;

	@BeforeTest
	public void setUp() throws Exception {

		System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test(dataProvider="fbData")
	public void test1(String FN, String LN, String email, String emailConfirm, String pwd, String month, String day,String year) throws InterruptedException {
		//System.out.println(FN + "|" + LN+ "|" + email+ "|" + emailConfirm+ "|" + pwd+ "|" + month+ "|" + day+"|"+ year);
		
		FaceBookRegistrationPage fbReg = new FaceBookRegistrationPage(driver);
		driver.get("https://facebook.com");
		//instantiate FB Page objects class
		
		fbReg.clickFBNALnk();
		Thread.sleep(2000);
		fbReg.setTxtFBFN(FN);
		fbReg.setTxtFBLN(LN);
		fbReg.setTxtFBRegEmail(email);
		fbReg.setTxtFBRegEmailConfirm(emailConfirm);
		fbReg.setTxtFBRegPwd(pwd);

		fbReg.selectFBDOBMonth(month);
		//fbReg.selectFBDOBDay(day);
		//fbReg.selectFBDOBYear(year);

		fbReg.radioGenderMale();
		fbReg.closeFBRegWindow();

	}

	@DataProvider(name = "fbData")
	public Object[][] getData() {

		Object data[][] = testData(projectPath+excelPath, sheetName);
		return data;
	}

	public Object[][] testData(String excelPath, String sheetName) {

		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);		
		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();

		Object data[][] = new Object[rowCount-1][colCount];		

		for(int i=1; i<rowCount; i++) {
			for(int j=0;j<colCount;j++) {

				String cellData = excel.getCellDataString(i, j);
				//System.out.print(cellData+" | ");
				data[i-1][j] = cellData;
			}
			//System.out.println();
		} return data;
	}

}
