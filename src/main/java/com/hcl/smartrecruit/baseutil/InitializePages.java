package com.hcl.smartrecruit.baseutil;

import org.openqa.selenium.WebDriver;

import com.hcl.smartrecruit.pages.ApproveAllRequisition_Page;
import com.hcl.smartrecruit.pages.CloseRequisition_Page;
import com.hcl.smartrecruit.pages.Login_Page;
import com.hcl.smartrecruit.pages.RequisitionRequest_Page;

import com.hcl.smartrecruit.util.WebActionUtil;


/**
 *Description: Initializes all pages with driver,ETO, WebAactionUtil
 *@author  :   Shreya U,Vivek Dogra,Aatish Slathia 
 */

public class InitializePages {
	public Login_Page loginPage;
	public RequisitionRequest_Page requistionRequest;
	public CloseRequisition_Page closeRequisition;
	public ApproveAllRequisition_Page approveAllRequisition;
	public InitializePages(WebDriver driver,long ETO,WebActionUtil WebActionUtil) {
			
			loginPage = new Login_Page(driver, ETO, WebActionUtil);
			requistionRequest= new RequisitionRequest_Page(driver, ETO, WebActionUtil);
			closeRequisition = new CloseRequisition_Page(driver, ETO, WebActionUtil);
			approveAllRequisition= new ApproveAllRequisition_Page(driver, ETO, WebActionUtil);
	}

}
