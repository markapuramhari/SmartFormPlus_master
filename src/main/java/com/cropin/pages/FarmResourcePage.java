package com.cropin.pages;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.cropin.util.WebActionUtil;

public class FarmResourcePage {
	public WebDriver driver;
	public WebActionUtil WebActionUtil;
	public long ETO = 10;
	public FarmResourcePage(WebDriver driver, WebActionUtil WebActionUtil, long ETO) {
		
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
	private WebElement txtResourceName;
	
	/*find xpath of owner drop down */
	@FindBy(xpath="//mat-label[contains(text(),'Owner')]/../../preceding-sibling::mat-select[@role='listbox']")
	private WebElement btnOwner;
	
	/*find xpath of owner dropdown list */
	@FindBys(@FindBy(xpath="//mat-option[@role='option']"))
	private List<WebElement> optionsOwner;
	
	/*find xpath of resource type button */
	@FindBy(xpath="//mat-label[text()='Resource Type']/../../../mat-select[@id='typeId']")
	private WebElement btnResourceType;
	
	/*find xpath of resource type drop dpwn */
	@FindBys(@FindBy(xpath="//mat-option[@role='option']"))
	private List<WebElement> optionsResourceType;
	
	/*find xpath of save button */
	@FindBy(xpath="//div/button/span[text()=' Save ']")
	private WebElement btnSave;
	
	/*find xpath of profile pic */
	@FindBy(xpath="//smartfarm-file-upload/label/img[@alt='Profile pic']")
	private WebElement imgFile;
	
	/*find xpath of bulk template button*/
	@FindBy(xpath="//span/img[@src='/content/images/upload-farmer.svg']")
	private WebElement btnBulkTemplate;
	
	/*find xpath of download template button */
	@FindBy(xpath="//div/button[text()='Download Template ']")
	private WebElement btnDownloadTemplate;
	
	/*find xpath of downloading template message */
	@FindBy(xpath="//simple-snack-bar[@class='mat-simple-snackbar ng-star-inserted']/span[text()='Downloading template.. Please Wait']")
	private WebElement downloadMessage;
	
	
	/*find xpath of upload template button */
	@FindBy(xpath="//div/label[text()=' Upload Template ']")
	private WebElement btnUploadTemplate;
	
	/*find xpath of view status */
	@FindBy(xpath="//span/a[text()=' VIEW STATUS']")
	private WebElement uploadViewStatus;
	
	/*find xpath of successful message */
	@FindBy(xpath="//div[text()=' Processing Bulk Upload Template... 100% ']/../../../parent::div[@role='region']")
	private WebElement statusMessage;
	
	/*find xpath of error status message */
	@FindBy(xpath="//span[text()='Errors']/../../parent::div/div[text()=' Network Failure ']")
	private WebElement errorStatus;
	
	/*search user xpath */
	@FindBy(xpath="//div/input[@placeholder='Search in table']")
	private WebElement txtSearchResource;
	
	/* find  the element of table */
	@FindBy(xpath = "//table/tbody/tr[*]/td[2]//a")
	private WebElement colResource;
	
	/* find the xpath of deleting an element from table */
	@FindBy(xpath = "//span/mat-icon[text()='delete']")
	private WebElement btnDelete;

	
	
	
	/* Search contractor  link element */
	public String actualResource(String resource) {
		return driver.findElement(By.xpath("//table/tbody/tr[*]/td[2]//a[text()=' "+resource+" ']")).getText();
	}
	
	
	/**
	 * Description :adding farm resource
	 * 
	 * @author Vinay Singh
	 */
	public synchronized void addFarmResource(String fileLocation,String resourceName, String expectedOwner,String expectedResourceType ) {
		try {
			WebActionUtil.clickOnElement(iconAdd, "Add icon");
			WebActionUtil.waitForThePresenceOfElement(2);
			WebActionUtil.clickOnElement(imgUpload, "Upload image");
			WebActionUtil.waitForThePresenceOfElement(2);
			WebActionUtil.clickOnUploadFile(fileLocation, "Image file");
            WebActionUtil.typeText(txtResourceName, resourceName, "Resource Name");
			WebActionUtil.clickOnElement(btnOwner, "Owner button");
			WebActionUtil.waitForThePresenceOfElement(2);
			WebActionUtil.handlingList(optionsOwner, expectedOwner, "Owner dropdown");
			WebActionUtil.waitForThePresenceOfElement(2);
			WebActionUtil.clickOnElement(btnResourceType, "Resource Type button");
		
			WebActionUtil.handlingList(optionsResourceType, expectedResourceType, "Resource Type dropdown");
			//WebActionUtil.clickOnElement(btnSave, "Save button");
			
		
		}catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.info("Unable to add Farm Resource");
			Assert.fail("Unable to add Farm Resource");
		}
			
	}
	/**
	 * Description:validate main grid and farm Resource added or not
	 * 
	 * @author Vinay Singh
	 */
	public synchronized void validateUserURL(String expectedURL) {
		try {
			WebActionUtil.info("Validation of Main Grid page using URL");
			WebActionUtil.waitForThePresenceOfElement(3);
			String actualURL = driver.getCurrentUrl();
			WebActionUtil.waitForThePresenceOfElement(5);
			Assert.assertEquals(expectedURL, actualURL);
			WebActionUtil.pass("Validation of URL is successful");
		} catch (Exception e) {
			WebActionUtil.info("Unable to verify the URL");
			Assert.fail("Unable to verify URL");
		}
     }
	
