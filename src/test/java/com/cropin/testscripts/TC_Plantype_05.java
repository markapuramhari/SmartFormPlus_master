package com.cropin.testscripts;

import org.testng.annotations.Test;

import com.cropin.baseutil.BaseTest;
import com.cropin.baseutil.InitializePages;
import com.cropin.commonutils.ExcelUtil;

public class TC_Plantype_05 extends BaseTest{
	/**
	 * Descriptio:Conditional Attribute
	 * @author Vinay Singh
	 */
	@Test
	public synchronized void testCalculatedAttribute() {
	
		/*fetching data from excel */
		String planName=ExcelUtil.getCellData(EXCELPATH, "PlanType", 49, 1);
		int row=Integer.parseInt(ExcelUtil.getCellData(EXCELPATH, "PlanType", 49, 2));
		String fieldName=ExcelUtil.getCellData(EXCELPATH, "PlanType", 49, 3);
		String expectedAsset=ExcelUtil.getCellData(EXCELPATH, "PlanType", 49, 4);
		String symbol=ExcelUtil.getCellData(EXCELPATH, "PlanType", 49, 5);
		String expectedAsset_1=ExcelUtil.getCellData(EXCELPATH, "PlanType", 49, 6);
		String symbol_1=ExcelUtil.getCellData(EXCELPATH, "PlanType", 50, 5);
		String symbol_2=ExcelUtil.getCellData(EXCELPATH, "PlanType", 51, 5);
		String expectedAsset_2=ExcelUtil.getCellData(EXCELPATH, "PlanType", 49, 7);
		String expectedAsset_3=ExcelUtil.getCellData(EXCELPATH, "PlanType", 49, 8);
		String expectedTest=ExcelUtil.getCellData(EXCELPATH, "PlanType", 49, 9);
		String expectedMsg=ExcelUtil.getCellData(EXCELPATH, "PlanType", 16, 2);
		
	    /*creating object of Initialize Pages */
	    InitializePages pages = new InitializePages(driver, WebActionUtil, ETO);
	
         /* navigate to login page  */
	    pages.companyDomainPage.continueToApplication(companyDomain);
			
	    /*navigate to home page  */
	    pages.loginPage.signToApplication(userName, password);
			
	     /*  navigate to Configuration page */                                  
	     pages.homePage.navigateToConfiguration();
	     
	     /*navigate to plan types */
	     pages.configPage.navigateToPlanTypes();
	     
	     /*calculate formula*/
	     pages.planTypePage.calculatedAttribute(planName, row, fieldName, expectedAsset, symbol, expectedAsset_1, symbol_1, symbol_2, expectedAsset_2, expectedAsset_3);
	
	     /*validate Calculated Attribute */
	     pages.planTypePage.validateCalculatedAttribute(expectedTest);
	     
	     /*validate main page of plan type afer clicking on save */
	     pages.planTypePage.validateMsg(expectedMsg);
	
	
	}   

}
