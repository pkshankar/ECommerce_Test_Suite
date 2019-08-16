package com.ecom.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.ecom.qa.base.TestBase;

import io.qameta.allure.Step;

public class BillingInformationPage extends TestBase {

	@FindBy(id = "billing:street1")
	WebElement address;

	@FindBy(id = "billing:city")
	WebElement city;

	@FindBy(id = "billing:telephone")
	WebElement telephone;

	@FindBy(xpath = "(//button[@title='Continue'])[1]")
	public WebElement continueBtn;

	@FindBy(xpath = "(//select[@title='State/Province'])[1]")
	WebElement stateDropdown;

	@FindBy(xpath = "(//input[@title='Zip'])[1]")
	WebElement zip;

	/***************************************************************************/

	public BillingInformationPage() {

		PageFactory.initElements(driver, this);
	}

	/***************************************************************************/
	@Step("Entering billing information step")
	public void enterBillingInformation(String adrs, String cty, String ste, String zipc, String tphone) {

		address.clear();
		address.sendKeys(adrs);
		city.clear();
		city.sendKeys(cty);
		Select sel = new Select(stateDropdown);
		sel.selectByVisibleText(ste);
		zip.clear();
		zip.sendKeys(zipc);
		telephone.clear();
		telephone.sendKeys(tphone);
		continueBtn.click();

	}

}
