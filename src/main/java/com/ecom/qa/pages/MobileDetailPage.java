package com.ecom.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecom.qa.base.TestBase;

import io.qameta.allure.Step;

public class MobileDetailPage extends TestBase {

	@FindBy(xpath = "(//div[@class='product-name'])[1]")
	WebElement wPhoneName;

	@FindBy(xpath = "//div[@class='price-box']/span/span" + "|"
			+ "//div[@class='price-box']/p[@class='special-price']/span[@class='price']")
	WebElement wPhonePrice;

	public MobileDetailPage() {

		PageFactory.initElements(driver, this);
	}

	public String detailPagePhoneName(String pName) {

		return wPhoneName.getText();

	}

	public String detailPagePhonePrice() {

		return wPhonePrice.getText();
	}
}
