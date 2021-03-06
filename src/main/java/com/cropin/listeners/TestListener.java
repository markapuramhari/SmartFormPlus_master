package com.cropin.listeners;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.cropin.baseutil.BaseTest;
import com.cropin.reports.ExtentCropinManager;
import com.cropin.reports.ExtentCropinTest;
import com.cropin.util.WebActionUtil;


/**
 * Description: This class implements ITestListener and overrides methods like
 * onFinish, onTestFailure,onTestSkipped,onTestSuccess which are used in Extent
 * report and Emailable report.
 * 
 * @author Vinay
 * 
 */
public class TestListener implements ITestListener {
	public static ArrayList sTestName = new ArrayList<String>();
	public static ArrayList sStatus = new ArrayList<String>();
	public static Properties prop;
	public static int iPassCount = 0;
	public static int iFailCount = 0;
	public static int iSkippedCount = 0;
	public static String profile = null;
	public static long totPassedTime = 0;
	public static long totFailedTime = 0;
	public static long totSkippedTime = 0;
	public static long totalTimeTaken = 0;
	public static String pass_Time = "0";
	public static String fail_Time = "0";
	public static String skip_Time = "0";
	public static String tot_Time = "0";
	public static String sDirPath = System.getProperty("user.dir");
	public static final String PDFREPORTPATH = sDirPath + "./docs" + ".pdf";
	public static final String CONFIGPATH = sDirPath + "./conf/config.properties";
	BaseTest basetest =new BaseTest();
	static {
		BaseTest.logger.info("");
		profile = System.getProperty("profile");
		profile = "Cropin ";
		System.setProperty("profile", profile);
		BaseTest.logger.info("Running locally " + profile);
	}

	static Map<String, String> reportMailBody = new HashMap<String, String>();
	File pdfReports = new File(PDFREPORTPATH);

	/**
	 * Description :Flushes the Extent report and sends an email of the report.
	 * 
	 * @author Aatish Slathia,shreya Ugavekar
	 * @paran context
	 * 
	 */
	public void onFinish(ITestContext context) {
		iPassCount = context.getPassedTests().size();
		iFailCount = context.getFailedTests().size();
		iSkippedCount = context.getSkippedTests().size();
		int iTotal_Executed = iPassCount + iFailCount + iSkippedCount;
		totalTimeTaken = totPassedTime + totFailedTime + totSkippedTime;
		tot_Time = WebActionUtil.formatDuration(totalTimeTaken);
		/* Its not working in HCL environment will be implemented in the future */
		// sendMail(iPassCount, iFailCount, iSkippedCount, iTotal_Executed, pdfReports,
		// profile);
		ExtentCropinTest.getExtent().flush();

	}

	public void onStart(ITestContext context) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	/**
	 * Description :Increases the fail count and add fail result in Extent
	 * report,adds screenshots to the  Extent report on Test case failure.
	 * 
	 * @author Aatish Slathia,shreya Ugavekar
	 * @param result
	 * 
	 */
	public void onTestFailure(ITestResult result) {
		iFailCount = iFailCount + 1;
		setStatus(result.getTestClass().getRealClass().getSimpleName().toString(),
				result.getThrowable().getLocalizedMessage(), sTestName, sStatus);
		for (int i = 0; i < sTestName.size(); i++) {
			String s1 = (String) sTestName.get(i);
			String s2 = (String) sStatus.get(i);
			reportMailBody.put(s1, s2);
		}
		long scriptTime = result.getEndMillis() - result.getStartMillis();
		totFailedTime = totFailedTime + scriptTime;
		fail_Time = WebActionUtil.formatDuration(totFailedTime);
		ExtentCropinManager.getTestReport().log(Status.FAIL, result.getMethod().getMethodName() + "-Test case failed");
		try {
			ExtentCropinManager.getTestReport().addScreenCaptureFromPath(
					WebActionUtil.getScreenShot(System.getProperty("user.dir") + "/reports" + "/ScreenShots-"
							+ WebActionUtil.getCurrentDateTime() + "/Cropin_screenshots/", BaseTest.driver));
		} catch (IOException e) {
			BaseTest.logger.error("Unable to attach the screenshot");
		}

	}

	/**
	 * Description :Increases the skip count and adds the skip result in Extent report.
	 * 
	 * @author Aatish Slathia,shreya Ugavekar
	 * @param result
	 * 
	 */
	public void onTestSkipped(ITestResult result) {
		iSkippedCount = iSkippedCount + 1;
		setStatus(result.getTestClass().getRealClass().getSimpleName().toString(),
				result.getThrowable().getLocalizedMessage(), sTestName, sStatus);
		for (int i = 0; i < sTestName.size(); i++) {
			String s1 = (String) sTestName.get(i);
			String s2 = (String) sStatus.get(i);
			reportMailBody.put(s1, s2);
		}
		long scriptTime = result.getEndMillis() - result.getStartMillis();
		totSkippedTime = totSkippedTime + scriptTime;
		skip_Time = WebActionUtil.formatDuration(totSkippedTime);
		ExtentCropinManager.getTestReport().log(Status.SKIP, result.getMethod().getMethodName() + "-Test case Skipped");

	}

