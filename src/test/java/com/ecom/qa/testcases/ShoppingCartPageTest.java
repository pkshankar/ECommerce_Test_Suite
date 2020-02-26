package com.ecom.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ecom.qa.base.TestBase;
import com.ecom.qa.pages.ApplicationHomePage;
import com.ecom.qa.pages.RegistrationHomePage;
import com.ecom.qa.pages.ShoppingCartPage;
import com.ecom.qa.pages.TVHomePage;
import com.ecom.qa.pages.UserHomePage;
import com.ecom.qa.pages.WishlistPage;
import com.ecom.qa.testdata.TestData;
import com.ecom.qa.util.TestUtil;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class ShoppingCartPageTest extends TestBase {

	ApplicationHomePage applicationHomePage;
	RegistrationHomePage registrationHomePage;
	WishlistPage wishlistPage;
	UserHomePage userHomePage;
	ShoppingCartPage shoppingCartPage;
	TVHomePage tvHomePage;

	public ShoppingCartPageTest() {

		super();
	}

	@BeforeMethod
	@Parameters({ "emailId", "password" })
	public void setUp(String eId, String pwd) {

		initialization();
		applicationHomePage = new ApplicationHomePage();
		registrationHomePage = new RegistrationHomePage();
		userHomePage = new UserHomePage();
		wishlistPage = new WishlistPage();
		tvHomePage = new TVHomePage();
		shoppingCartPage = new ShoppingCartPage();
		applicationHomePage.clickMyAccountLink();
		registrationHomePage.loginToWebsite(eId, pwd);
		userHomePage.clickTvLink();
		tvHomePage.addToWishlistTV(TestData.tvName);
		wishlistPage.clickAddToCart();
		shoppingCartPage.selectStateDropDown().selectByVisibleText(TestData.state);
		shoppingCartPage.enterZipCode(TestData.zip);
		shoppingCartPage.clickEstimate();

	}

	@Test(priority = 1, description = "Validate that shipping cost is generated")

	public void isShippingCostGenerated() {

		Assert.assertTrue(shoppingCartPage.fetchShippingCost().isDisplayed());

	}

	@Test(priority = 2, description = "Validate grand total")

	public void validateGrandTotal() {

		shoppingCartPage.clickShippingCostRadioBtn();
		shoppingCartPage.clickUpdateTotalBtn();
		Assert.assertEquals(
				Double.parseDouble(
						TestUtil.extractStringSubString(shoppingCartPage.fetchGrandTotal(), 1).replaceAll(",", "")),
				Double.parseDouble(
						TestUtil.extractStringSubString(shoppingCartPage.fetchSubtotal(), 1).replaceAll(",", ""))
						+ Double.parseDouble(
								TestUtil.extractStringSubString(shoppingCartPage.fetchShippingCost().getText(), 1)
										.replaceAll(",", "")));

	}

	@AfterMethod()
	public void tearDown() {

		eventFiringDriver.unregister(webEventListener);
		driver.quit();
	}

}
