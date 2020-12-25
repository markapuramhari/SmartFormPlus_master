package com.cropin.testscripts;

import org.testng.annotations.Test;

import com.cropin.baseutil.BaseTest;
import com.cropin.baseutil.InitializePages;
import com.cropin.commonutils.ExcelUtil;

public class TC_Plantype_01 extends BaseTest{
	
	/**
	 * Descriptio:create plan types
	 * @author Vinay Singh
	 */
	@Test
	public synchronized void testCreatePlan() {
	
		/*fetching data from excel */
		String planName=ExcelUtil.getCellData(EXCELPATH, "PlanType", 2, 1);
		String attributeLabel_1=ExcelUtil.getCellData(EXCELPATH, "PlanType", 2, 2);
		String expectedDataType_1=ExcelUtil.getCellData(EXCELPATH, "PlanType", 2, 3);
		String attributeLabel_2=ExcelUtil.getCellData(EXCELPATH, "PlanType", 3, 2);
		String expectedDataType_2=ExcelUtil.getCellData(EXCELPATH, "PlanType", 3, 3);
		String attributeLabel_3=ExcelUtil.getCellData(EXCELPATH, "PlanType", 4, 2);
		String expectedDataType_3=ExcelUtil.getCellData(EXCELPATH, "PlanType", 4, 3);
		String expectedHeaderGroup=ExcelUtil.getCellData(EXCELPATH, "PlanType", 2, 4);
		String expectedURL=ExcelUtil.getCellData(EXCELPATH, "PlanType", 2, 5);
		String planType=ExcelUtil.getCellData(EXCELPATH, "PlanType", 2, 6);
		String expectedplanType=ExcelUtil.getCellData(EXCELPATH, "PlanType", 2, 7);
		int row_1=Integer.parseInt(ExcelUtil.getCellData(EXCELPATH, "PlanType", 2, 8));
		int row_2=Integer.parseInt(ExcelUtil.getCellData(EXCELPATH, "PlanType", 3, 8));
		int row_3=Integer.parseInt(ExcelUtil.getCellData(EXCELPATH, "PlanType", 4, 8));
	    int row_num= Integer.parseInt(ExcelUtil.getCellData(EXCELPATH, "PlanType", 2, 9));
	    
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
	     
	     /*create plan types */
	     pages.planTypePage.createPlanType(planName);
	     
	     /*create attribute label */
	     pages.planTypePage.handlingAttributeTable(row_1, attributeLabel_1, expectedDataType_1);
	     pages.planTypePage.handlingAttributeTable(row_2, attributeLabel_2, expectedDataType_2);
	     pages.planTypePage.handleAdditionalInfoColumn(row_num);
	     pages.planTypePage.handlingAttributeTable(row_3, attributeLabel_3, expectedDataType_3);
	     
	     /* header group column */
	     pages.planTypePage.handlingHeaderGroup(expectedHeaderGroup);
	     
	     /*validation of Main Grid page through URL*/
	     pages.planTypePage.validatePlanTypeURL(expectedURL);
	     
	     /*validate plan is created or not */
	     pages.planTypePage.validatePlanType(planType, expectedplanType);
	     
	     
	}

}
