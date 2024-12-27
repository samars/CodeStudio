package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
	
	//1. create object of webdriver
		WebDriver ldriver;
		
		//Contructor 
		public MyAccountPage(WebDriver rdriver) {
			ldriver = rdriver;
			PageFactory.initElements(rdriver, this);
		}
		
		//identify Webelements
		
		@FindBy(id="email_create")
		WebElement createEmailID;
		
		@FindBy(name="SubmitCreate")
		WebElement submitCreate;
		
		@FindBy(xpath ="//a[@title='View my customer account']")
		WebElement myAccountName;
		
		@FindBy(xpath="//input[@id='email']")
		WebElement username;
		
		@FindBy(xpath="//input[@id='passwd']")
		WebElement password;
		
		@FindBy(xpath="//button[@id='SubmitLogin']")
		WebElement loginButton;
		
		//Identify Action on webElement
		public void enterCreateEmailAddress(String emailAddress) {
			
			createEmailID.sendKeys(emailAddress);
			
		}
		
		public void clickOnSubmitCreate() {
			
			submitCreate.click();
		}
		
		public void loginApp(String uname, String pas) {
			username.sendKeys(uname);
			password.sendKeys(pas);
			loginButton.click();		
		}
		
		public void enterUsername(String un) {
			username.sendKeys(un);
		}
		
		public void enterPass(String ps) {
			password.sendKeys(ps);
		}
		
		public void clickOnLoginSubmit() {
			loginButton.click();
		}
		
		
		

}
