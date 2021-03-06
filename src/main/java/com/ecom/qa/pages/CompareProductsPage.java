package com.ecom.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecom.qa.base.TestBase;
import com.ecom.qa.util.TestUtil;

import io.qameta.allure.Step;

public class CompareProductsPage extends TestBase {

	TestUtil testUtil = new TestUtil();

	@FindBy(xpath = "//div[@class='page-title title-buttons']/h1")
	WebElement compareProductsPageTitle;

	@FindBy(xpath = "//h2[@class='product-name']/a")
	List<WebElement> wListPhoneName;

	public CompareProductsPage() {

		PageFactory.initElements(driver, this);
	}

	public String compareProductsPageTitle() {

		return compareProductsPageTitle.getText();
	}

	public List<String> listPhoneNames() {

		return TestUtil.sort(wListPhoneName);
	}

	public void closeComparePopUp() {

		driver.close();
	}

}
