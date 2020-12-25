package com.cropin.baseutil;

import java.awt.AWTException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentTest;
import com.cropin.commonutils.ExcelUtil;
import com.cropin.commonutils.FileOperations;
import com.cropin.reports.ExtentCropinManager;
import com.cropin.reports.ExtentCropinTest;
import com.cropin.util.WebActionUtil;

/***********************************************************************
 * Description : Implements Application Precondition and Postcondition.
 * 
 * @author : Shreya U ,Vivek Dogra, Aatish Slathia
 * @BeforeSuite: Creates all the folder structure for Extent Reports
 * @BeforeClass : Launches the browser according to the browser name specified.
 * @AfterClass : Closes the browser after completion of execution
 * @AfterSuite: Kills the driver (example chromedriver.exe) according to browser
 *              specified.
 */

    public class BaseTest {
	public static WebDriver driver;
	public Properties prop;
	public static final int ITO = 10;
	public static final int ETO = 10;
	public static String sDirPath = System.getProperty("user.dir");
	public static final String EXCELPATH = sDirPath + "./src/main/resources/data/cropinData.xlsx";
	public static Logger logger = LogManager.getLogger(BaseTest.class);
	public static WebActionUtil WebActionUtil;
	public String testCaseName;
	public static final String CONFIGPATH = sDirPath + "./conf/config.properties";
	public static final String URL = ExcelUtil.getCellData(EXCELPATH, "SystemData", 1, 0);
	public String companyDomain = ExcelUtil.getCellData(EXCELPATH, "SystemData", 1, 1);
	public String userName = ExcelUtil.getCellData(EXCELPATH, "SystemData", 1, 2);
	public String password = ExcelUtil.getCellData(EXCELPATH, "SystemData", 1, 3);
	public int invocationcount = 1;

	/**
	 * Description : Creates folder structure for Extent reports.
	 * 
	 * @author:Shreya U
	 */
	@BeforeSuite(alwaysRun = true)
	public synchronized void createFiles() {
		try {
			logger.info("Folder creation for Extent");
			FileOperations fileOperation = new FileOperations();
			fileOperation.createFiles();
		} catch (Exception e) {
			logger.info("Exception while report inititation");
		}

	}

	/**
	 * Description: Launches the browser as specified in the parameter
	 * 
	 * @author:Shreya U,Vivek Dogra
	 * @param :browserName
	 * @throws AWTException 
	 */
	@Parameters({"browserName"})
	@BeforeClass
	public synchronized void launchApp(String browserName) throws AWTException {
		ExtentTest parentExtentTest = ExtentCropinTest.createTest(getClass().getSimpleName());

		ExtentCropinManager.setParentReport(parentExtentTest);
		
		  
		 if (browserName.equalsIgnoreCase("chrome")) { 
			 System.out.println("Chrome Browser is opening..... ");
				
				System.setProperty("webdriver.chrome.driver",sDirPath + "./drivers/chromedriver.exe");
								
				driver= new ChromeDriver();
							
				}else if(browserName.equalsIgnoreCase("firefox"))
							
				{
								
				System.out.println("Firefox Browser is opening..... ");
								
				System.setProperty("webdriver.gecko.driver", sDirPath+"./drivers/geckodriver.exe");
								
				driver= new FirefoxDriver();
							
				}
							
				
							
			driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.SECONDS);
			WebActionUtil = new WebActionUtil(driver, ETO);
			driver.manage().window().maximize();
			driver.get(URL);
							 }
					  


	/**
	 * Description: Closes the browser
	 * 
	 * @author:Shreya U
	 */
	@AfterClass
	public synchronized void closeBrowser() {

		try {
			if (driver != null) {

				driver.quit();

			} else {
				logger.info("Unable to close the driver");
			}
		} catch (Exception e) {

		}

	}

	/**
	 * Description: Kills the driver in Task Manager as specified in the parameter.
	 * 
	 * @author:Shreya U
	 * @param :browserName
	 */
	@AfterSuite
	@Parameters({ "browserName" })
	public synchronized void killTask(String browserName) {
		try {
			if (browserName.equalsIgnoreCase("chrome")) {
				Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
			} else if (browserName.equalsIgnoreCase("firefox")) {

				Runtime.getRuntime().exec("taskkill /IM firefox.exe /F");
			} else if (browserName.equalsIgnoreCase("edge")) {

				Runtime.getRuntime().exec("taskkill /F /IM MicrosoftEdgeCP.exe");
			} else {
				logger.info("Browser Name Not specified properly to kil the Task");
			}

		} catch (IOException e) {

		}
	}

	/**
	 * Description: Creates nodes for the test methods in Extent report.
	 * 
	 * @author:Shreya U
	 * @param: methodName
	 */
	@BeforeMethod
	public synchronized void setExtentReport(Method methodName) {
		this.testCaseName = methodName.getName();
		ExtentTest testReport = ExtentCropinManager.getParentReport().createNode(testCaseName, "Description");
		ExtentCropinManager.setTestReport(testReport);
	}
}