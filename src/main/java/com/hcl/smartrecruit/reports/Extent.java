package com.hcl.smartrecruit.reports;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.hcl.smartrecruit.commonutils.FileVariables;
import com.hcl.smartrecruit.util.WebActionUtil;

/**
 * Description: Implements the creation of the extent html report with specified name after loading the extent config file from specified location.
 * @author Shreya U,Vivek Dogra            
 */
public class Extent {
	
	private ExtentReports extent;
	FileVariables fileVariables = new FileVariables();
	/**
	 * Description Creates of HTML report in specified path
	 * @author shreya U, Vivek Dogra
	 */
	public  ExtentReports getExtent(String filepath) {

		if (extent == null) {
			try {
				extent = new ExtentReports();
				extent.attachReporter(getHtmlReporter(filepath+  " _Report.html"));
				return extent; 
			} catch (Exception e) {
				WebActionUtil.info("Exception while creating report html file.");
				
			}
		}
		return extent;
	}
	/**
	 * Description  Loads the extent-config file specified from the location
	 * @author Shreya U, Vivek Dogra
	 */
	private static ExtentHtmlReporter getHtmlReporter(String filePath) {
		
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(filePath);
		htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "/conf/extent-config.xml");
		return htmlReporter;
	}

}
