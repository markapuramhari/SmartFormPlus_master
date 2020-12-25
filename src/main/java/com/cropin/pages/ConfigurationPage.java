package com.cropin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cropin.util.WebActionUtil;

public class ConfigurationPage {
	public WebDriver driver;
	public WebActionUtil WebActionUtil;
	public long ETO = 10;
	public ConfigurationPage(WebDriver driver, WebActionUtil WebActionUtil, long ETO) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.WebActionUtil = WebActionUtil;
		this.ETO = ETO;
	}
	
	/*find xpath of Plan Types */
	@FindBy(xpath="//span[text()='Plan Types']")
	private WebElement lnkPlanTypes;
	
	
	/*find xpath of Contractor */
	@FindBy(xpath="//span[text()='Contractor']")
	private WebElement lnkContractor;
	
	
	/*find xpath of Farmers */
	@FindBy(xpath="//span[text()='Farmers ']")
	private WebElement lnkFarmers ;
	
	
	/*find xpath of Assets */
	@FindBy(xpath="//span[text()='Assets']")
	private WebElement lnkAssets;
	
	
	/*find xpath of farm resource */
	@FindBy(xpath="//span[text()='Farm Resource']")
	private WebElement lnkFarmResource;
	
	/*find xpath of Crop(s)*/
	@FindBy(xpath="//span[text()='Crop(s)']")
	private WebElement lnkCrop;
	
	
	/*find xpath of Alerts */
	@FindBy(xpath="//span[text()='Alerts']")
	private WebElement lnkAlerts;
	
	
	/*find xpath of Farms */
	@FindBy(xpath="//span[text()='Forms']")
	private WebElement lnkForms;
	
	/*find xpath of Smart Compute */
	@FindBy(xpath="//span[text()='Smart Compute']")
	private WebElement lnkSmartCompute;
	
	/**
	 * Description:navigate to Plan Types
	 * 
	 * @author Vinay Singh
	 */
	public synchronized void navigateToPlanTypes() {
		WebActionUtil.waitForThePresenceOfElement(5);
		WebActionUtil.clickOnElement(lnkPlanTypes, "Plan Types link ");
	}
	
	/**
	 * Description:navigate to Contractor
	 * 
	 * @author Vinay Singh
	 */
	public synchronized void navigateToContractor() {
		WebActionUtil.waitForThePresenceOfElement(5);
		WebActionUtil.clickOnElement(lnkContractor, "Contractor link ");
	}
	
	/**
	 * Description:navigate to Farmers
	 * 
	 * @author Vinay Singh
	 */
	public synchronized void navigateToFarmers() {
		WebActionUtil.waitForThePresenceOfElement(5);
		WebActionUtil.clickOnElement(lnkFarmers, "Farmers link ");
	}
	
	/**
	 * Description:navigate to Assets
	 * 
	 * @author Vinay Singh
	 */
	public synchronized void navigateToAssets() {
		WebActionUtil.waitForThePresenceOfElement(5);
		WebActionUtil.clickOnElement(lnkAssets, "Assets link ");
	}
	
	/**
	 * Description:navigate to Farm Resource
	 * 
	 * @author Vinay Singh
	 */
	public synchronized void navigateToFarmResource() {
		WebActionUtil.waitForThePresenceOfElement(5);
		WebActionUtil.clickOnElement(lnkFarmResource, "Farm Resource link ");
	}
	
	/**
	 * Description:navigate to Crop(s)
	 * 
	 * @author Vinay Singh
	 */
	public synchronized void navigateToCrop() {
		WebActionUtil.waitForThePresenceOfElement(5);
		WebActionUtil.clickOnElement(lnkCrop, "Crop link ");
	}
	
	/**
	 * Description:navigate to Alerts
	 * 
	 * @author Vinay Singh
	 */
	public synchronized void navigateToAlerts() {
		WebActionUtil.waitForThePresenceOfElement(5);
		WebActionUtil.clickOnElement(lnkAlerts, "Alerts link ");
	}
	
	/**
	 * Description:navigate to Forms
	 * 
	 * @author Vinay Singh
	 */
	public synchronized void navigateToForms() {
		WebActionUtil.waitForThePresenceOfElement(5);
		WebActionUtil.clickOnElement(lnkForms, "Forms link ");
	}
	
	/**
	 * Description:navigate to Smart Compute
	 * 
	 * @author Vinay Singh
	 */
	public synchronized void navigateToSmartCompute() {
		WebActionUtil.waitForThePresenceOfElement(5);
		WebActionUtil.clickOnElement(lnkSmartCompute, "Smart Compute link ");
	}
}
