package com.hcl.smartrecruit.util;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.hcl.smartrecruit.baseutil.BaseTest;
import com.hcl.smartrecruit.reports.ExtentHCLManager;

/**
 * Description: All the action utilities added in this class e.g
 * clickonelement,WaitforElement etc
 * 
 * @author : Shreya U ,Vivek Dogra,Aatish Slatia
 */

public class WebActionUtil {
	public WebDriver driver;
	WebDriverWait wait;
	public long ETO;
	public JavascriptExecutor jsExecutor;
	public Actions action;

	public WebActionUtil(WebDriver driver, long ETO) {
		this.driver = driver;
		this.ETO = ETO;
		wait = new WebDriverWait(driver, ETO);
		jsExecutor = (JavascriptExecutor) driver;
		action = new Actions(driver);
	}

	/**
	 * Description : Method for the pass updation in extent Report,Log file,TestNG
	 * Report
	 * 
	 * @author Shreya U
	 * @param message
	 */

	public static void pass(String message) {
		ExtentHCLManager.getTestReport().pass(MarkupHelper.createLabel(message, ExtentColor.GREEN));
	}

	/**
	 * Description: Method to provide info in the log,extent reports,testNg reports
	 * 
	 * @author Shreya U
	 * @param message
	 */
	public static void info(String message) {
		Reporter.log(message, true);
		BaseTest.logger.info(message);
		ExtentHCLManager.getTestReport().info(message);

	}

	/**
	 * Description Method for the Warning updation in extent Report,Log file,TestNG
	 * Report
	 * 
	 * @author Shreya U
	 * @param message
	 * 
	 */

	public void warn(String message) {
		BaseTest.logger.warn(message);
		Reporter.log(message, true);
	}

	/**
	 * DescriptionMethod for the failure updation in extent eport,Log file,TestNG
	 * Report
	 * 
	 * @author Shreya U
	 * @param message
	 */

	public static void fail(String message) {
		Reporter.log(message, true);
		ExtentHCLManager.getTestReport().fail(MarkupHelper.createLabel(message, ExtentColor.RED));

	}

	/**
	 * Description : Method implements error updation in extent Report,Log
	 * file,TestNg Report
	 * 
	 * @author Shreya U
	 * 
	 */
	public void error(String message) {

		BaseTest.logger.error(message);
		Reporter.log(message, true);
		ExtentHCLManager.getTestReport().error(message);
	}

	/**
	 * Description: Method for the error updation in extent Report,Log file,TestNg
	 * Report
	 * 
	 * @author Shreya U
	 * 
	 */

	public static String getCurrentDateTime() {
		DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate = new Date();
		return customFormat.format(currentDate);
	}

	/**
	 * Description : Click on the web element
	 * 
	 * @author Shreya U
	 * @param element
	 * @param elementName
	 * @param message
	 */
	public synchronized void clickOnWebElement(WebElement element, String elementName, String message) {

		if (isElementClickable(element, elementName)) {
			element.click();
			pass("Click on " + elementName);
		} else {
			fail(message);
			Assert.assertTrue(wait.until(ExpectedConditions.elementToBeClickable(element)) == null);
		}
	}

