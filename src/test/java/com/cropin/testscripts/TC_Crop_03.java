package com.cropin.testscripts;

import org.testng.annotations.Test;

import com.cropin.baseutil.BaseTest;
import com.cropin.baseutil.InitializePages;
import com.cropin.commonutils.ExcelUtil;

public class TC_Crop_03 extends BaseTest {
	/**
	 * Description : Create Crop data with Crop Stages, Seed Grades and Harvest Grades
	 * @author Lohith Reddy
	 */
	@Test
	public synchronized void testCreateCropSubVariety(){
		
		/*Fetch the data from Excel sheet for  Variety Information of Add variety*/
		String crop = ExcelUtil.getCellData(EXCELPATH, "crop",16,1);
		String cropVariety = ExcelUtil.getCellData(EXCELPATH, "crop",16,2);
		String varietyShortName = ExcelUtil.getCellData(EXCELPATH, "crop",16,3);
		String expHarvestDays= ExcelUtil.getCellData(EXCELPATH, "crop",16,4);
		String location = ExcelUtil.getCellData(EXCELPATH, "crop",16,5);
		String expectedYield = ExcelUtil.getCellData(EXCELPATH, "crop",16,6);
		String expYieldUnits = ExcelUtil.getCellData(EXCELPATH, "crop",16,7);
		String refrenceAreaUnit = ExcelUtil.getCellData(EXCELPATH, "crop",16,8);
		
		/*Fetch the data from Excel sheet for  Crop Stages of Add variety*/
		String cropStageName=ExcelUtil.getCellData(EXCELPATH, "crop",16,9);
		String cropStageDescription=ExcelUtil.getCellData(EXCELPATH, "crop",16,10);
		String cropStageDaysSowing=ExcelUtil.getCellData(EXCELPATH, "crop",16,11);
		
		/*Fetch the data from Excel sheet for  Seed Grades of Add variety*/
		String seedGradeName=ExcelUtil.getCellData(EXCELPATH, "crop",16,12);
		String seedGradeDescription=ExcelUtil.getCellData(EXCELPATH, "crop",16,13);
		
		/*Fetch the data from Excel sheet for Harvest Grades of Add variety*/
		String harvestGradeName=ExcelUtil.getCellData(EXCELPATH, "crop",16,14);
		String harvestGradeDescription=ExcelUtil.getCellData(EXCELPATH, "crop",16,15);
		
		String expectedCropURL = ExcelUtil.getCellData(EXCELPATH, "crop",16,16);
		
		
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
		
		/*Adding mandatory crop data in Variety Information of Add variety */
		pages.cropPage.addNewVarietyCrop(crop, cropVariety, varietyShortName, expHarvestDays,
							location, expectedYield, expYieldUnits, refrenceAreaUnit);

		/*Adding data of Crop Stages*/
		pages.cropPage.addCropStages(cropStageName, cropStageDescription, cropStageDaysSowing);
	
		/*Adding data of Seed Grades*/
		pages.cropPage.addSeedGrades(seedGradeName, seedGradeDescription);
		
		/*Adding data of HArvest Grades*/
		pages.cropPage.addHarvestGrades(harvestGradeName, harvestGradeDescription);
		
		 /*Click on Save button*/ 
		pages.cropPage.clickOnSave();
		
		/*Validation of crop main grid URL after save*/
		pages.cropPage.validateCropURLAddVariety(expectedCropURL);
	
}
}