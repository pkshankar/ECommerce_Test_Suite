package com.ecom.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecom.qa.base.TestBase;

import io.qameta.allure.Step;

public class CheckoutPage extends TestBase {

	@FindBy(xpath = "//div[@id='shipping-method-buttons-container']/button")
	WebElement continueBtn1;

	@FindBy(xpath = "//input[@id='p_method_checkmo']")
	WebElement checkMoneyOrderRadioBtn;

	@FindBy(xpath = "(//button[@class='button'])[2]")
	WebElement continueBtn2;

	@FindBy(xpath = "//button[@title='Place Order']")
	WebElement placeOrderBtn;

	@FindBy(xpath = "//div[@class='page-title']/h1")
	WebElement orderReceivedMessage;

	@FindBy(xpath = "//p[contains(text(),'Your order')]/a")
	WebElement orderNo;

	/*****************************************************************************/

	public CheckoutPage() {

		PageFactory.initElements(driver, this);
	}

	/*****************************************************************************/

	public void clickContinueBtn1() {

		continueBtn1.click();

	}

	public void clickCheckMoneyOrderRadioBtn() {

		checkMoneyOrderRadioBtn.click();

	}

	public void clickContinueBtn2() {

		continueBtn2.click();

	}

	public void clickPlaceOrder() {

		placeOrderBtn.click();

	}

	public String FetchOrderReceivedMessage() {

		return orderReceivedMessage.getText();
	}

	public WebElement FetchOrderNumber() {

		return orderNo;
	}

}