	/**
	 * Description: This methods implements to check whether the Element is
	 * displayed with expected conditions.
	 * 
	 * @author Shreya U
	 * @param element
	 * @param elementName
	 */
	public synchronized boolean isElementClickable(WebElement element, String elementName) {

		info("Verify " + elementName + " is Clickable or Not");
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			return true;
		} catch (Exception e) {
			fail(elementName + " is not Clickable ");
			return false;
		}
	}

	/**
	 * Description :This method  Implements Wait for a element to be visible
	 * 
	 * @author Shreya U
	 * @param element
	 * @param elementName
	 * @param seconds
	 */
	public void waitForElement(WebElement element, String eleName, long seconds) {
		try {

			wait = new WebDriverWait(driver, seconds);
			wait.until(ExpectedConditions.visibilityOf(element));
			Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(element)) != null);

		} catch (Exception e) {
			fail("Element is not visible---------" + eleName);

		}
	}

	/**
	 * Description : Deletes a previously existing directory
	 * 
	 * @author Shreya U
	 * @param pathToDeleteFolder
	 */
	public static void deleteDir(String pathToDeleteFolder) {
		File extefolder = new File(pathToDeleteFolder);
		if ((extefolder.exists())) {
			deleteFolderDir(extefolder);
		}
	}

	/**
	 * Description : This method implements to delete the folder directory.
	 * 
	 * @author Shreya U
	 * @param folderToDelete
	 */
	public static void deleteFolderDir(File folderToDelete) {
		File[] folderContents = folderToDelete.listFiles();
		if (folderContents != null) {
			for (File folderfile : folderContents) {
				if (!Files.isSymbolicLink(folderfile.toPath())) {
					deleteFolderDir(folderfile);
				}
			}

		}
		folderToDelete.delete();
	}

	/**
	 * Description Captures the screenshot of the complete screen
	 * 
	 * @author Shreya U
	 * @param path
	 * @param driver
	 */
	public static String getScreenShot(String path, WebDriver driver) {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationPath = path + getCurrentDateTime() + ".png";
		File destination = new File(destinationPath);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return destinationPath;
	}

	/**
	 * Description  Enters the Text to the Text field
	 * 
	 * @author Shreya U
	 * @param element
	 * @param value
	 * @param elementName
	 */
	public static synchronized void typeText(WebElement element, String value, String elementName) {
		try {
			info("Enter the value into " + elementName);
			element.sendKeys(value);
			pass("User is able to type " + value + " into " + elementName);
		} catch (AssertionError error) {
			fail(" User is not able to type " + value + " into " + elementName);
			Assert.fail("Unable to type on " + elementName);
		} catch (Exception e) {
			fail(" User is not able to type " + value + "into " + elementName);
			Assert.fail("Unable to type in " + elementName);
		}
	}

	/**
	 * Description :Selects the value by the Visible Text
	 * 
	 * @author Shreya U
	 * @param element
	 * @param value
	 * @param elementName
	 */
	public static synchronized void selectByText(WebElement element, String value) {
		try {
			info("Select the value " + value);
			Select selecvalue = new Select(element);
			selecvalue.selectByVisibleText(value);
			pass("User is able to select the value" + value);
		} catch (Exception e) {
			fail(" User is not able to Select" + value);
			Assert.fail("Unable to select  " + value);
		}

	}

	/**
	 * Description: Clicks on the check box
	 * 
	 * @author Shreya U
	 * @param element
	 * @param elementName
	 */
	public static void clickCheckBox(WebElement element, String elementname) {

		if (element.isSelected()) {
			pass("Already Selected " + elementname);
		} else {
			element.click();
			pass("Selected the " + elementname);

		}
	}

	/**
	 * Description :Scrolls to the Element
	 * 
	 * @author Shreya U
	 * @param elementName
	 * @param element
	 */
	public void scrollToElement(WebElement element, String elementName) {
		info("-------------Scrolling till the Element------------");
		try {
			jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
			pass("-------------Scrolling till the Element Completed------------");
		} catch (Exception e) {
			fail("-------------Scroll Till the Element Has Failed ------------");
		}

	}

	/**
	 * Description Clicks on the Element using JavaSCript
	 * 
	 * @author Shreya U
	 * @param element
	 * @param elementName
	 */
	public void clickOnElementUsingJS(WebElement element, String elementName) {
		try {
			if (isElementClickable(element, elementName)) {
				pass("User is able to click " + " into " + elementName);
				jsExecutor.executeScript("arguments[0].click();", element);
			}
		} catch (NoSuchElementException e) {
			pass("User is not able to click " + " into " + elementName);
			Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(element)) == null);
		}
	}

	/**
	 * Description :Double Clicks On Element
	 * 
	 * @author Shreya U
	 * @param element
	 * @param elementName
	 */
	public void doubleClickOnElement(WebElement element, String elementName) {
		try {
			pass("User is able to click " + " into " + elementName);
			action.doubleClick(element).perform();
		} catch (Exception e) {
			fail(" User is not able to double click on  " + elementName);
			Assert.fail("Unable to Double click on  " + elementName);
		}
	}

	/**
	 * ' Description :Clears the Text present in the text field.
	 * 
	 * @author Shreya U
	 * @param element
	 * @param elementName
	 */
	public void clearText(WebElement element, String elementName) {
		try {
			info("Clear the Text Present in" + elementName);
			element.clear();
			pass("Cleared the Text Present in" + elementName);
		} catch (Exception e) {
			fail("Unable to clear the text in " + elementName);
		}
	}

	/**
	 * Description To create the duration of the Test Run
	 * 
	 * @author Aatish Slathia
	 * @param millis
	 */
	public static String formatDuration(final long millis) {
		long seconds = (millis / 1000) % 60;
		long minutes = (millis / (1000 * 60)) % 60;
		long hours = millis / (1000 * 60 * 60);

		StringBuilder b = new StringBuilder();
		b.append(hours == 0 ? "00" : hours < 10 ? String.valueOf("0" + hours) : String.valueOf(hours));
		b.append(":");
		b.append(minutes == 0 ? "00" : minutes < 10 ? String.valueOf("0" + minutes) : String.valueOf(minutes));
		b.append(":");
		b.append(seconds == 0 ? "00" : seconds < 10 ? String.valueOf("0" + seconds) : String.valueOf(seconds));
		return b.toString();
	}

	/**
	 * Description Waits for an element
	 * 
	 * @author Aatish Slathia
	 * @param element
	 * @param driver
	 * @param elementName
	 */
	public void waitForElement(WebElement element, WebDriver driver, String elementName) {
		waitTillPageLoad(10);
		long timeout = 60;
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeout))
				.pollingEvery(Duration.ofMillis(250)).ignoring(NoSuchElementException.class);

	}

	/**
	 * Description Highlights the validation points on the extent report
	 * 
	 * @author Aatish Slathia
	 * @param message
	 * 
	 */
	public void validationpass(String message) {
		ExtentHCLManager.getTestReport().pass(MarkupHelper.createLabel(message, ExtentColor.BLUE));

	}

	/**
	 * Description :Checks whether an element is visible
	 * 
	 * @author Aatish Slathia
	 * @param element
	 * @param elementName
	 * 
	 */
	public boolean isElementVisible(WebElement element, String elemantName) {

		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			validationpass(elemantName + " is Visible ");
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Description : Mouse over an element
	 * 
	 * @author Aatish Slathia
	 * @param element
	 * @param elementName
	 */
	public void actionMouseHover(WebElement element, String elementName) {
		waitTillPageLoad(2);
		if (isElementVisible(element, elementName)) {
			action.moveToElement(element).build().perform();
			pass("MouseHover Action completed ");
		} else {
			fail("Mouse Hover is not completed");
			Assert.fail("MouseHover is not Completed");
		}
	}

	/**
	 * Description:Presses Tab using action class
	 * 
	 * @author Aatish Slathia
	 */

	public void actionType() {
		try {
			action.sendKeys(Keys.TAB).build().perform();
			pass("Tab Press action completed");
		} catch (Exception e) {
			Assert.fail("Unable to press Tab");
		}

	}

	/**Description :Clicks on the ement 
	 * @author Aatish Slathia
	 * @param element
	 * @param  elementName
	 */
	public void clickOnElement(WebElement element, String elementName) {

		try {
			info("Clicking on  " + elementName);
			if (isElementClickable(element, elementName)) {
				waitForElement1(element, "wait for " + elementName, 120);
				element.click();
				pass("Clicked on  " + elementName);
			}
		} catch (Exception e) {
			fail("Unable to click on " + elementName);
		}

	}

	/**
	 * Description Switches to tab
	 * 
	 * @author Aatish Slathia
	 * @param tabindex
	 * 
	 */
	public void switchToTab(int tabindex) {
		try {
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(tabindex));
			pass("Switch to tab complete");
		} catch (Exception e) {
			fail("Switching to tab failed ");

		}

	}

	/**
	 * Description Close the Tab
	 * 
	 * @author Aatish Slathia
	 */
	public void closeTab() {
		try {
			driver.close();
			pass("Closed current Tab");
		} catch (Exception e) {
			fail("Closing current tab failed");

		}

	}

	/**
	 * Description :Presses  tab key with Robot class 
	 * 
	 * @author Aatish Slathia
	 */
	public void clickOntabButton() {
		try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);
			pass("Pressed the Tab Key");
		} catch (Exception e) {
			fail("Unable to press tab");
		}

	}

	/**
	 * Description Scrolls down the page
	 * 
	 * @author Aatish Slathia
	 * @param element
	 * @param elementName
	 */
	public void clickElementByUsingJS(WebElement element, String elementName) {
		try {
			pass("User is able to click" + " into " + elementName);
			jsExecutor.executeScript("arguments[0].click();", element);
		} catch (NoSuchElementException e) {
			pass("User is not able to click" + " into " + elementName);
			Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(element)) == null);
		}
	}

	/**
	 * Description: This method to scroll the page upward 25%
	 * 
	 * @author Aatish Slathia
	 * @param driver
	 */

	public void scrollUp(WebDriver driver) {
		try {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,-500", "");
			pass("Scrolling  Up in the page is completed");
		} catch (Exception e) {
			fail("Failed to Scroll Up in the page");
		}

	}

	/**
	 * Description Scrolls down the page
	 * 
	 * @author Aatish Slathia
	 * @param driver
	 */
	public void scrollDown(WebDriver driver) {
		try {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,500", "");
			pass("Scrolling  Down in the page is completed");
		} catch (Exception e) {
			fail("Failed to Scroll Down in the page");
		}

	}

	/**
	 * Description Verify the Element Text
	 * 
	 * @author Aatish Slathia
	 * @param element
	 * @param expectedText
	 */
	public void verifyElementText(WebElement element, String expectedText) {
		String actualText = element.getText();
		try {
			Assert.assertEquals(actualText, expectedText);
			validationpass(actualText + " text is matching with " + expectedText + " text in the Application");
		} catch (Exception e) {
			fail(actualText + " text is not matching with " + expectedText + " text in the Application");
			Assert.fail(actualText + " is not matching with " + expectedText);
		}
	}

	/**
	 * Description : Checks whether Element Displayed Or Not
	 * 
	 * @author Aatish Slathia
	 * @param element
	 */
	public boolean isElementDisplayedOrNot(WebElement element) {
		waitForThePresenceOfElement(3);
		boolean actual = element.isDisplayed();
		// Assert.assertEquals(actual, true, "Element is Not Displayed");
		return actual;
	}

	/**
	 * Description :Waits for an element
	 * @author Aatish Slathia
	 * @param seconds
	 */
	public void waitForThePresenceOfElement(long seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Description Selects Drop Down
	 * 
	 * @author Aatish Slathia
	 * @param element
	 * @param value
	 * @param elementName
	 */
	public void selectDropDown(WebElement element, String value, String elementName) {
		try {
			if (isElementVisible(element, elementName)) {
				Select drpDown = new Select(element);
				drpDown.selectByVisibleText(value);
				pass("Successfully Select the Value" + elementName);
			}
		} catch (Exception e) {
			fail("Unable to Select the Value" + elementName);
			Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(element)) == null);
		}
	}

	/**
	 * Description: Waits for the Page Title
	 * 
	 * @author Aatish Slathia
	 * @param seconds
	 * @param ePageTitle
	 */
	@SuppressWarnings("deprecation")
	public void waitForThePageTitle(long seconds, String ePageTitle) {
		try {
			wait = new WebDriverWait(driver, seconds);
			wait.until(ExpectedConditions.titleContains(ePageTitle));
			pass("Waited for the Page Title" + ePageTitle);
		} catch (Exception e) {
			fail("Unable to Wait for the page according to the specified Title ");
		}
	}

	/**
	 * Description :Waits for the Page To Load using the Expected Conditions
	 * 
	 * @author Aatish Slathia
	 * @param seconds
	 */
	@SuppressWarnings("deprecation")
	public void waitTillPageLoad(long seconds) {
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		jsExecutor = (JavascriptExecutor) driver;
		// Wait for Javascript to load
		ExpectedCondition<Boolean> jsLoad = wd -> ((JavascriptExecutor) driver)
				.executeScript("return document.readyState").toString().equals("complete");
		// Get JS is Ready
		boolean jsReady = (Boolean) jsExecutor.executeScript("return document.readyState").toString()
				.equals("complete");
		// Wait Javascript until it is Ready!
		if (!jsReady) {
			System.out.println("JS in NOT Ready!");
			// Wait for Javascript to load
			wait.until(jsLoad);
		} else {
			waitForThePresenceOfElement(2);
		}
	}

	/**
	 * Description Wait for an element
	 * 
	 * @author Aatish Slathia
	 * @param seconds
	 * @param element
	 * @param eleName
	 */
	@SuppressWarnings("deprecation")
	public void waitForElement1(WebElement element, String eleName, long seconds) {
		try {
			wait = new WebDriverWait(driver, seconds);
			wait.until(ExpectedConditions.visibilityOf(element));
			Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(element)) != null);
		} catch (Exception e) {
			fail("Element is not visible");
		}
	}

	/**
	 * Description Checks for the Alert
	 * 
	 * @author Aatish Slathia
	 * @param seconds
	 */
	public void checkForAlert(long seconds) {
		try {
			wait = new WebDriverWait(driver, seconds);

			wait.until(ExpectedConditions.alertIsPresent());
		} catch (Exception e) {
			fail("Alert is not Present");
		}
	}

	/**
	 * Description: Accepts an  alert
	 * 
	 * @author Aatish Slathia
	 */
	public void acceptAlert() {
		try {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			fail("Failed to switch the tab");
		}

	}

	/**
	 * Description Switches the Tab
	 * 
	 * @author Aatish Slathia
	 * @param tabindex
	 */
	public void switchToTabAndClose(int tabindex) {
		try {
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(tabindex));
			driver.quit();
			pass("Switch to tab complete");
		} catch (Exception e) {
			fail("Switching to tab is failed ");

		}
	}

	/**
	 * Description Gets text of requisition
	 * 
	 * @author Aatish Slathia
	 * @return text
	 */
	public String getText() {
		String alert = driver.switchTo().alert().getText();
		String text = alert.substring(alert.indexOf("BTIS"), alert.indexOf("."));
		return text;

	}

	/**
	 * Description Get approve ID Text
	 * 
	 * @author Aatish Slathia
	 * @param element
	 * @return text2
	 */
	public String getApproverIdText(WebElement element) {
		String text1 = element.getText();
		String text = text1.substring(text1.indexOf("["), text1.indexOf("]"));
		String text2 = text.replace("[", " ").trim();
		return text2;

	}

	/**
	 * Description :Navigates to the URL specified
	 * 
	 * @author Aatish Slathia
	 * @param path
	 */
	public void navigateToUrl(String value) {
		info("Navigating to the URL");
		try {
			driver.navigate().to(value);
		} catch (Exception e) {
			fail("Unable to navigate to URL provided");
		}

	}

	/**
	 * Description :Gets the approver Id
	 * 
	 * @author Aatish Slathia
	 * @param element
	 * @return text2
	 */
	public String getApproverIdTextOfApprovers(WebElement element) {
		String text1 = element.getText();
		String text = text1.substring(text1.indexOf("("), text1.indexOf(")"));
		String text2 = text.replace("(", " ").trim();
		return text2;

	}

	/**
	 * Description Verifies  the Text
	 * 
	 * @author Aatish Slathia
	 * @param expected
	 * @param element
	 * @param elementname
	 */
	public void verifytext(String expected, WebElement element, String elementname) {
		try {
			info("Getting text from " + elementname);
			String actual = element.getText();
			Assert.assertEquals(actual, expected);
		} catch (Exception e) {
			fail("Failed to fetch the text from " + elementname);
		}

	}

	/**
	 * Description :Click on element using js
	 * 
	 * @author Aatish Slathia
	 * 
	 */
	public void clickByJs(WebElement element, String elementName) {
		info("Click on Element " + elementName);
		try {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].click();", element);
			pass("Clicked on Element " + elementName);
		} catch (Exception e) {
			fail("Unable to Click on Element " + elementName);
		}

	}

	/**
	 * Description :Gets Text from Alert
	 * 
	 * @author Aatish Slathia
	 */
	public String getAlertText() {
		info("Fetching the Text from the Alert");
		String text = "";
		try {
			text = driver.switchTo().alert().getText();
			pass("Alert Text is fetched");
		} catch (Exception e) {
			fail("Unable to fetch the Text from the Alert");
		}
		return text;
	}

	/**
	 * Description Keys to close the tab
	 * 
	 * @author Aatish Slathia
	 * 
	 */
	public void actionSendKeys() {
		try {
			action.sendKeys(Keys.CONTROL, Keys.getKeyFromUnicode((char) 87));
			pass("Entered the keys control and w ");
		} catch (Exception e) {
			fail("Failed to enter contrl and w ");
		}

	}

	/**
	 * Description Clicks on element using action class
	 * 
	 * @author Aatish Slathia
	 * @param element
	 * @param elementName
	 * 
	 */
	public void actionClick(WebElement element, String elementName) {
		try {
			action.click(element).build().perform();
			pass("Clicked on " + elementName);
		} catch (Exception e) {
			fail("Unable to click on " + elementName);

		}

	}

}
