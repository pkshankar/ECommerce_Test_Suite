package com.ecom.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;

import com.ecom.qa.base.TestBase;

public class TestUtil extends TestBase {

	static List<String> listString;

	public static long PAGE_LOAD_TIMEOUT = 20;

	public static long IMPLICIT_WAIT = 20;

	public static String extractStringSubString(String inputString, int index) {

		return inputString.substring(index);

	}

	public static void takeScreenshotOnFailure(ITestResult result) {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src,
					new File("C:\\Users\\pkshank\\eclipse-workspace\\ECommerce_Test_Suite\\Failed_Cases_Screenshots\\"
							+ result.getMethod().getMethodName() + ".png"));
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public static List<String> sort(List<WebElement> listWebElements) {

		listString = new ArrayList<String>();

		for (WebElement w : listWebElements) {

			listString.add(w.getText());
		}

		Collections.sort(listString);

		return listString;

	}

	public static List<String> WebElementToString(List<WebElement> listWebElements) {

		listString = new ArrayList<String>();

		for (WebElement w : listWebElements) {

			listString.add(w.getText());
		}

		return listString;

	}

	public static ArrayList<String[]> readExcel(String sheetName) {

		FileInputStream fis = null;
		XSSFWorkbook wb;
		ArrayList<String[]> al = new ArrayList<String[]>();
		try {
			fis = new FileInputStream("C:\\Users\\pkshank\\eclipse-workspace"
					+ "\\ECommerce_Test_Suite\\src\\main\\java\\com\\ecom\\qa\\testdata\\TestData.xlsx");

			try {
				wb = new XSSFWorkbook(fis);
				XSSFSheet sh = wb.getSheet(sheetName);

				int lastRow = sh.getLastRowNum();
				for (int row = 1; row <= lastRow; row++) {

					String fName = sh.getRow(row).getCell(0).getStringCellValue();
					String mName = sh.getRow(row).getCell(1).getStringCellValue();
					String lName = sh.getRow(row).getCell(2).getStringCellValue();
					String eAddress = sh.getRow(row).getCell(3).getStringCellValue();
					String pwd = sh.getRow(row).getCell(4).getStringCellValue();

					al.add(new String[] { fName, mName, lName, eAddress, pwd });

				}

			} catch (IOException e) {

				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		return al;

	}

	

	public static void updateExcel(String sheetName, String msg, String searchByEmailAddress) {

		FileInputStream fis = null;
		FileOutputStream fos = null;
		XSSFWorkbook wb;

		try {
			fis = new FileInputStream("C:\\Users\\pkshank\\eclipse-workspace"
					+ "\\ECommerce_Test_Suite\\src\\main\\java\\com\\ecom\\qa\\testdata\\TestData.xlsx");

			try {
				wb = new XSSFWorkbook(fis);
				XSSFSheet sh = wb.getSheet(sheetName);
				int lastRow = sh.getLastRowNum();
				for (int row = 1; row <= lastRow; row++) {

					if (sh.getRow(row).getCell(3).getStringCellValue().equalsIgnoreCase(searchByEmailAddress)) {

						sh.getRow(row).createCell(5).setCellValue(msg);
						fos = new FileOutputStream("C:\\Users\\pkshank\\eclipse-workspace"
								+ "\\ECommerce_Test_Suite\\src\\main\\java\\com\\ecom\\qa\\testdata\\TestData.xlsx");
						wb.write(fos);
						fos.close();
						break;

					}

				}

			} catch (Exception e) {

				e.printStackTrace();
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
