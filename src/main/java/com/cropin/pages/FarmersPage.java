package com.cropin.pages;

import java.awt.Robot;


import java.awt.event.KeyEvent;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.cropin.baseutil.BaseTest;
import com.cropin.util.WebActionUtil;

public class FarmersPage extends BaseTest{
	public WebDriver driver;
	public WebActionUtil WebActionUtil;
	public long ETO = 10;

	public FarmersPage(WebDriver driver, WebActionUtil WebActionUtil, long ETO) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.WebActionUtil = WebActionUtil;
		ETO = ETO;
	}
	
	/* Finding element of add new farmer*/
	@FindBy(xpath="//mat-icon[text()='add']")
	private WebElement btnAddNew;
	
	/* Finding element of Bulk upload*/
	@FindBy(xpath="//button/span/img[@src='/content/images/upload-farmer.svg']")
	private WebElement btnBulkUpload;
	
	/* Finding element of Download Template*/
	@FindBy(xpath="//div/button[text()='Download Template ']")
	private WebElement optionDownloadTemp;
	
	/*Finding element of Download Template success msg*/
	@FindBy(xpath="//snack-bar-container/simple-snack-bar/span[text()='Downloading template.. Please Wait']")
	private WebElement msgDownloadTemp;
	
	/*Finding element of Uploaded Template*/
	@FindBy(xpath="//div/label[text()=' Upload Template ']")
	private WebElement optionUploadTemp;
	
	/*Finding the Element of Uploaded Template view status*/
	@FindBy(xpath="//div/span/a[text()=' VIEW STATUS']")
	private WebElement msgViewStatus;
	
	/*Finding element of Upload Template  success msg*/
	@FindBy(xpath="//div[text()=' Processing Bulk Upload Template... 100% ']/../../../parent::div[@role='region']")
	private WebElement msgUploadTemp;
	
	/*Finding the Element of Upload duplicate Template failure msg*/
	@FindBy(xpath ="//span[text()='Errors']/../../parent::div/div[text()=' Network Failure ']")
	private WebElement msgUploadDuplicateTemp;
	
	/*Finding the Element of Upload Template with out mandatory field failure msg*/
	@FindBy(xpath="//span[text()='Errors']/../../../div[contains(text(),' Cell -K2: Mandatory Field  Address missing ')]")
	private WebElement msgNoMandatoryTemp;
	
	/*Finding element to add img */
	@FindBy(xpath ="//smartfarm-file-upload/label/img[@alt='Profile pic']")
	private WebElement imgProfilePic;
	
	/* Finding element of farmer name*/
	@FindBy(xpath="//input[@placeholder='Farmer Name']")
	private WebElement txtFarmerName;
	
	/* Finding element of farmer code*/
	@FindBy(xpath="//input[@placeholder='Farmer Code']")
	private WebElement txtFarmerCode;
	
	/* Finding element of ISD dropdown*/
	@FindBy(xpath="//mat-label[contains(text(),'ISD')]/../../preceding-sibling::mat-select[@role='listbox']")
	private WebElement dropdownISD;
	
	/* Finding element of ISD options*/
	@FindBys(@FindBy(xpath="//mat-option[contains(@id,'mat-option')]"))
	private List<WebElement> optionsISD;
	
	/*Finding element of search in ISD dropdown*/
	@FindBy(xpath="//span[text()='SEARCH...']/../../../input[@placeholder='SEARCH...']")
	private WebElement searchInISDDropdown;

	
	/*Finding element of mobile number*/
	@FindBy(name="mobileNumber")
	private WebElement txtMobileNumber;
	
	/*Finding element of Assigned To dropdown*/
	@FindBy(xpath="//div/mat-select[@id='assignedTo']")
	private WebElement dropdownAssignedTo;
	
	/*Finding element of search in Assigned To dropdown*/
	@FindBy(xpath="//span[text()='SEARCH']/../../../input[@placeholder='SEARCH']")
	private WebElement searchInDropdown;
	
	/*Finding element at first index in dropdown*/
	@FindBy(xpath="//mat-option[@tabindex='0']")
	private WebElement selectFromDropdown;
	
	/*Finding element of location information*/
	@FindBy(xpath="//mat-panel-title[text()=' Location Information * ']")
	private WebElement btnLocationInfo;
	
	/*finding element of address textfield*/
	@FindBy(xpath="//mat-label[text()='Address']/../../../input[@name='formattedAddress']")
	private WebElement txtAddress;
	
	/*finding element of save*/
	@FindBy(xpath="//div/button/span[contains(text(),'Save')]")
	private WebElement btnSave;
	
	/*finding element of Assigned To button on farmer main grid*/
	@FindBy(xpath="//div/button/span/mat-icon[text()=' assignment_ind ']")
	private WebElement btnAssignedTo;
	
	
	/**
	 * Description: Navigate to add new Farmer 
	 * @author Lohith Reddy
	 */
	public synchronized void navigateToAddNewFarmer() {
		WebActionUtil.waitForThePresenceOfElement(5);
		WebActionUtil.clickOnElement(btnAddNew, "Add new Farmer");
	}
	
	/**
	 * Description: Method for adding Farmer data
	 *@author Lohith Reddy
	 */
	public synchronized void addFarmer(String imgPath,String farmerName,String farmerCode,String iSD,String mobileNo, String assignedTo,String address) throws InterruptedException {
		try {
		WebActionUtil.waitForThePresenceOfElement(3);
		WebActionUtil.clickOnElement(imgProfilePic,"Add Profile Picture");
		WebActionUtil.waitForThePresenceOfElement(3);
		WebActionUtil.clickOnUploadFile(imgPath, "Added the Img");
		WebActionUtil.typeText(txtFarmerName,farmerName ,"FarmerName type text");
		WebActionUtil.typeText(txtFarmerCode, farmerCode,"Code type text");
		
		WebActionUtil.clickOnElement(dropdownISD,"ISD dropdown");
		WebActionUtil.typeText(searchInISDDropdown, iSD, "ISD text field");
		WebActionUtil.clickOnElement(selectFromDropdown, "first option in ISD dropdown");
		
		WebActionUtil.typeText(txtMobileNumber, mobileNo,"Mobile type text");
		
		WebActionUtil.clickOnElement(dropdownAssignedTo,"AssignedTo dropdown");
		WebActionUtil.typeText(searchInDropdown, assignedTo, "Assigned To");
		driver.findElement(By.xpath("//span[text()=' "+assignedTo+" ']/preceding-sibling::mat-pseudo-checkbox")).click();
		
		WebActionUtil.robot.keyPress(KeyEvent.VK_TAB);
		WebActionUtil.robot.keyRelease(KeyEvent.VK_TAB);
		
		WebActionUtil.clickOnElement(btnLocationInfo,"Location Information");
		WebActionUtil.typeText(txtAddress, address,"Address type text");
		WebActionUtil.clickOnDown_Enter("Address text");
		}catch(Exception e){
		WebActionUtil.error(e.getMessage());
		WebActionUtil.info("Unable to add the Farmer");
		Assert.fail("Unable to add the Farmer");
		}
	}
	
	/**
	 * Description: Validate Image
	 * @author Lohith Reddy
	 */
	public synchronized void validateImage(){
			try {
			WebActionUtil.info("Validating image");
	        Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", imgProfilePic);
	        Assert.assertTrue(ImagePresent);
	        WebActionUtil.pass("Profile pic is uploaded");
	        WebActionUtil.clickOnElementUsingJS(btnSave, "Save button");
			}catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.info("Unable to validate profile pic");
			Assert.fail("Unable to validate profile pic");
			}
		}
	
	/**
	* Description : validate Farmer main grid
	*@author Lohith Reddy
	*/
	public synchronized void validateFarmerURL(String expectedURL) {
			try {
			WebActionUtil.info("Validation of Main farmer page URL");
			WebActionUtil.waitForThePresenceOfElement(3);
			String actualURL = driver.getCurrentUrl();
			Assert.assertEquals(expectedURL, actualURL);
			WebActionUtil.pass("Validated that page comes to main grid after clicking on Save button");
			}catch (Exception e) {
			WebActionUtil.info("Unable to verify the URL");
			Assert.fail("Unable to verify URL");
			}
		}

	/* Search farmer link element in main grid*/
	public String actualfarmer(String farmer) {
	return driver.findElement(By.xpath("//table/tbody/tr[*]/td[2]//a[text()=' "+farmer+" ']")).getText();
	}
	
	/**
	* Description: validation by farmer link in main grid
	* @author Lohith Reddy
	*/
	public synchronized void validateFarmerInList(String farmer,String expectedfarmer) {
			try {
			WebActionUtil.info("Validation of farmer");
			WebActionUtil.waitForThePresenceOfElement(3);
			Assert.assertEquals(actualfarmer(farmer), expectedfarmer);
			WebActionUtil.pass("Validated successfully farmer created");
			} catch (NoSuchElementException e) {
			WebActionUtil.info("Unable to verify the farmer");
			Assert.fail("Unable to verify farmer");
			}
	 	}
	
	/**
	 * Description : Method to select Checkbox of farmer from main grid
	 * @author Lohith Reddy
	 */
	public synchronized void clickOnCheckbox(String farmerName) {
			try {
			WebActionUtil.waitForThePresenceOfElement(2);
			WebActionUtil.info("Clicking on checkbox");
			WebElement checkboxColumn = driver
				   .findElement(By.xpath("//table//tbody//tr[*]/td[2]//a[text()=' "+farmerName+" ']//ancestor::td/preceding-sibling::td//div/input[@type='checkbox']"));
		   	WebActionUtil.waitForElement(checkboxColumn, "CheckBox Column", ETO);
		   	WebActionUtil.clickElementByUsingJS(checkboxColumn, "checkbox column");
			}catch(Exception e) {
		    WebActionUtil.error(e.getMessage());
		    WebActionUtil.info("Unable to perform clicking on checkbox");
		    Assert.fail("Unable to perform clicking on checkbox");
		    }
		}
	/**
	 * Description : Method to for farmer assignment from main grid
	 * @author Lohith Reddy
	 */
	public synchronized void assignmentMainGrid(String farmerName,String assignedTo) {
		try {
			WebActionUtil.waitForThePresenceOfElement(2);
			clickOnCheckbox(farmerName);
			WebActionUtil.clickOnElement(btnAssignedTo, "Assigned To  from main grid");
			WebActionUtil.clickOnElement(dropdownAssignedTo,"AssignedTo dropdown");
			WebActionUtil.typeText(searchInDropdown, assignedTo, "Assigned To");
			driver.findElement(By.xpath("//span[text()=' "+assignedTo+" ']/preceding-sibling::mat-pseudo-checkbox")).click();
			WebActionUtil.robot.keyPress(KeyEvent.VK_TAB);
			WebActionUtil.robot.keyRelease(KeyEvent.VK_TAB);
			WebElement btnSaveAlert = driver.findElement(By.xpath("//mat-dialog-actions/button/span[text()='Save']"));
			WebActionUtil.clickOnElementUsingJS(btnSaveAlert,"Save button");
			}catch(Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.info("Unable to assign the user to from main grid");
			Assert.fail("Unable to assign the user to from main grid");
		}
	}
	
	/* Search assigned userName link element in main grid*/
	public String actualUserName(String expectedFarmer ,String user) {
	return driver.findElement(By.xpath("//table/tbody/tr[*]/td[2]/span/a[text()=' "+expectedFarmer+" ']/../../../td[5]/span/div[contains(text(),' "+user+" ')]")).getText();
	}
	
	/**
	* Description: validation by farmer link
	* @author Lohith Reddy
	*/
	public synchronized void validateUserInList(String expectedFarmer,String user,String expectedUser) {
		try {
			WebActionUtil.info("Validation of farmer");
			WebActionUtil.waitForThePresenceOfElement(3);
			Assert.assertEquals(actualUserName(expectedFarmer,user), expectedUser);
			WebActionUtil.pass("Validated successfully user assignedTo");
			} catch (NoSuchElementException e) {
			WebActionUtil.info("Unable to verify the user assignedTo");
			Assert.fail("Unable to verify the user assignedTo");
			}
		}
	
	/**
	 * Description : Method to download Bulk template
	 * @author Lohith Reddy
	 */
	public synchronized void downloadTemp() {
		try {
			WebActionUtil.info("Downloading Template");
			WebActionUtil.clickOnElement(btnBulkUpload,"Bulk Upload");
			WebActionUtil.clickOnElement(optionDownloadTemp,"Download Template");
		}catch(Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.info("Download Template not started");
			Assert.fail("Downloading Template not done");
		}
	}
	
	/**
	 * Description : Method to validate the download Bulk template
	 * @author Lohith Reddy
	 */
	public synchronized void validateDownloadTemp(String expectedDownloadMsg) {
		try {
			WebActionUtil.info("Validation of download Template msg");
			String actualDownloadMsg = msgDownloadTemp.getText();
			Assert.assertEquals(actualDownloadMsg, expectedDownloadMsg);
			WebActionUtil.pass("Validated download Template successfully");
		}catch(Exception e) {
			WebActionUtil.info("Unable to verify the download Template msg");
			Assert.fail("Unable to verify the download Template msg");
		}
	}	
	/**
	 * Description : Method to upload Bulk template
	 * @author Lohith Reddy
	 */
	public synchronized void uploadTemp(String filePath) {
		try {
			WebActionUtil.info("Bulk Upload started");
			WebActionUtil.waitForThePresenceOfElement(3);
			WebActionUtil.clickOnElement(btnBulkUpload,"Bulk Upload");
			WebActionUtil.clickOnElement(optionUploadTemp,"Upload Template");
			WebActionUtil.waitForThePresenceOfElement(3);
			WebActionUtil.clickOnUploadFile(filePath,"filepath");
		}catch(Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.info("Bulk Upload not started");
			Assert.fail("Uploading Template not done");
		}
	}
	/**
	 * Description : Method to valid Upload Bulk Temp
	 * @author Lohith Reddy
	 */
	public synchronized void validateUploadTemp(String expectedUploadMsg) {
		try {
			WebActionUtil.info("validation of Upload Template msg");
			WebActionUtil.clickOnElement(msgViewStatus,"View Status");
			WebActionUtil.waitForThePresenceOfElement(3);
			WebActionUtil.info("View Status opened");
			String actualUploadMsg = msgUploadTemp.getText();
			Assert.assertEquals(actualUploadMsg, expectedUploadMsg);
			WebActionUtil.pass("Validated Upload Template successfully");	
		}catch(Exception e) {
			WebActionUtil.info("Unable to verify the Upload Template msg");
			Assert.fail("Unable to verify the Upload Template msg");
		}	
	}
	
	/**
	 * Description : Method to valid Upload duplicate Bulk Temp
	 * @author Lohith Reddy
	 */
	public synchronized void validateDuplicateTemp(String expectedDuplicateMsg) {
		try {
			WebActionUtil.info("validation of Upload Template msg");
			WebActionUtil.clickOnElement(msgViewStatus,"View Status");
			WebActionUtil.waitForThePresenceOfElement(3);
			WebActionUtil.info("View Status opened");
			String actualDuplicateMsg = msgUploadDuplicateTemp.getText();
			Assert.assertEquals(actualDuplicateMsg, expectedDuplicateMsg);
			WebActionUtil.pass("Validated Upload duplicate Template successfully");	
		}catch(Exception e) {
			WebActionUtil.info("Unable to verify the Upload duplicate Template msg");
			Assert.fail("Unable to verify the Upload duplicate Template msg");
		}	
	}
	
	/**
	 * Description : Method to valid Upload Bulk Temp with out Mandatory field
	 * @author Lohith Reddy
	 */
	public synchronized void validateWithOutMandatoryTemp(String expectedNoMandatoryMsg) {
		try {
			WebActionUtil.info("validation of Upload Template msg with out mandatory field");
			WebActionUtil.clickOnElement(msgViewStatus,"View Status");
			WebActionUtil.waitForThePresenceOfElement(3);
			WebActionUtil.info("View Status opened");
			String actualNoMandatoryMsg=msgNoMandatoryTemp.getText();
			System.out.println(actualNoMandatoryMsg);
			Assert.assertEquals(actualNoMandatoryMsg, expectedNoMandatoryMsg);
			WebActionUtil.waitForThePresenceOfElement(3);
			WebActionUtil.pass("Validated Uploaded Template with out mandatory field successfully");	
		}catch(Exception e) {
			WebActionUtil.info("Unable to verify the Uploaded Template with out mandatory msg");
			Assert.fail("Unable to verify the Upload Template with out mandatory msg");
		}	
	}
	
	
}


