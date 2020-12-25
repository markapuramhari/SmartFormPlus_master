package com.cropin.testscripts;

import org.testng.annotations.Test;

import com.cropin.baseutil.BaseTest;
import com.cropin.baseutil.InitializePages;
import com.cropin.commonutils.ExcelUtil;

public class TC_Plantype_02 extends BaseTest{
	
	/**
	 * Descriptio:edit plan types
	 * @author Vinay Singh
	 */
	@Test
	public synchronized void testEditPlan() {
	
		/*fetching data from excel */
		String planName=ExcelUtil.getCellData(EXCELPATH, "PlanType", 16, 1);
		String expectedMsg=ExcelUtil.getCellData(EXCELPATH, "PlanType", 16, 2);
		String expectedHeaderGroup=ExcelUtil.getCellData(EXCELPATH, "PlanType", 16, 3);
		int row=Integer.parseInt(ExcelUtil.getCellData(EXCELPATH, "PlanType", 16, 4));

	
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
	     
	     /*edit plan type*/
	     pages.planTypePage.editPlanType(planName, row, expectedHeaderGroup);
	     
	     /*Validate by successful message after clicking on Save*/
	     pages.planTypePage.validateMsg(expectedMsg);
	     
	}
}
