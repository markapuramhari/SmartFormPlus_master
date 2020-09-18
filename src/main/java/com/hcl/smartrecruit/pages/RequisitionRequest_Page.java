package com.hcl.smartrecruit.pages;

import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hcl.smartrecruit.baseutil.BaseTest;
import com.hcl.smartrecruit.util.WebActionUtil;

/**
 * Description: This class implements the methods for creation of new
 * Requisition form.
 * 
 * @author Aatish Slathia
 * 
 */
public class RequisitionRequest_Page {

	public WebDriver driver;
	public WebActionUtil WebActionUtil;
	public long ETO = 10;

	public RequisitionRequest_Page(WebDriver driver, long ETO, WebActionUtil WebActionUtil) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.WebActionUtil = WebActionUtil;
		this.ETO = ETO;
	}

	/* Initiator Actions */
	@FindBy(xpath = "//a[contains(text(),'Initiator Actions')]")
	private WebElement ddinitiatorActions;

	/* Create new requisition */
	@FindBy(xpath = "//a[contains(text(),'Create New Requisition')]")
	private WebElement createaNewRequisitionOption;

	/* Project name */
	@FindBy(id = "autocompleteinput")
	private WebElement txtProjectName;

	/* Request type element */
	@FindBy(id = "RequestType")
	private WebElement ddRequestType;

	/* NewResourceRequest */
	@FindBy(xpath = "//a[text()='New Resource Request']")
	private WebElement ddResourceRequest;

	/* New Position */
	@FindBy(xpath = "//a[text()='New Position']")
	private WebElement txtNewPosition;
	
	/* New Position */
	@FindBy(xpath = "(//a[text()='New Resource Request'])[2]")
	private WebElement txtNewResourceRequest;

	/* Skill text box */
	@FindBy(id = "Skills")
	private WebElement txtSkill;

	/* Skill id text box */
	@FindBy(xpath = "(//input[@id='txtskill' and @placeholder='Enter min. 3 characters'])[1]")
	private WebElement txtSkillDetails;

	/* Plus button element under skill */
	@FindBy(xpath = "(//table[@id='tbltempSearchSkill'])[1]/descendant::i[@class='icon-add addSkillicon']")
	private WebElement btnPlusUnderSkill;

	/* Done button under skill */
	@FindBy(xpath = "//input[@name='primary']/parent::td/child::label")
	private WebElement doneButtonSkill;

	/* Done button under skill details */
	@FindBy(xpath = "(//button[text()='Done'and@type='submit' ])[1]")
	private WebElement btnDoneUnderSkill;

	/* Job Text */
	@FindBy(id = "ForBulkHiring")
	private WebElement txtJob;

	/* Job text box */
	@FindBy(id = "txtJob")
	private WebElement txtJobType;

	/* Tick Icon under job details */
	@FindBy(xpath = "//ul[@class='jobListUL']/descendant::i")
	private WebElement icnTickJob;

	/* Done button under job */
	@FindBy(xpath = "//button[text()='Done' and @class='btn primary-button updatejob']")
	private WebElement btnDoneUndeJob;

	/* Employee group name */
	@FindBy(xpath = "(//span[text()='--Select Employee Group--'])[1]")
	private WebElement txtEmployeGroupName;

	/* Select band drop down name */
	@FindBy(xpath = "(//span[text()='--Select Band--'])[1]")
	private WebElement ddBandName;

	/* Select sub band */
	@FindBy(xpath = "(//span[text()='--Select Sub-Band--'])[1]")
	private WebElement ddSubBand;

	/* Secondary Psa Dropdown */
	@FindBy(xpath = "(//span[text()='Noida'])[3]")
	private WebElement secondaryPSA;

	/* Select Secondary Psa element from excel */
	@FindBy(xpath = "(//span[text()='ENOI'])[2]")
	private WebElement selectSecondaryPSA;

	/* No of position */
	@FindBy(id = "VacancyCount")
	private WebElement txtNoOfPosition;

	/* Yes button */
	@FindBy(xpath = "//div[@class='sa-confirm-button-container']//descendant::button[text()='Yes']")
	private WebElement btnYes;

	/* Save as Draft button */
	@FindBy(id = "SaveAsDraft")
	private WebElement saveAsDraftBtn;

	/* Experience Drop Down */
	@FindBy(xpath = "(//span[text()='--Select Experience --'])[1]")
	private WebElement ddExperience;

	/* Qualification text */
	@FindBy(xpath = "//span[text()='--Select Qualification--']")
	private WebElement txtQualification;

	/* Select qualification from drop down */
	@FindBy(xpath = "(//ul[@class='dropdown-menu inner'])[2]//descendant::a[@class='opt ng-binding ng-scope ng-scope'][3]")
	private WebElement selectQualification;

	/* Designation */
	@FindBy(xpath = "//button[@class='btn dropdown-toggle bs-placeholder btn-default']//span[text()=' --Select Designation--']")
	private WebElement desgination;

	/* Cwl joining location element */
	@FindBy(xpath = "(//span[text()='--Select Joining location --'])[1]")
	private WebElement ddCwlJoiningLocation;

	/* Select Cwl Joining location */
	@FindBy(xpath = "//h4[text()='Joining Details']/parent::div/child::div[3]//div[@class='bs-searchbox']/input")
	private WebElement txtSelectCwlLoaction;

	/* Secondary joining location element */
	@FindBy(xpath = "//button[@class='btn dropdown-toggle bs-placeholder btn-default']//span[text()='--Select Secondary Joining location --']")
	private WebElement cwlSecondaryJoiningLocation;

	// Select Cwl secondary joining location
	@FindBy(xpath = "//h4[text()='Joining Details']/parent::div/child::div[4]//div[@class='bs-searchbox']/input")
	private WebElement txtSelectSceondaryJoiningLocation;

	/* State DropDown */
	@FindBy(xpath = "//button[@class='btn dropdown-toggle bs-placeholder btn-default']//span[text()=' --Select State--']")
	private WebElement ddState;

	/* City DropDown */
	@FindBy(xpath = "//button[@class='btn dropdown-toggle bs-placeholder btn-default']//span[text()=' --Select City--']")
	private WebElement ddCity;

	/* Consent for Tp */
	@FindBy(xpath = "//ul[@class='list-inline typeInput']/li/label[text()='No']")
	private WebElement rdbtnTp;

	/* Save as draft button */
	@FindBy(id = "SaveAsDraft")
	private WebElement btnSaveDraft;

	/* Billing type element */
	@FindBy(xpath = "//button[@class='btn dropdown-toggle bs-placeholder btn-default']//span[text()='--Select Bill-Type--']")
	private WebElement billingType;

	/* Interviewer one */
	@FindBy(name = "interviewerid1TP1")
	private WebElement interviewerOne;

	/* Interviewer two */
	@FindBy(name = "interviewerid2TP1")
	private WebElement interviewerTwo;

	/* Save submit Button */
	@FindBy(xpath = "(//button[@type='submit'])[2]")
	private WebElement btnSubmit;

	/* Yes button */
	@FindBy(xpath = "//button[text()='Yes']")
	private WebElement finalYesConformation;

	/* Primary Radio Button */
	@FindBy(xpath = "//input[@name='primary']/../label")
	private WebElement rdbtnprimary;

	/* Entity Name */
	@FindBy(xpath = "//select[@id='EntityName']")
	private WebElement ddentity;

	/* Entity Submit button */
	@FindBy(id = "btnEntitySubmit")
	private WebElement btnEntitySubmit;

	/* Entity Name */
	@FindBy(xpath = "//button[@class='btn dropdown-toggle bs-placeholder btn-default' and @data-title='--Select PSA--']")
	private WebElement ddpsa;

	/* Entity Name */
	@FindBy(xpath = "(//div[@class='dropdown-menu open'])[9]/div[@class='bs-searchbox']/input")
	private WebElement txtpsa;
	
	
	/* Entity Name */
	@FindBy(id = "TxtjobDesription")
	private WebElement taJobDescription;
	
	
	/* Entity Name */
	@FindBy(id = "OnBoardingDate")
	private WebElement txtonboarding;
	
	
	/* Search job element */
	public void selectPSA(String psa) {
		driver.findElement(
				By.xpath("(//li[@class='dropdown-header ng-scope'])[1]/following-sibling::li/descendant::span[text()='"
						+ psa + "']"))
				.click();
	}

	/* Search job element */
	public void searchJob(String job) {
		driver.findElement(By.xpath("(//div[contains(text(),'"+ job +"')])[1]")).click();
	}

	/* Select bill type */
	public void selectBillType(String billableType) {
		driver.findElement(By.xpath("//span[text()='" + billableType + "']")).click();
	}

	/* Select desigination */
	public void desginationdropdown(String desiginationType) {
		driver.findElement(By.xpath("(//span[text()='" + desiginationType + "'])[1]")).click();
	}

	/* Select skill element from table */
	public void skillSelectOption(String skill) {
		WebActionUtil.waitForThePresenceOfElement(5);
		driver.findElement(By.xpath("//div[text()='" + skill + "']")).click();
	}

	/* Select Experience */
	public void selectExperience(String experience) {
		driver.findElement(By.xpath("//span[text()='" + experience + "']")).click();
	}

	/* Select Employee Group */
	public void selectEmployeGroupName(String groupName) {
		driver.findElement(By.xpath("//div[@class='dropdown-menu open']//span[text()='" + groupName + "']")).click();
	}

	/* Select city from the dropdown */
	public void selectCity(String city) {
		driver.findElement(By.xpath("//span[text()='" + city + "']")).click();
	}

	/* Select band */
	public void selectBandDropdown(String band) {
		driver.findElement(By.xpath("//span[text()='" + band + "']")).click();
	}

	/* Select State element */
	public void selectState(String selectState) {
		driver.findElement(By.xpath("//span[text()='" + selectState + "']")).click();
	}

	/* Sub band option element */
	public void selectSubBandOption(String subBand) {
		driver.findElement(By.xpath("//span[text()='" + subBand + "']")).click();
	}

	public void selectCWLlocation(String cwllocation) {
		driver.findElement(By.xpath("(//span[text()='" + cwllocation + "'])[1]")).click();

	}

	/* Secondary location */
	public void selectSecondaryCWLlocation(String seccwllocation) {
		driver.findElement(
				By.xpath("(//ul[@class='dropdown-menu inner'])[7]/descendant::span[text()='" + seccwllocation + "']"))
				.click();

	}

	/* PSA location */
	public void selectPSAlocation(String psaLocation) {
		driver.findElement(By.xpath("((//span[text()='" + psaLocation + "'])[3]")).click();

	}

	/* Secondary PSA location */
	public void selectSecondaryPSAlocation(String secPsaLocation) {
		driver.findElement(By.xpath("(//span[text()='" + secPsaLocation + "'])[2]")).click();

	}

	/**
	 * Description Fills the project details in Requisition Form.
	 * 
	 * @author Aatish Slathia
	 * @param projectName
	 */

	public synchronized void projectDetail(String projectName, String entityname) {
		try {
			WebActionUtil.actionMouseHover(ddinitiatorActions, "Initiator Action dropdown");
			WebActionUtil.clickOnElement(createaNewRequisitionOption, "New Requisition option");
			// WebActionUtil.selectByText(ddentity, entityname);
			// WebActionUtil.clickOnElement(btnEntitySubmit, "Entity Submit button");

			//WebActionUtil.clearText(txtProjectName, "Project name text box");
			//WebActionUtil.typeText(txtProjectName, projectName, "Project name text box");
			WebActionUtil.clickOnElement(ddRequestType, "RequestType dropdown");
			WebActionUtil.actionMouseHover(ddResourceRequest, "NewRequest option");
			WebActionUtil.clickOnElement(txtNewResourceRequest, "New resource request");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.info("Unable to performe action Project Details");
			Assert.fail("Unable to performe action Project Details");
		}
	}

	/**
	 * Description : Fills the job Details in Requisition form
	 * 
	 * @author Aatish Slathia
	 * @param skillValue
	 * @param skill
	 * @param jobValue
	 * @param groupName
	 * @param subBand
	 * @param job
	 * @param secondaryPsa
	 */

	public synchronized void jobDetails(String skillValue, String skill, String jobValue, String groupName, String band,
			String subBand, String job, String secondaryPsa, String psa) {
		try {
			WebActionUtil.clickOnElement(txtSkill, "Id skill text box");
			WebActionUtil.typeText(txtSkillDetails, skillValue, "SkillDetail text box");
			skillSelectOption(skill);
			WebActionUtil.clickOnElement(btnPlusUnderSkill, "Plus button under skills");
			//WebActionUtil.waitForElement(rdbtnprimary, "Primary Radio Button", 10);
			WebActionUtil.waitForThePresenceOfElement(2);
			WebActionUtil.clickByJs(rdbtnprimary, "Primary Radio Button");
			WebActionUtil.clickOnElement(btnDoneUnderSkill, "Done button ");
			WebActionUtil.clickOnElement(txtJob, "Job tex box detail ");
			WebActionUtil.typeText(txtJobType, jobValue, "Job text box ");
			searchJob(job);
			WebActionUtil.waitForThePresenceOfElement(2);
			WebActionUtil.waitForElement(icnTickJob, "Tick Icon", 10);
			WebActionUtil.clickOnElement(icnTickJob, "SelectJob tick icon");
			WebActionUtil.waitForThePresenceOfElement(2);
			WebActionUtil.waitForElement(btnDoneUndeJob, "Done Button", 10);
			WebActionUtil.clickOnElement(btnDoneUndeJob, "Save button ");
			WebActionUtil.waitForThePresenceOfElement(2);

			WebActionUtil.waitForElement(txtEmployeGroupName, "Employee group name", 10);
			WebActionUtil.clickOnElement(txtEmployeGroupName, "Employe group name dropdown");
			WebActionUtil.waitForThePresenceOfElement(2);
			selectEmployeGroupName(groupName);
			WebActionUtil.waitForElement(ddBandName, "Brand name drop down", 10);
			WebActionUtil.clickOnElement(ddBandName, "Band element dropdown");
			selectBandDropdown(band);
			WebActionUtil.waitForThePresenceOfElement(2);
			WebActionUtil.waitForElement(ddSubBand, "Sub brand name drop down", 10);
			WebActionUtil.clickOnElement(ddSubBand, "SubBand Element dropdown");
			WebActionUtil.waitForThePresenceOfElement(2);
			selectSubBandOption(subBand);
			WebActionUtil.waitForThePresenceOfElement(2);
			WebActionUtil.actionClick(ddpsa, "PSA Drop down");
			WebActionUtil.waitForThePresenceOfElement(2);
			WebActionUtil.typeText(txtpsa, psa, "PSA Text box");
			WebActionUtil.waitForThePresenceOfElement(2);
			selectPSA(psa);
			
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.info("Unable to performe action on Job Details ");
			Assert.fail("Unable to performe action on Job Details ");
		}
	}

	/**
	 * Description : Fills the Position and Location details in Requisition Form
	 * 
	 * @author Aatish Slathia
	 * @param value
	 */

	public void positionAndLocationDetail(String value) {
		try {
			WebActionUtil.waitForThePresenceOfElement(5);
			WebActionUtil.waitForElement(txtNoOfPosition, "Number of position text box", 10);
			WebActionUtil.typeText(txtNoOfPosition, value, "Number of Position text box");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.info("Unable to performe action Position and Location Details");
			Assert.fail("Unable to performe action on Position and Location Details ");
		}
	}

	/**
	 * Description Submits the first page of the Requisition Form
	 * 
	 * @author Aatish Slathia
	 */

	public void submisitionOfThePage() {
		try {
			WebActionUtil.waitTillPageLoad(10);
			WebActionUtil.waitForThePresenceOfElement(5);
			WebActionUtil.waitForElement(btnSubmit, "Submit button", 10);
			WebActionUtil.clickOnElement(btnSubmit, "Submit button ");
			WebActionUtil.waitForThePresenceOfElement(5);
			WebActionUtil.checkForAlert(10);
			WebActionUtil.acceptAlert();
			WebActionUtil.waitForThePresenceOfElement(5);
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.info("Unable to performe action on Submit The Page ");
			Assert.fail("Unable to performe action on Submit The Page");
		}
	}

	/**
	 * Description Fills the Additional JobDetails in Requisition Form
	 * 
	 * @author Aatish Slathia
	 * @param desiginationType
	 * @param experience
	 */

	public synchronized void additionaJobDetails(String desiginationType, String experience) {
		try {
			WebActionUtil.waitForThePresenceOfElement(2);
			WebActionUtil.waitForElement(ddExperience, "Experience dropdown", 10);
			WebActionUtil.actionClick(ddExperience, "Experience drop down");
			selectExperience(experience);
			WebActionUtil.waitForElement(txtQualification, "Qualification drop down", 10);
			WebActionUtil.clickElementByUsingJS(txtQualification, "Qualification dropdown");
			WebActionUtil.waitForElement(selectQualification, "Select qualification", 10);
			WebActionUtil.clickElementByUsingJS(selectQualification, "Select Qualification");
			WebActionUtil.waitForThePresenceOfElement(4);
			WebActionUtil.clickElementByUsingJS(taJobDescription, "Job description");
			WebActionUtil.clearText(taJobDescription, "Job description text area ");
			WebActionUtil.typeText(taJobDescription, "Admin Role", "Job description text area ");
			WebActionUtil.clickElementByUsingJS(desgination, "Desgination dropdown");
			WebActionUtil.waitForThePresenceOfElement(4);
			desginationdropdown(desiginationType);
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.info("Unable to performe action Additional Job Details ");
			Assert.fail("Unable to performe action on Additional Job Details ");
		}
	}

	/**
	 * Description Fills the Joining Details in Requisition Form
	 * 
	 * @author Aatish Slathia
	 * @param selectState
	 * @param city
	 * @param joinigLocation
	 * @param secondaryJoiningLocation
	 */

	public void joiningDetails(String selectState, String city, String joinigLocation,
			String secondaryJoiningLocation) {
		try {
			WebActionUtil.waitForThePresenceOfElement(2);
			WebActionUtil.actionClick(ddCwlJoiningLocation, "Cwl joining Location");
			WebActionUtil.typeText(txtSelectCwlLoaction, joinigLocation, "Location dropdown");
			WebActionUtil.waitForThePresenceOfElement(2);
			selectCWLlocation(joinigLocation);
			WebActionUtil.waitForThePresenceOfElement(2);
			/*
			 * WebActionUtil.actionClick(cwlSecondaryJoiningLocation,
			 * "Cwl Secondary location"); WebActionUtil.waitForThePresenceOfElement(2);
			 * WebActionUtil.typeText(txtSelectSceondaryJoiningLocation,
			 * secondaryJoiningLocation, "Secondary Location dropdown");
			 * WebActionUtil.waitForThePresenceOfElement(2);
			 * selectSecondaryCWLlocation(secondaryJoiningLocation);
			 */

			WebActionUtil.clickOnElement(ddState, "State drop drown");
			selectState(selectState);
			WebActionUtil.clickOnElement(ddCity, "City dropdown ");
			selectCity(city);
			WebActionUtil.clickByJs(rdbtnTp, "Radio Button ");
			WebActionUtil.waitForThePresenceOfElement(5);
			WebActionUtil.clickOnElement(btnSaveDraft, "Save Draft button");
			WebActionUtil.checkForAlert(10);
			WebActionUtil.acceptAlert();
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.info("Unable to performe action on Joining Details");
			Assert.fail("Unable to performe action on Joinign Details ");
		}
	}

	/**
	 * Description Fills Billing details in the Requisition form.
	 * 
	 * @author Aatish Slathia Form
	 * @param interviewer1
	 * @param interviewer2
	 * @param billableType
	 */
	public synchronized void billingDetails(String interviewer1, String interviewer2, String billableType) {
		try {
			WebActionUtil.waitForThePresenceOfElement(5);
			WebActionUtil.clickElementByUsingJS(billingType, "Bill Type dropdown");
			WebActionUtil.waitForThePresenceOfElement(2);
			selectBillType(billableType);
			WebActionUtil.typeText(txtonboarding,"25-Dec-2020", "On boarding date");
			WebActionUtil.actionClick(interviewerOne, "nterviewer one TextBox");
			WebActionUtil.typeText(interviewerOne, interviewer1, "Interviewer 1 text box");
			WebActionUtil.actionClick(interviewerTwo, "nterviewer Two TextBox");
			WebActionUtil.typeText(interviewerTwo, interviewer2, "Interviewer two text box");
			WebActionUtil.waitForThePresenceOfElement(3);
			WebActionUtil.clickOnElement(btnSubmit, "Submit button ");
			WebActionUtil.waitForThePresenceOfElement(5);
			WebActionUtil.clickOnElement(finalYesConformation, "Submit button ");
			WebActionUtil.waitForThePresenceOfElement(5);
			WebActionUtil.waitForThePresenceOfElement(5);
			WebActionUtil.checkForAlert(10);
			String reqNum = WebActionUtil.getText();
			BaseTest.map.put("requisitionNumber", reqNum);
			BaseTest.logger.info(BaseTest.map.get("requisitionNumber"));
			WebActionUtil.acceptAlert();
			WebActionUtil.waitForThePresenceOfElement(5);
			WebActionUtil.switchToTab(1);
			WebActionUtil.waitForThePresenceOfElement(5);
			WebActionUtil.closeTab();
			WebActionUtil.switchToTab(0);
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.info("Unable to performe action on Billing Details ");
			Assert.fail("Unable to performe action on Billing Details ");
		}
	}
}
