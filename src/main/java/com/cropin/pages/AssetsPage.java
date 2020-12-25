package com.cropin.pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.cropin.util.WebActionUtil;

public class AssetsPage {

	public WebDriver driver;
	public WebActionUtil WebActionUtil;
	public long ETO = 10;
	public AssetsPage (WebDriver driver,WebActionUtil WebActionUtil,long ETO) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.WebActionUtil = WebActionUtil;
		this.ETO = ETO;
	}
	
	/*Finding element to add img */
	@FindBy(xpath ="//smartfarm-file-upload//img[@alt='Profile pic']")
	private WebElement imgProfilePic;
	
	/* Finding element of add new farmer*/
	@FindBy(xpath="//mat-icon[text()='add']")
	private WebElement btnAddNew;
	
	/*Finding element of Asset Name text field*/
	@FindBy(xpath="//span[text()='Asset Name']/../../../input[@id='name']")
	private WebElement txtAssetName;
	
	/*Finding element of Belongs To dropdown*/
	@FindBy(xpath="//mat-label[text()='Belongs To']/../../../mat-select[@role='listbox']")
	private WebElement dropdownBelongsTo;
	
	/*Finding element of search in Belongs To dropdown*/
	@FindBy(xpath="//span[text()='SEARCH']/../../../input[@placeholder='SEARCH']")
	private WebElement searchInDropdown;
	
	/*Finding element at first index in dropdown*/
	@FindBy(xpath="//mat-option[@tabindex='0']")
	private WebElement selectFromDropdown;
	
	/*Finding element of SoilType  dropdown*/
	@FindBy(xpath="//mat-label[text()='Soil Type']/../../../mat-select[@role='listbox']")
	private WebElement dropdownSoilType;
	
	/*Finding element of IrrigationType  dropdown*/
	@FindBy(xpath="//mat-label[text()='Irrigation Type']/../../../mat-select[@role='listbox']")
	private WebElement dropdownIrrigationType;
	
	/*Finding element of Declared Area text field*/
	@FindBy(xpath="//span[text()='Declared Area']/../../../input[@type=\"number\"]")
	private WebElement txtDeclaredArea;
	
	/*Finding element of location information*/
	@FindBy(xpath="//mat-panel-title[text()=' Location Information * ']")
	private WebElement btnLocationInfo;
	
	/*finding element of address textfield*/
	@FindBy(xpath="//mat-label[text()='Address']/../../../input[@name='formattedAddress']")
	private WebElement txtAddress;
	
	/*finding element of save*/
	@FindBy(xpath="//button/span[text()=' Save ']")
	private WebElement btnSave;
	
	/* Finding element of Bulk upload*/
	@FindBy(xpath="//button/span/img[@src='/content/images/upload-farmer.svg']")
	private WebElement btnBulkUpload;
	
	/* Finding element of Download Template*/
	@FindBy(xpath="//div/button[text()='Download Template']")
	private WebElement optionDownloadTemp;
	
	/*Finding element of Download Template success msg*/
	@FindBy(xpath="//snack-bar-container/simple-snack-bar/span[text()='Downloading template.. Please Wait']")
	private WebElement msgDownloadTemp;
	
	/*Finding element of Upload Template*/
	@FindBy(xpath="//div/label[text()=' Upload Template ']")
	private WebElement optionUploadTemp;
	
	/*Finding the Element of Upload Template view status*/
	@FindBy(xpath="//div/span/a[text()=' VIEW STATUS']")
	private WebElement msgViewStatus;
	
	/*Finding element of Uploaded Template  success msg*/
	@FindBy(xpath="//div[text()=' Processing Bulk Upload Template... 100% ']/../../../parent::div[@role='region']")
	private WebElement msgUploadTemp;
	
	/*Finding the Element of Uploaded duplicate Template failure msg*/
	@FindBy(xpath ="//span[text()='Errors']/../../parent::div/div[text()=' Network Failure ']")
	private WebElement msgUploadDuplicateTemp;
	
	/*Finding the Element of Upload Template with out mandatory field failure msg*/
	@FindBy(xpath="//span[text()='Errors']/../../../div[contains(text(),' Cell -E2: Mandatory Field  Declared Area Unit missing ')]")
	private WebElement msgNoMandatoryTemp;
	
	/**
	 * Description: Navigate to add new Asset 
	 * @author Lohith Reddy
	 */
	public synchronized void navigateToAddNewAsset() {
		WebActionUtil.waitForThePresenceOfElement(5);
		WebActionUtil.clickOnElement(btnAddNew, "Add new Asset");
	}
	
	/**
	 * Description: Method for adding Asset data
	 *@author Lohith Reddy
	 */
	public synchronized void addAsset(String imgPath,String assetName,String declaredArea,
			String belongsTo,String soilType,String irrigationType,String address) {
		try {
		WebActionUtil.waitForThePresenceOfElement(2);
		WebActionUtil.clickOnElement(imgProfilePic,"Add Profile Picture");
		WebActionUtil.clickOnUploadFile(imgPath, "Added the Img");
		WebActionUtil.waitForThePresenceOfElement(2);
		WebActionUtil.typeText(txtAssetName,assetName ,"AssertName type text");
		
		WebActionUtil.clickOnElement(dropdownBelongsTo, "BelongsTo dropdown");
		WebActionUtil.typeText(searchInDropdown, belongsTo ,"BelongsTo text field");
		WebActionUtil.clickOnElement(selectFromDropdown, "first option in BelongsTo dropdown");
		
		WebActionUtil.clickOnElement(dropdownSoilType, "SoilType dropdown");
		WebActionUtil.typeText(searchInDropdown, soilType ,"SoilType text field");
		WebActionUtil.clickOnElement(selectFromDropdown, "first option in SoilType dropdown");
		
		WebActionUtil.clickOnElement(dropdownIrrigationType, "IrrigationType dropdown");
		WebActionUtil.typeText(searchInDropdown, irrigationType ,"IrrigationType text field");
		WebActionUtil.clickOnElement(selectFromDropdown, "first option in IrrigationType dropdown");
		
		WebActionUtil.typeText(txtDeclaredArea, declaredArea,"DeclaredArea text");	
		
		WebActionUtil.clickOnElement(btnLocationInfo, "Location Information");
		WebActionUtil.waitForThePresenceOfElement(2);
		WebActionUtil.typeText(txtAddress, address,"Address type text");
		WebActionUtil.waitForThePresenceOfElement(2);
		WebActionUtil.clickOnDown_Enter("Address text");
		}catch(Exception e) {
		WebActionUtil.error(e.getMessage());
		WebActionUtil.info("Unable to add the Asset");
		Assert.fail("Unable to add the Asset");
		}
	}
	
	/**
	 * Description: Validate Image
	 * @author Lohith Reddy
	 */
	public synchronized void validateImage(){
			try {
			WebActionUtil.info("Validating image");
			WebActionUtil.waitForThePresenceOfElement(3);
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
	* Description : validate main Assets main grid
	*@author Lohith Reddy
	*/
	public synchronized void validateAssetURL(String expectedURL) {
			try {
			WebActionUtil.info("Validation of Main Assert page URL");
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
	public String actualfarmer(String assetName) {
	return driver.findElement(By.xpath("//table/tbody/tr[*]/td[2]//a[text()=' "+assetName+" ']")).getText();
	}
	
	/**
	* Description: validation by farmer link in main grid
	* @author Lohith Reddy
	*/
	public synchronized void validateAssetInList(String assetName,String expectedAssertName) {
			try {
			WebActionUtil.info("Validation of Asset");
			WebActionUtil.waitForThePresenceOfElement(3);
			Assert.assertEquals(actualfarmer(assetName), expectedAssertName);
			WebActionUtil.pass("Validated successfully Asset created");
			} catch (NoSuchElementException e) {
			WebActionUtil.info("Unable to verify the Asset");
			Assert.fail("Unable to verify Asset");
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
			WebActionUtil.info("Bulk upload not started");
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
			WebActionUtil.waitForThePresenceOfElement(3);
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
			WebActionUtil.pass("Validated Uploaded Template with out mandatory field successfully");	
		}catch(Exception e) {
			WebActionUtil.info("Unable to verify the Uploaded Template with out mandatory msg");
			Assert.fail("Unable to verify the Upload Template with out mandatory msg");
		}	
	}
	
}
