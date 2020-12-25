package com.cropin.testscripts;
import org.openqa.selenium.By;

import org.testng.annotations.Test;


import com.cropin.baseutil.BaseTest;
import com.cropin.baseutil.InitializePages;
import com.cropin.commonutils.ExcelUtil;

public class TC_SubCompany_01 extends BaseTest{
	/**
	 * Description : Create Subcompany 
	 * @author Lohith Reddy
	 * @throws InterruptedException 
	 */
 @Test
 public synchronized void testCreateSubCompany() throws InterruptedException {
	 
	 	/*Read the data from ExcelSheet*/
		String subCompanyName = ExcelUtil.getCellData(EXCELPATH, "Setup",28,1);
		String website = ExcelUtil.getCellData(EXCELPATH, "Setup",28,2);
		String address = ExcelUtil.getCellData(EXCELPATH, "Setup",28,3);
		String expectedSubcompanyTitle =ExcelUtil.getCellData(EXCELPATH,"Setup",28,4);
		String expectedCompanyURL = ExcelUtil.getCellData(EXCELPATH,"Setup",28,5);
		
	 	/*creating object of Initialize Pages */
		InitializePages pages = new InitializePages(driver, WebActionUtil, ETO);	
		
		/* navigate to login page from company domain page */
		pages.companyDomainPage.continueToApplication(companyDomain);
		
		/*navigate to home page from login */
		pages.loginPage.signToApplication(userName, password);
		
		/*  navigate to setup page from home page*/
		pages.homePage.navigateToSetup();
		
		/* navigate to company from setup*/
		pages.setupPage.navigateToCompany();
		
		/* navigate to Subcompanies from Company*/
		pages.companyPage.navigateToAddSubCompanies();
		
		/* Add the data in SubCompany*/
		pages.subCompaniesPage.addSubCompany(subCompanyName, website, address);
		
		/*Validate the SubCompany page */
		pages.subCompaniesPage.validateSubCompanyScreen(expectedSubcompanyTitle);
		
		/*Validate the Edit button*/
		pages.subCompaniesPage.validateEditCancelButton();
		
		/* Cancel the SubCompany data which navigate to company page */
		pages.subCompaniesPage.cancelSubCompanyData();
		
		/*Validate the CompanyURL */
		pages.subCompaniesPage.validateURL(expectedCompanyURL);
		
		/*Display the list of subCompanies created in SubCompany*/
		pages.companyPage.fetchingSubCompanies();		
}
}
