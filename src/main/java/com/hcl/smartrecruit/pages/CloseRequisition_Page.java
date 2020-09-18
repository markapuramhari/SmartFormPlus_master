package com.hcl.smartrecruit.pages;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hcl.smartrecruit.baseutil.BaseTest;
import com.hcl.smartrecruit.util.WebActionUtil;
/**
 * Description: This class implements the methods for closing the created Requisition.
 * @author Aatish Slathia
 * 
 */
public class CloseRequisition_Page {

	public WebDriver driver;
	public WebActionUtil WebActionUtil;
	public long ETO = 10;

	public CloseRequisition_Page(WebDriver driver, long ETO, WebActionUtil WebActionUtil) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.WebActionUtil = WebActionUtil;
		this.ETO = ETO;
	}
	
	/*Approver Text */
	@FindBy(xpath = "//a[text()='Approver Role']")
		private WebElement txtapprover;

	/*Pending for my approval */
	@FindBy(xpath = "//div[@class='small-box bg-tile cardTile']/descendant::p[text()='Pending for My Approvals']")
		private WebElement pendingActions;

	/* Requisition search box */
	@FindBy(id="ReqNo")
		private WebElement searchBxrequNumber;

	/* Search button */
	@FindBy(id="SearchReq")
		private WebElement btnsearch;

	/*Edit button */
	@FindBy(xpath = "//div[@class='anchor-inBlock']/a[@id='edit']")
		private WebElement btnedit;

	/*Select Action */
	@FindBy(xpath = "//select[@id='Action']")
		private WebElement selectAction;

	/*Close action */
	@FindBy(xpath = "//select[@id='Action']/option[text()='Close']")
		private WebElement closeAction;

	/* Reason */
	@FindBy(xpath = "//select[@id='Reason']")
		private WebElement reason;

	/*Select Reason */
	@FindBy(xpath = "//select[@id='Reason']/option[text()='SR Closure - Incorrect details']")
		private WebElement selectReason;
	
	/*Approver id */
	@FindBy(xpath = "//table[@class='table table-striped table-bordered table-hover example no-footer']/tbody/tr/td[2]")
	private WebElement txtapproverId;
	
	/*Remarks*/
	@FindBy(xpath = "//div[@class='form-group has-feedback has-error']/textarea[@id='Remarks']")
		private WebElement txtremarks;
	
	/*Submit button */
	@FindBy(id="btnsubmit")
		private WebElement btnSubmit;
	
	/*Approver Id */
	@FindBy(xpath = "//table[@class='table table-striped table-bordered table-hover example no-footer']/tbody/tr/td[2]")
	private WebElement approverId;
	
     /*Approver Role */
	@FindBy(xpath = "//a[text()='Approver Role']")
	private WebElement approver;
	
	 /*Requisition number */
	@FindBy(xpath = "//input[@id='ReqNo']")
	private WebElement txtrequNumber;
	/*Search Button*/
	@FindBy(id = "SearchReq")
	private WebElement btnSearch;
	
	@FindBy(xpath = "//div[@class='anchor-inBlock']/a[@id='edit']")
	private WebElement btnEdit;
	
	/*Approver Link */
	public WebElement approverLink(String approverLink) {
		String xpath =  "//a[text()='" +approverLink+ "']/../following-sibling::td[6]//a[.='Initiator/Approver']";
		return driver.findElement(By.xpath(xpath));
	}
	
	/**
	 * Description : Method to get approver data
	 * @author Aatish Slathia 
	 */
	
	
	public  synchronized void getApproverData() {
		WebActionUtil.waitForThePresenceOfElement(5);
		String value = BaseTest.map.get("requisitionNumber");
		WebActionUtil.clickOnElement(approverLink(value), "Approver link ");
		WebActionUtil.waitForThePresenceOfElement(5);
		String approverIdText = WebActionUtil.getApproverIdText(txtapproverId);
		BaseTest.map.put("approver1", approverIdText);
		
	}

	/**
	 * Description : Method for closing the requisition
	 * @author Aatish Slathia
	 */
	
public synchronized void closeRequisition() throws InterruptedException, IOException, AWTException {
	try {
	
		WebActionUtil.clickOnElement(txtapprover, "Approver Text");
		WebActionUtil.waitForThePresenceOfElement(5);
		WebActionUtil.clickElementByUsingJS(pendingActions, "Pending Actions Text");
		WebActionUtil.waitForThePresenceOfElement(5);
		WebActionUtil.typeText(searchBxrequNumber, BaseTest.map.get("requisitionNumber"), "Requisition Number TextBox");
		WebActionUtil.clickOnElement(btnsearch, "Serch Button ");
		WebActionUtil.clickOnElement(btnedit, "Action TickIcon ");
		WebActionUtil.clickOnElement(selectAction, "Select Action ");
		WebActionUtil.clickOnElement(closeAction, "Closed  Option");
		WebActionUtil.clickOnElement(reason, "Reason DropDwon");
		WebActionUtil.clickOnElement(selectReason, "Reason Option");
		WebActionUtil.typeText(txtremarks, "Closing Requisition ", "Remark TextBox");
		WebActionUtil.waitForThePresenceOfElement(10);
		WebActionUtil.clickOnElement(btnSubmit, "Submit Button");
	} catch (Exception e) {
		WebActionUtil.error(e.getMessage());
		WebActionUtil.info("Unable to performe action Search Created Requisition");
		Assert.fail("Unable to performe action Search Created Requisition");
		}
	}



}
