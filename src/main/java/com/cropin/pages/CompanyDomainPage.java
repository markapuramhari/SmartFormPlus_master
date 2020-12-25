package com.cropin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.cropin.baseutil.BaseTest;
import com.cropin.util.WebActionUtil;

public class CompanyDomainPage {
	public WebDriver driver;
	public WebActionUtil WebActionUtil;
	public long ETO = 10;
	public CompanyDomainPage(WebDriver driver, WebActionUtil WebActionUtil, long ETO) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.WebActionUtil = WebActionUtil;
		this.ETO = ETO;
	}
	
	/* Company Domain input element */
	@FindBy(name="domainName")
	private WebElement txtCompanyDomain;
	
	/* Company Domain input element */
	@FindBy(xpath="//button/span[text()=' Continue ']")
	private WebElement btnContinue;
	
	
	
	
	public synchronized void continueToApplication(String companyDomain) {
		try {
		
			WebActionUtil.info("URL of the application is "+BaseTest.URL);
		    WebActionUtil.typeText(txtCompanyDomain, companyDomain, " CompanyDomain Text box");
			WebActionUtil.clickOnElement(btnContinue, "Continue button");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.info("Unable to Continue To Application");
			Assert.fail("Unable to Sign To Application");
		}
	}

}
