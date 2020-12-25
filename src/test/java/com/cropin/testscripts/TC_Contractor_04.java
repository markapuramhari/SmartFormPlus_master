package com.cropin.testscripts;

import org.testng.annotations.Test;

import com.cropin.baseutil.BaseTest;
import com.cropin.baseutil.InitializePages;
import com.cropin.commonutils.ExcelUtil;

public class TC_Contractor_04 extends BaseTest{
	
	/**
	 * Descriptio:search and delete
	 * @author Vinay Singh
	 */
	@Test
	public synchronized void testSearch_And_Delete() {
	
	/*fetching data from excel */
	String contractor=ExcelUtil.getCellData(EXCELPATH, "Contractor", 18, 3);
	String searchContractor=ExcelUtil.getCellData(EXCELPATH, "Contractor", 18, 2);
    String expectedContractor=ExcelUtil.getCellData(EXCELPATH, "Contractor", 18, 1);
	
	/*creating object of Initialize Pages */
	InitializePages pages = new InitializePages(driver, WebActionUtil, ETO);
	
    /* navigate to login page  */
	pages.companyDomainPage.continueToApplication(companyDomain);
			
	/*navigate to home page  */
	pages.loginPage.signToApplication(userName, password);
			
	/*  navigate to Configuration page */                                  
	pages.homePage.navigateToConfiguration();
	
	/* navigate to Contractor */
	pages.configPage.navigateToContractor();
	
	/* search and delete */
	pages.contractorPage.search_And_Delete(searchContractor, contractor);
	
	/*validate search contractor */
	pages.contractorPage.validateSearcAndDelete(searchContractor, contractor, expectedContractor);
	
	}
	

}
