package com.ecom.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.ecom.qa.base.TestBase;
import com.ecom.qa.pages.ApplicationHomePage;
import com.ecom.qa.pages.BillingInformationPage;
import com.ecom.qa.pages.CheckoutPage;
import com.ecom.qa.pages.RegistrationHomePage;
import com.ecom.qa.pages.ShoppingCartPage;
import com.ecom.qa.pages.TVHomePage;
import com.ecom.qa.pages.UserHomePage;
import com.ecom.qa.pages.WishlistPage;
import com.ecom.qa.testdata.TestData;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class BillingInformationPageTest extends TestBase {

	ApplicationHomePage applicationHomePage;
	RegistrationHomePage registrationHomePage;
	WishlistPage wishlistPage;
	UserHomePage userHomePage;
	ShoppingCartPage shoppingCartPage;
	TVHomePage tvHomePage;
	BillingInformationPage billingInformationPage;
	CheckoutPage checkoutPage;

	public BillingInformationPageTest() {

		super();
	}

	@BeforeMethod
	// @Parameters({ "emailId", "password" })
	public void setUp() {

		initialization();
		applicationHomePage = new ApplicationHomePage();
		registrationHomePage = new RegistrationHomePage();
		userHomePage = new UserHomePage();
		wishlistPage = new WishlistPage();
		tvHomePage = new TVHomePage();
		shoppingCartPage = new ShoppingCartPage();
		billingInformationPage = new BillingInformationPage();
		checkoutPage = new CheckoutPage();
		applicationHomePage.clickMyAccountLink();
		registrationHomePage.loginToWebsite(prop.getProperty("emailId"), prop.getProperty("password"));
		userHomePage.clickTvLink();
		tvHomePage.addToWishlistTV(TestData.tvName);
		wishlistPage.clickAddToCart();
		shoppingCartPage.selectStateDropDown().selectByVisibleText(TestData.state);
		shoppingCartPage.enterZipCode(TestData.zip);
		shoppingCartPage.clickEstimate();
		shoppingCartPage.clickUpdateTotalBtn();
		shoppingCartPage.clickProceedToCheckoutBtn();

	}

	@Test(priority = 1, description = "Validate that the order number is generated")
	public void isOrderNumberGenerated() {

		billingInformationPage.enterBillingInformation(TestData.address, TestData.city, TestData.state, TestData.zip,
				TestData.tPhone);
		checkoutPage.clickContinueBtn1();
		checkoutPage.clickCheckMoneyOrderRadioBtn();
		checkoutPage.clickContinueBtn2();
		checkoutPage.clickPlaceOrder();
		Assert.assertTrue(checkoutPage.FetchOrderNumber().isDisplayed());
		System.out.println(checkoutPage.FetchOrderNumber().getText());

	}

	@AfterMethod()
	public void tearDown() {

		eventFiringDriver.unregister(webEventListener);
		driver.quit();
	}

}
