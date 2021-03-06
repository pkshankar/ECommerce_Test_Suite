package com.ecom.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecom.qa.base.TestBase;

import io.qameta.allure.Step;

public class RegistrationHomePage extends TestBase {

	@FindBy(xpath = "//a[@title='Create an Account']")
	WebElement createAccountLink;

	@FindBy(xpath = "//input[@title='Email Address']")
	WebElement userId;

	@FindBy(xpath = "//input[@title='Password']")
	WebElement password;

	@FindBy(xpath = "//button[@id='send2']")
	WebElement submitBtn;

	public RegistrationHomePage() {

		PageFactory.initElements(driver, this);
	}

	public RegistrationDetailPage clickCreateAccountLink() {

		createAccountLink.click();

		return new RegistrationDetailPage();
	}

	public void loginToWebsite(String uId, String pwd) {

		userId.sendKeys(uId);
		password.sendKeys(pwd);
		submitBtn.click();

	}
}
