package com.hcl.smartrecruit.testscripts;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import com.hcl.smartrecruit.baseutil.BaseTest;
import com.hcl.smartrecruit.baseutil.InitializePages;
import com.hcl.smartrecruit.commonutils.ExcelUtil;
import com.hcl.smartrecruit.dataproviders.CloseRequisitionDataProvider;
import com.hcl.smartrecruit.dataproviders.CreateRequisitionDataProvider;

public class CloseRequisition extends BaseTest{

	/**
	 * Description:This class implements the scenario of closing the requisition.
	 * @author : Shreya U ,Vivek Dogra,Aatish Slatia  
	 */
	@Test(description = "Close Requisition", dataProvider = "TestDataProvider", dataProviderClass = CloseRequisitionDataProvider.class)

	
	public synchronized void TC_CloseRequisitionForm(String projectName,String skillvalue,String skill,String jobvalue,String job,String employeeGroup,String band,String SubBand,String secondaryPSA,String experience,String noOfPosition,String designationType,
			String joiningLocation,String secondaryJoiningLocation,String state
			,String city,String billtype,String interviewer1,String interviewer2,String statusRemarks) throws Exception, Exception, AWTException {
		InitializePages pages = new InitializePages(driver, ETO, WebActionUtil);
		int indexUserName = ExcelUtil.getColoumIndex(EXCELPATH, "Credentials", "UserName");
		String[] userData = ExcelUtil.toReadExcelData(EXCELPATH, "Credentials", "Approver_1");
		int indexPassword = ExcelUtil.getColoumIndex(EXCELPATH, "Credentials", "Password");
		String[] userPass = ExcelUtil.toReadExcelData(EXCELPATH, "Credentials", "Approver_1");
		pages.loginPage.signToApplication(userData[indexUserName],userPass[indexPassword]);
		pages.requistionRequest.projectDetail( projectName);
		pages.requistionRequest.jobDetails(skillvalue, skill, jobvalue, employeeGroup, band, SubBand, job, secondaryPSA);
		pages.requistionRequest.positionAndLocationDetail(noOfPosition);
		pages.requistionRequest.submisitionOfThePage();
		pages.requistionRequest.additionaJobDetails(designationType, experience);
		pages.requistionRequest.joiningDetails(state, city, joiningLocation, secondaryJoiningLocation);
		pages.requistionRequest.billingDetails(interviewer1,interviewer2,billtype);
		pages.closeRequisition.getApproverData();
		WebActionUtil.navigateToUrl(BaseTest.URL);
		 String approver1Id = BaseTest.map.get("approver1");
	     pages.loginPage.signToApplication(approver1Id,userPass[indexPassword]);
        pages.closeRequisition.closeRequisition();
	}
}
