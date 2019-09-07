package com.ecom.qa.testcases;

import org.testng.TestNG;

public class TestRunner {

	static TestNG testNg;

	public static void main(String[] args) {

		testNg = new TestNG();
		testNg.setTestClasses(new Class[] { ApplicationHomePageTest.class, BillingInformationPageTest.class,
				CompareProductsPageTest.class, MobileHomePageTest.class, RegistrationDetailPageTest.class,
				ShoppingCartPageTest.class, WishlistPageTest.class });
		testNg.run();

	}

}
