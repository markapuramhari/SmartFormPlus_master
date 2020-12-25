package com.cropin.testscripts;

import org.testng.annotations.Test;

import com.cropin.baseutil.BaseTest;
import com.cropin.baseutil.InitializePages;
import com.cropin.commonutils.ExcelUtil;

public class TC_Farmer_05 extends BaseTest{
	/**
	 * Description : Download BulkTemplate
	 * @author Lohith Reddy
	 */
@Test
public synchronized void testDownloadBulkTemp() {
	
	/*Fetch the data from Excel sheet*/
	String expectedDownloadMsg = ExcelUtil.getCellData(EXCELPATH, "Farmers",32,1);
	
	/*Creating object of Initialize Pages */
	InitializePages pages = new InitializePages(driver, WebActionUtil, ETO);
	
	/*Navigate to login page from company domain page */
	pages.companyDomainPage.continueToApplication(companyDomain);
	
	/*Navigate to home page from login */
	pages.loginPage.signToApplication(userName, password);
	
	/*Navigate to configuration page from home page*/
	pages.homePage.navigateToConfiguration();
	
	/*Landing on farmers page from Configuration*/
	pages.configPage.navigateToFarmers();
	
	/* Downloading the Template from Bulk Upload button*/
	pages.farmersPage.downloadTemp();
	
	/*validate the downloaded success message*/
	pages.farmersPage.validateDownloadTemp(expectedDownloadMsg);
	
	
}
}
