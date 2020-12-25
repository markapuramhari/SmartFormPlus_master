package com.cropin.testscripts;

import org.testng.annotations.Test;

import com.cropin.baseutil.BaseTest;
import com.cropin.baseutil.InitializePages;
import com.cropin.commonutils.ExcelUtil;

public class TC_Alerts_01 extends BaseTest{
	/**
	 * Descriptio: add alert
	 * @author Vinay Singh
	 */
	@Test
	public synchronized void testAddAlert() {
	
		/*fetching data from excel */
		String alertName=ExcelUtil.getCellData(EXCELPATH, "Alerts", 2, 1);
		String expectedAlertType=ExcelUtil.getCellData(EXCELPATH, "Alerts", 2, 2);
		String parent=ExcelUtil.getCellData(EXCELPATH, "Alerts", 2, 3);
		String radio=ExcelUtil.getCellData(EXCELPATH, "Alerts", 2, 4);
		String expectedURL=ExcelUtil.getCellData(EXCELPATH, "Alerts", 2, 5);
		String alert=ExcelUtil.getCellData(EXCELPATH, "Alerts", 2, 6);
		String expectedAlertName=ExcelUtil.getCellData(EXCELPATH, "Alerts", 2, 7);
		String advice=ExcelUtil.getCellData(EXCELPATH, "Alerts", 2, 8);
		
	    
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
	     
	     /*add alert*/
	     pages.alertPage.addAlert(alertName, expectedAlertType, parent, radio, advice);
	     
	     /*validate URL*/
	     pages.alertPage.validateAlertURL(expectedURL);
	     
	     /*validate Alert is created or not */
	     pages.alertPage.validateAlert(alert, expectedAlertName);
	   
	     
	}

}
