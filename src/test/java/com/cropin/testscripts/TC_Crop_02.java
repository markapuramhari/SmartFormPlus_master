package com.cropin.testscripts;

import org.testng.annotations.Test;

import com.cropin.baseutil.BaseTest;
import com.cropin.baseutil.InitializePages;
import com.cropin.commonutils.ExcelUtil;

public class TC_Crop_02 extends BaseTest {
	/**
	 * Description : Create Crop data from Add SubVariety
	 * @author Lohith Reddy
	 */
	@Test
	public synchronized void testCreateCropSubVariety(){
		
		/*Fetch the data from Excel sheet*/
		String crop = ExcelUtil.getCellData(EXCELPATH, "crop",9,1);
		String cropVariety = ExcelUtil.getCellData(EXCELPATH, "crop",9,2);
		String cropSubVariety = ExcelUtil.getCellData(EXCELPATH, "crop",9,3);
		String subVarietyShortName = ExcelUtil.getCellData(EXCELPATH, "crop",9,4);
		String expHarvestDays= ExcelUtil.getCellData(EXCELPATH, "crop",9,5);
		String location = ExcelUtil.getCellData(EXCELPATH, "crop",9,6);
		String expectedYield = ExcelUtil.getCellData(EXCELPATH, "crop",9,7);
		String expYieldUnits = ExcelUtil.getCellData(EXCELPATH, "crop",9,8);
		String refrenceAreaUnit = ExcelUtil.getCellData(EXCELPATH, "crop",9,9);
		String expectedCropURL = ExcelUtil.getCellData(EXCELPATH, "crop",9,10);
		String expectedCropSubVariety = ExcelUtil.getCellData(EXCELPATH, "crop",9,11);
		
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
		
		/*Navigate to Add SubVariety from crop main grid*/
		pages.cropPage.navigateToAddSubVariety();
		
		/*Adding mandatory crop data in Variety Information of  Add SubVariety*/
		pages.cropPage.addNewSubVarietyCrop(crop,cropVariety, cropSubVariety, subVarietyShortName, 
						expHarvestDays,location, expectedYield,expYieldUnits, refrenceAreaUnit);
		
		/* Click on Save button */
		pages.cropPage.clickOnSave();
		
		/*Validation of crop main grid URL after save*/
		pages.cropPage.validateCropURLSubVariety(expectedCropURL);
		
		/*Validation of crop SubVariety in the list of crop main grid*/
		pages.cropPage.validateCropSubVariety(crop,cropSubVariety,expectedCropSubVariety);
	
}
}



