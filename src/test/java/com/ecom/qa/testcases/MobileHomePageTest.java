package com.ecom.qa.testcases;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.ecom.qa.base.TestBase;
import com.ecom.qa.pages.ApplicationHomePage;
import com.ecom.qa.pages.MobileDetailPage;
import com.ecom.qa.pages.MobileHomePage;
import com.ecom.qa.pages.ShoppingCartPage;
import com.ecom.qa.util.TestUtil;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class MobileHomePageTest extends TestBase {

	SoftAssert softAssert = new SoftAssert();
	MobileHomePage mobileHomePage;
	ApplicationHomePage appHomePage;
	MobileDetailPage mobileDetailPage;
	ShoppingCartPage shoppingCartPage;

	public MobileHomePageTest() {

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
	}

	@Test(priority = 1, description = "Validate mobile page title")

	public void mobilePageTitleTest() {

		Assert.assertEquals(mobileHomePage.mobilePageTitle(), "Mobile");

	}

	@Test(priority = 2, description = "Verify mobile name sorting feature")

	public void validateMobileNameSortTest() {

		List<WebElement> nameListUnsorted = mobileHomePage.listPhoneNames();

		Select selectDD = mobileHomePage.listDropDownValues();

		selectDD.selectByVisibleText("Name");

		List<WebElement> wActualNameListSorted = mobileHomePage.listPhoneNames();

		Assert.assertEquals(TestUtil.WebElementToString(wActualNameListSorted), TestUtil.sort(nameListUnsorted));

	}

	@Test(priority = 3, description = "Verify mobile price")

	public void phonePriceTest() {

		String sHomePageMobilePrice = mobileHomePage.phonePrice("SONY XPERIA");

		mobileHomePage.clickMobileName("Sony Xperia");

		String sDetailPageMobilePrice = mobileDetailPage.detailPagePhonePrice();

		Assert.assertEquals(sHomePageMobilePrice, sDetailPageMobilePrice);

	}

	@Test(priority = 4, description = "Verify error message when items in cart exceed maximum permissible limit")

	public void checkMaxItemsCartTest() {

		shoppingCartPage = mobileHomePage.checkMaxItemsCart("Samsung Galaxy");

		String actErrorMsg = shoppingCartPage.checkMaxItemsCartTest("1000");

		String expErrorMsg = "* The maximum quantity allowed for purchase is 500.";

		softAssert.assertEquals(actErrorMsg, expErrorMsg);

		String actEmptyCartMsg = shoppingCartPage.emptyCartMessage();

		String expEmptyCartMsg = "SHOPPING CART IS EMPTY";

		Assert.assertEquals(actEmptyCartMsg, expEmptyCartMsg);

		softAssert.assertAll();

	}

	@AfterMethod
	public void tearDown() {

		eventFiringDriver.unregister(webEventListener);
		driver.quit();
	}
}
