package com.hcl.smartrecruit.baseutil;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverInitialization {
	
	private WebDriver driver = null;
	

	public  WebDriver getDriver() throws MalformedURLException{
		return driver =new RemoteWebDriver(new URL(BaseTest.URL),BaseTest.chromeOpt);
	}
}
