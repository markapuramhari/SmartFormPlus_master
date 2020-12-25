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

public class AlertsPage {
	public WebDriver driver;
	public WebActionUtil WebActionUtil;
	public long ETO = 10;
	
	public AlertsPage(WebDriver driver, WebActionUtil WebActionUtil, long ETO) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.WebActionUtil = WebActionUtil;
		this.ETO = ETO;
	}
	
	/*find xpath of add icon */
	@FindBy(xpath="//button/span/mat-icon[text()='add']")
	private WebElement iconAdd;
	
	/*find xpath of Name field*/
	@FindBy(xpath="//mat-label[text()='Name ']/../../../input[@type='text']")
	private WebElement txtName;
	
	/*find xpath of alert type field*/
	@FindBy(xpath="//mat-label[text()='Alert Type']/../../../mat-select[@role='listbox']")
	private WebElement btnAlertType;
	
	/*find xpath to capture the elements of alert type field*/
	@FindBys(@FindBy(xpath="//mat-option[@role='option']"))
	private List<WebElement> optionsAlertType;
	
	/*find xpath of Crop(s) dropdown button */
	@FindBy(xpath="//mat-label[text()='Crop(s)']/../../../mat-select[@role='listbox']")
	private WebElement btnCrop;
	
	/*find xpath of Search text box*/
	@FindBy(xpath="//span[text()='Search Alert']/../../../input[@type='text']")
	private WebElement txtSearch;
	
	/*find xpath of add new button */
	@FindBy(xpath="//span[text()=' Add New ']/mat-icon[text()='add']")
	private WebElement btnAddNew;
	
	/*find xpath of plan name field */
	@FindBy(xpath="//mat-label[text()='Plan Name ']/../../../input[@type='text']")
	private WebElement txtPlanName;
	
	/*find xpath of Plan Type drop down button */
	@FindBy(xpath="//mat-label[text()='Plan Type']/../../../mat-select[@role='listbox']")
	private WebElement btnPlanType;
	
	/*find xpath of plan type elements */
	@FindBys(@FindBy(xpath="//mat-option[@role='option']"))
	private List<WebElement> optionsPlanType;
	
	/*find xpath of continue button */
	@FindBy(xpath="//button/span[text()='Continue']")
	private WebElement btnContinue;
	
	/*find xpath of drop down button inside custom attributes */
	@FindBy(xpath="//mat-label[text()='Drop Down']/../../../mat-select[@role='listbox']")
	private WebElement btnDrp_dwn_CustomAttributes;
	
	/*find xpath of plan type elements */
	@FindBys(@FindBy(xpath="//mat-option[@role='option']"))
	private List<WebElement> optionsCustomAttributes;
	
	/*find xpath of Plan */
	public String actualPlan(String planName) {
		return driver.findElement(By.xpath("//button/span[text()=' "+planName+" ']")).getText();
	}
	
	/*find xpath of Crop(s) dropdown parent element*/
	public WebElement chkboxCrop(String parent) {
		return driver.findElement(By.xpath("//span[text()=' "+parent+" ']/preceding-sibling::div/input[@type='checkbox']"));
	}
	
	/*find xpath of Crop(s) dropdown child element*/
	public WebElement chkboxVariety_SubVariety(String child,String sub_child) {
		return driver.findElement(By.xpath("//span[text()=' "+child+" ']/preceding-sibling::div/ancestor::li[1]/ul/descendant::span[contains(text(),'"+sub_child+"')]/preceding-sibling::div/input"));
	}
	
	/*find xpath of radio button */
	public WebElement radioAdvice(String radio) {
		return driver.findElement(By.xpath("//div[contains(text(),'"+radio+"')]/preceding-sibling::div/input[@type='radio']"));
	}
	
	/* find xpath of alert link element */
	public WebElement lnkAlert(String alert) {
		return driver.findElement(By.xpath("//table/tbody/tr[*]/td[1]//a[text()=' "+alert+" ']"));
	}
	
	/*find xpath of advice text field */
	@FindBy(xpath="//span[text()='Advice']/../../../textarea[@placeholder='Advice']")
	private WebElement txtAdvice;
	
	/*find xpath of save btn */
	@FindBy(xpath="(//div/button/span[text()=' Save '])[1]")
	private WebElement btnSave_1;
	
	/*find xpath of second save button */
	@FindBy(xpath="(//div/button/span[text()=' Save '])[2]")
	private WebElement btnSave_2;
	
	/* find xpath of alert link element */
	public String actualAlert(String alert) {
		return driver.findElement(By.xpath("//table/tbody/tr[*]/td[1]//a[text()=' "+alert+" ']")).getText();
	}
	
	/* find xpath of alert link element */
	public String actualEditAlert(String alert) {
		return driver.findElement(By.xpath("//table/tbody/tr[*]/td[1]//a[text()=' "+alert+" ']/../../following-sibling::td[4]/span/span")).getText();
	}
	
	/*find xpath od delete button */
	public WebElement btnDelete(String alert) {
		return driver.findElement(By.xpath("//table/tbody/tr[*]/td[1]//a[text()=' "+alert+" ']/../../following-sibling::td[5]//span/mat-icon[text()=' delete_outline']"));
	}
	
	public synchronized void addAlert(String alertName,String expectedAlert,String parent,String radio,String advice) {
		try {
			WebActionUtil.clickOnElement(iconAdd, "Add icon");
			WebActionUtil.typeText(txtName, alertName, "Alert text box");
			WebActionUtil.clickOnElement(btnAlertType, "AlertType dropdown button");
			WebActionUtil.handlingList(optionsAlertType, expectedAlert, "AlertType dropdown");
			WebActionUtil.clickOnElement(btnCrop, "Crop button");
			WebActionUtil.waitForThePresenceOfElement(5);
			WebActionUtil.clickCheckBoxByJS(chkboxCrop(parent), "Crop checkbox or Variety checkbox");
			WebActionUtil.waitForThePresenceOfElement(5);
			WebActionUtil.scrollToElement(txtAdvice, "Scroll to Advice text box");
			WebActionUtil.clickOnRadioButton(radioAdvice(radio), "Advice radio button");
			WebActionUtil.waitForThePresenceOfElement(10);
			WebActionUtil.typeText(txtAdvice, advice, "Advice text box");
			WebActionUtil.waitForThePresenceOfElement(2);
			WebActionUtil.clickByJs(btnSave_1, "Save button");
		}catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.info("Unable to create Alert");
			Assert.fail("Unable to create Alert");
		}
	}
	
	/**
	 * Description:validation of main grid page by URL
	 * 
	 * @author Vinay Singh
	 */
	public synchronized void validateAlertURL(String expectedURL) {
		try {
			WebActionUtil.info("Validation of Main Grid page using URL");
			WebActionUtil.waitForThePresenceOfElement(3);
			String actualURL = driver.getCurrentUrl();
			Assert.assertEquals(expectedURL, actualURL);
			WebActionUtil.pass("Validate successfully that page comes to main page after clicking on Save button");
		} catch (Exception e) {
			WebActionUtil.info("Unable to verify the URL");
			Assert.fail("Unable to verify URL");
		}

	}
	
	/**
	 * Description validation by alert link
	 * 
	 * @author Vinay Singh
	 */
	public synchronized void validateAlert(String alert,String expectedAlertName) {
		try {
			WebActionUtil.info("Validation of Alert");
			WebActionUtil.waitForThePresenceOfElement(3);
			Assert.assertEquals(actualAlert(alert), expectedAlertName);
			WebActionUtil.pass("Validated successfully Alert is added");
		} catch (NoSuchElementException e) {
			WebActionUtil.info("Unable to verify the Alert");
			Assert.fail("Unable to verify Alert");
		}

	  }
	/**
	 * Description: edit alert
	 * @author Vinay Singh
	 * @param alert
	 * @param advice
	 */
	public synchronized void editAlert(String alert,String advice) {
		try {
			WebActionUtil.waitForThePresenceOfElement(3);
			WebActionUtil.clickOnElement(lnkAlert(alert), "Alert link");
			WebActionUtil.scrollToElement(txtAdvice, "Scroll to Advice");
			WebActionUtil.clearText(txtAdvice, "Advice text box");
			WebActionUtil.waitForThePresenceOfElement(5);
			WebActionUtil.typeText(txtAdvice, advice, "Advice textbox");
			WebActionUtil.waitForThePresenceOfElement(3);
			WebActionUtil.clickByJs(btnSave_1, "Save button");
		}catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.info("Unable to edit Alert");
			Assert.fail("Unable to edit Alert");
		}
	}
	/**
	 * Description : Validation after edit
	 * @author Vinay Singh
	 * @param alert
	 * @param expectedEditAlert
	 */
	public synchronized void validateEditAlert(String alert,String expectedEditAlert) {
		try {
			WebActionUtil.info("Validation after  Alert editing");
			WebActionUtil.waitForThePresenceOfElement(3);
			Assert.assertEquals(actualEditAlert(alert), expectedEditAlert);
			WebActionUtil.pass("Validated successfully Alert is added");
			
		}catch (Exception e) {
			WebActionUtil.info("Unable to verify the Alert after editing");
			Assert.fail("Unable to verify Alert after editing");
		}
	}
	/**
	 * Description delete and search
	 * @author Vinay Singh
	 * @param alert
	 * @param alertName
	 */
	public synchronized void delete_And_Search(String alert,String alertName) {
		try {
			WebActionUtil.clickOnElement(btnDelete(alert), "Delete button");
			WebActionUtil.waitForThePresenceOfElement(3);
			WebActionUtil.typeText(txtSearch, alertName, "Search text box");
			
		}catch(Exception e) {
			WebActionUtil.info("Unable to perform delete and search");
			Assert.fail("Unable to perform delete and search");
		}
	}
	
	public synchronized void validateDelete(String alert,String expectedAlert) {
		try {
			WebActionUtil.info("Validating Alert deleted or not");
			WebActionUtil.waitForThePresenceOfElement(5);
			Assert.assertTrue(actualAlert(alert).equalsIgnoreCase(expectedAlert));
			WebActionUtil.fail("Alert is not deleted");
			
		}catch (Exception e) {
			WebActionUtil.info("Unable to verify the Alert after delete");
			Assert.fail("Unable to verify Alert after delete");
		}
	}
	
	public synchronized void addPlanAlert(String alert,String planName,String expectedPlanType,String expectedCA) {
		try {
		WebActionUtil.waitForThePresenceOfElement(3);
		WebActionUtil.clickOnElement(lnkAlert(alert), "Alert link");
		WebActionUtil.clickOnElement(btnAddNew, "Add New button");
		WebActionUtil.typeText(txtPlanName, planName, "Plan Name text box");
		WebActionUtil.clickOnElement(btnPlanType, "PlanType button");
		WebActionUtil.handlingList(optionsPlanType, expectedPlanType, "Plan Type drop down");
		WebActionUtil.clickOnElement(btnContinue, "Continue button");
		WebActionUtil.clickOnElement(btnDrp_dwn_CustomAttributes, "Custom Attribute Drop down button");
		WebActionUtil.handlingList(optionsCustomAttributes, expectedCA, "Custom Attributes dropdown");
		WebActionUtil.waitForThePresenceOfElement(3);
		WebActionUtil.clickByJs(btnContinue, "Continue button");
		WebActionUtil.clickByJs(btnSave_2, "Save button");
		
		
		
	   }catch (Exception e) {
		   WebActionUtil.error(e.getMessage());
			WebActionUtil.info("Unable to add Plan");
			Assert.fail("Unable to add plan");
	  }
	}
	
	public synchronized void validatePlan(String planName,String expectedPlan ) {
		try {
			WebActionUtil.info("Validating Plan ceated or not");
			
			Assert.assertEquals(actualPlan(planName),expectedPlan);
			WebActionUtil.pass("Successfully plan is created");
			WebActionUtil.waitForThePresenceOfElement(3);
			WebActionUtil.clickByJs(btnSave_1, "Save button");
		}catch (Exception e) {
			WebActionUtil.info("Unable to verify the Plan");
			Assert.fail("Unable to verify Plan");
		}
		
	}
	
}
