package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class FaceBookRegistrationPage {
	
	WebDriver driver = null;
	
	public FaceBookRegistrationPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By fbNALnk = By.linkText("Create New Account");
	By fbFN = By.name("firstname");
	By fbLN = By.name("lastname");
	By fbRegEmail = By.name("reg_email__");
	By fbRegEmailConfirm = By.name("reg_email_confirmation__");
	By fbRegPwd = By.id("password_step_input");	
	By fbRegMonth = By.id("month");
	By fbRegDay = By.id("day");
	By fbRegYear = By.id("year");
	
	By fbGenMale = By.xpath("//span[2]/input");
	By fbGenFemale = By.name("sex");
	By fbRegClose = By.xpath("//img[contains(@src,'https://static.xx.fbcdn.net/rsrc.php/v3/y2/r/__geKiQnSG-.png')]");
	
	
	public void clickFBNALnk() {		
		driver.findElement(fbNALnk).click();		
	}
	public void setTxtFBFN(String text) {		
		driver.findElement(fbFN).sendKeys(text);		
	}
	public void setTxtFBLN(String text) {		
		driver.findElement(fbLN).sendKeys(text);		
	}
	public void setTxtFBRegEmail(String text) {		
		driver.findElement(fbRegEmail).sendKeys(text);		
	}
	public void setTxtFBRegEmailConfirm(String text) {		
		driver.findElement(fbRegEmailConfirm).sendKeys(text);		
	}
	public void selectFBDOBMonth(String text) {		
		new Select(driver.findElement(fbRegMonth)).selectByVisibleText(text);
	}
	public void selectFBDOBDay(String text) {		
		new Select(driver.findElement(fbRegDay)).selectByVisibleText(text);
	}
	public void selectFBDOBYear(String text) {		
		new Select(driver.findElement(fbRegYear)).selectByVisibleText(text);
	}
	
	public void setTxtFBRegPwd(String text) {		
		driver.findElement(fbRegPwd).sendKeys(text);		
	}
	public void radioGenderMale() {		
		driver.findElement(fbGenMale).click();		
	}
	public void radioGenderFeMale() {		
		driver.findElement(fbGenFemale).click();		
	}
	public void closeFBRegWindow() {		
		driver.findElement(fbRegClose).click();		
	}

}
