package com.cropin.testscripts;

import org.testng.annotations.Test;

import com.cropin.baseutil.BaseTest;
import com.cropin.baseutil.InitializePages;
import com.cropin.commonutils.ExcelUtil;

public class TC_Resource_04 extends BaseTest{
	/**
	 * Descriptio:download template
	 * @author Vinay Singh
	 */
	@Test
	public synchronized void testUploadTemplate() {
	
		/*fetching data from excel */
		String resource=ExcelUtil.getCellData(EXCELPATH, "Farm Resource", 25, 1);
		String searchResource=ExcelUtil.getCellData(EXCELPATH, "Farm Resource", 25, 2);
		String expectedResource=ExcelUtil.getCellData(EXCELPATH, "Farm Resource", 25, 3);
	
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
	     
	     /*search and delete */
	     pages.farmResourcePage.search_And_Delete(searchResource, resource);
	     
	     /*validate */
	     pages.farmResourcePage.validateSearcAndDelete(searchResource, resource, expectedResource);
	     
	     
	}
}
