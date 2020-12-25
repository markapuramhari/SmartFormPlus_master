package com.cropin.testscripts;

import org.testng.annotations.Test;

import com.cropin.baseutil.BaseTest;
import com.cropin.baseutil.InitializePages;
import com.cropin.commonutils.ExcelUtil;

public class TC_Crop_04 extends BaseTest {
	/**
	 * Description : Create plan for crop 
	 * @author Lohith Reddy
	 */
	@Test
	public synchronized void testCreateCropVariety(){
		
		/*Fetch the data from Excel sheet*/
		String crop = ExcelUtil.getCellData(EXCELPATH, "crop",23,1);
		String cropVariety = ExcelUtil.getCellData(EXCELPATH, "crop",23,2);
		String planName = ExcelUtil.getCellData(EXCELPATH, "crop",23,3);
		String planType = ExcelUtil.getCellData(EXCELPATH, "crop",23,4);
		String expectedPackagePlansURL=ExcelUtil.getCellData(EXCELPATH, "crop",23,5);
		
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
		
		/*Navitage to plan icon in crop main grid under Actions*/
		pages.cropPage.navigateToAddPlan(crop, cropVariety);
		
		/* Add Information data i.e Plan Type for Crop*/
		pages.cropPage.addPlanInformation(planName, planType);
		
		/*Validation of Package of Plans URL*/
		pages.cropPage.validatePackagePlansURL(expectedPackagePlansURL);
}
}
