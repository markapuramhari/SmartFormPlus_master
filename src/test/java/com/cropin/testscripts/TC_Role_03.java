package com.cropin.testscripts;

import org.testng.annotations.Test;

import com.cropin.baseutil.BaseTest;
import com.cropin.baseutil.InitializePages;
import com.cropin.commonutils.ExcelUtil;

import org.testng.Assert;

public class TC_Role_03 extends BaseTest{
	/**
	 * 
	 * @author Vinay Singh
	 */
	
	@Test
	public synchronized void testSearchAndDelete() {
		
		/*creating object of Initialize Pages */
		InitializePages pages = new InitializePages(driver, WebActionUtil, ETO);
		
		/*read data from excel */
		String searchRole = ExcelUtil.getCellData(EXCELPATH, "Setup", 9, 1);
		String expectedUserRole = ExcelUtil.getCellData(EXCELPATH, "Setup", 9, 2);
		String expectedStatus= ExcelUtil.getCellData(EXCELPATH, "Setup", 9, 3);
	    String expectedMsg= ExcelUtil.getCellData(EXCELPATH, "Setup", 9, 4);
	    
	    /* navigate to login page from company domain page */
		pages.companyDomainPage.continueToApplication(companyDomain);
		
		/*navigate to home page from login */
		pages.loginPage.signToApplication(userName, password);
		
		/*  navigate to setup page from home page                                     */
		pages.homePage.navigateToSetup();
		
		/*landing on user roles page from setup*/
		pages.setupPage.navigateToUserRoles();
		
		/* perform search and delete  */
		pages.userRolePage.search_And_Delete(searchRole, expectedUserRole, expectedStatus);
		
		/*validate the test case */
		pages.userRolePage.verifyPage(expectedMsg);
		
		//Assert.assertEquals(expectedMsg, "No records found");

		
	}

}