	/**
	 * Description validation by farm resource link
	 * 
	 * @author Vinay Singh
	 */
	public synchronized void validateResource(String resource,String expectedResourceName) {
		try {
			WebActionUtil.info("Validation of Farm Resource");
			WebActionUtil.waitForThePresenceOfElement(3);
			WebActionUtil.waitForThePresenceOfElement(5);
			Assert.assertEquals(actualResource(resource), expectedResourceName);
			WebActionUtil.pass("Validated successfully farm resource created");
		} catch (NoSuchElementException e) {
			WebActionUtil.info("Unable to verify the farm resource");
			Assert.fail("Unable to verify farm resource");
		}

	  }
	
	/**
	 * Description: Validate Image
	 * @author Vinay Singh
	 */
	public synchronized void checkImage(){
		
			try {
			
			WebActionUtil.info("Validating image");
	        Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", imgFile);
	       	Assert.assertTrue(ImagePresent);
	        WebActionUtil.pass("Profile pic is uploaded");
	        WebActionUtil.waitForThePresenceOfElement(3);
	        WebActionUtil.clickOnElement(btnSave, "Save button");
			}catch (Exception e) {
				WebActionUtil.error(e.getMessage());
				WebActionUtil.info("Unable to validate profile pic");
				Assert.fail("Unable to validate profile pic");
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
	public synchronized void validateErrorStatus(String expectedErrorMessage) {
		try {
			WebActionUtil.info("Validation of uploading template  error status");
			WebActionUtil.waitForThePresenceOfElement(2);
			String actualErrorStatus=errorStatus.getText();
			if(actualErrorStatus.equalsIgnoreCase(expectedErrorMessage)) {
				WebActionUtil.pass(expectedErrorMessage);
			}else {
				WebActionUtil.info("Getting "+ actualErrorStatus +" instead of "+expectedErrorMessage);
				WebActionUtil.fail("Getting Bug");
			}
			
			
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
			WebActionUtil.waitForThePresenceOfElement(2);
			String actualStatus=statusMessage.getText();
			System.out.println(actualStatus);
			System.out.println(expectedNetworkStatus);
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
	public synchronized void search_And_Delete(String searchResource,String resource) {
		try {
			
			WebActionUtil.typeText(txtSearchResource, searchResource, " Search text box");
			WebActionUtil.waitForThePresenceOfElement(3);
			clickOnCheckbox(resource);
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
	public synchronized void clickOnCheckbox(String resource) {
		try {
			
			WebActionUtil.info("Clicking on checkbox");
		    WebElement chkboxColumn = driver
				.findElement(By.xpath("//table//tbody//tr[*]/td[2]//a[text()=' "+resource+" ']//ancestor::td/preceding-sibling::td//div/input[@type='checkbox']"));
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
	public synchronized void validateSearcAndDelete(String searchResource,String resource,String expectedResource) {
		try {
			
			WebActionUtil.clearText(txtSearchResource, "Search text bx");
			WebActionUtil.waitForThePresenceOfElement(3);
			WebActionUtil.typeText(txtSearchResource, searchResource, " Search text box");
			
			System.out.println(actualResource(resource));
			System.out.println(expectedResource);
			WebActionUtil.info("Validating farmResource deleted or not");
			WebActionUtil.waitForThePresenceOfElement(10);
			Assert.assertTrue(actualResource(resource).equalsIgnoreCase(expectedResource));
			WebActionUtil.fail("Resource is not deleted");
		}catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.info("Unable to Validate element present or not");
			Assert.fail("Unable to Validate element present or not");
		}
	}
	
}
