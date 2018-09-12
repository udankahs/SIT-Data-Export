package com.email.scripts;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;

import com.lib.ExcelLib;

/* 
 * Owner 			: Udanka H S
 * Email Id			: udanka.hs@cognizant.com
 * Department 		: QEA CRM
 * Organization		: Cognizant Technology Solutions
 */

public class SFA_Main {
	public static void main(String[] args) throws UnsupportedEncodingException {

		WebDriver driver = null;

		TestListenerAdapter tla = new TestListenerAdapter();
		TestNG testng = new TestNG();
		testng.setTestClasses(new Class[] { DataExtract.class });
		testng.addListener(tla);
		testng.run();
	}
}