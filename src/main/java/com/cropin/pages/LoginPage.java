package com.cropin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.cropin.baseutil.BaseTest;
import com.cropin.util.WebActionUtil;

public class LoginPage {
	public WebDriver driver;
	public WebActionUtil WebActionUtil;
	public long ETO = 10;

	public LoginPage(WebDriver driver,WebActionUtil WebActionUtil, long ETO) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.WebActionUtil = WebActionUtil;
		this.ETO = ETO;
	}

	/*Sign in  username text box*/
	@FindBy(id = "username")
	private WebElement txtUserName;

	/*Sign in  Password id text box*/
	@FindBy(id = "password")
	private WebElement txtPassword;

	/*Sign in  Login button*/
	@FindBy(name="login")
	private WebElement btnLogin;

	/**
	 * Description Method for login to the  Application
	 * @author Aatish Slathia
	 * @param username
	 * @param pwd
	 *               
	 */
	
	public synchronized void signToApplication(String username, String password) {
		try {
			//WebActionUtil.info("URL of the application is "+BaseTest.URL);
			WebActionUtil.typeText( txtUserName, username, " Username Text box");
			WebActionUtil.typeText(txtPassword, password, " Password Text box");
			WebActionUtil.clickOnElement(btnLogin, "Login button");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.info("Unable to Sign To Application");
			Assert.fail("Unable to Sign To Application");
		}
	}

	
}
