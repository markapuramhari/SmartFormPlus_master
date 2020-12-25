package com.cropin.pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.cropin.util.WebActionUtil;

public class CropPage {
	
	public WebDriver driver;
	public WebActionUtil WebActionUtil;
	public long ETO = 10;
	public CropPage(WebDriver driver,WebActionUtil WebActionUtil,long ETO) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.WebActionUtil = WebActionUtil;
		this.ETO = ETO;
	}
	
	// Variety Information
	/*Finding element of add new crop*/
	@FindBy(xpath="//button/span[text()=' Add ']")
	private WebElement btnAddCrop;
	
	/*Finding element of Add Variety*/
	@FindBy(xpath="//div/button[text()='Add Variety']")
	private WebElement optionAddVariety;
	
	/*Finding element of Add Subvariety*/
	@FindBy(xpath="//div/button[text()='Add Subvariety']")
	private WebElement optionAddSubvariety;
	
	/*Finding element of crop dropdown*/
	@FindBy(xpath="//mat-label[text()='Crop']/../../../mat-select[@role='listbox']")
	private WebElement dropdownCrop;
	
	/*Finding element of search field in dropdown*/
	@FindBy(xpath="//input[@placeholder='SEARCH...']")
	private WebElement searchInDropdown;
	
	/*Finding element at first index in dropdown*/
	@FindBy(xpath="//mat-option[@tabindex='0']")
	private WebElement selectFromDropdown;
	
	/*Finding element of textfield for crop variety in Add Variety page*/
	@FindBy(xpath="//mat-label[text()='Crop Variety ']/../../../input[@type='text']")
	private WebElement txtCropVariety;
	
	/*Finding element of textfield for variety short name*/
	@FindBy(xpath="//mat-label[text()='Variety_Short_Name ']/../../../input[@type='text']")
	private WebElement txtVarietyShortName;
	
	/*Finding element of Exp harvest days*/
	@FindBy(xpath="//mat-label[text()='Exp Harvest Days (from date of sowing) ']/../../../input[@type='number']")
	private WebElement txtExpHarvestDayVariety;
	
	/*Finding of element of Crop Price*/
	@FindBy(xpath="//mat-label[text()='Crop Price ']/../../../input[@type='number']")
	private WebElement txtCropPrice;
	
	/*Finding element of Price unit dropdown*/
	@FindBy(xpath="//mat-label[text()='Price Unit']/../../../mat-select[@role='listbox']")
	private WebElement dropdownPriceUnit;
	
	/*Finding element of Per Quantity dropdown*/
	@FindBy(xpath="//mat-label[text()='Per Quantity']/../../../mat-select[@role='listbox']")
	private WebElement dropdownPerQuantity;
	
	/*Finding element of Add yield per location*/
	@FindBy(xpath="//button/span/mat-icon[text()='add']")
	private WebElement btnAddYieldPerLocation;
	
	/*Finding element of Location in AddYieldPerLocation*/
	@FindBy(xpath="//mat-label[text()='Location']/../../../input[@placeholder='Enter a location']")
	private WebElement txtLocation;
	
	/*Finding element of Expected yield in AddYieldPerLocation*/
	@FindBy(xpath="//mat-label[text()='Expected Yield ']/../../../input[@type='number']")
	private WebElement txtExpectedYield;
	
	/*Finding element of Expected Yield Units dropdown in AddYieldPerLocation*/
	@FindBy(xpath="//mat-label[text()='Expected Yield Units']/../../../mat-select[@role='listbox']")
	private WebElement dropdownExpYieldUnits;
	
	/*Finding element of Refrence Area Unit dropdown in AddYieldPerLocation*/
	@FindBy(xpath="//mat-label[text()='Refrence Area Unit']/../../../mat-select[@role='listbox']")
	private WebElement dropdownRefrenceAreaUnit;

	/*Finding the element of save button */
	@FindBy(xpath = "//div/button/span[text()=' Save ']")
	private WebElement btnSave;
	

	//Add SubVariety page
	/*Finding element of Crop Variety dropdown in Add SubVariety page*/
	@FindBy(xpath="//mat-label[text()='Crop Variety']/../../../mat-select[@role='listbox']")
	private WebElement dropdownCropVariety;
	
	/*Finding element of textfield for crop SubVariety in SubVariety page*/
	@FindBy(xpath="//mat-label[text()='Crop Sub-Variety ']/../../../input[@type='text']")
	private WebElement txtCropSubVariety;
	
	/*Finding element of textfield for SubVariety short name in SubVariety page*/
	@FindBy(xpath="//mat-label[text()='Subvariety_Short_Name ']/../../../input[@type='text']")
	private WebElement txtSubVarietyShortName;
	
	/*Finding element of Exp harvest days in SubVariety page*/
	@FindBy(xpath="//mat-label[text()='Exp. Harvest Days (from date of sowing) ']/../../../input[@type='number']")
	private WebElement txtExpHarvestDaySubVariety;
	
	
	//Crop Stages
	/*Finding element of Crop Stages*/
	@FindBy(xpath="//div/div[contains(text(),'Crop Stages')]")
	private WebElement btnCropStages;
	
	/*Finding element of Add New Crop Stage*/
	@FindBy(xpath="//button/span[text()='Add New Crop Stage ']")
	private WebElement btnAddNewCropStage;
	
	/*Finding element of Name*/
	@FindBy(xpath="//mat-label[text()='Name']/../../../mat-select[@role='listbox']")
	private WebElement dropdownName;
	
	/*Finding element of Description*/
	@FindBy(xpath="//span[text()='Description']/../../../textarea[@placeholder='Description']")
	private WebElement txtDescription;
	
	/*Finding element of Days After Sowing*/
	@FindBy(xpath="//span[text()='Days After Sowing']/../../../input[@type='number']")
	private WebElement txtDaysAfterSowing;
	
	//Seed Grades
	/*Finding element of Seed Grades*/
	@FindBy(xpath="//div/div[contains(text(),'Seed Grades')]")
	private WebElement btnSeedGrades;
	
	/*Finding element of Add New Seed Grade*/
	@FindBy(xpath="//button/span[text()='Add New Seed Grade ']")
	private WebElement btnAddNewSeedGrade;
	
	//Harvest Grades
	/*Finding element of Harvest Grades */
	@FindBy(xpath="//div/div[contains(text(),'Harvest Grades')]")
	private WebElement btnHarvestGrades;
	
	/*Finding element of Add New Harvest Grades*/
	@FindBy(xpath="//button/span[text()='Add New Harvest Grade ']")
	private WebElement btnAddNewHarvestGrades;
	
	//Add Plan
	/*Finding the element of add Plan */
	@FindBy(xpath="//button/span/span[text()='Add Plan']")
	private WebElement btnAddPlan;
	
	//Information
	/*Finding the element of Plan Name text in Information*/
	@FindBy(xpath="//mat-label[text()='Plan Name ']/../../../input[@type='text']")
	private WebElement txtPlanName;
	
	/*Finding the element of Plan Type dropdown in Information*/
	@FindBy(xpath="//mat-label[text()='Plan Type']/../../../mat-select[@role='listbox']")
	private WebElement dropdownPlanType;
	
	
	/*Finding the element of Continue button */
	@FindBy(xpath="//button/span[text()='Continue']")
	private WebElement btnContinueInf;
	
	//Date
	/*Finding the element of Scheduled radio btn*/
	@FindBy(xpath="//div[text()=' Scheduled ']/../div/descendant::input[@type='radio']")
	private WebElement btnScheduled;
	
	/*Finding the element of Continue button */
	@FindBy(xpath="//button/span[text()=' Continue ']")
	private WebElement btnContinue;
	
	/*Finding the element of Unscheduled radio btn*/
	@FindBy(xpath="//div[text()=' Unscheduled ']")
	private WebElement btnUnScheduled;
	
	/*Finding the element of Package of Plans*/
	@FindBy(xpath="//div[contains(text(),'Package of Plans')]")
	private WebElement txtPackageOfPlans;
	
	/**
	 * Description: Navigate to Add Variety from crop main grid 
	 * @author Lohith Reddy
	 */
	public synchronized void navigateToAddVariety() {
		try{
		WebActionUtil.waitForThePresenceOfElement(3);
		WebActionUtil.clickOnElement(btnAddCrop, "Add Crop");
		WebActionUtil.clickOnElement(optionAddVariety, "Add Variety");
		}catch(Exception e){
		WebActionUtil.error(e.getMessage());
		WebActionUtil.info("Unable to navigate Add Variety ");
		Assert.fail("Unable to perform action to navigate Add Variety");
		}
	}
	
	/**
	 * Description: Navigate to Add Subvariety from crop main grid 
	 * @author Lohith Reddy
	 */
	public synchronized void navigateToAddSubVariety() {
		try {
		WebActionUtil.waitForThePresenceOfElement(3);
		WebActionUtil.clickOnElement(btnAddCrop, "Add Crop");
		WebActionUtil.clickOnElement(optionAddSubvariety, "Add Variety");
		}catch(Exception e) {
		WebActionUtil.error(e.getMessage());
		WebActionUtil.info("Unable to navigate Add Subvariety ");
		Assert.fail("Unable to perform action to navigate Add Subvariety");
		}
	}

	/**
	 * Description: Add crop variety from add variety option of Add button  
	 * @author Lohith Reddy
	 */
	public synchronized void addNewVarietyCrop(String crop,String cropVariety,String varietyShortName,String expHarvestDays,
			String location,String expectedYield,String expYieldUnits,String refrenceAreaUnit ){
		try{
		WebActionUtil.waitForThePresenceOfElement(3);
		WebActionUtil.clickOnElement(dropdownCrop, "Crop dropdown");
		WebActionUtil.typeText(searchInDropdown, crop ,"Crop text field");
		WebActionUtil.clickOnElement(selectFromDropdown, "first option in Crop dropdown");
		
		WebActionUtil.typeText(txtCropVariety, cropVariety ,"CropVariety text field");
		WebActionUtil.typeText(txtVarietyShortName, varietyShortName ,"VarietyShortName text field");
		WebActionUtil.typeText(txtExpHarvestDayVariety, expHarvestDays ,"ExpHarvestDays text field");
		
		WebActionUtil.clickOnElement(btnAddYieldPerLocation, "Add Yield Per Location");
		WebActionUtil.scrollToElement(btnAddYieldPerLocation, "Add Yield Per Location");
		
		WebActionUtil.typeText(txtLocation, location ,"Location text field");
		WebActionUtil.clickOnDown_Enter("Location");
		
		WebActionUtil.typeText(txtExpectedYield, expectedYield,"ExpectedYield text field");
		
		WebActionUtil.clickOnElement(dropdownExpYieldUnits, "ExpYieldUnits dropdown");
		WebActionUtil.typeText(searchInDropdown, expYieldUnits ,"ExpYieldUnits text field");
		WebActionUtil.clickOnElement(selectFromDropdown, "first option in ExpYieldUnits dropdown");
		
		WebActionUtil.clickOnElement(dropdownRefrenceAreaUnit, "ReferenceAreaUnit dropdown");
		WebActionUtil.typeText(searchInDropdown, refrenceAreaUnit ,"RefrenceAreaUnit text field");
		WebActionUtil.clickOnElement(selectFromDropdown, "first option in RefrenceAreaUnit dropdown");
		}catch(Exception e){
		WebActionUtil.error(e.getMessage());
		WebActionUtil.info("Unable to add mandatory data of crop from Add Variety ");
		Assert.fail("Unable to perform action to add mandatory data of crop from Add Variety");
		}
	}
	
	/**
	 * Description : Method to click on save button
	 * @author Lohith Reddy 
	 */
	public synchronized void clickOnSave() {
		WebActionUtil.waitForThePresenceOfElement(2);
		WebActionUtil.clickOnElementUsingJS(btnSave, "Save button");
		WebActionUtil.waitForThePresenceOfElement(2);
		WebActionUtil.acceptAlert();
	}
	
	/**
	 * Description : Method to validate crop main grid Url after adding Variety
	 * @author Lohith Reddy
	 */
	public synchronized void validateCropURLAddVariety(String expectedCropURL) {
		try {
		WebActionUtil.info("Validation of Crop main grid page using URL");
		WebActionUtil.waitForThePresenceOfElement(5);
		String actualCropURL = driver.getCurrentUrl();
		System.out.println(actualCropURL);
		if(actualCropURL.equalsIgnoreCase(expectedCropURL)) {
			WebActionUtil.pass("After saving user able to return to Crop main grid");
		}else {
			WebActionUtil.info("Getting "+ actualCropURL  +" instead of "+expectedCropURL);
			WebActionUtil.fail("Getting Bug");
		}
		} catch (Exception e) {
		
		}
	}	
	
	
	/* Search crop and crop variety  link element in the list of crop main grid */
	public String actualCropVariety(String crop, String cropVariety) {
		return driver.findElement(By.xpath("//table/tbody/tr[*]/td[2][text()=' "+crop+" ']/../../tr[*]/td[2]/span/span/a[text()='"+cropVariety+"']")).getText();
	}
	
	/**
	 * Description: Method to validate added crop variety in crop list of main grid   
	 * @author Lohith Reddy
	 */
	public synchronized void validateCropVariety(String crop,String cropVariety,String expectedCropVariety) {
		try {
		WebActionUtil.waitForThePresenceOfElement(3);
		WebActionUtil.info("Validation of Crop Variety");
		Assert.assertEquals(actualCropVariety(crop,cropVariety),  expectedCropVariety);
		WebActionUtil.pass("Validation successfully done for Crop Variety");
		} catch (NoSuchElementException e) {
		WebActionUtil.info("Unable to verify the Crop Variety");
		Assert.fail("Unable to verify Crop Variety");
		}
	}
	
	/**
	 * Description: Add crop Subvariety from Add SubVariety option of Add button
	 * @author Lohith Reddy
	 */
	public synchronized void addNewSubVarietyCrop(String crop,String cropVariety,String cropSubVariety,String subVarietyShortName,String expHarvestDays,
			String location,String expectedYield,String expYieldUnits,String refrenceAreaUnit ) {
		try{
		WebActionUtil.waitForThePresenceOfElement(3);
		WebActionUtil.clickOnElement(dropdownCrop, "Crop dropdown");
		WebActionUtil.typeText(searchInDropdown, crop ,"Crop text field");
		WebActionUtil.clickOnElement(selectFromDropdown, "first option in Crop dropdown");
		
		WebActionUtil.clickOnElement(dropdownCropVariety, "CropVariety dropdown");
		WebActionUtil.typeText(searchInDropdown, cropVariety ,"CropVariety text field");
		WebActionUtil.clickOnElement(selectFromDropdown, "first option in CropVariety dropdown");
		
		WebActionUtil.typeText(txtCropSubVariety, cropSubVariety ,"CropSubVariety text field");
		WebActionUtil.typeText(txtSubVarietyShortName, subVarietyShortName ,"SubVarietyShortName text field");
		WebActionUtil.typeText(txtExpHarvestDaySubVariety, expHarvestDays ,"ExpHarvestDays text field");
		
		WebActionUtil.clickOnElement(btnAddYieldPerLocation, "Add Yield Per Location");
		WebActionUtil.scrollToElement(btnAddYieldPerLocation, "Add Yield Per Location");
		
		WebActionUtil.typeText(txtLocation, location ,"Location text field");
		WebActionUtil.clickOnDown_Enter("Location");
		
		WebActionUtil.typeText(txtExpectedYield, expectedYield,"ExpectedYield text field");
		
		WebActionUtil.clickOnElement(dropdownExpYieldUnits, "ExpYieldUnits dropdown");
		WebActionUtil.typeText(searchInDropdown, expYieldUnits ,"ExpYieldUnits text field");
		WebActionUtil.clickOnElement(selectFromDropdown, "first option in ExpYieldUnits dropdown");
		
		WebActionUtil.clickOnElement(dropdownRefrenceAreaUnit, "ReferenceAreaUnit dropdown");
		WebActionUtil.typeText(searchInDropdown, refrenceAreaUnit ,"RefrenceAreaUnit text field");
		WebActionUtil.clickOnElement(selectFromDropdown, "first option in RefrenceAreaUnit dropdown");
		
		}catch(Exception e){
		   WebActionUtil.error(e.getMessage());
		   WebActionUtil.info("Unable to add mandatory data of crop from Add SubVariety ");
		   Assert.fail("Unable to perform action to add mandatory data of crop from Add SubVariety");
		}
	}
	
	/**
	 * Description : Method to validate crop main grid Url after adding Sub Variety 
	 * @author Lohith Reddy
	 */
	public synchronized void validateCropURLSubVariety(String expectedCropURL) {
		try {
		WebActionUtil.info("Validation of Crop main grid page using URL");
		WebActionUtil.waitForThePresenceOfElement(5);
		String actualCropURL = driver.getCurrentUrl();
		Assert.assertEquals(actualCropURL,  expectedCropURL);
		WebActionUtil.pass("Validation successfully done for Crop main grid Url");
		} catch (NoSuchElementException e) {
		WebActionUtil.info("Unable to verify the Crop main grid Url");
		Assert.fail("Unable to verify Crop main grid Url");
		}
	}
	
	/* Search crop, Variety and SubVariety  link element in the list of crop main grid */
	public String actualCropSubVariety(String crop,String cropSubVariety) {
		return driver.findElement(By.xpath("//table/tbody/tr[*]/td[2][text()=' "+crop+" ']/../../tr[*]/td[2]/span/span/a[text()='"+cropSubVariety+"']")).getText();
	}
	
	/**
	 * Description: Method to validate added crop Subvariety in crop list of main grid   
	 * @author Lohith Reddy
	 */
	public synchronized void validateCropSubVariety(String crop,String cropSubVariety,String expectedCropSubVariety) {
		try {
		WebActionUtil.waitForThePresenceOfElement(3);
		WebActionUtil.info("Validation of Crop SubVariety");
		Assert.assertEquals(actualCropSubVariety(crop,cropSubVariety),  expectedCropSubVariety);
		WebActionUtil.pass("Validation successfully done for Crop SubVariety");
		} catch (Exception e) {
		WebActionUtil.info("Unable to verify the Crop SubVariety");
		Assert.fail("Unable to verify Crop SubVariety");
		}
	}
	
	
	/**
	 * Description: Method to add data in Crop stages
	 * @author Lohith Reddy
	 */
	public synchronized void addCropStages(String cropStageName,String cropStageDescription,String cropStageDaysSowing) {
		try {
		WebActionUtil.waitForThePresenceOfElement(2);
		WebActionUtil.clickOnElementUsingJS(btnCropStages,"Crop Stages");
		WebActionUtil.clickOnElement(btnAddNewCropStage, "AddNewCropStage button");				
		WebActionUtil.clickOnElement(dropdownName, "Name dropdown");
		WebActionUtil.typeText(searchInDropdown, cropStageName ,"Name text field");
		WebActionUtil.clickOnElement(selectFromDropdown, "first option in Name dropdown");
		WebActionUtil.typeText(txtDescription, cropStageDescription,"Description text field");
		WebActionUtil.typeText(txtDaysAfterSowing,cropStageDaysSowing,"DaysAfterSowing text field");
		}catch(Exception e) {
		WebActionUtil.error(e.getMessage());
		WebActionUtil.info("Unable to add the data in Crop Stages");
		Assert.fail("Unable to perform action to add the data in Crop Stages");
		}
	}
	
	/**
	 * Description: Method to add data in Seed Grades
	 * @author Lohith Reddy
	 */
	public synchronized void addSeedGrades(String seedGradeName,String seedGradeDescription) {
		try {
		WebActionUtil.waitForThePresenceOfElement(2);
		WebActionUtil.clickOnElementUsingJS(btnSeedGrades,"Seed Grades");
		WebActionUtil.clickOnElement(btnAddNewSeedGrade, "AddNewSeedGrade button");			
			
		WebActionUtil.clickOnElement(dropdownName, "Name dropdown");
		WebActionUtil.typeText(searchInDropdown, seedGradeName ,"Name text field");
		WebActionUtil.clickOnElement(selectFromDropdown, "first option in Name dropdown");
		WebActionUtil.typeText(txtDescription, seedGradeDescription,"Description text field");
		}catch(Exception e) {
		WebActionUtil.error(e.getMessage());
		WebActionUtil.info("Unable to add the data in Crop Stages");
		Assert.fail("Unable to perform action to add the data in Crop Stages");
		}
	}
	
	/**
	 * Description: Method to add data in Harvest Grades
	 * @author Lohith Reddy
	 */
	public synchronized void addHarvestGrades(String harvestGradeName,String harvestGradeDescription) {
		try {
		WebActionUtil.waitForThePresenceOfElement(2);
		WebActionUtil.clickOnElement(btnHarvestGrades,"Harvest Grades");
		WebActionUtil.clickOnElement(btnAddNewHarvestGrades, "AddNewHarvestGrades button");			
		
		WebActionUtil.clickOnElement(dropdownName, "Name dropdown");
		WebActionUtil.typeText(searchInDropdown, harvestGradeName ,"Name text field");
		WebActionUtil.clickOnElement(selectFromDropdown, "first option in Name dropdown");
		WebActionUtil.typeText(txtDescription, harvestGradeDescription,"Description text field");
		}catch(Exception e) {
		WebActionUtil.error(e.getMessage());
		WebActionUtil.info("Unable to add the data in Crop Stages");
		Assert.fail("Unable to perform action to add the data in Crop Stages");
		}
	}
	
	/*Finding the element of plans icon under Actions of crop main grid*/
	public WebElement iconPlan(String crop, String cropVariety) {
		return driver.findElement(By.xpath("//table/tbody/tr[*]/td[2][text()=' "+crop+" ']/../../tr[*]/td[2]/span/span/a[text()='"+cropVariety+"']/../../../../../tr[*]/td[5]/span/button/span/mat-icon[text()='assignment ']"));
	}
	
	/**
	 * Description : Method to navigate add Plan  
	 * @author Lohith Reddy
	 */
	public synchronized void navigateToAddPlan(String crop,String cropVariety) {
		try {
		WebActionUtil.waitForThePresenceOfElement(2);
		WebActionUtil.clickOnElement(iconPlan(crop,cropVariety ),"Plans icon");	
		WebActionUtil.clickOnElement(btnAddPlan,"Add Plan");
		}catch(Exception e){
		WebActionUtil.error(e.getMessage());
		WebActionUtil.info("Unable to navigate Plans Icon under Actions ");
		Assert.fail("Unable to perform action to navigate Plans Icon under Actions");
		}
	}
	
	/**
	 * Description : Method to add Plan data i.e Plan Type
	 * @author Lohith Reddy
	 */
	public synchronized void addPlanInformation(String planName,String planType) {
		try {
		WebActionUtil.waitForThePresenceOfElement(2);
		WebActionUtil.typeText(txtPlanName,planName, "Plan Name");
		
		WebActionUtil.clickOnElement(dropdownPlanType, "Plan Type dropdown");
		WebActionUtil.typeText(searchInDropdown, planType, "Plan Type text field");
		WebActionUtil.clickOnElement(selectFromDropdown, "first option in Plan Type dropdown");
		WebActionUtil.clickOnElement(btnContinueInf, "Continue button");
	
		WebActionUtil.clickOnElement(btnUnScheduled, "Unscheduled button");
		WebActionUtil.clickElementByUsingJS(btnContinue,"Continue button");
		WebActionUtil.waitForThePresenceOfElement(2);
		WebActionUtil.clickElementByUsingJS(btnContinue,"Continue button");
		WebActionUtil.waitForThePresenceOfElement(2);
		WebActionUtil.clickElementByUsingJS(btnContinue,"Continue button");
		WebActionUtil.waitForThePresenceOfElement(2);
		WebActionUtil.clickElementByUsingJS(btnSave, "Save button");
		}catch(Exception e){
		WebActionUtil.error(e.getMessage());
		WebActionUtil.info("Unable to navigate Plans Icon under Actions ");
		Assert.fail("Unable to perform action to navigate Plans Icon under Actions");
		}
	}
	
	
	/**
	 * Description: Method to validate Package of Plans after saving the Plan   
	 * @author Lohith Reddy
	 */
	public synchronized void validatePackagePlansURL(String expectedPackagePlansText) {
		try {	
		WebActionUtil.waitForThePresenceOfElement(5);
		String actualText = txtPackageOfPlans.getText();
		WebActionUtil.info("Validation of Package Of Plans");
		String actualURL = driver.getCurrentUrl();
		Assert.assertEquals(actualText,  expectedPackagePlansText);
		WebActionUtil.pass("Validation successfully done for Package Of Plans");
		} catch (Exception e) {
		WebActionUtil.info("Unable to verify the Package Of Plans");
		Assert.fail("Unable to veriry Package Of Plans");
		}
	}
}
