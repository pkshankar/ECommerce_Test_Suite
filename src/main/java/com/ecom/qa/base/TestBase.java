/*@author: P K Shankar */

package com.ecom.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;

import com.ecom.qa.util.TestUtil;
import com.ecom.qa.util.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver eventFiringDriver;
	public static WebEventListener webEventListener;

	public TestBase() {

		prop = new Properties();

		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\pkshank\\eclipse-workspace\\ECommerce_Test_Suite"
					+ "\\src\\main\\java\\com\\ecom\\qa\\config\\config.properties");

			try {
				prop.load(fis);

			} catch (IOException e) {

				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

	}

	public static void initialization() {

		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\pkshank\\eclipse-workspace\\Automation_Concepts\\Browser_Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}

		else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\pkshank\\eclipse-workspace\\Automation_Concepts\\Browser_Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			
			
		}

		eventFiringDriver = new EventFiringWebDriver(driver);
		webEventListener = new WebEventListener();
		eventFiringDriver.register(webEventListener);
		driver = eventFiringDriver;
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}

}
