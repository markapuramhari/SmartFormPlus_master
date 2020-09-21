package com.hcl.smartrecruit.testscripts;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import com.hcl.smartrecruit.baseutil.BaseTest;
import com.hcl.smartrecruit.baseutil.InitializePages;
import com.hcl.smartrecruit.commonutils.ExcelUtil;
import com.hcl.smartrecruit.dataproviders.ApproveAllRequisitionDataProvider;
/**
 * Description:This class implements the scenario of approving the created requisition request by all approvers.
 * @author : Shreya U ,Vivek Dogra,Aatish Slatia  
 */
public class ApproveAllRequisition extends BaseTest {

	@Test(description = "Approve Requisition", dataProvider = "TestDataProvider", dataProviderClass = ApproveAllRequisitionDataProvider.class)

	public synchronized void TC_ApproveAllRequisition(String entityname,String projectName, String skillvalue, String skill,
			String jobvalue, String job, String employeeGroup, String band, String subBand,String psa, String secondaryPSA,
			String experience, String noOfPosition, String designationType, String joiningLocation,
			String secondaryJoiningLocation, String state, String city, String billtype, String interviewer1,
			String interviewer2, String statusRemarks) throws InterruptedException, AWTException, IOException {
		InitializePages pages = new InitializePages(driver, ETO, WebActionUtil);
		int indexUserName = ExcelUtil.getColoumIndex(EXCELPATH, "Credentials", "UserName");
		String[] userData = ExcelUtil.toReadExcelData(EXCELPATH, "Credentials", "Approver_1");
		int indexPassword = ExcelUtil.getColoumIndex(EXCELPATH, "Credentials", "Password");
		String[] userPass = ExcelUtil.toReadExcelData(EXCELPATH, "Credentials", "Approver_1");
		pages.loginPage.signToApplication(userData[indexUserName], userPass[indexPassword]);
		pages.requistionRequest.projectDetail(projectName,entityname);
		pages.requistionRequest.jobDetails(skillvalue, skill, jobvalue, employeeGroup, band, subBand, job,
				secondaryPSA,psa);
		pages.requistionRequest.positionAndLocationDetail(noOfPosition);
		pages.requistionRequest.submisitionOfThePage();
		pages.requistionRequest.additionaJobDetails(designationType, experience);
		pages.requistionRequest.joiningDetails(state, city, joiningLocation, secondaryJoiningLocation);
		pages.requistionRequest.billingDetails(interviewer1, interviewer2, billtype);
		pages.closeRequisition.getApproverData();
		WebActionUtil.navigateToUrl(BaseTest.URL);
		String approver1Id = BaseTest.map.get("approver1");
		pages.loginPage.signToApplication(approver1Id, userPass[indexPassword]);

		pages.approveAllRequisition.approveRequistionStage1(statusRemarks);
		WebActionUtil.navigateToUrl(BaseTest.URL);
		//Initiator id have to login again 
		pages.loginPage.signToApplication(userData[indexUserName], userPass[indexPassword]);
		pages.closeRequisition.getApproverData2();
		
		String approver2Id = BaseTest.map.get("approver2");
		pages.loginPage.signToApplication(approver2Id, userPass[indexPassword]);
		pages.approveAllRequisition.approveRequistionStage2(statusRemarks);

		WebActionUtil.navigateToUrl(BaseTest.URL);
		pages.loginPage.signToApplication(userData[indexUserName], userPass[indexPassword]);
//		String approver3Id = BaseTest.map.get("approver3");
//		pages.loginPage.signToApplication(approver3Id, userPass[indexPassword]);
//		pages.approveAllRequisition.approveRequistionStage3(statusRemarks);
//
//		WebActionUtil.navigateToUrl(BaseTest.URL);
//		pages.loginPage.signToApplication(userData[indexUserName], userPass[indexPassword]);
//
//		pages.approveAllRequisition.initiatorStage();
//		String status = ExcelUtil.getCellData(EXCELPATH, "ApproveAllRequisition", 1, 0);
//		pages.approveAllRequisition.verifyapprovaltext(status);

	}
}
