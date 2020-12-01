package seleniumtest;

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.FaceBookRegistrationPage;

public class TestFaceBookRegistration {

	private static WebDriver driver=null;
	public static String browser = null;
	public static String fbUrl = null;
	private static String projectPath = System.getProperty("user.dir");

	private StringBuffer verificationErrors = new StringBuffer();
	//private boolean acceptNextAlert = true;
	
	@BeforeTest
	public void setUp() throws Exception {

		//read properties from config.properties
		PropertiesFile.readProperties();
		
		//instantiate chrome driver
		if(browser.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		//instantiate IE driver
		if(browser.contains("IE")) {
			System.setProperty("webdriver.ie.driver", projectPath+"/src/test/resources/drivers/IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		//instantiate firefox driver
		if(browser.contains("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath+"/src/test/resources/drivers/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testFBRegistration() throws Exception {

		//get FB url from properties file
		driver.get(fbUrl);

		//instantiate FB Page objects class
		FaceBookRegistrationPage fbReg = new FaceBookRegistrationPage(driver);
		fbReg.clickFBNALnk();
		fbReg.setTxtFBFN("fn1");
		fbReg.setTxtFBLN("ln1");
		fbReg.setTxtFBRegEmail("fn1.ln1@gmail.com");
		fbReg.setTxtFBRegEmailConfirm("fn1.ln1@gmail.com");
		fbReg.setTxtFBRegPwd("Password@1");

		fbReg.selectFBDOBMonth("Jan");
		fbReg.selectFBDOBDay("4");
		fbReg.selectFBDOBYear("1990");

		fbReg.radioGenderMale();
		fbReg.closeFBRegWindow();

		fbReg.clickFBNALnk();
		fbReg.setTxtFBFN("fn2");
		fbReg.setTxtFBLN("ln2");
		fbReg.setTxtFBRegEmail("fn2.ln2@gmail.com");
		fbReg.setTxtFBRegEmailConfirm("fn2.ln2@gmail.com");
		fbReg.setTxtFBRegPwd("Password@2");

		fbReg.selectFBDOBMonth("Sep");
		fbReg.selectFBDOBDay("15");
		fbReg.selectFBDOBYear("1991");

		fbReg.radioGenderFeMale();
		fbReg.closeFBRegWindow();
	}

	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	//  private boolean isElementPresent(By by) {
	//    try {
	//      driver.findElement(by);
	//      return true;
	//    } catch (NoSuchElementException e) {
	//      return false;
	//    }
	//  }
	//
	//  private boolean isAlertPresent() {
	//    try {
	//      driver.switchTo().alert();
	//      return true;
	//    } catch (NoAlertPresentException e) {
	//      return false;
	//    }
	//  }
	//
	//  private String closeAlertAndGetItsText() {
	//    try {
	//      Alert alert = driver.switchTo().alert();
	//      String alertText = alert.getText();
	//      if (acceptNextAlert) {
	//        alert.accept();
	//      } else {
	//        alert.dismiss();
	//      }
	//      return alertText;
	//    } finally {
	//      acceptNextAlert = true;
	//    }
	//  }
}
