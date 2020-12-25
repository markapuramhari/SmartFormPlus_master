package com.cropin.pages;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.cropin.util.WebActionUtil;

public class PlanTypePage {
	public WebDriver driver;
	public WebActionUtil WebActionUtil;
	public long ETO = 10;
	
	public PlanTypePage(WebDriver driver, WebActionUtil WebActionUtil, long ETO) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.WebActionUtil = WebActionUtil;
		this.ETO = ETO;
	}
	
	/* find xpath of add icon */
	@FindBy(xpath = "//mat-icon[normalize-space()='add']")
	private WebElement iconAdd;
	
	/*find xpath of plan type name */
	@FindBy(xpath="//mat-label[text()='Plan type Name ']/../../../input[@type='text']")
	private WebElement txtPlanTypeName;
	
	/*find xpath of add attribute icon */
	@FindBy(xpath="//button/span/span[text()='Add Attribute']")
	private WebElement iconAddAttribute;
	
	/*find xpath of Data Type drop down elements */
	@FindBys(@FindBy(xpath="//mat-option[@role='option']"))
	private List<WebElement> optionsDataType;
	
	/*find xpath of PER_QUANTITY */
	@FindBy(xpath="//div[text()=' PER_QUANTITY ']")
	private WebElement scrollPERQUANTITY;
	
	/*find xpath of Select Column Attributes */
	@FindBy(xpath="//div[text()=' Select Column Attributes ']")
	private WebElement scrollColumnAttributes;
	
	/*find xpath of column header button */
	@FindBy(xpath="//mat-label[text()='Select Column Header Group']/../../../mat-select[@role='listbox']")
	private WebElement btnHeaderGroup;
	
	/*find xpath of header group dropdown elements */
	@FindBys(@FindBy(xpath="//mat-option[@role='option']"))
	private List<WebElement> optionsHeaderGroup_1;
	
	/*find xpath of inside dropdown elements of Header Group*/
	@FindBys(@FindBy(xpath="//mat-list-option[@role='option']"))
	private List<WebElement> optionsHeaderGroup_2;
	
	/*find xpath of save button */
	@FindBy(xpath=("//div/button/span[text()=' Save ']"))
	private WebElement btnSave;
	
	/*find xpath of attribute dropdown button */
	@FindBy(xpath="//mat-label[text()='Attribute']/../../../mat-select[@role='listbox']")
	private WebElement btnAttribute;
	
	/*find xpath to capture attribute dropdown element */
	@FindBys(@FindBy(xpath="//mat-option[@role='option']"))
	private List<WebElement> optionAttribute;
	
	/*find xpath of Value dropdown button */
	@FindBy(xpath="//mat-label[text()='Value']/../../../mat-select[@role='listbox']")
	private WebElement btnValue;
	
	/*find xpath to Value dropdown */
	@FindBys(@FindBy(xpath="//mat-option[@role='option']"))
	private List<WebElement> optionsValue;
	
	/*find xpath of popup save button */
	@FindBy(xpath="//mat-dialog-actions/button/span[text()='Save']")
	private WebElement btnSavePopUp;
	
	/*find xpath of Remove text into table */
	@FindBy(xpath="//table/tbody/tr[*]/td[6]/div/span[text()='Remove']")
	private WebElement txtRemove;
	
	/*find xpath of Remove text into table */
	@FindBy(xpath="//table/tbody/tr[*]/td[7]/div/span[text()='Remove']")
	private WebElement txtRemove_1;
	
	/*find xpath of Calculation logic link*/
	@FindBy(xpath="//div[contains(text(),'Set Calculation Logic')]")
	private WebElement lnkCalculationLogic;
	
	/*find xpath of formula text area*/
	@FindBy(xpath="//div[@id='formula']/textarea")
	private WebElement textFormula;
	
	/*find xpath to capture all the elements of standard fields*/
	@FindBys(@FindBy(xpath="//mat-tree-node[@role='treeitem']"))
	private List<WebElement> elementsAssetFields;
	
	/*find xpath of harvesting custom field to scroll */
	@FindBy(xpath="//mat-icon[text()=' chevron_right ']/../../parent::mat-tree-node[text()=' harvesting ']")
	private WebElement scrollHarvesting;
	
	/*find xpath of Asset audited area to scroll */
	@FindBy(xpath="//mat-tree-node[text()=' Audited Area Unit ']")
	private WebElement scrollAreaUnit;
	
	/*find xpath of Attribute label text box inside table */
	public WebElement txtAttributeLabel(int row) {
		return driver.findElement(By.xpath("//table/tbody/tr["+row+"]/td[2]/descendant::input[@name='label']"));
	}
	
	/*find xpath of Data Type dropdown inside table */
	public WebElement btnDataType(int row) {
		return driver.findElement(By.xpath("//table/tbody/tr["+row+"]/td[3]//mat-label[text()='Data Type']/../../../mat-select[@role='listbox']"));
	}
	
	/*find xpath of toggle inside table */
	public WebElement btnToggle(int row) {
		return driver.findElement(By.xpath("//table/tbody/tr["+row+"]/td[5]//div[@class='mat-slide-toggle-thumb']"));
	}
	
	/*find xpath of settings icon into table */
	public WebElement iconSetting(int row) {
		return driver.findElement(By.xpath("//table/tbody/tr["+row+"]/td[6]/div/div/mat-icon[text()=' settings']"));
	}
	
	/*find xpath of toggle inside table */
	public WebElement btnDelete(int row) {
		return driver.findElement(By.xpath("//table/tbody/tr["+row+"]/td[8]/mat-icon[text()=' delete_outline ']"));
	}
	
	/*find xpath of additional information column */
	public WebElement txtAdditionalInfo(int row_num) {
		return driver.findElement(By.xpath("//table/tbody/tr["+row_num+"]/td[4]/descendant::input"));
	}
	
	/* Search Plan Type  link element */
	public String actualPlanType(String planType) {
		return driver.findElement(By.xpath("//div/div[text()=' "+planType+" ']")).getText();
	}
	
	/*find xpath of plan type*/
	public WebElement lnkPlanName(String planName) {
		return driver.findElement(By.xpath("//div/div[contains(text(),'"+planName+"')] "));
	}
	
	/*find xpath of expected Message after clicking on save */
	public String actualMsg() {
		return driver.findElement(By.xpath("//snack-bar-container/simple-snack-bar/span[text()='Plan type has been updated successfully']")).getText();
	}
	
	/*find xpath of calculated attribute */
	public WebElement calculateAttribute(int row) {
		return driver.findElement(By.xpath("//table/tbody/tr["+row+"]/td[7]/div/div/mat-icon[@role='img']"));
	}
	
	/*find xpath of standard and custom fields*/
	public WebElement stdFields(String fieldName) {
		return driver.findElement(By.xpath("//mat-tree-node[text()=' "+fieldName+" ']/button/span/mat-icon[contains(text(),' chevron_right')] "));
	}
	
	/*find xpath of calculation symbol */
	public WebElement calculationSymbol(String symbol) {
		return driver.findElement(By.xpath("//div/div/span[text()='"+symbol+"']"));
	}
	/**
	 * Description create plan type
	 * @author Vinay Singh
	 */
	public synchronized void createPlanType(String planName) {
		try {
			WebActionUtil.info("Creating PlanTypes");
			WebActionUtil.clickOnElement(iconAdd, "Add icon");
			WebActionUtil.waitForThePresenceOfElement(2);
			WebActionUtil.typeText(txtPlanTypeName, planName, "Plan Types Name text box");
		 }catch(Exception e) {
			  WebActionUtil.error(e.getMessage());
				WebActionUtil.info("Unable to create Plan Types");
				Assert.fail("Unable to create Plan Types");
		  }
	}
	
	/**
	 * Description : handle Header Group column of Plan Type
	 * @author Vinay Singh
	 * @param expectedHeaderGroup
	 */
	public synchronized void handlingHeaderGroup(String expectedHeaderGroup) {
		try {
			WebActionUtil.scrollToElement(scrollColumnAttributes,"Column Attribute Scroll");
			WebActionUtil.waitForThePresenceOfElement(2);
			WebActionUtil.clickOnElement(btnHeaderGroup, "Header Group button");
			WebActionUtil.waitForThePresenceOfElement(2);
			WebActionUtil.handlingList(optionsHeaderGroup_1, expectedHeaderGroup, "Header Group");
			WebActionUtil.scrollToElement(iconAddAttribute, "Add Attribute icon");
			WebActionUtil.waitForThePresenceOfElement(5);
			WebActionUtil.clickOnMultipleElement(optionsHeaderGroup_2, "Header Group Dropdown",scrollPERQUANTITY,"Scroll Per Quantity");
			WebActionUtil.waitForThePresenceOfElement(2);
			WebActionUtil.clickOnElement(btnSave, "Save button");
		  }catch(Exception e) {
			  WebActionUtil.error(e.getMessage());
				WebActionUtil.info("Unable to handle header group");
				Assert.fail("Unable to handle header group");
		  }
	}
	
	/**
	 * Description:Handle attribute label table
	 * @author Vinay Singh
	 * @param i
	 * @param attributeLabel
	 * @param expectedDataType
	 */
	public synchronized void handlingAttributeTable(int row,String attributeLabel,String expectedDataType) {
		try {
		WebActionUtil.scrollToElement(iconAddAttribute, "Add Attribute");
		WebActionUtil.waitForThePresenceOfElement(2);
		WebActionUtil.clickOnElement(iconAddAttribute, "Add attribute icon");
		WebActionUtil.waitForThePresenceOfElement(2);
		WebActionUtil.typeText(txtAttributeLabel(row),attributeLabel,"Attribute label text box");
		WebActionUtil.waitForThePresenceOfElement(2);
		WebActionUtil.clickOnElement(btnDataType(row),"DataType button");
		WebActionUtil.waitForThePresenceOfElement(2);
		WebActionUtil.handlingList(optionsDataType, expectedDataType, "Data Type dropdown");
		
		}catch (Exception e) {
			 WebActionUtil.error(e.getMessage());
				WebActionUtil.info("Unable to handle Attribute table");
				Assert.fail("Unable to handle Attribute table");
		}
	}
	
	/**
	 * @author Vinay Singh
	 * @param j
	 */
	public synchronized void handleAdditionalInfoColumn(int row_num) {
		WebActionUtil.waitForThePresenceOfElement(2);
		WebActionUtil.info("Entering options for drop down data type");
		txtAdditionalInfo(row_num).sendKeys("A",Keys.ENTER);
		txtAdditionalInfo(row_num).sendKeys("B",Keys.ENTER);
		txtAdditionalInfo(row_num).sendKeys("C",Keys.ENTER);
		txtAdditionalInfo(row_num).sendKeys("D",Keys.ENTER);
		WebActionUtil.pass("Entered options completed into Additional Info");
		
		
	}
	
	
	/**
	 * Description:validate main grid and user 
	 * 
	 * @author Vinay Singh
	 */
	public synchronized void validatePlanTypeURL(String expectedURL) {
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
	 * Description validation by user link
	 * 
	 * @author Vinay Singh
	 */
	public synchronized void validatePlanType(String planType,String expectedplanType) {
		try {
			WebActionUtil.info("Validation of User");
			WebActionUtil.waitForThePresenceOfElement(3);
			Assert.assertEquals(actualPlanType(planType), expectedplanType);
			WebActionUtil.pass("Validated successfully PlanType created");
		} catch (NoSuchElementException e) {
			WebActionUtil.info("Unable to verify the Plan Type");
			Assert.fail("Unable to verify Plan Type");
		}

	  }
	
	/**
	 * Description Edit Plan
	 * @author Vinay Singh
	 */
	public synchronized void editPlanType(String planName,int row,String expectedHeaderGroup ) {
		try {
			WebActionUtil.waitForThePresenceOfElement(2);
			WebActionUtil.clickOnElement(lnkPlanName(planName),"Plan Type link");
			WebActionUtil.clickOnElement(btnDelete(row), "Delete button");
			WebActionUtil.waitForThePresenceOfElement(2);
			WebActionUtil.scrollToElement(scrollColumnAttributes,"Column Attribute Scroll");
			WebActionUtil.waitForThePresenceOfElement(2);
			WebActionUtil.clickOnElement(btnHeaderGroup, "Header Group button");
			WebActionUtil.waitForThePresenceOfElement(2);
			WebActionUtil.handlingList(optionsHeaderGroup_1, expectedHeaderGroup, "Header Group");
			WebActionUtil.scrollToElement(iconAddAttribute, "Add Attribute icon");
			WebActionUtil.waitForThePresenceOfElement(2);
			WebActionUtil.clickOnElement(btnSave, "Save button");
		}catch (Exception e) {
			 WebActionUtil.error(e.getMessage());
				WebActionUtil.info("Unable to edit Plan Type");
				Assert.fail("Unable to edit Plan Type");
		}
	}
	
	/**
	 * Description: Validation after edit
	 * @author Vinay Singh
	 */
	public synchronized void validateMsg(String expectedMsg) {
		try {
			WebActionUtil.info("Validation after Edit");
			WebActionUtil.waitForThePresenceOfElement(3);
			Assert.assertEquals(actualMsg(), expectedMsg);
			WebActionUtil.pass("Editing of fields successfully save");
			
		}catch (Exception e) {
			 WebActionUtil.error(e.getMessage());
				WebActionUtil.info("Unable to validate Msg");
				Assert.fail("Unable to validate Msg");
		}
	}
	
	/**
	 * Description : enable toggle
	 * @author Vinay Singh
	 */
	public synchronized void enableToggle(String planName,int row) {
		try {
			WebActionUtil.waitForThePresenceOfElement(3);
			WebActionUtil.clickOnElement(lnkPlanName(planName),"Plan Type link");
			WebActionUtil.waitForThePresenceOfElement(10);
			WebActionUtil.clickOnElement(btnToggle(row), "Toggle button");
			WebActionUtil.clickOnElement(btnSave, "Save button");
		}catch(Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.info("Unable to enable toggle");
			Assert.fail("Unable to enable toggle");
		}
	}
	
	/**
	 * Description : validate save button is enable or not without giving input to mandatory field
	 * @author Vinay Singh
	 */
	public synchronized void isEnableSave() {
		try {
			WebActionUtil.waitForThePresenceOfElement(3);
			WebActionUtil.clickOnElement(iconAdd, "Add icon");
			WebActionUtil.waitForThePresenceOfElement(2);
			WebActionUtil.waitForThePresenceOfElement(10);
			WebActionUtil.info("Validate save button is enable or not");
			Assert.assertTrue(btnSave.isEnabled());
			WebActionUtil.pass("Save button is not enable");
			
		}catch(Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.info("Unable to validate Save button");
			Assert.fail("Unable to validate Save button");
		}
	}
	
	/**
	 * Description : conditional attribute
	 * @author Vinay Singh
	 * @param planName
	 * @param row
	 * @param expectedAttribute
	 * @param expectedValue
	 */
	public synchronized void conditionalAttribute(String planName,int row,String expectedAttribute,String expectedValue) {
		try {
			WebActionUtil.waitForThePresenceOfElement(3);
			WebActionUtil.clickOnElement(lnkPlanName(planName),"Plan Type link");
			WebActionUtil.scrollToElement(iconAddAttribute, "Add Attribute icon");
			WebActionUtil.clickOnElement(iconSetting(row), "Setting icon");
			WebActionUtil.clickOnElement(btnAttribute, "Attribute button");
			WebActionUtil.handlingList(optionAttribute, expectedAttribute, "Attribute dropdown");
			WebActionUtil.clickOnElement(btnValue, "Value button");
			WebActionUtil.handlingList(optionsValue, expectedValue, "Attribute dropdown");
			WebActionUtil.clickOnElement(btnSavePopUp, "Save button of pop-up");
			WebActionUtil.clickOnElement(btnSave, "Save button");
			
		}catch(Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.info("Unable to perform action on Conditional attribute");
			Assert.fail("Unable to perform action on Conditional attribute");
		}
	}
	/**
	 * Description : Validation of Conditional Attribute
	 * @author Vinay Singh
	 * @param expectedTest
	 */
	public synchronized void validateConditionalAttribute(String expectedTest) {
		try {
			WebActionUtil.info("Validate Conditional Attribute");
			String actualText=txtRemove.getText();
			Assert.assertEquals(actualText, expectedTest);
			WebActionUtil.pass("Validation is successful");
			
		}catch(Exception e) {
			WebActionUtil.info("Unable to validate Conditional attribute");
			Assert.fail("Unable to validate Conditional attribute");
		}
	}
	/**
	 * Description:Perform action on calculation attribute column
	 * @author Vinay Singh
	 * @param planName
	 * @param row
	 * @param fieldName
	 * @param expectedAsset
	 * @param symbol
	 * @param expectedAsset_1
	 * @param symbol_1
	 * @param symbol_2
	 * @param expectedAsset_2
	 * @param expectedAsset_3
	 */
	public synchronized void calculatedAttribute(String planName,int row,String fieldName,String expectedAsset,String symbol,String expectedAsset_1,String symbol_1,String symbol_2,String expectedAsset_2,String expectedAsset_3) {
		try {
			WebActionUtil.waitForThePresenceOfElement(3);
			WebActionUtil.clickOnElement(lnkPlanName(planName),"Plan Type link");
			WebActionUtil.clickOnElement(calculateAttribute(row), "Calculation Attribute");
			WebActionUtil.clickOnElement(lnkCalculationLogic, "Calculation logic link");
			WebActionUtil.waitForThePresenceOfElement(5);
			formula(fieldName, expectedAsset, symbol, expectedAsset_1, symbol_1, symbol_2, expectedAsset_2, expectedAsset_3);
			
		}catch(Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.info("Unable to perform action on calculated attribute");
			Assert.fail("Unable to perform action on calculated attribute");
		}
	}
	
	/**
	 * 
	 * @author Vinay Singh
	 * @param fieldName
	 * @param expectedAsset
	 * @param symbol
	 * @param expectedAsset_1
	 * @param symbol_1
	 * @param symbol_2
	 * @param expectedAsset_2
	 * @param expectedAsset_3
	 */
	public synchronized void formula(String fieldName,String expectedAsset,String symbol,String expectedAsset_1,String symbol_1,String symbol_2,String expectedAsset_2,String expectedAsset_3) {
		try {
			WebActionUtil.scrollToElement(scrollHarvesting, "Scroll to Harvesting");
			WebActionUtil.waitForThePresenceOfElement(3);
			WebActionUtil.clickOnElement(stdFields(fieldName), "Standard Fields");
			WebActionUtil.waitForThePresenceOfElement(2);
			WebActionUtil.handlingList(elementsAssetFields, expectedAsset, "Asset fields");
			WebActionUtil.waitForThePresenceOfElement(2);
			WebActionUtil.actionScrollUp();
			WebActionUtil.waitForThePresenceOfElement(3);
			WebActionUtil.clickOnElement(calculationSymbol(symbol), "Symbol");
			WebActionUtil.waitForThePresenceOfElement(2);
			WebActionUtil.scrollToElement(scrollHarvesting, "Scroll to Harvesting");
			WebActionUtil.handlingList(elementsAssetFields, expectedAsset_1, "Asset fields");
			WebActionUtil.waitForThePresenceOfElement(2);
			WebActionUtil.actionScrollUp();
			WebActionUtil.waitForThePresenceOfElement(3);
			WebActionUtil.clickOnElement(calculationSymbol(symbol_1), "Symbol");
			WebActionUtil.waitForThePresenceOfElement(2);
			WebActionUtil.clickOnElement(calculationSymbol(symbol_2), "Symbol");
			WebActionUtil.waitForThePresenceOfElement(2);
			WebActionUtil.scrollToElement(scrollHarvesting, "Scroll to Harvesting");
            WebActionUtil.scrollToElement(scrollAreaUnit, "Area unit");
			WebActionUtil.handlingList(elementsAssetFields, expectedAsset_2, "Asset fields");
			WebActionUtil.waitForThePresenceOfElement(2);
			WebActionUtil.actionScrollUp();
			WebActionUtil.waitForThePresenceOfElement(2);
			WebActionUtil.clickOnElement(calculationSymbol(symbol), "Symbol");
			WebActionUtil.waitForThePresenceOfElement(2);
			WebActionUtil.scrollToElement(scrollHarvesting, "Scroll to Harvesting");
            WebActionUtil.scrollToElement(scrollAreaUnit, "Area unit");
            WebActionUtil.waitForThePresenceOfElement(2);
			WebActionUtil.handlingList(elementsAssetFields, expectedAsset_3, "Asset fields");
			WebActionUtil.waitForThePresenceOfElement(2);
			WebActionUtil.actionScrollUp();
			WebActionUtil.waitForThePresenceOfElement(2);
			WebActionUtil.clickOnElement(calculationSymbol(symbol_1), "Symbol");
			WebActionUtil.clickOnElement(btnSave,"Save button");
		}catch(Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.info("Unable to perform action on calculated attribute");
			Assert.fail("Unable to perform action on calculated attribute");
			
		}
		
	}
	
	
	/**
	 * Description :validation of calculated attribute column
	 * @author Vinay Singh
	 * @param expectedTest
	 */
	public synchronized void validateCalculatedAttribute(String expectedTest) {
		try {
			WebActionUtil.info("Validate Calculated Attribute");
			String actualText=txtRemove_1.getText();
			Assert.assertEquals(actualText, expectedTest);
			WebActionUtil.pass("Validation is successful");
			WebActionUtil.clickOnElement(btnSave,"Save button");
		}catch(Exception e) {
			WebActionUtil.info("Unable to validate Calculated attribute");
			Assert.fail("Unable to validate Calculated attribute");
		}
	}
	
}
