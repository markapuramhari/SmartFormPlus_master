package com.cropin.testscripts;

import org.testng.annotations.Test;

import com.cropin.baseutil.BaseTest;
import com.cropin.baseutil.InitializePages;
import com.cropin.commonutils.ExcelUtil;

public class TC_Plantype_04 extends BaseTest{
	/**
	 * Descriptio:Conditional Attribute
	 * @author Vinay Singh
	 */
	@Test
	public synchronized void testConditionalAttribute() {
	
		/*fetching data from excel */
		String planName=ExcelUtil.getCellData(EXCELPATH, "PlanType", 37, 1);
		String expectedAttribute=ExcelUtil.getCellData(EXCELPATH, "PlanType", 37, 2);
		String expectedValue=ExcelUtil.getCellData(EXCELPATH, "PlanType", 37, 3);
		int row=Integer.parseInt(ExcelUtil.getCellData(EXCELPATH, "PlanType", 37, 4));
		String expectedText=ExcelUtil.getCellData(EXCELPATH, "PlanType", 37, 5);
	
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
	     
	     /*conditional attribute */
	     pages.planTypePage.conditionalAttribute(planName, row, expectedAttribute, expectedValue);
	     
	     /*validation of conditional attribute */
	     pages.planTypePage.validateConditionalAttribute(expectedText);
	     
	     
	}
	     

}
