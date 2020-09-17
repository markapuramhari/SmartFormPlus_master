package com.hcl.smartrecruit.testscripts;

import org.testng.annotations.Test;

import com.hcl.smartrecruit.baseutil.BaseTest;
import com.hcl.smartrecruit.baseutil.InitializePages;
import com.hcl.smartrecruit.commonutils.ExcelUtil;
import com.hcl.smartrecruit.dataproviders.CreateRequisitionDataProvider;


public class CreateNewRequisition extends BaseTest{
	/**
	 * Description:This class implements the scenario of creating new  requisition.
	 * @author : Shreya U ,Vivek Dogra,Aatish Slatia  
	 */

	@Test(description = "Create Requisition", dataProvider = "TestDataProvider", dataProviderClass = CreateRequisitionDataProvider.class)

	
	public void TC_CreateNewRequisitionForm(String projectName,String skillvalue,String skill,String jobvalue,String job,String employeeGroup,String band,String subBand,String secondaryPSA,String experience,String noOfPosition,String designationType,
			String joiningLocation,String secondaryJoiningLocation,String state
			,String city,String billtype,String interviewer1,String interviewer2,String statusRemarks)  {
		InitializePages pages = new InitializePages(driver, ETO, WebActionUtil);
		int indexUserName = ExcelUtil.getColoumIndex(EXCELPATH, "Credentials", "UserName");
		String[] userData = ExcelUtil.toReadExcelData(EXCELPATH, "Credentials", "Approver_1");
		int indexPassword = ExcelUtil.getColoumIndex(EXCELPATH, "Credentials", "Password");
		String[] userPass = ExcelUtil.toReadExcelData(EXCELPATH, "Credentials", "Approver_1");
		pages.loginPage.signToApplication(userData[indexUserName],userPass[indexPassword]);
		pages.requistionRequest.projectDetail( projectName);
		pages.requistionRequest.jobDetails(skillvalue, skill, jobvalue, employeeGroup, band, subBand, job, secondaryPSA);
		pages.requistionRequest.positionAndLocationDetail(noOfPosition);
		pages.requistionRequest.submisitionOfThePage();
		pages.requistionRequest.additionaJobDetails(designationType, experience);
		pages.requistionRequest.joiningDetails(state, city, joiningLocation, secondaryJoiningLocation);
		pages.requistionRequest.billingDetails(interviewer1,interviewer2,billtype);

		
	}
}
