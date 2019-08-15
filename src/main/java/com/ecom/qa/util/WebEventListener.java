package com.ecom.qa.util;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.ecom.qa.base.TestBase;

public class WebEventListener extends TestBase implements WebDriverEventListener {
	
	/* OVERRIDDEN METHODS OF WEBDRIVER EVENT LISTENER */

	
	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("Before navigating to: '" + url + "'");
		
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("Navigated to: '" + url + "'");
		
	}

	public void beforeNavigateBack(WebDriver driver) {
		System.out.println("Before navigating back from: '"+ driver.getCurrentUrl() +"'");
		
	}

	public void afterNavigateBack(WebDriver driver) {
		System.out.println("After navigating back, now on: '"+ driver.getCurrentUrl() +"'");
		
	}

	public void beforeNavigateForward(WebDriver driver) {
		System.out.println("Before navigating forward from: '"+ driver.getCurrentUrl() +"'");
		
	}

	public void afterNavigateForward(WebDriver driver) {
		System.out.println("After navigating forward, now on: '"+ driver.getCurrentUrl() +"'");
		
	}

	
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Finding element by: " +by.toString());
				
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Found Element By : " + by.toString());
		
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.println("About to click on: "+ element.toString());
		
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println("Clicked on: "+ element.toString());
		
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		System.out.println("Value of :" + element.toString() + " before any changes made");
		
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		System.out.println("Element value changed to: " + element.toString());
		
	}

	
	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		System.out.println("Before switching to window: " + windowName);
		
	}

	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		System.out.println("After switching to window: " + windowName);
		
	}

	public void onException(Throwable throwable, WebDriver driver) {
		System.out.println("Exception occured: " + throwable.getMessage());
		
	}

	
	public void beforeGetText(WebElement element, WebDriver driver) {
		System.out.println("About to get text of element: " + element.toString());
		
	}

	public void afterGetText(WebElement element, WebDriver driver, String text) {
		System.out.println("Found text of element: " + element.toString());
		
	}
	
	
	/* NON OVERRIDDEN METHODS OF WEBDRIVER EVENT LISTENER */
	
	public void beforeAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}
	
	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}
	
	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}
	
	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		// TODO Auto-generated method stub
		
	}

	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		// TODO Auto-generated method stub
		
	}





}
