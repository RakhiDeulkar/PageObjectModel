package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;


public class ContactsPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;

	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();

		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homePage.clickOnContactsLink();
	}

	 @Test(priority=0)
	 public void verifyContactsPageLabelTest() {
	 Assert.assertTrue(contactsPage.verifyContactsLabel(),"contact label is misssing");
	 }
	 
	@Test(priority = 1)
	public void selectSingleContactsTest() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(2000);
		contactsPage.selectContactsByName("Rakhi Deulkar1");
	}
	
	@Test(priority = 2)
	public void selectMultipleContactsLabel() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(2000);
		contactsPage.selectContactsByName("Rakhi Deulkar1");
		contactsPage.selectContactsByName("Rahul Rahul");
	}

	/*********************** DataProvider********************** 
	 * import com.crm.qa.util.TestUtil;
	 * import org.testng.annotations.DataProvider;
	 * String sheetName = "contacts"; ---declare after class
	 * 
	 * @DataProvider public Object[][] getCRMTestData() { Object data[][] =
	 *               TestUtil.getTestData(sheetName); //store data in 2D array
	 *               return data; }
	 * 
	 *               //@Test(dataProvider="getCRMTestData")
	 * 
	 *               public void validateNewContactTest(String ftName, String
	 *               ltName) { 
	 *               contactsPage.selectNewContact(Fname, Lname);
	 *               }
	 */

	
	@Test(priority = 3)
	public void validateNewContactTest() {
		contactsPage.clickOnNewContacts();
		contactsPage.createNewContact("Nakul", "Deulkar");

	}

	@AfterMethod
	public void tearDown() {
		 driver.quit();
	}
	
}
