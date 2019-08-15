package com.ecom.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecom.qa.base.TestBase;

import io.qameta.allure.Step;

public class RegistrationDetailPage extends TestBase {

	@FindBy(id = "firstname")
	WebElement fname;

	@FindBy(id = "middlename")
	WebElement mName;

	@FindBy(id = "lastname")
	WebElement lName;

	@FindBy(id = "email_address")
	WebElement eAddress;

	@FindBy(id = "password")
	WebElement pwd;

	@FindBy(id = "confirmation")
	WebElement cnfrmPwd;

	@FindBy(xpath = "//button[@title='Register']")
	WebElement registerBtn;

	public RegistrationDetailPage() {

		PageFactory.initElements(driver, this);
	}

	public UserHomePage clickRegister() {

		registerBtn.click();

		return new UserHomePage();
	}

	@Step("Creating new account: Details: First Name: {0}, Middle Name: {1}, Last Name: {2}, Email Address: {3}, Password: {4} step")
	public void createAccount(String firstName, String middleName, String lastName, String emailAddress,
			String password) {

		fname.sendKeys(firstName);
		mName.sendKeys(middleName);
		lName.sendKeys(lastName);
		eAddress.sendKeys(emailAddress);
		pwd.sendKeys(password);
		cnfrmPwd.sendKeys(password);
		clickRegister();

	}

}
