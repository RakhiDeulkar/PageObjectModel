package com.crm.qa.pages;


import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//span[contains(text(),'Rakhi Deulkar')]")
	WebElement usernameLabel;

	@FindBy(xpath = "//span[contains(text(),'Contacts')]")
	WebElement contactLabel;

	@FindBy(xpath = "//span[contains(text(),'Deals')]")
	WebElement dealsLabel;
	
	@FindBy(xpath = "//span[contains(text(),'Tasks')]")
	WebElement tasksLabel;

	// Initializating the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyhomePagetitle() {
		return driver.getTitle();

	}

	public boolean verifyCorrectUserName() {
		return usernameLabel.isDisplayed();

	}

	public ContactsPage clickOnContactsLink() {
		contactLabel.click();
		return new ContactsPage();
	}

	public DealsPage clickOnDealsLink() {
		dealsLabel.click();
		return new DealsPage();
	}

	public TasksPage clickOnTasksLink() {
		tasksLabel.click();
		return new TasksPage();
	}
}