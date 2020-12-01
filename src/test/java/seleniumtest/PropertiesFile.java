package seleniumtest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesFile {
	
	static Properties prop = new Properties();
	static String projectPath = System.getProperty("user.dir");
	static String properties = "/src/test/resources/properties/config.properties";

	public static void main(String[] args) {
		readProperties();
		writeProperties();
		readProperties();
	}
	
	public static void readProperties() {		
		
		try {
			InputStream input = new FileInputStream(projectPath+properties);
			prop.load(input);
			TestGoogleSearch.browser = prop.getProperty("browser");
			TestGoogleSearch.baseUrl = prop.getProperty("baseUrl");
			
			TestFaceBookRegistration.browser = prop.getProperty("browser");
			TestFaceBookRegistration.fbUrl = prop.getProperty("fbUrl");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void writeProperties() {
		try {
			OutputStream output = new FileOutputStream(projectPath+properties);
			prop.setProperty("result", "pass");
			prop.store(output, null);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
