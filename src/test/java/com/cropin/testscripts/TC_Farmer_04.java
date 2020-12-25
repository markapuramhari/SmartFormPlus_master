package com.cropin.testscripts;

import org.testng.annotations.Test;

import com.cropin.baseutil.BaseTest;
import com.cropin.baseutil.InitializePages;
import com.cropin.commonutils.ExcelUtil;

public class TC_Farmer_04 extends BaseTest{
	/**
	 * Description : Assign user to created farmer from main grid
	 * @author Lohith Reddy
	 */
 @Test
 public synchronized void testAssignmentFarmer() throws InterruptedException {
	 	
	 	/*Fetch the data from Excel sheet*/
		String farmerName = ExcelUtil.getCellData(EXCELPATH, "Farmers",24,1);
		String assignedTo = ExcelUtil.getCellData(EXCELPATH, "Farmers",24,2);
		String expectedFarmer = ExcelUtil.getCellData(EXCELPATH, "Farmers",24,3);
		String user = ExcelUtil.getCellData(EXCELPATH, "Farmers",24,4);
		String expectedUser = ExcelUtil.getCellData(EXCELPATH, "Farmers",24,5);
		
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
			
		/*Farmer assignment from main grid */
		pages.farmersPage.assignmentMainGrid(farmerName,assignedTo);
		
		/* Validating UserName of Farmer list in main grid*/
		pages.farmersPage.validateUserInList(expectedFarmer,user, expectedUser);
		
}
}
