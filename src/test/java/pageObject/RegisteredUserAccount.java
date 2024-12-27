package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisteredUserAccount {
	
	//1. create object of webdriver
			WebDriver ldriver;
			
			//Contructor 
			public RegisteredUserAccount(WebDriver rdriver) {
				ldriver = rdriver;
				PageFactory.initElements(rdriver, this);
			}
			
			//identify Webelements
			@FindBy(xpath ="//a[@title='View my customer account']")
			WebElement userName;
			
			@FindBy(xpath="//a[@title='Log me out']")
			WebElement singOut;
			
			@FindBy(id="search_query_top")
			WebElement searchTextFiled;
			
			@FindBy(name="submit_search")
			WebElement searchButton;
			
			public String getUserName() {
				return userName.getText();
				
			}
			
			public void clickOnLogout() {
				singOut.click();
			}
			
			public void enterDataInSearchBox(String searchKey) {
				searchTextFiled.sendKeys(searchKey);
			}
			
			public void clickOnSearchButton() {
				searchButton.click();
			}
			
			

}
