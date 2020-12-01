package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPage {
	
	WebDriver driver = null;
	
	public GoogleSearchPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By txtBox_GoogleSrch = By.name("q");
	By button_search = By.name("btnK");
	
	public void googleTxtSearch(String text) {		
		driver.findElement(txtBox_GoogleSrch).sendKeys(text);		
	}	
	public void googleSearchBtn() {
		driver.findElement(button_search).sendKeys(Keys.RETURN);
	}
}
