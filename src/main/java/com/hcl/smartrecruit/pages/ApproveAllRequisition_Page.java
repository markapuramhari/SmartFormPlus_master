package com.hcl.smartrecruit.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hcl.smartrecruit.baseutil.BaseTest;
import com.hcl.smartrecruit.util.WebActionUtil;

/**
 * Description: This class implements the methods for approval of the requisition.
 * @author Aatish Slathia
 * 
 */
public class ApproveAllRequisition_Page {
	public WebDriver driver;
	public WebActionUtil WebActionUtil;
	public long ETO = 10;

	public ApproveAllRequisition_Page(WebDriver driver, long ETO, WebActionUtil WebActionUtil) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.WebActionUtil = WebActionUtil;
		this.ETO = ETO;
	}

	/* Approver Role */
	@FindBy(xpath = "//a[text()='Approver Role']")
	private WebElement txrapprover;

	/* Pending for my approval */
	@FindBy(xpath = "//div[@class='small-box bg-tile cardTile']/descendant::p[text()='Pending for My Approvals']")
	private WebElement pendingApprovals;

	/* Requisition number */
	@FindBy(xpath = "//input[@id='ReqNo']")
	private WebElement searchBxRequNumber;

	/* Search Button */
	@FindBy(xpath = "//input[@id='SearchReq']")
	private WebElement btnserch;

	/* Edit Tick icon */
	@FindBy(xpath = "//div[@class='anchor-inBlock']/a[@id='edit']")
	private WebElement icnTick;

	/* approval information */
	@FindBy(xpath = "//a[text()=' Interviewer/Approver Details ']")
	private WebElement approvelInformation;

	/* Second Approver */
	@FindBy(xpath = "//*[@id='Interviewer']/div/table/tbody/tr[2]/td[2]")
	private WebElement txtapprover2;

	/* Third Approver */
	@FindBy(xpath = "//*[@id='Interviewer']/div/table/tbody/tr[3]/td[2]")
	private WebElement txtApprover3;

	/* Requisition Actions */
	@FindBy(xpath = "//a[contains(text(),'Requisition Action')]")
	private WebElement requisitionActions;

	/* Remarks text box */
	@FindBy(xpath = "//div[@class='form-group']/textarea[@id='Remarks']")
	private WebElement txtRemarks;

	/* Submit button */
	@FindBy(xpath = "//input[@id='btnsubmit']")
	private WebElement btnSubmit;

	/* Approve status */
	@FindBy(xpath = "//table[@id='entry-grid']//descendant::td[text()='Approved']")
	private WebElement txtapprovedstatus;

	/**
	 * Description :Method to approve the requisition for first approver
	 * @author Aatish Slathia
	 * @param statusRemarks
	 * 
	 */

	public synchronized void approveRequistionStage1(String statusRemarks) {
		try {
			WebActionUtil.clickOnElement(txrapprover, "Approve text");
			WebActionUtil.clickOnElement(pendingApprovals, "Pending Approver text");
			WebActionUtil.typeText(searchBxRequNumber, BaseTest.map.get("requisitionNumber"),
					"Requisiton number serch box ");
			WebActionUtil.clickOnElement(btnserch, "Serch Button ");
			WebActionUtil.clickOnElement(icnTick, "Tick icon ");
			WebActionUtil.clickOnElement(approvelInformation, "Approver ID link");
			String approver2 = WebActionUtil.getApproverIdTextOfApprovers(txtapprover2);
			BaseTest.map.put("approver2", approver2);

			WebActionUtil.clickOnElement(requisitionActions, "Requisition actions d ropdown");
			WebActionUtil.typeText(txtRemarks, statusRemarks, "Remarks textbox");
			WebActionUtil.clickOnElement(btnSubmit, "Submit button");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.info("Unable to performe action on Approve Requistion Stage1");
			Assert.fail("Unable to performe action on Approve Requistion Stage1");
		}
	}

	/**
	 * Description : Method to approve the requisition for Second approver
	 * @author Aatish Slathia
	 * @param statusRemarks
	 */

	public synchronized void approveRequistionStage2(String statusRemarks) {
		try {
			WebActionUtil.clickOnElement(txrapprover, "Approve text");
			WebActionUtil.clickOnElement(pendingApprovals, "Pending Approver text");
			WebActionUtil.typeText(searchBxRequNumber, BaseTest.map.get("requisitionNumber"),
					"Requisiton number serch box ");
			WebActionUtil.clickOnElement(btnserch, "Serch button ");
			WebActionUtil.clickOnElement(icnTick, "Tick button ");
			WebActionUtil.clickOnElement(approvelInformation, "Approver ID link");
			String approver3 = WebActionUtil.getApproverIdTextOfApprovers(txtApprover3);
			BaseTest.map.put("approver3", approver3);
			WebActionUtil.clickOnElement(requisitionActions, "Requisition Actions dropdown");
			WebActionUtil.typeText(txtRemarks, statusRemarks, "Remarks text box");
			WebActionUtil.clickOnElement(btnSubmit, "Submit button");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.info("Unable to performe action on Approve Requistion Stage2");
			Assert.fail("Unable to performe action on Approve Requistion Stage2");
		}

	}

	/**
	 * Description : Method to approve the requisition for Third approver
	 * @author Aatish Slathia
	 * @param statusRemarks 
	 */

	public synchronized void approveRequistionStage3(String statusRemarks) {
		try {
			WebActionUtil.clickOnElement(txrapprover, "Approve text");
			WebActionUtil.clickOnElement(pendingApprovals, "Pending Approver text");
			WebActionUtil.typeText(searchBxRequNumber, BaseTest.map.get("requisitionNumber"),
					"Requisiton Number Serch Box ");
			WebActionUtil.clickOnElement(btnserch, "Serch Button ");
			WebActionUtil.clickOnElement(icnTick, "Tick button ");
			WebActionUtil.typeText(txtRemarks, statusRemarks, "Remarks text box");
			WebActionUtil.clickOnElement(btnSubmit, "Submit button");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.info("Unable to performe action on Approve Requistion Stage3");
			Assert.fail("Unable to performe action on Approve Requistion Stage3");
		}

	}
	/**
	 * Description : Method to check the pending approvals
	 * @author Aatish Slathia
	 */

	public synchronized void initiatorStage() {
		try {
			WebActionUtil.clickOnElement(pendingApprovals, "Pending for fulfillment");
			WebActionUtil.typeText(searchBxRequNumber, BaseTest.map.get("requisitionNumber"),
					"Requisition number search box");
			WebActionUtil.clickOnElement(btnserch, "Search button");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.info("Unable to click on Initiator Stage");
			Assert.fail("Unable to click on Initiator Stage");
		}
	}

	/**
	 * Description : Method to verify the approval text
	 * @author Aatish Slathia
	 * @param value
	 */

	public synchronized void verifyapprovaltext(String value) {
		try {
			WebActionUtil.waitForElement(txtapprovedstatus, driver, "approval status");
			WebActionUtil.verifyElementText(txtapprovedstatus, value);
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.info("Unable to verify Approval Text");
			Assert.fail("Unable to verify Approval Text");
		}
	}
}
