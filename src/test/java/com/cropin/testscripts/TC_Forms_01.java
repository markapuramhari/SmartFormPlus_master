package com.cropin.testscripts;

import org.testng.annotations.Test;

import com.cropin.baseutil.BaseTest;
import com.cropin.baseutil.InitializePages;
import com.cropin.commonutils.ExcelUtil;

public class TC_Forms_01 extends BaseTest{
	
	/**
	 * Description : Create Crop data from Add SubVariety
	 * @author Lohith Reddy
	 */
	@Test
	public synchronized void testAddForms(){
		
		/*Fetch the data from Excel sheet*/
		String formName = ExcelUtil.getCellData(EXCELPATH, "Forms",2,1);
		String expectedFormType = ExcelUtil.getCellData(EXCELPATH, "Forms",2,2);
		String expectedURL = ExcelUtil.getCellData(EXCELPATH, "Forms",2,3);
		String expectedForm = ExcelUtil.getCellData(EXCELPATH, "Forms",2,4);
		
		
		
		
		/*Creating object of Initialize Pages */
		InitializePages pages = new InitializePages(driver, WebActionUtil, ETO);
		
		/*Navigate to login page from company domain page */
		pages.companyDomainPage.continueToApplication(companyDomain);
		
		/*Navigate to home page from login */
		pages.loginPage.signToApplication(userName, password);
		
		/*Navigate to configuration page from home page*/
		pages.homePage.navigateToConfiguration();
		
		/*navigate to forms */
		pages.configPage.navigateToForms();
		
		/* add forms*/
		pages.formsPage.addForms(formName, expectedFormType);
		
		/*validate of URL*/
		pages.formsPage.validateURL(expectedURL);
		
		/*validate of forms*/
		pages.formsPage.validateForm(formName, expectedForm);
		
		
	}
		

}
