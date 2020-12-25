package com.cropin.testscripts;

import org.testng.annotations.Test;
import com.cropin.baseutil.BaseTest;
import com.cropin.baseutil.InitializePages;
import com.cropin.commonutils.ExcelUtil;

 

public class TC_Role_01 extends BaseTest{
	/**
	 * 
	 * @author Vinay Singh
	 */
	
	@Test
	public synchronized void testUserRole() {
	/*creating object of Initialize Pages */
	InitializePages pages = new InitializePages(driver, WebActionUtil, ETO);
		
	/*read data from excel */
	String userRoleName = ExcelUtil.getCellData(EXCELPATH, "Setup", 2, 1);
	String expectedCompany = ExcelUtil.getCellData(EXCELPATH, "Setup", 2, 2);
	String expectedURL=ExcelUtil.getCellData(EXCELPATH, "Setup", 2, 3);
	String role=ExcelUtil.getCellData(EXCELPATH, "Setup", 2, 4);
	String expectedRole=ExcelUtil.getCellData(EXCELPATH, "Setup", 2, 5);
	
	/* navigate to login page from company domain page */
	pages.companyDomainPage.continueToApplication(companyDomain);
	
	/*navigate to home page from login */
	pages.loginPage.signToApplication(userName, password);
	
	/*  navigate to setup page from home page  */
	pages.homePage.navigateToSetup();
	
	/*landing on user roles page from setup*/
	pages.setupPage.navigateToUserRoles();
	
	/*add user  */
	pages.userRolePage.createUserRoles(userRoleName, expectedCompany);
	
	/*validation by URL */
	pages.userRolePage.validateUserRoleURL(expectedURL);
	
	/*validation by user role link */
	pages.userRolePage.validateUserRole(role,expectedRole);
	
	
	}
}
