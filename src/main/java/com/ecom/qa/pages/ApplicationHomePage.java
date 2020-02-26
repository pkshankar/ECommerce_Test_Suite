package com.ecom.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecom.qa.base.TestBase;

import io.qameta.allure.Step;

public class ApplicationHomePage extends TestBase {

	@FindBy(xpath = "//a[text()='Mobile']")
	WebElement mobileLink;

	@FindBy(xpath = "//a[text()='TV']")
	WebElement tvLink;

	@FindBy(xpath = "(//a[@title='My Account'])[2]")
	WebElement myAccountLink;

	/* Initialize web objects of this class with webdriver instance */

	public ApplicationHomePage() {

		PageFactory.initElements(driver, this);
	}

	public String appHomePageTitle() {

		return driver.getTitle();
	}

	public MobileHomePage clickMobileLink() {

		mobileLink.click();

		return new MobileHomePage();

	}

	public RegistrationHomePage clickMyAccountLink() {

		myAccountLink.click();

		return new RegistrationHomePage();

	}

}
