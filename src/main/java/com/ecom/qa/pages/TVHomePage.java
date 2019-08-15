package com.ecom.qa.pages;

import org.openqa.selenium.By;

import com.ecom.qa.base.TestBase;

import io.qameta.allure.Step;

public class TVHomePage extends TestBase{
	
	@Step("Adding {0} TV to wishlist step")
	public void addToWishlistTV(String tvName) {
		
		String xpath = "//a[@title='"+tvName+"']/parent::h2/parent::div/child::div[@class='actions']"
				+ "/descendant::a[text()='Add to Wishlist']";
		
		driver.findElement(By.xpath(xpath)).click();
	}

}
