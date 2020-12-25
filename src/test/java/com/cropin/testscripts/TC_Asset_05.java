package com.cropin.testscripts;

import org.testng.annotations.Test;

import com.cropin.baseutil.BaseTest;
import com.cropin.baseutil.InitializePages;
import com.cropin.commonutils.ExcelUtil;

public class TC_Asset_05 extends BaseTest{

	/**
	 * Description : Create farmer
	 * @author Lohith Reddy
	 */
 @Test
 public synchronized void testAddAsset() {
	 
	 /*Fetch the data from Excel sheet*/
	String filePath = ExcelUtil.getCellData(EXCELPATH, "Assets",31,1);
	String expectedUploadMsg = ExcelUtil.getCellData(EXCELPATH, "Assets",31,2);
	String duplicateTempFilePath = ExcelUtil.getCellData(EXCELPATH, "Assets",33,1);
	String expectedDuplicateUploadMsg = ExcelUtil.getCellData(EXCELPATH, "Assets",33,2);
	String noMandatoryTempFilePath = ExcelUtil.getCellData(EXCELPATH, "Assets",35,1);
	String expectedNoMandatoryMsg = ExcelUtil.getCellData(EXCELPATH, "Assets",35,2);

	/*Creating object of Initialize Pages */
	InitializePages pages = new InitializePages(driver, WebActionUtil, ETO);
	
	/*Navigate to login page from company domain page */
	pages.companyDomainPage.continueToApplication(companyDomain);
	
	/*Navigate to home page from login */
	pages.loginPage.signToApplication(userName, password);
	
	/*Navigate to configuration page from home page*/
	pages.homePage.navigateToConfiguration();
	
	/*Navigate to Assets page from Configuration page*/
	pages.configPage.navigateToAssets();
	
	/*Uploading the duplicate Template from Bulk Upload button*/
	pages.assetsPage.uploadTemp(filePath);
	
	/* Validate the Uploaded Template */
	pages.assetsPage.validateUploadTemp(expectedUploadMsg);
	
	/* Landing on farmers page from Configuration */
	pages.configPage.navigateToAssets();
	
	/*Uploading the duplicate Template from Bulk Upload button*/
	pages.assetsPage.uploadTemp(duplicateTempFilePath);
	
	/* Validate the Uploaded Duplicate Template */
	pages.assetsPage.validateDuplicateTemp(expectedDuplicateUploadMsg);
	
	/* Landing on farmers page from Configuration */
	pages.configPage.navigateToAssets();
	
	/*Uploading the Template with out mandatory field from Bulk Upload button*/
	pages.assetsPage.uploadTemp(noMandatoryTempFilePath);
	
	/* Validate the Uploaded Template with out mandatory field msg */
	pages.assetsPage.validateWithOutMandatoryTemp(expectedNoMandatoryMsg);
	
 
 }
 }