	public void onTestStart(ITestResult result) {

	}

	/**
	 * Description:Increases the pass count and adds the pass result in Extent report
	 * 
	 * @author Aatish Slathia,shreya Ugavekar
	 * @param result
	 * 
	 */
	public void onTestSuccess(ITestResult result) {
		iPassCount = iPassCount + 1;
		setStatus(result.getName().toString(), "Passed", sTestName, sStatus);
		for (int i = 0; i < sTestName.size(); i++) {
			String s1 = (String) sTestName.get(i);
			String s2 = (String) sStatus.get(i);
			reportMailBody.put(s1, s2);
		}
		long scriptTime = result.getEndMillis() - result.getStartMillis();
		totPassedTime = totPassedTime + scriptTime;
		pass_Time = WebActionUtil.formatDuration(totPassedTime);
		ExtentCropinManager.getTestReport().log(Status.PASS, result.getMethod().getMethodName() + "-Test case passed");
	}

	/**
	 * Description :Sends email of the test execution as a report to the recipient specified in
	 * the property file.
	 * 
	 * @author Aatish Slathia
	 * @param iPassCount
	 * @param iFailCount
	 * @param skippedCount
	 * @param iTotal_Executed profile
	 */
	public static void sendMail(int iPassCount, int iFailCount, int skippedCount, int iTotal_Executed, File pdfReports,
			String profile) {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(CONFIGPATH);
			prop.load(fis);

		} catch (Exception e) {
			e.printStackTrace();
		}
		final String InternetAddress = prop.getProperty("InternetAddress");
		final String PasswordAuthentication = prop.getProperty("PasswordAuthentication");
		String RecipientType = prop.getProperty("RecipientType");
		String RecipientType2 = prop.getProperty("RecipientType2");
		//String SmtpUser = prop.getProperty("SmtpUser");
		//String SmtpHost = prop.getProperty("SmtpHost");

		Properties props = new Properties();
		BaseTest.logger.info("Executing sendMail method");
		Date date = new Date();
		SimpleDateFormat sdtf = new SimpleDateFormat("dd-MM-yyyy_hh_mm_ss");
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String sdate = sdf.format(date);
		String message = "<p>Hi Team,</p><div style=\"font-family:Verdana;\">Please check the Test script execution summary of "
				+ profile + " as shown in below table. </div><p></p><p></p><p></p><p></p>"
				+ "<p><div style=\"font-family:Verdana;\"><b> EXECUTION SUMMARY : </b></div></p>"
				+ "<table bgcolor=\"#f2d285\" style=\"border-radius: 20px; padding: 25px;\"><tr><td>&nbsp;&nbsp;&nbsp;<table style=\"height:180px; width:200px; border-width:2px; border-style:groove; float: left\"><tbody>"
				+ "<tr style=\"outline: thin solid; font-family:Verdana; color: #000000; text-align: left; border-width:2px; \"><th style=\"outline: thin solid;\">Total Executed</th><td style=\"outline: thin solid; font-weight: bold;\">&nbsp;&nbsp;"
				+ iTotal_Executed
				+ "&nbsp;&nbsp;</td><td style=\"outline: thin solid; font-weight: bold;\">&nbsp;&nbsp;"
				+ "&nbsp;&nbsp;</td></tr>"
				+ "<tr style=\"outline: thin solid;  font-family:Verdana; color: #000000; text-align: left; border-width:2px; \"><th style=\"outline: thin solid;\">Passed</th><td style=\"outline: thin solid; font-weight: bold;\">&nbsp;&nbsp;"
				+ iPassCount + "&nbsp;&nbsp;</td><td style=\"outline: thin solid; font-weight: bold;\">&nbsp;&nbsp;"
				+ "&nbsp;&nbsp;</td></tr>"
				+ "<tr style=\"outline: thin solid; font-family:Verdana; color: #000000; text-align: left; border-width:2px; \"><th style=\"outline: thin solid;\">Failed</th><td style=\"color: Red; outline: thin solid; font-weight: bold;\">&nbsp;&nbsp;"
				+ iFailCount + "&nbsp;&nbsp;</td><td style=\"outline: thin solid; font-weight: bold;\">&nbsp;&nbsp;"
				+ "&nbsp;&nbsp;</td></tr>"
				+ "<tr style=\"outline: thin solid; font-family:Verdana; color: #000000; text-align: left; border-width:2px; \"><th style=\"outline: thin solid;\">Skipped</th><td style=\"color: Red; outline: thin solid; font-weight: bold;\">&nbsp;&nbsp;"
				+ iSkippedCount + "&nbsp;&nbsp;</td><td style=\"outline: thin solid; font-weight: bold;\">&nbsp;&nbsp;"
				+ "&nbsp;&nbsp;</td></tr>";

