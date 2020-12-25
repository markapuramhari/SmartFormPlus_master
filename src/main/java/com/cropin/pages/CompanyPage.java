package com.cropin.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.cropin.util.WebActionUtil;
public class CompanyPage {
	public WebDriver driver;
	public WebActionUtil WebActionUtil;
	public long ETO = 10;
	
	public CompanyPage(WebDriver driver, WebActionUtil WebActionUtil, long ETO) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.WebActionUtil = WebActionUtil;
		this.ETO = ETO;
	}

	/*finding element of Edit button*/
	@FindBy(xpath="//button/span[text()=' Edit ']")
	private WebElement buttonEdit;
	
	/*finding element of SubCompanies*/
	@FindBy(xpath="//div[text()=' Sub Companies ']")
	private WebElement clickSubCompanies;
	
	/*finding element of AddNew*/
	@FindBy(xpath="//span[text()=' Add New ']")
	private WebElement clickAddNew;
	
	/* finding the element for fetching the SubCompanies in Company */
	@FindBys(@FindBy(xpath="//div[contains(@class,'sub-company-container m-3 mt-2 ng-star-inserted')]"))
	private List<WebElement> listSubCompanies;
	
	/* Access the list of SubCompanies in Company */
	public List<WebElement> getListSubCompanies() {
		return listSubCompanies;
	}

	
	/*Description Method for navigating from company to add SubComapanies
	 * @author Lohith Reddy
	 */
	public synchronized void navigateToAddSubCompanies() {
		try {
		WebActionUtil.clickOnElement(buttonEdit, "Edit");
		WebActionUtil.clickOnElement(clickSubCompanies, "SubCompanies");
		WebActionUtil.clickOnElement(clickAddNew, "AddNew");
		}
		catch(Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.info("Unable to Navigate to SubCompanies");
			Assert.fail("Unable to Navigate to SubCompanies");
		}
	}
	
	/*Description Method for fetching the SubCompanies present in Company
	 * @author Lohith Reddy
	 */
	public synchronized void fetchingSubCompanies() {
		try {
		WebActionUtil.clickOnElement(clickSubCompanies, "SubCompanies");
		for(WebElement element : listSubCompanies ) {
		Assert.assertTrue(element.isDisplayed());
		}
		WebActionUtil.pass("All the SubCompanies are displayed");
		}
		catch(Exception e) {
			WebActionUtil.error(e.getMessage());
			WebActionUtil.info("Unable to display SubCompanies");
			Assert.fail("Unable to display to SubCompanies");
		}
}
}
