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

public class UserPage {

	public WebDriver driver;
	public WebActionUtil WebActionUtil;
	public long ETO = 10;

	public UserPage(WebDriver driver, WebActionUtil WebActionUtil, long ETO) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.WebActionUtil = WebActionUtil;
		this.ETO = ETO;
	}
	
	/* find xpath of add icon */
	@FindBy(xpath = "//mat-icon[normalize-space()='add']")
	private WebElement iconAdd;

	/* find xpath of Profile pic uploading*/
	@FindBy(xpath = "//smartfarm-file-upload//img[@alt='Profile pic']")
	private WebElement imgUpload;

	/* find xpath of user name text field */
	@FindBy(xpath = "//mat-label[text()='Name ']/../../../input[@type='text']")
	private WebElement txtUserName;

	/* find xpath of user role dropdown */
	@FindBy(xpath = "//mat-label[text()='User Role']/../../../mat-select[@role='listbox']")
	private WebElement btnUserRole;

	/* find xpath of user role dropdown elements */
	@FindBys(@FindBy(xpath = "//mat-option[@role='option']"))
	private List<WebElement> optionsUserRole;

	/* find xpath of ISD dropdown */
	@FindBy(xpath = "//mat-label[text()='ISD']/../../../mat-select[@role='listbox']")
	private WebElement btnISD;
	
	/*find xpath to capture all the elements of ISD dropdown*/
	@FindBys(@FindBy(xpath="//mat-option[contains(@id,'mat-option')]"))
	private List<WebElement> optionsISD;
	
	/*find name for mobile number */
	@FindBy(name="mobileNumber")
	private WebElement txtMobileNum;
	
	/*find xpath for email */
	@FindBy(xpath="//mat-label[text()='Email ']/../../../input[@type='text']")
	private WebElement txtEmail;
	
	/*find xpath for loocation txtbox */
	@FindBy(xpath="//mat-form-field//div//input[@aria-required='true'][@placeholder='Enter a location']")
	private WebElement txtLocation;
	
	/*find xpath for time zone dropdown */
	@FindBy(xpath="//mat-label[text()='Time Zone']/../../../mat-select[@role='listbox']")
	private WebElement btnTimeZone;
	
	/*find xpath for capturing all the elements of time zone dropdown */
	@FindBys(@FindBy(xpath="//mat-option[contains(@id,'mat-option')]"))
	private List<WebElement> optionsTimeZone;
	
	/*find xpath for Language Preference dropdown */
	@FindBy(xpath="//mat-label[text()='Language Preference']/../../../mat-select[@role='listbox']")
	private WebElement btnLangPreference;
	
	/*find xpath for capturing all the elements of Language Preference dropdown */
	@FindBys(@FindBy(xpath="//mat-option[contains(@id,'mat-option')]"))
	private List<WebElement> optionsLangPreference;
	
	/*find xpath for currency preference dropdown */
	@FindBy(xpath="//mat-label[text()='Currency Preference']/../../../mat-select[@role='listbox']")
	private WebElement btnCurrencyPreference;
	
	/*find xpath for capturing all the elements of currency preference dropdown */
	@FindBys(@FindBy(xpath="//mat-option[contains(@id,'mat-option')]"))
	private List<WebElement> optionsCurrencyPreference;
	
	/*find xpath for area unit dropdown */
	@FindBy(xpath="//mat-label[text()='Area Units']/../../../mat-select[@role='listbox']")
	private WebElement btnAreaUnit;
	
	/*find xpath for capturing all the elements of area unit dropdown */
	@FindBys(@FindBy(xpath="//mat-option[contains(@id,'mat-option')]"))
	private List<WebElement> optionsAreaUnit;
	
	/*find xpath of save button */
	@FindBy(xpath="//div/button/span[text()=' Save ']")
	private WebElement btnSave;
	
	
	/*actual error message xpath */
	@FindBy(xpath="//simple-snack-bar[@class='mat-simple-snackbar ng-star-inserted']/span")
	private WebElement errorMessage;
	
	
	/* find  the element of table */
	@FindBy(xpath = "//table/tbody/tr[*]/td[2]//a")
	private WebElement colUser;
	
	/* find the xpath of actual status inside the table */
	@FindBy(xpath="//table/tbody/tr[*]/td[4]//span[text()=' ACTIVE ']")
	private WebElement colStatus;
	
	/* find the xpath of deleting an element from table */
	@FindBy(xpath = "//table/tbody/tr[*]/td[8]//span/mat-icon[contains(text(),'delete_outline')]")
	private WebElement btnDelete;

    /*find xpath of search user text box */
	@FindBy(xpath = "//div/input[@Placeholder='Search User']")
	private WebElement txtSearch;
	
	
	/* Search user  link element */
	public String actualUser(String user) {
		return driver.findElement(By.xpath("//table/tbody/tr[*]/td[2]//a[text()=' "+user+" ']")).getText();
	}

	
	/**
	 * 
	 * Description add users
	 * @author Vinay Singh
	 */
	public synchronized void addingUsers(String name,String fileLocation,String userRole, String location,String expectedISD,String mobileNum,String email,String expectedTimeZone,
			                        String expectedLangPreference,String  expectedCurrPref,String  expectedAreaUnit) {
		
		try {
		WebActionUtil.clickOnElement(iconAdd, "Add icon");
		WebActionUtil.waitForThePresenceOfElement(2);
		WebActionUtil.clickOnElement(imgUpload, "Upload image");
		WebActionUtil.waitForThePresenceOfElement(2);
		WebActionUtil.clickOnUploadFile(fileLocation, "Image file");
	
		WebActionUtil.typeText(txtUserName, name, "User Name");
		
		WebActionUtil.clickOnElement(btnUserRole, "User Role dropdown button");
		
		WebActionUtil.handlingList( optionsUserRole, userRole, "User Role");
		
		WebActionUtil.clickOnElement(btnISD, "ISD button");
		
		WebActionUtil.handlingList(optionsISD, expectedISD, "ISD");
		
		WebActionUtil.typeText(txtMobileNum, mobileNum, "Mobile Number");
	
		WebActionUtil.typeText(txtEmail, email, "Email TextBox");
	
		WebActionUtil.typeText(txtLocation, location, "Location TextBox");
		WebActionUtil.waitForThePresenceOfElement(2);
		WebActionUtil.clickOnDown_Enter("Location");
		
		WebActionUtil.clickOnElement(btnTimeZone, "Time Zone button");
		
		WebActionUtil.handlingList(optionsTimeZone,expectedTimeZone, "Time Zone dropdown");
		
		WebActionUtil.clickOnElement(btnLangPreference, "LanguagePreference button");
		
		WebActionUtil.handlingList(optionsLangPreference, expectedLangPreference, "Language Preference dropdoown");
		
		WebActionUtil.clickOnElement(btnCurrencyPreference, "Currency Preference");
		
		WebActionUtil.handlingList(optionsCurrencyPreference, expectedCurrPref, "Currency Preference dropdown");
		
		WebActionUtil.clickOnElement(btnAreaUnit, "Area Unit button");
		
		WebActionUtil.handlingList(optionsAreaUnit, expectedAreaUnit, "Area Unit dropdown");
		WebActionUtil.waitForThePresenceOfElement(2);
		WebActionUtil.clickByJs(btnSave, "Save button");
		
	  } catch (Exception e) {
		WebActionUtil.error(e.getMessage());
		WebActionUtil.info("Unable to perform action add user");
		Assert.fail("Unable to perform action add user");
		
	  }
	}
	
	/**
	 * Description:validate main grid and user 
	 * 
	 * @author Vinay Singh
	 */
	public synchronized void validateUserURL(String expectedURL) {
		try {
			WebActionUtil.info("Validation of Main Grid page using URL");
			WebActionUtil.waitForThePresenceOfElement(3);
			String actualURL = driver.getCurrentUrl();
			Assert.assertEquals(expectedURL, actualURL);
			WebActionUtil.pass("Validate that page comes to main page after clicking on Save button");
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
	public synchronized void validateUser(String user,String expectedUser) {
		try {
			WebActionUtil.info("Validation of User");
			WebActionUtil.waitForThePresenceOfElement(3);
			Assert.assertEquals(actualUser(user), expectedUser);
			WebActionUtil.pass("Validated successfully user created");
		} catch (NoSuchElementException e) {
			WebActionUtil.info("Unable to verify the user role");
			Assert.fail("Unable to verify user role");
		}

	  }
	
	/**
	 * Description validating when same entity entered into field
	 * @author Vinay Singh
	 */
	
	public synchronized void validateErrorMessage(String expectedError) {
		
		try {
		WebActionUtil.info("Validation of Error Message");
		WebActionUtil.waitForThePresenceOfElement(3);
		String actualError=errorMessage.getText();
		Assert.assertEquals(actualError, expectedError);
		WebActionUtil.pass("Validation of error message completed ");
		
		}catch(Exception e) {
			WebActionUtil.info("Unable to verify the error message");
			Assert.fail("Unable to verify error message");
		}
	}
	
	/**
	 * Description: clicking on checkbox through refrence of cellData
	 * 
	 * @author Vinay Singh
	 * @param cellData
	 */
	public synchronized void clickOnCheckbox(String users) {
		try {
			
			WebActionUtil.info("Clicking on checkbox");
		    WebElement chkboxColumn = driver
				.findElement(By.xpath("//table//tbody//tr[*]/td[2]//a[text()=' "+users+" ']//ancestor::td/preceding-sibling::td//div/input[@type='checkbox']"));
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
	 * Description: clicking on search and delete
	 * 
	 * @author Vinay Singh
	 * 
	 */
	public synchronized void search_And_Delete(String searchUser,String users,String expectedUser, String expectedStatus) {
		try {
			WebActionUtil.waitForThePresenceOfElement(2);
			WebActionUtil.typeText(txtSearch, searchUser, " Search user text box");
			WebActionUtil.waitForThePresenceOfElement(2);
			clickOnCheckbox(users);
			validateBeforeDelete(expectedUser, expectedStatus);
		}catch(Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.info("Unable to perform search and delete");
			Assert.fail("Unable to perform search and delete");
			
		}
	}
	
	/**
	 * Description: Validation with delete
	 * 
	 * @author Vinay Singh
	 * 
	 */
	public synchronized void validateBeforeDelete( String expectedUser, String expectedStatus) {
		try {
			
			String cellUserData = WebActionUtil.getText(colUser);
			WebActionUtil.waitForThePresenceOfElement(2);
			String actualStatus = WebActionUtil.getText(colStatus);
			WebActionUtil.info("Validating status");
			if (cellUserData.equals(expectedUser)) {
				if (actualStatus.equals(expectedStatus)) {
					WebActionUtil.info("Clicking on delete button");
					btnDelete.click();
					WebActionUtil.pass("Cannot delete active users");

				} else {
					WebActionUtil.info("Clicking on delete buttn");
					btnDelete.click();
					WebActionUtil.pass("Delete inactive users");

				}
				
			}		
					

		}catch(Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.info("Unable to perform search and delete");
			Assert.fail("Unable to perform search and delete");
		}		
			
	}
	
	
	/**
	 * Description: Validation by search user
	 * 
	 * @author Vinay Singh
	 * 
	 */
	public synchronized void searchValidation(String searchUser,String expectedUser) {
		try {
			WebActionUtil.clearText(txtSearch, "Search Role");
			WebActionUtil.waitForElement(txtSearch, searchUser, ETO);
			WebActionUtil.typeText(txtSearch, searchUser, " User Role Name text box");
			String actualUser = WebActionUtil.getText(colUser);
			WebActionUtil.info("Validate search user present or not");
			Assert.assertEquals(actualUser, expectedUser);
			WebActionUtil.pass("Search user is present");
			
			
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.info("Unable to perform search validation");
			Assert.fail("Unable to perform search validation");
		}

	}


}
