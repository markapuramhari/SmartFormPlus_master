package com.cropin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cropin.util.WebActionUtil;

public class SetupPage {
	public WebDriver driver;
	public WebActionUtil WebActionUtil;
	public long ETO = 10;
	public SetupPage(WebDriver driver ,WebActionUtil WebActionUtil , long ETO) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.WebActionUtil = WebActionUtil;
		this.ETO = ETO;
	}
	
	/* finding element of Company */
	@FindBy(xpath="//span[text()='Company']")
	private WebElement lnkCompany;
	
	/* finding element of User Roles */
	@FindBy(xpath="//span[text()='User Roles']")
	private WebElement lnkUserRoles;
	
	/*finding element of Users */
	@FindBy(xpath="//span[text()='Users']")
	private WebElement lnkUsers;
	
	/**
	 * Description: navigate to Company
	 * @author Vinay Singh
	 */
	public synchronized void navigateToCompany() {
		WebActionUtil.waitForThePresenceOfElement(5);
		WebActionUtil.clickOnElement(lnkCompany, "Company link ");
	}
	
	/**
	 * Description: navigate To User Roles
	 * @author Vinay Singh
	 */
	
	public synchronized void navigateToUserRoles() {
		WebActionUtil.waitForThePresenceOfElement(5);
		WebActionUtil.clickOnElement(lnkUserRoles, "User Role link ");
	}
	
	/**
	 * Description:navigate to Users 
	 * @author Vinay Singh
	 */
	public synchronized void navigateToUsers() {
		WebActionUtil.waitForThePresenceOfElement(5);
		WebActionUtil.clickOnElement(lnkUsers, "User link ");
	}

}
