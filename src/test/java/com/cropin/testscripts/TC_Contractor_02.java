package com.cropin.testscripts;

import org.testng.annotations.Test;

import com.cropin.baseutil.BaseTest;
import com.cropin.baseutil.InitializePages;
import com.cropin.commonutils.ExcelUtil;

public class TC_Contractor_02 extends BaseTest{
	/**
	 * Descriptio:download template
	 * @author Vinay Singh
	 */
	@Test
	public synchronized void testDownloadTemplate() {
	
	/*fetching data from excel */
	String expectedMessage=ExcelUtil.getCellData(EXCELPATH, "Contractor", 6, 1);
	
	
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
	
	/*download template */
	pages.contractorPage.downloadTemplate();
	
	/*validate downloading message */
	pages.contractorPage.validateDownloadTemplate(expectedMessage);
	
	
	}
	
}
