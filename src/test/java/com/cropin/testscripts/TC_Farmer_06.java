package com.cropin.testscripts;

import org.testng.annotations.Test;

import com.cropin.baseutil.BaseTest;
import com.cropin.baseutil.InitializePages;
import com.cropin.commonutils.ExcelUtil;

public class TC_Farmer_06 extends BaseTest{
	/**
	 * Description : Upload Bulk Template 
	 * @author Lohith Reddy
	 */
@Test
public synchronized void testUploadBulkTemp() {
	
	/*Fetch the data from Excel sheet*/
	String filePath = ExcelUtil.getCellData(EXCELPATH, "Farmers",39,1);
	String expectedUploadMsg = ExcelUtil.getCellData(EXCELPATH, "Farmers",39,2);
	String duplicateTempFilePath = ExcelUtil.getCellData(EXCELPATH, "Farmers",41,1);
	String expectedDuplicateUploadMsg = ExcelUtil.getCellData(EXCELPATH, "Farmers",41,2);
	String noMandatoryTempFilePath = ExcelUtil.getCellData(EXCELPATH, "Farmers",43,1);
	String expectedNoMandatoryUploadMsg = ExcelUtil.getCellData(EXCELPATH, "Farmers",43,2);
	
	/* Creating object of Initialize Pages */
	InitializePages pages = new InitializePages(driver, WebActionUtil, ETO);
	
	/* Navigate to login page from company domain page */
	pages.companyDomainPage.continueToApplication(companyDomain);
	
	/* Navigate to home page from login */
	pages.loginPage.signToApplication(userName, password);
	
	/* Navigate to configuration page from home page */
	pages.homePage.navigateToConfiguration();
	
	/* Landing on farmers page from Configuration */
	pages.configPage.navigateToFarmers();
	
	/* Uploading the Template from Bulk Upload button */
	pages.farmersPage.uploadTemp(filePath);
	
	/* Validate the Uploaded Template */
	pages.farmersPage.validateUploadTemp(expectedUploadMsg);
	
	/* Landing on farmers page from Configuration */
	pages.configPage.navigateToFarmers();
	
	/*Uploading the duplicate Template from Bulk Upload button*/
	pages.farmersPage.uploadTemp(duplicateTempFilePath);
	
	/* Validate the Uploaded Duplicate Template */
	pages.farmersPage.validateDuplicateTemp(expectedDuplicateUploadMsg);
	
	/* Landing on farmers page from Configuration */
	pages.configPage.navigateToFarmers();
	
	/*Uploading the Template with out mandatory field from Bulk Upload button*/
	pages.farmersPage.uploadTemp(noMandatoryTempFilePath);
	
	/* Validate the Uploaded Template with out mandatory field msg */
	pages.farmersPage.validateWithOutMandatoryTemp(expectedNoMandatoryUploadMsg);
	
}
}
