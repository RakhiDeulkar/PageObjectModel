package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homepage;
	
	public LoginPageTest() {
		super();
	}
	//adding comment to create new branch from master
	//master branch comment
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}
	
	@Test(priority=0)
	public void loginpageTitleTest() {
		String title= loginPage.ValidateLoginPageTitle();
		Assert.assertEquals(title , "Free CRM #1 cloud software for any business large or small");
	}
	
	@Test(priority=1)
	public void crmLogoImgTest() {
		boolean flag = loginPage.ValidateCRMImage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=2)
	public void loginTest() {
		homepage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
