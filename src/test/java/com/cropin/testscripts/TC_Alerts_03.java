package com.cropin.testscripts;

import org.testng.annotations.Test;

import com.cropin.baseutil.BaseTest;
import com.cropin.baseutil.InitializePages;
import com.cropin.commonutils.ExcelUtil;

public class TC_Alerts_03 extends BaseTest{
	/**
	 * Description: edit/search/delete alert
	 * @author Vinay Singh
	 */
	@Test
	public synchronized void testAddAlert() {
	
		/*fetching data from excel */
		
		String alert=ExcelUtil.getCellData(EXCELPATH, "Alerts", 25, 1);
		String planName=ExcelUtil.getCellData(EXCELPATH, "Alerts", 25, 2);
		String expectedPlanType=ExcelUtil.getCellData(EXCELPATH, "Alerts", 25, 3);
		String expectedCA=ExcelUtil.getCellData(EXCELPATH, "Alerts", 25, 4);
		String expectedPlan=ExcelUtil.getCellData(EXCELPATH, "Alerts", 25, 5);
		
		
	    /*creating object of Initialize Pages */
	    InitializePages pages = new InitializePages(driver, WebActionUtil, ETO);
	
         /* navigate to login page  */
	    pages.companyDomainPage.continueToApplication(companyDomain);
			
	    /*navigate to home page  */
	    pages.loginPage.signToApplication(userName, password);
			
	     /*  navigate to Configuration page */                                  
	     pages.homePage.navigateToConfiguration();
	     
	     /*navigate to alert page*/
	     pages.configPage.navigateToAlerts();
	     
	     /*add plan */
	     pages.alertPage.addPlanAlert(alert, planName, expectedPlanType, expectedCA);
	     
	     /*validate plan*/
	     pages.alertPage.validatePlan(planName, expectedPlan);
	     
	     
	}

}
