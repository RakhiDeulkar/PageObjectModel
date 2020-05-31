package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{

	//Page factory -OR:
	@FindBy(xpath = "//*[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']")
	WebElement LogIN;
	
	@FindBy(xpath = "//a[contains(text(),'Sign Up')]")
	WebElement signIn;
	
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath = "//*[@class='ui fluid large blue submit button']")
	WebElement loginBtn;
	
	@FindBy(xpath = "//a[@title='free crm home']//parent::div[@class='rd-navbar-brand']")
	WebElement crmLogo;
	
	//Initializing the Page Objects:
	public LoginPage() {
		PageFactory.initElements(driver, this); //this --pointing to current class object
	}
	
	//Actions
	public String ValidateLoginPageTitle() {
		return driver.getTitle();	
	}
	
	public boolean ValidateCRMImage() {
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un,  String pwd) {
		LogIN.click();
		username.sendKeys(un);
		password.sendKeys(pwd);	
		loginBtn.click();
		
		return new HomePage();
	}
}
