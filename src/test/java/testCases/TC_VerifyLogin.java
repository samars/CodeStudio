package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseClass;
import pageObject.IndexPage;
import pageObject.MyAccountPage;
import pageObject.RegisteredUserAccount;

public class TC_VerifyLogin extends BaseClass {
	
	@Test
	
	public void verifyLogin() throws InterruptedException {
		logger.info("Verify Login testing started...!!!!!");
		
		IndexPage ip = new IndexPage(driver);
		logger.info("Clicking on signin Link...!!!!!");
		ip.clickOnSignin();
		
		MyAccountPage mp= new MyAccountPage(driver);
		logger.info("Entering email into login username text filed...!!!!!");
		mp.enterUsername("testsam5@yopmail.com");
		logger.info("Entering password...!!!");
		mp.enterPass("test@#123");
		logger.info("Clicking on login button");
		mp.clickOnLoginSubmit();
		Thread.sleep(10000);
		RegisteredUserAccount rua = new RegisteredUserAccount(driver);
		String uname=rua.getUserName();
		if(uname.equals("Cusfname cuslname")) {
			logger.info("Verify login passed.... ");
			Assert.assertTrue(true);
			
		}  else 
		{
			logger.info("Verify login failed.... ");
			captureScreenshots(driver, "verifyLogin");
			Assert.assertTrue(false);
		}
	}

}
