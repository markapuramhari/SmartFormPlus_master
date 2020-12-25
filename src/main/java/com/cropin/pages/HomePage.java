package com.cropin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cropin.util.WebActionUtil;

public class HomePage {
	public WebDriver driver;
	public WebActionUtil WebActionUtil;
	public long ETO = 10;
	public HomePage(WebDriver driver, WebActionUtil WebActionUtil, long ETO) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.WebActionUtil = WebActionUtil;
		this.ETO = ETO;
	}
	
	/* finding dashboard element */
	@FindBy(xpath="//div/mat-icon[@mattooltip='Dashboard']")
	private WebElement iconDashboard;
	
	/* finding setup element */
	@FindBy(xpath="//span//div/mat-icon[text()=' settings']")
	private WebElement iconSettings;
	
	/* finding configuration element */                            
	@FindBy(xpath="//div/mat-icon[@mattooltip='Configuration']")
	private WebElement iconConfiguration;
	
	/* finding project element */
	@FindBy(xpath="//div/mat-icon[@mattooltip='Project']")
	private WebElement iconProject;
	
	/*finding reports element */
	@FindBy(xpath="//div/mat-icon[@mattooltip='Reports']")
	private WebElement iconReports;
	
	/*finding account menu */
	@FindBy(id="account-menu")
	private WebElement lnkAccountMenu;
	
	/*finding logout element */
	@FindBy(id="logout")
	private WebElement lnkSignOut;
	
	/**
	 * Description: navigate to dashboard module
	 * @author Vinay Singh
	 */
	
	public synchronized void navigateToDashboard() {
		WebActionUtil.waitForThePresenceOfElement(5);
		WebActionUtil.clickOnElement(iconDashboard, "Dashboard Icon ");
	}
	
	/**
	 * Description:navigate to setup module
	 * @author Vinay Singh
	 */
	public synchronized void navigateToSetup() {
		WebActionUtil.waitForThePresenceOfElement(5);
		WebActionUtil.clickOnElement(iconSettings, "Settings Icon ");
		
	}
	
	/**
	 * Description:navigate to Configuration 
	 * @author Vinay Singh
	 */
	public synchronized void navigateToConfiguration() {
		WebActionUtil.waitForThePresenceOfElement(5);
		WebActionUtil.clickOnElement(iconConfiguration, "Configuration Icon ");
	}
	
	/**
	 * Description: navigate to 
	 * @author Vinay Singh
	 */
	public synchronized void navigateToProject() {
		WebActionUtil.waitForThePresenceOfElement(5);
		WebActionUtil.clickOnElement(iconProject, "Project Icon ");
		
	}
	
	/**
	 * Description:navigate to Reports
	 * @author Vinay Singh
	 */
     public synchronized void navigateToReports() {
    	WebActionUtil.waitForThePresenceOfElement(5);
 		WebActionUtil.clickOnElement(iconReports, "Reports Icon ");
    	 
     }
     
     /**
      * Description: navigate to Account Menu 
      * @author Vinay Singh
      */
     public synchronized void navigateToAccountMenu() {
    	 WebActionUtil.waitForThePresenceOfElement(5);
  		WebActionUtil.clickOnElement(lnkAccountMenu, "Account Link ");
    	 
     }
}
