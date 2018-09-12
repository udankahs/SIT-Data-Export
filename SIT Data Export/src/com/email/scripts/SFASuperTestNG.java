package com.email.scripts;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.lib.ExcelLib;

/* Owner 			: Udanka H S
 * Email Id			: udanka.hs@cognizant.com
 * Department 		: QEA CRM
 * Organization		: Cognizant Technology Solutions
 */

public class SFASuperTestNG {
	public WebDriver driver;

	@BeforeMethod
	public void preCondition() throws UnsupportedEncodingException {
		String JarPath = DataExtract.class.getProtectionDomain().getCodeSource().getLocation().getPath();
		String unformattedFolderPath = JarPath.substring(0, JarPath.lastIndexOf("/") + 1);
		String folderPath = URLDecoder.decode(unformattedFolderPath, "UTF-8");

		String browser = ExcelLib.getCellValue(folderPath + "/Data Sheet/Data Sheet.xls", "Login", 1, 2);

		if (browser.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", folderPath+"/Browser Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		} 
		
		else if (browser.equals("Internet Explorer")) {
			System.setProperty("webdriver.ie.driver", folderPath+"/Browser Drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}

		else if (browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", folderPath+"/Browser Drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		else if (browser.equals("Opera")) {
			System.setProperty("webdriver.opera.driver", folderPath+"/Browser Drivers/operadriver.exe");
			driver = new OperaDriver();
		}

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void postCondition() {
		driver.quit();
	}
}
