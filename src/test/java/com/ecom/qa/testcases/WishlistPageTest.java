package com.ecom.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.ecom.qa.base.TestBase;
import com.ecom.qa.pages.MobileHomePage;
import com.ecom.qa.pages.RegistrationHomePage;
import com.ecom.qa.pages.TVHomePage;
import com.ecom.qa.pages.UserHomePage;
import com.ecom.qa.pages.WishlistPage;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class WishlistPageTest extends TestBase {

	MobileHomePage mobileHomePage;
	RegistrationHomePage registrationHomePage;
	UserHomePage userHomePage;
	TVHomePage tvHomePage;
	WishlistPage wishlistPage;

	public WishlistPageTest() {

		super();
	}

	@BeforeMethod
	public void setUp() {

		initialization();
		mobileHomePage = new MobileHomePage();
		mobileHomePage.clickMyAccountLink();
		registrationHomePage = new RegistrationHomePage();
		registrationHomePage.loginToWebsite("a23@email.com", "yulbat456"); // THIS CAN BE READ FROM EXCEL BUT THAT IS NOT THE
																		// PURPOSE OF THIS TEST CASE
		userHomePage = new UserHomePage();
		userHomePage.clickTvLink();
		tvHomePage = new TVHomePage();
		tvHomePage.addToWishlistTV("LG LCD");
		wishlistPage = new WishlistPage();

	}

	@Test(priority = 1, description = "Verify wishlist share feature")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description: Verify that user is able to share wishlist")
	@Story("Story Name: To check wishlist share feature")
	public void wishlistSharedTest() {

		wishlistPage.clickShareWishlist();
		wishlistPage.enterEmailIdMsg("abc@email.com", "TRY THIS OUT");
		wishlistPage.clickShareWishlist();
		Assert.assertEquals(wishlistPage.wishListSharedMsg(), "Your Wishlist has been shared.");
	}

	@AfterMethod
	public void tearDown() {

		eventFiringDriver.unregister(webEventListener);
		driver.quit();
	}

}
