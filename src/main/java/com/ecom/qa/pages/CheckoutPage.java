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
	@Step("Clicking continue button on checkout page step")
	public void clickContinueBtn1() {

		continueBtn1.click();

	}

	@Step("Clicking check/money order radio button step")
	public void clickCheckMoneyOrderRadioBtn() {

		checkMoneyOrderRadioBtn.click();

	}

	@Step("Clicking continue button after selecting check/money order step")
	public void clickContinueBtn2() {

		continueBtn2.click();

	}

	@Step("Clicking place order button")
	public void clickPlaceOrder() {

		placeOrderBtn.click();

	}

	@Step("Fetching order received message")
	public String FetchOrderReceivedMessage() {

		return orderReceivedMessage.getText();
	}

	@Step("Fetching order number")
	public WebElement FetchOrderNumber() {

		return orderNo;
	}

}
