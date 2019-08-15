package com.ecom.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ecom.qa.base.TestBase;
import com.ecom.qa.pages.ApplicationHomePage;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class ApplicationHomePageTest extends TestBase {

	ApplicationHomePage appHomePage;

	public ApplicationHomePageTest() {

		super();

	}

	@BeforeMethod
	public void setUp() {

		initialization();
		appHomePage = new ApplicationHomePage();
	}

	@Test(priority=1, description="Verify home page title test")
	@Severity(SeverityLevel.MINOR)
	@Description("Test Case Description: Verify title of home page")
	@Story("Story Name: To check home page title")
	public void appHomePageTitleTest() {

		Assert.assertEquals(appHomePage.appHomePageTitle(), "Home page");

	}

	@AfterMethod
	public void tearDown() {

		eventFiringDriver.unregister(webEventListener);
		driver.quit();
		
	}

}
