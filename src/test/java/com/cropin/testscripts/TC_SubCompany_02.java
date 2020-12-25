package com.cropin.testscripts;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.cropin.baseutil.BaseTest;
import com.cropin.baseutil.InitializePages;
import com.cropin.commonutils.ExcelUtil;

public class TC_SubCompany_02 extends BaseTest{
	/**
	 * Description : Search Subcompany created 
	 * @author lohith
	 * @throws InterruptedException 
	 */
 @Test
 public synchronized void testSearchSubCompany() throws InterruptedException {
	 	/*fetch the expected data from ExcelSheet*/
		String subCompanyName = ExcelUtil.getCellData(EXCELPATH,"Setup",36,1);
		String userRole = ExcelUtil.getCellData(EXCELPATH,"Setup",36,2);
		
		/*creating object of Initialize Pages */
		InitializePages pages = new InitializePages(driver, WebActionUtil, ETO);
		
		/* navigate to login page from company domain page */
		pages.companyDomainPage.continueToApplication(companyDomain);
		
		/*navigate to home page from login */
		pages.loginPage.signToApplication(userName, password);
		
		/*  navigate to setup page from home page*/
		pages.homePage.navigateToSetup();
		
		/*landing on user roles page from setup*/
		pages.setupPage.navigateToUserRoles();
		
		/*select the UserRole From UserRoles*/
		WebActionUtil.clickOnElement(pages.userRolePage.actualRoleInList(userRole), "User Role");
		
		/*select the SubCompanydropDown*/
		WebActionUtil.clickOnElement(pages.userRolePage.getBtnSubCompanyDropDown(), "SubCompany dropdown Option");
	
		/*validate the subCompanyName present in the DropDown*/
		WebActionUtil.handlingList(pages.userRolePage.getSubCompanyNames(),subCompanyName,"SubCompanyName in dropdown");
		
		/* navigate to company from setup*/
		pages.setupPage.navigateToCompany();

		/* fetch the subcompanies present in Company */
		pages.companyPage.fetchingSubCompanies();
}
}
