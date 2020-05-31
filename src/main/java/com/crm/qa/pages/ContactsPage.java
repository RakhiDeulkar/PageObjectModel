package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath = "//*[@class='ui header item mb5 light-black']")
	//disadv: if dom changes caches will be stale
	//adv : improve script performance
	//element is stored in cache memory instead of hitting brower 100 times for every element
	@CacheLookup
	WebElement contactslabel;

	@FindBy(xpath = "//*[@href='/contacts/new']")
	WebElement NewContactBtn;

	@FindBy(name = "first_name")
	WebElement firstName;

	@FindBy(name = "last_name")
	WebElement lastName;

	@FindBy(xpath = "//button[contains(text(),'Save')]")
	WebElement saveContactBtn;

	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyContactsLabel() {
		return contactslabel.isDisplayed();
	}

	public void selectContactsByName(String name) {
		driver.findElement(By.xpath("//td[contains(text(),'" + name + "')]//preceding::div[1]")).click();
	}

	public void clickOnNewContacts() {
		NewContactBtn.click();
		driver.navigate().refresh();
		driver.navigate().refresh();
		driver.navigate().refresh();

	}

	public void createNewContact(String ftName, String ltName) {
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		saveContactBtn.click();
	}

}
