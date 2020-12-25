package com.cropin.testscripts;

import org.testng.annotations.Test;

import com.cropin.baseutil.BaseTest;
import com.cropin.baseutil.InitializePages;
import com.cropin.commonutils.ExcelUtil;

public class TC_Asset_01 extends BaseTest{

	/**
	 * Description : Create farmer
	 * @author Lohith Reddy
	 */
 @Test
 public synchronized void testAddAsset() {
	 
	 /*Fetch the data from Excel sheet*/
	String imgPath = ExcelUtil.getCellData(EXCELPATH, "Assets",2,1);
	String assetName = ExcelUtil.getCellData(EXCELPATH, "Assets",2,2);
	String belongsTo = ExcelUtil.getCellData(EXCELPATH, "Assets",2,3);
	String soilType = ExcelUtil.getCellData(EXCELPATH, "Assets",2,4);
	String irrigationType = ExcelUtil.getCellData(EXCELPATH, "Assets",2,5);
	String declaredArea = ExcelUtil.getCellData(EXCELPATH, "Assets",2,6);
	String address = ExcelUtil.getCellData(EXCELPATH, "Assets",2,7);
	String expectedURL = ExcelUtil.getCellData(EXCELPATH, "Assets",2,8);
	String expectedAssetName = ExcelUtil.getCellData(EXCELPATH, "Assets",2,9);
	
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
	
	/*Navigate to new Asset from Asset main grid*/
	pages.assetsPage.navigateToAddNewAsset();
	
	/* Add the mandatory data to new Asset*/
	pages.assetsPage.addAsset(imgPath, assetName, declaredArea, belongsTo, soilType, irrigationType, address);

	/* Validating the profile Picture*/
	pages.assetsPage.validateImage();
	
	/* Validating that after saving tab should close and lead to main grid */
	pages.assetsPage.validateAssetURL(expectedURL);
	
	/* Validating farmer link*/
	pages.assetsPage.validateAssetInList(assetName, expectedAssetName);
 
}
}
