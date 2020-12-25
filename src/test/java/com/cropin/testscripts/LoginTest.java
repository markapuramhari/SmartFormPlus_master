package com.cropin.testscripts;

import org.testng.annotations.Test;

import com.cropin.baseutil.BaseTest;
import com.cropin.baseutil.InitializePages;

public class LoginTest extends BaseTest {
	/**
	 * 
	 * @author Vinay Singh
	 * @throws Throwable 
	 */
	@Test
	public synchronized void testLogin() throws Throwable {
		/* creating the object of InitalizePages class  */
		InitializePages pages = new InitializePages(driver, WebActionUtil, ETO);
		
		/*navigate to login page from  Company Domain Page */
		pages.companyDomainPage.continueToApplication(companyDomain);
	
		
		
		/* navigate to home page from login page */
		
		pages.loginPage.signToApplication(userName, password);
			
		
		
	}

}
