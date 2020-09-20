package com.hcl.smartrecruit.baseutil;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;

public class DriverInitialization {

	private WebDriver driver=null ;
	

	public  WebDriver getDriver(String URL,ChromeOptions chromeOpt) throws MalformedURLException{
		
		if (driver==null) {
			driver=new RemoteWebDriver(new URL(URL),chromeOpt);
		} 
		return driver;
	}
}

