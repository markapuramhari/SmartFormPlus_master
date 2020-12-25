package com.cropin.testscripts;

import org.testng.annotations.Test;

import com.cropin.baseutil.BaseTest;
import com.cropin.baseutil.InitializePages;
import com.cropin.commonutils.ExcelUtil;

public class TC_Resource_03 extends BaseTest{
	/**
	 * Descriptio:download template
	 * @author Vinay Singh
	 */
	@Test
	public synchronized void testUploadTemplate() {
	
		/*fetching data from excel */
		String fileLocation_1=ExcelUtil.getCellData(EXCELPATH, "Farm Resource", 18, 1);
		String fileLocation_2=ExcelUtil.getCellData(EXCELPATH, "Farm Resource", 19, 1);
		String fileLocation_3=ExcelUtil.getCellData(EXCELPATH, "Farm Resource", 20, 1);
		String expectedStatus=ExcelUtil.getCellData(EXCELPATH, "Farm Resource", 18, 2);
		String expectedErrorStatus=ExcelUtil.getCellData(EXCELPATH, "Farm Resource", 19, 2);
		String expectedNetworkStatus=ExcelUtil.getCellData(EXCELPATH, "Farm Resource", 20, 2);
	
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
	        
	     /*upload template*/
	    pages.farmResourcePage.uploadTemplate(fileLocation_1);
	     
	     /*validate successful uploading status*/
	     pages.farmResourcePage.validateStatus(expectedStatus);
	     
	     /*navigate to farm resource page */
	     pages.configPage.navigateToFarmResource();
	     
	    /*upload template*/
		 pages.farmResourcePage.uploadTemplate(fileLocation_2);
		  
	     /*validate error  status*/
		 pages.farmResourcePage.validateErrorStatus(expectedErrorStatus);
		 
		  /*navigate to farm resource page */
	     pages.configPage.navigateToFarmResource();
	     
	     /*upload template*/
		 pages.farmResourcePage.uploadTemplate(fileLocation_3);
		  
	     
	     /*validate network failure  status*/
		 pages.farmResourcePage.validateNetworkFailureStatus(expectedNetworkStatus);
		  
	}
	

}
