package baseTest;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;


import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readConfig = new ReadConfig();
	
	public String url = readConfig.getBaseUrl();
	
	public String lbrowser = readConfig.getBrowser();
	
	public static WebDriver driver;
	
	public static Logger logger;
	
	
	@BeforeClass
	public void setUp() {
		
		switch(lbrowser.toLowerCase()) 
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			//System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "firefox":
			//System.setProperty("webdriver.gecko.driver","./Drivers/geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();	
			break;
		case "ie":
			//System.setProperty("webdriver.ie.driver","./Drivers/IEDriverServer.exe");
			WebDriverManager.edgedriver().setup();
			driver = new InternetExplorerDriver();
			break;
			default:
				driver = null;
				break;
		
		}
		
//		if(lbrowser.equals("chrome")) 
//		{
//			
//			driver = new ChromeDriver();
//			
//			
//		} else if(lbrowser.equals("firefox")) {
//			driver = new FirefoxDriver();
//			
//			
//		} else
//		{
//			System.out.println("Sorry we do not support this browser..!!!");
//		}
		//maximising window
		driver.manage().window().maximize();
		//implicit wait upto 30 sec 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//for logging
		logger = LogManager.getLogger("MyStoreV1");	
		
		driver.get(url);
		logger.info("url opened...!!!!!");
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	
	public void captureScreenshots(WebDriver driver, String testname) {
		
		//Convert werdriver into screenshot interface
		TakesScreenshot ts= ((TakesScreenshot)driver);
		//call getScreenshotAs Method to create image file
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir")+"//Screenshots//"+testname+".png");
		
		try {
			//copy image file into destination
			FileUtils.copyFile(src, dest);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
