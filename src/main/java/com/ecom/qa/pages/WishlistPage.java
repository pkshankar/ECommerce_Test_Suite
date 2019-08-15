package com.ecom.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecom.qa.base.TestBase;

import io.qameta.allure.Step;

public class WishlistPage extends TestBase {

	@FindBy(xpath = "//button[@title='Share Wishlist']")
	WebElement shareWishlistLink;

	@FindBy(name = "emails")
	WebElement emailIdTextBox;

	@FindBy(id = "message")
	WebElement msgTextBox;

	@FindBy(xpath = "//button[@title='Share Wishlist']")
	WebElement shareWishlistBtn;

	@FindBy(xpath = "//li[@class='success-msg']/ul/li/span")
	WebElement wishlistShareMsg;

	@FindBy(xpath = "//li[@class='success-msg']/ul/li/span")
	WebElement wishlistSharedMsg;

	public WishlistPage() {

		PageFactory.initElements(driver, this);
	}

	@Step("Entering message: {1} and sending an email to: {0} step")
	public void enterEmailIdMsg(String emailId, String msg) {

		emailIdTextBox.sendKeys(emailId);
		msgTextBox.sendKeys(msg);

	}

	@Step("Clicking share wishlist step")
	public void clickShareWishlist() {

		shareWishlistBtn.click();

	}
	
	@Step("Fetching wishlist shared message step")
	public String wishListSharedMsg() {

		return wishlistSharedMsg.getText();
	}

}
