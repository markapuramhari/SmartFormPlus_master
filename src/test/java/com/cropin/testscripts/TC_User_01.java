package com.cropin.testscripts;

import org.testng.annotations.Test;

import com.cropin.baseutil.BaseTest;
import com.cropin.baseutil.InitializePages;
import com.cropin.commonutils.ExcelUtil;

public class TC_User_01 extends BaseTest{
	/**
	 * Descriptio: add user
	 * @author Vinay Singh
	 */
	
	@Test
	public synchronized void testAddUser() {
		
		/*creating object of Initialize Pages */
		InitializePages pages = new InitializePages(driver, WebActionUtil, ETO);
		
		/*read data from excel */
		String name = ExcelUtil.getCellData(EXCELPATH, "Setup", 17, 1);
		String userRole= ExcelUtil.getCellData(EXCELPATH, "Setup", 17, 2);
		String mobileNum= ExcelUtil.getCellData(EXCELPATH, "Setup", 17, 3);
	    String email= ExcelUtil.getCellData(EXCELPATH, "Setup", 17, 4);
	    String location=ExcelUtil.getCellData(EXCELPATH, "Setup", 17,5 );
	    String fileLocation= ExcelUtil.getCellData(EXCELPATH, "Setup", 17, 6);
	    String expectedISD= ExcelUtil.getCellData(EXCELPATH, "Setup", 17, 7);
	    String expectedTimeZone= ExcelUtil.getCellData(EXCELPATH, "Setup", 17, 8);
	    String expectedLangPreference= ExcelUtil.getCellData(EXCELPATH, "Setup", 17, 9);
	    String expectedCurrPref= ExcelUtil.getCellData(EXCELPATH, "Setup", 17, 10);
	    String expectedAreaUnit=ExcelUtil.getCellData(EXCELPATH, "Setup", 17, 11);
	    String expectedError=ExcelUtil.getCellData(EXCELPATH, "Setup", 17, 12);
	    String expectedURL=ExcelUtil.getCellData(EXCELPATH, "Setup", 17, 13);
	    String user=ExcelUtil.getCellData(EXCELPATH, "Setup", 17, 14);
	    String expectedUser=ExcelUtil.getCellData(EXCELPATH, "Setup", 17, 15);
	    
	    /* navigate to login page  */
		pages.companyDomainPage.continueToApplication(companyDomain);
		
		/*navigate to home page  */
		pages.loginPage.signToApplication(userName, password);
		
		/*  navigate to setup page */                                  
		pages.homePage.navigateToSetup();
		
		/* navigate to user page */
		pages.setupPage.navigateToUsers();
		
		/*add users */
		pages.userPage.addingUsers(name, fileLocation, userRole,location, expectedISD, mobileNum, email, expectedTimeZone, expectedLangPreference, expectedCurrPref, expectedAreaUnit);
		
		
		/* validate URL */
		pages.userPage.validateUserURL(expectedURL);
		
		/*validate user */
		pages.userPage.validateUser(user, expectedUser);
		
		/*add user with same mobile num and email id */
		pages.userPage.addingUsers(name, fileLocation, userRole,location, expectedISD, mobileNum, email, expectedTimeZone, expectedLangPreference, expectedCurrPref, expectedAreaUnit);
		
		/*validate  error message      */
		pages.userPage.validateErrorMessage(expectedError);
	}

}

