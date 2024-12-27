package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {
	
	//1. create object of webdriver
	WebDriver ldriver;
	
	public IndexPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//identify Webelements 
	
	//@FindBy(xpath="//a[@title='Log in to your customer account']") WebElement loginLink;
	
	@FindBy(linkText = "Sign in")
	WebElement signIn;
	
	//Identify action on webElement
	
	public void clickOnSignin() {
		signIn.click();
	}
	
	
	
	
	

}
