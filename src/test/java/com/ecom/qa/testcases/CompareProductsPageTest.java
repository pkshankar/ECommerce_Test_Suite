package com.ecom.qa.testcases;

import java.util.List;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.ecom.qa.base.TestBase;
import com.ecom.qa.pages.ApplicationHomePage;
import com.ecom.qa.pages.CompareProductsPage;
import com.ecom.qa.pages.MobileDetailPage;
import com.ecom.qa.pages.MobileHomePage;
import com.ecom.qa.pages.ShoppingCartPage;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class CompareProductsPageTest extends TestBase {

	SoftAssert softAssert = new SoftAssert();
	MobileHomePage mobileHomePage;
	ApplicationHomePage appHomePage;
	MobileDetailPage mobileDetailPage;
	ShoppingCartPage shoppingCartPage;
	CompareProductsPage compareProductsPage;

	public CompareProductsPageTest() {

		super();
	}

	@BeforeMethod
	public void setUp() {

		initialization();
		appHomePage = new ApplicationHomePage();
		appHomePage.clickMobileLink();
		mobileHomePage = new MobileHomePage();
		mobileDetailPage = new MobileDetailPage();
		shoppingCartPage = new ShoppingCartPage();
		compareProductsPage = new CompareProductsPage();
	}

	@Test(priority = 1, description = "Validate phone compare feature")

	public void validatePopUpMessageTest() {

		mobileHomePage.addToCompareFeature("Samsung Galaxy", "Xperia");
		List<String> mobileHomePhoneList = mobileHomePage.homeListPhoneNames();
		mobileHomePage.clickCompareBtn();
		mobileHomePage.switchToWindow();
		List<String> mobileComparePagePhoneList = compareProductsPage.listPhoneNames();
		softAssert.assertEquals(compareProductsPage.compareProductsPageTitle(), "COMPARE PRODUCTS", "did not match");
		Assert.assertEquals(mobileHomePhoneList, mobileComparePagePhoneList);
		softAssert.assertAll();

	}

	@AfterMethod
	public void tearDown() {

		eventFiringDriver.unregister(webEventListener);
		driver.quit();
	}

}
