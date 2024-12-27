package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import baseTest.BaseClass;
import pageObject.IndexPage;
import pageObject.MyAccountPage;
import pageObject.RegisteredUserAccount;
import utilities.ReadExcelFile;

public class TC_VerifyLoginDataDrivenTest extends BaseClass {
	
	@Test(dataProvider = "LoginDataProvider")
	
	public void verifyLogin(String userEmail, String pass, String expUserName) throws InterruptedException {
		logger.info("Verify Login testing started...!!!!!");
		
		IndexPage ip = new IndexPage(driver);
		logger.info("Clicking on signin Link...!!!!!");
		ip.clickOnSignin();
		
		MyAccountPage mp= new MyAccountPage(driver);
		logger.info("Entering email into login username text filed...!!!!!");
		mp.enterUsername(userEmail);
		logger.info("Entering password...!!!");
		mp.enterPass(pass);
		logger.info("Clicking on login button");
		mp.clickOnLoginSubmit();
		Thread.sleep(10000);
		RegisteredUserAccount rua = new RegisteredUserAccount(driver);
		String uname=rua.getUserName();
		if(uname.equals(expUserName)) {
			logger.info("Verify login passed.... ");
			Assert.assertTrue(true);
			rua.clickOnLogout();
			
		}  else 
		{
			logger.info("Verify login failed.... ");
			captureScreenshots(driver, "verifyLogin");
			Assert.assertTrue(false);
		}
		
		
	}
	
	
	@DataProvider(name="LoginDataProvider")
	public String[][] loginDataProvider(){
		//System.out.println(System.getProperty("user.dir"));
		String fileName= System.getProperty("user.dir")+"\\TestData\\TestExcel.xlsx";
	
		int ttlRows=ReadExcelFile.getRowCount(fileName, "Login");
		int ttlCol=ReadExcelFile.getColumCount(fileName, "Login");
	    String data[][]=new String[ttlRows-1][ttlCol];
	    
	    for(int i=1;i<ttlRows;i++) {  // row=1,2
	    	for(int j=0;j<ttlCol;j++) { //col=0,1,2
	    		data[i-1][j]=ReadExcelFile.getCellValue(fileName, "Login", i, j);
	    	}
	    }
	    return data;
	}

}
