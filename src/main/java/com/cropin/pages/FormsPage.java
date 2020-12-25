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

public class FormsPage {
	public WebDriver driver;
	public WebActionUtil WebActionUtil;
	public long ETO = 10;
	public FormsPage(WebDriver driver,WebActionUtil WebActionUtil,long ETO) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.WebActionUtil = WebActionUtil;
		this.ETO = ETO;
	}
	
	/*find xpath of add icon */
	@FindBy(xpath="//mat-icon[text()='add']")
	private WebElement iconAdd;
	
	/*find xpath of Name text box */
	@FindBy(xpath="//span[text()='Form Name']/../../../input[@id='name']")
	private WebElement txtFormName;
	
	/*find xpath dropdown button */
	@FindBy(xpath="//mat-label[text()='Form Type']/../../../mat-select[@id='formTypeName']")
	private WebElement btnFormType;
	
	/*find xpath to capture dropdown elements */
	@FindBys(@FindBy(xpath="//mat-option[@role='option']"))
	private List<WebElement>  optionsFormType;
	
	/*find the xpath of save button */
	@FindBy(xpath="//button/span[text()=' Save ']")
	private WebElement btnSave;
	
	/* Search Plan Type  link element */
	public String actualForm(String formName) {
		return driver.findElement(By.xpath("//table/tbody/tr[*]/td[2]//a[text()=' "+formName+" ']")).getText();
	}
	
	/**
	 * Description : add forms
	 * @author Vinay Singh
	 * @param formName
	 * @param expectedFormType
	 */
	public synchronized void addForms(String formName,String expectedFormType) {
		try {
			WebActionUtil.waitForThePresenceOfElement(2);
			WebActionUtil.clickOnElement(iconAdd, "Add icon");
			WebActionUtil.typeText(txtFormName, formName, "Form Name input box");
			WebActionUtil.waitForThePresenceOfElement(2);
			WebActionUtil.clickOnElement(btnFormType, "Form Type button");
			WebActionUtil.handlingList(optionsFormType, expectedFormType, "FormType dropdown");
			WebActionUtil.clickOnElement(btnSave, "Save button");
			
		}catch (Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.info("Unable to add forms ");
			Assert.fail("Unable to add forms");
		}
	}
	
	/**
	 * Description: Validation of main page
	 * @author Vinay Singh
	 * @param expectedURL
	 */
	public synchronized void validateURL(String expectedURL) {
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
	 * Description: Validate forms
	 * @author Vinay Singh
	 * @param formName
	 * @param expectedForm
	 */
	public synchronized void validateForm(String formName,String expectedForm) {
		try {
			WebActionUtil.info("Validation of Form");
			WebActionUtil.waitForThePresenceOfElement(3);
			Assert.assertEquals(actualForm(formName), expectedForm);
			WebActionUtil.pass("Validated successfully PlanType created");
		} catch (NoSuchElementException e) {
			WebActionUtil.info("Unable to verify the Form");
			Assert.fail("Unable to verify Form");
		}
	}

}
