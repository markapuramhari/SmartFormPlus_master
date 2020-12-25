package com.cropin.testscripts;

import org.testng.annotations.Test;

import com.cropin.baseutil.BaseTest;
import com.cropin.baseutil.InitializePages;
import com.cropin.commonutils.ExcelUtil;

public class TC_Resource_01 extends BaseTest{
	
	/**
	 * Descriptio:add Farm Resource
	 * @author Vinay Singh
	 */
	@Test
	public synchronized void testAddFarmResource() {
	
	/*fetching data from excel */
	String fileLocation=ExcelUtil.getCellData(EXCELPATH, "Farm Resource", 2, 1);
	String  resourceName=ExcelUtil.getCellData(EXCELPATH, "Farm Resource", 2, 3);
    String expectedOwner=ExcelUtil.getCellData(EXCELPATH, "Farm Resource", 2, 2);
	String expectedURL=ExcelUtil.getCellData(EXCELPATH, "Farm Resource", 2, 4);
	String resource=ExcelUtil.getCellData(EXCELPATH, "Farm Resource", 2, 5);
	String expectedResourceType=ExcelUtil.getCellData(EXCELPATH, "Farm Resource", 2, 6);
	String expectedResourceName=ExcelUtil.getCellData(EXCELPATH, "Farm Resource", 2, 7);
	
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
	
	/*add farm resource */
	pages.farmResourcePage.addFarmResource(fileLocation, resourceName, expectedOwner, expectedResourceType);
	
	/*validate profile pic */
	pages.farmResourcePage.checkImage();
	
	/*validation  page */
	pages.farmResourcePage.validateUserURL(expectedURL);
	
	/*validate farm resource*/
	pages.farmResourcePage.validateResource(resource, expectedResourceName);
	
	
	
	
	}
}
