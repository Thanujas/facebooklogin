package com.facebook.web.automation.utility;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.facebook.web.automation.configurations.ConfigData;
import com.facebook.web.automation.configurations.ConfigFile;
public class ReportGenerator {
	public static ExtentReports report;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentTest test;
	WebDriver driver;

	private static ConfigFile _con = new ConfigFile();
	

	public static  ExtentReports initializeextendreports() {
		System.out.println("Report generated1");
		if (report == null) {
			System.out.println("Report generated2");
			
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());	
		//report = new ExtentReports ("C:\\Users\\Dell\\git\\IPG_Automation\\CS_Portal\\cs-ipg-portal-qa-automation\\Reports\\Test Report"+ timeStamp + ".html",false);
			htmlReporter = new	ExtentHtmlReporter("E:\\Facebook_Web_Automation\\Reports\\Facebook-Web-Testing"+timeStamp+".html");
			System.out.println("report path "+htmlReporter.getFilePath());
			htmlReporter.config().setDocumentTitle("Payable Web Portal");
			htmlReporter.config().setTheme(Theme.DARK);
			htmlReporter.config().setCSS("css-string");
			htmlReporter.config().setReportName("TEST AUTOMATION REPORT OF Facebook-"+timeStamp);
			htmlReporter.config().setTimeStampFormat(timeStamp);
			
			
			report = new ExtentReports();
		    report.attachReporter(htmlReporter);
		    report.setSystemInfo("Automation Engineer", " Thanuja Sanduni");
		    report.setSystemInfo("Build version", "v1.0.05Q");
		    report.setSystemInfo("Browser name", "FireFox Browser");
		    report.setSystemInfo("Browser version", "82.0 (64-bit)");
		}
		System.out.println("status"+report.getStats());
		System.out.println("HTML Report generated2 returend"+htmlReporter);
		System.out.println("Report generated2 returend"+report);
		return report;
		
	}
	
	
	 public static String capture(WebDriver driver,String screenShotName)
	    {
	        TakesScreenshot ts = ((TakesScreenshot)driver);
	        File source = ts.getScreenshotAs(OutputType.FILE);
	        String dest = System.getProperty("user.dir") +"//Reports//Screenshots//"+screenShotName+".png";
	        File destination = new File(dest);
	        try {
				FileUtils.copyFile(source, destination);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}        
	                     
	        return dest;
	    }	
	
	
	
	
	
}
