package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AccountCreationPage {
	
	//1. create object of webdriver
		WebDriver ldriver;
		
		public AccountCreationPage(WebDriver rdriver) {
			ldriver = rdriver;
			PageFactory.initElements(rdriver, this);
		}
		
		//identify Webelements 
		
		//@FindBy(xpath="//a[@title='Log in to your customer account']") WebElement loginLink;
		
		@FindBy(id = "id_gender1")
		WebElement titleMr;
		
		@FindBy(id = "id_gender2")
		WebElement titleMrs;
		
		@FindBy(id="customer_firstname")
		WebElement fnmae;
		
		@FindBy(id="customer_lastname")
		WebElement lnmae;
		
		@FindBy(id="passwd")
		WebElement password;
		
		@FindBy(id="submitAccount")
		WebElement registerButton;
		
		@FindBy(id="days")
		WebElement dobDays;
		
		@FindBy(id="months")
		WebElement dobMonths;
		
		@FindBy(id="years")
		WebElement dobYears;
		
		
		
		//Identify Action to be performed
		public void selectTitleMr() {
			
			titleMr.click();
			
		}
		
		public void enterCusFirstName(String cusfname) {
			fnmae.sendKeys(cusfname);
		}
		
		public void enterCusLastName(String cuslname) {
			lnmae.sendKeys(cuslname);
		}
		
		public void enterPassword(String pass) {
			password.sendKeys(pass);
		}
		
		public void clickOnRegisterButton() {
			registerButton.click();
		}
		
		public void selectDOB(String day, String month, String year) {
			
			Select selDay = new Select(dobDays);
			selDay.selectByVisibleText(day);
			Select selMonth = new Select(dobMonths);
			selMonth.selectByVisibleText(month);
			Select selYear = new Select(dobYears);
			selYear.selectByVisibleText(year);	
			
		}
		
		
		

}
