package com.email.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/* Owner 			: Udanka H S
 * Email Id			: udanka.hs@cognizant.com
 * Department 		: QEA CRM
 * Organization		: Cognizant Technology Solutions
 */

public class performDataExtract {
	private WebDriver driver;

	@FindBy(id = "QB_object_sel")
	private WebElement ObjectPickList;

	@FindBy(id = "QB_field_sel")
	private WebElement FieldSelect;

	@FindBy(xpath = "//*[@id='query_form']/table/tbody/tr[3]/td[1]/input")
	private WebElement Query;

	@FindBy(id = "export_action_async_csv")
	private WebElement CSVradio;

	@FindBy(xpath = ".//*[@id='mainBlock']/table[3]/tbody/tr[2]/td[1]/a/img")
	private WebElement Download;
	
	@FindBy(xpath = "//*[@id='nav']/li[3]/a/span")
	private WebElement QueryDropDown;
	
	@FindBy(xpath = "//*[@id='nav']/li[3]/ul/li[1]/a")
	private WebElement SOQLquery;
	
	public performDataExtract(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void performDataExtractOnEachObject (String Obj) throws InterruptedException {
		Thread.sleep(1000);
		new Select(ObjectPickList).selectByVisibleText(Obj);
		CSVradio.click();
		int size = new Select(FieldSelect).getOptions().size();
		System.out.println("Number of Options: " + size);
		for (int i = 1; i < size; i++) {
			new Select(FieldSelect).selectByIndex(i);
		}
		Query.click();
		Thread.sleep(5000);
		Download.click();
		QueryDropDown.click();
		SOQLquery.click();
	}
}
