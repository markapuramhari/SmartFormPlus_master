package com.cropin.testscripts;

import org.testng.annotations.Test;

import com.cropin.baseutil.BaseTest;
import com.cropin.baseutil.InitializePages;
import com.cropin.commonutils.ExcelUtil;

public class TC_Contractor_01 extends BaseTest {
	
	/**
	 * Descriptio:add Contractor
	 * @author Vinay Singh
	 */
	@Test
	public synchronized void testAddContractor() {
	
	/*fetching data from excel */
	String fileLocation=ExcelUtil.getCellData(EXCELPATH, "Contractor", 2, 1);
	String contractorName=ExcelUtil.getCellData(EXCELPATH, "Contractor", 2, 2);
    String expectedISD=ExcelUtil.getCellData(EXCELPATH, "Contractor", 2, 3);
	String mobileNum=ExcelUtil.getCellData(EXCELPATH, "Contractor", 2, 4);
	String address=ExcelUtil.getCellData(EXCELPATH, "Contractor", 2, 5);
	String expectedURL=ExcelUtil.getCellData(EXCELPATH, "Contractor", 2, 6);
	String contractor=ExcelUtil.getCellData(EXCELPATH, "Contractor", 2, 7);
	String expectedContractor=ExcelUtil.getCellData(EXCELPATH, "Contractor", 2, 8);
	
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
	
	/* add contractor */
	pages.contractorPage.addContractor(fileLocation, contractorName, expectedISD, mobileNum, address);
	
	/*validation of main grid through URL */
	pages.contractorPage.validateUserURL(expectedURL);
	
	/*validation of user created or not */
	pages.contractorPage.validateContractor(contractor, expectedContractor);
	
	
	}

}
