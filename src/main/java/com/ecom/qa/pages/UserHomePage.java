package com.ecom.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecom.qa.base.TestBase;

import io.qameta.allure.Step;

public class UserHomePage extends TestBase {

	@FindBy(xpath = "//li[@class='success-msg' or @class='error-msg']/ul/li/span")
	WebElement registrationMsg;

	@FindBy(xpath = "//a[text()='TV']")
	WebElement tvLink;

	@FindBy(xpath = "(//a[text()='My Wishlist'])[2]")
	WebElement myWishlistLink;

	public UserHomePage() {

		PageFactory.initElements(driver, this);
	}

	@Step("Fetching registration message step")
	public String getRegistrationMsg() {

		return registrationMsg.getText();
	}

	@Step("Clicking on TV link step")
	public void clickTvLink() {

		tvLink.click();
	}

	@Step("Clicking on my wishlist link step")
	public WishlistPage clickMyWishlist() {

		myWishlistLink.click();

		return new WishlistPage();
	}

}
