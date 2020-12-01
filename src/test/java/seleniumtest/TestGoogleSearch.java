package seleniumtest;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.GoogleSearchPage;

public class TestGoogleSearch {
	
	private static WebDriver driver = null;
	public static String browser = null;
	public static String baseUrl = null;
	private static String projectPath = System.getProperty("user.dir");
	
	@BeforeTest
	public void setUp() throws Exception {

		PropertiesFile.readProperties();
		
		if(browser.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browser.contains("IE")) {
			System.setProperty("webdriver.ie.driver", projectPath+"/src/test/resources/drivers/IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}else if(browser.contains("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath+"/src/test/resources/drivers/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
	public void googleSearchTest() throws InterruptedException {
		driver.get(baseUrl);
		GoogleSearchPage gSrch = new GoogleSearchPage(driver);
		gSrch.googleTxtSearch("Spelling the Dream");
		gSrch.googleSearchBtn();
		Thread.sleep(3000);		
	}
	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();		
	}

}
