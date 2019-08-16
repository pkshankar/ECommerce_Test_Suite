package com.ecom.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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

	@FindBy(xpath = "//select[@id='region_id']")
	WebElement selectState;

	@FindBy(xpath = "//input[@id='postcode']")
	WebElement zipCode;

	@FindBy(xpath = "//button[@title='Estimate']")
	WebElement estimateLink;

	@FindBy(xpath = "//label/span[@class='price']")
	WebElement shippingCost;

	@FindBy(xpath = "//input[@id='s_method_flatrate_flatrate']")
	WebElement shippingCostRadioBtn;

	@FindBy(xpath = "//button[@title='Update Total']")
	WebElement updateTotalBtn;

	@FindBy(xpath = "//td[contains(text(),'Subtotal')]/parent::tr/td/span")
	WebElement subtotal;

	@FindBy(xpath = "//strong/span[@class='price']")
	WebElement grandTotal;

	@FindBy(xpath = "(//button[@title='Proceed to Checkout']/span)[2]")
	WebElement proceedToCheckoutBtn;

	/**********************************************************************************/

	public ShoppingCartPage() {

		PageFactory.initElements(driver, this);
	}

	/**********************************************************************************/

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

	@Step("Selecting state step")
	public Select selectStateDropDown() {

		Select selectDropDown = new Select(selectState);
		return selectDropDown;
	}

	@Step("Entering zip code step")
	public void enterZipCode(String zip) {

		zipCode.sendKeys(zip);
	}

	@Step("Clicking on estimate link step")
	public void clickEstimate() {

		estimateLink.click();
	}

	@Step("Fetching shipping cost step")
	public WebElement fetchShippingCost() {

		return shippingCost;
	}

	@Step("Clicking shipping cost radio button step")
	public void clickShippingCostRadioBtn() {

		shippingCostRadioBtn.click();
	}

	@Step("Clicking update total button step")
	public void clickUpdateTotalBtn() {

		updateTotalBtn.click();
	}

	@Step("Fetching subtotal step")
	public String fetchSubtotal() {

		return subtotal.getText();

	}

	@Step("Fetching grand total")
	public String fetchGrandTotal() {

		return grandTotal.getText();
	}

	@Step("Clicking proceed to checkout button")
	public void clickProceedToCheckoutBtn() {

		proceedToCheckoutBtn.click();
	}

}
