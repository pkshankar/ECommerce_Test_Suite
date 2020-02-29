package com.ecom.qa.testcases;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ecom.qa.base.TestBase;
import com.ecom.qa.pages.ApplicationHomePage;
import com.ecom.qa.pages.RegistrationDetailPage;
import com.ecom.qa.pages.RegistrationHomePage;
import com.ecom.qa.pages.UserHomePage;
import com.ecom.qa.util.TestUtil;

public class RegistrationDetailPageTest extends TestBase {

	SoftAssert softAssert = new SoftAssert();
	ApplicationHomePage applicationHomePage;
	RegistrationHomePage registrationHomePage;
	RegistrationDetailPage registrationDetailPage;
	UserHomePage userHomePage;

//	public RegistrationDetailPageTest() {
//
//		super();
//	}

	@BeforeMethod
	public void setup() {

		initialization();
		applicationHomePage = new ApplicationHomePage();
		registrationHomePage = new RegistrationHomePage();
		registrationDetailPage = new RegistrationDetailPage();
		userHomePage = new UserHomePage();
		applicationHomePage.clickMyAccountLink();
		registrationHomePage.clickCreateAccountLink();

	}

	@DataProvider
	public Iterator<String[]> getTestData() {

		ArrayList<String[]> rcvdData = TestUtil.readExcel("RegDetails");
		return rcvdData.iterator();
	}

	@Test(dataProvider = "getTestData")
	public void userRegistrationTest(String firstName, String middleName, String lastName, String emailAddress,
			String password) {

		registrationDetailPage.createAccount(firstName, middleName, lastName, emailAddress, password);

		Assert.assertEquals(userHomePage.getRegistrationMsg(),
				"Thank you for registering with Main Website Store.");

		TestUtil.updateExcel("RegDetails", "Registration successful for " + firstName, emailAddress);

	}

	@AfterMethod
	public void tearDown() {

		eventFiringDriver.unregister(webEventListener);
		driver.quit();
	}

}
