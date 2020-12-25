package com.cropin.pages;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.cropin.commonutils.ExcelUtil;
import com.cropin.util.WebActionUtil;

public class SubCompaniesPage {
	
		public WebDriver driver;
		public WebActionUtil WebActionUtil;
		public long ETO = 10;
		
		public SubCompaniesPage(WebDriver driver, WebActionUtil webActionUtil, long ETO) {
			super();
			this.driver = driver;
			PageFactory.initElements(driver, this);
			this.WebActionUtil = webActionUtil;
			this.ETO = ETO;
		}
		/*finding element of Sub Company title */
		@FindBy(xpath="//div[@class='title-name']")
		private WebElement titleSubCompany;
		
		/*finding element of subCompanyName*/
		@FindBy(xpath="//mat-label[text()='Sub Company Name ']/../../../input[@type='text']")
		private WebElement txtSubCompanyName;
		
		/*finding element of website*/
		@FindBy(xpath="//mat-label[text()='Website ']/../../../input[@type='text']")
		private WebElement txtWebsite;
		
		/*finding element of address*/
		@FindBy(xpath="//mat-label[text()='Address']/../../../input[@placeholder='Enter a location']")
		private WebElement txtAddress;
		
		/*finding element of save*/
		@FindBy(xpath="//div/button/span[contains(text(),'Save')]")
		private WebElement btnSave;
		
		/*finding element of Cancel*/
		@FindBy(xpath="//button/span[text()=' Cancel ']")
		private WebElement btnCancel;
		
		/*finding element of Edit*/
		@FindBy(xpath="//button/span[text()=' Edit ']")
		private WebElement btnEdit;
		
		/*Description Method for adding SubComapany data
		 * @author lohith
		 */
		public synchronized void addSubCompany(String subCompanyName,String website,String address) throws InterruptedException {
			try {
			WebActionUtil.typeText(txtSubCompanyName,subCompanyName ,"SubCompanyName type text");
			WebActionUtil.typeText(txtWebsite, website,"Website type text");
			WebActionUtil.typeText(txtAddress, address,"Address type text");
			WebActionUtil.clickOnDown_Enter("Address text");	
			WebActionUtil.clickOnElementUsingJS(btnSave,"Save Button");
			}catch(Exception e){
			WebActionUtil.error(e.getMessage());
			WebActionUtil.info("Unable to add the SubCompany");
			Assert.fail("Unable to add the SubCompany");
			}
		}
		
		/*
		 * Description Method to validate the SubCompany screen
		 * @author Lohith Reddy
		 */
		public synchronized void validateSubCompanyScreen(String expectedSubCompanyTitle) {
			try {
			WebActionUtil.waitForThePresenceOfElement(3);
			String actualSubCompanyTitle = titleSubCompany.getText();
			Assert.assertEquals(actualSubCompanyTitle,expectedSubCompanyTitle);
			WebActionUtil.pass("User varified the subCompany screen with page Title");
			} catch (Exception e) {
			WebActionUtil.info("Unable to verify the SubCompany screen");
			Assert.fail("Unable to verify the SubCompany screen");
			}	
		}
		
		/* Description Method to Cancel the SubCompany data
		 * @author Lohith Reddy
		 */
		public synchronized void cancelSubCompanyData() {
			WebActionUtil.clickOnElement(btnCancel,"Cancel data");
			WebActionUtil.info("succeesfully cancelled the SubCompany");
		}
		
		
		/* Description Method to validate Edit button
		 * @author Lohith Reddy
		 */
		public synchronized void validateEditCancelButton() {
			try {
			WebActionUtil.waitForThePresenceOfElement(3);
			Assert.assertTrue (btnEdit.isEnabled());
			Assert.assertTrue(btnCancel.isEnabled());
			WebActionUtil.pass("Edit and Cancel button are Enabled");
			} catch (Exception e) {
			WebActionUtil.info("Unable to verify Edit and Cancel Button");
			Assert.fail("Unable to verify Edit and Cancel Button");
			}	
		}
		
		/**
		 * Description Method to validate the Company URL
		 * @author Lohith Reddy
		 */
		public synchronized void validateURL(String expectedURL) {
			try {
			WebActionUtil.waitForThePresenceOfElement(3);
			String actualURL = driver.getCurrentUrl();
			Assert.assertEquals(expectedURL, actualURL);
			WebActionUtil.pass("User navigate to Company Edit Screen");
			} catch (Exception e) {
			WebActionUtil.info("Unable to verify the URL");
			Assert.fail("Unable to verify URL");
			}
		}
		
}

