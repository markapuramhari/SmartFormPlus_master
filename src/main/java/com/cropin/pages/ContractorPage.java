package com.cropin.pages;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.cropin.util.WebActionUtil;

public class ContractorPage {
	public WebDriver driver;
	public WebActionUtil WebActionUtil;
	public long ETO = 10;
	public ContractorPage(WebDriver driver, WebActionUtil WebActionUtil, long ETO) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.WebActionUtil = WebActionUtil;
		this.ETO = ETO;
	}
	
	/* find xpath of add icon */
	@FindBy(xpath="//mat-icon[normalize-space()='add']")
	private WebElement iconAdd;
	
	/*find xpath of uploading image */
	@FindBy(xpath="//smartfarm-file-upload//img[@alt='Profile pic']")
	private WebElement imgUpload;
	
	/*find xpath of contractor name field */
	@FindBy(xpath="//div/input[@id='name']")
	private WebElement txtContractorName;
	
	/*find xpath of ISD dropdown*/
	@FindBy(xpath="//mat-label[contains(text(),'ISD')]/../../preceding-sibling::mat-select[@role='listbox']")
	private WebElement btnISD_Dropdwn;
	
	/*find xpath to capture all the elements of ISD dropdown*/
	@FindBys(@FindBy(xpath="//mat-option[contains(@id,'mat-option')]"))
	private List<WebElement> optionsISD;
	
	/* find xpath of mobile field */
	@FindBy(name="mobileNumber")
	private WebElement txtMobileNumber;
	
	/*find xpath of location information button */
	@FindBy(xpath="//mat-panel-title[text()=' Location Information * ']/../parent::mat-expansion-panel-header[@role='button']")
	private WebElement btnLocationInfor;
	
	/*find xpath of Address field */
	@FindBy(xpath="//mat-label[text()='Address']/../../preceding-sibling::input[@placeholder='Enter a location']")
	private WebElement txtAddress;
	
	/*find xpath of save button */
	@FindBy(xpath="//button/span[text()=' Save ']")
	private WebElement btnSave;
	
	/*find xpath of bulk template button*/
	@FindBy(xpath="//span/img[@src='/content/images/upload-farmer.svg']")
	private WebElement btnBulkTemplate;
	
	/*find xpath of download template button */
	@FindBy(xpath="//div/button[text()='Download Template ']")
	private WebElement btnDownloadTemplate;
	
	/*find xpath of upload template button */
	@FindBy(xpath="//div/label[text()=' Upload Template ']")
	private WebElement btnUploadTemplate;
	
	/*find xpath of downloading template message */
	@FindBy(xpath="//simple-snack-bar[@class='mat-simple-snackbar ng-star-inserted']/span[text()='Downloading template.. Please Wait']")
	private WebElement downloadMessage;
	
	/*find xpath of uploading successful message */
	@FindBy(xpath=" //div/span[text()='Records have been successfully added to database...']")
	private WebElement uploadingMessage;
	
	/*find xpath of view status */
	@FindBy(xpath="//span/a[text()=' VIEW STATUS']")
	private WebElement uploadViewStatus;
	
	/*find xpath of successful message */
	@FindBy(xpath="//div[text()=' Processing Bulk Upload Template... 100% ']/../../../parent::div[@role='region']")
	private WebElement statusMessage;
	
	/*find xpath of error status message */
	@FindBy(xpath="//span[text()='Errors']/../../../div[contains(text(),'Cell -B2: Mandatory Field  Mobile Number missing')]")
	private WebElement errorStatus;
	
	/*search user xpath */
	@FindBy(xpath="//div/input[@placeholder='Search in table']")
	private WebElement txtSearchContractor;
	
	/* find  the element of table */
	@FindBy(xpath = "//table/tbody/tr[*]/td[2]//a")
	private WebElement colContractor;
	
	/* find the xpath of deleting an element from table */
	@FindBy(xpath = "//span/mat-icon[text()='delete']")
	private WebElement btnDelete;

	/*find xpath of contractor link */
	@FindBy(xpath="//div/a[text()='Contractor']")
	private WebElement lnkContractor;
	
	/* Search contractor  link element */
	public String actualContractor(String contractor) {
		return driver.findElement(By.xpath("//table/tbody/tr[*]/td[2]//a[text()=' "+contractor+" ']")).getText();
	}
	
	/**
	 * Description :adding contractor
	 * 
	 * @author Vinay Singh
	 */
	public synchronized void addContractor(String fileLocation,String contractorName, String expectedISD,String mobileNum, String address ) {
		try {
			WebActionUtil.clickOnElement(iconAdd, "Add icon");
			WebActionUtil.waitForThePresenceOfElement(2);
			WebActionUtil.clickOnElement(imgUpload, "Upload image");
			WebActionUtil.waitForThePresenceOfElement(2);
			WebActionUtil.clickOnUploadFile(fileLocation, "Image file");
		
			WebActionUtil.typeText(txtContractorName, contractorName, "Contractor Name");
			
			WebActionUtil.clickOnElement(btnISD_Dropdwn, "ISD button");
			
			WebActionUtil.handlingList(optionsISD, expectedISD, "ISD");
			
			WebActionUtil.typeText(txtMobileNumber, mobileNum, "Mobile Number text box");
			
			WebActionUtil.clickOnElement(btnLocationInfor, "Location Information button");
			WebActionUtil.waitForThePresenceOfElement(2);
			WebActionUtil.typeText(txtAddress, address, "Address text box");
			WebActionUtil.waitForThePresenceOfElement(2);
			WebActionUtil.clickOnDown_Enter("Location");
			
			WebActionUtil.clickOnElement(btnSave, "Save button");
			
	       }catch (Exception e) {
	   		WebActionUtil.error(e.getMessage());
			WebActionUtil.info("Unable to perform action add Contractor");
			Assert.fail("Unable to perform action add Contractor");
			
		  }
	}
	
	/**
	 * Description:validate main grid and Contractor added or not
	 * 
	 * @author Vinay Singh
	 */
	public synchronized void validateUserURL(String expectedURL) {
		try {
			WebActionUtil.info("Validation of Main Grid page using URL");
			WebActionUtil.waitForThePresenceOfElement(3);
			String actualURL = driver.getCurrentUrl();
			Assert.assertEquals(expectedURL, actualURL);
			WebActionUtil.pass("Validation of URL is successful");
		} catch (Exception e) {
			WebActionUtil.info("Unable to verify the URL");
			Assert.fail("Unable to verify URL");
		}

	}
	
	/**
	 * Description validation by user link
	 * 
	 * @author Vinay Singh
	 */
	public synchronized void validateContractor(String contractor,String expectedContractor) {
		try {
			WebActionUtil.info("Validation of User");
			WebActionUtil.waitForThePresenceOfElement(3);
			Assert.assertEquals(actualContractor(contractor), expectedContractor);
			WebActionUtil.pass("Validated successfully Contractor created");
		} catch (NoSuchElementException e) {
			WebActionUtil.info("Unable to verify the Contractor");
			Assert.fail("Unable to verify Contractor");
		}

	  }

	/**
	 * Description: download template 
	 * 
	 * @author Vinay Singh
	 */
	public synchronized void downloadTemplate() {
		try {
			WebActionUtil.clickOnElement(btnBulkTemplate, "Bulk Template button");
			WebActionUtil.clickOnElement(btnDownloadTemplate, "Download Template button");
			
		}catch(Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.info("Unable to download bulk template");
			Assert.fail("Unable to download bulk template");
			
		}
	}
	
	/**
	 * Description:validation of download template 
	 * @author Vinay Singh
	 */
	public synchronized void validateDownloadTemplate(String expectedMessage) {
		try {
			WebActionUtil.info("Validation of downloading template Message");
			WebActionUtil.waitForThePresenceOfElement(3);
			String actualMessage=downloadMessage.getText();
			Assert.assertEquals(actualMessage, expectedMessage);
			WebActionUtil.pass("Validation of  downloading template  completed ");
			
			}catch(Exception e) {
				WebActionUtil.info("Unable to verify the downloading template message");
				Assert.fail("Unable to verify downloading template message");
			}
		}
	
	/**
	 * Description: upload template 
	 * 
	 * @author Vinay Singh
	 */
	public synchronized void uploadTemplate(String fileLocation) {
		try {
			WebActionUtil.clickOnElement(btnBulkTemplate, "Bulk Template button");
			WebActionUtil.clickOnElement(btnUploadTemplate, "Upload Template button");
			WebActionUtil.clickOnUploadFile(fileLocation, "Upload Template button");
			WebActionUtil.clickOnElement(uploadViewStatus, "View Status link");
		}catch(Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.info("Unable to upload template");
			Assert.fail("Unable to upload template");
			
		}
	}
	
	/**
	 * Description: Validate successful message
	 * @author Vinay Singh
	 */
	public synchronized void validateStatus(String expectedStatus) {
		try {
			WebActionUtil.info("Validation of uploading template status");
			WebActionUtil.waitForThePresenceOfElement(2);
			String actualStatus=statusMessage.getText();
			System.out.println(actualStatus);
			Assert.assertEquals(actualStatus, expectedStatus);
			WebActionUtil.pass("Validation of  uploading template status  successful ");
			}catch(Exception e) {
				WebActionUtil.info("Unable to verify the upload template status");
				Assert.fail("Unable to verify upload template status");
			}
		
	}
	
	/**
	 * Description: Validate mandatory field error status
	 *@author Vinay Singh
	 */
	public synchronized void validateErrorStatus(String errorMessage) {
		try {
			WebActionUtil.info("Validation of uploading template  error status");
			WebActionUtil.waitForThePresenceOfElement(5);
			String actualErrorStatus=errorStatus.getText();
			System.out.println(actualErrorStatus);
			Assert.assertEquals(actualErrorStatus,errorMessage);
			WebActionUtil.pass("Getting Error:Mandatory field required");
		
			}catch(Exception e) {
				WebActionUtil.info("Unable to verify the Error Status");
				Assert.fail("Unable to verify Error Status");
			}
		
	  }
	

	/**
	 * Description: Validate network failure status due to same entity like mobile number
	 *@author Vinay Singh
	 */
	public synchronized void validateNetworkFailureStatus(String expectedNetworkStatus) {
		try {
			WebActionUtil.info("Validation of network failure status after passing same entity");
			WebActionUtil.waitForThePresenceOfElement(3);
			String actualStatus=statusMessage.getText();
			if(actualStatus.equalsIgnoreCase(expectedNetworkStatus)) {
				WebActionUtil.pass(expectedNetworkStatus);
			}else {
				WebActionUtil.info("Getting "+ actualStatus +" instead of "+expectedNetworkStatus);
				WebActionUtil.fail("Getting Bug");
			}
			
			}catch(Exception e) {
				WebActionUtil.info("Unable to verify Network failure message");
				Assert.fail("Unable to verify Network failure message");
			}
		
	  }
	
	/**
	 * Description: search and selete
	 * 
	 * @author Vinay Singh
	 */
	public synchronized void search_And_Delete(String searchContractor,String contractor) {
		try {
			WebActionUtil.waitForThePresenceOfElement(3);
			System.out.println(searchContractor);
			WebActionUtil.typeText(txtSearchContractor, searchContractor, " Contractor text box");
			WebActionUtil.waitForThePresenceOfElement(3);
			clickOnCheckbox(contractor);
			WebActionUtil.clickOnElement(btnDelete, "Delete button");
				
		}catch(Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.info("Unable to perform search and delete");
			Assert.fail("Unable to perform search and delete");
		}
		
	    }
	
	/**
	 * Description: clicking on checkbox through refrence of contractor
	 * 
	 * @author Vinay Singh
	 * @param cellData
	 */
	public synchronized void clickOnCheckbox(String contractor) {
		try {
			
			WebActionUtil.info("Clicking on checkbox");
		    WebElement chkboxColumn = driver
				.findElement(By.xpath("//table//tbody//tr[*]/td[2]//a[text()=' "+contractor+" ']//ancestor::td/preceding-sibling::td//div/input[@type='checkbox']"));
		    WebActionUtil.waitForElement(chkboxColumn, "CheckBox Column", ETO);
		    WebActionUtil.clickElementByUsingJS(chkboxColumn, "checkbox column");
		    WebActionUtil.pass("Successfully clicked on checkbox");
		
	    }catch(Exception e) {
	    	WebActionUtil.error(e.getMessage());
			WebActionUtil.info("Unable to perform clicking on checkbox");
			Assert.fail("Unable to perform clicking on checkbox");
	     }
		
	}
	
	/**
	 * Description: validate search and delete
	 * 
	 * @author Vinay Singh
	 * @param cellData
	 */
	public synchronized void validateSearcAndDelete(String searchContractor,String contractor,String expectedContractor) {
		try {
			
			WebActionUtil.clearText(txtSearchContractor, "Clear text");
			WebActionUtil.waitForThePresenceOfElement(3);
			WebActionUtil.typeText(txtSearchContractor, searchContractor, " Contractor text box");
			
			System.out.println(actualContractor(contractor));
			System.out.println(expectedContractor);
			WebActionUtil.info("Validating Contractor deleted or not");
			WebActionUtil.waitForThePresenceOfElement(10);
			Assert.assertTrue(actualContractor(contractor).equalsIgnoreCase(expectedContractor));
			WebActionUtil.fail("Contractor is not deleted");
		}catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.info("Unable to Validate element present or not");
			Assert.fail("Unable to Validate element present or not");
		}
	}
	
	
}
