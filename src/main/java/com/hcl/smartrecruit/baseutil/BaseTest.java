package com.hcl.smartrecruit.baseutil;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentTest;
import com.hcl.smartrecruit.commonutils.ExcelUtil;
import com.hcl.smartrecruit.commonutils.FileOperations;
import com.hcl.smartrecruit.reports.ExtentHCLManager;
import com.hcl.smartrecruit.reports.ExtentHCLTest;
import com.hcl.smartrecruit.util.WebActionUtil;

/***********************************************************************
 * Description : Implements Application Precondition and Postcondition.
 * @author : Shreya U ,Vivek Dogra, Aatish Slathia
 * @BeforeSuite: Creates all the folder structure for Extent Reports
 * @BeforeClass : Launches the browser according to the browser name specified.
 * @AfterClass : Closes the browser after completion of execution 
 * @AfterSuite:  Kills the driver (example chromedriver.exe) according to browser specified.
 */

public class BaseTest {
	public  WebDriver driver;
	public Properties prop;
	public static final int ITO = 10;
	public static final int ETO = 10;
	public static String sDirPath = System.getProperty("user.dir");
	public static final String EXCELPATH = sDirPath + "./src/main/resources/data/SmartRecruitData.xlsx";
	public static Logger logger = LogManager.getLogger(BaseTest.class);
	public static WebActionUtil WebActionUtil;
	public String testCaseName;
	public DesiredCapabilities cap;
	public static final String LOCAL_HUB_URL = "http://localhost:4444/wd/hub";
	public static final String CONFIGPATH = sDirPath + "./conf/config.properties";
	public static Map<String, String> map = new LinkedHashMap<String,String>();
	public static String name="gupta.ami";
	public static ChromeOptions chromeOpt;
	public static final String URL = ExcelUtil.getCellData(EXCELPATH, "AppURL", 1, 0);
	public String username = ExcelUtil.getCellData(EXCELPATH, "SystemUserName", 1, 0);
	public int invocationcount=0;

	/**
	 * Description : Creates folder structure for Extent reports.
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
	 * Description: Launches  the browser as specified in the parameter
	 * @author:Shreya U,Vivek Dogra
	 * @param :browserName
	 */
	@Parameters({ "browserName" })
	@BeforeClass
	public synchronized void launchApp(String browserName) {
		ExtentTest parentExtentTest = ExtentHCLTest.createTest(getClass().getSimpleName());

		ExtentHCLManager.setParentReport(parentExtentTest);
		
		  
		 if (browserName.equalsIgnoreCase("firefox")) { 
			   cap.setBrowserName(BrowserType.FIREFOX);
				  
				  } else if (browserName.equalsIgnoreCase("edge")) { 
					  
					  /*Since Edge Options is not supported in Selenium 3.141.59 hence following
					   * lines are commented will be removed in Selenium 4 alpha and above version*/
//					
//				  cap.setBrowserName(BrowserType.EDGE);
					  //System.setProperty("webdriver.edge.driver", "./drivers/msedgedriver.exe");
					
//					EdgeOptions edgeOpt = new EdgeOptions(); 
					
//				        /*Static Path with User name as a variable
//						edgeOpt.addArguments(
//								"user-data-dir=" + "C:\\Users\\"+ username +"\\AppData\\Local\\Microsoft\\Edge\\User Data\\Default");
//						edgeOpt.addArguments("--start-maximized");
///
//						driver = new EdgeDriver();
//					  cap.setBrowserName(BrowserType.EDGE);
//					  
//                      cap.setPlatform(Platform.WINDOWS);
//                      edgeOpt.merge(cap);
// 					 try { 
// 						 driver = new RemoteWebDriver(new URL(LOCAL_HUB_URL),edgeOpt); } catch
// 					  (MalformedURLException e) {
// 					  
// 					 logger.info("The given HUB URL is not proper"); }
				  
				 } else if(browserName.equalsIgnoreCase("chrome")) { 
                  /*user-data-dir is the standard path for storing the user data and the name parameter is passed to
                   * to support portability*/
					 chromeOpt = new ChromeOptions(); 
					 chromeOpt.addArguments("user-data-dir=" +
					 "C:\\Users\\"+name+"\\AppData\\Local\\Google\\Chrome\\UserData"+ ++invocationcount);
					cap = new DesiredCapabilities();
					cap.setBrowserName(BrowserType.CHROME);
					chromeOpt.merge(cap);
				 
				 } try { 
						 driver = new RemoteWebDriver(new URL(LOCAL_HUB_URL),chromeOpt); } catch
					  (MalformedURLException e) {
					  
					 logger.info("The given HUB URL is Malformed"); 
					
				 
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.SECONDS);
		WebActionUtil = new WebActionUtil(driver, ETO);
		driver.manage().window().maximize();
		driver.get(URL);
						 }
	}

	/**
	 * Description: Closes  the browser
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
	 * @author:Shreya U              
	 * @param: methodName
	 */
	@BeforeMethod
	public synchronized void setExtentReport(Method methodName) {
		this.testCaseName = methodName.getName();
		ExtentTest testReport = ExtentHCLManager.getParentReport().createNode(testCaseName, "Description");
		ExtentHCLManager.setTestReport(testReport);
	}
}