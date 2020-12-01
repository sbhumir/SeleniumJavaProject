package seleniumtest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import pages.GoogleSearchPage;

public class DesiredCapabilitiesDemo {
	

	private static WebDriver driver = null;
	
	private static String projectPath = System.getProperty("user.dir");
	
	@SuppressWarnings("deprecation")
	@Before
	public void setUp() throws Exception {

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("ignoreProtectedModeSettings", true);
		
		System.setProperty("webdriver.ie.driver", projectPath+"/src/test/resources/drivers/IEDriverServer.exe");
		driver=new InternetExplorerDriver(caps);
}
	@Test
	public void DesiredCapabilitiesTest() throws InterruptedException {
		driver.get("https://google.com");
		GoogleSearchPage gSrch = new GoogleSearchPage(driver);
		gSrch.googleTxtSearch("A");
		gSrch.googleSearchBtn();		
	}
	@After
	public void tearDown() throws Exception {
		driver.quit();		
	}
}
