package com.cropin.testscripts;

import org.testng.annotations.Test;

import com.cropin.baseutil.BaseTest;
import com.cropin.baseutil.InitializePages;
import com.cropin.commonutils.ExcelUtil;

public class TC_Crop_01 extends BaseTest {
	
	/**
	 * Description : Create Crop data from Add Variety
	 * @author Lohith Reddy
	 */
	@Test
	public synchronized void testCreateCropVariety(){
		
		/*Fetch the data from Excel sheet*/
		String crop = ExcelUtil.getCellData(EXCELPATH, "crop",2,1);
		String cropVariety = ExcelUtil.getCellData(EXCELPATH, "crop",2,2);
		String varietyShortName = ExcelUtil.getCellData(EXCELPATH, "crop",2,3);
		String expHarvestDays= ExcelUtil.getCellData(EXCELPATH, "crop",2,4);
		String location = ExcelUtil.getCellData(EXCELPATH, "crop",2,5);
		String expectedYield = ExcelUtil.getCellData(EXCELPATH, "crop",2,6);
		String expYieldUnits = ExcelUtil.getCellData(EXCELPATH, "crop",2,7);
		String refrenceAreaUnit = ExcelUtil.getCellData(EXCELPATH, "crop",2,8);
		String expectedCropURL = ExcelUtil.getCellData(EXCELPATH, "crop",2,9);
		String expectedCropVariety = ExcelUtil.getCellData(EXCELPATH, "crop",2,10);
		
		/*Creating object of Initialize Pages */
		InitializePages pages = new InitializePages(driver, WebActionUtil, ETO);
		
		/*Navigate to login page from company domain page */
		pages.companyDomainPage.continueToApplication(companyDomain);
		
		/*Navigate to home page from login */
		pages.loginPage.signToApplication(userName, password);
		
		/*Navigate to configuration page from home page*/
		pages.homePage.navigateToConfiguration();
		
		/*Navigate to crop from configuration page*/
		pages.configPage.navigateToCrop();
		
		/*Navigate to Add variety from crop main grid*/
		pages.cropPage.navigateToAddVariety();
		
		/*Adding mandatory crop data in Variety Information of Add variety*/
		pages.cropPage.addNewVarietyCrop(crop, cropVariety, varietyShortName, expHarvestDays,
				 location, expectedYield, expYieldUnits, refrenceAreaUnit);
		
		/* Click on Save button */
		pages.cropPage.clickOnSave();
		
		/*Validation of crop main grid URL after save*/
		pages.cropPage.validateCropURLAddVariety(expectedCropURL);
		
		/*Validation of crop variety in the list of crop main grid*/
		pages.cropPage.validateCropVariety(crop,cropVariety, expectedCropVariety);
	
}
}
