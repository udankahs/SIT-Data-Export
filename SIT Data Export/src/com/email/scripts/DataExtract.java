package com.email.scripts;

import java.net.URLDecoder;

import org.testng.annotations.Test;

import com.email.pom.SFDCLogin;
import com.email.pom.performDataExtract;
import com.lib.ExcelLib;

/* 
 * Owner 			: Udanka H S
 * Email Id			: udanka.hs@cognizant.com
 * Department 		: QEA CRM
 * Organization		: Cognizant Technology Solutions
 */

public class DataExtract extends SFASuperTestNG {
	@Test
	public void getFields() throws Exception {

		String Obj;

		String JarPath = DataExtract.class.getProtectionDomain().getCodeSource().getLocation().getPath();
		String folderPath = JarPath.substring(0, JarPath.lastIndexOf("/") + 1);
		String decodedPath = URLDecoder.decode(folderPath, "UTF-8");

		String dataSheetPath = decodedPath + "Data Sheet/Data Sheet.xls";
		String sheetName = "Login";

		SFDCLogin loginPage = new SFDCLogin(driver);
		performDataExtract performDataExtract = new performDataExtract(driver);
		loginPage.login();
		int objCount = ExcelLib.getRowCountofColumn(dataSheetPath, sheetName, 3);
		System.out.println(objCount);

		for (int i = 1; i <objCount; i++) {
		Obj = ExcelLib.getCellValue(dataSheetPath, sheetName, i, 3);
		System.out.println(Obj);
		performDataExtract.performDataExtractOnEachObject(Obj);
		}
	}
}
