package com.cropin.pages;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.cropin.util.WebActionUtil;

public class UserRolePage {

	public WebDriver driver;
	public WebActionUtil WebActionUtil;
	public long ETO = 10;

	public UserRolePage(WebDriver driver, WebActionUtil WebActionUtil, long ETO) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.WebActionUtil = WebActionUtil;
		this.ETO = ETO;
	}

	/* find search input txtBox */
	@FindBy(xpath = "//div/input[@Placeholder='Search User']")
	private WebElement txtSearch;

	/* find xpath of add icon */
	@FindBy(xpath = "//span/mat-icon[text()='add']")
	private WebElement iconAdd;

	/* find xpath of user role name */
	@FindBy(xpath = "//input[@id='mat-input-5']")
	private WebElement txtUserRoleName;

	/* find xpath of dropdown button */
	@FindBy(xpath = "//mat-label[text()='Select Company/Sub Company']/../../../mat-select[@role='listbox']")
	private WebElement btnDropdown;

	/* find the zeroth position of xpath into dropdown */
	@FindBys(@FindBy(xpath = "//mat-option[@role='option']"))
	private List<WebElement> selectCompany;

	/* find xpath of toggle web */
	@FindBy(xpath = "//label[@for='mat-slide-toggle-1-input']//div[@class='mat-slide-toggle-thumb-container']")
	private WebElement toggleWeb;

	/* find xpath of toggle mobile */
	@FindBy(xpath = "//label[@for='mat-slide-toggle-2-input']//div[@class='mat-slide-toggle-thumb-container']")
	private WebElement toggleMobile;

	/* find the xpath of save button */
	@FindBy(xpath = "//button/span[text()=' Save ']")
	private WebElement btnSave;

	/* find  the element of table */
	@FindBy(xpath = "//table/tbody/tr[*]/td[2]//a")
	private WebElement col_two_Data;

	/* find the xpath of actual status inside the table */
	@FindBy(xpath = "//table/tbody/tr[*]/td[4]//span[text()=' --- ']")
	private WebElement col_four_Data;

	/* find the xpath of deleting an element from table */
	@FindBy(xpath = "//table/tbody/tr[*]/td[6]//span/mat-icon[text()=' delete_outline']")
	private WebElement btnDelete;

	/* find xpath to verify the page */
	@FindBy(xpath = "//span[text()='No records found']")
	private WebElement txtMsg;

	/* find xpath to validate toggle */
	@FindBy(xpath = "//input[@id='mat-slide-toggle-3-input']")
	private WebElement verifyFarmersToggle;

	/* find xpath to validate mobile toggle */
	@FindBy(xpath = "//input[@id='mat-slide-toggle-215-input']")
	private WebElement verifyUserProfileToggle;
	
	/**
	 *Description: Finding the subcompanies dropdown
	 *@author Lohith Reddy
	 */
	
	@FindBy(xpath = "(//div/mat-select[@role='listbox'])[2]")
	private WebElement btnSubCompanyDropDown;
	
	public WebElement getBtnSubCompanyDropDown() {
		return btnSubCompanyDropDown;
	}
	
	/* Search user role link element from the list in User Roles main grid
	 * @author Lohith Reddy
	 */
	public WebElement actualRoleInList(String role) {
		return driver.findElement(By.xpath("//table/tbody/tr[*]/td[2]//a[text()=' "+role+" ']"));
	}

	/**
	 * capture all the subcompanies present in dropdown
	 * @author Lohith Reddy
	 */
	@FindBys(@FindBy(xpath="//mat-option[contains(@id,'mat-option')]"))
	private List<WebElement> subCompanyNames;
	
	public List<WebElement> getSubCompanyNames() {
		return subCompanyNames;
	}
	
	/* Search user role link element */
	public WebElement actualRole_two(String role) {
		return driver.findElement(By.xpath("//table/tbody/tr[*]/td[2]//a[text()=' "+role+" ']"));
		
	}
	
	/* capture all the toggles */
	@FindBys(@FindBy(xpath = "//div/input[contains(@id,'mat-slide-toggle')]"))
	private List<WebElement> btnToggleElements;

	/* Search user role link element */
	public String actualRole(String role) {
		return driver.findElement(By.xpath("//table/tbody/tr[*]/td[2]//a[text()=' "+role+" ']")).getText();
	}

	/**
	 * Description:validate main grid and user role
	 * 
	 * @author Vinay Singh
	 */
	public synchronized void validateUserRoleURL(String expectedURL) {
		try {
			WebActionUtil.waitForThePresenceOfElement(3);
			WebActionUtil.info("Validation of URL");
			String actualURL = driver.getCurrentUrl();
			Assert.assertEquals(expectedURL, actualURL);
			WebActionUtil.pass("Validation successfully done for UserRole URL");
		} catch (Exception e) {
			WebActionUtil.info("Unable to verify the URL");
			Assert.fail("Unable to verify URL");
		}

	}

	/**
	 * Description validation by user role link
	 * 
	 * @author Vinay Singh
	 */
	public synchronized void validateUserRole(String expected,String role) {
		try {
			WebActionUtil.waitForThePresenceOfElement(3);
			WebActionUtil.info("Validation of User Role");
			Assert.assertEquals(actualRole(role),  expected);
			WebActionUtil.pass("Validation successfully done for User Role");
		} catch (NoSuchElementException e) {
			WebActionUtil.info("Unable to verify the user role");
			Assert.fail("Unable to verify user role");
		}

	}

	/**
	 * Description: validate toggle
	 * 
	 * @author Vinay Singh
	 */
	public synchronized void validateToggle(String attribute, String expectedValue) {
		try {
			WebActionUtil.info("Validation of toggle");
			 for(WebElement toggles:btnToggleElements) {
				Assert.assertTrue(toggles.getAttribute(attribute).equalsIgnoreCase(expectedValue));
		    } 
			 WebActionUtil.pass("Validation of toggle button pass");

		} catch (Exception e) {

			System.out.println(e);
			WebActionUtil.info("Unable to verify the toggle");
			Assert.fail("Unable to verify toggle");

		}

	}

	/***
	 * Description: creating a new user
	 * 
	 * @author Vinay Singh
	 */
	public synchronized void createUserRoles(String userRoleName, String expectedCompany) {
		try {
			WebActionUtil.waitForThePresenceOfElement(3);
			WebActionUtil.clickOnElement(iconAdd, "Add icon");
			WebActionUtil.typeText(txtUserRoleName, userRoleName, " User Role Name text box");
			WebActionUtil.clickOnElement(btnDropdown, "Dropdown button");
			WebActionUtil.handlingList(selectCompany, expectedCompany, "Company drop down");
			WebActionUtil.waitForThePresenceOfElement(2);
			WebActionUtil.clickOnElement(btnSave, "Save button");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.info("Unable to perform action add user role");
			Assert.fail("Unable to perform action add user role");
		}

	}

	/***
	 * Description: creating a new user and enable the toggle of web and mobile
	 * features
	 * 
	 * @author Vinay Singh
	 */
	public synchronized void enableWebAndMobileToggle(String userRoleName, String expectedCompany) {
		try {
			WebActionUtil.waitForThePresenceOfElement(5);
			WebActionUtil.clickOnElement(iconAdd, "Add icon");
			WebActionUtil.typeText(txtUserRoleName, userRoleName, " User Role Name text box");
			WebActionUtil.clickOnElement(btnDropdown, "Dropdown button");
			WebActionUtil.handlingList(selectCompany, expectedCompany, "Company drop down");
			WebActionUtil.clickOnElement(toggleWeb, "Web toggle");
			WebActionUtil.clickOnElement(toggleMobile, "Mobile toggle");
		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.info("Unable to perform action add user");
			Assert.fail("Unable to perform action add user");
		}

	}
	
	public synchronized void clickOnSaveBtn() {
		try {
			WebActionUtil.clickOnElement(btnSave, "Save button");
		}catch(Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.info("Unable to perform action add user");
			Assert.fail("Unable to perform action add user");
		}
	
	}

	/**
	 * Description: clicking on checkbox through refrence of cellData
	 * 
	 * @author Vinay Singh
	 * @param cellData
	 */
	public synchronized void clickOnCheckbox(String cellData) {

		WebElement chkboxColumn = driver
				.findElement(By.xpath("//table[@class='checkbox-table mat-table']/descendant::a[contains(text(),"
						+ cellData + ")]/ancestor::tr[1]/descendant::input"));
		WebActionUtil.waitForElement(chkboxColumn, "CheckBox Column", ETO);
		WebActionUtil.clickElementByUsingJS(chkboxColumn, "checkbox column");

	}

	/**
	 * 
	 * Description:search and delete perform in this method
	 * 
	 * @author Vinay Singh
	 */
	public synchronized void search_And_Delete(String searchRole, String expectedUserRole, String expectedStatus) {
		try {
			WebActionUtil.waitForThePresenceOfElement(2);
			WebActionUtil.typeText(txtSearch, searchRole, " User Role Name text box");
			WebActionUtil.waitForThePresenceOfElement(2);
			String cellData = WebActionUtil.getText(col_two_Data);
			WebActionUtil.waitForThePresenceOfElement(2);
			String actualStatus = WebActionUtil.getText(col_four_Data);
			if (cellData.equals(expectedUserRole)) {
				if (actualStatus.equals(expectedStatus)) {
					System.out.println("ACTIVE----->We cannot delete any user role");

				} else {
					WebActionUtil.waitForThePresenceOfElement(5);
					clickOnCheckbox(cellData);
					WebActionUtil.clickOnElement(btnDelete, "Delete button");
					WebActionUtil.waitForThePresenceOfElement(2);
					WebActionUtil.clearText(txtSearch, "Search Role");
					WebActionUtil.waitForElement(txtSearch, cellData, ETO);
					WebActionUtil.typeText(txtSearch, cellData, " User Role Name text box");

				}

			} else {
				System.out.println("Element is not present in the table");
			}

		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.info("Unable to perform search and delete");
			Assert.fail("Unable to perform search and delete");
		}

	}

	/***
	 * Description verify the page
	 * 
	 * @author Vinay Singh
	 */
	public synchronized void verifyPage(String expectedMsg) {
		try {
			WebActionUtil.waitForThePresenceOfElement(3);
			String actualMsg=txtMsg.getText();
			//WebActionUtil.verifytext(expectedMsg, txtMsg, "Text Message");
			WebActionUtil.info("Verifying the page");
			Assert.assertEquals(actualMsg, expectedMsg);
			WebActionUtil.pass("Successfully validation completed");

		} catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.info("Unable to perform verify the page");
			Assert.fail("Unable to perform verify the page");
		}
	}

}
