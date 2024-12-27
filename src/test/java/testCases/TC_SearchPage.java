package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseClass;
import pageObject.IndexPage;
import pageObject.MyAccountPage;
import pageObject.RegisteredUserAccount;
import pageObject.SearchResultPage;

public class TC_SearchPage extends BaseClass {
	
	
	@Test
	
	public void verifySearchProduct() {
		
		String searchKey="T-Shirt";
		logger.info("...Test cases search product started...");
		
		IndexPage ip=new IndexPage(driver);
		ip.clickOnSignin();
		
		MyAccountPage map= new MyAccountPage(driver);
		map.enterUsername("testsam5@yopmail.com");
		map.enterPass("test@#123");
		map.clickOnLoginSubmit();
		
		RegisteredUserAccount rua = new RegisteredUserAccount(driver);
		rua.enterDataInSearchBox(searchKey);
		rua.clickOnSearchButton();
		
		SearchResultPage srp = new SearchResultPage(driver);
		String pdpName=srp.getSearchResultProductName();
		if(pdpName.contains(searchKey)) {
			logger.info("Search product test cases--- passed!!!");
			Assert.assertTrue(true);
			rua.clickOnLogout();
		}
		else {
			logger.info("Search product test cases --failed..!!!");
			Assert.assertTrue(false);
		}
		
		
		
		
	}

}
