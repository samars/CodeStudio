package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	public Properties prop;
	
	String path = "C:\\Users\\codilar\\eclipse-workspace\\CodeStudioPOM\\Config\\config.properties";
	
	
	//Constructor
	public ReadConfig() {
		
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(path);
			prop.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getBaseUrl() {
		String value= prop.getProperty("baseUrl");
		if(value != null) {
			return value;
		} else {
			throw new RuntimeException("URL not specified in config file..!!!");
		}	
	}
	
	public String getBrowser() {
		String value = prop.getProperty("browser");
		if(value != null) {
			return value;
		} else {
			throw new RuntimeException("Browser not specified in config file..!!!");
		}	
	}
	
	

}
