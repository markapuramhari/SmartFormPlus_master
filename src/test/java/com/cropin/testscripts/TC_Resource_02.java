package com.cropin.testscripts;

import org.testng.annotations.Test;

import com.cropin.baseutil.BaseTest;
import com.cropin.baseutil.InitializePages;
import com.cropin.commonutils.ExcelUtil;

public class TC_Resource_02 extends BaseTest{
	/**
	 * Descriptio:download template
	 * @author Vinay Singh
	 */
	@Test
	public synchronized void testDownloadTemplate() {
	
	/*fetching data from excel */
	String expectedMessage=ExcelUtil.getCellData(EXCELPATH, "Farm Resource", 13, 1);
	
	
	/*creating object of Initialize Pages */
	InitializePages pages = new InitializePages(driver, WebActionUtil, ETO);
	
    /* navigate to login page  */
	pages.companyDomainPage.continueToApplication(companyDomain);
			
	/*navigate to home page  */
	pages.loginPage.signToApplication(userName, password);
			
	/*  navigate to Configuration page */                                  
	pages.homePage.navigateToConfiguration();
	
	/*navigate to farm resource page */
	pages.configPage.navigateToFarmResource();
	
	/*download template */
	pages.farmResourcePage.downloadTemplate();
	
	/*validate download template */
	pages.farmResourcePage.validateDownloadTemplate(expectedMessage);
	
	}

}
