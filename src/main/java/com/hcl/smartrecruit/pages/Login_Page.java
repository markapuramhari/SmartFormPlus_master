package com.hcl.smartrecruit.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hcl.smartrecruit.util.WebActionUtil;
/**
 * Description: This class implements the method for Log in to the application.
 * @author Aatish Slathia
 * 
 */
public class Login_Page {
	/**
	 * @author shreya.u@testyantra.com
	 */
	public WebDriver driver;
	public WebActionUtil WebActionUtil;
	public long ETO = 10;

	public Login_Page(WebDriver driver, long ETO, WebActionUtil WebActionUtil) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.WebActionUtil = WebActionUtil;
		this.ETO = ETO;
	}

	/*Sign in  Employee id text box*/
	@FindBy(id = "EmployeeCode")
	private WebElement txtEmployeeID;

	/*Sign in  Password id text box*/
	@FindBy(id = "Password")
	private WebElement txtPassword;

	/*Sign in  Login button*/
	@FindBy(id="SubmitButton")
	private WebElement btnLogin;

	/**
	 * Description Method for login to the  Application
	 * @author Aatish Slathia
	 * @param username
	 * @param pwd
	 *               
	 */
	
	public void signToApplication(String username, String pwd) {
		try {
			WebActionUtil.typeText(txtEmployeeID, username, " EmployeeID Text box");
			WebActionUtil.typeText(txtPassword, pwd, " Password Text box");
			WebActionUtil.actionType();
			WebActionUtil.clickOnElement(btnLogin, "Login button");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.info("Unable to Sign To Application");
			Assert.fail("Unable to Sign To Application");
		}
	}

}
