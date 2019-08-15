package com.ecom.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecom.qa.base.TestBase;

import io.qameta.allure.Step;

public class ShoppingCartPage extends TestBase {

	@FindBy(xpath = "//td[@class='product-cart-actions']/input[@type='text']")
	WebElement qtyText;

	@FindBy(xpath = "//button[@type='submit']/span/span[text()='Update']")
	WebElement updateBtn;

	@FindBy(xpath = "//h2[@class='product-name']/following-sibling::p[@class='item-msg error']")
	WebElement errorMsgText;

	@FindBy(xpath = "//button[@type='submit']/span/span[text()='Empty Cart']")
	WebElement emptyCartLink;

	@FindBy(xpath = "//div[@class='page-title']/h1")
	WebElement emptyCartMsg;

	public ShoppingCartPage() {

		PageFactory.initElements(driver, this);
	}
	
	@Step("Fetching error message when items in cart {qty} exceed maximum permissible limit(500) step")
	public String checkMaxItemsCartTest(String qty) {

		qtyText.clear();

		qtyText.sendKeys(qty);

		updateBtn.click();

		return errorMsgText.getText();

	}

	@Step("Fetching empty cart message step")
	public String emptyCartMessage() {

		emptyCartLink.click();

		return emptyCartMsg.getText();

	}

}
