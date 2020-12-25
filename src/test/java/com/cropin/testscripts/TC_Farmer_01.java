package com.cropin.testscripts;

import org.testng.annotations.Test;

import com.cropin.baseutil.BaseTest;
import com.cropin.baseutil.InitializePages;
import com.cropin.commonutils.ExcelUtil;

public class TC_Farmer_01 extends BaseTest{
	/**
	 * Description : Create farmer
	 * @author Lohith Reddy
	 */
 @Test
 public synchronized void testAddFarmer() throws InterruptedException {
	 
	 	/*Fetch the data from Excel sheet*/
		String farmerName = ExcelUtil.getCellData(EXCELPATH, "Farmers",2,1);
		String farmerCode = ExcelUtil.getCellData(EXCELPATH, "Farmers",2,2);
		String iSD = ExcelUtil.getCellData(EXCELPATH, "Farmers",2,3);
		String mobileNo = ExcelUtil.getCellData(EXCELPATH, "Farmers",2,4);
		String assignedTo = ExcelUtil.getCellData(EXCELPATH, "Farmers",2,5);
		String address = ExcelUtil.getCellData(EXCELPATH, "Farmers",2,6);
		String imgPath = ExcelUtil.getCellData(EXCELPATH, "Farmers",2,7);
		String expectedURL=ExcelUtil.getCellData(EXCELPATH, "Farmers",2,8);
		String expectedfarmer=ExcelUtil.getCellData(EXCELPATH, "Farmers",2,1);
		String farmer = ExcelUtil.getCellData(EXCELPATH, "Farmers",2,1);
		
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
		
		/*Navigate to new farmer from Farmers main grid*/
		pages.farmersPage.navigateToAddNewFarmer();
		
		/* Add the mandatory data to new Farmer*/
		pages.farmersPage.addFarmer(imgPath, farmerName, farmerCode, iSD, mobileNo, assignedTo, address);
		
		/* Validating the profile Picture*/
		pages.farmersPage.validateImage();
		
		/* Validating after saving tab close */
		pages.farmersPage.validateFarmerURL(expectedURL);
		
		/* Validating farmer link*/
		pages.farmersPage.validateFarmerInList(farmer, expectedfarmer);
}
}
