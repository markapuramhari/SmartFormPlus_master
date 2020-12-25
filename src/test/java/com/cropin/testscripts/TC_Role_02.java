package com.cropin.testscripts;

import org.testng.annotations.Test;
import com.cropin.baseutil.BaseTest;
import com.cropin.baseutil.InitializePages;
import com.cropin.commonutils.ExcelUtil;

public class TC_Role_02 extends BaseTest {
	/**
	 * 
	 * @author Vinay Singh
	 * @throws Exception 
	 */
	@Test
	public synchronized void testWebAndMobileToggle(){
		/*creating object of Initialize Pages */
		InitializePages pages = new InitializePages(driver, WebActionUtil, ETO);
			
		/*read data from excel */
		String userRoleName = ExcelUtil.getCellData(EXCELPATH, "Setup", 3, 1);
		String selectCompany = ExcelUtil.getCellData(EXCELPATH, "Setup", 3, 2);
		String attribute=ExcelUtil.getCellData(EXCELPATH, "Setup", 6, 1);
		String expectedValue=ExcelUtil.getCellData(EXCELPATH, "Setup", 6, 2);
		
		/* navigate to login page from company domain page */
		pages.companyDomainPage.continueToApplication(companyDomain);
		
		/*navigate to home page from login */
		pages.loginPage.signToApplication(userName, password);
		
		/*  navigate to setup page from home page                                     */
		pages.homePage.navigateToSetup();
		
		/*landing on user roles page from setup*/
		pages.setupPage.navigateToUserRoles();
		
		/*add user and enable toggle of web and mobile */
		pages.userRolePage.enableWebAndMobileToggle(userRoleName, selectCompany);
				
		/* validation of test case */
		pages.userRolePage.validateToggle(attribute, expectedValue);
		
		/*click on Save button */
		pages.userRolePage.clickOnSaveBtn();
		
		
		
		
		
		
	
		
	}

}
