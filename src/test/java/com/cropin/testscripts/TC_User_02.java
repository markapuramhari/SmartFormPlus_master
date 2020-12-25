package com.cropin.testscripts;

import org.testng.annotations.Test;

import com.cropin.baseutil.BaseTest;
import com.cropin.baseutil.InitializePages;
import com.cropin.commonutils.ExcelUtil;

public class TC_User_02 extends BaseTest{
	

	/**
	 * Descriptio:search and delete user
	 * @author Vinay Singh
	 */
	
	@Test
	public synchronized void testSearchAndDelete() {
		
		/*fetching data from excel */
		String searchUser=ExcelUtil.getCellData(EXCELPATH, "Setup", 23, 1);
		String users=ExcelUtil.getCellData(EXCELPATH, "Setup", 23, 2);
	    String expectedUser=ExcelUtil.getCellData(EXCELPATH, "Setup", 23, 3);
		String expectedStatus=ExcelUtil.getCellData(EXCELPATH, "Setup", 23, 4);
		
		
		/*creating object of Initialize Pages */
		InitializePages pages = new InitializePages(driver, WebActionUtil, ETO);
		
	    /* navigate to login page  */
		pages.companyDomainPage.continueToApplication(companyDomain);
				
		/*navigate to home page  */
		pages.loginPage.signToApplication(userName, password);
				
		/*  navigate to setup page */                                  
		pages.homePage.navigateToSetup();
				
		/* navigate to user page */
		pages.setupPage.navigateToUsers();
		
		/* search,delete and validate */
		
		pages.userPage.search_And_Delete(searchUser, users, expectedUser, expectedStatus);
		
		/*validate search user */
		pages.userPage.searchValidation(searchUser, expectedUser);
		
		
		
		
		
		
	}

}
