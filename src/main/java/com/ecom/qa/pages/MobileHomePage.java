package com.ecom.qa.pages;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.ecom.qa.base.TestBase;
import com.ecom.qa.util.TestUtil;

import io.qameta.allure.Step;

public class MobileHomePage extends TestBase {

	Select selectDropdown;

	@FindBy(xpath = "(//select[@title='Sort By'])[1]")
	WebElement selectName;

	@FindBy(xpath = "//h2[@class='product-name']/a")
	List<WebElement> listPhonesNames;

	@FindBy(xpath = "//button[@title='Compare']")
	WebElement compareBtn;

	@FindBy(xpath = "//p[@class='product-name']/a")
	List<WebElement> homePagePhoneNames;

	@FindBy(xpath = "(//a[@title='My Account'])[2]")
	WebElement myAccountLink;

	public MobileHomePage() {

		PageFactory.initElements(driver, this);
	}

	public String mobilePageTitle() {

		return driver.getTitle();
	}

	public Select listDropDownValues() {

		selectDropdown = new Select(selectName);

		return selectDropdown;
	}

	public List<WebElement> listPhoneNames() {

		return listPhonesNames;

	}

	public String phonePrice(String phoneName) {

		Map<String, String> map = new HashMap<String, String>();

		List<WebElement> listPhoneName = driver.findElements(By.xpath("//h2[@class='product-name']/a"));

		List<String> sListPhoneName = TestUtil.WebElementToString(listPhoneName);

		List<WebElement> wPhonePrice = driver
				.findElements(By.xpath("//h2[@class='product-name']/following-sibling::div/span/span |"
						+ " //h2[@class='product-name']/following-sibling::div/p[@class='special-price']/span[@class='price']"));

		List<String> sListPhonePrice = TestUtil.WebElementToString(wPhonePrice);

		for (int i = 0; i < sListPhoneName.size(); i++) {

			map.put(sListPhoneName.get(i), sListPhonePrice.get(i));

		}

		return map.get(phoneName);

	}

	public MobileDetailPage clickMobileName(String phoneName) {

		String bXpath = "//h2[@class='product-name']/a[text()='";
		String aXpath = "']";
		String xpath = bXpath + phoneName + aXpath;

		driver.findElement(By.xpath(xpath)).click();

		return new MobileDetailPage();

	}

	public ShoppingCartPage checkMaxItemsCart(String phoneName) {

		String bXpath = "//a[@title='";
		String aXpath = "']/following-sibling::div/child::div[@class='actions']/child::button";
		String xpath = bXpath + phoneName + aXpath;

		driver.findElement(By.xpath(xpath)).click();
		return new ShoppingCartPage();
	}

	public void addToCompareFeature(String phoneName1, String phoneName2) {

		driver.findElement(
				By.xpath("//a[@title='" + phoneName1 + "']/following-sibling::div/child::div[@class='actions']"
						+ "/child::ul/descendant::span/following-sibling::a"))
				.click();

		driver.findElement(
				By.xpath("//a[@title='" + phoneName2 + "']/following-sibling::div/child::div[@class='actions']"
						+ "/child::ul/descendant::span/following-sibling::a"))
				.click();

	}

	public void clickCompareBtn() {

		compareBtn.click();

	}

	public void switchToWindow() {

		/* Switch to window can be added in test util class - will try that later */

		Set<String> windowHandles = driver.getWindowHandles();

		Iterator<String> itr = windowHandles.iterator();

		itr.next();

		String childWindowId = itr.next();

		driver.switchTo().window(childWindowId);

	}

	public List<String> homeListPhoneNames() {

		return TestUtil.sort(homePagePhoneNames);
	}

	public void clickMyAccountLink() {

		myAccountLink.click();
	}
}