		message = message
				+ "<table bgcolor=\"#f2d285\" style=\"border-radius: 20px; padding: 25px;\"><tr><td><table style=\"width:800px; border-width:2px; border-style:groove; float: left\"><tbody>"
				+ "<tr style=\"outline: thin solid;  font-family:Verdana; color: #000000; text-align: left; border-width:2px; \"><th style=\"outline: thin solid;\">Time Taken For Passed Script</th><td style=\"outline: thin solid; font-weight: bold;\">&nbsp;&nbsp;"
				+ pass_Time + "&nbsp;&nbsp;</td></tr>"
				+ "<tr style=\"outline: thin solid; font-family:Verdana; color: #000000; text-align: left; border-width:2px; \"><th style=\"outline: thin solid;\">Time Taken For Failed Script</th><td style=\"color: Red; outline: thin solid; font-weight: bold;\">&nbsp;&nbsp;"
				+ fail_Time + "&nbsp;&nbsp;</td></tr>"
				+ "<tr style=\"outline: thin solid; font-family:Verdana; color: #000000; text-align: left; border-width:2px; \"><th style=\"outline: thin solid;\">Time Taken For Skipped Script</th><td style=\"outline: thin solid; font-weight: bold;\">&nbsp;&nbsp;"
				+ skip_Time + "&nbsp;&nbsp;</td></tr>" + "</tbody></table></td>"
				+ "<tr style=\"outline: thin solid; font-family:Verdana; color: #000000; text-align: left; border-width:2px; \"><th style=\"outline: thin solid;\">Total Time Taken For Suite Execution</th><td style=\"outline: thin solid; font-weight: bold;\">&nbsp;&nbsp;"
				+ tot_Time + "&nbsp;&nbsp;</td></tr>" + "</tbody></table></td>" + "&nbsp;&nbsp;&nbsp;";

		message = message
				+ "<table bgcolor=\"#f2d285\" style=\"border-radius: 20px; padding: 25px;\"><tr><td><table style=\"width:800px; border-width:2px; border-style:groove; float: left\"><tbody>"
				+ "<tr style=\"outline: thin solid; font-family:Verdana; color: #000000; text-align: left; border-width:2px; width:400px; \"><th style=\"outline: thin solid;\">Test Case</th>"
				+ "<th style=\"outline: thin solid; width:400px; \">Reason for failure</th></tr>";
		for (@SuppressWarnings("rawtypes")
		Map.Entry entry : reportMailBody.entrySet()) {
			BaseTest.logger.info(entry.getKey() + " :" + entry.getValue());
			message = message
					+ "<tr style=\"outline: thin solid; font-family:Verdana; color: #000000; text-align: left; border-width:2px; width:400px; \">"
					+ "<td style=\"outline: thin solid; width:2px; border-style:groove; float: left  width:400px; \">"
					+ entry.getKey()
					+ "</td> <td style=\"outline: thin solid; width:2px; border-style:groove; float: left  width:600px; \">"
					+ entry.getValue() + "</td>" + " </tr>";
		}
		message = message + "</tbody></table></td></tr></table>"
				+ "<p></p><div style=\"font-family:Verdana;\">Regards,</div><p></p>"
				+ "<div style=\"font-family:Verdana;\">Test Yantra Software Automation Team</div>";

//		props.put("mail.smtp.user", SmtpUser);
//		props.put("mail.smtp.host", SmtpHost);
//		props.put("mail.smtp.port", "25");
//		props.put("mail.debug", "true");
//		props.put("mail.smtp.auth", "true");
//		props.put("mail.smtp.starttls.enable", "true");
//		props.put("mail.smtp.EnableSSL.enable", "true");
//
//		props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//		props.setProperty("mail.smtp.socketFactory.fallback", "false");
//		props.setProperty("mail.smtp.port", "465");
//		props.setProperty("mail.smtp.socketFactory.port", "465");
        
		
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new javax.mail.PasswordAuthentication(InternetAddress, PasswordAuthentication);
			}
		});

		try {
			MimeMessage msg = new MimeMessage(session);
			//msg.setFrom(new InternetAddress(InternetAddress));
			msg.setRecipients(Message.RecipientType.TO, RecipientType);
			msg.addRecipients(Message.RecipientType.TO, RecipientType2);
			msg.setSubject("Test " + "script execution" + " summary of " + profile + sdate);
			msg.setSentDate(new Date());
			Multipart multipart = new MimeMultipart();
			MimeBodyPart textPart = new MimeBodyPart();
			textPart.setContent(message, "text/html");
			multipart.addBodyPart(textPart);
			msg.setContent(multipart);
			Transport.send(msg);
			BaseTest.logger.info("Mail Sent Successfully");
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
	

	/**
	 * Description :Sets the status of the test execution in the mail report.
	 * 
	 * @author Aatish Slathia
	 * @param sName
	 * @param sResult
	 * @param sTestName
	 * @param sStatus
	 * 
	 */
	public static void setStatus(String sName, String sResult, ArrayList sTestName, ArrayList sStatus) {
		sName = sName.replace("test", "");
		sTestName.add(sName);
		sStatus.add(sResult);

		if (sResult.equals("Passed")) {
			iPassCount = iPassCount + 1;
		} else if (sResult.equals("Failed")) {
			iFailCount = iFailCount + 1;
		} else {
			iSkippedCount = iSkippedCount + 1;
		}
	}
}
