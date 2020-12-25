package com.cropin.testscripts;

import org.testng.annotations.Test;

import com.cropin.baseutil.BaseTest;
import com.cropin.baseutil.InitializePages;
import com.cropin.commonutils.ExcelUtil;

public class TC_Contractor_03 extends BaseTest{
	/**
	 * Descriptio:upload template
	 * @author Vinay Singh
	 */
	@Test
	public synchronized void testUploadTemplate() {
	
	/*fetching data from excel */
	String fileLocation_1=ExcelUtil.getCellData(EXCELPATH, "Contractor", 11, 1);
	String fileLocation_2=ExcelUtil.getCellData(EXCELPATH, "Contractor", 12, 1);
	String fileLocation_3=ExcelUtil.getCellData(EXCELPATH, "Contractor", 13, 1);
	String expectedStatus=ExcelUtil.getCellData(EXCELPATH, "Contractor", 11, 2);
	String expectedErrorStatus=ExcelUtil.getCellData(EXCELPATH, "Contractor", 12, 2);
	String expectedNetworkStatus=ExcelUtil.getCellData(EXCELPATH, "Contractor", 13, 2);
	
	
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
	
	/*upload template */
	pages.contractorPage.uploadTemplate(fileLocation_1);
	
	/*validate successful status */
	pages.contractorPage.validateStatus(expectedStatus);
	
	/* navigate to Contractor */
	pages.configPage.navigateToContractor();
	
	/*upload template */
	pages.contractorPage.uploadTemplate(fileLocation_2);
	
	/*validate error status */
	pages.contractorPage.validateErrorStatus(expectedErrorStatus);
	
	
	/* navigate to Contractor */
	pages.configPage.navigateToContractor();
	
	/*upload template */
	pages.contractorPage.uploadTemplate(fileLocation_3);
	
	/*validate network failure */
	pages.contractorPage.validateNetworkFailureStatus(expectedNetworkStatus);
	
	
	
	}
	

}
