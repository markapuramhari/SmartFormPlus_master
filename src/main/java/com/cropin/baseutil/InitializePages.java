package com.cropin.baseutil;

import org.openqa.selenium.WebDriver;

import com.cropin.pages.AlertsPage;
import com.cropin.pages.AssetsPage;
import com.cropin.pages.CompanyDomainPage;
import com.cropin.pages.CompanyPage;
import com.cropin.pages.ConfigurationPage;
import com.cropin.pages.ContractorPage;
import com.cropin.pages.CropPage;
import com.cropin.pages.FarmResourcePage;
import com.cropin.pages.FarmersPage;
import com.cropin.pages.FormsPage;
import com.cropin.pages.HomePage;
import com.cropin.pages.LoginPage;
import com.cropin.pages.PlanTypePage;
import com.cropin.pages.SetupPage;
import com.cropin.pages.SubCompaniesPage;
import com.cropin.pages.UserPage;
import com.cropin.pages.UserRolePage;
import com.cropin.util.WebActionUtil;


/**
 *Description: Initializes all pages with driver instance ,Explicit Time out, WebAactionUtility
 *             using variables driver,ETO,WebactionUtil
 *@author  :  Vinay Singh 
 */

public class InitializePages {
	public CompanyDomainPage companyDomainPage;
	public LoginPage loginPage;
	public HomePage homePage;
	public SetupPage setupPage;
	public UserRolePage userRolePage;
	public UserPage  userPage;
	public ConfigurationPage configPage;
	public ContractorPage contractorPage;
	public FarmResourcePage farmResourcePage;
	public SubCompaniesPage subCompaniesPage;
	public CompanyPage companyPage;
	public FarmersPage farmersPage;
	public PlanTypePage planTypePage;
	public CropPage cropPage;
	public AlertsPage alertPage;
	public AssetsPage assetsPage;
	public FormsPage formsPage;

	
	public InitializePages(WebDriver driver,WebActionUtil WebActionUtil,long ETO) {
			
		    companyDomainPage=new CompanyDomainPage(driver,WebActionUtil,ETO);
			loginPage = new LoginPage(driver,WebActionUtil,ETO );
			homePage= new HomePage(driver, WebActionUtil, ETO);
			setupPage = new SetupPage(driver, WebActionUtil, ETO);
			userRolePage= new UserRolePage(driver, WebActionUtil, ETO);
			userPage= new UserPage(driver, WebActionUtil, ETO);
			configPage=new ConfigurationPage(driver, WebActionUtil, ETO);
			contractorPage=new ContractorPage(driver, WebActionUtil, ETO);
			farmResourcePage=new FarmResourcePage(driver, WebActionUtil, ETO);
			subCompaniesPage = new SubCompaniesPage(driver, WebActionUtil,ETO);
			companyPage = new CompanyPage(driver, WebActionUtil,ETO);
			farmersPage = new FarmersPage(driver,WebActionUtil,ETO);
			planTypePage=new PlanTypePage(driver,WebActionUtil,ETO);
			cropPage= new CropPage (driver,WebActionUtil,ETO);
			alertPage=new AlertsPage(driver,WebActionUtil,ETO);
			assetsPage= new AssetsPage(driver,WebActionUtil,ETO);
			formsPage= new FormsPage(driver,WebActionUtil,ETO);
	}

}
