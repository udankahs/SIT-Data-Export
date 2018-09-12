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

public class SFDCLogin {
	private WebDriver driver;

	@FindBy(id = "oauth_env")
	private WebElement Environment;

	@FindBy(id = "termsAccepted")
	private WebElement TermsAccepted;

	@FindBy(id = "loginBtn")
	private WebElement LoginBtn;

	@FindBy(id = "username")
	private WebElement unTextBox;

	@FindBy(id = "password")
	private WebElement pwTextBox;

	@FindBy(id = "Login")
	private WebElement loginButton;

	@FindBy(id = "actionJump")
	private WebElement ActionJump;

	@FindBy(xpath = "//*[@id='mainBlock']/form/input[2]")
	private WebElement Select;

	public SFDCLogin(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void login() {
		driver.get("https://workbench.developerforce.com/login.php");
		new Select(Environment).selectByVisibleText("Sandbox");
		TermsAccepted.click();
		LoginBtn.click();
		unTextBox.sendKeys("dataloader@telenetgroup.be.sittool");
		pwTextBox.sendKeys("udanka123");
		loginButton.click();
		new Select(ActionJump).selectByVisibleText("SOQL Query");
		Select.click();
	}
}
