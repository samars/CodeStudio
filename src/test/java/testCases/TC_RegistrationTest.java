package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseClass;
import pageObject.AccountCreationPage;
import pageObject.IndexPage;
import pageObject.MyAccountPage;
import pageObject.RegisteredUserAccount;

public class TC_RegistrationTest extends BaseClass {
	
	
	@Test(priority=1)
	public void verifyRegistrationLogin() throws InterruptedException {
		
		//open url
		logger.info("Regsitration & Login testing started...!!!!!");
		IndexPage ip = new IndexPage(driver);
		logger.info("Clicking on signin Link...!!!!!");
		ip.clickOnSignin();
		
		MyAccountPage mp= new MyAccountPage(driver);
		logger.info("Entering email into create account username text filed...!!!!!");
		mp.enterCreateEmailAddress("testsam6@yopmail.com");
		logger.info("Clicking on submit Link...!!!!!");
		mp.clickOnSubmitCreate();
		AccountCreationPage acp = new AccountCreationPage(driver);
		logger.info("Selecting title Mr...!!!!!");
		acp.selectTitleMr();
		logger.info("Entering customer first name ...!!!!!");
		acp.enterCusFirstName(" Cusfname");
		logger.info("Entering customer last name...!!!!!");
		acp.enterCusLastName("cuslname");
		logger.info("Entering password...!!!!!");
		acp.enterPassword("test@#123");
		logger.info("Clicking on registered Link...!!!!!");
		acp.clickOnRegisterButton();
		Thread.sleep(10000);
		RegisteredUserAccount rua = new RegisteredUserAccount(driver);
		String uname=rua.getUserName();
		logger.info("Verifying usernmae after registration...!!!!!");
		Assert.assertEquals("Cusfname cuslname", uname);
			
			
	}
	

}
